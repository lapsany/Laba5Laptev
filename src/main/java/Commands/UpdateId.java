package Commands;

import input.Input;
import input.InputFromConsole;
import input.Messenger;
import product.Product;
import lombok.Getter;
import lombok.Setter;
import javax.validation.ConstraintViolation;
import java.util.HashSet;
import java.util.Set;

@Getter @Setter
public class UpdateId extends Command {

    private Input userInput;

    public UpdateId(HashSet<Product> products, Messenger messenger) {
        super(products, messenger);

        userInput = new InputFromConsole(messenger);
    }

    @Override
    public String execute(String id) {

        for (Product o : getProducts()) {
            if (o.getId() == Long.parseLong(id)) {
                try {
                    Product product = userInput.enter();
                    Set<ConstraintViolation<Product>> violations = getValidator().validate(product);

                    if (violations.isEmpty()) {
                        o = product;
                        return getEditor().BooleanOperation(true, getMessenger());
                    }
                    violations.forEach(v -> System.err.println(v.getMessage()));

                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }

        return getEditor().BooleanOperation(false, getMessenger());
    }

    @Override
    public String toString() {
        return super.toString() + ": " + getMessenger().getMessage("infoUpdateId");
    }
}