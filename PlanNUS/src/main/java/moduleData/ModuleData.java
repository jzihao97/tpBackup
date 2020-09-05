package moduleData;

import java.io.*;

import com.google.gson.Gson;

public class ModuleData {
//    public static String StreamToString(InputStream in) {
//        ByteArrayOutputStream result = new ByteArrayOutputStream();
//        try {
//            byte[] buffer = new byte[1024];
//            int length;
//            while ((length = in.read(buffer)) != -1) {
//                result.write(buffer, 0, length);
//            }
//
//
//        } catch (IOException ioError){
//            ioError.printStackTrace();
//        }
//        return result.toString();
//    }

    public static void loadModuleInfo() {
        Gson gson = new Gson();

//        try {
            InputStream in = ModuleData.class.getResourceAsStream("/moduleInfo.json");
            Reader jsonReader = new InputStreamReader(in);
            ModuleFullDetails[] moduleFullDetails = gson.fromJson(jsonReader, ModuleFullDetails[].class);
//            BufferedReader bufferedReader = new BufferedReader(jsonReader);
//
//            String currentLine;
//            while ((currentLine = bufferedReader.readLine()) != null) {
//                System.out.println(currentLine);
//            }
//            InputStream in = ModuleData.class.getResource("./moduleInfo.json");
//            System.out.println(Thread.currentThread().getContextClassLoader().getResourceAsStream("moduleInfo.json"));
//            Reader fileReader = new InputStreamReader(in);
//            ModuleFullDetails moduleFullDetails = gson.fromJson(fileReader, ModuleFullDetails.class);
//
//            System.out.println(moduleFullDetails);
//        } catch (IOException ioError) {
//            ioError.printStackTrace();
//        }
    }

    public static void main(String[] args) {
        loadModuleInfo();
    }
}
