//Almicke Navarro 
//CST-323
//January 12, 2020 
//I used the source code from the following website: https://github.com/MickeyNavarro/ArtistWebsiteV3/blob/master/src/com/business/EventBusinessService.java

//SongBusinessService will persist any CRUD operations to the data service

package CST323.KaraokeMachine.business;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import CST323.KaraokeMachine.data.SongDataInterface;
import CST323.KaraokeMachine.model.Song;

public class SongBusinessService implements SongBusinessInterface {
	@SuppressWarnings("rawtypes")
	@Autowired
	SongDataInterface dao; 

	//creates a song in the database
	@SuppressWarnings("unchecked")
	public boolean request(Song song) {
		System.out.println("Processing SongBusinessService.request()...");
		return dao.create(song);
	}

	//reads all of the songs from the database
	@SuppressWarnings("unchecked")
	public List<Song> findAllSongs() {
		System.out.println("Processing SongBusinessService.findAllSongs()...");
		return dao.readAll();
	}

	//reads a single song from the database by its id
	@SuppressWarnings("unchecked")
	public Song findSong(int id) {
		System.out.println("Processing SongBusinessService.findSong()...");
		return dao.read(id);
	}

}
