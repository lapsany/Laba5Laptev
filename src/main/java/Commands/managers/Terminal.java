package Commands.managers;

import Commands.Exit;
import input.Messenger;
import editing.Editor;
import editing.Printer;

import java.util.Scanner;

public class Terminal {
    private CommandManager manager;
    private Messenger messenger;
    private Printer printer;
    private Editor editor;

    public Terminal(CommandManager manager, Messenger messenger, Printer printer, Editor editor) {
        this.manager = manager;
        this.messenger = messenger;
        this.printer = printer;
        this.editor = editor;
    }

    public CommandManager getManager() {
        return manager;
    }

    public void start() {

        System.out.println("Терминал открыт.\n" +
                "Введите команду для продолжения (help - список доступных команд)");

        Scanner sc = new Scanner(System.in);
        String response;
        while (!(response = sc.nextLine()).equalsIgnoreCase("exit")) {
            try {
                if(response.equals("")) {
                    System.out.println(getManager().getMessenger().getMessage("enterValidData"));
                } else {
                    manager.executeUserCommand(response);
                }

            } catch (Exception e) {
                System.err.println(e.getMessage());
            }
        }
        new Exit(null,null).execute(null);
    }
}
