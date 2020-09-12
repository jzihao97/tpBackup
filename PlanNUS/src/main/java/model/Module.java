package model;

public class Module {
    private String moduleCode;
    private int semesterIndex; // 1 to 8
    private String grade;
    private Integer moduleCredit;

    public Module (String moduleCode, int semesterIndex, String grade) {
        setModuleCode(moduleCode);
        setSemesterIndex(semesterIndex);
        setGrade(grade);
    }

    public String getModuleCode() {
        return moduleCode;
    }

    public Integer getModuleCredit() { return moduleCredit;}

    public void setModuleCredit(Integer moduleCredit) { this.moduleCredit = moduleCredit;}

    public void setModuleCode(String moduleCode) {
        this.moduleCode = moduleCode;
    }

    public int getSemesterIndex() {
        return semesterIndex;
    }

    public void setSemesterIndex(int semesterIndex) {
        this.semesterIndex = semesterIndex;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }
}
