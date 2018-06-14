package Model;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.processing.ProcessingEnvironment;

import DAL.KaszperPage;
import DAL.Menu91;
import net.bytebuddy.asm.Advice.OnDefaultValue;

//TODO might skip rows if database changes while in operation
public class AcceptAndFinalizeTask extends Task {

	KaszperPage startingpage;
	Menu91 menu91;

	public AcceptAndFinalizeTask(KaszperPage startingpage) {
		this.startingpage = startingpage;
	}

	@Override
	public KaszperPage execute() {
		menu91 = new Menu91(startingpage);
		do {
			processPage();
		}while(menu91.selectNextPage());
		
		return menu91;
	}

	private void processPage() {
		
		int recordsonpage = menu91.getNumberofRowsOnListPage();
		System.out.println("Records on page:" + recordsonpage);
		int currentrow = 0;
		String lastid = "";
		while (true) {
			if (lastid.equals(menu91.getId(currentrow))) {
				currentrow++;
				if(currentrow>=recordsonpage)
					break;
			}
			lastid = menu91.getId(currentrow);
			processRow(currentrow);
		}
	}

	private void processRow(int rowindex) {
		System.out.println("processing row:" + rowindex);
		menu91.enterRowDetailsPage(rowindex);
		int numofkontirtetelek = menu91.getNumberofKontirTetelek();
		for (int i = 0; i < numofkontirtetelek; i++) {
			if (menu91.kontirtetelHasElotoltButton(i)) {
				menu91.elotoltRow(i);
				menu91.hozzaad();
			} else
				menu91.hozzaad();
		}

		menu91.closeDetails();
		menu91.selectRow(rowindex);
		menu91.veglegesit();

	}

}
