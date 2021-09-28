package Commands;

import input.Messenger;
import org.reflections.Reflections;
import product.Product;
import java.lang.reflect.Constructor;
import java.util.HashSet;
import java.util.Set;

public class Help extends Command {

    public Help(HashSet<Product> products, Messenger messenger) {
        super(products, messenger);
    }

    @Override
    public String execute(String ignore) {

        Reflections reflections = new Reflections("Commands");
        Set<Class<? extends Command>> classes = reflections.getSubTypesOf(Command.class);

        StringBuilder result = new StringBuilder("");

        classes.forEach(c -> {

            try {
                Constructor<? extends Command> constructor = c.getConstructor(HashSet.class, Messenger.class);
                Command command = constructor.newInstance(getProducts(), getMessenger());
                result.append(command.toString()).append("\n");
            } catch (Exception e) {
                e.printStackTrace();
            }
        });

        return result.toString();
    }

    @Override
    public String toString() {
        return super.toString() + ": " + getMessenger().getMessage("infoHelp");
    }
}
