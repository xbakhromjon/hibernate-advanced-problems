package uz.bakhromjon.hibernate.announcement;

import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AnnouncementRepository extends JpaRepository<Announcement, Long> {
    Optional<Announcement> findById(long id);

    @EntityGraph(attributePaths = {"owners", "complaints"})
    @Query("select a from Announcement a where a.id = :id")
    Optional<Announcement> findByIdWithOwnersAndComplaints(@Param(value = "id") long id);

    @EntityGraph(attributePaths = {"owners"})
    @Query("select a from Announcement a where a.id = :id")
    Optional<Announcement> findByIdWithOwners(@Param(value = "id") long id);


    @EntityGraph(attributePaths = {"complaints"})
    @Query("select a from Announcement a where a.id = :id")
    Optional<Announcement> findByIdWithComplaints(@Param(value = "id") long id);

}
