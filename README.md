# example-state-machine
Example Java state machine for FTC 9915


To run, import the project then run Main.java from IntelliJ or Android Studio.


## Example Output
* In this example, the robot "moves" twice, then "rotates" once, as an example command queue.
```
Example State Machine + Command Queue Application
Current robot state: PoweringUpState
* Performing robot stuff that we would do on power up.
*** Changed state: PoweringUpState -> InitializingDataState
Current robot state: InitializingDataState
* Cleared robot data
-------- Populating Command Queue --------
* Queue: added Move To Location 1.0, 2.0 speed 2.0
* Queue: added Move To Location -1.0, -2.0 speed 1.0
* Queue: added Rotate degrees: 180.0 speed 22.5

-------- Entering Main Robot State --------
*** Changed state: InitializingDataState -> IdleWaitingForCommandState
Current robot state: IdleWaitingForCommandState
* Got new command. Processing: class commands.MoveToLocationXY
*** Changed state: IdleWaitingForCommandState -> MovingToLocationState

Current robot state: MovingToLocationState
* Moving to location 1.0, 2.0
* Completed Move To Location 1.0, 2.0 speed 2.0
*** Changed state: MovingToLocationState -> IdleWaitingForCommandState
Current robot state: IdleWaitingForCommandState
* Got new command. Processing: class commands.MoveToLocationXY
*** Changed state: IdleWaitingForCommandState -> MovingToLocationState

Current robot state: MovingToLocationState
* Moving to location -1.0, -2.0
* Completed Move To Location -1.0, -2.0 speed 1.0
*** Changed state: MovingToLocationState -> IdleWaitingForCommandState
Current robot state: IdleWaitingForCommandState
* Got new command. Processing: class commands.RotateDegrees
*** Changed state: IdleWaitingForCommandState -> RotatingState

Current robot state: RotatingState
* RotatingState... 
* Completed Rotate degrees: 180.0 speed 22.5
*** Changed state: RotatingState -> IdleWaitingForCommandState
Current robot state: IdleWaitingForCommandState
Current robot state: IdleWaitingForCommandState
```
