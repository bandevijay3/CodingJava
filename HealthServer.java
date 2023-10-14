import java.net.*;
import java.io.*;
public class HealthServer
{
	public static void main(String []args) 
	{
		try
		{
			ServerSocket ss=new ServerSocket(5001);
			System.out.println("Waiting for Client Request...");
			Socket s=ss.accept();
			System.out.println("Connected with Client");
			
			InputStream is=s.getInputStream();
			DataInputStream dis=new DataInputStream(is);
			
			OutputStream os=s.getOutputStream();
			DataOutputStream dos=new DataOutputStream(os);
			
			String sym=dis.readUTF();
			
			String medicine;
			if(sym.equalsIgnoreCase("h"))
			{
				medicine="Take Anacin for Headache";
				dos.writeUTF(medicine);
				System.out.println("Medical Advice sent to the client");
			}
			else if(sym.equalsIgnoreCase("b"))
			{
				medicine="Apply Moov or volini spray for backpain";
				dos.writeUTF(medicine);
				System.out.println("Medical Advice sent to the client");
			}
			else if(sym.equalsIgnoreCase("d"))
			{
				medicine="Take Calpal for BodyPain";
				dos.writeUTF(medicine);
				System.out.println("Medical Advice sent to the client");
			}
			
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
	}
}