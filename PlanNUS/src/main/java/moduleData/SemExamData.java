package moduleData;

import java.util.HashMap;
import java.util.Map;

/** Module semester and exam timing
    "semester",
    "examDate",
    "examDuration"
*/

public class SemExamData {
    private Integer semester;
    private String examDate;
    private Integer examDuration;
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();
    
    public Integer getSemester() {
        return semester;
    }

    public void setSemester(Integer semester) {
        this.semester = semester;
    }

    public SemExamData withSemester(Integer semester) {
        this.semester = semester;
        return this;
    }

    public String getExamDate() {
        return examDate;
    }

    public void setExamDate(String examDate) {
        this.examDate = examDate;
    }

    public SemExamData withExamDate(String examDate) {
        this.examDate = examDate;
        return this;
    }

    public Integer getExamDuration() {
        return examDuration;
    }

    public void setExamDuration(Integer examDuration) {
        this.examDuration = examDuration;
    }

    public SemExamData withExamDuration(Integer examDuration) {
        this.examDuration = examDuration;
        return this;
    }

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
//    public SemExamData withAdditionalProperty(String name, Object value) {
//        this.additionalProperties.put(name, value);
//        return this;
//    }
//
//    @Override
//    public int hashCode() {
//        return new HashCodeBuilder().append(semester).append(examDate).append(examDuration).append(additionalProperties).toHashCode();
//    }
//
//    @Override
//    public boolean equals(Object other) {
//        if (other == this) {
//            return true;
//        }
//        if ((other instanceof SemExamData) == false) {
//            return false;
//        }
//        SemExamData rhs = ((SemExamData) other);
//        return new EqualsBuilder().append(semester, rhs.semester).append(examDate, rhs.examDate).append(examDuration, rhs.examDuration).append(additionalProperties, rhs.additionalProperties).isEquals();
//    }
}
