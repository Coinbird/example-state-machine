

public class Main {

    public static void main(String[] args) {

        ExampleRobot robot = new ExampleRobot();
        System.out.println("Example State Machine + Command Queue Application");

        // Simulate our Main ExampleRobot Loop
        while(true) { // loop forever, until program stopped
            try {
                System.out.println("Current robot state: " + robot.getRobotStateName());
                Thread.sleep(1000); // Wait 1 second - real robot would read sensors, etc here instead

                robot.runStateMachine();

            } catch (InterruptedException e) { // for Thread.sleep
                e.printStackTrace();
            }

        }
    }
}
