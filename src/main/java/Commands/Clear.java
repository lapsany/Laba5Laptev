package Commands;

import input.Messenger;
import product.Product;
import java.util.HashSet;

public class Clear extends Command{
    public Clear(HashSet<Product> products, Messenger messenger) {
        super(products, messenger);
    }

    @Override
    public String execute(String ignore) {
        getProducts().clear();
        return getEditor().BooleanOperation(true, getMessenger());
    }

    @Override
    public String toString() {
        return super.toString() + ": " + getMessenger().getMessage("infoClear");
    }
}
