package at.htlklu.drawshapes;

public class Square extends Rectangle{

    public Square(double a){
        super(a,a);
    }

    public Square(){
        this(DEFAULT_SIZE);
    }

   // überschreiben der Setter, damit width und height immer gleich sind.
    @Override
    public void setWidth(double width) {
        super.setWidth(width);
        super.setHeight(width);
    }

    @Override
    public void setHeight(double height) {
        super.setHeight(height);
        super.setWidth(height);
    }

}
