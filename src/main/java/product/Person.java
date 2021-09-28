package product;

public class Person {
    private String name; //Поле не может быть null, Строка не может быть пустой
    private String passportID; //Строка не может быть пустой, Поле не может быть null
    private Color hairColor; //Поле не может быть null
    private Country nationality; //Поле может быть null

    public Person(String name, String passportID, Color hairColor, Country nationality) {
        this.name = name;
        this.passportID = passportID;
        this.hairColor = hairColor;
        this.nationality = nationality;
    }

    public Person() {
    }

    @Override
    public String toString() {
        return "product.Person{\r\n" +
                "\t\tname='" + name + '\'' +
                ",\n\t\tpassportID='" + passportID + '\'' +
                ",\n\t\thairColor=" + hairColor +
                ",\n\t\tnationality=" + nationality +
                "\n\t}";
    }

    public void setColor(Color hairColor) {
        this.hairColor = hairColor;
    }

    public void setCountry(Country nationality) {
        this.nationality = nationality;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPassportID(String passportID) {
        this.passportID = passportID;
    }

}
