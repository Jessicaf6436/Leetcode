class Solution {

    String[] below20 = {
        "", "One", "Two", "Three", "Four", "Five",
        "Six", "Seven", "Eight", "Nine", "Ten",
        "Eleven", "Twelve", "Thirteen", "Fourteen",
        "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen"
    };

    String[] tens = {
        "", "", "Twenty", "Thirty", "Forty",
        "Fifty", "Sixty", "Seventy", "Eighty", "Ninety"
    };

    public String numberToWords(int num) {

        if (num == 0) {
            return "Zero";
        }

        String result = "";

        if (num >= 1000000000) {
            result += convert(num / 1000000000) + " Billion ";
            num %= 1000000000;
        }

        if (num >= 1000000) {
            result += convert(num / 1000000) + " Million ";
            num %= 1000000;
        }

        if (num >= 1000) {
            result += convert(num / 1000) + " Thousand ";
            num %= 1000;
        }

        if (num > 0) {
            result += convert(num);
        }

        return result.trim();
    }

    private String convert(int num) {

        if (num < 20) {
            return below20[num];
        }

        if (num < 100) {
            return tens[num / 10] +
                   (num % 10 != 0 ? " " + below20[num % 10] : "");
        }

        return below20[num / 100] + " Hundred" +
               (num % 100 != 0 ? " " + convert(num % 100) : "");
    }
}