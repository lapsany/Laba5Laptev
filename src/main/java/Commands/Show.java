package Commands;

import input.Messenger;
import product.Product;

import java.util.HashSet;

public class Show extends Command{
    public Show(HashSet<Product> products, Messenger messenger) {
        super(products, messenger);
    }

    @Override
    public String execute(String ignore) {
        return getEditor().editCollection(getProducts());
    }

    @Override
    public String toString() {
        return super.toString() + ": " + getMessenger().getMessage("infoShow");
    }
}
