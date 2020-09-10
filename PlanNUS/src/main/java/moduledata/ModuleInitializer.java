package moduledata;

import com.google.gson.Gson;

import java.io.InputStream;
import java.io.Reader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
//import java.util.ArrayList;
//import java.util.Arrays;
//import java.util.List;

public class ModuleInitializer {
    private static Map<String, Integer> moduleMap = new HashMap<>();
    private static ModuleDatum[] moduleFullDetails;

    public static ModuleDatum[] loadModuleInfo() { //Returns all the information of the available modules
//        try {
            Gson gson = new Gson();

            InputStream in = ModuleInitializer.class.getResourceAsStream("/moduleData.json");
            Reader jsonReader = new InputStreamReader(in);
            moduleFullDetails = gson.fromJson(jsonReader, ModuleDatum[].class);

            for (int i = 0; i < moduleFullDetails.length; i++) {
                moduleMap.put(moduleFullDetails[i].getModuleCode(), i);
            }

            /** Uncomment below for testing purposes */
//        for (int i = 0; i < moduleFullDetails.length; i++) {
//            System.out.println(moduleFullDetails.toString());
//            System.out.println(moduleMap.get(moduleFullDetails[i].getModuleCode()));
//        }

        int indexOfCS1231 = moduleMap.get("CS1010");
        System.out.println(indexOfCS1231);
        System.out.println(moduleFullDetails[indexOfCS1231].toString());

            return moduleFullDetails;
//        } catch (NullPointerException nullError) {
//            System.out.println("File is missing");
//        }
    }

    public Map<String, Integer> getModuleMap() {
        return moduleMap;
    }

    public ModuleDatum[] getModuleFullDetails() {
        return moduleFullDetails;
    }

    public static void main(String[] args) {
        ModuleDatum[] allModules = loadModuleInfo();

        System.out.println(allModules[20].getModuleCode());

        /** Uncomment below for testing purposes */
//        for (int i = 0; i < allModules.length; i++) {
//            System.out.println(allModules[i].toString());
//        }
    }
}
