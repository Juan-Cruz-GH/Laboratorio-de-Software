import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.*;

public class SNLProcessor {
    public static <T> List<T> createRandomInstances(Class<T> elClass, int cant) throws NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        if (!elClass.isAnnotationPresent(Generator.class)) {
            throw new IllegalArgumentException("La clase no está anotada con @Generator");
        }

        List<T> instancias = new ArrayList<>();

        for (Field campo : elClass.getDeclaredFields()) {
            if (!campo.isAnnotationPresent(SeedValueAttribute.class)) {
                throw new IllegalArgumentException("El atributo seed no está anotado con @SeedValueAttribute");
            }
            else {
                long[] seeds = campo.getAnnotation(SeedValueAttribute.class).value();
                if (seeds.length != cant) {
                    throw new IllegalArgumentException("La cantidad de valores en la anotación es distinta a la cantidad de instancias que se quieren crear.");
                }
                for(int i = 0; i <= cant; i++) {
                    T instancia = elClass.getDeclaredConstructor().newInstance();
                    campo.setAccessible(true);
                    campo.setLong(instancia, seeds[i]);
                    instancias.add(instancia);
                }
            }
        }
        return instancias;
    }
}
