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
* Checks if data entered into fields are empty strings or not, If they are empty 
* will send user to invalid-change-error.jsp, if not will send user back to 
* pat-main-menu after updating the database and patient object with the new
* information provided by the patient.
*****************************************************************************/
@WebServlet(urlPatterns = {"/dentInfoChangeServlet"})
public class dentInfoChangeServlet extends HttpServlet {
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String firstName = request.getParameter("first-name");
        String lastName = request.getParameter("last-name");
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        RequestDispatcher rd;
        HttpSession session = request.getSession();
        Dentist dentist = (Dentist) session.getAttribute("dentist");
        if (firstName.equals("") || lastName.equals("") || email.equals("") || password.equals("")) {
            rd = request.getRequestDispatcher("invalid-change-error.jsp");
            rd.forward(request, response);
        } else {
            dentist.setFirstName(firstName);
            dentist.setLastName(lastName);
            dentist.setEmail(email);
            dentist.setPasswd(password);
            dentist.updateDB();
            session.setAttribute("dentist", dentist);
            rd = request.getRequestDispatcher("/dent-main-menu.jsp");
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
