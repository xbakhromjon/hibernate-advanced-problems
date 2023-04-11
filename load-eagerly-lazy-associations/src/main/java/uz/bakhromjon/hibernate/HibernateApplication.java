package uz.bakhromjon.hibernate;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.hibernate.Hibernate;
import org.hibernate.jpa.QueryHints;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import uz.bakhromjon.hibernate.announcement.Announcement;
import uz.bakhromjon.hibernate.announcement.AnnouncementRepository;
import uz.bakhromjon.hibernate.complaint.Complaint;
import uz.bakhromjon.hibernate.complaint.ComplaintRepository;
import uz.bakhromjon.hibernate.user.User;
import uz.bakhromjon.hibernate.user.UserRepository;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@SpringBootApplication
public class HibernateApplication implements CommandLineRunner {

    @Autowired
    private AnnouncementRepository announcementRepository;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private ComplaintRepository complaintRepository;

    @Autowired
    private EntityManager em;

    public static void main(String[] args) {
        SpringApplication.run(HibernateApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
    }
}


