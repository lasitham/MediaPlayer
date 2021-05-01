DROP PROCEDURE IF EXISTS sp_createSong;
DELIMITER $$
CREATE PROCEDURE `sp_createSong`(IN songname varchar(100),IN singer varchar(100))
BEGIN
	insert into SongsTbl(songName,singer) values(songname,singer);
END$$
DELIMITER ;

DROP PROCEDURE IF EXISTS sp_deleteSong;
DELIMITER $$
CREATE PROCEDURE `sp_deleteSong`(IN id smallint)
BEGIN
	delete from SongsTbl where songId = id ;
END$$

DELIMITER ;
DROP PROCEDURE IF EXISTS sp_createPlayList;
DELIMITER $$
CREATE PROCEDURE `sp_createPlayList`(IN playListName varchar(100))
BEGIN
	insert into PlayListTbl(name) values(playListName);
END$$

DELIMITER ;
DROP PROCEDURE IF EXISTS sp_deletePlayList;
DELIMITER $$
CREATE PROCEDURE `sp_deletePlayList`(IN id smallint)
BEGIN
	delete from PlayListTbl where playListId = id ;
END$$
DELIMITER ;

DROP PROCEDURE IF EXISTS sp_addSongsToPL;
DELIMITER $$
CREATE PROCEDURE `sp_addSongsToPL`(IN sId smallint,IN plId smallint)
BEGIN
	
    IF NOT EXISTS (select * from PlayListSongsTbl where playlistId = plId && songId =sId)
	THEN
		insert into PlayListSongsTbl(playlistId,songId) values(plId,sId);
	END IF;
END$$
DELIMITER ;

DROP PROCEDURE IF EXISTS sp_removeSongfrmPL;
DELIMITER $$
CREATE PROCEDURE `sp_removeSongfrmPL`(IN sId smallint,IN plId smallint)
BEGIN
	delete from PlayListSongsTbl where playlistId = plId and songId = sId;
END$$
DELIMITER ;

DROP PROCEDURE IF EXISTS sp_getPlayList;
DELIMITER $$
CREATE PROCEDURE `sp_getPlayList`(IN plId smallint)
BEGIN
	SELECT name,playlistId from PlayListTbl WHERE `playlistId` = plId ; 
END$$
DELIMITER ;

DROP PROCEDURE IF EXISTS sp_getAllPlayList;
DELIMITER $$
CREATE PROCEDURE `sp_getAllPlayList`()
BEGIN
	SELECT name,playlistId from PlayListTbl  ; 
END$$
DELIMITER ;

DROP PROCEDURE IF EXISTS sp_getSongsofPL;
DELIMITER $$
CREATE PROCEDURE `sp_getSongsofPL`(IN plId smallint)
BEGIN
	SELECT S.songName,S.singer,S.songId from PlayListSongsTbl as P  join SongsTbl as S    ON P.songId = S.songId
    where P.playlistId = plId; 
END$$
DELIMITER ;

DROP PROCEDURE IF EXISTS sp_getPLWithSongs;
DELIMITER $$
CREATE PROCEDURE `sp_getPLWithSongs`()
BEGIN
	SELECT S.songName,S.singer,S.songId,PL.name as 'PlayListName' from PlayListSongsTbl as P  join SongsTbl as S    ON P.songId = S.songId join PlayListTbl as PL on P.playlistId=PL.playlistId; 
END$$
DELIMITER ;