package commands;

public class MoveToLocationXY extends RobotCommand {

    private double m_xLocation;
    private double m_yLocation;
    private double m_speed;

    public MoveToLocationXY(double xLocationInches, double yLocationInches, double speedInchesPerSecond) {
        this.commandDescription = "Move To Location " + xLocationInches + ", " + yLocationInches + " speed " + speedInchesPerSecond;
        m_xLocation = xLocationInches;
        m_yLocation = yLocationInches;
        m_speed = speedInchesPerSecond;
    }

    public boolean runUntilComplete() throws InterruptedException {
        // Example function
        // Check if we reached the position?
        // Real code wouldn't block here - sleep is for demonstration
        // InterruptedException could be used for malfunctions during movement
        System.out.println("* Moving to location " + m_xLocation + ", " + m_yLocation );
        Thread.sleep(1000);
        System.out.println("* Completed " + this.commandDescription);
        return true;
    }
}
