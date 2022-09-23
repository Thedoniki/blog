package com.example.blog.Repository;

import com.example.blog.Entity.Posts;
import org.hibernate.cache.spi.support.AbstractReadWriteAccess;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface PostsRepository extends JpaRepository<Posts, Integer> {
    Posts getPostsById(int id);

    Posts deleteById(int id);

    Posts findById(int id);

    @Override
    List<Posts> findAll();

    @Query("SELECT p FROM Posts p WHERE CONCAT(p.title, p.text, p.creationDate) LIKE %?1%")
    List<Posts> search(String keyword);

}


