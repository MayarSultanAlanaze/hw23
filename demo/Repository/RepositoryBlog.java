package com.example.demo.Repository;

import com.example.demo.Model.Blog;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface  RepositoryBlog extends JpaRepository<Blog,Integer> {
    Blog findBlogById(Integer id);
    List<Blog>findBlogByUserId(Integer id);

    Blog findBlogByTitle(String title);

}
