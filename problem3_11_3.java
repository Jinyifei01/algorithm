package leetcode;

import java.util.*;

public class problem3_11_3 {

    //有效的括号
    public boolean isValid(String s) {
        int n = s.length();
        if (n % 2 == 1) {
            return false;
        }

        Map<Character, Character> pairs = new HashMap<Character, Character>() {{
            put(')', '(');
            put(']', '[');
            put('}', '{');
        }};

        Deque<Character> stack = new LinkedList<Character>();
        for (int i = 0; i < n; i++) {
            char ch = s.charAt(i);
            if (pairs.containsKey(ch)) {
                if (stack.isEmpty() || stack.peek() != pairs.get(ch)) {
                    return false;
                }
                stack.pop();
            } else {
                stack.push(ch);
            }
        }
        return stack.isEmpty();
    }
}

//
//class Solution {
//    public boolean isValid(String s) {
//        Stack<Character> stack = new Stack<Character>();
//        char[] chars = s.toCharArray();
//        for (char c : chars) {
//            if (c == '(') {
//                stack.push(')');
//            } else if (c == '[') {
//                stack.push(']');
//            } else if (c == '{') {
//                stack.push('}');
//            } else if (stack.isEmpty() || c != stack.pop()) {
//                return false;
//            }
//        }
//        if (stack.isEmpty()) {
//            return true;
//        }
//        return false;
//    }
//}
