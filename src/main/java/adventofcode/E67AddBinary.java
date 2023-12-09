package adventofcode;

public class E67AddBinary {
    public String addBinary(String a, String b) {
        String res = "";

        int aI = a.length()-1;
        int bI = b.length()-1;

        int carry = 0;

        while(aI >=0 || bI >= 0 || carry != 0) {
            int sum = carry;

            if (aI >=0) sum += (a.charAt(aI--) - '0');
            if (bI >=0) sum += (b.charAt(bI--) - '0');

            res = sum % 2 + res;
            carry = sum / 2;
        }

        return res;

    }

    public static void main(String[] strings) {
        System.out.println(new E67AddBinary().addBinary("11", "1").equals("100"));
    }
}
