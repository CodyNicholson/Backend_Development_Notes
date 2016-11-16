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
		startMenu(START);
		addEXIT(EXIT);

		numberTest = input -> {
			try {
				Integer.parseInt(input);
				return true;
			} catch (NumberFormatException e) {
				return false;
			}
		};
		setStringTest(input -> ! "".equals(input.trim()));	
		
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

	private void startMenu(int stateNum)
	{
		UIMenuBuilder s = new UIMenuBuilder();
		
		s.add("Default", () -> ui.displayError("You cannot leave."));
		s.add("Run Simulation", () -> state = EXITED);
		s.add("Change Simulator Parameters", () -> changeParamsMenu(START));
		s.add("Exit", () -> System.exit(0));
		menus[stateNum] = s.toUIMenu("Cody's Traffic Simulator");
	}
	
	private void changeParamsMenu(int stateNum) {
		UIMenuBuilder m = new UIMenuBuilder();
		
		m.add("Default",
				() -> ui.displayError("You cannot leave."));
		m.add("Show All Values", 
				() ->{
					ui.displayMessage("Simulation Time Steps: " + modelParams.simTimeStep + 
							"\nSimulation Runtime: " + modelParams.simRuntime +
							"\nGrid Rows: " + ModelParameters.gridRow +
							"\nGrid Columns: " + ModelParameters.gridColumn +
							"\nTraffic Pattern: " + ModelParameters.p +
							"\nCar Generation Delay Min: " + ModelParameters.carGenerationDelayMin +
							"\nCar Generation Delay Max: " + ModelParameters.carGenerationDelayMax +
							"\nRoad Segment Length Min: " + ModelParameters.roadLengthMin +
							"\nRoad Segment Length Max: " + ModelParameters.roadLengthMax +
							"\nIntersection Length Min: " + ModelParameters.intersectionMin +
							"\nIntersection Length Max: " + ModelParameters.intersectionMax +
							"\nCar Length Min: " + ModelParameters.carLenMin +
							"\nCar Length Max: " + ModelParameters.carLenMax +
							"\nCar Velocity Min: " + ModelParameters.carVelocityMin +
							"\nCar Velocity Max: " + ModelParameters.carVelocityMax +
							"\nCar Stopping Distance Min: " + ModelParameters.carStopDistanceMin +
							"\nCar Stopping Distance Max: " + ModelParameters.carStopDistanceMax +
							"\nCar Braking Distance Min: " + ModelParameters.carBrakeDistanceMin +
							"\nCar Braking Distance Max: " + ModelParameters.carBrakeDistanceMax +
							"\nGreen Light Duration Min: " + ModelParameters.greenLightLenMin +
							"\nGreen Light Duration Max: " + ModelParameters.greenLightLenMax +
							"\nYellow Light Duration Min: " + ModelParameters.yellowLightLenMin +
							"\nYellow Light Duration Max: " + ModelParameters.yellowLightLenMax);
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
					ModelParameters.gridRow = Integer.parseInt(vals[0]); // Stores rows in model params
					ModelParameters.gridColumn = Integer.parseInt(vals[1]); // Stores columns in model params
				});
		m.add("Traffic Pattern:",
				() -> {
					UIFormBuilder f = new UIFormBuilder();
					f.add("Traffic Pattern:", numberTest);
					UIForm form = f.toUIForm("Traffic Pattern 1 = Simple, 2 = Alternating:");
					String[] vals = ui.processForm(form);
					if(vals[0].equals("2"))
					{
						ModelParameters.p = GridPattern.alternating;
					}
					else
					{
						ModelParameters.p = GridPattern.simple;
					}
				});
		m.add("Car Generation Delay:",
				() -> {
					UIFormBuilder f = new UIFormBuilder();
					f.add("Car Generation Delay Min:", numberTest);
					f.add("Car Generation Delay Max:", numberTest);
					UIForm form = f.toUIForm("Enter Car Generation Delay Min and Max Values:");
					String[] vals = ui.processForm(form);
					ModelParameters.carGenerationDelayMin = Integer.parseInt(vals[0]);
					ModelParameters.carGenerationDelayMax = Integer.parseInt(vals[1]);
				});
		m.add("Road Segment Length:",
				() -> {
					UIFormBuilder f = new UIFormBuilder();
					f.add("Road Segment Length Min:", numberTest);
					f.add("Road Segment Length Max:", numberTest);
					UIForm form = f.toUIForm("Enter Road Length Min and Max Values:");
					String[] vals = ui.processForm(form);
					ModelParameters.roadLengthMin = Integer.parseInt(vals[0]);
					ModelParameters.roadLengthMax = Integer.parseInt(vals[1]);
				});
		m.add("Intersection Length:",
				() -> {
					UIFormBuilder f = new UIFormBuilder();
					f.add("Intersection Length Min:", numberTest);
					f.add("Intersection Length Max:", numberTest);
					UIForm form = f.toUIForm("Enter Road Length Min and Max Values:");
					String[] vals = ui.processForm(form);
					ModelParameters.intersectionMin = Integer.parseInt(vals[0]);
					ModelParameters.intersectionMax = Integer.parseInt(vals[1]);
				});
		m.add("Car Length:",
				() -> {
					UIFormBuilder f = new UIFormBuilder();
					f.add("Car Length Min:", numberTest);
					f.add("Car Length Max:", numberTest);
					UIForm form = f.toUIForm("Enter Car Length Min and Max Values:");
					String[] vals = ui.processForm(form);
					ModelParameters.carLenMin = Integer.parseInt(vals[0]);
					ModelParameters.carLenMax = Integer.parseInt(vals[1]);
				});
		m.add("Car Velocity:",
				() -> {
					UIFormBuilder f = new UIFormBuilder();
					f.add("Car Velocity Min:", numberTest);
					f.add("Car Velocity Max:", numberTest);
					UIForm form = f.toUIForm("Enter Car Velocity Min and Max Values:");
					String[] vals = ui.processForm(form);
					ModelParameters.carVelocityMin = Integer.parseInt(vals[0]);
					ModelParameters.carVelocityMax = Integer.parseInt(vals[1]);
				});
		m.add("Car Stopping Distance:",
				() -> {
					UIFormBuilder f = new UIFormBuilder();
					f.add("Car Stopping Distance Min:", numberTest);
					f.add("Car Stopping Distance Max:", numberTest);
					UIForm form = f.toUIForm("Enter Car Stopping Distance Min and Max Values:");
					String[] vals = ui.processForm(form);
					ModelParameters.carStopDistanceMin = Integer.parseInt(vals[0]);
					ModelParameters.carStopDistanceMax = Integer.parseInt(vals[1]);
				});
		m.add("Car Braking Distance:",
				() -> {
					UIFormBuilder f = new UIFormBuilder();
					f.add("Car Braking Distance Min:", numberTest);
					f.add("Car Braking Distance Max:", numberTest);
					UIForm form = f.toUIForm("Enter Car Braking Distance Min and Max Values:");
					String[] vals = ui.processForm(form);
					ModelParameters.carBrakeDistanceMin = Integer.parseInt(vals[0]);
					ModelParameters.carBrakeDistanceMax = Integer.parseInt(vals[1]);
				});
		m.add("Green Light Duration:",
				() -> {
					UIFormBuilder f = new UIFormBuilder();
					f.add("Green Light Duration Min:", numberTest);
					f.add("Green Light Duration Max:", numberTest);
					UIForm form = f.toUIForm("Enter Green Light Duration Min and Max Values:");
					String[] vals = ui.processForm(form);
					ModelParameters.greenLightLenMin = Integer.parseInt(vals[0]);
					ModelParameters.greenLightLenMax = Integer.parseInt(vals[1]);
				});
		m.add("Yellow Light Duration:",
				() -> {
					UIFormBuilder f = new UIFormBuilder();
					f.add("Yellow Light Duration Min:", numberTest);
					f.add("Yellow Light Duration Max:", numberTest);
					UIForm form = f.toUIForm("Enter Yellow Light Duration Min and Max Values:");
					String[] vals = ui.processForm(form);
					ModelParameters.yellowLightLenMin = Integer.parseInt(vals[0]);
					ModelParameters.yellowLightLenMax = Integer.parseInt(vals[1]);
				});
		m.add("Exit",
				() -> startMenu(stateNum));
		menus[stateNum] = m.toUIMenu("Simulator Parameters");
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

	public UIFormTest getStringTest() {
		return stringTest;
	}

	public void setStringTest(UIFormTest stringTest) {
		this.stringTest = stringTest;
	}
}
