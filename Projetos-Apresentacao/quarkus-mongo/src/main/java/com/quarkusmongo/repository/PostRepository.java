package com.quarkusmongo.repository;

import com.quarkusmongo.domain.Post;
import io.quarkus.mongodb.panache.PanacheMongoRepository;
import io.quarkus.mongodb.panache.PanacheMongoRepositoryBase;
import org.bson.types.ObjectId;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.enterprise.context.ApplicationScoped;
import java.util.List;

@Repository
public class PostRepository implements PanacheMongoRepositoryBase<Post,String>  {
    @Query("{ 'title': { $regex: ?0, $options: 'i' } }")
    List<Post> searchTitle(String text) {
        return null;
    }
}
