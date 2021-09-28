package input;

import product.Person;
import product.Coordinates;
import product.Product;
import product.UnitOfMeasure;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class InputFromConsole extends Input {

    public InputFromConsole(Messenger messenger) {
        super(new BufferedReader(new InputStreamReader(System.in)), messenger);
    }

    public Product enter() throws Exception {

        String name;
        Coordinates coordinates;
        Double price;
        String partNumber;
        long manufactureCost;
        UnitOfMeasure unitOfMeasure;

        while (true) {
            System.out.println("Введите имя продукта:");
            try {
                name = readName();
                break;
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }

        while (true) {
            System.out.println("Введите координаты через пробел:");
            try {
                coordinates = readCoordinates();
                break;
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }

        while (true) {
            System.out.println("Введите цену:");
            try {
                price = readPrice();
                break;
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }

        while (true) {
            System.out.println("Введите номер части:");
            try {
                partNumber = readPartNumber();
                break;
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }

        while (true) {
            System.out.println("Введите стоимость производства:");
            try {
                manufactureCost = readManufactureCost();
                break;
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }

        while (true) {
            System.out.println("Введите меру измерения (MILLILITERS, GRAMS, MILLIGRAMS):");
            try {
                unitOfMeasure = readUnitOfMeasure();
                break;
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }

        PersonReader reader = new ConsoleReaderPerson();
        Person owner = reader.enter();

        return new Product(name, coordinates, price, partNumber, manufactureCost, unitOfMeasure, owner);
    }

    @Override
    public PersonReader getPersonReader() {
        return new ConsoleReaderPerson();
    }

    public class ConsoleReaderPerson extends PersonReader {

        @Override
        public Person enter() {

            Person owner = new Person();

            while (true) {
                System.out.println("Введите имя:");
                try {
                    owner.setName(readPersonName());
                    break;
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                }
            }

            while (true) {
                System.out.println("Введите номер паспорта:");
                try {
                    owner.setPassportID(readPassportID());
                    break;
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                }
            }

            while (true) {
                System.out.println("Введите цвет волос: GREEN,\n" +
                        "        RED,\n" +
                        "        BLUE,\n" +
                        "        ORANGE,\n" +
                        "        WHITE;");
                try {
                    owner.setColor(readColor());
                    break;
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                }
            }

            while (true) {
                System.out.println("Введите национальность:");
                try {
                    owner.setCountry(readCountry());
                    break;
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                }
            }

            return owner;
        }
    }
}
