package annotation.demo1;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;



@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.TYPE})
@Documented
//@RequestMapping
public @interface ControllerTest {
		String value() default "";
		
}
