package myproject.main;

import myproject.main.Control;
import myproject.model.Model;
import myproject.model.ModelParameters;
import myproject.model.swing.SwingAnimatorBuilder;
import myproject.model.text.TextAnimatorBuilder;
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
		ModelParameters modelParams = new ModelParameters();
		ui = new myproject.ui.PopupUI();
		Control control = new Control(modelParams, ui);
		control.run();
		
		{
			Model m = new Model(new SwingAnimatorBuilder(), modelParams.gridRow, modelParams.gridColumn);
			m.run(modelParams.simRuntime);
			m.dispose();
		}
		System.exit(0);
	}
}

