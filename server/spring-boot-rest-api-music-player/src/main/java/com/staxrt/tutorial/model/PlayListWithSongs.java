package com.staxrt.tutorial.model;

import javax.persistence.*;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table
@Getter
@Setter
@NamedStoredProcedureQueries({@NamedStoredProcedureQuery(name="plWithSongs",procedureName="sp_getPLWithSongs"),@NamedStoredProcedureQuery(name="songsOfPL",procedureName="sp_getSongsOfPL",parameters= {@StoredProcedureParameter(mode=ParameterMode.IN,name="plId",type=Integer.class)})})
public class PlayListWithSongs {
@Id	
private int id;
private String songName;
private String singer;
private String playListName;

}