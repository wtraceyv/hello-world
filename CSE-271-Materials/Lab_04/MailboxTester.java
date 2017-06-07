package lab_four_src;

/**
 * class to test the Mailbox class and its methods;
 * also uses Message object as a matter of course
 * CSE 271, B
 * @author Wallisan
 * Instructor: Dr. Stephan
 * 2/19/2017
 */
public class MailboxTester {

	public static void main(String[] args) {
		// create some Message objects, fill with some messageBodies to use for testing Mailbox
		Message tristanCatchup = new Message("Walter Tracey","Tristan Migoski");
		Message scholarshipQuestion = new Message("Walter Tracey","Scholarship committee");
		Message momQuestion = new Message("Walter Tracey","Mom");
		Message professorNote = new Message("Walter Tracey","Dr. Stephan");
		Message testMessage = new Message("Walter Tracey","");
		tristanCatchup.append("Hey Tristan!\nJust trying to get together for some music things! SOON!");
		scholarshipQuestion.append("Hey almighty committee!\nJust curious when I'll get that award exactly?\nThanks!");
		momQuestion.append("MAM!\nAre we having chili tonight?!");
		professorNote.append("Hey Dr. Stephan!\nI hope this is satisfactory!!\nGr.");
		testMessage.append("Can't think of more Messages. This is a test. Wee.");

		// create a Mailbox
		Mailbox inbox = new Mailbox("~Everybody was kung fu fighting~\n\"Errbody needs a Scanner!\"\n-Walter V");
		// test addMessage(Message m)
		System.out.println("Amount of messages should be 0, since none added:");
		System.out.println(inbox.getAmountMessages());
		inbox.addMessage(testMessage);
		System.out.println("Amount messages should now be 1 (added testMessage):");
		System.out.println(inbox.getAmountMessages());
		inbox.addMessage(tristanCatchup);
		inbox.addMessage(scholarshipQuestion);
		System.out.println("Finally, should show there are now 3 messages :");
		System.out.println(inbox.getAmountMessages());
		System.out.println();// final carriage return to separate method testing

		// new Mailbox for next method test
		Mailbox secondInbox = new Mailbox("");
		// test removeMessage(int i)
		secondInbox.addMessage(scholarshipQuestion);
		secondInbox.addMessage(professorNote);
		System.out.println("secondInbox should currently have 2 Messages:");
		System.out.println(secondInbox.getAmountMessages());
		secondInbox.removeMessage(0);
		System.out.println("secondInbox should have 1 message removed (1 message left):");
		System.out.println(secondInbox.getAmountMessages());
		System.out.println();

		// final Mailbox to test getMessage(int i)
		Mailbox thirdInbox = new Mailbox("\"Who\'s the boss?!!\"");
		thirdInbox.addMessage(momQuestion);
		System.out.println("getMessage(0) should print:");
		System.out.println("From: Walter Tracey\nTo: Mom\n\nMAM!\nAre we having chili tonight?!\n\n\"Who\'s the boss?!!\"\n");
		System.out.println("Actually prints:");
		System.out.println(thirdInbox.getMessage(0));// implicit toString() on Message called
		
	}

}// end MailboxTester class
