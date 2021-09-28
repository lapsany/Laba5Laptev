package Commands;

import input.Messenger;
import lombok.AccessLevel;
import editing.Editor;
import editing.ImplEditor;
import product.Product;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import java.util.HashSet;

import lombok.Getter;
import lombok.Setter;
@Getter(AccessLevel.PROTECTED)
@Setter(AccessLevel.PROTECTED)

public abstract class Command {

    private HashSet<Product> products;
    private Editor editor;
    private Messenger messenger;
    private Validator validator;


    public Command(HashSet<Product> products, Messenger messenger) {
        this.products = products;
        this.messenger = messenger;
        this.editor = new ImplEditor();
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        validator = factory.getValidator();
    }

    public abstract String execute(String args) throws Exception;


    @Override
    public String toString() {
        return this.getClass().getSimpleName();
    }
}

