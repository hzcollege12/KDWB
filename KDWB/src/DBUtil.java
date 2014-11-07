//DBUtil ���   P79 80
//kehua

public static String registerUser(String u_name,String u_pwd,String u_email,String u_state,String h_id){
	String result=null;
	Connection con=null;
	PreparedStatement ps=null;
	try{
		con=getConnection();
		if(con==null){
			result=CONNECTION_OUT;
			return result;
		}
		ps=com.prepareStatement("insert into user(u_no,u_name,u_pwd,u_email,u_state,h_id)"+"values(?,?,?,?,?,?)");
		String u_no=String.valueOf(getMax(USER));
		u_name=new String(u_name.getBytes(),"ISO-8859-1");
		u_state=new String(u_state.getBytes(),"ISO-8859-1");
		int no=Integer.valueOf(u_no);
		int hid=Integer.valueOf(h_id);
		ps.setInt(1,no);
		ps.setString(2,u_name);
		ps.setString(3,u_pwd);
		ps.setString(4,u_email);
		ps.setString(5,u_state);
                ps.setInt(6,hid);
		int count=ps.executeUpdate();
		if(count==1){
			result=u_no;
			}
		else{
			result=REGISTER_FAIL;
			}
		}catch(Exception e)	{
			e.printStackTrace();
		}finally{
			try{if(ps!=null){
				ps.close();ps=null;
			}
			}catch(Exception e){e.printStacktrace();}
			try{if(con!=null){con.close();con=null;}
			}catch(Exception e){e.printStackTrace();}
		}
		return result;
}

//DBUtil.java    80ҳ
//13 李富涛

public static sychronized int getMax(String table){
	int max=-1;
	Connection con =null;
	Statement st =null;
	ResultSet rs =null;
	try{
		con = getConnection();
		st = con.createStatement();
		String sql="update set"+table+"+1";
		st.executeUpdate(sql);
		rs =st.executeQuery("select"+"table"+"from max");
		if(rs.next()){
			max = rs.getInt(1);
			return max;
			}
		}catch(Exception e){e.printStackTrace();}
		finally{
			try{
			if(rs!=null){rs.close();rs =null;}
			}catch(Exception e){e.printStackTrace();}
			try{
			if(st!=null){st.close();st =null;}
			}catch(Exception e){e.printStackTrace();}
			try{
			if(con!=null){con.close();con =null;}
			}catch(Exception e){e.printStackTrace();}
			}
	return max;
}