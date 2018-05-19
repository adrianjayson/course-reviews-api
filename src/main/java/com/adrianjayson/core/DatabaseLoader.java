package com.adrianjayson.core;

import com.adrianjayson.course.Course;
import com.adrianjayson.course.CourseRepository;
import com.adrianjayson.review.Review;
import com.adrianjayson.user.User;
import com.adrianjayson.user.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

@Component
public class DatabaseLoader implements ApplicationRunner {
    private final CourseRepository COURSES;
    private final UserRepository users;

    private final Logger log = LoggerFactory.getLogger(DatabaseLoader.class);

    @Autowired
    public DatabaseLoader(CourseRepository COURSES, UserRepository users) {
        this.COURSES = COURSES;
        this.users = users;
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {
        log.info("Loading data to database...");

        List<User> students = Arrays.asList(
                new User("jacobproffer", "Jacob",  "Proffer", "password", new String[] {"ROLE_USER"}),
                new User("mlnorman", "Mike",  "Norman", "password", new String[] {"ROLE_USER"}),
                new User("k_freemansmith", "Karen",  "Freeman-Smith", "password", new String[] {"ROLE_USER"}),
                new User("seth_lk", "Seth",  "Kroger", "password", new String[] {"ROLE_USER"}),
                new User("mrstreetgrid", "Java",  "Vince", "password", new String[] {"ROLE_USER"}),
                new User("anthonymikhail", "Tony",  "Mikhail", "password", new String[] {"ROLE_USER"}),
                new User("boog690", "AJ",  "Teacher", "password", new String[] {"ROLE_USER"}),
                new User("faelor", "Erik",  "Faelor Shafer", "password", new String[] {"ROLE_USER"}),
                new User("christophernowack", "Christopher",  "Nowack", "password", new String[] {"ROLE_USER"}),
                new User("calebkleveter", "Caleb",  "Kleveter", "password", new String[] {"ROLE_USER"}),
                new User("richdonellan", "Rich",  "Donnellan", "password", new String[] {"ROLE_USER"}),
                new User("albertqerimi", "Albert",  "Qerimi", "password", new String[] {"ROLE_USER"})
        );

        users.save(students);
        users.save(new User("adrianjayson13", "Adrian", "Catambay", "adrianImmortal", new String[]{"ROLE_USER", "ROLE_ADMIN"}));

        Course course1 = new Course("Java Basics", "https://teamtreehouse.com/library/java-basics");
        course1.addReview(new Review(5, "This course is great!", students.get(2)));
        course1.addReview(new Review(3, "Alright but lacks detailed explanation.", students.get(5)));
        COURSES.save(course1);

        Course course2 = new Course("Hibernate Basics", "https://teamtreehouse.com/library/hibernate-basics");
        course2.addReview(new Review(5, "This course is excellent!", students.get(6)));
        COURSES.save(course2);
    }
}
