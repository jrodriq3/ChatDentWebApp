
import Business.Patient;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;



/*******************************************************************************
* takes in the values provided from pat-enter-new-appointment.jsp and alters the
* appointment object from blank values to these values then inserts this 
* appointment into the database then sends the user to the main menu.
*******************************************************************************/
@WebServlet(urlPatterns = {"/PatAptAddServlet"})
public class PatAptAddServlet extends HttpServlet {
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        Patient patient = (Patient) session.getAttribute("patient");
        String month = request.getParameter("months");
        String day = request.getParameter("days");
        String year = request.getParameter("years");
        String time = request.getParameter("time");
        String procCode = request.getParameter("proc-code");
        String dentId = request.getParameter("dent-id");
        
        patient.getAppointment().setApptDateTime(month + " " + day + ", " + year + ", " + time);
        patient.getAppointment().setDentId(dentId);
        patient.getAppointment().setProcCode(procCode);
        patient.getAppointment().setPatId(patient.getPatId());
        patient.getAppointment().insertDB();
        patient.getAppointment().selectDB();
        patient.selectDB();
        session.setAttribute("patient", patient);
        RequestDispatcher rd = request.getRequestDispatcher("/pat-main-menu.jsp");
        rd.forward(request, response);
        
        
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
