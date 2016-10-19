package bean.user;
import org.springframework.stereotype.Repository;

@Repository("userDaoImpl") 
public class UserDaoImpl  {

	public void save() {
		System.out.println("UserDaoImpl add");
	}

	public void delete() {
		System.out.println("UserDaoImpl delete");
	}

}
