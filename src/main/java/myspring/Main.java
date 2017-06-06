package myspring;

/**
 * Created by Evegeny on 06/06/2017.
 */
public class Main {
    public static void main(String[] args) throws InstantiationException, IllegalAccessException {
        IRobot iRobot = ObjectFactory.getInstance().createObject(IRobot.class);
        iRobot.cleanRoom();
    }
}
