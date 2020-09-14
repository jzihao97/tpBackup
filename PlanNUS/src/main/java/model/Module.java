package model;

public class Module {
    private String moduleCode;
    private int semesterIndex; // 1 to 8
    private String grade;
    private int moduleCredit;

    public Module (String moduleCode, int semesterIndex, String grade, int moduleCredit) {
        setModuleCode(moduleCode);
        setSemesterIndex(semesterIndex);
        setGrade(grade);
        setModuleCredit(moduleCredit);
    }

    public String getModuleCode() {
        return moduleCode;
    }

    public Integer getModuleCredit() {
        return moduleCredit;
    }

    public String getGrade() {
        return grade;
    }

    public int getSemesterIndex() {
        return semesterIndex;
    }

    public void setModuleCredit(int moduleCredit) {
        this.moduleCredit = moduleCredit;
    }

    public void setModuleCode(String moduleCode) {
        this.moduleCode = moduleCode;
    }

    public void setSemesterIndex(int semesterIndex) {
        this.semesterIndex = semesterIndex;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }
}
