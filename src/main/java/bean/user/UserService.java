package bean.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import annotation.test.ActionTest;

@Service(value="userService")
public class UserService {
	@Autowired
	@Qualifier("userDaoImpl")  
	private UserDaoImpl userDao;
	
	public void setDao(UserDaoImpl userDao) {
		this.userDao = userDao;
	}
	
	public void add(){
		System.out.println("UserService add....");
		userDao.save();
	}

	public void delete(){
		System.out.println("CompanyService delete....");
		userDao.delete();
	}
}
