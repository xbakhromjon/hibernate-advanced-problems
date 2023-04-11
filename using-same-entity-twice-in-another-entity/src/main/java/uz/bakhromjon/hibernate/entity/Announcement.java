package uz.bakhromjon.hibernate.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;


@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "announcement")
@AllArgsConstructor
@Builder
public class Announcement {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;

    @OneToMany(fetch = FetchType.EAGER)
    private List<Image> images = new ArrayList<>();

    @OneToMany(fetch = FetchType.EAGER)
    private List<Image> plans = new ArrayList<>();


}
