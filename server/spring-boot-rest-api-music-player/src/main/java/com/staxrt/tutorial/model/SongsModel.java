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
@NamedStoredProcedureQueries({@NamedStoredProcedureQuery(name="songlist",procedureName="sp_getAllSongs")})
@Builder
@Value
public class SongsModel {
	@Id	
	public int songId;
	public String songName;
	public String singer;

}
