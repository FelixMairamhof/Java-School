public class Calculations {
    private Operator operator;
    private Number n1;
    private Number n2;

    public Calculations(Operator operator, Number n1, Number n2) {
        this.operator = operator;
        this.n1 = n1;
        this.n2 = n2;
    }

    public Calculations(double num1, double num2, Operator operator) {
        this(operator, new Number(num1), new Number(num2) );
    }

    public Number getResult (){
        return operator.performOperation(n1,n2);
    }

    @Override
    public String toString() {
        return n1 + " " + operator + " " + n2 + " = " + getResult() + "\n";
    }
    public static Calculations getCalculationFromString(String s) {
        String[] parts = s.split(" "); // Aufteilen des Strings an Leerzeichen

        if (parts.length != 3) {
            throw new IllegalArgumentException("Invalid input string format!");
        }

        double num1 = Double.parseDouble(parts[0]); // Erste Zahl
        char opSign = parts[1].charAt(0);           // Operator-Zeichen
        double num2 = Double.parseDouble(parts[2]); // Zweite Zahl

        Operator operator;
        switch (opSign) {
            case '+':
                operator = new Plus();
                break;
            case '-':
                operator = new Minus();
                break;
            case '*':
                operator = new Multiplication();
                break;
            case '/':
                operator = new Division();
                break;
            default:
                throw new IllegalArgumentException("Unsupported operator: " + opSign);
        }

        return new Calculations( operator, new Number(num1), new Number(num2));
    }
}
