package com.staxrt.tutorial.controller;

import java.util.List;

import org.apache.juli.logging.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.staxrt.tutorial.dao.PlayListDao;
import com.staxrt.tutorial.model.PlayList;
import com.staxrt.tutorial.model.PlayListWithSongs;
import com.staxrt.tutorial.model.SongPlayListModel;
import com.staxrt.tutorial.model.SongsModel;

/**
 * Controller class to create different API's for Media player application.
 * @author lasithamukkunnathu
 *
 */
@RestController
@RequestMapping(value="/api/v2",produces = {"application/json"})

public class PlayListController {
	
	/**
	 * Initialize obect.
	 */
	@Autowired
	private PlayListDao dao;
	
	/**
	 * Api for getting all play list.
	 * @return : Object of PlayList class that contain data.
	 */
	@GetMapping("/getAllPlayList")
	public List<PlayList> getAllPlayList(){
		return dao.getPlayListInfo();
		
	
	}
	
	/**
	 * Api for getting all play list.
	 * @return : Object of PlayList class that contain data.
	 */
	@GetMapping("/getAllSongs")
	public List<SongsModel> getAllSongs(){
		return dao.getAllSongs();
		
	
	}
	
	/**
	 * Api for getting all play list by providing specific id.
	 * @param id:Id for playlist
	 * @return: Object of PlayList class that contain data.
	 */
	@GetMapping("/getPlayListById/{id}")
	public List<PlayList> getPlayListById(@PathVariable int id){
		System.out.println("PlayListController2");
		return dao.getPlayListById(id);
	}
	
	/**
	 * Api for getting all play list by providing specific id.
	 * @return: Object of PlayList class that contain data.
	 */
	@GetMapping("/getPLWithSongs")
	public List<PlayListWithSongs> getPLWithSongs(){
		System.out.println("PlayListController2");
		return dao.getPLWithSongs();
	}
	
	@GetMapping("/getSongsOfPL/{id}")
	public List<PlayListWithSongs> getSongsOfPL(@PathVariable int id){
		System.out.println("PlayListController2");
		return dao.getSongsOfPL(id);
	}
	
	@PostMapping("/createPL")
	public boolean createPlayList(@RequestBody String name){
		System.out.println("PlayListController2");
		return dao.createPlayList(name);	
	}
	
	@DeleteMapping("/deletePlayList")
	public boolean deletePlayList(int id){
		System.out.println("PlayListController2");
		return dao.deletePlayList(id);	
	}

	@PostMapping("/createSong")
	public boolean createSong(@RequestBody SongsModel smodel){
		System.out.println("PlayListController2");
		return dao.createSong(smodel.songName,smodel.singer);	
	}
	
	@DeleteMapping("/deleteSong")
	public boolean deleteSong(int id){
		System.out.println("PlayListController2");
		return dao.deleteSong(id);	
	}
	
	@PostMapping("/addSongToPL")
	public boolean addSongToPL(@RequestBody SongPlayListModel spModel){
		System.out.println("PlayListController2");
		return dao.addSongToPL(spModel.playlistId,spModel.songId);	
	}
	
	@DeleteMapping("/removeSongFrmPL")
	public boolean removeSongFrmPL(int playListId, int songId){
		System.out.println("PlayListController2");
		return dao.removeSongFrmPL(playListId,songId);	
	}

}
