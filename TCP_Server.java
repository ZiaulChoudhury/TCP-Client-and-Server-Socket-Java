/*
 * Ziaul Choudhury
 * Server TCP socket
 * This socket can be used as chat program with client 
 * by providing user input option for string input
 * */
import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;
//import javax.swing.JOptionPane;

public class TCP_Server {

	public static void main(String[] args) throws IOException {
		System.out.println("TCP Server Started/Running.");
		//JOptionPane.showMessageDialog(null,"TCP Server Started/Running.");
		 while(true){
		 int port = 4000; 
		 String cInput;
         ServerSocket ws = new ServerSocket(port);
         System.out.println("Current avilable prot number: " + port);
        
        try{
            Socket dp = ws.accept(); // accepting the packets from client
            BufferedReader FromClient = new BufferedReader
            		(new InputStreamReader(dp.getInputStream()));
           
            cInput = FromClient.readLine(); //display the received message
            //JOptionPane.showMessageDialog(null, "Message Received From Client: "+ cInput);
            System.out.println("Message Recieved From Client: " + cInput);
            
            String str = cInput + '\n';
            DataOutputStream toClient = new DataOutputStream(dp.getOutputStream());
            toClient.writeBytes(str); // sending back the received message
            
         }finally{
        	 ws.close();
         }
        port++;
	}
  }
}
