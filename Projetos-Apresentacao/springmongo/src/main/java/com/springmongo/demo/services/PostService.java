package com.springmongo.demo.services;

import com.springmongo.demo.domain.Post;
import com.springmongo.demo.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class PostService {

    // instaciação do repósitorio
    @Autowired
    private PostRepository repo;


    public Post findById(String id){

        Optional<Post> optPost = repo.findById(id);


        if (optPost.isPresent()) {
            System.out.println("Entrou");
        }
        else {
            System.out.println("N entrou");
            System.out.println(optPost);
        }
        //obtençao da entidade user através do objeto optional para entity
        Post post = optPost.get();
        return post;

		/*Optional<User> obj= repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado"));*/
    }

    public List<Post> findByTitle(String text){
        return repo.searchTitle(text);
    }

    public List<Post> fullSearch(String text, Date minDate, Date maxDate){
        maxDate = new Date(maxDate.getTime()+24*60*60*1000);
        return repo.fullSearch(text, minDate, maxDate);
    }

    public Post salvarPost (Post post){
        if (post != null){
            repo.save(post);
            return post;
        }
        else{
            return null;
        }
    }
}
