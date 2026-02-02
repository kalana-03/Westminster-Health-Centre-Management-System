import java.time.LocalDate;

public class Receptionist extends StaffMember{
    private int deskNumber;
    private int hoursPerWeek;

    public Receptionist(String uniqueID, String name, String surName, String contactNo, String dob, int deskNumber, int hoursPerWeek){
        super(uniqueID,name, surName, contactNo, dob);
        this.deskNumber = deskNumber;
        this.hoursPerWeek = hoursPerWeek;

    }

    public int getDeskNumber() {
        return deskNumber;
    }

    public void setDeskNumber(int deskNumber) {
        this.deskNumber = deskNumber;
    }

    public int getHoursPerWeek() {
        return hoursPerWeek;
    }

    public void setHoursPerWeek(int hoursPerWeek) {
        this.hoursPerWeek = hoursPerWeek;
    }

    @Override
    public String getRole(){
        return "Receptionist";
    }

    @Override
    public String toString() {
        return super.toString() +
                "deskNumber=" + deskNumber +
                ", hoursPerWeek=" + hoursPerWeek ;
    }
}
