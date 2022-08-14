package webapp.contoller;
import webapp.dao.studentdao;
import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import webapp.model.student;

/**
 * Servlet implementation class studentservlet
 */
@WebServlet("/register")
public class studentservlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       studentdao Studentdao= new studentdao(); 
    /**
     * @see HttpServlet#HttpServlet()
     */
    public studentservlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		RequestDispatcher dispatcher= request.getRequestDispatcher("/views/studentregister.jsp");
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String ID=request.getParameter("id");
		String name2=request.getParameter("name");
		String subject2=request.getParameter("subject");
		String asscat2=request.getParameter("asscat");
		String date2=request.getParameter("date");
		String points2=request.getParameter("points");
		
		student Student=new student();
		Student.getId(Integer.parseInt(ID));
		Student.getName(name2);
		Student.getAsscat(asscat2);
		Student.getSubject(subject2);
		Student.getDate(date2);
		Student.getPoints(Integer.parseInt(points2));
		 try {
			Studentdao.register(Student);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 RequestDispatcher dispatcher= request.getRequestDispatcher("/views/studentdetails.jsp");
			dispatcher.forward(request, response);
	}

}
