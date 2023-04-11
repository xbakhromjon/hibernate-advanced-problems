package uz.bakhromjon.hibernate.complaint;

import jakarta.persistence.*;
import lombok.*;
import uz.bakhromjon.hibernate.announcement.Announcement;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "complaint")
public class Complaint {
    @Id
    private Long id;
    private String title;
    private String message;

    @ManyToOne(fetch = FetchType.LAZY)
    private Announcement announcement;


    public Complaint(Long id, String title, String message) {
        this.id = id;
        this.title = title;
        this.message = message;
    }
}
