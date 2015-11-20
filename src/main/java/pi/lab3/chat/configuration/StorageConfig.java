package pi.lab3.chat.configuration;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import pi.lab3.chat.entity.Message;
import pi.lab3.chat.entity.User;
import pi.lab3.chat.serializer.ICollectionSerializer;
import pi.lab3.chat.serializer.IMapSerializer;
import pi.lab3.chat.serializer.impl.CollectionSerializer;
import pi.lab3.chat.serializer.impl.MapSerializer;

import java.util.HashMap;
import java.util.TreeSet;

/**
 * Yuliia Vovk
 * 20.11.15
 */
@Configuration
public class StorageConfig {

    @Bean
    public IMapSerializer<String, User> createUserSerializer() {
        return new MapSerializer<>(String.class, User.class);
    }

    @Bean(name = "users")
    public HashMap<String, User> createUserMap(@Value("${path.to.user.map}") String path) {
        return createUserSerializer().deserialize(path);
    }

    @Bean
    public ICollectionSerializer<Message> createMessageSerializer() {
        return new CollectionSerializer<>(Message.class);
    }

    @Bean(name = "messages")
    public TreeSet<Message> createMessageMap(@Value("${path.to.message.collection}") String path) {
        return createMessageSerializer().deserialize(path);
    }

}
