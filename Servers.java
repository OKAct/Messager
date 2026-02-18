import org.java_websocket.server.WebSocketServer;
import org.java_websocket.handshake.ClientHandshake;
import org.java_websocket.WebSocket;
import java.net.InetSocketAddress;
import java.util.HashMap;


public class Servers extends WebSocketServer{

	public Servers(int port){
	super(new InetSocketAddress(port));
	}

	@Override
	public void onOpen(WebSocket conn,ClientHandshake handshake){
	System.out.println("Client Connected:"+conn.getRemoteSocketAddress());
	}

	@Override
	public void onClose(WebSocket conn,int code,String reason,boolean remote){
	 System.out.println("Client Disconnected:"+reason);
	}

	@Override
	public void onError(WebSocket conn,Exception e){
		System.out.println("Error:"+e.getMessage());
	}

	@Override 
	public void onMessage(WebSocket conn,String message){
		System.out.println("Message from Client:"+message);
	
	}

	@Override 
	public void onStart(){
	System.out.println("Server Started");
	}
	
	public static void main(String[] args){
	int port =9999;
	Servers server=new Servers(port);
	server.start();
	System.out.println("Listening on the port:"+port);
	}
}


