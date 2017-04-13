/*
 * Ziaul Choudhury
 * Client TCP socket
 * This socket can be used as chat program with server
 * */

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

import javax.swing.JOptionPane;

public class TCP_Client {
	

	public static void main(String[] args) throws IOException{
		
		int n = 1;
		
		do{
			 
			  int m = n-1;
				
			  System.out.println("This is a TCP socket.");
			  System.out.print("Enter a Message: ");
			
			  @SuppressWarnings("unused")
			  BufferedReader userInput = new BufferedReader( new InputStreamReader(System.in)); //to get the user input
			  Socket client = new Socket("localhost", 4000);
			  DataOutputStream outToServer = new DataOutputStream(client.getOutputStream());
			  BufferedReader inFromServer = new BufferedReader(new InputStreamReader(client.getInputStream()));
			  String sentence = userInput(JOptionPane.showInputDialog("This is a TCP socket.\n" + 
					  "Number of sent message(s): "+ m + ". Max limit: 5 messages" +
			  		  "\n**************************\n\n"+"Enter a message: "));
			  outToServer.writeBytes(sentence + '\n'); // sending the massage to server
			  String str = inFromServer.readLine(); // Receiving the massage back 
			  JOptionPane.showMessageDialog(null, "Eco-Relpy From TCP Server: "+ str+" "+str);
			  System.out.println("Eco-Relpy From Server: " + str + " " + str);
			  client.close();
			  
			  n++;
			  
			  if (n == 5){
				  final String[] seclection = { "Yes", "No" };
				    String favoritePizza = (String) JOptionPane.showInputDialog(null, 
				        "Do you want to keep communicationg with server? ",
				        "Select:\n Yes = Continue.\n No = Exit. ",
				        JOptionPane.QUESTION_MESSAGE, 
				        null, 
				        seclection, 
				        seclection[0]);

				    // favoritePizza will be null if the user clicks Cancel
				    if( favoritePizza == "Yes") n = 1;
				    else{
				    	JOptionPane.showMessageDialog(null,"Good Bye !!");
				    	System.exit(0);
				    }
			  }
			     
		}while(true);

	}

	private static String userInput(String showInputDialog) {
		return showInputDialog;
	}

}
