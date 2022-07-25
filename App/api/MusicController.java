package com.example.Music.App.api;

import com.example.Music.App.model.Music;
import com.example.Music.App.service.MusicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value="musicapp/")   // localhost:8080/musicapp/
public class MusicController {
    private final  MusicService musicService;
    @Autowired
    public MusicController (MusicService musicService) { this.musicService = musicService;}

    @PostMapping(value = "", consumes = MediaType.APPLICATION_JSON_VALUE)
    int insertMusic(@RequestBody Music music) {
        return musicService.insertMusic(music);
    }

    @PutMapping(value = "{id}")
    int updateMusic(@PathVariable("id") int id, @RequestBody Music music) {
        return musicService.updateMusic(id, music);
    }

    @DeleteMapping(value = "{id}")
    int deleteMusic(@PathVariable("id") int id) {
        return musicService.deleteMusic(id);
    }

    @GetMapping
    List<Music> queryMusic() {
        return musicService.queryMusic();
    }

    @GetMapping(value = "{id}")
    Optional<Music> queryMusic(@PathVariable("id") int id) {
        return musicService.queryMusic(id);
    }

    }





