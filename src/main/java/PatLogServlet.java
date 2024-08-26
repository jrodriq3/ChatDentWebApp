
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
* Checks if credentials entered are valid and if they are sends user to 
* pat-main-menu.jsp if not sends to LoginError.jsp.
*******************************************************************************/
@WebServlet(urlPatterns = {"/PatLogServlet"})
public class PatLogServlet extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String pid = request.getParameter("patientId");
        String passwd = request.getParameter("patientPassword");
        Patient patient = new Patient();
        RequestDispatcher rd;
        HttpSession session = request.getSession();
        patient.setPatId(pid);
        patient.selectDB();
        if (patient.getPasswd().equals(passwd) && !passwd.equals("") && !patient.getPatId().equals("")) {
            session.setAttribute("patient", patient);
            rd = request.getRequestDispatcher("/pat-main-menu.jsp");
            rd.forward(request, response);
        }
        else {
         rd = request.getRequestDispatcher("/LoginError.jsp");
         rd.forward(request, response);
        }
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
