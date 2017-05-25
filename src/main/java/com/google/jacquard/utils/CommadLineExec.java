package com.google.jacquard.utils;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;


public class CommadLineExec {

    ExtentTest test;


    public CommadLineExec(){



    }


    public CommadLineExec(ExtentTest test){

        this.test =test;

    }

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
commadLineExec.getcurrenCPUUsage();





    }




    public void initBatteryData(){

        test.log(LogStatus.INFO,"Clearing battery data");

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

    test.log(LogStatus.INFO,"printing the data to the file");

    Runtime rt = Runtime.getRuntime();
    String file = "C:\\batteryReports\\"+name+".txt";

    System.out.println("executing command "+ file );
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


public void clearAllappdata(){
    Runtime rt = Runtime.getRuntime();

//    test.log(LogStatus.INFO,"clearing the app data");
    System.out.println("Clearing application data");
    String[] commands = {"cmd", "/c", "adb shell"+" pm clear "+"com.google.atap.jacquard"};

    try {
        Process pr = rt.exec(commands);
    } catch (IOException e) {
        e.printStackTrace();
    }


}

    public ArrayList<String> getCommandLineOutPut(String [] command){
        Runtime rt = Runtime.getRuntime();

        ArrayList<String> content = new ArrayList<String>();
        String line = null;
        String [] cpuUsageDueToApp = {"cmd", "/c", "adb shell dumpsys cpuinfo | findstr com.google.atap.jacquard"};
        try {
            Process proc = rt.exec(command);
            BufferedReader br = new BufferedReader(
                    new InputStreamReader(proc.getInputStream()));

            try {
                while ((line = br.readLine()) != null) {
                      // test.log(LogStatus.INFO,"Current "+line.toString());
                   System.out.println(line);
                   if (line!=null){
                content.add(line);
                   }

                }
            } catch (IOException e) {
                e.printStackTrace();
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

//        if (line!=null) {
//
//            return line;
//        }else{
//
//            return "Command output not found ";
//        }

        for (String s : content) {
            System.out.println(s);


        }

        return content;
}


    public String getVotageInfo(){
        String[] commands_level = {"cmd", "/c", "adb shell dumpsys battery | findstr level"};
        ArrayList<String> batteryLevel = getCommandLineOutPut(commands_level);
        return batteryLevel.get(0);

    }




    public String getcurrentBatteryLevel(){
    String[] commands_level = {"cmd", "/c", "adb shell dumpsys battery | findstr level"};
        ArrayList<String> batteryLevel = getCommandLineOutPut(commands_level);

        if (batteryLevel.size()!=0) {
            return batteryLevel.get(0);
        }else{

            return "ADB error in getting battery info";
        }

    }

    public String getcurrentBatteryTemperature(){
        String[] commands_temp = {"cmd", "/c", "adb shell dumpsys battery | findstr temperature"};

        ArrayList<String> batteryLevel = getCommandLineOutPut(commands_temp);
        return batteryLevel.get(0);
    }


    public String getcurrenCPUUsage(){
        String [] cpuUsageDueToApp = {"cmd", "/c", "adb shell dumpsys cpuinfo | findstr com.google.atap.jacquard"};

        ArrayList<String> batteryLevel = getCommandLineOutPut(cpuUsageDueToApp);
        if (batteryLevel.size()!= 0){
            System.out.println(batteryLevel.get(0));
            String val = batteryLevel.get(0);

        return val;
    }else{

            return "Application is not consuming CPU ";
        }
    }



public ArrayList<String> getCurrentBatteryStatsNew(){
    Runtime rt = Runtime.getRuntime();
    String line = null;
    String [] cpuUsageDueToApp = {"cmd", "/c", "adb shell dumpsys cpuinfo | findstr com.google.atap.jacquard"};
    String[] commands_level = {"cmd", "/c", "adb shell dumpsys battery | findstr level"};
    String[] command_voltage = {"cmd", "/c", "adb shell dumpsys battery | findstr voltage"};
    String[] commands_temp = {"cmd", "/c", "adb shell dumpsys battery | findstr temperature"};


ArrayList<String> Data = new ArrayList<String>();

Data.add(getCommandLineOutPut(commands_level).toString());
Data.add(String.valueOf(getCommandLineOutPut(commands_temp)));
Data.add(String.valueOf(getCommandLineOutPut(cpuUsageDueToApp)));

   // test.log(LogStatus.INFO, "Current "+getCommandLineOutPut(cpuUsageDueToApp));





//    System.out.println(getCommandLineOutPut(cpuUsageDueToApp));
//    test.log(LogStatus.INFO, "Current "+getCommandLineOutPut(commands_level));
//    test.log(LogStatus.INFO, "Current "+getCommandLineOutPut(commands_temp));
//    test.log(LogStatus.INFO, "Current "+getCommandLineOutPut(cpuUsageDueToApp));
//    test.log(LogStatus.INFO, "Current "+getCommandLineOutPut(command_voltage));




//    System.out.println(getCommandLineOutPut(commands_level));
//    System.out.println(command_voltage);
//    System.out.println(getCommandLineOutPut(commands_temp));
//    System.out.println(getCommandLineOutPut(command_voltage));

    return Data;
}


public void getCurrentBatteryStats(){

    Runtime rt = Runtime.getRuntime();

    String[] commands_level = {"cmd", "/c", "adb shell dumpsys battery | findstr level"};
    String[] command_voltage = {"cmd", "/c", "adb shell dumpsys battery | findstr voltage"};
    String[] commands_temp = {"cmd", "/c", "adb shell dumpsys battery | findstr temperature"};
    String [] cpuUsageDueToApp = {"cmd", "/c", "adb shell dumpsys cpuinfo | findstr com.google.atap.jacquard"};

    try {
        Process proc = rt.exec(commands_level);
        BufferedReader br = new BufferedReader(
                new InputStreamReader(proc.getInputStream()));
        String line;
        try {
            while ((line = br.readLine()) != null) {
                //   test.log(LogStatus.INFO,"Current "+line.toString());
                System.out.println(line);
               //  break;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    } catch (IOException e) {
        e.printStackTrace();
    }


    try {
        Process proc = rt.exec(cpuUsageDueToApp);
        BufferedReader br = new BufferedReader(
                new InputStreamReader(proc.getInputStream()));
        String line;
        try {
            while ((line = br.readLine()) != null)
               // test.log(LogStatus.INFO,"Current CPU usage: "+line.toString());
                System.out.println(line);
        }
        catch (IOException e) {
            e.printStackTrace();
        }

    } catch (IOException e) {
        e.printStackTrace();
    }


    try {
        Process proc = rt.exec(command_voltage);
        BufferedReader br = new BufferedReader(
                new InputStreamReader(proc.getInputStream()));
        String line;
        try {
            while ((line = br.readLine()) != null)
                //test.log(LogStatus.INFO,"Current Battery: "+line.toString());
                System.out.println(line);
        } catch (IOException e) {
            e.printStackTrace();
        }

    } catch (IOException e) {
        e.printStackTrace();
    }



    try {
        Process proc = rt.exec(commands_temp);
        BufferedReader br = new BufferedReader(
                new InputStreamReader(proc.getInputStream()));
        String line;
        try {
            while ((line = br.readLine()) != null)
                //test.log(LogStatus.INFO,"Current "+line.toString());
                System.out.println(line);
        } catch (IOException e) {
            e.printStackTrace();
        }

    } catch (IOException e) {
        e.printStackTrace();
    }



}


      public void generateBatteryHistorianGraph(String name){


//          test.log(LogStatus.INFO,"Generating the batteryHistorian graph");

          Runtime rt = Runtime.getRuntime();
          String batteryHistorian = "C:\\Python27\\battery-historian-master\\battery-historian-master\\scripts\\historian.py";
          String file = "C:\\batteryReports\\"+name+".txt";
          String outputfile = "C:\\batteryReports\\"+name+".html";



          //python historian.py batterystats.txt > batterystats.html
         // System.out.println("executing command "+ file );
         // test.log(LogStatus.INFO,"Generating the batteryHistorian graph "+outputfile);
          String[] commands = {"cmd", "/c", "python "+batteryHistorian+" "+file," > ",outputfile };

          try {
              Process pr = rt.exec(commands);
          } catch (IOException e) {
              e.printStackTrace();
          }


      }

}
