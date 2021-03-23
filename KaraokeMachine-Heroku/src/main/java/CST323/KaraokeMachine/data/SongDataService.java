//Almicke Navarro 
//CST-323
//January 9, 2020 
//I used the source code from the following websites: https://github.com/MickeyNavarro/ArtistWebsiteV3/blob/master/src/com/data/EventDataService.java, https://stackoverflow.com/questions/35302501/jdbctemplate-is-null-and-throws-null-pointer-exception

//SongDataService will deal with any CRUD operations to the database 
package CST323.KaraokeMachine.data;

import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;

import CST323.KaraokeMachine.exception.DatabaseException;
import CST323.KaraokeMachine.model.Song;

public class SongDataService implements SongDataInterface {
	
	@SuppressWarnings("unused")
	private DataSource dataSource; 
	private JdbcTemplate jdbcTemplate;
	
	//set the spring bean
	public void setDataSource(DataSource dataSource) { 
		this.dataSource = dataSource; 
	}
	
	//get and set the JDBC template object 
	public JdbcTemplate getJdbcTemplate() {
	    return jdbcTemplate;
	}
	@Autowired
	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
	    this.jdbcTemplate = jdbcTemplate;
	}

	//default constructor 
	public SongDataService() {}
	
	//create a song to the database; returns if successful or not
	@Override
	public boolean create(Song s) {
		String sql = "INSERT INTO vzrpf9eq4ondk8oc.Song (Artist, Title, YoutubeLink) VALUES (?,?,?)";
		try { 
			//output statement for console
			System.out.println("Successful connection for SongDataService.create()!");
			
			//Execute SQL Insert 
			int rows = jdbcTemplate.update(sql, 
					s.getArtist(), s.getTitle(), s.getYoutubeLink()); 
			
			//Return result of Insert
			return rows == 1 ? true:false; 
		}
		catch (Exception e) { 
			//output statement for console
			System.out.println("Failed connection for SongDataService.create()!");
			e.printStackTrace();
			throw new DatabaseException(e); 
		}
	}

	//read a song from the database; returns the song info
	@Override
	public Song read(int id) {
		String sql = "SELECT * FROM vzrpf9eq4ondk8oc.Song WHERE ID = ?"; 

		//create a song object to hold the song found from the database
		Song song = null; 

		try { 
			//output statement for console
			System.out.println("Successful connection for SongDataService.read()!");

			//Execute SQL Query and check if an Event was returned
			SqlRowSet srs = jdbcTemplate.queryForRowSet(sql, id); 
			if(srs.next()) { 
				song = new Song(id,
						srs.getString("Artist"), 
						srs.getString("Title"), 
						srs.getString("YoutubeLink")); 

			}

		}
		catch (Exception e) { 
			//output statement for console
			System.out.println("Failed connection for SongDataService.read()!");
			e.printStackTrace();
			throw new DatabaseException(e); 
		}
		return song; 
	}

	//reads all the songs from the database; returns a list of songs
	@Override
	public List<Song> readAll() {
		String sql = "SELECT * FROM vzrpf9eq4ondk8oc.Song"; 
		
		//create a lits of songs so it will be returned later to the JSP page 
		List<Song> songs = new ArrayList<Song>(); 
		
		try { 
			//output statement for console
			System.out.println("Successful connection for SongDataService.readAll()!");
			
			//Execute SQL Query and loop over result set
			SqlRowSet srs = jdbcTemplate.queryForRowSet(sql); 
			while(srs.next()) { 
				songs.add(new Song(srs.getInt("ID"), 
						srs.getString("Artist"), 
						srs.getString("Title"), 
						srs.getString("YoutubeLink"))); 

			}
			
		}
		catch (Exception e) { 
			//output statement for console
			System.out.println("Failed connection for SongDataService.readAll()!");
			e.printStackTrace();
			throw new DatabaseException(e); 


		}
		return songs;
	}
	
	//update a song in the database; returns if successful or not - out of scope
	@Override
	public boolean update(Song p) {
		// TODO Auto-generated method stub
		return false;
	}

	//delete a song in the database; returns if successful or not - out of scope
	@Override
	public boolean delete(int id) {
		// TODO Auto-generated method stub
		return false;
	}



}
