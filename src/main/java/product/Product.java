package product;

import java.util.List;
import java.util.Objects;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class Product implements Comparable<Product> {
    private Long id; //Поле не может быть null, Значение поля должно быть больше 0, Значение этого поля должно быть уникальным, Значение этого поля должно генерироваться автоматически
    private String name; //Поле не может быть null, Строка не может быть пустой
    private Coordinates coordinates; //Поле не может быть null
    private java.time.LocalDate creationDate; //Поле не может быть null, Значение этого поля должно генерироваться автоматически
    private Double price; //Поле может быть null, Значение поля должно быть больше 0
    private String partNumber; //Длина строки должна быть не меньше 22, Поле не может быть null
    private long manufactureCost;
    private UnitOfMeasure unitOfMeasure; //Поле не может быть null
    private Person owner; //Поле не может быть null

    private static long current_id = 0;

    public Product(String name, Coordinates coordinates, Double price, String partNumber,
                   long manufactureCost, UnitOfMeasure unitOfMeasure, Person owner) {
        this.name = name;
        this.coordinates = coordinates;
        this.price = price;
        this.partNumber = partNumber;
        this.manufactureCost = manufactureCost;
        this.unitOfMeasure = unitOfMeasure;
        this.owner = owner;
        this.id = ++current_id;
        this.creationDate = java.time.LocalDate.now();
    }



    @Override
    public String toString() {
        return "product.Product{\r\n" +
                "\tid=" + id +
                ",\n\tname='" + name + '\'' +
                ",\n\tcoordinates=" + coordinates +
                ",\n\tcreationDate=" + creationDate +
                ",\n\tprice=" + price +
                ",\n\tpartNumber='" + partNumber + '\'' +
                ",\n\tmanufactureCost=" + manufactureCost +
                ",\n\tunitOfMeasure=" + unitOfMeasure +
                ",\n\towner=" + owner +
                "\n}";
    }

    public String getName() {return name;}

    @Override
    public int compareTo(Product product) {
        return this.name.compareTo(product.getName());
    }

    public Double getPrice() {return price;}
    public long getManufactureCost() {return manufactureCost;}

    public String[] getStringFields() {
        return new String[] {
                String.valueOf(id),
                name,
                coordinates.toString(),
                creationDate.toString(),
                price.toString(),
                partNumber,
                String.valueOf(manufactureCost),
                String.valueOf(unitOfMeasure),
                String.valueOf(owner)};

    }

    public static Product setStringFields(List<String> fields) {
        Long id = Long.parseLong(fields.get(0));

        String name = fields.get(1);

        String[] arr = fields.get(2).split("; ");
        Integer x = Integer.parseInt(arr[0].substring(1));
        Float y = Float.parseFloat(arr[1].substring(0, arr[1].length() - 1));
        Coordinates coordinates = new Coordinates(x,y);

        java.time.LocalDate creationDate = java.time.LocalDate.parse(fields.get(3));

        Double price = Double.parseDouble(fields.get(4));

        String partNumber = fields.get(5);

        long manufactureCost = Long.parseLong(fields.get(6));

        UnitOfMeasure unitOfMeasure = null;
        if(!fields.get(7).equals("null")) {
            unitOfMeasure = UnitOfMeasure.valueOf(fields.get(6));
        }

        String[] personFields = fields.get(7).split(";");
        String personName = personFields[0].substring(1);
        String passportID = personFields[1].substring(0, personFields[1].length() - 1);
        Color hairColor = Color.valueOf(personFields[2].substring(0, personFields[1].length() - 1));
        Country nationality = Country.valueOf(personFields[3].substring(0,personFields[1].length() - 1));
        Person owner = new Person(personName, passportID, hairColor, nationality);

        Product product = new Product(name, coordinates, price, partNumber, manufactureCost,unitOfMeasure, owner);
        product.setId(id);
        product.setCreationDate(creationDate);
        return product;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, coordinates, creationDate, price, partNumber,
                manufactureCost, unitOfMeasure, owner);
    }


}
