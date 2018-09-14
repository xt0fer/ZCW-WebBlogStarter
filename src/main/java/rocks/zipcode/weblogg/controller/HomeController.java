package rocks.zipcode.weblogg.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import rocks.zipcode.weblogg.model.Post;

@Controller
public class HomeController {
    @Autowired
    PostController postController;

@RequestMapping("/")
    public String index() {
        return "index";
    }

@RequestMapping(value = "/list", method = RequestMethod.GET)
    public String postList(Model model) {
        List<Post> posts = postController.listAll();
        model.addAttribute("posts", posts);
        return "list";
    }
}