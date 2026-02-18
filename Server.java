

import org.java_websocket.server.WebSocketServer;
import org.java_websocket.handshake.ClientHandshake;
import org.java_websocket.WebSocket;
import java.net.InetSocketAddress;
import static java.lang.System.out;
import java.util.HashMap;
import com.google.gson.Gson;


public class Server extends WebSocketServer
{



    String name;   

    HashMap <InetSocketAddress,String> map=new HashMap<>();

    Gson gson= new Gson();  

    
    
    

    public Server(int port)
    {
        super(new InetSocketAddress(port));
    }

    @Override
    public void onOpen(WebSocket conn,ClientHandshake handshake)
    {
        out.println("Client connected:" +conn.getRemoteSocketAddress());

        map.put(conn.getRemoteSocketAddress(),"");
    }

    @Override
    public void onClose(WebSocket conn,int code, String reason,boolean remote)
    {

        map.remove(conn.getRemoteSocketAddress());
        out.println("Client left:"+reason);


    }

    @Override
    public void onError(WebSocket conn,Exception e)
    {
        out.println("There is an error:"+e.getMessage());
    }
    @Override
    public void onMessage(WebSocket conn,String message)    
    {
        
      if(map.get(conn.getRemoteSocketAddress())=="")
      {
        map.put(conn.getRemoteSocketAddress(),message);


        for(WebSocket client:getConnections())
        {


        String mess=gson.toJson(user);
        client.send(mess);

        

      }
      }
      else
      {
        for(WebSocket client:getConnections())
        {
            if(client!=null && client.isOpen() && client!=conn && message!="")
            {
                name=map.get(conn.getRemoteSocketAddress());

                tag user=new tag("message",name,message,conn.getRemoteSocketAddress());

                String mess=gson.toJson(user);
                client.send(mess);
            }
        }
      } 
        System.out.println(map);
    }
    @Override 
    public void onStart()
    {
        out.println("Server Started:");
    }



    public static void main(String[] args)
    {
        int port=9999;
        Server server=new Server(port);
        server.start();
        out.println("Listening on port: "+port);
    }

}
