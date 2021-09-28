package Commands;

import input.Input;
import input.InputFromConsole;
import input.Messenger;
import product.Product;
import java.util.HashSet;

public class RemoveGreater extends Command {

    private Input input;

    public RemoveGreater(HashSet<Product> products, Messenger messenger) {
        super(products, messenger);

        this.input = new InputFromConsole(getMessenger());
    }

    @Override
    public String execute(String args) throws Exception {

        Product product = input.enter();

        return getEditor().BooleanOperation(
                getProducts().removeIf(o -> o.compareTo(product) > 0),
                getMessenger()
        );
    }

    @Override
    public String toString() {
        return super.toString() + ": " + getMessenger().getMessage("infoRemoveGreater");
    }
}
