//Almicke Navarro 
//CST-323
//January 10, 2020 
//This is my own work.

//Song will contain the attributes of the karaoke song
package CST323.KaraokeMachine.model;

public class Song {

	//attributes 
	private int ID; 
	private String Artist; 
	private String Title; 
	private String YoutubeLink; 
	
	//default constructor
	public Song() {}

	//non-default constructor
	public Song(int iD, String artist, String title, String youtubeLink) {
		super();
		ID = iD;
		Artist = artist;
		Title = title;
		YoutubeLink = youtubeLink;
	}
	
	//getters & setters
	public int getID() {
		return ID;
	}

	public void setID(int iD) {
		ID = iD;
	}

	public String getArtist() {
		return Artist;
	}

	public void setArtist(String artist) {
		Artist = artist;
	}

	public String getTitle() {
		return Title;
	}

	public void setTitle(String title) {
		Title = title;
	}

	public String getYoutubeLink() {
		return YoutubeLink;
	}

	public void setYoutubeLink(String youtubeLink) {
		YoutubeLink = youtubeLink;
	}
		
}
