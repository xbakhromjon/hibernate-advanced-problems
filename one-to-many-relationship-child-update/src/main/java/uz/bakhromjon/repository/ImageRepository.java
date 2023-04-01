package uz.bakhromjon.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import uz.bakhromjon.entity.Image;

@Repository
public interface ImageRepository extends JpaRepository<Image, Long> {
}
