package adventofcode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class E205IsomorphicStrings {
    public boolean isIsomorphic(String s, String t) {
        Map<Character, Character> charToCharMap = new HashMap();
        Set<Character> seen = new HashSet();

        for(int i=0; i<s.length(); i++) {

            Character oldChar = charToCharMap.put(s.charAt(i), t.charAt(i));
            boolean isNotPresent = seen.add(t.charAt(i));

            if (oldChar == null) {
                if (!isNotPresent) return false;
            } else if (oldChar != t.charAt(i)) return false;
        }

        return true;
    }

    public static void main(String[] strings) {
        String s = "egg";
        String t = "add";
        System.out.println(new E205IsomorphicStrings().isIsomorphic(s, t) == true);
    }
}