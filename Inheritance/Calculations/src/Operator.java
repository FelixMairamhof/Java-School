public abstract class Operator {
    private char sign;

    @Override
    public String toString() {
        return " " + sign + " ";
    }
    public abstract Number performOperation(Number num1, Number num2);

    public Operator(char sign) {
        this.sign = sign;
    }
}
