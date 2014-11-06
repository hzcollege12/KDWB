//MyServlet      弘权 p78,79

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