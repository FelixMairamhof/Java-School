public class Division extends Operator{
    @Override
    public Number performOperation(Number num1, Number num2) {
        return new Number(num1.getDoubleValue() / num2.getDoubleValue());
    }
    public Division (){
        super('/');
    }
}
