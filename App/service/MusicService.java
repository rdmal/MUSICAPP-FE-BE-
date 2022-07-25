package com.example.Music.App.service;

import com.example.Music.App.dao.MusicDao;
import com.example.Music.App.model.Music;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MusicService {
      private final MusicDao musicDao;

      @Autowired
      public MusicService(@Qualifier("MusicRepository") MusicDao musicDao) {this.musicDao= musicDao;}
    public int insertMusic(int id, Music music){
        return musicDao.insertMusic(id, music);
    }
    public int insertMusic( Music music){
        return musicDao.insertMusic(music);
    }
    public int updateMusic(int id,Music music ) {
        return musicDao.updateMusic(id, music);
    }
    public int deleteMusic(int id){
        return musicDao.deleteMusic(id);

    }
    public List<Music> queryMusic(){
        return musicDao.queryMusic();
    }
    public Optional<Music> queryMusic(int id ) {
        return musicDao.queryMusic(id);

    }
}