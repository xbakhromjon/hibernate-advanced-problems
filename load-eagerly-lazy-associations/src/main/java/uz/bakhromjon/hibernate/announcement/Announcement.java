package uz.bakhromjon.hibernate.announcement;

import jakarta.persistence.*;
import lombok.*;
import uz.bakhromjon.hibernate.complaint.Complaint;
import uz.bakhromjon.hibernate.user.User;

import java.util.List;
import java.util.Set;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "announcement")
public class Announcement {
    @Id
    private Long id;

    private String address;
    private Double longitude;
    private Double latitude;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "announcement")
    private Set<User> owners;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "announcement")
    private Set<Complaint> complaints;

    public Announcement(Long id, String address, Double longitude, Double latitude) {
        this.id = id;
        this.address = address;
        this.longitude = longitude;
        this.latitude = latitude;
    }
}
