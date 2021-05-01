package com.staxrt.tutorial.model;

import javax.persistence.*;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.Value;

@Entity
@Table
@Getter
@Setter
@NamedStoredProcedureQueries({@NamedStoredProcedureQuery(name="playlist",procedureName="sp_getAllPlayList"),
	@NamedStoredProcedureQuery(name="playlistById",procedureName="sp_getPlayList",
parameters= {@StoredProcedureParameter(mode=ParameterMode.IN,name="plId",type=Integer.class)}),
	@NamedStoredProcedureQuery(name="createPL",procedureName="sp_createPlayList",
parameters= {@StoredProcedureParameter(mode=ParameterMode.IN,name="playListName",type=String.class)}),
	@NamedStoredProcedureQuery(name="createSong",procedureName="sp_createSong",
	parameters= {@StoredProcedureParameter(mode=ParameterMode.IN,name="songname",type=String.class),
				@StoredProcedureParameter(mode=ParameterMode.IN,name="singer",type=String.class)}),
	@NamedStoredProcedureQuery(name="addSongToPL",procedureName="sp_addSongsToPL",
	parameters= {@StoredProcedureParameter(mode=ParameterMode.IN,name="sId",type=Integer.class),
				@StoredProcedureParameter(mode=ParameterMode.IN,name="plId",type=Integer.class)}),
	@NamedStoredProcedureQuery(name="removeSongFrmPL",procedureName="sp_removeSongfrmPL",
	parameters= {@StoredProcedureParameter(mode=ParameterMode.IN,name="sId",type=Integer.class),
				@StoredProcedureParameter(mode=ParameterMode.IN,name="plId",type=Integer.class)}),
	@NamedStoredProcedureQuery(name="deleteSong",procedureName="sp_deleteSong",
	parameters= {@StoredProcedureParameter(mode=ParameterMode.IN,name="id",type=Integer.class)}),
	@NamedStoredProcedureQuery(name="deletePlayList",procedureName="sp_deletePlayList",
	parameters= {@StoredProcedureParameter(mode=ParameterMode.IN,name="id",type=Integer.class)})})
@Builder
@Value
public class PlayList {
@Id	
private int id;
private String name;
private boolean insertStat;


}
