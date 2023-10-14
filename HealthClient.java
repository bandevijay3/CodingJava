import java.net.*;
import java.io.*;
public class HealthClient
{
	public static void main(String []args)
	{
		try
		{
			Socket s=new Socket("localhost",5001);
			
			InputStream is=s.getInputStream();
			DataInputStream dis=new DataInputStream(is);
			
			OutputStream os=s.getOutputStream();
			DataOutputStream dos=new DataOutputStream(os);
			
			System.out.println("Enter your symptom to get medical advice:");
			System.out.println("h:Headache");
			System.out.println("b:BackPain");
			System.out.println("d:BodyPain");
			
			InputStreamReader isr=new InputStreamReader(System.in);
			BufferedReader br=new BufferedReader(isr);
			
			String symptom=br.readLine();
			dos.writeUTF(symptom);
			
			String medicine;
			medicine=dis.readUTF();
			System.out.println(medicine);
			s.close();
			
			
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
	}
}