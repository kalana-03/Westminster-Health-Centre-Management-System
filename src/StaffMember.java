
public abstract class StaffMember {
    private String uniqueID;
    private String name;
    private String surName;
    private String dob;
    private String contactNo;

    public StaffMember(String uniqueID, String name, String surName, String contactNo, String dob) {
        this.uniqueID = uniqueID;
        this.name = name;
        this.surName = surName;
        this.contactNo = contactNo;
        this.dob = dob;
    }

    public String getUniqueID() {
        return uniqueID;
    }

    public void setUniqueID(String uniqueID) {
        this.uniqueID = uniqueID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurName() {
        return surName;
    }

    public void setSurName(String surName) {
        this.surName = surName;
    }

    public String getDob() {
        return dob;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }

    public String getContactNo() {
        return contactNo;
    }

    public void setContactNo(String contactNo) {
        this.contactNo = contactNo;
    }

    public abstract String getRole();

    @Override
    public String toString() {
        return "StaffMember{" +
                "uniqueID='" + uniqueID + '\'' +
                ", name='" + name + '\'' +
                ", surName='" + surName + '\'' +
                ", dob=" + dob +
                ", contactNo='" + contactNo + '\'' +
                '}';
    }
}
