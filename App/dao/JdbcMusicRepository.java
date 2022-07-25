package com.example.Music.App.dao;


import com.example.Music.App.model.Music;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.IncorrectResultSizeDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository ("MusicRepository")
public class JdbcMusicRepository implements MusicDao {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public int insertMusic(int id,Music music) {
        String sql = "INSERT INTO MUSICAPP (SongName,genre,artist,duration) VALUES (?, ?,?,?)";
        return jdbcTemplate.update(sql,
               new Object[]{music.getSongName(),music.getGenre(),music.getArtist(),
                       music.getDuration(), id});
    }

    @Override
    public int updateMusic(int id, Music music) {
        String sql= "UPDATE MUSICAPP SET SONGNAME=?, GENRE=? ,ARTIST=?, DURATION =? WHERE ID =?";
        return jdbcTemplate.update(sql,
                new Object[]{music.getSongName(), music.getGenre(),music.getArtist(), music.getDuration(), id});
    }

    @Override
    public int deleteMusic(int id) {
        String sql = "DELETE FROM MUSICAPP WHERE ID=?";
        return jdbcTemplate.update(sql, id);
    }

    @Override
    public List<Music> queryMusic() {
        String sql = "SELECT * FROM MUSICAPP";
        return jdbcTemplate.query(sql,
                BeanPropertyRowMapper.newInstance(Music.class));
    }

    @Override
    public Optional<Music> queryMusic(int id) {
        Music music = null;
        try {
            String sql = "SELECT * FROM MUSICAPP WHERE ID=?";
            music = jdbcTemplate.queryForObject(sql,
                    BeanPropertyRowMapper.newInstance(Music.class), id);
            return Optional.ofNullable(music);
        } catch (IncorrectResultSizeDataAccessException e) {
            return Optional.ofNullable(music);
        }
    }
}