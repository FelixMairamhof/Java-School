package shapes_files_paint;

public class Square extends Rectangle{

    public Square (int width){
        super(width, width);
    }
    @Override
    public String toString() {
        return super.toString() + String.format(", size [%d/%d]",
                this.getHeight(), this.getWidth());
    }
}
