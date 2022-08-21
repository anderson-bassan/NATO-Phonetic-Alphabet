package com.nato;

public class Points {
	private int points;
 	private final String CURRENT_POINTS_MESSAGE;
	private final String FINAL_POINTS_MESSAGE;
	private final String WIN_MESSAGE;
	private final String GAME_OVER_MESSAGE;
	private final String GAME_OVER_BY_TIMEOUT_MESSAGE;

	public Points(String currentPointsMessage, String finalPointsMessage, String winMessage, String gameOverMessage, String lostByTimeoutMessage) {
		this.points = 0;
 		this.CURRENT_POINTS_MESSAGE = currentPointsMessage;
		this.FINAL_POINTS_MESSAGE = finalPointsMessage;
		this.WIN_MESSAGE = winMessage;
		this.GAME_OVER_MESSAGE = gameOverMessage;
		this.GAME_OVER_BY_TIMEOUT_MESSAGE = lostByTimeoutMessage;
	}
	
	public void increasePoints() {
		this.points++;
	}
	
	public void decreasePoints() {
		this.points--;
	}
	
	public int getPoints() {
		return this.points;
	}
	
	private String formatPointsMessage(String pointsMessage) {
		String bufferedMessage;
		
		if (points > 0 && points < 10) {
			bufferedMessage = "   " + pointsMessage.toUpperCase() + " " + points + "     ";
			
		} else if (points > 0 && points > 10) {
			bufferedMessage = "   " + pointsMessage.toUpperCase() + " " + points + "    ";
		
		} else if (points < 0 && points > -10){
			bufferedMessage = "   " + pointsMessage.toUpperCase() + " " + points + "    ";
		
		} else {
			bufferedMessage = "   " + pointsMessage.toUpperCase() + " " + points + "   ";
		}
		
		String fullLine = "";
		String cleanLine = "";
		
		for (int i = 0; i < bufferedMessage.length(); i++) {
			fullLine += "#"; // sets it to something like "#######################"
			cleanLine += " ";// sets it to something like "                       "
		}

		// add # to the points of the lines
		fullLine = "#" + fullLine + "#\n";
		cleanLine = "#" + cleanLine + "#\n";
		bufferedMessage = "#" + bufferedMessage + "#\n";

		// sets the full message
		bufferedMessage = "\n" + fullLine + cleanLine + bufferedMessage + cleanLine + fullLine + "\n";
		
		return bufferedMessage;
	}
	
	private String formatGameOverMessage(String finalMessage) {
		String bufferedMessage = "   " + finalMessage.toUpperCase() + "   ";
		
		String fullLine = "";
		String cleanLine = "";
		
		for (int i = 0; i < bufferedMessage.length(); i++) {
			fullLine += "#";
			cleanLine += " ";
		}
		
		fullLine = "#" + fullLine + "#\n";
		cleanLine = "#" + cleanLine + "#\n";
		bufferedMessage = "#" + bufferedMessage + "#\n";
		
		bufferedMessage = "\n" + fullLine + cleanLine + bufferedMessage + cleanLine + fullLine + "\n";
		
		return bufferedMessage;
	}
	
	public void showCurrentPoints() {
		String bufferedMessage = formatPointsMessage(CURRENT_POINTS_MESSAGE	);
		System.out.println(bufferedMessage);

		/* prints something like
		
		################################
		#                              #
		# current ponts message points #
		#                              #
		################################
		
		*/
	}
	
	public void showFinalPoints() {
		System.out.println(formatPointsMessage(FINAL_POINTS_MESSAGE));

		/* prints something like
		
		################################
		#                              #
		# current ponts message points #
		#                              #
		################################
		
		*/
	}
	
	public void showWinMessage() {
		System.out.println(formatGameOverMessage(WIN_MESSAGE));
		
		/* prints something like
		
		###########
		#         #
		# YOU WON #
		#         #
		###########
		
		*/
	}
	
	public void showGameOverMessage() {
		System.out.println(formatGameOverMessage(GAME_OVER_MESSAGE));
	}
	
	public void showGameOverByTimeOutMessage() {
		System.out.println(formatGameOverMessage(GAME_OVER_BY_TIMEOUT_MESSAGE));
	}
}