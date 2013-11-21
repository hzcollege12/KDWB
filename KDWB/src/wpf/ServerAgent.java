//Á»½Ü  107P 

package wpf;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.EOFException;
import java.io.IOException;
import java.net.Socket;

public class ServerAgent extends Thread {
	public Socket socket;
	public DataInputStream din;
	public DataOutputStream dout;
	boolean flag =false;
	public ServerAgent(Socket socket){
		this.socket=socket;
		try{
			din=new DataInputStream(socket.getInputStream());
			dout=new DataOutputStream(socket.getOutputStream());
			flag=true;
		}
		catch(IOException e){
			e.printStackTrace();
		}
	}


	public void run(){
		while (flag){
			try{
				String msg=din.readUTF();
				if(msg.startsWith("<#LIGIN#>")){
					//**************
				}
				//**********

			}
			catch (EOFException eof) {
				try{
					dout.close();din.close();socket.close();
					socket=null;flag=false;
				}catch(IOException e){e.printStackTrace();}
			}
			catch(Exception e){e.printStackTrace();}
		}
	}

}