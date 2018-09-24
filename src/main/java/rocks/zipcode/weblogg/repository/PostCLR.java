package rocks.zipcode.weblogg.repository;

import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import rocks.zipcode.weblogg.model.Comment;
import rocks.zipcode.weblogg.model.Post;
import rocks.zipcode.weblogg.model.User;

@Component
public class PostCLR implements CommandLineRunner {
  private static final Logger log = Logger.getLogger("PostCLR");
  @Autowired
  private PostRepository postRepo;

  @Autowired
  private UserRepository userRepo;

  @Autowired
  private CommentRepository cmmtRepo;

  @Override
  public void run(String... args) {
    User usr;

    log.info("-------------------------------");
    log.info("Deleting all Demo data.");
    log.info("-------------------------------");
    cmmtRepo.deleteAllInBatch();
    postRepo.deleteAllInBatch();
    userRepo.deleteAllInBatch();

    log.info("-------------------------------");
    log.info("Adding Demo User.");
    log.info("-------------------------------");
    if (!userRepo.existsByUsername("anony@mous.coward")) {
      // User(String username, String passwordHash, String fullName)
      usr = new User("anony@mous.coward", "", "Anonymous Coward");
      userRepo.save(usr);
    } else {
      usr = userRepo.findByUsername("anony@mous.coward");
    }
    log.info("-------------------------------");
    log.info("Adding Demo Posts.");
    log.info("-------------------------------");
    if (!postRepo.existsByTitle("Hello World!")) {
      Post tom = new Post("Hello World!", "It's great to be here. Wonderful, really.");
      tom.setUser(usr);
      usr.addPost(tom);
      postRepo.save(tom);
      Comment cmt = new Comment();
      cmt.setText("amazing!");
      cmt.setPost(tom);
      cmmtRepo.save(cmt);
    }
    if (!postRepo.existsByTitle("Another Incredible!")) {
      Post tom = new Post("Another Incredible!", "It's great to be here. Wonderful, really.");
      usr.addPost(tom);
      tom.setUser(usr);
      postRepo.save(tom);
    }

    if (!postRepo.existsByTitle("Interesting Lorem!")) {
      Post tom = new Post("Interesting Lorem!",
          "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.");
      usr.addPost(tom);
      tom.setUser(usr);
      postRepo.save(tom);
    }

  }

}