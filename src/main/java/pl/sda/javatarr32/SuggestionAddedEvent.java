package pl.sda.javatarr32;

import lombok.Value;

import java.time.LocalDateTime;

@Value
public class SuggestionAddedEvent {
    private Suggestion suggestion;
    private LocalDateTime timestamp;
}
