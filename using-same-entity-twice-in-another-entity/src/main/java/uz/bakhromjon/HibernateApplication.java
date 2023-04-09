package uz.bakhromjon;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import uz.bakhromjon.entity.Announcement;
import uz.bakhromjon.entity.Image;
import uz.bakhromjon.repository.AnnouncementRepository;
import uz.bakhromjon.repository.ImageRepository;

import java.util.List;
import java.util.Optional;

@SpringBootApplication
public class HibernateApplication implements CommandLineRunner {
    @Autowired
    private AnnouncementRepository announcementRepository;
    @Autowired
    private ImageRepository imageRepository;

    public static void main(String[] args) {
        SpringApplication.run(HibernateApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        Image image = new Image(1);
        image = imageRepository.save(image);

        Announcement announcement = Announcement.builder().title("Title").images(List.of(image)).build();
        announcement = announcementRepository.save(announcement);

        Optional<Announcement> optional = announcementRepository.findById(announcement.getId());

        announcementRepository.save(optional.get());
    }
}