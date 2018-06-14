package Model;

import DAL.InstitutionChooserMenu;
import DAL.KaszperPage;
import DAL.Menu1372;

public class Task1372 extends Task{
	KaszperPage startingpage;
	
	public Task1372(KaszperPage startingpage) {
		this.startingpage = startingpage;
	}
	
	@Override
	public KaszperPage execute() {
		Menu1372 menu1372 = new Menu1372(startingpage);
		menu1372.setDateFilter("=2017*");
		menu1372.refreshTable();
		menu1372.sortByBizonylatDateAscending();
		menu1372.removeEmptyDateRows();
		return menu1372;
	}

}
