import commands.MoveToLocationXY;
import commands.RobotCommandQueue;
import commands.RotateDegrees;

public class ExampleRobot {

    private RobotGeometry m_robotGeometry = new RobotGeometry();
    private RobotData m_robotData = new RobotData();
    private RobotCommandQueue m_robotQueue = new RobotCommandQueue();

    private RobotState previousState = null;
    private RobotState m_currentState = RobotState.PoweringUpState;

    private Object m_currentCommand = null; // See commands.RobotCommand implementations

    public String getRobotStateName() {
        return m_currentState.toString();
    } // for display in Main

    public void setRobotState(RobotState newState) {
        previousState = m_currentState;
        m_currentState = newState;
        System.out.println("*** Changed state: " + previousState.toString() + " -> " + m_currentState.toString());
    }

    /**
     * Main robot loop/ state machine. This is example code.
     */
    public void runStateMachine() {
        switch(m_currentState) {
            case PoweringUpState:
                if (this.doPowerUpStuff()) {
                    this.setRobotState(RobotState.InitializingDataState);
                }
                break;
            case InitializingDataState:

                if (this.initializeData()) {
                    // Load some commands for our robot.
                    // We could definitely load these from a different file.
                    System.out.println("-------- Populating Command Queue --------");
                    m_robotQueue.addCommand(new MoveToLocationXY(1.0, 2.0, 2.0));
                    m_robotQueue.addCommand(new MoveToLocationXY(-1.0, -2.0, 1.0));
                    m_robotQueue.addCommand(new RotateDegrees(180.0, 22.5));

                    System.out.println("\n-------- Entering Main Robot State --------");
                    this.setRobotState(RobotState.IdleWaitingForCommandState);
                }
                break;
            case IdleWaitingForCommandState:
                if (m_robotQueue.isCommandPending()) {

                    m_currentCommand = m_robotQueue.getNextCommand();

                    // m_currentCommand is a generic Object. Let's see what it actually is...
                    String commandName = m_currentCommand.getClass().toString();
                    System.out.println("* Got new command. Processing: " + commandName);

                    // Change robot state depending on the type of command we found.
                    switch (commandName) {
                        // NOTE: This "class xyz" text compare is kind of weird,
                        // We could probably find a better way.
                        case "class commands.MoveToLocationXY":
                            this.setRobotState(RobotState.MovingToLocationState);
                            break;
                        case "class commands.RotateDegrees":
                            this.setRobotState(RobotState.RotatingState);
                            break;
                        default:
                            System.out.println("Unrecognized command " + commandName);
                    }
                    System.out.println();

                } else if (m_currentCommand != null) {
                    m_currentCommand = null; // Doing nothing. Clear current command.
                }
                break;
            case MovingToLocationState:
                MoveToLocationXY moveCmd = (MoveToLocationXY) m_currentCommand;
                try {
                    if (moveCmd.runUntilComplete()) {
                        // Done moving, process next item in command queue
                        this.setRobotState(RobotState.IdleWaitingForCommandState);
                    }
                } catch (InterruptedException e) { // for Thread.sleep - demo only
                    e.printStackTrace();
                }
                break;
            case RotatingState:
                RotateDegrees rotateCmd = (RotateDegrees) m_currentCommand; // Cast to correct type.
                try {
                    if (rotateCmd.runUntilComplete()) {
                        // Done moving, process next item in command queue
                        this.setRobotState(RobotState.IdleWaitingForCommandState);
                    }
                } catch (InterruptedException e) { // for Thread.sleep - demo only
                    e.printStackTrace();
                }
                break;
            case SearchingForTargetsState:
                // TODO - implement SearchTarget demo behavior
                break;
        }
    }

    /**
     * Perform tasks that happen ONCE at robot power up
     * @return true if complete, false otherwise
     */
    public boolean doPowerUpStuff() {
        System.out.println("* Performing robot stuff that we would do on power up.");
        // Home motors, move stuff to starting position, etc.
        // System.out.println("Robot wheelbase in inches: " + m_robotGeometry.wheelbaseInches);
        return true;
    }

    /**
     * Clear robot's session data, e.g. location of items found, etc.
     * @return true if complete, false otherwise
     */
    public boolean initializeData() {
        m_robotData.clear(); // Data that we store "per game session"
        System.out.println("* Cleared robot data");
        return true;
    }
}
