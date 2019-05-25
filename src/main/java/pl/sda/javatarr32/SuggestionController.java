package pl.sda.javatarr32;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/suggestions")
public class SuggestionController {

    private SuggestionService suggestionService;

    public SuggestionController(SuggestionService suggestionService) {
        this.suggestionService = suggestionService;
    }

    @PostMapping
    public void addSuggestion(@RequestBody Suggestion suggestion) {
        suggestionService.addSuggestion(suggestion);
    }

    @GetMapping
    public List<Suggestion> getSuggestions() {
        return suggestionService.findAll();
    }

    @GetMapping(params = "name")
    public List<Suggestion> getSuggestionByAuthor(@RequestParam String name) {
        return suggestionService.findByAuthor(name);
    }
}
