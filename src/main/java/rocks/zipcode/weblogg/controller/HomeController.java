package rocks.zipcode.weblogg.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.data.web.SpringDataWebProperties.Pageable;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import rocks.zipcode.weblogg.model.Comment;
import rocks.zipcode.weblogg.model.Post;
import rocks.zipcode.weblogg.model.User;
import rocks.zipcode.weblogg.repository.UserRepository;

@Controller
public class HomeController {
    @Autowired
    PostController postController;

    @Autowired
    CommentController commentController;

    @Autowired
    UserRepository userRepository;

    @RequestMapping("/")
    public String index() {
        return "index";
    }

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public String postList(Model model) {
        List<Post> posts = postController.listAll();
        // List<Comment> comments = commentController.getAllCommentsByPostId(postId, pageable);
        model.addAttribute("posts", posts);
        return "list";
    }
    @RequestMapping(value = "/user/{userid}", method = RequestMethod.GET)
    public String showUser(@PathVariable Long userid, Model model) {
        Optional<User> usr = userRepository.findById(userid);
        if (usr.isPresent()){
            User foo = usr.get();
            model.addAttribute("user", foo);
        } 
        return "user";
    }
}