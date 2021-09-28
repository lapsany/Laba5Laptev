package Commands;

import input.Messenger;
import product.Product;
import java.util.HashSet;
import editing.Converter;

public class Save extends Command {

    public Save(HashSet<Product> products, Messenger messenger) {
        super(products, messenger);
    }

    @Override
    public String execute(String ignore) {

        Converter.write(getProducts(), System.getenv("javaFilePathLab5"));

        return getEditor().BooleanOperation(true, getMessenger());
    }

    @Override
    public String toString() {
        return super.toString() + ": " + getMessenger().getMessage("infoSave");
    }
}