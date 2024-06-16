public class Number {
    public double number;

    public Number (double number){
        this.number = number;
    }
    public double getDoubleValue (){
        return this.number;
    }
    @Override
    public String toString() {
        if (Math.floor(this.number) == this.number) {
            // Wert ist eine Ganzzahl
            return String.format("%.0f", this.number);
        } else {
            // Wert ist eine Kommazahl
            return String.format("%.2f", this.number);
        }
    }
}
