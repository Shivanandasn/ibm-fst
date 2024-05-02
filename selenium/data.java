import org.testng.annotations.DataProvider;

public class data {
    @DataProvider(name = "Authentication")
    public static Object[][] credentials() {
        return new Object[][] {
                { "admin", "1", "asn@gmail.com", "9071520155", "hi" },
                { "admin", "2", "bsn@gmail.com", "9071520156", "hello" },
                { "admin", "3", "csn@gmail.com", "9071520157", "hi hello" }
        };
    }

}
