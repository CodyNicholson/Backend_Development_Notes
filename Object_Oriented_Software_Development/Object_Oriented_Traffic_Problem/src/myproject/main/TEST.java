package myproject.main;

import myproject.model.Model;
import myproject.model.ModelParameters;
import myproject.model.swing.SwingAnimatorBuilder;
import myproject.ui.UI;

public class TEST
{
	public static void main(String[] args)
	{
		ModelParameters modelParams = new ModelParameters();
		{
			Model m = new Model(new SwingAnimatorBuilder(), ModelParameters.gridRow, ModelParameters.gridColumn);
			m.publicSetup(new SwingAnimatorBuilder(), ModelParameters.gridRow, ModelParameters.gridColumn);
			System.out.println("ASDF");
		}
		System.exit(0);
	}
}
