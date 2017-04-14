/**
 * ModalListener.java
 *
 * This class runs on the client end and just
 * displays any text received from the server.
 *
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
					System.out.println(serverText);
					Writer w = new Writer();
					melody1 = w.writeString(serverText);
					Reader r = new Reader();
					if(melody2.length != 0)
					{
						r.playNotes(melody1,melody2);
					}
					else
					{
						r.playNotes(melody1);
					}
					melody2 = melody1;

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
