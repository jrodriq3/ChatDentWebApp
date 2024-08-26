
package Business;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;



/*******************************************************************************
* Creates a procedure object that can select, insert,
* update and delete records from the database's Procedures
* table.
*******************************************************************************/
public class Procedure {
    private String procCode = "";
    private String procName = "";
    private String procDesc = "";
    private double cost = 0;

    public Procedure() {
    }
    /***************************************************************************
    * Instantiates procedure object and sets it's properties to the values 
    * provided in the parameters.
    ***************************************************************************/
    public Procedure(String procCode, String procName, String procDesc, double cost) {
        this.procCode = procCode;
        this.procName = procName;
        this.procDesc = procDesc;
        this.cost = cost;
    }
    public String getProcCode() {
        return procCode;
    }

    public void setProcCode(String procCode) {
        this.procCode = procCode;
    }

    public String getProcName() {
        return procName;
    }

    public void setProcName(String procName) {
        this.procName = procName;
    }

    public String getProcDesc() {
        return procDesc;
    }

    public void setProcDesc(String procDesc) {
        this.procDesc = procDesc;
    }

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }

    
    /***************************************************************************
    * selects from Procedures table the record's procCode that matches this 
    * obj's procCode then sets this objects properties to the data from the 
    * query.
    ***************************************************************************/
    public void selectDB() {
        try {
            Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
            String conURL = "jdbc:ucanaccess:///Users/jasonwilsonrodriguez/Desktop/DESKDOCS/CIST2373/FinalProject/DentistOfficeACCDB.accdb";
            Connection con = DriverManager.getConnection(conURL);
            Statement stmt = con.createStatement();
            String sql = "select * from Procedures where procCode = '" + getProcCode() + "';";
            ResultSet rs = stmt.executeQuery(sql);
            rs.next();
            setProcCode(rs.getString(1));
            setProcName(rs.getString(2));
            setProcDesc(rs.getString(3));
            setCost(Double.parseDouble(rs.getString(4)));
            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    /***************************************************************************
    * Inserts into Procedures table a new record with the same values as this 
    * objects properties.
    ***************************************************************************/
    public void insertDB() {
        try {
            Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
            String conURL = "jdbc:ucanaccess:///Users/jasonwilsonrodriguez/Desktop/DESKDOCS/CIST2373/FinalProject/DentistOfficeACCDB.accdb";
            Connection con = DriverManager.getConnection(conURL);
            Statement stmt = con.createStatement();
            String sql = "insert into Procedures "
                        +"VALUES ( '" + getProcCode() + "', '" + getProcName() + "', '" + getProcDesc() + "', " 
                    + getCost() + ");";
            stmt.executeUpdate(sql);
            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    /***************************************************************************
    * Updates the record from Procedures table whose procCode matches this obj's 
    * procCode, it will use the values from this objects properties to update 
    * the database.
    ***************************************************************************/
    public void updateDB() {
        try {
            Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
            String conURL = "jdbc:ucanaccess:///Users/jasonwilsonrodriguez/Desktop/DESKDOCS/CIST2373/FinalProject/DentistOfficeACCDB.accdb";
            Connection con = DriverManager.getConnection(conURL);
            Statement stmt = con.createStatement();
            String sql = "UPDATE Procedures " +
                              "SET procCode = " + "'" + getProcCode() + "', " +
                              "procName = " + "'" + getProcName() + "', " +
                              "procDesc = " + "'" + getProcDesc() + "', " +
                              "cost = " + getCost() + " " +
                              "WHERE procCode = '" + getProcCode() + "';";
            stmt.executeUpdate(sql);
            
            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    /***************************************************************************
    * Takes this objects procCode and deletes the record that matches procCode in the 
    * Procedures table.
    ***************************************************************************/
    public void deleteDB() {
        try {
            Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
            String conURL = "jdbc:ucanaccess:///Users/jasonwilsonrodriguez/Desktop/DESKDOCS/CIST2373/FinalProject/DentistOfficeACCDB.accdb";
            Connection con = DriverManager.getConnection(conURL);
            Statement stmt = con.createStatement();
            String sql = "delete from Procedures where procCode = '" + getProcCode() + "';";
            stmt.executeUpdate(sql);
            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    /***************************************************************************
    * Testing method to print this objects properties.
    **************************************************************************/
    public void displayRecord() {
        System.out.println("procCode: " + getProcCode());
        System.out.println("procName: " + getProcName());
        System.out.println("procDesc: " + getProcDesc());
        System.out.println("cost: " + getCost());
        
    }
    /***************************************************************************
    * Testing method to display the whole Procedures table.
    ***************************************************************************/
    public void displayTable() {
        try {
            Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
            String conURL = "jdbc:ucanaccess:///Users/jasonwilsonrodriguez/Desktop/DESKDOCS/CIST2373/FinalProject/DentistOfficeACCDB.accdb";
            Connection con = DriverManager.getConnection(conURL);
            Statement stmt = con.createStatement();
            String sql = "select * from Procedures;";
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                System.out.println("procCode: " + rs.getString(1));
                System.out.println("procName: " + rs.getString(2));
                System.out.println("procDesc: " + rs.getString(3));
                System.out.println("cost: " + rs.getString(4));
                System.out.println("___________________________");
            }
            
            con.close();
        } catch (Exception e) {
        }
    }
    public static void main(String[] args) {
        Procedure proc1 = new Procedure("P201", "TRing", "Putting a ring in a tooth", 200.00);
        proc1.displayTable();
        System.out.println("***********************************");
        proc1.insertDB();
        proc1.displayTable();
        
    }
}
