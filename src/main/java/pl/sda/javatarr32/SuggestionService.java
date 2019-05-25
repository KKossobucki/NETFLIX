package pl.sda.javatarr32;

import org.springframework.context.ApplicationEventPublisher;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class SuggestionService {
    private SuggestionRepository suggestionRepository;
    private ApplicationEventPublisher eventPublisher;

    public SuggestionService(SuggestionRepository suggestionRepository,
                             ApplicationEventPublisher eventPublisher) {
        this.suggestionRepository = suggestionRepository;
        this.eventPublisher = eventPublisher;
    }

    public void addSuggestion(Suggestion suggestion) {
        Suggestion addedSuggestion = suggestionRepository.save(suggestion);
        SuggestionAddedEvent event =
                new SuggestionAddedEvent(addedSuggestion, LocalDateTime.now());
        eventPublisher.publishEvent(event);
    }

    public List<Suggestion> findAll() {
        return suggestionRepository.findAll();
    }

    public List<Suggestion> findByAuthor(String name) {
        return suggestionRepository.findByAuthor(name);
    }
}
