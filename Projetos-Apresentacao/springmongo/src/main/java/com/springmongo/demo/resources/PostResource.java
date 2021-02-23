package com.springmongo.demo.resources;

import com.springmongo.demo.domain.Post;
import com.springmongo.demo.services.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping(value="/posts")
public class PostResource {

    @Autowired
    private PostService service;


    @GetMapping(value= "/{id}")
    public ResponseEntity<Post> findById(@PathVariable String id){
        Post obj = service.findById(id);
        return ResponseEntity.ok().body(obj);
    }

    @PostMapping
    public ResponseEntity<Post> salvarPost(@RequestBody Post post){
        Post post2 = service.salvarPost(post);
        if (post2!=null){
            return ResponseEntity.ok().body(post);
        }
        else{
            return  ResponseEntity.noContent().build();
        }
    }
}
