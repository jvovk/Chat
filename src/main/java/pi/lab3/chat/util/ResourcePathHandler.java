package pi.lab3.chat.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import pi.lab3.chat.serializer.impl.MapSerializer;

import java.io.IOException;

/**
 * Yuliia Vovk
 * 20.11.15
 */
public final class ResourcePathHandler {

    private final static Logger LOGGER = LoggerFactory.getLogger(MapSerializer.class);

    private ResourcePathHandler() {

    }

    public static String getResourcePath(String absolutePath) {
        Resource rsrc = new ClassPathResource(absolutePath);
        try {
            absolutePath = rsrc.getFile().getAbsolutePath();
        } catch (IOException e) {
            LOGGER.error("Error while getting file!!", e);
            throw new RuntimeException(e);
        }
        return absolutePath;
    }

}
