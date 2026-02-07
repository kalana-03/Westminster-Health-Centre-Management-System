public class Doctor extends StaffMember{
    private String licenceNumber;
    private String specialisation;
    private int consultationsPerWeek;

    public Doctor(String uniqueID, String name, String surName, String contactNo, String dob, String licenceNumber, String specialisation, int consultationsPerWeek){
        super(uniqueID,name, surName, contactNo, dob);
        this.licenceNumber = licenceNumber;
        this.specialisation = specialisation;
        this.consultationsPerWeek = consultationsPerWeek;
    }

    public String getLicenceNumber(){
        return licenceNumber;
    }

    public void setLicenceNumber(String licenceNumber){
        this.licenceNumber = licenceNumber;
    }

    public String getSpecialisation() {
        return specialisation;
    }


    public void setSpecialisation(String specialisation) {
        this.specialisation = specialisation;
    }

    public int getConsultationsPerWeek() {
        return consultationsPerWeek;
    }

    public void setConsultationsPerWeek(int consultationsPerWeek) {
        this.consultationsPerWeek = consultationsPerWeek;
    }

    @Override
    public String getRole(){
        return "Role: Doctor";
    }

    @Override
    public String toString() {
        return  super.toString() +
                "licenceNumber='" + licenceNumber + '\'' +
                ", specialisation='" + specialisation + '\'' +
                ", consultationsPerWeek=" + consultationsPerWeek +
                '}';
    }
}
