package com.example.Music.App.dao;

import com.example.Music.App.model.Music;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.Random;

@Repository
public interface MusicDao {
    default int insertMusic( Music music) {
        Random rand = new Random();
        int id = rand.nextInt();
        return insertMusic(id, music);
    }
    int insertMusic(int id,Music music );
    int updateMusic(int id, Music music);
    int deleteMusic(int id);
    List<Music> queryMusic();

    Optional<Music> queryMusic(int id);

}
