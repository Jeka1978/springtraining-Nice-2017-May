package myspring;

import lombok.SneakyThrows;

import java.lang.reflect.Field;

/**
 * Created by Evegeny on 06/06/2017.
 */
public class InjectByFieldTypeObjectConfigurer implements ObjectConfigurer {
    @Override
    @SneakyThrows
    public void configure(Object t) {
        Field[] fields = t.getClass().getDeclaredFields();
        for (Field field : fields) {
            if (field.isAnnotationPresent(InjectByFieldType.class)) {
                Class<?> type = field.getType();
                Object object = ObjectFactory.getInstance().createObject(type);
                field.setAccessible(true);
                field.set(t,object);

            }
        }
    }
}





