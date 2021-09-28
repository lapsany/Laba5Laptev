package input;
import product.*;

import java.io.BufferedReader;
import java.util.Scanner;


public abstract class Input {
    private BufferedReader reader;
    private Messenger messenger;

    public Input(BufferedReader reader, Messenger messenger) {
        this.messenger = messenger;
        this.reader = reader;
    }

    public Input(BufferedReader reader) {
    }

    public abstract Product enter() throws Exception;

    public String readName() throws Exception {
        try {
            String name = reader.readLine();
            if (name.equals("")) throw new IllegalArgumentException();
            return name;
        } catch (Exception e) {
            throw new Exception("Некорректный ввод.");
        }
    }

    public Coordinates readCoordinates() throws Exception {
        try {
            String[] arr = (reader.readLine()).split(" ");
            int x = Integer.parseInt(arr[0]);
            float y = Float.parseFloat(arr[1]);
            if (y <= -823) throw new IllegalArgumentException("Значение поля должно быть больше -823");
            return new Coordinates(x, y);
        } catch (IllegalArgumentException e) {
            throw new Exception(e.getMessage());
        } catch (Exception e) {
            throw new Exception("Некорректный ввод.");
        }
    }

    public double readPrice() throws Exception {
        try {
            double price = Double.parseDouble(reader.readLine());
            if (price <= 0) throw new IllegalArgumentException("Значение поля должно быть больше нуля!");
            return price;
        } catch (IllegalArgumentException e) {
            throw new Exception(e.getMessage());
        } catch (Exception e) {
            throw new Exception("Некорректный ввод.");
        } }

    public String readPartNumber() throws Exception {
        try {
            String partNumber = reader.readLine();
            if (partNumber.length() < 22) throw new IllegalArgumentException("Длина строки должна быть не меньше 22");
            return partNumber;
        } catch (IllegalArgumentException e) {
            throw new Exception(e.getMessage());
        } catch (Exception e) {
            throw new Exception("Некорректный ввод.");
        }
    }

    public long readManufactureCost() throws Exception {
        try {
            long manufactureCost = Long.parseLong(reader.readLine());
            return manufactureCost;
        } catch (Exception e) {
            throw new Exception("Некорректный ввод.");
        }
    }

    public UnitOfMeasure readUnitOfMeasure() throws Exception {
        try {
            String measure = reader.readLine();
            UnitOfMeasure unitOfMeasure;
            if(!measure.equals("")) {
                unitOfMeasure = UnitOfMeasure.valueOf(measure);
            } else {
                throw new Exception("Поле не может быть null");
            }
            return unitOfMeasure;
        } catch (Exception e) {
            throw new Exception("Некорректный ввод.");
        }
    }



    public abstract class PersonReader {

        public abstract Person enter() throws Exception;

        public String readPersonName() throws Exception {
            try {
                String name = reader.readLine();
                if(name.equals("")) throw new IllegalArgumentException("Строка не может быть пустой.");
                return name;
            } catch (IllegalArgumentException e) {
                throw new Exception(e.getMessage());
            } catch (Exception e) {
                throw new Exception("Некорректный ввод");
            }
        }

        public String readPassportID() throws Exception {
            try {
                String ID = reader.readLine();
                if(ID.equals("")) throw new IllegalArgumentException("Строка не может быть пустой.");
                return ID;
            } catch (IllegalArgumentException e) {
                throw new Exception(e.getMessage());
            } catch (Exception e) {
                throw new Exception("Некорректный ввод");
            }
        }

        public Color readColor() throws Exception {
            try {
                String hairColor = reader.readLine();
                Color color;
                if(!hairColor.equals("")) {
                    color = Color.valueOf(hairColor);
                } else {
                    throw new Exception("Поле не может быть null");
                }
                return color;
            } catch (Exception e) {
                throw new Exception("Некорректный ввод.");
            }
        }

        public Country readCountry() throws Exception {
            try {
                String nationality = reader.readLine();
                Country country;
                if (!nationality.equals("")) {
                    country = Country.valueOf(nationality);
                } else {
                    throw new Exception("Поле не может быть null");
                }
                return country;
            } catch (Exception e) {
                throw new Exception("Некорректный ввод.");
            }
        }
    }

    public abstract PersonReader getPersonReader();
}
