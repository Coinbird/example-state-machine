package commands;

abstract class RobotCommand {
    public String commandDescription;
    public abstract boolean runUntilComplete() throws InterruptedException;
}
