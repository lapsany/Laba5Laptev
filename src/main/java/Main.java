import editing.Converter;
import input.ImplMessenger;
import input.Messenger;
import Commands.managers.*;
import editing.ImplEditor;
import editing.ImplPrinter;

import java.util.ResourceBundle;

public class Main {
    public static void main(String[] args) {

        Messenger messenger = new ImplMessenger(ResourceBundle.getBundle("text", Messenger.initLang()));

        Terminal terminal = new Terminal(
                new CommandManager(
                        new ImplEditor(),
                        messenger,
                        Converter.read(System.getenv("javaFilePathLab5")),
                        new ImplPrinter()
                ),
                messenger,
                new ImplPrinter(),
                new ImplEditor()
        );
        terminal.start();
    }
}