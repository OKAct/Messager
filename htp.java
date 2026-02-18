import java.net.ServerSocket;
import java.net.Socket;
import java.io.*;
import java.nio.file.*;


public class htp
	
{
	public static void main(String[] args) throws Exception 
	{
	ServerSocket s=new ServerSocket(9090);
	System.out.println("Server started at 9090");
	
	Socket c= s.accept();
	
	byte[] html=Files.readAllBytes(Paths.get("index.html")); 

	
	OutputStream out = c.getOutputStream();
        
	
	out.write(("HTTP/1.1 200\r\n\r\n").getBytes());
	
	
	


	out.write(html);
	
	
	c.close();
	s.close();
	}
	}

