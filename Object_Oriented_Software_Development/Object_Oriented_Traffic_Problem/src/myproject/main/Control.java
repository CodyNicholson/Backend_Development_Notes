package myproject.main;

import myproject.model.GridPattern;
import myproject.model.ModelParameters;
import myproject.ui.UI;
import myproject.ui.UIError;
import myproject.ui.UIForm;
import myproject.ui.UIFormBuilder;
import myproject.ui.UIFormTest;
import myproject.ui.UIMenu;
import myproject.ui.UIMenuBuilder;

class Control {
	private static final int EXITED = 0;
	private static final int EXIT = 1;
	private static final int START = 2;
	private static final int NUMSTATES = 10;
	private UIMenu[] menus;
	private int state;
	private UIFormTest numberTest;
	private UIFormTest stringTest;
	private ModelParameters modelParams;
	private UI ui;

	Control(ModelParameters modelParams, UI ui) {
		this.modelParams = modelParams;
		this.ui = ui;

		menus = new UIMenu[NUMSTATES];
		state = START;
		addSTART(START);
		addEXIT(EXIT);

		numberTest = input -> {
			try {
				Integer.parseInt(input);
				return true;
			} catch (NumberFormatException e) {
				return false;
			}
		};
		stringTest = input -> ! "".equals(input.trim());	
		
	}

	void run() {
		try {
			while (state != EXITED) {
				ui.processMenu(menus[state]);
			}
		} catch (UIError e) {
			ui.displayError("UI closed");
		}
	}

	private void addSTART(int stateNum) {
		UIMenuBuilder m = new UIMenuBuilder();
		
		
		m.add("Default",
				() -> ui.displayError("You cannot leave."));
		m.add("Show All Values", 
				() ->{
					UIFormBuilder f = new UIFormBuilder();
					f.add("Simulation Time Steps " + modelParams.simTimeStep, stringTest);
					UIForm form = f.toUIForm("");
					ui.processForm(form);
				});
		m.add("Simulation time step (seconds):",
				() ->{
					UIFormBuilder f = new UIFormBuilder();
					f.add("Time Step Seconds", numberTest);
					UIForm form = f.toUIForm("Enter Time Step Value");
					String[] vals = ui.processForm(form);
					modelParams.simTimeStep = Double.parseDouble(vals[0]); 
				});
		m.add("Simulation run time (seconds):",
				() -> {
					UIFormBuilder f = new UIFormBuilder();
					f.add("Simulation Runtime Seconds", numberTest);
					UIForm form = f.toUIForm("Enter Runtime Value");
					String[] vals = ui.processForm(form);
					modelParams.simRuntime = Double.parseDouble(vals[0]);
				});
		m.add("Grid Size (Number of roads):",
				() -> {
					UIFormBuilder f = new UIFormBuilder();
					f.add("Simulation Grid Rows", numberTest); //Takes user input
					f.add("Simulation Grid Columns", numberTest); //takes input
					UIForm form = f.toUIForm("Enter Row and Column Value"); //Creates form to take input
					String[] vals = ui.processForm(form); // Gets the output from the form
					modelParams.gridRow = Integer.parseInt(vals[0]); // Stores rows in model params
					modelParams.gridColumn = Integer.parseInt(vals[1]); // Stores columns in model params
				});
		m.add("Traffic Pattern:",
				() -> {
					UIFormBuilder f = new UIFormBuilder();
					f.add("Traffic Pattern:", numberTest);
					UIForm form = f.toUIForm("Traffic Pattern 1 = Simple, 2 = Alternating:");
					String[] vals = ui.processForm(form);
					if(vals[0].equals("1"))
					{
						modelParams.p = GridPattern.simple;
					}
					else
					{
						modelParams.p = GridPattern.alternating;
					}
				});
		m.add("Car Generation Delay:",
				() -> {
					UIFormBuilder f = new UIFormBuilder();
					f.add("Car Generation Delay Min:", numberTest);
					f.add("Car Generation Delay Max:", numberTest);
					UIForm form = f.toUIForm("Enter Car Generation Delay Min and Max Values:");
					String[] vals = ui.processForm(form);
					modelParams.carGenerationDelayMin = Integer.parseInt(vals[0]);
					modelParams.carGenerationDelayMax = Integer.parseInt(vals[1]);
				});
		m.add("Road Segment Length:",
				() -> {
					UIFormBuilder f = new UIFormBuilder();
					f.add("Road Segment Length Min:", numberTest);
					f.add("Road Segment Length Max:", numberTest);
					UIForm form = f.toUIForm("Enter Road Length Min and Max Values:");
					String[] vals = ui.processForm(form);
					modelParams.roadLengthMin = Integer.parseInt(vals[0]);
					modelParams.roadLengthMax = Integer.parseInt(vals[1]);
				});
		m.add("Intersection Length:",
				() -> {
					UIFormBuilder f = new UIFormBuilder();
					f.add("Intersection Length Min:", numberTest);
					f.add("Intersection Length Max:", numberTest);
					UIForm form = f.toUIForm("Enter Road Length Min and Max Values:");
					String[] vals = ui.processForm(form);
					modelParams.intersectionMin = Integer.parseInt(vals[0]);
					modelParams.intersectionMax = Integer.parseInt(vals[1]);
				});
		m.add("Car Length:",
				() -> {
					UIFormBuilder f = new UIFormBuilder();
					f.add("Road Segment Length Min:", numberTest);
					f.add("Road Segment Length Max:", numberTest);
					UIForm form = f.toUIForm("Enter Road Length Min and Max Values:");
					String[] vals = ui.processForm(form);
					modelParams.roadLengthMin = Integer.parseInt(vals[0]);
					modelParams.roadLengthMax = Integer.parseInt(vals[1]);
				});
		m.add("Car Maximum Velocity:",
				() -> {
					
				});
		m.add("Car Stop Distance:",
				() -> {
					
				});
		m.add("Car Brake Distance:",
				() -> {
					
				});
		m.add("Green Light Duration:",
				() -> {
					
				});
		m.add("Yellow Light Duration:",
				() -> {
					
				});
		m.add("Exit",
				() -> state = EXIT);
		menus[stateNum] = m.toUIMenu("Cody's Traffic Simulator");
	}
	private void addEXIT(int stateNum) {
		UIMenuBuilder m = new UIMenuBuilder();

		m.add("Default", () -> {});
		m.add("Yes",
				() -> state = EXITED);
		m.add("No",
				() -> state = START);

		menus[stateNum] = m.toUIMenu("Are you sure you want to exit?");
	}
}
