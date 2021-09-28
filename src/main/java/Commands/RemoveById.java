package Commands;

import input.Messenger;
import product.Product;
import java.util.HashSet;

public class RemoveById extends Command {
    public RemoveById(HashSet<Product> products, Messenger messenger) {
        super(products, messenger);
    }

    @Override
    public String execute(String id) {
        return getEditor().BooleanOperation(
                getProducts().removeIf(d -> d.getId() == Long.parseLong(id)),
                getMessenger()
        );
    }
    @Override
    public String toString() {
        return super.toString() + ": " + getMessenger().getMessage("infoRemoveById");
    }
}
