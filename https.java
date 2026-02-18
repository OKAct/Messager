import java.net.*;
import java.io.*;
import java.nio.file.*;


public class https
{
    public static void main(String[] args) throws Exception
    {
        ServerSocket s=new ServerSocket(9090);
        System.out.println("Server running at:9090");
        Socket c= s.accept();

        byte[] html=Files.readAllBytes(Paths.get("index.html"));

        OutputStream out=c.getOutputStream();

        out.write(("HTTP/2 200 OK \r\n\r\n").getBytes());
        out.write(html);



        out.flush();
	
	System.out.println("done");


        c.close();
        s.close();



        
    } 
}
