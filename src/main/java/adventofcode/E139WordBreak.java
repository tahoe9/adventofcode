package adventofcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class E139WordBreak {

    public boolean wordBreak(String s, List<String> wordDict) {
        return wordBreak(s, 0, wordDict, new HashMap());
    }

    public boolean wordBreak(String s, int end, List<String> wordDict, Map<String, Boolean> map) {
        if (map.containsKey(s)) return map.get(s);

        if (s.trim().length() == 0) return true;

        if (end >= s.length()) return false;

        String prefix = s.substring(0, end+1);
        if (wordDict.contains(prefix)) {
            String suffix = s.substring(end+1);
            boolean isFound = wordBreak(suffix, 0, wordDict, map) || wordBreak(s, end+1, wordDict, map);
            map.put(suffix, isFound);
            return isFound;
        }

        return wordBreak(s, end+1, wordDict, map);
    }

    public static void main(String[] strings) {
        System.out.println(new E139WordBreak().wordBreak("leetcode", Arrays.asList("leet","code")) == true);
    }
}
