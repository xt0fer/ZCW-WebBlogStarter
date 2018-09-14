package rocks.zipcode.weblogg.repository;

import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import rocks.zipcode.weblogg.model.Post;

@Component
public class PostCLR implements CommandLineRunner {
 private static final Logger log = Logger.getLogger("PostCLR");
 @Autowired
 private PostRepository postRepo;

 @Override
 public void run(String...args) {
  log.info("-------------------------------");
  log.info("Adding Demo Posts.");
  log.info("-------------------------------");
  if (!postRepo.existsByTitle("Hello World!")) { 
    Post tom = new Post("Hello World!", "It's great to be here. Wonderful, really.");
    postRepo.save(tom);
  }
  if (!postRepo.existsByTitle("Another Incredible!")) { 
    Post tom = new Post("Another Incredible!", "It's great to be here. Wonderful, really.");
    postRepo.save(tom);
  }

  if (!postRepo.existsByTitle("Interesting Lorem!")) { 
    Post tom = new Post("Interesting Lorem!", "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.");
    postRepo.save(tom);
  }

 }

}