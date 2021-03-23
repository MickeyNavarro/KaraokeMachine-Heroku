//Almicke Navarro 
//CST-323
//January 9, 2020 
//This is my own work.


//DataAccessInterface will maintain the CRUD operations
package CST323.KaraokeMachine.data;

import java.util.List;

public interface DataAccessInterface<P> {
	//create will be used to create a new song to the database
	public boolean create(P p); 
	
	//read will be used to read a song from the database
	public P read(int id); 
	
	//readAll will be used to read all the songs from the database
	public List<P> readAll(); 
	
	//update will be used to update a song in the the database - out of scope
	public boolean update(P p); 
	
	//delete will be used to delete a song from the database - out of scope
	public boolean delete(int id); 
}