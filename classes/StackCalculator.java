public class StackCalculator extends Calculator {
    public String infixToPostfix(String expr) {
        String result = "";
        StackAsArray stack = new StackAsArray();
        ExpTokenizer tokens = new ExpTokenizer(expr);
        for (int i = 0; i < tokens.countTokens(); i++) {
            Object cur_token = tokens.nextElement();
            char cur_token_char = (char) cur_token;
            //if it's an operand(number), add it to the string
            if (Character.isDigit(cur_token_char))
                result = result.concat(String.valueOf(cur_token_char));
                // if token is an opening bracket, push token to the stack
            else if (cur_token_char == '(') {
                stack.push(cur_token_char);
            }
            // if token is a closing bracket
            else if (cur_token_char == ')') {
                while (true) {
                    char check_char = (char) stack.pop();
                    if (check_char == '(')
                        break;
                    result = result.concat(String.valueOf(check_char));
                }
            }
            //  if token is an operator
            else {
                // pop elements from the stack until (not including) operator with lower precedence or non-operator (e.g. opening bracket)
                while (!stack.isEmpty()) {
                    char check_char = (char) stack.pop();
                    if ((check_char == '(')) // need to add more conditions!!
                        break;
                    result = result.concat(String.valueOf(check_char));
                }
            }
        }
        return result;
    }

    @Override
    public double evaluate(String expr) {
        StackAsArray stack = new StackAsArray();
        for (int i = 0; i < expr.length(); i++) {
            char cur_elem = expr.charAt(i);
            // if the token is a number
            if (Character.isDigit(cur_elem))
                stack.push(cur_elem);
            // if the token is an operator
            else {
                int elem1 = (int) stack.pop();
                int elem2 = (int) stack.pop();
                stack.push(cur_elem.operate(val1, val2)); //need to update- how to do it?
            }
        }
        return (double) stack.pop();
    }
}



