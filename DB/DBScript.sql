
CREATE DATABASE IF NOT EXISTS MusicDB;

Use MusicDB;

CREATE TABLE IF NOT EXISTS PlayListTbl ( 
 playlistId smallint unsigned not null auto_increment,
 name varchar(100) not null,
 constraint pk_playlistId primary key (playlistId) );

 CREATE TABLE IF NOT EXISTS SongsTbl ( 
 songId smallint unsigned not null auto_increment,
 songName varchar(100) not null,
 singer varchar(100) ,
 constraint pk_songId primary key (songId) );
  
  CREATE TABLE IF NOT EXISTS PlayListSongsTbl ( 
 playlistId smallint unsigned not null auto_increment,
 songId smallint unsigned not null,
 
 primary key (playlistId,songId),
 
 FOREIGN KEY (playlistId)
        REFERENCES PlayListTbl(playlistId)
        ON DELETE CASCADE,
 
 FOREIGN KEY (songId)
        REFERENCES SongsTbl(songId)
        ON DELETE CASCADE);
 
 