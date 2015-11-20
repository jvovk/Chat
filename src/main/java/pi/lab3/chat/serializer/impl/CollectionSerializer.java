package pi.lab3.chat.serializer.impl;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import pi.lab3.chat.serializer.ICollectionSerializer;
import pi.lab3.chat.util.ResourcePathHandler;

import java.io.File;
import java.io.IOException;
import java.util.Collection;
import java.util.TreeSet;

/**
 * Yuliia Vovk
 * 20.11.15
 */
public class CollectionSerializer<COLLECTION> implements ICollectionSerializer<COLLECTION> {

    private final static Logger LOGGER = LoggerFactory.getLogger(CollectionSerializer.class);

    private Class<COLLECTION> collectionClass;

    public CollectionSerializer(Class<COLLECTION> collectionClass) {
        this.collectionClass = collectionClass;
    }

    @Override
    public void serialize(Collection<COLLECTION> itemsMap, String path) {
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.enableDefaultTyping(ObjectMapper.DefaultTyping.NON_FINAL);
        try {
            objectMapper.writeValue(new File(path), itemsMap);
        } catch (IOException e) {
            LOGGER.error("Error while serializing!", e);
            throw new RuntimeException(e);
        }
    }

    @Override
    public TreeSet<COLLECTION> deserialize(String path) {
        ObjectMapper mapper = new ObjectMapper();
        mapper.enableDefaultTyping(ObjectMapper.DefaultTyping.NON_FINAL);
        TreeSet<COLLECTION> collectionObject = new TreeSet<>();
        path = ResourcePathHandler.getResourcePath(path);
        File jsonFile = new File(path);
        if(jsonFile.length() > 0) {
            try {
                collectionObject = mapper.readValue(jsonFile, new TypeReference<TreeSet<COLLECTION>>() {
                });
            } catch (IOException e) {
                LOGGER.error("Error while deserializing!", e);
                throw new RuntimeException(e);
            }
        }
        return collectionObject;
    }
}
