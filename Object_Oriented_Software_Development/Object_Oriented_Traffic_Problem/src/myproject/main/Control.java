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
					f.add("Simulation Time Steps " + modelParams.simTimeStep + 
							"\nSimulation Runtime " + modelParams.simRuntime +
							"\nGrid Rows " + modelParams.gridRow +
							"\nGrid Columns " + modelParams.gridColumn +
							"\nTraffic Pattern " + modelParams.p +
							"\nCar Generation Delay Min " + modelParams.carGenerationDelayMin +
							"\nCar Generation Delay Max " + modelParams.carGenerationDelayMax +
							"\nRoad Segment Length Min " + modelParams.roadLengthMin +
							"\nRoad Segment Length Max " + modelParams.roadLengthMax +
							"\nIntersection Length Min " + modelParams.intersectionMin +
							"\nIntersection Length Max " + modelParams.intersectionMax +
							"\nCar Length Min " + modelParams.carLenMin +
							"\nCar Length Max " + modelParams.carLenMax +
							"\nCar Velocity Min " + modelParams.carVelocityMin +
							"\nCar Velocity Max " + modelParams.carVelocityMax +
							"\nCar Stopping Distance Min " + modelParams.carStopDistanceMin +
							"\nCar Stopping Distance Max " + modelParams.carStopDistanceMax +
							"\nCar Braking Distance Min " + modelParams.carBrakeDistanceMin +
							"\nCar Braking Distance Max " + modelParams.carBrakeDistanceMax +
							"\nGreen Light Duration Min " + modelParams.greenLightLenMin +
							"\nGreen Light Duration Max " + modelParams.greenLightLenMax +
							"\nYellow Light Duration Min " + modelParams.yellowLightLenMin +
							"\nYellow Light Duration Max " + modelParams.yellowLightLenMax, stringTest);
					
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
					if(vals[0].equals("2"))
					{
						modelParams.p = GridPattern.alternating;
					}
					else
					{
						modelParams.p = GridPattern.simple;
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
					f.add("Car Length Min:", numberTest);
					f.add("Car Length Max:", numberTest);
					UIForm form = f.toUIForm("Enter Car Length Min and Max Values:");
					String[] vals = ui.processForm(form);
					modelParams.carLenMin = Integer.parseInt(vals[0]);
					modelParams.carLenMax = Integer.parseInt(vals[1]);
				});
		m.add("Car Velocity:",
				() -> {
					UIFormBuilder f = new UIFormBuilder();
					f.add("Car Velocity Min:", numberTest);
					f.add("Car Velocity Max:", numberTest);
					UIForm form = f.toUIForm("Enter Car Velocity Min and Max Values:");
					String[] vals = ui.processForm(form);
					modelParams.carVelocityMin = Integer.parseInt(vals[0]);
					modelParams.carVelocityMax = Integer.parseInt(vals[1]);
				});
		m.add("Car Stopping Distance:",
				() -> {
					UIFormBuilder f = new UIFormBuilder();
					f.add("Car Stopping Distance Min:", numberTest);
					f.add("Car Stopping Distance Max:", numberTest);
					UIForm form = f.toUIForm("Enter Car Stopping Distance Min and Max Values:");
					String[] vals = ui.processForm(form);
					modelParams.carStopDistanceMin = Integer.parseInt(vals[0]);
					modelParams.carStopDistanceMax = Integer.parseInt(vals[1]);
				});
		m.add("Car Braking Distance:",
				() -> {
					UIFormBuilder f = new UIFormBuilder();
					f.add("Car Braking Distance Min:", numberTest);
					f.add("Car Braking Distance Max:", numberTest);
					UIForm form = f.toUIForm("Enter Car Braking Distance Min and Max Values:");
					String[] vals = ui.processForm(form);
					modelParams.carBrakeDistanceMin = Integer.parseInt(vals[0]);
					modelParams.carBrakeDistanceMax = Integer.parseInt(vals[1]);
				});
		m.add("Green Light Duration:",
				() -> {
					UIFormBuilder f = new UIFormBuilder();
					f.add("Green Light Duration Min:", numberTest);
					f.add("Green Light Duration Max:", numberTest);
					UIForm form = f.toUIForm("Enter Green Light Duration Min and Max Values:");
					String[] vals = ui.processForm(form);
					modelParams.greenLightLenMin = Integer.parseInt(vals[0]);
					modelParams.greenLightLenMax = Integer.parseInt(vals[1]);
				});
		m.add("Yellow Light Duration:",
				() -> {
					UIFormBuilder f = new UIFormBuilder();
					f.add("Yellow Light Duration Min:", numberTest);
					f.add("Yellow Light Duration Max:", numberTest);
					UIForm form = f.toUIForm("Enter Yellow Light Duration Min and Max Values:");
					String[] vals = ui.processForm(form);
					modelParams.yellowLightLenMin = Integer.parseInt(vals[0]);
					modelParams.yellowLightLenMax = Integer.parseInt(vals[1]);
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
