package pe.edu.trivia.backend_game.controller;

import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pe.edu.trivia.backend_game.collection.Level;
import pe.edu.trivia.backend_game.collection.Question;
import pe.edu.trivia.backend_game.service.LevelService;

import java.util.List;

@RestController
@RequestMapping("/api/level")
@AllArgsConstructor
public class LevelController {

    private final LevelService levelService;
    @GetMapping("/getAll")
    public List<Level> fetchAllGamesOfline(){
        return levelService.getAllLevels();
    }
    @PostMapping("/search")
    public List<Level> searchLevels(@RequestParam String keyword) {
        return levelService.searchLevels(keyword);
    }
    @PostMapping("/save")
    public String saveLevel(@RequestBody Level level) {
        return levelService.save(level);
    }

    @PutMapping("/update")
    public ResponseEntity<String> updateLevel(@RequestBody Level updatedLevel) {
        String response = levelService.updateLevel(updatedLevel);
        return ResponseEntity.ok(response);
    }
}