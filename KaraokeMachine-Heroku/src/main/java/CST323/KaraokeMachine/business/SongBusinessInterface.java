//Almicke Navarro 
//CST-323
//January 12, 2020 
//This is my own work.

//SongBusinessInterface will be implemented in the Song SpringBean 

package CST323.KaraokeMachine.business;

import java.util.List;

import CST323.KaraokeMachine.model.Song;

public interface SongBusinessInterface {
	//method to allow the creation of a new song in the database
	public boolean request(Song song); 
	
	//method to get all the songs from the database
	public List<Song> findAllSongs(); 
	
	//method to get a single song from the database
	public Song findSong(int id); 

}
