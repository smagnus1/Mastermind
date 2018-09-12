import java.util.HashMap;
import java.util.Map;

public class Extentor {
	private String[] secret;
  private String[] availableColors;
	private Map<Integer, String[]> revealedInfo;
	private static int turn;

	public Extentor(String[] secret) {
		this.secret = secret;
    this.availableColors = { "Yellow", "Blue", "Green", "Red", "Orange", "Purple"};
		revealedInfo = new HashMap<Integer, String[]>();
		turn = 1;
	}

	public String[] move(String[] guess) {
		String[] result = new String[4];
		if (isEqual(guess, secret)) {
			System.out.println("The game is over, the winner is the guesser.");
		} else {
			for (int i = 0; i < 4; i++) {
				if (containsColour(guess[i], secret)) {
					if (isRightPlace(guess[i], secret[i])) {
						result[i] = "black";
					} else {
						result[i] = "white";
					}
				}
			}
		}
		revealedInfo.put(turn, result);
		turn++;
		if (turn == 10) {
			System.out.println("Game over, the winner is the keykeeper.");
		}
		return result;
	}

	public String[] getInfo(int i) {
		return revealedInfo.get(i);
	}

	public boolean containsColour(String guess, String[] secret) {
		for (int i = 0; i < 4; i++) {
			if (guess.equals(secret[i])) {
				return true;
			}
		}
		return false;
	}

	public boolean isRightPlace(String guess, String secret) {
		return guess.equals(secret);
	}

	public boolean isEqual(String[] guess, String[] secrect) {
		for (int i = 0; i < 4; i++) {
			if (!(guess[i].equals(secret[i]))) {
				return false;
			}
		}
		return true;
	}

	public static String[] guessBot(MasterMinder game) {
	   guess = randomColors();
     move(guess);
     
	}




	public static void main(String[] args) {
		// pool = Yellow, Blue, Green, Red, Orange, Purple
		String[] secret = { "Yellow", "Blue", "Green", "Red" };
		Extentor game = new Extentor(secret);

		// turn 1
		String[] guess = { "Blue", "Blue", "Orange", "Orange" };
		game.move(guess);
		String[] revealed = game.getInfo(1);
		for (String s : revealed) {
			System.out.print(s + " ");
		}
		System.out.println();

		// turn 2
		guess = new String[] { "Blue", "Purple", "Yellow", "Yellow" };
		game.move(guess);
		revealed = game.getInfo(1);
		for (String s : revealed) {
			System.out.print(s + " ");
		}
		System.out.println();

		// turn 3
		guess = new String[] { "Yellow", "Blue", "Green", "Green" };
		game.move(guess);
		revealed = game.getInfo(1);
		for (String s : revealed) {
			System.out.print(s + " ");
		}
		System.out.println();

		// turn 4
		guess = new String[] { "Yellow", "Blue", "Green", "Red" };
		game.move(guess);
		revealed = game.getInfo(1);
		for (String s : revealed) {
			System.out.print(s + " ");
		}
		System.out.println();

		// turn 5
		guess = new String[] { "Orange", "Blue", "Green", "Red" };
		game.move(guess);
		revealed = game.getInfo(1);
		for (String s : revealed) {
			System.out.print(s + " ");
		}
		System.out.println();
	}
}
