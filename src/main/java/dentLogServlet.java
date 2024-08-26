import Business.Dentist;
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
 * Verifies the id and password provided are a match in the database if so,
 * the dentist object is created with the tables record's values, If Correct 
 * user is sent to the dent-main-menu.jsp page if not sent to LoginError.jsp.
 ******************************************************************************/

@WebServlet(urlPatterns = {"/dentLogServlet"})
public class dentLogServlet extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String did = request.getParameter("dentistId");
        String passwd = request.getParameter("dentistPassword");
        Dentist dentist = new Dentist();
        RequestDispatcher rd;
        HttpSession session = request.getSession();
        dentist.setId(did);
        dentist.selectDB();
        if (dentist.getPasswd().equals(passwd) && !passwd.equals("") && !dentist.getId().equals("")) {
            session.setAttribute("dentist", dentist);
            rd = request.getRequestDispatcher("/dent-main-menu.jsp");
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
