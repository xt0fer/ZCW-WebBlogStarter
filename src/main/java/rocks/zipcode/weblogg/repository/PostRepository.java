package rocks.zipcode.weblogg.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import rocks.zipcode.weblogg.model.Post;

@Repository
@Transactional // do you  need this for mysql??
public interface PostRepository extends JpaRepository<Post, Long> {

}