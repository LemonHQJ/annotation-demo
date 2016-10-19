package bean.company;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;

import annotation.test.ActionTest;
import annotation.test.ControllerTest;
@ControllerTest(value="companyController")
@Scope("prototype")
public class CompanyController {
//	@Autowired
	private CompanyService companyService = new CompanyService();
//	private CompanyService companyService;
	@ActionTest(url="/companySave")
	public void executeSave(){
		System.out.println("CompanyController executSave ");
		companyService.add();
	}
	
	@ActionTest(url="/companyDelete")
	public void executeDelete(){
		System.out.println("CompanyController executeDelete 1111111");
		companyService.delete();
	}
}
