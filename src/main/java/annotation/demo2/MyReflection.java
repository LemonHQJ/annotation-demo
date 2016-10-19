package annotation.demo2;

import java.lang.reflect.Method;

public class MyReflection {

	public static void main(String[] args) throws Exception {
		MyTest myTest = new MyTest();
		Class<MyTest> c =MyTest.class;
		Method method=c.getMethod("outPut", new Class[] {});
		if(MyTest.class.isAnnotationPresent(MyAnnotation.class))  
		  {  
		   System.out.println("have annotation");  
		  }  
		   if (method.isAnnotationPresent(MyAnnotation.class))  
		   {  
		   method.invoke(myTest, null); 
		     MyAnnotation myAnnotation = method.getAnnotation(MyAnnotation.class);  
		    String hello = myAnnotation.hello();  
		   String world = myAnnotation.world();  
		   System.out.println(hello + ", " + world); 
		   System.out.println(myAnnotation.array().length);
		   System.out.println(myAnnotation.style());  
		   }  
		   }  
		}  
