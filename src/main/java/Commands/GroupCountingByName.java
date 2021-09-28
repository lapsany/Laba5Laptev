package Commands;

import editing.Editor;
import input.Messenger;
import product.Product;

import java.util.HashSet;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class GroupCountingByName extends Command{


    public GroupCountingByName(HashSet<Product> products, Messenger messenger) {
        super(products, messenger);
    }

    @Override
    public String execute(String args) throws Exception {
        Map<String, Long> productsByNames = getProducts().stream().collect(
                Collectors.groupingBy(Product::getName, Collectors.counting()));
        return getEditor().editGroup(productsByNames);
    }

    @Override
    public String toString() {
        return super.toString() + ": " + getMessenger().getMessage("infoGroupCountingByName");
    }
}
