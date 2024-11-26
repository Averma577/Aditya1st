package com.crm.Controller;

import com.crm.entity.Post;
import com.crm.repository.CommentRepository;
import com.crm.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/posts")
public class PostController {

    private PostRepository postRepository;


    public PostController(PostRepository postRepository) {
        this.postRepository = postRepository;

    }
    @PostMapping
    public String createPost(
          @RequestBody Post post
    ){
        postRepository.save(post);
        return "record is saved";
    }
@DeleteMapping
    public  void deletePost(){
      postRepository.deleteById(1L);
    }



}
