/**
 * ModalListener.java
 *
 * This class runs on the client end and just
 * displays any text received from the server.
 * This is where basically all of the action is happening within the program.
 * Since the info that is sent out from the client is then sent to the server and then all the listeners
 every listener gets the same string which we then use the other class to convert into string Array
 which can then be used to play our melodies, the player is also able to see melody that was written Since
 its is printed out at the beginning.
 */
import java.net.Socket;
import java.io.DataOutputStream;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.Scanner;
import java.util.ArrayList;

public class ModalListener implements Runnable
{
	private Socket connectionSock = null;
	private String[] melody1;
	private String[] melody2 = {};

	ModalListener(Socket sock)
	{
		this.connectionSock = sock;
	}

	public void run()
	{
       		 // Wait for data from the server.  If received, output it.
		try
		{
			BufferedReader serverInput = new BufferedReader(new InputStreamReader(connectionSock.getInputStream()));
			while (true)
			{
				// Get data sent from the server
				String serverText = serverInput.readLine();
				if (serverInput != null)
				{
					/**this is where all the program actually runs. A writer is made to convert the strings that are received from the
					server into a format which is more easily used by the reader.*/
					System.out.println(serverText);
					Writer w = new Writer();
					melody1 = w.writeString(serverText);
					Reader r = new Reader();
					if(melody2.length != 0)//this checks to see if there has only been one melody put in or if there are now two
					{
						r.playNotes(melody1,melody2);
					}
					else
					{
						r.playNotes(melody1);
					}
					melody2 = melody1;//now the melody which  was used to harmonize the first melody will also be harmonized

				}
				else
				{
					// Connection was lost
					System.out.println("Closing connection for socket " + connectionSock);
					connectionSock.close();
					break;
				}
			}
		}
		catch (Exception e)
		{
			System.out.println("Error: " + e.toString());
		}
	}
} // ModalListener for MTClient
