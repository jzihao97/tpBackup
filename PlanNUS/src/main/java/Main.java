import model.Person;
import moduledata.ModuleDatum;
import moduledata.ModuleInitializer;

public class Main {
    public static void main(String[] args) {
//        ModuleInitializer allModules =  new ModuleInitializer();
//        Integer idx = allModules.getModuleMap().get("CS1010");
//        ModuleDatum cs1010Data = allModules.getModuleFullDetails()[idx];
//
//        System.out.println(cs1010Data.toString());
        Person Bob = new Person("Bob" , 3);
        System.out.println("Oi type la");
        Bob.addModule();
        System.out.println(Bob.toString());
        Bob.printList();
    }
}
