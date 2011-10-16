import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class main {
    public static void main(String[] args) throws IOException {
        String userInput = getCustomerInput();
        InputAnalyzer analyzer = new InputAnalyzer(userInput);
        Stuff stuff = new Stuff(analyzer.getNumber(),analyzer.isImported(),analyzer.getName(),analyzer.getPrice());
        Calculate calculate = new Calculate();
        double totalTax = calculate.getTax(stuff);
        double totalPrice = calculate.getPrice(stuff);
        System.out.println("tax:    " + totalTax);
        System.out.println("price:  " + totalPrice);
    }

    public static String getCustomerInput() throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        return input.readLine();
    }

}
