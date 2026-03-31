package com.cg.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.cg.entity.Track;
import com.cg.repo.TrackRepository;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/tracks")
public class TrackController {

    @Autowired
    private TrackRepository repository;

    @PostMapping
    public ResponseEntity<String> addTrack(@RequestBody Track track) {
        if (track != null) {
            repository.save(track);
            return ResponseEntity.ok("Track added successfully");
        } else {
            return ResponseEntity.badRequest().body("Invalid track data");
        }
    }

    @GetMapping
    public ResponseEntity<List<Track>> getTracks() {
        List<Track> list = repository.findAll();
        if (!list.isEmpty()) {
            return ResponseEntity.ok(list);
        } else {
            return ResponseEntity.status(404).build();
        }
    }

    @GetMapping("/title/{title}")
    public ResponseEntity<List<Track>> getTracksByTitle(@PathVariable String title) {
        List<Track> list = repository.findByTitle(title);
        if (!list.isEmpty()) {
            return ResponseEntity.ok(list);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> getTrack(@PathVariable Long id) {
        Optional<Track> track = repository.findById(id);
        if (track.isPresent()) {
            return ResponseEntity.ok(track.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}