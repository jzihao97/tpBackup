import model.CAPlist;
import moduledata.ModuleDatum;
import moduledata.ModuleInitializer;

import java.text.DecimalFormat;
import java.math.RoundingMode;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
//        ModuleInitializer allModules =  new ModuleInitializer();
//        Integer idx = allModules.getModuleMap().get("CS1010");
//        ModuleDatum cs1010Data = allModules.getModuleFullDetails()[idx];
//
//        System.out.println(cs1010Data.toString());

        CAPlist CAPlist = new CAPlist();
        CAPlist.setInitialCAP();
        CAPlist.setCurrentCAP();
        CAPlist.setTargetCAP();
//        CAPlist.setSUs(); WORK IN PROCESS!!
    }
}
