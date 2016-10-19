package bean.company;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import annotation.test.ActionTest;

@Service(value="companyService")
public class CompanyService {
//	@Autowired
//	@Qualifier("companyDaoImpl")  
	private CompanyDaoImpl companyDao=new CompanyDaoImpl();
//	private CompanyDaoImpl companyDao;
	
	public void setDao(CompanyDaoImpl companyDao) {
		this.companyDao = companyDao;
	}
	
	public void add(){
		System.out.println("CompanyService add....");
		companyDao.save();
	}

	public void delete(){
		System.out.println("CompanyService delete....");
		companyDao.delete();
	}
}
