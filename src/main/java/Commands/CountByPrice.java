package Commands;

import input.Messenger;
import product.Product;
import java.util.HashSet;

public class CountByPrice extends Command{
    public CountByPrice(HashSet<Product> products, Messenger messenger) {
        super(products, messenger);
    }

    @Override
    public String execute(String args) throws Exception {

        int count = 0;
        Double price = Double.parseDouble(args);
        for (Product v: getProducts()) {
            if(v.getPrice().equals(price)) count++;
        }
        return String.valueOf(count);
    }

    @Override
    public String toString() {
        return super.toString() + ": " + getMessenger().getMessage("infoAdd");
    }
}
