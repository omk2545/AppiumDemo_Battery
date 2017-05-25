package rough;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by okulkarni on 12/22/2016.
 */
public class CommadLineExec {


    public static void main(String a[]) throws IOException {
















////        System.out.println("Hello");
//
//        final List<String> commands = new ArrayList<String>();
//        commands.add("cmd");
//        commands.add("appium - h"); // second commandline argument
//     //   commands.add(input3);// third commandline agrument
//        ProcessBuilder pb = new ProcessBuilder(commands);


        String port;

String startservercmd = "adb shell dumpsys batterystats --reset ";
       // startAppiumServer()


CommadLineExec commadLineExec = new CommadLineExec();
commadLineExec.printBatteryData("test");





    }




    public void initBatteryData(){


              // String command  = "appium -a 127.0.0.1 -p"+port +"--no-reset -U"+deviceId;
        String command  = "adb shell dumpsys batterystats --reset";
        //String startservercmd = "appium -a 127.0.0.1 -p 4739 --no-reset -U LS4503";
        Runtime rt = Runtime.getRuntime();
        // rt.exec(new String[]{"cmd.exe","/c","start"});

        try {
            System.out.println("Battery init");
            rt.exec("cmd.exe /c start "+command);
            //rt.
        } catch (IOException e) {
            e.printStackTrace();
        }


    }

public void printBatteryData(String name) {

    Runtime rt = Runtime.getRuntime();
    String file = "C:\\batteryReports\\"+name+".txt";

    System.out.println("executing command " );
    String[] commands = {"cmd", "/c", "adb shell dumpsys batterystats"," > " ,file };

    try {
        Process pr = rt.exec(commands);
    } catch (IOException e) {
        e.printStackTrace();
    }


//    String command  = "adb shell dumpsys batterystats ";
//
//    Runtime rt = Runtime.getRuntime();
//    // rt.exec(new String[]{"cmd.exe","/c","start"});
//
//    try {
//        System.out.println("Battery report generation ");
//        rt.exec("cmd.exe /c start "+command);
//    } catch (IOException e) {
//        e.printStackTrace();
//    }
//}


}

}
