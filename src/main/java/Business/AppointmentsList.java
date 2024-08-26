package Business;

import java.util.ArrayList;
/*******************************************************************************
* This class allows us to build an arrayList of Appointments.
*******************************************************************************/
public class AppointmentsList {
    /***************************************************************************
     * Instantiates appointmentslist obj that contains an arrayList called arrList
     **************************************************************************/
    public AppointmentsList() {
        arrList = new ArrayList<>();
    }
    private ArrayList<Appointment> arrList;
    /***************************************************************************
     * Adds an appointment object to the arrList, uses the parameter appointment
     **************************************************************************/
    public void addAppointment(Appointment appointment) {
        arrList.add(appointment);
    }
    /***************************************************************************
     * Gets the appointment object in arrList at the specified index given from
     * the parameter
     **************************************************************************/
    public Appointment getAppointmentIndex(int i) {
        return arrList.get(i);
    }
    /***************************************************************************
     * Returns the size of arrList
     **************************************************************************/
    public int getAptCount() {
        return arrList.size();
    }
    /***************************************************************************
     * Testing method to print out each appointment in the list
     **************************************************************************/
    public void displayList() {
        for (int i = 0; i < arrList.size(); i++) {
            arrList.get(i).displayRecord();
            System.out.println("");
            
        }
    }
    public static void main(String[] args) {
        AppointmentsList aList = new AppointmentsList();
        Appointment a1 = new Appointment();
        a1.setPatId("A900");
        a1.selectDB();
        /*
        
        
        
        Appointment a2 = new Appointment();
        a2.setPatId("A901");
        a2.selectDB();
        */
        //aList.addAppointment(a1);
        //aList.addAppointment(a2);
        //aList.displayList();
    }
}
