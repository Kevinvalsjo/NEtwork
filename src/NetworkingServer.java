import java.net.*;
import java.io.*;

public class NetworkingServer{
    public static void main(String[]args){
        ServerSocket server = null;
        Socket client;
        int portnumber= 3333;
        if(args.length>=1){
            portnumber=Integer.parseInt(args[0]);
        }


        try {
            server = new ServerSocket(portnumber);
        }catch(IOException ie){
            System.out.println("cannot open socket."+ie);
            System.out.println(1);
        }
        System.out.println("Server socket is created"+server);
        while(true){
            try{
                System.out.println("waiting for connect requst");
                client=server.accept();
                System.out.println("connect request is accepted.");
                String clienthost= client.getInetAddress().getHostAddress();
                int clientport = client.getPort();
                System.out.println("client host = "+clienthost +"Client port ="+clientport);
                InputStream clientIn=


            }
        }
    }

}