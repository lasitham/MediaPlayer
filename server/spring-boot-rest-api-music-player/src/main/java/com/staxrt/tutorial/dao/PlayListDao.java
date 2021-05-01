package com.staxrt.tutorial.dao;

import java.util.List;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.staxrt.tutorial.model.PlayList;
import com.staxrt.tutorial.model.PlayListWithSongs;
import com.staxrt.tutorial.model.SongsModel;

/**
 * Class to communicate with DB.
 * @author lasithamukkunnathu
 *
 */
@Repository
public class PlayListDao {
	
	@Autowired
	private EntityManager em;
	
	/**
	 * get all playlist.
	 * @return: List<PlayList>
	 */
	@SuppressWarnings("unchecked")
	public List<PlayList> getPlayListInfo(){
		System.out.println("PlayListDao");
		return em.createNamedStoredProcedureQuery("playlist").getResultList();
	}
	
	/**
	 * get all songs.
	 * @return:List<SongsModel>
	 */
	@SuppressWarnings("unchecked")
	public List<SongsModel> getAllSongs(){
		System.out.println("PlayListDao");
		return em.createNamedStoredProcedureQuery("songlist").getResultList();
	}
	
	/**
	 * get playlist by providing id.
	 * @param input:id
	 * @return:List<PlayList>
	 */
	@SuppressWarnings("unchecked")
	public List<PlayList> getPlayListById(int input){
		System.out.println("PlayListDao--getPlayListById");
		return em.createNamedStoredProcedureQuery("playlistById").setParameter("plId",input).getResultList();
	}
	
	/**
	 * get songs of playlist.
	 * @param input:id
	 * @return List<PlayListWithSongs>
	 */
	@SuppressWarnings("unchecked")
	public List<PlayListWithSongs> getSongsOfPL(int input){
		System.out.println("PlayListDao--getPlayListById");
		return em.createNamedStoredProcedureQuery("songsOfPL").setParameter("plId",input).getResultList();
	}
	
	/**
	 * get play list and corresponding song details together.
	 * @return:List<PlayListWithSongs>
	 */
	@SuppressWarnings("unchecked")
	public List<PlayListWithSongs> getPLWithSongs(){
		System.out.println("PlayListDao--getPlayListById");
		return em.createNamedStoredProcedureQuery("plWithSongs").getResultList();
	}
	
	/**
	 * create play list.
	 * @param input:id
	 * @return: boolean
	 */
	@SuppressWarnings("unchecked")
	public boolean createPlayList(String input){
		System.out.println("PlayListDao--getPlayListById");
		return em.createNamedStoredProcedureQuery("createPL").setParameter("playListName",input).execute();
	}
	
	/**
	 * create a song .
	 * @param name: song name
	 * @param singer: singer
	 * @return: boolean
	 */
	@SuppressWarnings("unchecked")
	public boolean createSong(String name,String singer){
		System.out.println("PlayListDao--getPlayListById");
		return em.createNamedStoredProcedureQuery("createSong").setParameter("songname",name).setParameter("singer",singer).execute();
	}
	/**
	 * add song to play list.
	 * @param playId: play id
	 * @param songId: song id
	 * @return: boolean
	 */
	@SuppressWarnings("unchecked")
	public boolean addSongToPL(int playId, int songId){
		System.out.println("PlayListDao--getPlayListById");
		return em.createNamedStoredProcedureQuery("addSongToPL").setParameter("sId",songId).setParameter("plId",playId).execute();
	}
	
	/**
	 * remove song from play list.
	 * @param playId: play id
	 * @param songId: song id
	 * @return: boolean
	 */
	@SuppressWarnings("unchecked")
	public boolean removeSongFrmPL(int playId, int songId){
		System.out.println("PlayListDao--getPlayListById");
		return em.createNamedStoredProcedureQuery("removeSongFrmPL").setParameter("sId",songId).setParameter("plId",playId).execute();
	}
	
	/**
	 * delete song from list.
	 * @param input: id 
	 * @return: boolean
	 */
	@SuppressWarnings("unchecked")
	public boolean deleteSong(int input){
		System.out.println("PlayListDao--getPlayListById");
		return em.createNamedStoredProcedureQuery("deleteSong").setParameter("id",input).execute();
	}
	/**
	 * delete a play list.
	 * @param input:id
	 * @return: boolean
	 */
	@SuppressWarnings("unchecked")
	public boolean deletePlayList(int input){
		System.out.println("PlayListDao--getPlayListById");
		return em.createNamedStoredProcedureQuery("deletePlayList").setParameter("id",input).execute();
	}
	
}
