package moduleData;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/** Module information are as follow
    "moduleCode",
    "title",
    "description",
    "moduleCredit",
    "department",
    "faculty",
    "workload",
    "semesterData",
    "preclusion",
    "typeData",
    "prerequisite",
    "corequisite"
*/

public class ModuleFullDetails {
    private String moduleCode;
    private String title;
    private String description;
    private String moduleCredit;
    private String department;
    private String faculty;
    private List<Double> workload = new ArrayList<Double>();
    private List<SemExamData> semesterData = new ArrayList<SemExamData>();
    private String preclusion;
    private TypeData typeData;
    private String prerequisite;
    private String corequisite;
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    public String getModuleCode() {
        return moduleCode;
    }


    public void setModuleCode(String moduleCode) {
        this.moduleCode = moduleCode;
    }

    public ModuleFullDetails withModuleCode(String moduleCode) {
        this.moduleCode = moduleCode;
        return this;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public ModuleFullDetails withTitle(String title) {
        this.title = title;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public ModuleFullDetails withDescription(String description) {
        this.description = description;
        return this;
    }

    public String getModuleCredit() {
        return moduleCredit;
    }

    public void setModuleCredit(String moduleCredit) {
        this.moduleCredit = moduleCredit;
    }

    public ModuleFullDetails withModuleCredit(String moduleCredit) {
        this.moduleCredit = moduleCredit;
        return this;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public ModuleFullDetails withDepartment(String department) {
        this.department = department;
        return this;
    }

    public String getFaculty() {
        return faculty;
    }

    public void setFaculty(String faculty) {
        this.faculty = faculty;
    }

    public ModuleFullDetails withFaculty(String faculty) {
        this.faculty = faculty;
        return this;
    }

    public List<Double> getWorkload() {
        return workload;
    }

    public void setWorkload(List<Double> workload) {
        this.workload = workload;
    }

    public ModuleFullDetails withWorkload(List<Double> workload) {
        this.workload = workload;
        return this;
    }

    public List<SemExamData> getSemesterData() {
        return semesterData;
    }

    public void setSemesterData(List<SemExamData> semesterData) {
        this.semesterData = semesterData;
    }

    public ModuleFullDetails withSemesterData(List<SemExamData> semesterData) {
        this.semesterData = semesterData;
        return this;
    }

    public String getPreclusion() {
        return preclusion;
    }

    public void setPreclusion(String preclusion) {
        this.preclusion = preclusion;
    }

    public ModuleFullDetails withPreclusion(String preclusion) {
        this.preclusion = preclusion;
        return this;
    }

    public TypeData getAttributes() {
        return typeData;
    }

    public void setAttributes(TypeData typeData) {
        this.typeData = typeData;
    }

    public ModuleFullDetails withAttributes(TypeData typeData) {
        this.typeData = typeData;
        return this;
    }

    public String getPrerequisite() {
        return prerequisite;
    }

    public void setPrerequisite(String prerequisite) {
        this.prerequisite = prerequisite;
    }

    public ModuleFullDetails withPrerequisite(String prerequisite) {
        this.prerequisite = prerequisite;
        return this;
    }

    public String getCorequisite() {
        return corequisite;
    }

    public void setCorequisite(String corequisite) {
        this.corequisite = corequisite;
    }

    public ModuleFullDetails withCorequisite(String corequisite) {
        this.corequisite = corequisite;
        return this;
    }


    //Below are the funcitons that we might need to change given our use cases, delete accordingly
//    @Override
//    public String toString() {
//        return ToStringBuilder.reflectionToString(this);
//    }
//
//    public Map<String, Object> getAdditionalProperties() {
//        return this.additionalProperties;
//    }
//
//    public void setAdditionalProperty(String name, Object value) {
//        this.additionalProperties.put(name, value);
//    }
//
//    public ModuleFullDetails withAdditionalProperty(String name, Object value) {
//        this.additionalProperties.put(name, value);
//        return this;
//    }
//
//    public int hashCode() {
//        return new HashCodeBuilder().append(moduleCode).append(title).append(description).append(moduleCredit).append(department).append(faculty).append(workload).append(semesterData).append(preclusion).append(typeData).append(prerequisite).append(corequisite).append(additionalProperties).toHashCode();
//    }
//
//    public boolean equals(Object other) {
//        if (other == this) {
//            return true;
//        }
//        if ((other instanceof ModuleFullDetails) == false) {
//            return false;
//        }
//        ModuleFullDetails rhs = ((ModuleFullDetails) other);
//        return new EqualsBuilder().append(moduleCode, rhs.moduleCode).append(title, rhs.title).append(description, rhs.description).append(moduleCredit, rhs.moduleCredit).append(department, rhs.department).append(faculty, rhs.faculty).append(workload, rhs.workload).append(semesterData, rhs.semesterData).append(preclusion, rhs.preclusion).append(typeData, rhs.typeData).append(prerequisite, rhs.prerequisite).append(corequisite, rhs.corequisite).append(additionalProperties, rhs.additionalProperties).isEquals();
//    }
}
