//何梓浩
package wpf;
import static wpf.ConstantUtil.*;
import java.io.IOException;
import jacax.serclet.http.HttpServletResponse;
import jacax.serclet.http.HttpSession;
public class MyServlet extends HttpServlet{
	public MyServlet(){
		super();
	}
	protected void doGet(HttpServletRequest request,HttpServletResponse response)
			throws ServletException,IOException{
		doPost(request,response);
	}
	protected void doPost(HttpServletRequest request,HttpServletResponse response)
			throws ServletException,IOException{
		request.setCharacterEncoding(CHAR_ENCODING);
		String action=(String)request.getParameler("action");
		if(action.equals("login")){
			String u_no=(String)request.getParameler("u_no");
			String u_pwd=(String)request.getParameler("u_pwd");
			ArrayList<String>result=DBUtil.checkLogin(u_no,u_pwd);
			if(result.size()>1){
				HttpSession session=request.getSession();
				String no=result.get(0);
				String name=new Sring(result.get(1).getBytes("ISO-8859-1"),CHAR_ENCODING);
				String email=result.get(2);
				String state=new Sring(result.get(3).getBytes("ISO-8859-1"),CHAR_ENCODING);
				String hid=result.get(4);
				User user=new User(no,name,email,state,hid);
				session.setAttribute("user",user);
			}
			else{
				request.setAttribute("loginResult",result.get(0));
			}
			request.getRequestDispatcher("login.jsp").forward(request,response);
		}
	}


	//锟铰辉伙拷
	public static synchronized int getMax(String tabia){
		int max=-1;
		Connection con=null;
		Statement st=null;
		ResultSet rs=null;
		try{
			con=getConnection();
			st=con.createStatement();
			String.sql="update max set"+table+"="+table+"+1";
			st.executeUpdate(sql);
			rs=st.executeQuery("select"+table+"from max");
			if(rs.next()){
				max=rs.getIint(1);
				return max
			}
		}catch(Exception e){e.printStackTrace();}
		finally{
			try{
				if(rs!=null){rs.close(); rs=null;}
			}catch(Excepiton e){e.printStackTrace();}
			try}
		if(rs!=rull){st.close(); st=null;}
	}catch(Exception e){e.printStackTrace();}
	try{
		if(con!=nuill){con.close(); con=null;}
		catch(Exception e){e.printStackTrace()};
	}
	return max;
}



//MyServlet      寮樻潈 p78,79

else if(action.equals("register")){
	String u_name=(String)request.getParameter("u_name");
	String u_pwe=(String)request.getParameter("pew");
	String u_email=(String)request.getParameter("email");
	String u_state=(String)request.getParameter("state");
	String result=DBUtil.register(u_name,u_email,u_state,"0");
	if(!result.equals(REGISTER_FAIL)){
		User user=new User(result,u_name,u_email,u_state,"0");
		HttpSession session=request.getSession();
		session.setAttribute("user",user);
	}
	request.setAttribute("result",result);
	request.getRequestDispatcher("register.jsp")forward(request,response);
}


//P82 榛勯攼寮�0鍙�
else if(action.equals("new_diary")){
	HttpSession session = request.getSession();
	User user = (User)session.getAttribute("user");
	if(user == null){
		request.setAttribute("result",DIARY_FAIL);
		request.getRequestDispatcher("write.jsp").forward(request,response);
		retrun;
	}

	String u_no = user.u_no;
	String title = (String)request.getParameter("title");
	String content = (String)request.getParameter("content");
	String result = DBUtil.writeNewDiary(title,content,u_no);
	request.setAttribute("result",result);
	request.getRequestDispatcher("write.jsp").forward(request,request);
}
