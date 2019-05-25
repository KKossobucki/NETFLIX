package pl.sda.javatarr32;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Data
@Entity
public class Suggestion {
    private String link;
    private Rate rate;
    private String title;
    private String author;
    @Id
    @GeneratedValue
    private Long id;
}
