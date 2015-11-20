package pi.lab3.chat.serializer.impl;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import pi.lab3.chat.serializer.IMapSerializer;
import pi.lab3.chat.util.ResourcePathHandler;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * Yuliia Vovk
 * 16.11.15
 */
public class MapSerializer<KEY, VALUE> implements IMapSerializer<KEY, VALUE> {

    private final static Logger LOGGER = LoggerFactory.getLogger(MapSerializer.class);

    private Class<KEY> keyClass;
    private Class<VALUE> valueClass;

    public MapSerializer(Class<KEY> keyClass, Class<VALUE> valueClass) {
        this.keyClass = keyClass;
        this.valueClass = valueClass;
    }

    public void serialize(Map<KEY, VALUE> itemsMap, String path) {
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.enableDefaultTyping(ObjectMapper.DefaultTyping.NON_FINAL);
        try {
            objectMapper.writeValue(new File(path), itemsMap);
        } catch (IOException e) {
            LOGGER.error("Error while serializing!", e);
            throw new RuntimeException(e);
        }
    }

    public HashMap<KEY, VALUE> deserialize(String path) {
        ObjectMapper mapper = new ObjectMapper();
        mapper.enableDefaultTyping(ObjectMapper.DefaultTyping.NON_FINAL);
        HashMap<KEY, VALUE> mapObject = new HashMap<>();
        path = ResourcePathHandler.getResourcePath(path);
        File jsonFile = new File(path);
        if (jsonFile.length() > 0) {
            try {
                mapObject = mapper.readValue(jsonFile, new TypeReference<HashMap<KEY, VALUE>>() {
                });
            } catch (IOException e) {
                LOGGER.error("Error while deserializing!", e);
                throw new RuntimeException(e);
            }
        }
        return mapObject;
    }
}
