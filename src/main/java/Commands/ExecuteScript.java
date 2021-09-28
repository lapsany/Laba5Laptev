package Commands;

import input.Input;
import input.InputFromFile;
import input.Messenger;
import Commands.managers.CommandManager;
import product.Product;
import java.io.*;
import java.util.HashSet;
import java.util.Scanner;

public class ExecuteScript extends Command{
    private Input userInput;
    private CommandManager manager;

    public ExecuteScript(HashSet<Product> products, Messenger messenger) {
        super(products, messenger);
    }

    @Override
    public String execute(String fileName) throws Exception {
        return execute_script(fileName);
    }

    public String execute_script(String fileName) throws Exception {

        this.userInput = new InputFromFile(new BufferedReader(new FileReader(fileName)), getMessenger());

        if(!new File(fileName).exists()) throw new IOException(getMessenger().getMessage("fileNotFound"));

        try(Scanner scanner = new Scanner(new File(fileName))) {
            StringBuilder result = new StringBuilder();
            String response;
            while (scanner.hasNextLine()) {
                response = scanner.nextLine();
                if(response.equals("executescript " + fileName)) {
                    result.append(getMessenger().getMessage("recursiveCallScript")).append("\n");
                } else {
                    result.append(manager.executeCommand(response)).append("\n");
                }
            }

            return result.toString();

        } catch (IOException e) {
            throw new Exception(e.getMessage());
        } catch (Exception e) {
            throw new Exception(getMessenger().getMessage("scriptNotValid"));
        }
    }

    public void setCommandManager(CommandManager manager) {
        this.manager = manager;
    }


    @Override
    public String toString() {
        return super.toString() + ": " + getMessenger().getMessage("infoExecuteScript");
    }
}

