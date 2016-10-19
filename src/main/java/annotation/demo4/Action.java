package annotation.demo4;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.xml.ws.FaultAction;

@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface Action {
	
    String input() default "";
    
    String output() default "";
    
    FaultAction[] fault() default { };
}