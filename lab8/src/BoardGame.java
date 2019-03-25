import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class BoardGame {
	protected LinkedHashMap<String, GamePiece> playerPieces;
	protected LinkedHashMap<String, Location> playerLocations;
	
	public BoardGame() {
		playerPieces = new LinkedHashMap<String, GamePiece>();
		playerLocations = new LinkedHashMap<String, Location>();
	}
	
	public boolean addPlayer(String name, GamePiece gamePiece, Location location) {
		if(!playerPieces.containsValue(gamePiece)) {
			playerPieces.put(name, gamePiece);
			playerLocations.put(name, location);
			return true;
		}
		return false;
	}
	
	public GamePiece getPlayerGamePiece(String name) {
		return playerPieces.get(name);
	}
	
	public String getPlayerWithGamePiece(GamePiece gamePiece) {
		Set<String> players = playerPieces.keySet();
		
		for (String p1 : players) {
			if (playerPieces.get(p1).equals(gamePiece)) {
				return p1;
			}
		}
		return null;
	}
	
	public void movePlayer(String name, Location location) {
		playerLocations.put(name, location);
	}
	
	public String[] moveTwoPlayers(String[] names, Location[] locations) {
		String[] playOrder = new String[names.length];
		
		playOrder[0] = this.getPlayerWithGamePiece(GamePiece.movesFirst(playerPieces.get(names[0]),
				playerPieces.get(names[1])));
		
		if (playOrder[0].equalsIgnoreCase(names[0])) {
			playOrder[1] = names[1];
		} else {
			playOrder[1] = names[0];
		}
		
		int count = 0;
		for(String p1 : names) {
			this.movePlayer(p1, locations[count]);
			count++;
		}
		return playOrder;
	}
	
	public ArrayList<String> getPlayersAtLocation(Location location){
		Map<String, Location> map = playerLocations;
		ArrayList<String> players = new ArrayList<String>();
		
		for(Entry<String, Location> a : map.entrySet()) {
			if(a.getValue().equals(location)) {
				players.add(a.getKey());
			}
		}
		return players;
	}
	
	public ArrayList<GamePiece> getGamePiecesAtLocation(Location location){
		Map<String, Location> pieces = playerLocations;
		ArrayList<GamePiece> players = new ArrayList<GamePiece>();
		
		for(Entry<String, Location> a : pieces.entrySet()) {
			if(a.getValue().equals(location)) {
				players.add(playerPieces.get(a.getKey()));
			}
		}
		return players;
	}
	
	public Set<String> getPlayers(){
		return playerPieces.keySet();
	}
	
	public Set<Location> getPlayerLocations(){
		return new HashSet<Location>(playerLocations.values());
	}
	
	public Set<GamePiece> getPlayerPieces(){
		return new HashSet<GamePiece>(playerPieces.values());
	}
	
	public Location getplayerLocations(String name) {
		return playerLocations.get(name);
	}
	
	public Location getPlayersLocation(String name) {
		return playerLocations.get(name);
	}
	}
