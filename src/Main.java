import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import java.util.Scanner;

import javax.management.MBeanServer;
import javax.management.ObjectName;
import java.lang.management.ManagementFactory;

import mbeans.AvgPeriod;
import mbeans.ShotCounter;

public class Main {
    public static ResourceBundle bundleDefault = ResourceBundle.getBundle("resources.msgs");

    protected static ShotCounter shotCounterMBean;
    protected static AvgPeriod avgPeriodMBean;


    public static void main(String[] args) {
        try {
            MBeanServer server = ManagementFactory.getPlatformMBeanServer();
            ObjectName avgPeriodName = new ObjectName("smpi_laba4.mbeans:type=AvgPeriod");
            avgPeriodMBean = new AvgPeriod();
            server.registerMBean(avgPeriodMBean, avgPeriodName);
            ObjectName shotName = new ObjectName("smpi_laba4.mbeans:type=ShotCounter");
            shotCounterMBean = new ShotCounter();
            server.registerMBean(shotCounterMBean, shotName);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.exit(1);
        }

        client_io cli = new client_io();

        System.out.println(bundleDefault.getString("welcome"));
        while (!cli.eof()) {
            cli.read_and_execute_command();
        }
    }
}

class HelpCommand {
    public boolean is_equals(String word) {
        if (word == null) word = "";
        return word.equals("help");
    }

    public String execute() {
        String response = "";
        response += "help - " + Main.bundleDefault.getString("help.desc") + "\n";
        response +="shot X Y R - " + Main.bundleDefault.getString("shot.desc") + "\n";
        response +="history - " + Main.bundleDefault.getString("history.desc") + "\n";
        response +="exit - " + Main.bundleDefault.getString("exit.desc") + "\n";
        return response;
    }
}

class ShotCommand {
    public boolean isEquals(String word) {
        if (word == null) word = "";
        return word.equals("shot");
    }

    boolean execute(double x, double y, double r) {
        SimulateShot sim_shot = new SimulateShot(r);
        boolean isHit = sim_shot.shotAt(x, y);
        Main.shotCounterMBean.increment(isHit);
        Main.avgPeriodMBean.addPoint();
        return isHit;
    }
}

class HistoryCommand {
    final private List<String> l_history;

    public HistoryCommand() {
        this.l_history = new ArrayList<String>();
    }

    public boolean isEquals(String word) {
        if (word == null) word = "";
        return word.equals("history");
    }

    public String execute() {
        StringBuilder ss = new StringBuilder();
        for (String shot : l_history) {
            ss.append(shot);
        }
        return ss.toString();
    }

    public void push(String cmd) {
        l_history.add(cmd);
    }
}

class ExitCommand {
    public boolean isEquals(String word) {
        if (word == null) word = "";
        return word.equals("exit");
    }

    void execute() {
        System.exit(0);
    }
}

class client_io {
    Scanner scanner = new Scanner(System.in);

    private boolean               end_of_input;
    private final HelpCommand     cmd_help = new HelpCommand();
    private final ShotCommand     cmd_shot = new ShotCommand();
    private final HistoryCommand  cmd_history = new HistoryCommand();
    private final ExitCommand     cmd_exit = new ExitCommand();

    boolean read_number(String word) {
        try {
            Double.parseDouble(word);
            return true;
        } catch (Exception e) {
            System.out.println(Main.bundleDefault.getString("err.numparse"));
            return false;
        }
    }

    public client_io() {
        this.end_of_input = false;
    }

    boolean eof() {
        return end_of_input;
    }

    void read_and_execute_command() {
        String word;

        word = scanner.nextLine();
        if (cmd_exit.isEquals(word)) {

            cmd_exit.execute();
            end_of_input = true;

        } else if (cmd_help.is_equals(word)) {

            System.out.println(cmd_help.execute());

        } else if (cmd_shot.isEquals(word)) {
            boolean isSuccess = false;

            String maybeNumber;
            double arg1 = 0;
            double arg2 = 0;
            double arg3 = 0;

            maybeNumber = scanner.nextLine();
            if (read_number(maybeNumber)) {
                arg1 = Double.parseDouble(maybeNumber);
                maybeNumber = scanner.nextLine();
                if (read_number(maybeNumber)) {
                    arg2 = Double.parseDouble(maybeNumber);
                    maybeNumber = scanner.nextLine();
                    if (read_number(maybeNumber)) {
                        arg3 = Double.parseDouble(maybeNumber);
                        if (arg3 > 0) {
                            isSuccess = true;
                        } else {
                            System.out.println(Main.bundleDefault.getString("err.wrong-radius"));
                        }
                    }
                }
            }
            if (isSuccess) {
                String ss = "";
                ss += Main.bundleDefault.getString("shot.shot") + " " + arg1 + " " + arg2 + " "  + arg3 + " ";
                boolean success = cmd_shot.execute(arg1, arg2, arg3);
                ss +=  success
                        ? Main.bundleDefault.getString("shot.hit") + "\n"
                        : Main.bundleDefault.getString("shot.missed") + "\n";
                System.out.println(success
                        ? Main.bundleDefault.getString("shot.hit") + "\n"
                        : Main.bundleDefault.getString("shot.missed") + "\n");
                cmd_history.push(ss);
            } else {
                System.out.println();
            }

        } else if (cmd_history.isEquals(word)) {

            System.out.println(cmd_history.execute());

        } else {
            System.out.println(Main.bundleDefault.getString("err.unknown-cmd") + " " + word + "\n");
        }
    }
}
