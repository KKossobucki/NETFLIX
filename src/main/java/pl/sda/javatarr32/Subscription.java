package pl.sda.javatarr32;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;

@Data
@Entity
public class Subscription {
    @Id
    private String mail;
}
