public class InputAnalyzer {
    private String input;

    public InputAnalyzer(String userInput) {
        this.input = userInput;
    }

    public int getNumber() {
        return Integer.parseInt(this.input.split(" ")[0]);
    }

    public String getName() {
        int startIndex = this.input.indexOf(" ") + 1;
        int endIndex = this.input.indexOf("at");
        String name = this.input.substring(startIndex, endIndex).trim();
        return name.startsWith("imported ") ? name.replaceFirst("imported", "").trim() : name;
    }

    public double getPrice() {
        int startIndex = this.input.indexOf("at") + 3;
        return Double.parseDouble(this.input.substring(startIndex));
    }

    public boolean isImported() {
        return this.input.contains("imported");
    }
}
