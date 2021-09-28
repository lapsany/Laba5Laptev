package editing;

import input.Messenger;
import product.Product;

import java.util.Collection;
import java.util.Map;

public class ImplEditor implements Editor{
    public String editCollection(Collection<?> collection) {
        return collection
                .toString()
                .substring(1, collection.toString().length()-1)
                .replaceAll(", ", "\n");
    }

    public String BooleanOperation(boolean bool, Messenger messenger) {
        if(bool) {
            return messenger.getMessage("OperatorTrue");
        } else {
            return messenger.getMessage("OperatorFalse");
        }
    }

    public String editGroup(Map<String, Long> map){
        String result = "";
        for (Map.Entry<String, Long> entry : map.entrySet()) {
            result += entry.getKey() + ": " + entry.getValue() + "\n";
        }
        return result;
    }
}
