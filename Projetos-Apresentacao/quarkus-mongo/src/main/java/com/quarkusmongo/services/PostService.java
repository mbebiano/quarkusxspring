package com.quarkusmongo.services;

import com.quarkusmongo.domain.Post;
import com.quarkusmongo.repository.PostRepository;
import org.bson.types.ObjectId;
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

        Optional<Post> optPost = Optional.ofNullable(repo.findById(id));


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




    public Post salvarPost (Post post){
        if (post != null){
            post.persist();
            return post;
        }
        else{
            return null;
        }
    }
}
