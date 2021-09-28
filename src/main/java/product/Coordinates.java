package product;

public class Coordinates {
    private int x; //Поле не может быть null
    private float y; //Значение поля должно быть больше -823

    public Coordinates(Integer x, Float y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public String toString() {
        return "[" + x + "; " + y + "]";
    }





}
