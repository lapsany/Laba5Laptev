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
public class Add extends Command {

    private Input consoleUserInput;

    public Add(HashSet<Product> products, Messenger messenger) {
        super(products, messenger);
        consoleUserInput = new InputFromConsole(messenger);
    }

    @Override
    public String execute(String ignore) throws Exception {

        Product product = consoleUserInput.enter();

        Set<ConstraintViolation<Product>> violations = getValidator().validate(product);

        if(violations.isEmpty()) {
            getProducts().add(product);
            return getEditor().BooleanOperation(true, getMessenger());
        }

        violations.forEach(v -> System.err.println(v.getMessage()));
        return getEditor().BooleanOperation(false, getMessenger());
    }

    @Override
    public String toString() {
        return super.toString() + ": " + getMessenger().getMessage("infoAdd");
    }
}