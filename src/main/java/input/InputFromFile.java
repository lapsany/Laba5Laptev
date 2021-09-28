package input;
import product.Person;
import product.Product;

import java.io.BufferedReader;

public class InputFromFile extends Input {

    public InputFromFile(BufferedReader reader, Messenger messenger) {
        super(reader, messenger);
    }

    public class FileReaderPerson extends PersonReader {
        @Override
        public Person enter() throws Exception {
            return new Person(readPersonName(), readPassportID(), readColor(), readCountry());
        }
    }

    @Override
    public Product enter() throws Exception {
        FileReaderPerson reader = new FileReaderPerson();
        return new Product(readName(),
                readCoordinates(),
                readPrice(),
                readPartNumber(),
                readManufactureCost(),
                readUnitOfMeasure(),
                new Person(
                        reader.readPersonName(),
                        reader.readPassportID(),
                        reader.readColor(),
                        reader.readCountry()
                )
        );
    }

    public PersonReader getPersonReader() {return new FileReaderPerson();}



}
