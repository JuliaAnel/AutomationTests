import org.apache.commons.lang3.StringUtils;
import org.testng.Assert;
import org.testng.annotations.Test;

public class MainTest {
    @Test
    public void testAbbr() {
        String result = Main.abbr("Julia", 4);
        Assert.assertEquals(result,  "J...");
    }
    @Test
    public void testAbbr1() {
        String result = Main.abbr("Sergey", 4);
        Assert.assertEquals(result,  "S...");
    }
    @Test
    public void testAbbr2() {
        String result = Main.abbr("Anna", 4);
        Assert.assertEquals(result,  "A...");
    }
    @Test
    public void testSub() {
        Assert.assertEquals(StringUtils.substring("Hello", 3), "lo");
    }
}
