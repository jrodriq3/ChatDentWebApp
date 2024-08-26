package Business;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

/*******************************************************************************
* Creates a dentist object that can select, insert,
* update and delete records from the database's Dentist's
* table.
*******************************************************************************/
public class Dentist {
    /***************************************************************************
     * Instantiates dentist object and sets it's properties to empty strings or
     * if an object it instantiates it to it's default value.
     **************************************************************************/
    public Dentist() {
        firstName = "";
        lastName = "";
        email = "";
        id = "";
        office = "";
        passwd = "";
        aList = new AppointmentsList();
        
    }
    /***************************************************************************
     * Instantiates dentist object and sets it's properties to the values 
     * provided in the parameters.
     **************************************************************************/
    public Dentist(String firstName, String lastName, String email, String id, String office, String passwd, AppointmentsList aList) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.id = id;
        this.office = office;
        this.passwd = passwd;
        this.aList = aList;
        
    }
    private String firstName;
    private String lastName;
    private String email;
    private String id;
    private String office;
    private String passwd;
    private AppointmentsList aList;

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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getOffice() {
        return office;
    }

    public void setOffice(String office) {
        this.office = office;
    }

    public String getPasswd() {
        return passwd;
    }

    public void setPasswd(String passwd) {
        this.passwd = passwd;
    }
    /***************************************************************************
     * Fills in the AppointmentsList object with appointments the dentist with 
     * this objects dentId has by querying the Appointments table using this 
     * obj's dentId to filter results.
     **************************************************************************/
    public void setAppointmentsList() {
        try {
            Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
            String conURL = "jdbc:ucanaccess:///Users/jasonwilsonrodriguez/Desktop/DESKDOCS/CIST2373/FinalProject/DentistOfficeACCDB.accdb";
            Connection con = DriverManager.getConnection(conURL);
            Statement stmt = con.createStatement();
            String sql = "select patId from Appointments where dentId = '" + getId() + "';";
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                String patId = rs.getString(1);
                Appointment a1 = new Appointment();
                a1.setPatId(patId);
                a1.selectDB();
                
                
                aList.addAppointment(a1);
            }
            con.close();
        } catch (Exception e) {
            
        }
    }
    /***************************************************************************
     * Returns appointmentslist object
     **************************************************************************/
    public AppointmentsList getAppointmentsList() {
        return aList;
    }
    /***************************************************************************
     * selects from Dentists table the record's id that matches this obj's id 
     * then sets this objects properties to the data from the query.
     **************************************************************************/
    public void selectDB() {
        try {
            // loading driver and database file
            Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
            String conURL = "jdbc:ucanaccess:///Users/jasonwilsonrodriguez/Desktop/DESKDOCS/CIST2373/FinalProject/DentistOfficeACCDB.accdb";
            Connection con = DriverManager.getConnection(conURL);
            Statement stmt = con.createStatement();
            String sql = "select * from Dentists where id = '" + getId() + "';";
            ResultSet rs = stmt.executeQuery(sql);
            rs.next();
            firstName = rs.getString(1);
            lastName = rs.getString(2);
            email = rs.getString(3);
            id = rs.getString(4);
            office = rs.getString(5);
            passwd = rs.getString(6);
            setAppointmentsList();
            con.close();
            
            
        } catch (Exception e) {
            
        }
    }
    
    
    
        /***********************************************************************
        * selects from Dentists table the record's id that matches this obj's id 
        * then sets this objects properties to the data from the query.
        * Does not do anything with setting this object AppointmentsList obj.
        ***********************************************************************/
        public void selectDBnoAList() {
        try {
            // loading driver and database file
            Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
            String conURL = "jdbc:ucanaccess:///Users/jasonwilsonrodriguez/Desktop/DESKDOCS/CIST2373/FinalProject/DentistOfficeACCDB.accdb";
            Connection con = DriverManager.getConnection(conURL);
            Statement stmt = con.createStatement();
            String sql = "select * from Dentists where id = '" + getId() + "';";
            ResultSet rs = stmt.executeQuery(sql);
            rs.next();
            firstName = rs.getString(1);
            lastName = rs.getString(2);
            email = rs.getString(3);
            id = rs.getString(4);
            office = rs.getString(5);
            passwd = rs.getString(6);
            
            con.close();
            
            
        } catch (Exception e) {
            
        }
    }
    /***************************************************************************
    * Inserts into Dentists table a new record with the same values as this 
    * objects properties.
    ***************************************************************************/
    public void insertDB() {
        try {
            Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
            String conURL = "jdbc:ucanaccess:///Users/jasonwilsonrodriguez/Desktop/DESKDOCS/CIST2373/FinalProject/DentistOfficeACCDB.accdb";
            Connection con = DriverManager.getConnection(conURL);
            Statement stmt = con.createStatement();
            String sql = "insert into Dentists "
                        +"VALUES ( '" + getFirstName() + "', '" + getLastName() + "', '" + getEmail() + "', '" 
                    + getId() + "', '" + getOffice() + "', '" + getPasswd() + "');";
            stmt.executeUpdate(sql);
            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    /***************************************************************************
    * Updates the record from Dentists table whose id matches this obj's id,
    * it will use the values from this objects properties to update 
    * the database.
    ***************************************************************************/
    public void updateDB() {
        try {
            Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
            String conURL = "jdbc:ucanaccess:///Users/jasonwilsonrodriguez/Desktop/DESKDOCS/CIST2373/FinalProject/DentistOfficeACCDB.accdb";
            Connection con = DriverManager.getConnection(conURL);
            Statement stmt = con.createStatement();
            String sql = "UPDATE Dentists " +
                              "SET firstName = " + "'" + getFirstName() + "', " +
                              "lastName = " + "'" + getLastName() + "', " +
                              "email = " + "'" + getEmail() + "', " +
                              "id = " + "'" + getId() + "', " +
                              "office = " + "'" + getOffice() + "', " +
                              "passwd = " + "'" + getPasswd() + "' " +
                              "WHERE id = '" + getId() + "';";
            stmt.executeUpdate(sql);
            con.close();
        } catch (Exception e) {
        }
    }
    /***************************************************************************
    * Takes this objects Id and deletes the record that matches Id in the 
    * Dentists table
    ***************************************************************************/
    public void deleteDB() {
        try {
            Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
            String conURL = "jdbc:ucanaccess:///Users/jasonwilsonrodriguez/Desktop/DESKDOCS/CIST2373/FinalProject/DentistOfficeACCDB.accdb";
            Connection con = DriverManager.getConnection(conURL);
            Statement stmt = con.createStatement();
            String sql = "delete from Dentists where id = '" + getId() + "';";
            stmt.executeUpdate(sql);
            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    /***************************************************************************
     * Testing method to print this objects properties
     **************************************************************************/
    public void displayRecord() {
        System.out.println("FirstName: " + firstName);
        System.out.println("LastName: " + lastName);
        System.out.println("Email: " + email);
        System.out.println("ID: " + id);
        System.out.println("Office: " + office);
        System.out.println("Password: " + passwd);
    }
    /***************************************************************************
    * Testing method to display the whole Dentists table.
    ***************************************************************************/
    public void displayTable() {
        try {
            Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
            
            String conURL = "jdbc:ucanaccess:///Users/jasonwilsonrodriguez/Desktop/DESKDOCS/CIST2373/FinalProject/DentistOfficeACCDB.accdb";
            Connection con = DriverManager.getConnection(conURL);
            Statement stmt = con.createStatement();
            String sql = "select * from Dentists;";
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                System.out.println("FirstName: " + rs.getString(1));
                System.out.println("LastName: " + rs.getString(2));
                System.out.println("Email: " + rs.getString(3));
                System.out.println("ID: " + rs.getString(4));
                System.out.println("Office: " + rs.getString(5));
                System.out.println("Password: " + rs.getString(6));
                System.out.println("_________________________________");
            }
            con.close();
        } catch (Exception e) {
        }
    }
    public static void main(String[] args) {
        Dentist d1 = new Dentist();
        d1.setId("D202");
        d1.selectDB();
        
        
        d1.displayRecord();
        d1.aList.displayList();
        System.out.println("Procedure name: " + d1.aList.getAppointmentIndex(0).getProcedure().getProcName());
    }
}
