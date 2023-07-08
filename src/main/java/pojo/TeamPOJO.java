package pojo;

import java.util.ArrayList;

public class TeamPOJO {

	private String teamName;
	private String categories;
	private ArrayList<PlayerPOJO> players;
	public String getTeamName() {
		return teamName;
	}
	public void setTeamName(String teamName) {
		this.teamName = teamName;
	}
	public String getCategories() {
		return categories;
	}
	public void setCategories(String categories) {
		this.categories = categories;
	}
	public ArrayList<PlayerPOJO> getPlayers() {
		return players;
	}
	public void setPlayers(ArrayList<PlayerPOJO> players) {
		this.players = players;
	}
}
