//Almicke Navarro 
//CST-323
//January 12, 2020 
//I used the source code from the following website: https://github.com/MickeyNavarro/ArtistWebsiteV3/blob/master/src/com/controller/EventController.java

//SongController will deal with accessing all the pages of the application
package CST323.KaraokeMachine.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import CST323.KaraokeMachine.business.SongBusinessInterface;
import CST323.KaraokeMachine.model.Song;

@Controller
public class SongController {
	
	//logger intialization
	Logger logger = LoggerFactory.getLogger(SongController.class); 
	
	//spring bean declaration 
	SongBusinessInterface service; 
	
	//set the spring bean
	public void setSongService(SongBusinessInterface service) { 
		this.service = service; 
	}

	//home page 
	@RequestMapping(value="/home")
	public ModelAndView home(HttpServletResponse response) throws IOException{
		return new ModelAndView("home");
	}
	
	//request a song page
	@RequestMapping(value="/requestASong", method = RequestMethod.GET) 
	public ModelAndView displayRequestPage() {
		return new ModelAndView("request", "song", new Song(0,"","",""));
	}
	
	//requested song success page 
	@RequestMapping(value="/requestSuccess", method = RequestMethod.POST) 
	public ModelAndView displayRequestSuccessPage(@ModelAttribute("song") Song song, BindingResult result) {
		//check if the form has any errors 
		if(result.hasErrors()) { 
			//return to previous form with errors outputted
			return new ModelAndView("request", "song", song); 
		} 
		//try to call the SongBusinessService to create a song
		try {
			
			service.request(song); 
			
			//return to songList page if successful
			List<Song> songs = service.findAllSongs(); 
			return new ModelAndView("songList", "songs", songs);
		}
		//catch all exceptions 
		catch (Exception e) {
			logger.info("------------------> Exception caught in the SongController.displayRequestSuccessPage() with message: " + e.getMessage());

			
			//create a modelandview 
			ModelAndView errorMV = new ModelAndView("error"); 
			
			//create a error message 
			String errorMessage = "Whoops! There was an error! " + e.getMessage(); 
					
			//create an object to output the error 
			errorMV.addObject("error", errorMessage); 
					
			//output error to errorPage
			return errorMV; 
		}
	}
	
	//list of all songs page 
	@RequestMapping(value="/songList", method = RequestMethod.GET) 
	public ModelAndView displaySongListPage() {
		System.out.println("Processing SongController.displaySongListPage()...");
		
		//try to call the business service to return a list of all the songs
		try {
			List<Song> songs = service.findAllSongs(); 
			return new ModelAndView("songList", "songs", songs);
		}
		//catch all exceptions 
		catch (Exception e) {
			logger.info("------------------> Exception caught in the SongController.displaySongListPage() with message: " + e.getMessage());

			
			//create a modelandview 
			ModelAndView errorMV = new ModelAndView("error"); 
			//create a error message 
			String errorMessage = "Whoops! There was an error! " + e.getMessage(); 
			
			//create an object to output the error 
			errorMV.addObject("error", errorMessage); 
			
			//output error to errorPage
			return errorMV; 
		}
	}
	
	//single song page - karaoke time!
	@RequestMapping(value="/karaokeSong", method = RequestMethod.POST) 
	public ModelAndView displayKaraokeSongPage(@RequestParam(value = "songID") int id) {
		//check if an ID was sent 
		if (id != 0) {
			
			//try to call the business service to return a single song for karaoke
			try {
				Song song = service.findSong(id); 
				return new ModelAndView("karaokeSong", "song", song);
			}
			//catch all exceptions 
			catch (Exception e) {
				logger.info("------------------> Exception caught in the SongController.displayKaraokeSongPage() with message: " + e.getMessage());
				
				//create a modelandview 
				ModelAndView errorMV = new ModelAndView("error"); 

				//create a error message 
				String errorMessage = "Whoops! There was an error! " + e.getMessage(); 

				//create an object to output the error 
				errorMV.addObject("error", errorMessage); 

				//output error to errorPage
				return errorMV; 
			}
		}
		
		//output error if ID was not sent
		else { 
			//create a modelandview 
			ModelAndView errorMV = new ModelAndView("error"); 
			
			//create a error message 
			String errorMessage = "Whoops! There was an error! The ID was never sent!"; 

			//create an object to output the error 
			errorMV.addObject("error", errorMessage); 

			//output error to errorPage
			return errorMV;
		}
	}
}
