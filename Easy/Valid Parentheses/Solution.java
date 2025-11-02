import java.util.Stack;

class Solution {
    public static boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            switch (s.charAt(i)) {
                case '(':
                    stack.push(s.charAt(i));
                    break;

                case '[':
                    stack.push(s.charAt(i));
                    break;

                case '{':
                    stack.push(s.charAt(i));
                    break;

                case ')':
                    if (stack.isEmpty() || stack.pop() != '(')
                        return false;
                    else
                        break;

                case ']':
                    if (stack.isEmpty() || stack.pop() != '[')
                        return false;
                    else
                        break;

                case '}':
                    if (stack.isEmpty() || stack.pop() != '{')
                        return false;
                    else
                        break;

                default:
                    break;
            }
        }

        return stack.isEmpty();
    }

    // public static boolean isValid(String s) {
    //     Stack<Character> stack = new Stack<>();
    //     Map<Character, Character> map = new HashMap<>();
    //     map.put(')','(');
    //     map.put(']','[');
    //     map.put('}','{');

    //     for (int i = 0; i < s.length(); i++) {
    //         char c = s.charAt(i);

    //         if (map.containsValue(c)) {
    //             stack.push(c);
    //         }
    //         else if (map.containsKey(c)) {
    //             if (stack.isEmpty() || map.get(c) != stack.pop()) {
    //                 return false;
    //             }
    //         }
    //     }

    //     return stack.isEmpty();
    // }

    public static void main(String[] args) {
        System.out.println(isValid("()"));
        System.out.println(isValid("()[]{}"));
        System.out.println(isValid("(]"));
        System.out.println(isValid("([])"));
        System.out.println(isValid("([)]"));
        System.out.println(isValid("["));
        System.out.println(isValid("]"));
        System.out.println(isValid("(("));
        System.out.println(isValid("){"));
    }
}