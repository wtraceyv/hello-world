package lab_four_src;

import java.util.ArrayList;

/**
 * class to model a Mailbox with a unique signature
 * and capability to add, remove, get stored/created
 * Message objects
 * CSE 271, B
 * @author Wallisan
 * Instructor: Dr. Stephan
 * 2/19/2017
 */
public class Mailbox {

	public final String SIGNATURE; // unique=non-static; secure,constant=public; constant=final
	private ArrayList<Message> messages;

	/**
	 * one constructor, initializes empty message list
	 * and smart-sets the signature
	 * @param signature to be added to each message after adding it
	 */
	public Mailbox(String signature) {
		messages = new ArrayList<Message>();
		// put smart section here, since only needed once
		if (signature.length()==0){
			this.SIGNATURE = "-END-";
			return;
		}
		this.SIGNATURE = new String(signature);
	}

	/**
	 * add given message to the mailbox's list of messages;
	 * also append signature to message
	 * @param m, message to add
	 */
	public void addMessage(Message m){
		Message temp = m;
		messages.add(temp);
		temp.append("\n" + this.SIGNATURE);
	}

	/**
	 * @param i, 0-based index of message to retrieve from mailbox
	 * @return Message object of 0-indexed message to retrieve
	 * from mailbox's list of messages
	 */
	public Message getMessage(int i){
		try {
			return messages.get(i);
		} catch (IndexOutOfBoundsException e){
			System.out.println("Message " + i + " does not exist.");
			return null;
		}
	}

	/**
	 * remove Message from mailbox's message list at given
	 * 0-based index; refuse if out of list bounds
	 * @param i, 0-based index of Message to delete
	 */
	public void removeMessage(int i){
		try{
			messages.remove(i);
		} catch (IndexOutOfBoundsException e){
			System.out.println("Message " + i + " not a valid message to delete.");
		}
	}

	/**
	 * @return .size() of private unique messages ArrayList
	 * to securely get amount for proving function
	 * of addMessage() and removeMessage() methods
	 */
	public int getAmountMessages(){
		return messages.size();
	}

	/**
	 * @return specific Mailbox instance's final signature
	 * String, primarily for debugging purposes
	 */
	public String getSignature(){
		return this.SIGNATURE;
	}

}// end Mailbox class
