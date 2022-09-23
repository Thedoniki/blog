package com.example.blog.Service;

import com.example.blog.Entity.Posts;
import com.example.blog.Repository.PostsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;

@Service

public class PostService {
    @Autowired
    private PostsRepository postsRepository;


    public Posts findById(Integer id) {
        return postsRepository.findById(id).orElse(null);
    }

    public List<Posts> getAllPosts() {
        return postsRepository.findAll();
    }


    public Posts addPost(Posts posts) {
        return postsRepository.save(posts);

    }

    public Posts deleteById(int id) {
        return postsRepository.deleteById(id);
    }


    public Posts updatePost(Posts posts) {
        Posts existingPosts = postsRepository.findById(posts.getId()).orElse(null);
        existingPosts.setTitle(posts.getTitle());
        existingPosts.setText(posts.getText());
        return postsRepository.save(existingPosts);
    }
    public Posts findPostById(int id){
        return postsRepository.findById(id);
    }

    public Posts getPostById(int id) {
        return postsRepository.findById(id);
    }

    public List<Posts> listAll(String keyword) {
      if (keyword != null) {

    }
     return postsRepository.findAll();
      }
    public List<Posts> search(String key) { return postsRepository.search(key); }


    public Object findAll(PageRequest paging) {
        return postsRepository;
    }
}
