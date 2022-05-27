package ToyRobotChallenge;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/**
 * The main class to run the program from
 * @author MarkG
 *
 */
public class Main {
	
	/**
	 * Main method for opening up the robot command file
	 * @param args
	 */
	public static void main(String[] args) {
		
		ArrayList<String> commands = new ArrayList<>();
		
		try {
			FileInputStream fileStream = new FileInputStream("robotCommand.txt");
			BufferedReader br = new BufferedReader(new InputStreamReader(fileStream));
			
			String commandLine;
			while((commandLine = br.readLine()) != null) {
				commands.add(commandLine);
			}
			
			br.close();
			
		} catch (IOException e) {
			System.out.println("An error occurred.");
		    e.printStackTrace();
		}
		
		if(!commands.isEmpty()) {
			runRobotGame(commands);
		}
		
	}
	
	/**
	 * Method to run the robot game
	 * @param commands
	 */
	public static void runRobotGame(List<String> commands) {
		RobotGame robotGame = new RobotGame();
		robotGame.startUpRobotGame();
		for(String command : commands) {
			robotGame.executeCommands(command);
		}
	}
}
