package edu.uoregon.cs.p2presenter.interactivity.demo;

import java.awt.Dimension;
import java.net.ConnectException;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import com.ryanberdeen.postal.LocalConnection;
import com.ryanberdeen.postal.client.PostalClient;

import edu.uoregon.cs.p2presenter.interactivity.InteractivityParticipantClient;

public class DemoClient {

	/**
	 * @param args
	 */
	public static void main(String[] args) throws Exception {
		JFrame frame = new JFrame("Interactivity Demo Participant");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		String host = args.length == 0 ? JOptionPane.showInputDialog("Host address:", "localhost") : args[0];
		if (host == null) {
			System.exit(0);
		}
		String interactivityIdString = JOptionPane.showInputDialog("Interactivity Id:", 1);
		if (interactivityIdString == null) {
			System.exit(0);
		}
		try {
			PostalClient postalClient = new PostalClient();
			LocalConnection connection = postalClient.connect(host, 9000);

			InteractivityParticipantClient client = new InteractivityParticipantClient(connection, new Integer(interactivityIdString));

			// TODO
			frame.setContentPane(client.getView());
			frame.setSize(new Dimension(300, 200));
			frame.setVisible(true);
		}
		catch (ConnectException ex) {
			JOptionPane.showMessageDialog(null, "Couldn't connect to server '" + host + "'");
		}
	}

}
