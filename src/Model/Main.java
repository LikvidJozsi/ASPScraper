package Model;



import DAL.InstitutionChooserMenu;
import DAL.KaszperPage;
import DAL.Menu1372;

public class Main {

	public static void main(String[] args) {

		String username = "Dummy user";
		String password = "Dummy password";
		String institutionname = "Dummy önkormányzat";
		
		SetupTask setup = new SetupTask(username, password, institutionname);
		KaszperPage currentpage = setup.execute();
		
		AcceptAndFinalizeTask task = new AcceptAndFinalizeTask(currentpage);
		task.execute();
	}
	
	

	

}
