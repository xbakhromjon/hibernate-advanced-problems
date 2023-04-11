package uz.bakhromjon.hibernate.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import uz.bakhromjon.hibernate.entity.Image;

@Repository
public interface ImageRepository extends JpaRepository<Image, Long> {
}
