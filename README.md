# example-state-machine
Example Java state machine for FTC 9915


To run, import the project then run Main.java from IntelliJ or Android Studio.


## Example Output
* In this example, the robot "moves" twice, then "rotates" once, as an example command queue.
```
C:\jdk1.8.0_181\bin\java.exe "-javaagent:C:\Users\Will.Smith\AppData\Roaming\JetBrains\IntelliJ IDEA Community Edition 2018.2.5\lib\idea_rt.jar=62708:C:\Users\Will.Smith\AppData\Roaming\JetBrains\IntelliJ IDEA Community Edition 2018.2.5\bin" -Dfile.encoding=UTF-8 -classpath C:\jdk1.8.0_181\jre\lib\charsets.jar;C:\jdk1.8.0_181\jre\lib\deploy.jar;C:\jdk1.8.0_181\jre\lib\ext\access-bridge-64.jar;C:\jdk1.8.0_181\jre\lib\ext\cldrdata.jar;C:\jdk1.8.0_181\jre\lib\ext\dnsns.jar;C:\jdk1.8.0_181\jre\lib\ext\jaccess.jar;C:\jdk1.8.0_181\jre\lib\ext\jfxrt.jar;C:\jdk1.8.0_181\jre\lib\ext\localedata.jar;C:\jdk1.8.0_181\jre\lib\ext\nashorn.jar;C:\jdk1.8.0_181\jre\lib\ext\sunec.jar;C:\jdk1.8.0_181\jre\lib\ext\sunjce_provider.jar;C:\jdk1.8.0_181\jre\lib\ext\sunmscapi.jar;C:\jdk1.8.0_181\jre\lib\ext\sunpkcs11.jar;C:\jdk1.8.0_181\jre\lib\ext\zipfs.jar;C:\jdk1.8.0_181\jre\lib\javaws.jar;C:\jdk1.8.0_181\jre\lib\jce.jar;C:\jdk1.8.0_181\jre\lib\jfr.jar;C:\jdk1.8.0_181\jre\lib\jfxswt.jar;C:\jdk1.8.0_181\jre\lib\jsse.jar;C:\jdk1.8.0_181\jre\lib\management-agent.jar;C:\jdk1.8.0_181\jre\lib\plugin.jar;C:\jdk1.8.0_181\jre\lib\resources.jar;C:\jdk1.8.0_181\jre\lib\rt.jar;C:\git\example-state-machine\out\production\example-state-machine Main
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
