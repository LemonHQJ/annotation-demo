package annotation.demo4;

import java.lang.annotation.ElementType;

public class Main {
	
	public static void main(String[] args)  {
		System.out.println(ElementType.valueOf("METHOD"));
		for(ElementType c : ElementType.values())
	        System.out.println(c);

	}
}
