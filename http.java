import java.net.*;

import java.io.*;
import java.nio.file.*;


public class http
{
    public static void main(String[] args) throws Exception
    {
	    ServerSocket s=new ServerSocket(8080);
	    Socket c=s.accept();


	    OutputStream out =c.getOutputStream();

	    out.write ((
				    "HTTP/1.1 200 OK\r\n"+
				    "\r\n"+
				    "<h1>hello</h1>"
		       ).getBytes());



	    out.flush();
	    c.close();
	    s.close();
    }
}

