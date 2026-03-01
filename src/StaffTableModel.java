import javax.swing.table.AbstractTableModel;
import java.util.ArrayList;

public class StaffTableModel extends AbstractTableModel{
    private ArrayList<StaffMember> staffMembers;
    private String[] columnsName = {"ID", "Name", "Surname", "Role", "Date of Birth", "Contact", "Details"};

    public StaffTableModel(ArrayList<StaffMember> staffMembers){
        this.staffMembers = staffMembers;
    }

    @Override
    public int getRowCount() {
        return staffMembers.size();
    }

    @Override
    public int getColumnCount() {
        return columnsName.length;
    }

    @Override
    public String getColumnName(int column){
        return columnsName[column];
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        StaffMember staff = staffMembers.get(rowIndex);

        switch (columnIndex){
            case 0:
                return staff.getUniqueID();
            case 1:
                return staff.getName();
            case 2:
                return staff.getSurName();
            case 3:
                return staff.getRole();
            case 4:
                return staff.getDob();
            case 5:
                return staff.getContactNo();
            case 6:
                if (staff instanceof Doctor){
                      Doctor doc = (Doctor) staff;
                    return String.format("%s - %d consultations/week",
                            doc.getSpecialisation(), doc.getConsultationsPerWeek());
                } else if (staff instanceof Receptionist) {
                    Receptionist rec = (Receptionist) staff;
                    return String.format("Desk: %s - %d hours/week",
                            rec.getDeskNumber(), rec.getHoursPerWeek());
                }
                return "";
            default:
                return null;
        }
    }

    //update the stafflist
    public void setStaffList(ArrayList<StaffMember> newStaffMembers){
        this.staffMembers = newStaffMembers;
    }

    //get staff member on a specific row 
    public StaffMember getStaffAt(int row){
        if (row >= 0 && row < staffMembers.size()){
            return staffMembers.get(row);
        }
        return null;
    }

    

}
