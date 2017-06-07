package lab_four_src;

/**
 * class to model a "Message", with a messageBody,
 * and sender and recipient strings used in methods
 * like overidden toString(); formatted/used similarly
 * to an email
 * CSE 271, B
 * @author Wallisan
 * Instructor: Dr. Stephan
 * 2/19/2017
 */
public class Message {

	private String sender;
	private String recipient;
	private String messageBody;
	public static final String RECIPIENT_MARKER = "\nTo: ";
	public static final String SENDER_MARKER = "From: ";

	// single contructor, takes sender and recipient
	public Message(String sender, String recipient){
		setSender(sender);
		setRecipient(recipient);
		messageBody = "";
	}

	/**
	 * set name of sender, default to "Unknown origin"
	 * if given name has length 0
	 * @param sender
	 */
	public void setSender(String sender){
		if (sender.length()==0){
			this.sender = "Unknown origin";
			return;
		}
		this.sender = sender;
	}

	/**
	 * set name of recipient, default to
	 * "Unspecified recipient" if name of length 0 given
	 * @param recipient
	 */
	public void setRecipient(String recipient){
		if (recipient.length()==0){
			this.recipient = "Unspecified recipient";
			return;
		}
		this.recipient = recipient;
	}

	/**
	 * @return message's messageBody for the purposes of
	 * testing/debugging
	 */
	public String getMessageBody(){
		return this.messageBody;
	}

	/**
	 * append given String line to current message's body
	 * @param line to be added to the messageBody
	 */
	public void append(String line){
		messageBody += line + "\n";
	}

	/**
	 * Overrides toString() to return a visual,
	 * easily human-understood form of Message
	 */
	@Override
	public String toString() {
		return Message.SENDER_MARKER + this.sender
				+ Message.RECIPIENT_MARKER + this.recipient + "\n"
				+ this.messageBody + "\n";
	}

}// end Message class
