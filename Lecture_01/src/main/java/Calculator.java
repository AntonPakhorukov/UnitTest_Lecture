public class Calculator {
    public static void main(String[] args) {
        System.out.printf("Результат операции: %s\n", calculation(2,2,'+'));
        System.out.printf("Результат операции: %s\n", calculation(4,2,'-'));
        System.out.printf("Результат операции: %s\n", calculation(8,2,'/'));
        System.out.printf("Результат операции: %s\n", calculation(3,2,'*'));
        System.out.printf("Результат операции: %s\n", calculation(3,2,'_'));
    }
    public static int calculation(int firstOperand, int secondOperand, char operator) {
        int result;
        switch (operator){
            case '+':
                result = firstOperand + secondOperand;
                break;
            case '-':
                result = firstOperand - secondOperand;
                break;
            case '*':
                result = firstOperand * secondOperand;
                break;
            case '/':
                if (secondOperand != 0){
                    result = firstOperand / secondOperand;
                    break;
                } else {
                    throw new ArithmeticException("Делить на ноль нельзя");
                }
            default:
                throw new IllegalStateException("Не известный оператор");
        }
        return result;
    }
}
