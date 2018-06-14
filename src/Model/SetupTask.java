package Model;

import DAL.InstitutionChooserMenu;
import DAL.KaszperPage;

public class SetupTask extends Task{
	String username;
	String password;
	String institutionname;

	public SetupTask(String username,String password,String institutionname) {
		this.username = username;
		this.password = password;
		this.institutionname = institutionname;
	}

	@Override
	public KaszperPage execute() {
		InstitutionChooserMenu kaszper = new InstitutionChooserMenu(username, password);
		
		 kaszper.selectInstitution(institutionname);
		
		return kaszper;
	}

}
