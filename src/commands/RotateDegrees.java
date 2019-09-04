package commands;

public class RotateDegrees extends RobotCommand {

    private double m_degrees;
    private double m_speed;

    public RotateDegrees(double degrees, double speedDegreesPerSecond) {
        this.commandDescription = "Rotate degrees: " + degrees +  " speed " + speedDegreesPerSecond;
        m_degrees = degrees;
        m_speed = speedDegreesPerSecond;
    }

    public boolean runUntilComplete() throws InterruptedException {
        // Example function
        // Check if we reached the position?
        // Real code wouldn't block here - sleep is for demonstration
        // InterruptedException could be used for malfunctions during movement
        System.out.println("* RotatingState... " );
        Thread.sleep(1000);
        System.out.println("* Completed " + this.commandDescription);

        return true;
    }
}
