package bean.company;
import org.springframework.stereotype.Repository;

@Repository("companyDaoImpl") 
public class CompanyDaoImpl {

	public void save() {
		System.out.println("CompanyDaoImpl add");
	}

	public void delete() {
		System.out.println("CompanyDaoImpl delete");
	}

}
