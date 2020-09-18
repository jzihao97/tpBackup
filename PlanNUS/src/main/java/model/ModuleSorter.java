package model;

import java.util.ArrayList;
import java.util.Collections;

public class ModuleSorter {
    private ArrayList<Module> moduleArrayList = new ArrayList<>();

    public ModuleSorter(ArrayList<Module> moduleArrayList) {
        this.moduleArrayList = moduleArrayList;
    }

    public ArrayList<Module> getSortedModuleByGrades() {
        Collections.sort(moduleArrayList);
        return moduleArrayList;
    }
}
