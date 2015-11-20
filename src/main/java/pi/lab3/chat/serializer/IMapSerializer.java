package pi.lab3.chat.serializer;

import java.util.HashMap;
import java.util.Map;

/**
 * Yuliia Vovk
 * 16.11.15
 */
public interface IMapSerializer<KEY, VALUE> {

    void serialize(Map<KEY, VALUE> itemsMap, String path);
    HashMap<KEY,VALUE> deserialize(String path);
}
