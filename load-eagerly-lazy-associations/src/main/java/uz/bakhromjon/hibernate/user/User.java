package uz.bakhromjon.hibernate.user;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import uz.bakhromjon.hibernate.announcement.Announcement;


@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "users")
public class User {
    @Id
    private Long id;

    private String phone;
    private String flm;

    @ManyToOne(fetch = FetchType.LAZY)
    private Announcement announcement;


    public User(Long id, String phone, String flm) {
        this.id = id;
        this.phone = phone;
        this.flm = flm;
    }
}
