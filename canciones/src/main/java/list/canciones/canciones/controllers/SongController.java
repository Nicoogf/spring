package list.canciones.canciones.controllers;

import list.canciones.canciones.models.Song;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestController
public class SongController {

    public List<Song> playlist = new ArrayList<>(Arrays.asList(
            new Song ( 1 , "Chau mohicano" , "FDAA")
    ));

    @GetMapping("/list")
    public List getPlaylist() {
        return playlist ;
    }
    @GetMapping("/list/{id}")
    public Song getSongID(@PathVariable int id) {
        for( Song cancion : playlist) {
            if( cancion.getID() == id ){
                return cancion ;
            }
        }
        return null ;
    }

    @PostMapping("/list")
    public Song postSong(@RequestBody Song newSong) {
        playlist.add(newSong);
        return newSong;
    }



}
