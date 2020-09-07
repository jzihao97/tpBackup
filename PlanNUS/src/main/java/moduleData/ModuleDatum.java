package moduleData;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

//    "moduleCode",
//    "title",
//    "moduleCredit",
//    "department",
//    "faculty",
//    "semester"
//    "preclusion",
//    "attibutes" = [
//     su: false, Index 0 of attribute
//     sfs: false, Index 1 of attribute
//     ssgf: false, Index 2 of attribute
//     ism: false, Index 3 of attribute
//     fyp: false, Index 4 of attribute
//     year: false, Index 5 of attribute
//     grsu: false, Index 6 of attribute
//     lab: false, Index 7 of attribute
//     urop: false, Index 8 of attribute
//    ],
//    "prerequisite",
//    "corequisite"

public class ModuleDatum {
    private String moduleCode;
    private String title;
    private Integer moduleCredit;
    private String department;
    private String faculty;
    private List<Integer> semester = new ArrayList<Integer>();
    private String preclusion;
    private List<Boolean> attibutes = new ArrayList<Boolean>();
    private String prerequisite;
    private String corequisite;
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    public String getModuleCode() {
        return moduleCode;
    }

    public void setModuleCode(String moduleCode) {
        this.moduleCode = moduleCode;
    }

    public ModuleDatum withModuleCode(String moduleCode) {
        this.moduleCode = moduleCode;
        return this;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public ModuleDatum withTitle(String title) {
        this.title = title;
        return this;
    }

    public Integer getModuleCredit() {
        return moduleCredit;
    }

    public void setModuleCredit(Integer moduleCredit) {
        this.moduleCredit = moduleCredit;
    }

    public ModuleDatum withModuleCredit(Integer moduleCredit) {
        this.moduleCredit = moduleCredit;
        return this;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public ModuleDatum withDepartment(String department) {
        this.department = department;
        return this;
    }

    public String getFaculty() {
        return faculty;
    }

    public void setFaculty(String faculty) {
        this.faculty = faculty;
    }

    public ModuleDatum withFaculty(String faculty) {
        this.faculty = faculty;
        return this;
    }

    public List<Integer> getSemester() {
        return semester;
    }

    public void setSemester(List<Integer> semester) {
        this.semester = semester;
    }

    public ModuleDatum withSemester(List<Integer> semester) {
        this.semester = semester;
        return this;
    }

    public String getPreclusion() {
        return preclusion;
    }

    public void setPreclusion(String preclusion) {
        this.preclusion = preclusion;
    }

    public ModuleDatum withPreclusion(String preclusion) {
        this.preclusion = preclusion;
        return this;
    }

    public List<Boolean> getAttibutes() {
        return attibutes;
    }

    public void setAttibutes(List<Boolean> attibutes) {
        this.attibutes = attibutes;
    }

    public ModuleDatum withAttibutes(List<Boolean> attibutes) {
        this.attibutes = attibutes;
        return this;
    }

    public String getPrerequisite() {
        return prerequisite;
    }

    public void setPrerequisite(String prerequisite) {
        this.prerequisite = prerequisite;
    }

    public ModuleDatum withPrerequisite(String prerequisite) {
        this.prerequisite = prerequisite;
        return this;
    }

    public String getCorequisite() {
        return corequisite;
    }

    public void setCorequisite(String corequisite) {
        this.corequisite = corequisite;
    }

    public ModuleDatum withCorequisite(String corequisite) {
        this.corequisite = corequisite;
        return this;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }

    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

    public ModuleDatum withAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
        return this;
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(moduleCode).append(title).append(moduleCredit).append(department).append(faculty).append(semester).append(preclusion).append(attibutes).append(prerequisite).append(corequisite).append(additionalProperties).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof ModuleDatum) == false) {
            return false;
        }
        ModuleDatum rhs = ((ModuleDatum) other);
        return new EqualsBuilder().append(moduleCode, rhs.moduleCode).append(title, rhs.title).append(moduleCredit, rhs.moduleCredit).append(department, rhs.department).append(faculty, rhs.faculty).append(semester, rhs.semester).append(preclusion, rhs.preclusion).append(attibutes, rhs.attibutes).append(prerequisite, rhs.prerequisite).append(corequisite, rhs.corequisite).append(additionalProperties, rhs.additionalProperties).isEquals();
    }
}
