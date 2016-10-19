package annotation.test;

import java.io.File;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

public class FileTest {
	static Map<String,Object> obj = new HashMap<String,Object>();
	static Map<String,Method> objMethod = new HashMap<String,Method>();
	public static void getAllObject() {
		
		String url = FileTest.class.getClassLoader().getResource("").getPath()+"bean/";
		url = url.replace(File.separator, "/");
		url = url.substring(1, url.length());
		File file = new File(url);
		
		for(int i=0;i<file.list().length;i++){
			String className = "bean."+file.list()[i];
			String fileUrl = url+file.list()[i];
			File fileTemp = new File(fileUrl);
			for(int j=0;j<fileTemp.list().length;j++){
				try {
					String classNameTemp = className+"."+fileTemp.list()[j].substring(0, fileTemp.list()[j].length()-6);
					Class<?> newClass = Class.forName(classNameTemp);
					if(newClass.isAnnotationPresent(annotation.test.ControllerTest.class)){
						String annotationValue = newClass.getAnnotation(annotation.test.ControllerTest.class).value();
						getAnnotationMethodValue(annotationValue,newClass);
					} 
//					else if(newClass.isAnnotationPresent(org.springframework.stereotype.Service.class)){
//						String annotationValue = newClass.getAnnotation(org.springframework.stereotype.Service.class).value();
//						obj.put(annotationValue, newClass.newInstance());
//					} else if(newClass.isAnnotationPresent(org.springframework.stereotype.Repository.class)){
//						String annotationValue = newClass.getAnnotation(org.springframework.stereotype.Service.class).value();
//						obj.put(annotationValue, newClass.newInstance());
//					}  
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
	}
	
	private  static void getAnnotationMethodValue(String annotationValue,Class newClass){
		Method[] methods = newClass.getMethods();
		for(Method method:methods){
			ActionTest actionTest = method.getAnnotation(ActionTest.class);  
			if(actionTest != null){
				String name = actionTest.url(); 
				try {
					obj.put(annotationValue +name, newClass.newInstance());
					objMethod.put(annotationValue +name, method);
				} catch (Exception e) {
					e.printStackTrace();
				} 
			}
            }  
        
	}
	public static void method(String url){
		Object object= obj.get(url);
		Method method = objMethod.get(url);
		try {
			method.invoke(object, null);
		} catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(object);
	}
	
}


