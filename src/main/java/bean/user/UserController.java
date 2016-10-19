package bean.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;

import annotation.test.ActionTest;
import annotation.test.ControllerTest;


@ControllerTest(value="userController")
@Scope("prototype")
public class UserController {
	@Autowired
	private UserService userService;
	
	@ActionTest(url="/userSave")
	public void executeSave(){
		System.out.println("UserController executeSave ");
		userService.add();
	}
	
	@ActionTest(url="/userDelete")
	public void executeDelete(){
		System.out.println("UserController executeDelete ");
		userService.delete();
	}
	
}
