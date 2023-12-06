package adventofcode;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class E20ValidParenthesis {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack();

        Map<Character, Character> map = new HashMap();
        map.put('}', '{');
        map.put(']', '[');
        map.put(')', '(');

        for(char c : s.toCharArray()) {
            if (!map.containsKey(c)) stack.push(c);
            else if (stack.isEmpty() || map.get(c) != stack.peek()) return false;
            else stack.pop();
        }

        return stack.isEmpty();
    }

    public static void main(String[] strings) {
        System.out.println(new E20ValidParenthesis().isValid("()[]{}") == true);
    }
}
