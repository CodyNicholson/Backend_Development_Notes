package myproject.main;

import myproject.main.Control;
import myproject.model.MP;
import myproject.model.Model;
import myproject.model.swing.SwingAnimatorBuilder;
import myproject.ui.UI;

/**
 * A static class to demonstrate the visualization aspect of
 * simulation.
 */
public class Main {
	private Main() {}
	public static void main(String[] args)
	{
		UI ui = null;
		MP modelParams = new MP();
		ui = new myproject.ui.PopupUI();
		Control control = new Control(modelParams, ui);
		control.run();
		{
			Model m = new Model(new SwingAnimatorBuilder(), MP.gridRow, MP.gridColumn);
			m.run(modelParams.simRuntime);
			m.dispose();
		}
		System.exit(0);
	}
}

/*
State
Visitor
Factory Method
Null Object
*/