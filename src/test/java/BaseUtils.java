import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class BaseUtils {

    //    private static final String CHROME_OPTIONS = "CHROME_OPTIONS";
//    private static final String CHROME_OPTIONS_PROP = "default." + CHROME_OPTIONS.toLowerCase();
//
//    private static Properties properties;
//
//    private static void initProperties() {
//        if (properties == null) {
//            properties = new Properties();
//            if (isServerRun()) {
//                properties.setProperty(CHROME_OPTIONS_PROP, System.getenv(CHROME_OPTIONS));
//            } else {
//                try {
//                    InputStream inputStream = BaseUtils.class.getClassLoader().getResourceAsStream("local.properties");
//                    if (inputStream == null) {
//                        System.out.println("ERROR: The \u0018[31mlocal.properties\u0018[0m file not found in src/test/resources.directory.");
//                        System.out.println("You need to create it from local.properties.TEMPLATE file.");
//                        System.exit(1);
//                    }
//                    properties.load(inputStream);
//                } catch (IOException ignore) {}
//            }
//        }
//    }
//
//    private static final ChromeOptions chromeOptions;
//    static {
//        initProperties();
//
//        chromeOptions = new ChromeOptions();
//        String options = properties.getProperty(CHROME_OPTIONS_PROP);
//        if (options != null) {
//            for (String argument : options.split(";")) {
//                chromeOptions.addArguments(argument);
//            }
//        }
//
//        WebDriverManager.chromedriver().setup();
//    }
//
//    static boolean isServerRun() {
//        return System.getenv("CI_RUN") != null;
//    }
//
//    static WebDriver createDriver() {
//        WebDriver driver = new ChromeDriver(chromeOptions);
//        driver.manage().timeouts().implicitlyWait(18, TimeUnit.SECONDS);
//
//        return driver;
//    }
//}
    private static final String HUB_URL = "https://localhost:4444/wd/hub";
    private static boolean remoteWebDriver = false;

    static {
        try {
            HttpURLConnection con = (HttpURLConnection) new URL(HUB_URL + "/status").openConnection();
            try {
                con.setRequestMethod("GET");
                remoteWebDriver = con.getResponseCode() == HttpURLConnection.HTTP_OK;
            } finally {
                con.disconnect();
            }
        } catch (IOException ignore) {
        }
        if (!remoteWebDriver) {
            WebDriverManager.chromedriver().setup();
            // WebDriverManager.firefoxdriver().setup();
        }
    }
}
