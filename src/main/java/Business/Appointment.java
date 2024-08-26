package Business;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

/**********
     * Creates an appointment object that can select, insert, update and delete records
     * from the database Appointments table
     */
public class Appointment {
    

    
    /******
     * Creates an appointment object with blank fields for its properties. Creates
     * dentist and procedure object which also instantiates these objects with empty strings for it's properties values.
     */
    public Appointment() {
        procCode = "";
        apptDateTime = "";
        patId = "";
        dentId = "";
        dentist = new Dentist();
        procedure = new Procedure();
    }
    
    
    /*******
     * Instantiates a new appointment object with the parameters provided. 
     * @param procCode
     * @param apptDateTime
     * @param patId
     * @param dentId 
     */
    public Appointment(String procCode, String apptDateTime, String patId, String dentId) {
        this.procCode = procCode;
        this.apptDateTime = apptDateTime;
        this.patId = patId;
        this.dentId = dentId;
    }
    
    private String procCode;
    private String apptDateTime;
    private String patId;
    private String dentId;
    private Dentist dentist;
    private Procedure procedure;
    public String getProcCode() {
        return procCode;
    }
    public Dentist getDentist() {
        return dentist;
    }
    public void setProcCode(String procCode) {
        this.procCode = procCode;
    }
    public String getApptDateTime() {
        return apptDateTime;
    }
    public void setApptDateTime(String apptDateTime) {
        this.apptDateTime = apptDateTime;
    }
    public String getPatId() {
        return patId;
    }
    public void setPatId(String patId) {
        this.patId = patId;
    }
    public String getDentId() {
        return dentId;
    }
    public void setDentId(String dentId) {
        this.dentId = dentId;
    }
    public Procedure getProcedure() {
        return procedure;
    }
        public void setProcedure() {
        procedure.setProcCode(getProcCode());
        procedure.selectDB();
    }
        /****
         * Sets appointment's dentist object by calling on the dentist object's 
         * selectDBnoAList() method. This converts its properties from blank strings to the data in the database.
         */
    public void setDentist() {
        dentist.setId(getDentId());
        dentist.selectDBnoAList();
    }
   /*********
    * takes in a appointment object and sets it's properties and its objects properties to empty strings 
    * @param aptObj
    * 
    */
    public void cleanSlate(Appointment aptObj) {
        aptObj.setApptDateTime("");
        aptObj.setDentId("");
        aptObj.setPatId("");
        aptObj.setProcCode("");
        aptObj.getDentist().setEmail("");
        aptObj.getDentist().setFirstName("");
        aptObj.getDentist().setLastName("");
        aptObj.getDentist().setId("");
        aptObj.getDentist().setOffice("");
        aptObj.getProcedure().setProcCode("");
        aptObj.getProcedure().setProcDesc("");
        aptObj.getProcedure().setProcName("");
        aptObj.getProcedure().setCost(0);

    }
    
    /**********
     * selects from appointments table the record that matches patId  
     * then sets this objects properties to the data from the query.
     */
    public void selectDB() {
        try {
            Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
            String conURL = "jdbc:ucanaccess:///Users/jasonwilsonrodriguez/Desktop/DESKDOCS/CIST2373/FinalProject/DentistOfficeACCDB.accdb";
            Connection con = DriverManager.getConnection(conURL);
            Statement stmt = con.createStatement();
            String sql = "select * from Appointments where patId = '" + getPatId() + "';";
            ResultSet rs = stmt.executeQuery(sql);
            rs.next();
            setProcCode(rs.getString(1));
            setApptDateTime(rs.getString(2));
            setPatId(rs.getString(3));
            setDentId(rs.getString(4));
            setDentist();
            setProcedure();
            con.close();
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("THIS RAN");
        }
    }
    /**
     * Inserts into appointments table a new record with the same values as this objects properties.
     */
    public void insertDB() {
        try {
            Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
            String conURL = "jdbc:ucanaccess:///Users/jasonwilsonrodriguez/Desktop/DESKDOCS/CIST2373/FinalProject/DentistOfficeACCDB.accdb";
            Connection con = DriverManager.getConnection(conURL);
            Statement stmt = con.createStatement();
            String sql = "insert into Appointments "
                        +"VALUES ( '" + getProcCode() + "', '" + getApptDateTime() + "', '" + getPatId() + "', '" 
                    + getDentId() + "');";
            stmt.executeUpdate(sql);
            
            con.close();
        } catch (Exception e) {
        }
       
    }
    /**
     * Takes this objects patId and deletes the record that matches patId in the appointments table
     */
    public void deleteDB() {
        try {
            Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
            String conURL = "jdbc:ucanaccess:///Users/jasonwilsonrodriguez/Desktop/DESKDOCS/CIST2373/FinalProject/DentistOfficeACCDB.accdb";
            Connection con = DriverManager.getConnection(conURL);
            Statement stmt = con.createStatement();
            String sql = "delete from Appointments where patId = '" + getPatId() + "';";
            stmt.executeUpdate(sql);
            con.close();
            cleanSlate(this);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    /***
     * Updates the record with this objects patId with the values that this object has.
     */
    public void updateDB() {
        try {
            Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
            String conURL = "jdbc:ucanaccess:///Users/jasonwilsonrodriguez/Desktop/DESKDOCS/CIST2373/FinalProject/DentistOfficeACCDB.accdb";
            Connection con = DriverManager.getConnection(conURL);
            String sql = "UPDATE Appointments " +
                              "SET procCode = " + "'" + getProcCode() + "', " +
                              "apptDateTime = " + "'" + getApptDateTime() + "', " +
                              "patId = " + "'" + getPatId() + "', " +
                              "dentId = " + "'" + getDentId() + "' " +
                              "WHERE patId = '" + getPatId() + "';";
            Statement stmt = con.createStatement();
            stmt.executeUpdate(sql);
            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    /****
     * Testing method to print this objects properties
     */
    public void displayRecord() {
        System.out.println("procCode: " + getProcCode());
        System.out.println("appDateTime: " + getApptDateTime());
        System.out.println("patId: " + getPatId());
        System.out.println("dentId: " + getDentId());
        //System.out.println("Dentist Name: " + dentist.getFirstName() + " " + dentist.getLastName());
    }
    /****
     * Testing method to display the whole appointments table
     */
    public void displayTable() {
        try {
            Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
            String conURL = "jdbc:ucanaccess:///Users/jasonwilsonrodriguez/Desktop/DESKDOCS/CIST2373/FinalProject/DentistOfficeACCDB.accdb";
            Connection con = DriverManager.getConnection(conURL);
            Statement stmt = con.createStatement();
            String sql = "select * from Appointments;";
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                System.out.println("procCode: " + rs.getString(1));
                System.out.println("apptDateTime: " + rs.getString(2));
                System.out.println("patId: " + rs.getString(3));
                System.out.println("dentId: " + rs.getString(4));
                System.out.println("_________________________________");
            }
            con.close();
        } catch (Exception e) {
        }
    }
}
