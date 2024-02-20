import java.util.Scanner;
import java.util.Stack;

public class ExpressionEvaluator {

    public static class InfixEvaluator {
        private static final String INFIX_EXPRESSION = "(a+b)*(c+d)";

        public static int evaluateInfix(String str, int a, int b, int c, int d) {
            Stack<Integer> valueStack = new Stack<>();
            Stack<Character> operatorStack = new Stack<>();

            for (char ch : str.toCharArray()) {
                if (Character.isDigit(ch)) {
                    valueStack.push(Character.getNumericValue(ch));
                } else if (ch == '+' || ch == '-' || ch == '*' || ch == '/') {
                    while (!operatorStack.isEmpty() && hasPrecedence(ch, operatorStack.peek())) {
                        applyOperator(valueStack, operatorStack.pop());
                    }
                    operatorStack.push(ch);
                } else if (ch == '(') {
                    operatorStack.push(ch);
                } else if (ch == ')') {
                    while (!operatorStack.isEmpty() && operatorStack.peek() != '(') {
                        applyOperator(valueStack, operatorStack.pop());
                    }
                    operatorStack.pop(); // Pop the '('
                }
            }

            while (!operatorStack.isEmpty()) {
                applyOperator(valueStack, operatorStack.pop());
            }

            return valueStack.pop();
        }

        private static boolean hasPrecedence(char op1, char op2) {
            return (op2 != '(' && op2 != ')' && getPrecedence(op1) <= getPrecedence(op2));
        }

        private static int getPrecedence(char operator) {
            switch (operator) {
                case '+':
                case '-':
                    return 1;
                case '*':
                case '/':
                    return 2;
                default:
                    return -1;
            }
        }

        private static void applyOperator(Stack<Integer> values, char operator) {
            if (values.size() < 2) {
                throw new IllegalArgumentException("Invalid infix expression");
            }

            int b = values.pop();
            int a = values.pop();

            switch (operator) {
                case '+':
                    values.push(a + b);
                    break;
                case '-':
                    values.push(a - b);
                    break;
                case '*':
                    values.push(a * b);
                    break;
                case '/':
                    values.push(a / b);
                    break;
            }
        }

    }

    public static class PostFixEvaluator {
        private static final String POSTFIX_EXPRESSION = "ac-b^d+";

        public static int evaluatePostfix(String str, int a, int b, int c, int d) {
            Stack<Integer> stack = new Stack<>();

            for (char ch : str.toCharArray()) {
                if (Character.isDigit(ch)) {
                    stack.push(Character.getNumericValue(ch));
                } else {
                    int operand2 = stack.pop();
                    int operand1 = stack.pop();

                    switch (ch) {
                        case '+':
                            stack.push(operand1 + operand2);
                            break;
                        case '-':
                            stack.push(operand1 - operand2);
                            break;
                        case '*':
                            stack.push(operand1 * operand2);
                            break;
                        case '/':
                            stack.push(operand1 / operand2);
                            break;
                        case '^':
                            stack.push((int) Math.pow(operand1, operand2));
                            break;
                    }
                }
            }

            return stack.pop();
        }
    }

    public static class ExpressionDriver {
        public static void main(String[] args) {
            Scanner scanner = new Scanner(System.in);

            while (true) {
                System.out.println("Enter values for identifiers (a, b, c, d):");
                int a = scanner.nextInt();
                int b = scanner.nextInt();
                int c = scanner.nextInt();
                int d = scanner.nextInt();

                int infixResult = InfixEvaluator.evaluateInfix(InfixEvaluator.INFIX_EXPRESSION, a, b, c, d);
                int postfixResult = PostFixEvaluator.evaluatePostfix(PostFixEvaluator.POSTFIX_EXPRESSION, a, b, c, d);

                System.out.println("Value of infix string " + InfixEvaluator.INFIX_EXPRESSION +
                        " with a = " + a + ", b = " + b + ", c = " + c + ", d = " + d + " is " + infixResult);

                System.out.println("Value of postfix string " + PostFixEvaluator.POSTFIX_EXPRESSION +
                        " with a = " + a + ", b = " + b + ", c = " + c + ", d = " + d + " is " + postfixResult);

                System.out.println("Do you want to compute again? (yes/no)");
                String response = scanner.next().toLowerCase();

                if (!response.equals("yes")) {
                    System.out.println("Program ended.");
                    break;
                }
            }

            scanner.close();
        }
    }
}
