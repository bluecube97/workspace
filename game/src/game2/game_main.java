package game2;

public class game_main {

	public static void main(String[] args) {
		game_progress gp = new game_progress();
		game_stat gs = new game_stat();
		var_game_hashlist vgh = new var_game_hashlist();
		
		gp.gameProgress(vgh, gs);
	}
}
