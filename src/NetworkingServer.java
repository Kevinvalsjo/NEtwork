import java.net.*;
import java.io.*;
import java.security.spec.RSAOtherPrimeInfo;

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
                InputStream clientIn= client.getInputStream();
                BufferedReader br = new BufferedReader(new InputStreamReader(clientIn));
                        String msgFromClient =br.readLine();
                System.out.println("Message received from client="+msgFromClient);
                if(msgFromClient !=null&&!msgFromClient.equalsIgnoreCase("bye")) {
                    OutputStream clientOut = client.getOutputStream();
                    PrintWriter pw = new PrintWriter(clientOut, true);
                    String ansMsg = "Hello," + msgFromClient;
                    pw.println(ansMsg);


                }
                if(msgFromClient!=null&&msgFromClient.equalsIgnoreCase("bye"))
                {
                    server.close();
                    client.close();
                    break;

                }





            }catch(IOException ie){
                System.out.println("banan");
            }
        }
    }

}