package annotation.test;

import java.io.File;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;

@SuppressWarnings("serial")
public class ObtainClass extends HttpServlet {
	//不带参
		public  static void getAllClass(String location){
			String[] classes = location.split("/");
			String companyUrl = "F:/workspacegit/annotation-demo/annotation_demo/src/main/java/bean/company";
			String userUrl = "F:/workspacegit/annotation-demo/annotation_demo/src/main/java/bean/user";
			File companyFiles = new File(companyUrl);
			File userFiles = new File(userUrl);
			boolean flag = false;
			 HashMap<String, Object> classesMap = new  HashMap<String,Object> ();
			String[] companyClassName = companyFiles.list();
			Arrays.asList(companyClassName).forEach(name -> {
				String className = name.substring(0, name.length()-5);
				HashMap<String, Object>  newClasses = new HashMap<String,Object>();
				try {
					Class<?> newClass = Class.forName("bean.company."+className) ;
					Object object=newClass.newInstance();
					boolean annotationFlag = newClass.isAnnotationPresent(annotation.test.ControllerTest.class);
					if(annotationFlag){
						 String annotationValue = newClass.getAnnotation(annotation.test.ControllerTest.class).value();
						 if(classes[1].equals(annotationValue)){
							 Method method = newClass.getMethod(classes[2]);	
							 method.invoke(object, null);
						 }
					}
					System.out.println("类名  :" + className + "         是否含有注解controller:  " + annotationFlag);
					newClasses.put(className, object);
				} catch (Exception e) {
					e.printStackTrace();
				}
			});
			
			String[] userClassName = userFiles.list();
//			Arrays.asList(userClassName).forEach(System.out::println);
//			Arrays.asList(companyClassName).forEach(System.out::println);
			
		}
}
