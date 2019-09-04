package commands;

import java.util.LinkedList;
import java.util.Queue;

public class RobotCommandQueue {
    private Queue<RobotCommand> m_queue;


    /**
     * Simple queue, using a Linked List.
     * See https://www.geeksforgeeks.org/queue-interface-java/
     */
    public RobotCommandQueue() {
        m_queue = new LinkedList<>();
    }

    /**
     * Get length of Queue
     * @return size of queue
     */
    public int size() {
        return m_queue.size();
    }

    /**
     * See if there are any robot commands waiting
     * @return true if queue has entries in it
     */
    public boolean isCommandPending() {
        return m_queue.size() > 0;
    }


    /**
     * Add a Robot Command to our command queue
     * @param command Command to add
     * @return true if added, else false
     */
    public boolean addCommand(RobotCommand command) {
        System.out.println("* Queue: added " + command.commandDescription);
        return m_queue.add(command);
    }

    /**
     * Gets next RobotCommand in queue
     * @return Robot Command (removes from queue)
     */
    public RobotCommand getNextCommand() {
        return m_queue.remove();
    }

    /**
     * Peeks at next RobotCommand in queue - does NOT remove from queue
     * @return Robot Command (stays in queue)
     */
    public RobotCommand peekNextCommand() {
        return m_queue.peek();
    }

}
