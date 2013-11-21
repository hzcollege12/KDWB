package wpf;
//DBUtil ���?  P79 80
//kehua

  package wpf;
  import static wpf.ConstabtUtil.*;
  ...
  import java.util.ArrayList;
  public classDBUtil{
    public static Connection Connection(){
          Connection con =null;
          try{
           Context inintial=new InitialContext();
          DataSource ds =(DataSource)inintial.lookup("java:comp/env/jdbc/mysql");
          con=ds.getConnectionb()
          }
          catch(Exception e{
              e.printStackTrace();
          }
   public static ArrayList<String>checkLogin(String u_no,String u_pwd){

        ArrayList<String>result=new ArrayList<String>();
        Connection con =null;
        PreparedStatenent ps null;
        ResultSet rs = null;
        try{
            con =getConnection();
            if(con== null){
               result.add(CONNECTION_OUT);
               return result;
             }
             ps = con.prepareStatement("select u_no,u_name,u_email,u_state,h_id from user
                                             where u_no=?and u_pwd=?");
             ps.setString(1,u_no);
            ps.setString(2,u_pwd);
             rs = ps.executeQuery();
             if(rs.next()){
                 for(int i=1;i<5:i++){
                   result.(rs.getString(i));
                   }
                }else{
                   result.add(LOGIN_FAIL);
                   }
             }catch(Exception e){e.printStackTrace();}
             finally{
                try{if(rs !=null){rs.close(); rs =null;}}
                catch(Exception e){e.printStackTrce();}
                try{if(ps !=null){ps.close(); ps =null;}}
                catch(Exception e){e.printStackTrce();}
                try{if(con !=null){con.close(); con =null;}}
                catch(Exception e){e.printStackTrce();}
                }
             return result;
             }
  ...
  }
   

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
//13 李富�?

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


//14号李君海
pubic static String writeNewDiary(String title,String content,String author){//
String result = null;
Connection con = null;
PreparedStatement ps = null;
try{
con = getConnection();
ps = con.prepareStatement("insert into diary
(r_id,,r_title,r_content,u_no)" + "values(?,?,?,?);
int max = getMax(DIARY);
ps.setInt(1,max);
ps.setString(2,new String(title.getBytes(CHAR_ENCODING),"ISO-8859-1"));
ps.setString(3,new String(content.getBytes(CHAR_ENCODING),"ISO-8859-1"));
int u_no = integer.calueOf(author);
ps.setInt(4.u_no);
int count = ps.executeUpdate();
if(count == 1){
resu1t = DLARY_SUCCESS;
}
else{
resu1t = DLARY_FAIL;
}
return resu1t;
}catch(Exception e){e.prinStackTrace();}
finally(
tr{if(ps != null){ps.close();ps = null;}
}catch(Exception e){e.printStackTrace();}
try{
if(con != null){con.close();con = null;}
}catch(Exception e){e.printStackTrace();}
}
return resu1t;
}