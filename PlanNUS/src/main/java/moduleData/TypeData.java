package moduleData;

import java.util.HashMap;
import java.util.Map;

/** Module type are listed below
    "su",
    "sfs",
    "ssgf",
    "ism",
    "fyp",
    "year",
    "grsu",
    "lab",
    "urop"
 */

public class TypeData {
    private Boolean su;
    private Boolean sfs;
    private Boolean ssgf;
    private Boolean ism;
    private Boolean fyp;
    private Boolean year;
    private Boolean grsu;
    private Boolean lab;
    private Boolean urop;
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();
    public Boolean getSu() {
        return su;
    }
    public void setSu(Boolean su) {
        this.su = su;
    }

    public TypeData withSu(Boolean su) {
        this.su = su;
        return this;
    }

        public Boolean getSfs() {
        return sfs;
    }

        public void setSfs(Boolean sfs) {
        this.sfs = sfs;
    }

    public TypeData withSfs(Boolean sfs) {
        this.sfs = sfs;
        return this;
    }

    public Boolean getSsgf() {
        return ssgf;
    }

    public void setSsgf(Boolean ssgf) {
        this.ssgf = ssgf;
    }

    public TypeData withSsgf(Boolean ssgf) {
        this.ssgf = ssgf;
        return this;
    }

    public Boolean getIsm() {
        return ism;
    }

    public void setIsm(Boolean ism) {
        this.ism = ism;
    }

    public TypeData withIsm(Boolean ism) {
        this.ism = ism;
        return this;
    }

    public Boolean getFyp() {
        return fyp;
    }

    public void setFyp(Boolean fyp) {
        this.fyp = fyp;
    }

    public TypeData withFyp(Boolean fyp) {
        this.fyp = fyp;
        return this;
    }

    public Boolean getYear() {
        return year;
    }

    public void setYear(Boolean year) {
        this.year = year;
    }

    public TypeData withYear(Boolean year) {
        this.year = year;
        return this;
    }

    public Boolean getGrsu() {
        return grsu;
    }

    public void setGrsu(Boolean grsu) {
        this.grsu = grsu;
    }

    public TypeData withGrsu(Boolean grsu) {
        this.grsu = grsu;
        return this;
    }

    public Boolean getLab() {
        return lab;
    }

    public void setLab(Boolean lab) {
        this.lab = lab;
    }

    public TypeData withLab(Boolean lab) {
        this.lab = lab;
        return this;
    }

    public Boolean getUrop() {
        return urop;
    }

    public void setUrop(Boolean urop) {
        this.urop = urop;
    }

    public TypeData withUrop(Boolean urop) {
        this.urop = urop;
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
//    public TypeData withAdditionalProperty(String name, Object value) {
//        this.additionalProperties.put(name, value);
//        return this;
//    }
//
//    @Override
//    public int hashCode() {
//        return new HashCodeBuilder().append(su).append(sfs).append(ssgf).append(ism).append(fyp).append(year).append(grsu).append(lab).append(urop).append(additionalProperties).toHashCode();
//    }
//
//    @Override
//    public boolean equals(Object other) {
//        if (other == this) {
//            return true;
//        }
//        if ((other instanceof TypeData) == false) {
//            return false;
//        }
//        TypeData rhs = ((TypeData) other);
//        return new EqualsBuilder().append(su, rhs.su).append(sfs, rhs.sfs).append(ssgf, rhs.ssgf).append(ism, rhs.ism).append(fyp, rhs.fyp).append(year, rhs.year).append(grsu, rhs.grsu).append(lab, rhs.lab).append(urop, rhs.urop).append(additionalProperties, rhs.additionalProperties).isEquals();
//    }

}
