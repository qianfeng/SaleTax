import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class CalculateTest {
    private Calculate calculate;

    @Before
    public void setUp() {
        calculate = new Calculate();
    }

    @After
    public void tearDown() {
        calculate = null;
    }

    @Test
    public void should_return_zero_when_it_is_not_imported_and_not_a_book_or_medicial_or_music() throws Exception {
        Stuff stuff = new Stuff(2, false, "book", 12.9);
        Assert.assertTrue(0 == calculate.getTaxRatio(stuff));
    }

    @Test
    public void should_return_five_percents_when_it_is_imported_but_not_a_book_or_medicial_or_music() throws Exception {
        Stuff stuff = new Stuff(3, true, "book", 12.0);
        Assert.assertTrue(0.05 == calculate.getTaxRatio(stuff));
    }

    @Test
    public void should_return_ten_percents_when_it_is_not_imported_but_is_a_cd() throws Exception {
        Stuff stuff = new Stuff(3, false, "cd", 12.0);
        Assert.assertTrue(0.1 == calculate.getTaxRatio(stuff));
    }

    @Test
    public void should_return_fifteen_percents_when_it_is_imported_and_is_a_cd() throws Exception {
        Stuff stuff = new Stuff(3, true, "cd", 12.0);
        Assert.assertTrue(0.15 == calculate.getTaxRatio(stuff));
    }

    @Test
    public void should_return_0_when_taxRatio_is_zero() throws Exception {
        Stuff stuff = new Stuff(3, false, "book", 12.0);
        Assert.assertTrue(0 == calculate.getTax(stuff));
    }

    @Test
    public void should_return_tax_value_when_taxRatio_is_not_zero() throws Exception {
        Stuff stuff = new Stuff(3, true, "cd", 12.0);
        Assert.assertTrue(5.4 == calculate.getTax(stuff));
    }

    @Test
    public void should_return_only_price_when_taxRatio_is_zero() throws Exception {
        Stuff stuff = new Stuff(3, false, "book", 12.0);
        Assert.assertTrue(36 == calculate.getPrice(stuff));
    }

    @Test
    public void should_return_tax_value_plus_price_when_taxRatio_is_not_zero() throws Exception {
        Stuff stuff = new Stuff(3, true, "cd", 12.0);
        Assert.assertTrue(41.4 == calculate.getPrice(stuff));
    }
}
