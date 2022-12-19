package dynamic_beat_16;

public class Track {
	
	private String startImage;
	private String startMusic;
	private String gameMusic;
	private String gameScreen;
	private String titleName;
	
	public String getGameScreen() {
		return gameScreen;
	}
	public void setGameScreen(String gameScreen) {
		this.gameScreen = gameScreen;
	}
	public String getStartImage() {
		return startImage;
	}
	public void setStartImage(String startImage) {
		this.startImage = startImage;
	}
	public String getStartMusic() {
		return startMusic;
	}
	public void setStartMusic(String startMusic) {
		this.startMusic = startMusic;
	}
	public String getGameMusic() {
		return gameMusic;
	}
	public void setGameMusic(String gameMusic) {
		this.gameMusic = gameMusic;
	}
	public String getTitleName() {
		return titleName;
	}
	public void setTitleName(String titleName) {
		this.titleName = titleName;
	}
	
	public Track(String startImage, String startMusic, String gameMusic,String gameScreen,String titleName) {
		super();
		this.startImage = startImage;
		this.startMusic = startMusic;
		this.gameMusic = gameMusic;
		this.gameScreen=gameScreen;
		this.titleName=titleName;
	}
	
}