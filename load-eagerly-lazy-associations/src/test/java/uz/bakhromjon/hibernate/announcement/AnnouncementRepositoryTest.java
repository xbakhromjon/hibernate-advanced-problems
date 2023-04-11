package uz.bakhromjon.hibernate.announcement;

import static org.assertj.core.api.Assertions.assertThat;

import org.hibernate.Hibernate;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.jdbc.Sql;

import java.util.Optional;

@DataJpaTest
class AnnouncementRepositoryTest {
    @Autowired
    private AnnouncementRepository underTest;

    @Test
    @Sql("AnnouncementRepositoryTest.sql")
    void findByIdWithLoadUserAndComplaintEagerly() {
        Optional<Announcement> optional = underTest.findByIdWithOwnersAndComplaints(1L);

        assertThat(optional).isPresent();
        assertThat(Hibernate.isInitialized(optional.get().getOwners())).isTrue();
        assertThat(Hibernate.isInitialized(optional.get().getComplaints())).isTrue();
    }

    @Test
    @Sql("AnnouncementRepositoryTest.sql")
    void findByIdWithLoadOwnersEagerly() {
        Optional<Announcement> optional = underTest.findByIdWithOwners(1L);

        assertThat(optional).isPresent();
        assertThat(Hibernate.isInitialized(optional.get().getOwners())).isTrue();
    }

    @Test
    @Sql("AnnouncementRepositoryTest.sql")
    void findByIdWithLoadComplaintEagerly() {
        Optional<Announcement> optional = underTest.findByIdWithComplaints(1L);

        assertThat(optional).isPresent();
        assertThat(Hibernate.isInitialized(optional.get().getComplaints())).isTrue();
    }

    @Test
    @Sql("AnnouncementRepositoryTest.sql")
    void findByIdBare() {
        Optional<Announcement> optional = underTest.findById(1L);

        assertThat(optional).isPresent();
    }

}

