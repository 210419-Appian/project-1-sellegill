import java.util.List;

import com.revature.daos.AccountDAOImpl;
import com.revature.daos.UserDAOImpl;
import com.revature.models.Account;
import com.revature.models.User;
import com.revature.service.AccountService;
import com.revature.service.UserService;

public class Driver {
	
	
//static methods can only call static fields
  	private static AccountService aServ =  new AccountService();
		
		private static UserService uServ = new UserService();

		public static void main(String[] args) {
	//	List<Account> list = aServ.findAllAccounts();
			
		
				//System.out.println(list);
	//	for(Account a: list) {
	//			System.out.println(a);
	//		}
			
		
/*--------------------------------------------------------------------------------*/	
		//AccountDAO
		AccountDAOImpl adao = new AccountDAOImpl();
	//	System.out.println(adao.findAccountByStatus(1));// It works 
	//	System.out.println(adao.findByAccountId(2)); //It works
		
	//	System.out.println(adao.findAllAccounts()); //It works
		
		
		
/*--------------------------------------------------------------------------------*/		
		//UserDAO
	List<User> ulist = uServ.findAllUsers();
	UserDAOImpl udao = new UserDAOImpl();
	//	System.out.println(ulist); works
	//	System.out.println(udao.findById(4)); Works
	//	System.out.println(udao.findUserByUsername("tammytea")); it works!!
	
//	  for(User u: ulist) {
//			System.out.println(ulist);
		}
		
		
	//	System.out.println(udao.findAllUsers()); //Fixed!!!
		
/*--------------------------------------------------------------------------------*/

	//	}

}