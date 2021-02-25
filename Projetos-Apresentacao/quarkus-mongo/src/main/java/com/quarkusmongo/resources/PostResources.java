package com.quarkusmongo.resources;

import com.quarkusmongo.domain.Post;
import com.quarkusmongo.services.PostService;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value="/posts")
public class PostResources {

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
