//MyServletContextListene ������ p106


package wpf;
import java.net.ServerSocket;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class MyServletContextListener implements ServletContextListener{
	ServerSocket ss=null;
	ServerThread st=null;
	public void contextIntitialized(ServletContextEvent sce){
		try{
			ss=new ServerSocket(8888);
			st=new ServerThread(ss);
			st.start();
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	public void contextDestroyed(ServletContextEvent sce){
		try{
			st.flag=false;
			ss.close();
			ss=null;
			st=null;
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	public void contextInitialized(ServletContextEvent arg0) {
		// TODO Auto-generated method stub
		
	}
}