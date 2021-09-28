package Commands;

import input.Messenger;
import product.Product;
import java.util.HashSet;

public class Exit extends Command {

    public Exit(HashSet<Product> products, Messenger messenger) {
        super(products, messenger);
    }

    @Override
    public String execute(String ignore) {
        System.exit(0);
        return null;
    }

    @Override
    public String toString() {
        return super.toString() + ": " + getMessenger().getMessage("infoExit");
    }
}

