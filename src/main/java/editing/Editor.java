package editing;

import input.Messenger;

import java.util.Collection;
import java.util.Map;

public interface Editor {
    String editCollection(Collection<?> collection);
    String BooleanOperation(boolean bool, Messenger messenger);
    String editGroup(Map<String, Long> map);
}
