import java.net.*;
import java.io.*;
import java.nio.file.*;
	
	
	public class new_htp{
	
	
	public static void main(String[] args) throws Exception {
	
	
	int port=8899; 


	ServerSocket server= new ServerSocket();
	server.bind(new InetSocketAddress("0.0.0.0",9899));

 
	System.out.println("Server at "+port);
	
	



	while(true){

	Socket  client =server.accept();
	



	BufferedReader  in =new BufferedReader(new InputStreamReader(client.getInputStream()));
	
	
	OutputStream out =client.getOutputStream();
	
	String request=in.readLine();
	
	
	System.out.println(request);
	
	
	




	if(request==null)
	{
		client.close();	

		continue;


	}



	if(request.contains("GET /style.css")){
	
	
	byte[] css =Files.readAllBytes(Paths.get("style.css"));
	
	
	
	out.write((
	"HTTP/1.1 200 OK\r\n"+
	"Content-Type:text/css\r\n\r\n").getBytes());
	
	
	out.write(css);
	}	
	else if(request.contains("GET /script.js"))
	{
	byte[] js=Files.readAllBytes(Paths.get("script.js"));
	
	out.write(("HTTP/1.1 200 OK\r\n"+
	"Content-Type:text/css\r\n\r\n").getBytes());
	
	
	out.write(js);


	}

	else
	{

		byte[] html=Files.readAllBytes(Paths.get("index.html"));
	
	out.write(("HTTP/1.1 200 OK\r\n"+
	"content -Type:text/html\r\n\r\n").getBytes());
	
	out.write(html);

	}
	
	out.flush();
	
	client.close();






    }
}
}













