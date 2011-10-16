import java.text.DecimalFormat;

public class Calculate {

    private String specialStuff = "book, food, medcial stuff";

    public double getTaxRatio(Stuff stuff) {
        double taxRatio = 0;
        if (stuff.isImported) {
            taxRatio += 0.05;
        }

        if (!isSpecial(stuff.name)) {
            taxRatio += 0.10;
        }

        return format(taxRatio);
    }

    private boolean isSpecial(String name) {
        return specialStuff.contains(name);
    }

    public double getTax(Stuff stuff) {
        double tax = 0;
        if (getTaxRatio(stuff) != 0) {
            tax = stuff.num * getTaxRatio(stuff) * stuff.price;
        }
        return format(tax);
    }

    private double format(double value) {
        DecimalFormat df = new DecimalFormat("###,##0.00");
        return Double.parseDouble(df.format(value));
    }

    public double getPrice(Stuff stuff) {
        double price = stuff.num * stuff.price;
        if (getTaxRatio(stuff) != 0) {
            price += getTax(stuff);
        }
        return format(price);
    }
}
