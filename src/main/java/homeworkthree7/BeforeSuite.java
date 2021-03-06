package homeworkthree7;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)  // когда доступна анотация
@Target(ElementType.METHOD) // к чему применяется
public @interface BeforeSuite {
}
