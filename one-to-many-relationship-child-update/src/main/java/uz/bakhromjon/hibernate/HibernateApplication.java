package uz.bakhromjon.hibernate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import uz.bakhromjon.hibernate.entity.Announcement;
import uz.bakhromjon.hibernate.entity.Image;
import uz.bakhromjon.hibernate.repository.AnnouncementRepository;
import uz.bakhromjon.hibernate.repository.ImageRepository;

import java.util.List;

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
        Image image = new Image();
        image = imageRepository.save(image);

        List<Image> images = List.of(image);

        Announcement announcement = new Announcement("Title", images);
        announcementRepository.save(announcement);

        for (int i = 0; i < images.size(); i++) {
            images.get(i).setOrderNumber(i + 1);
        }
        imageRepository.saveAll(images);
    }
}

