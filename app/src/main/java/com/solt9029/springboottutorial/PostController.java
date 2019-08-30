package com.solt9029.springboottutorial;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/posts")
public class PostController {
    private final PostService service;

    @Autowired
    public PostController(PostService service) {
        this.service = service;
    }

    @GetMapping("")
    List<Post> index() {
        return service.findAll();
    }

    @PostMapping("")
    Post create(@Valid @RequestBody Post post) {
        return service.save(post);
    }

    @DeleteMapping("/{id}")
    void destroy(@PathVariable Long id) {
        service.deleteById(id);
    }
}
