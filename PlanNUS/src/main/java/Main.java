import model.Person;

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
        Bob.printList();
        Bob.editModule();
        Bob.printList();
        Bob.editModule();
        Bob.printList();
        Bob.removeModule();
        Bob.printList();
    }
}
