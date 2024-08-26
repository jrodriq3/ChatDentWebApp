/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Business;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
/*******************************************************************************
* Creates a patient object that can select, insert,
* update and delete records from the database's Patients
* table.
*******************************************************************************/
public class Patient {
    /***************************************************************************
     * Instantiates patient object and sets it's properties to empty strings or
     * if an object, it instantiates it to it's default value.
     **************************************************************************/
    public Patient() {
        firstName = "";
        lastName = "";
        addr = "";
        email = "";
        insCo = "";
        patId = "";
        passwd = "";
        appointment = new Appointment();
        
    }
    /***************************************************************************
    * Instantiates a patient object and sets it's properties to the values 
    * provided in the parameters.
    ***************************************************************************/
    public Patient(String firstName, String lastName, String addr, String email, String insCo, String patId, String passwd) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.addr = addr;
        this.email = email;
        this.insCo = insCo;
        this.patId = patId;
        this.passwd = passwd;
        
    }
    private String firstName;
    private String lastName;
    private String addr;
    private String email;
    private String insCo;
    private String patId;
    private String passwd;
    private Appointment appointment;
    /***************************************************************************
    * Returns this obj's appointment object
    ***************************************************************************/
    public Appointment getAppointment() {
        return appointment;
    }
    /***************************************************************************
    * Sets this obj's appointment object to the appointment object in the parameter
    ***************************************************************************/
    public void setAppointment(Appointment appointment) {
        this.appointment = appointment;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getAddr() {
        return addr;
    }

    public void setAddr(String addr) {
        this.addr = addr;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getInsCo() {
        return insCo;
    }

    public void setInsCo(String insCo) {
        this.insCo = insCo;
    }

    public String getPatId() {
        return patId;
    }

    public void setPatId(String patId) {
        this.patId = patId;
    }

    public String getPasswd() {
        return passwd;
    }

    public void setPasswd(String passwd) {
        this.passwd = passwd;
    }
    /***************************************************************************
    * Takes this objects appointment object and sets appt objects patId to this
    * objects patId then uses the selectDB method in appt object which then 
    * fills in appt objects fields.
    ***************************************************************************/
    public void setPatAppointment() {
        appointment.setPatId(getPatId());
        appointment.selectDB();
    }
    /***************************************************************************
     * selects from Patients table the record's patId that matches this obj's patId 
     * then sets this objects properties to the data from the query.
     **************************************************************************/
    public void selectDB() {
        try {
            Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
            String conURL = "jdbc:ucanaccess:///Users/jasonwilsonrodriguez/Desktop/DESKDOCS/CIST2373/FinalProject/DentistOfficeACCDB.accdb";
            Connection con = DriverManager.getConnection(conURL);
            Statement stmt = con.createStatement();
            String sql = "select * from Patients where patId = " + "'" + getPatId() + "'" + ";";
            ResultSet rs = stmt.executeQuery(sql);
            rs.next();
            firstName = rs.getString(1);
            lastName = rs.getString(2);
            addr = rs.getString(3);
            email = rs.getString(4);
            insCo = rs.getString(5);
            patId = rs.getString(6);
            passwd = rs.getString(7);
            setPatAppointment();
            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    /***************************************************************************
    * Inserts into Patients table a new record with the same values as this 
    * objects properties.
    ***************************************************************************/
    public void insertDB() {
        try {
            Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
            String conURL = "jdbc:ucanaccess:///Users/jasonwilsonrodriguez/Desktop/DESKDOCS/CIST2373/FinalProject/DentistOfficeACCDB.accdb";
            Connection con = DriverManager.getConnection(conURL);
            Statement stmt = con.createStatement();
            String sql = "insert into Patients "
                        +"VALUES ( '" + getFirstName() + "', '" + getLastName() + "', '" + getAddr() + "', '" 
                    + getEmail() + "', '" + getInsCo() + "', '" + getPatId() + "', '" + getPasswd() + "');";
            stmt.executeUpdate(sql);
            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    /***************************************************************************
    * Updates the record from Patients table whose patId matches this obj's patId,
    * it will use the values from this objects properties to update 
    * the database.
    ***************************************************************************/
    public void updateDB() {
        try {
            Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
            String conURL = "jdbc:ucanaccess:///Users/jasonwilsonrodriguez/Desktop/DESKDOCS/CIST2373/FinalProject/DentistOfficeACCDB.accdb";
            Connection con = DriverManager.getConnection(conURL);
            Statement stmt = con.createStatement();
            String sql = "UPDATE Patients " +
                              "SET firstName = " + "'" + getFirstName() + "', " +
                              "lastName = " + "'" + getLastName() + "', " +
                              "addr = " + "'" + getAddr() + "', " +
                              "email = " + "'" + getEmail() + "', " +
                              "insCo = " + "'" + getInsCo() + "', " +
                              "patId = " + "'" + getPatId() + "', " +
                              "passwd = " + "'" + getPasswd() + "' " +
                              "WHERE patId = '" + getPatId() + "';";
            stmt.executeUpdate(sql);
            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        
    }
    /***************************************************************************
    * Takes this objects patId and deletes the record that matches patId in the 
    * Patients table
    ***************************************************************************/
    public void deleteDB() {
        try {
            Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
            String conURL = "jdbc:ucanaccess:///Users/jasonwilsonrodriguez/Desktop/DESKDOCS/CIST2373/FinalProject/DentistOfficeACCDB.accdb";
            Connection con = DriverManager.getConnection(conURL);
            Statement stmt = con.createStatement();
            String sql = "delete from Patients where patId = '" + getPatId() + "';";
            stmt.executeUpdate(sql);
            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    /***************************************************************************
    * Testing method to print this objects properties.
    ***************************************************************************/
    public void displayRecord() {
        System.out.println("FirstName: " + getFirstName());
        System.out.println("LastName: " + getLastName());
        System.out.println("Address: " + getAddr());
        System.out.println("Email: " + getEmail());
        System.out.println("Insurance: " + getInsCo());
        System.out.println("Patient ID: " + getPatId());
        System.out.println("Password: " + getPasswd());
        System.out.println("");
        System.out.println("Appointment Details: ");
        getAppointment().displayRecord();
    }
    /***************************************************************************
    * Testing method to display the whole Patients table.
    ***************************************************************************/
    public void displayTable() {
        try {
            Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
            String conURL = "jdbc:ucanaccess:///Users/jasonwilsonrodriguez/Desktop/DESKDOCS/CIST2373/FinalProject/DentistOfficeACCDB.accdb";
            Connection con = DriverManager.getConnection(conURL);
            Statement stmt = con.createStatement();
            String sql = "select * from Patients;";
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                System.out.println("FirstName: " + rs.getString(1));
                System.out.println("LastName: " + rs.getString(2));
                System.out.println("Address: " + rs.getString(3));
                System.out.println("Email: " + rs.getString(4));
                System.out.println("Insurance: " + rs.getString(5));
                System.out.println("Patient ID: " + rs.getString(6));
                System.out.println("Password: " + rs.getString(7));
                System.out.println();
            }
            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        
    }
    public static void main(String[] args) {
        Patient p1 = new Patient();
        p1.setPatId("A900");
        p1.selectDB();
        p1.displayRecord();
        
    }
}
