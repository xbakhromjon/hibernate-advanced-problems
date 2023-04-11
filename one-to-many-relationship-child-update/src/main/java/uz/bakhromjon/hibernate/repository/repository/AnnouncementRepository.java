package uz.bakhromjon.hibernate.repository.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import uz.bakhromjon.hibernate.repository.entity.Announcement;

@Repository
public interface AnnouncementRepository extends JpaRepository<Announcement, Long> {
}
