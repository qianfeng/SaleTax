import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class InputAnalyzerTest {
    private InputAnalyzer inputAnalyzer;
    private String input;

    @Before
    public void setUp() {
        input = "1 imported book at 12.5";
        inputAnalyzer = new InputAnalyzer(input);
    }

    @After
    public void tearDown() {
        inputAnalyzer = null;
    }

    @Test
    public void should_return_the_num_of_stuff() {
        int number = inputAnalyzer.getNumber();
        Assert.assertTrue(number == 1);
    }

    @Test
    public void should_return_the_name_of_stuff() {
        String name = inputAnalyzer.getName();
        Assert.assertEquals("book", name);
    }

    @Test
    public void should_return_the_price_of_stuff() {
        double price = inputAnalyzer.getPrice();
        Assert.assertTrue(12.5 == price);
    }

    @Test
    public void should_return_true_when_the_stuff_is_imported() throws Exception {
        Assert.assertTrue(inputAnalyzer.isImported());
    }
}
