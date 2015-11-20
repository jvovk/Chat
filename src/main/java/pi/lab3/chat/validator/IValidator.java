package pi.lab3.chat.validator;

/**
 * Created by Y. Vovk on 23.09.15.
 */
public interface IValidator<T> {

    void validate(T obj);
}
