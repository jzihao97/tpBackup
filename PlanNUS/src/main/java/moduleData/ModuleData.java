package moduleData;

import com.google.gson.Gson;

import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;
import java.io.InputStreamReader;

public class ModuleData {
    public static ModuleDatum[] loadModuleInfo() {
//        try {
            Gson gson = new Gson();

            InputStream in = ModuleData.class.getResourceAsStream("/moduleData.json");
            Reader jsonReader = new InputStreamReader(in);
            ModuleDatum[] moduleFullDetails = gson.fromJson(jsonReader, ModuleDatum[].class);

            /** Uncomment below for testing purposes */
//        for (int i = 0; i < moduleFullDetails.length; i++) {
//            System.out.println(moduleFullDetails[i].toString());
//        }

            return moduleFullDetails;
//        } catch (NullPointerException nullError) {
//            System.out.println("File is missing");
//        }
    }

    public static void main(String[] args) {
        ModuleDatum[] allModules = loadModuleInfo();

        /** Uncomment below for testing purposes */
        for (int i = 0; i < allModules.length; i++) {
            System.out.println(allModules[i].toString());
        }
    }
}
