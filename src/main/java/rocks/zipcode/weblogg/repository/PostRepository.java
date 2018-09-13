package rocks.zipcode.weblogg.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import rocks.zipcode.weblogg.model.Post;

@Repository
public interface PostRepository extends JpaRepository<Post, Long> {

}