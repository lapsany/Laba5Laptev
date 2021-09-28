package Commands.managers;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import Commands.Command;
import Commands.ExecuteScript;
import input.Messenger;
import org.reflections.Reflections;
import product.Product;
import java.lang.reflect.Constructor;
import editing.*;
import java.util.HashSet;
import java.util.Set;

@Getter @Setter
@AllArgsConstructor
public class CommandManager {

    private Editor editor;
    private Messenger messenger;
    private HashSet<Product> mDataSet;
    private Printer printer;

//    public CommandManager(Messenger messenger, HashSet<Product> mDataSet, Printer printer) {
//        this.messenger = messenger;
//        this.mDataSet = mDataSet;
//        this.printer = printer;
//    }

    public Messenger getMessenger() {
        return messenger;
    }

    public void executeUserCommand(String input) throws Exception {
        String[] array = input.split(" ");
        String commandName = array[0];
        String args = null;
        if (array.length > 1) {
            args = array[1];
        }
        String result = executeCommand(commandName, args);
        printResult(result);
    }

    public void printResult(String result) {printer.printResult(result);
    }

    private String executeCommand(String commandName, String args) throws Exception {

        Reflections reflections = new Reflections("Commands");
        Set<Class<? extends Command>> classes = reflections.getSubTypesOf(Command.class);

        final Command[] command = new Command[1];
        classes.forEach(c -> {
            if(c.getSimpleName().equalsIgnoreCase(commandName)) {
                try {
                    if(commandName.equalsIgnoreCase("executescript")) {
                        Constructor<ExecuteScript> constructor = ExecuteScript.class.getConstructor
                                (HashSet.class, Messenger.class);
                        ExecuteScript executeScript = constructor.newInstance(mDataSet, messenger);
                        executeScript.setCommandManager(this);
                        command[0] = executeScript;
                    } else {
                        Constructor<? extends Command> constructor = c.getConstructor(HashSet.class, Messenger.class);
                        command[0] = constructor.newInstance(mDataSet, messenger);
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });

        return command[0] != null ? command[0].execute(args) : messenger.getMessage("noSuchCommand");
    }

    public String executeCommand(String commandArgs) throws Exception {
        String[] array = commandArgs.split(" ");
        String commandName = array[0];
        String args = null;
        if (array.length > 1) {
            args = array[1];
        }
        return executeCommand(commandName, args);
    }
}