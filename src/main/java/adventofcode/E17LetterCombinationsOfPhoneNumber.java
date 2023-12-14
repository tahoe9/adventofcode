package adventofcode;

import java.util.*;

public class E17LetterCombinationsOfPhoneNumber {
    public List<String> letterCombinations(String digits) {
        Map<Character, String> letterMap = new HashMap();

        letterMap.put('2', "abc");
        letterMap.put('3', "def");
        letterMap.put('4', "ghi");
        letterMap.put('5', "jkl");
        letterMap.put('6', "mno");
        letterMap.put('7', "pqrs");
        letterMap.put('8', "tuv");
        letterMap.put('9', "wxyz");

        List<String> strings = new ArrayList();
        for(char c : digits.toCharArray()) strings.add(letterMap.get(c));

        List<String> res = new ArrayList();
        if (strings.isEmpty()) return res;

        generateCombinations(strings, 0, "", res);

        return res;

    }

    public void generateCombinations(List<String> strings, int rowIndex, String combination, List<String> res) {
        if (rowIndex == strings.size()) {
            res.add(combination);
            return;
        }

        for(char c : strings.get(rowIndex).toCharArray())
            generateCombinations(strings, rowIndex+1, combination + c, res);

    }

    public static void main(String[] strings) {
        List<String> output = Arrays.asList("ad","ae","af","bd","be","bf","cd","ce","cf");
        System.out.println(new E17LetterCombinationsOfPhoneNumber().letterCombinations("23").equals(output));
    }
}
