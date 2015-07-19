//ServletThread.java   ¿Ó‘∂ª‘


public class a {
	
	
	package wpf;
	import java.net.ServerSocket;
	import java.net.Socket;
	public class ServerThread extends Thread{
		public ServerSocket ss;
		public boolean flag=false;
		public ServerThread(ServerSocket ss){
			this.ss=ss;
			flag=true;
		}
		public void run(){
			while(flag){
				try{
					Socket socket=ss.accept();
					ServerAgent sa=new ServerAgent(socket);
					sa.start();
				}catch(Exception e){
					e.printStackTrace();
				}
				
			}
		}
	}

}