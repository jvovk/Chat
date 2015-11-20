package pi.lab3.chat.serializer;

import java.util.Collection;
import java.util.TreeSet;

/**
 * Yuliia Vovk
 * 20.11.15
 */
public interface ICollectionSerializer<COLLECTION> {

    void serialize(Collection<COLLECTION> itemsMap, String path);
    TreeSet<COLLECTION> deserialize(String path);
}
