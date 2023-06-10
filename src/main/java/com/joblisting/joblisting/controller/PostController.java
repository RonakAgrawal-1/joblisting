package com.joblisting.joblisting.controller;

import com.joblisting.joblisting.repository.PostRepository;
import com.joblisting.joblisting.model.Post;
import com.joblisting.joblisting.repository.SearchRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.annotations.ApiIgnore;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@RestController
public class PostController {

    @Autowired
    PostRepository repository;

    @Autowired
    SearchRepository searchRepository;

    @ApiIgnore
    @RequestMapping(value = "/")
    public void redirect(HttpServletResponse response) throws IOException {
        response.sendRedirect("/swagger-ui.html");
    }

    @GetMapping("/posts")
    public List<Post> getAllPosts() {
        return repository.findAll();
    }

    @GetMapping("/search/{text}")
    public List<Post> search(@PathVariable String text) {
         return searchRepository.findByText(text);
    }

    @PostMapping("/post")
    public Post addPost(@RequestBody Post post) {
        return repository.save(post);
    }
}
