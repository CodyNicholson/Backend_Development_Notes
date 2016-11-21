package myproject.main;

import myproject.model.GridPattern;
import myproject.model.MP;
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
	private MP modelParams;
	private UI ui;

	Control(MP modelParams, UI ui) {
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
							"\nGrid Rows: " + MP.gridRow +
							"\nGrid Columns: " + MP.gridColumn +
							"\nTraffic Pattern: " + MP.trafficPattern +
							"\nCar Generation Delay Min: " + MP.carGenerationDelayMin +
							"\nCar Generation Delay Max: " + MP.carGenerationDelayMax +
							"\nRoad Segment Length Min: " + MP.roadLengthMin +
							"\nRoad Segment Length Max: " + MP.roadLengthMax +
							"\nIntersection Length Min: " + MP.intersectionMin +
							"\nIntersection Length Max: " + MP.intersectionMax +
							"\nCar Length Min: " + MP.carLenMin +
							"\nCar Length Max: " + MP.carLenMax +
							"\nCar Velocity Min: " + MP.carVelocityMin +
							"\nCar Velocity Max: " + MP.carVelocityMax +
							"\nCar Stopping Distance Min: " + MP.carStopDistanceMin +
							"\nCar Stopping Distance Max: " + MP.carStopDistanceMax +
							"\nCar Braking Distance Min: " + MP.carBrakeDistanceMin +
							"\nCar Braking Distance Max: " + MP.carBrakeDistanceMax +
							"\nGreen Light Duration Min: " + MP.greenLightLenMin +
							"\nGreen Light Duration Max: " + MP.greenLightLenMax +
							"\nYellow Light Duration Min: " + MP.yellowLightLenMin +
							"\nYellow Light Duration Max: " + MP.yellowLightLenMax);
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
					MP.gridRow = Integer.parseInt(vals[0]); // Stores rows in model params
					MP.gridColumn = Integer.parseInt(vals[1]); // Stores columns in model params
				});
		m.add("Traffic Pattern:",
				() -> {
					UIFormBuilder f = new UIFormBuilder();
					f.add("Traffic Pattern:", numberTest);
					UIForm form = f.toUIForm("Traffic Pattern 1 = Simple, 2 = Alternating:");
					String[] vals = ui.processForm(form);
					if(vals[0].equals("2"))
					{
						MP.trafficPattern = GridPattern.alternating;
					}
					else
					{
						MP.trafficPattern = GridPattern.simple;
					}
				});
		m.add("Car Generation Delay:",
				() -> {
					UIFormBuilder f = new UIFormBuilder();
					f.add("Car Generation Delay Min:", numberTest);
					f.add("Car Generation Delay Max:", numberTest);
					UIForm form = f.toUIForm("Enter Car Generation Delay Min and Max Values:");
					String[] vals = ui.processForm(form);
					MP.carGenerationDelayMin = Integer.parseInt(vals[0]);
					MP.carGenerationDelayMax = Integer.parseInt(vals[1]);
				});
		m.add("Road Segment Length:",
				() -> {
					UIFormBuilder f = new UIFormBuilder();
					f.add("Road Segment Length Min:", numberTest);
					f.add("Road Segment Length Max:", numberTest);
					UIForm form = f.toUIForm("Enter Road Length Min and Max Values:");
					String[] vals = ui.processForm(form);
					MP.roadLengthMin = Integer.parseInt(vals[0]);
					MP.roadLengthMax = Integer.parseInt(vals[1]);
				});
		m.add("Intersection Length:",
				() -> {
					UIFormBuilder f = new UIFormBuilder();
					f.add("Intersection Length Min:", numberTest);
					f.add("Intersection Length Max:", numberTest);
					UIForm form = f.toUIForm("Enter Road Length Min and Max Values:");
					String[] vals = ui.processForm(form);
					MP.intersectionMin = Integer.parseInt(vals[0]);
					MP.intersectionMax = Integer.parseInt(vals[1]);
				});
		m.add("Car Length:",
				() -> {
					UIFormBuilder f = new UIFormBuilder();
					f.add("Car Length Min:", numberTest);
					f.add("Car Length Max:", numberTest);
					UIForm form = f.toUIForm("Enter Car Length Min and Max Values:");
					String[] vals = ui.processForm(form);
					MP.carLenMin = Integer.parseInt(vals[0]);
					MP.carLenMax = Integer.parseInt(vals[1]);
				});
		m.add("Car Velocity:",
				() -> {
					UIFormBuilder f = new UIFormBuilder();
					f.add("Car Velocity Min:", numberTest);
					f.add("Car Velocity Max:", numberTest);
					UIForm form = f.toUIForm("Enter Car Velocity Min and Max Values:");
					String[] vals = ui.processForm(form);
					MP.carVelocityMin = Integer.parseInt(vals[0]);
					MP.carVelocityMax = Integer.parseInt(vals[1]);
				});
		m.add("Car Stopping Distance:",
				() -> {
					UIFormBuilder f = new UIFormBuilder();
					f.add("Car Stopping Distance Min:", numberTest);
					f.add("Car Stopping Distance Max:", numberTest);
					UIForm form = f.toUIForm("Enter Car Stopping Distance Min and Max Values:");
					String[] vals = ui.processForm(form);
					MP.carStopDistanceMin = Integer.parseInt(vals[0]);
					MP.carStopDistanceMax = Integer.parseInt(vals[1]);
				});
		m.add("Car Braking Distance:",
				() -> {
					UIFormBuilder f = new UIFormBuilder();
					f.add("Car Braking Distance Min:", numberTest);
					f.add("Car Braking Distance Max:", numberTest);
					UIForm form = f.toUIForm("Enter Car Braking Distance Min and Max Values:");
					String[] vals = ui.processForm(form);
					MP.carBrakeDistanceMin = Integer.parseInt(vals[0]);
					MP.carBrakeDistanceMax = Integer.parseInt(vals[1]);
				});
		m.add("Green Light Duration:",
				() -> {
					UIFormBuilder f = new UIFormBuilder();
					f.add("Green Light Duration Min:", numberTest);
					f.add("Green Light Duration Max:", numberTest);
					UIForm form = f.toUIForm("Enter Green Light Duration Min and Max Values:");
					String[] vals = ui.processForm(form);
					MP.greenLightLenMin = Integer.parseInt(vals[0]);
					MP.greenLightLenMax = Integer.parseInt(vals[1]);
				});
		m.add("Yellow Light Duration:",
				() -> {
					UIFormBuilder f = new UIFormBuilder();
					f.add("Yellow Light Duration Min:", numberTest);
					f.add("Yellow Light Duration Max:", numberTest);
					UIForm form = f.toUIForm("Enter Yellow Light Duration Min and Max Values:");
					String[] vals = ui.processForm(form);
					MP.yellowLightLenMin = Integer.parseInt(vals[0]);
					MP.yellowLightLenMax = Integer.parseInt(vals[1]);
				});
		m.add("Return to Home Menu",
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
