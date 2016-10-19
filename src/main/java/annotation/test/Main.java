package annotation.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import bean.company.CompanyController;
import bean.user.UserController;

public class Main {
	public static void main(String[] args) {
		ApplicationContext ctx  = new ClassPathXmlApplicationContext("annotation.xml");
		UserController userController = (UserController)ctx.getBean("userController");
		CompanyController companyController = (CompanyController)ctx.getBean("companyController");
		FileTest.getAllObject();
		FileTest.method("companyController/companyDelete");
		System.out.println("end.................");
	}

}
