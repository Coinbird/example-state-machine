/**
 * Example "data" that the robot might need
 */
public class RobotData {

    // Vision Data
    boolean foundYellowBall;
    boolean foundRedBall;

    // Measurement Data
    boolean measuredWall;
    double distanceToWallMeasured;

    public RobotData() {
        this.clear();
    }

    public void clear() {
        foundRedBall = false;
        foundYellowBall = false;
        measuredWall = false;
        distanceToWallMeasured = 0.0; // warning - be sure to check if negative before doing measurements
    }
}
