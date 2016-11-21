package myproject.main;

import myproject.model.Model;
import myproject.model.MP;
import myproject.model.swing.SwingAnimatorBuilder;

public class TEST
{
	public static void main(String[] args)
	{
		{
			Model m = new Model(new SwingAnimatorBuilder(), MP.gridRow, MP.gridColumn);
			m.publicSetup(new SwingAnimatorBuilder(), MP.gridRow, MP.gridColumn);
		}
		System.exit(0);
	}
}
