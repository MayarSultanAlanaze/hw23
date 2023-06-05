package com.example.demo.Service;

import com.example.demo.ApiException.ApiException;
import com.example.demo.Model.Blog;
import com.example.demo.Model.User;
import com.example.demo.Repository.RepositoryBlog;
import com.example.demo.Repository.RepositoryUser;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BlogService {

        private final RepositoryUser repositoryUser;
        private final RepositoryBlog repositoryBlog;
        public void assignBlogToUser(Integer user_id,Integer blog_id){

           User user=repositoryUser.findUserById(user_id);
           Blog blog=repositoryBlog.findBlogById(blog_id);
            if(user==null||blog==null){
                throw new ApiException(" wrong id");
            }
            blog.setUser(user);
            repositoryBlog.save(blog);
        }

        public List<Blog>getBlogs(Integer userId) {
            return repositoryBlog.findBlogByUserId(userId);
        }


        public void addBlog(Integer userId, Blog blog){
            User user=repositoryUser.findUserById(userId);
            blog.setUser(user);
            repositoryBlog.save(blog);
        }

        public void updateBlog(Integer userId, Blog blog, Integer blogid){

            Blog oldBlog=repositoryBlog.findBlogById(blogid);
            if(oldBlog==null) {
                throw new ApiException("not found");
            }

            if(oldBlog.getUser().getId()!=userId) {
                throw new ApiException(" Blog doesn't belong to you");
            }

            oldBlog.setTitle(blog.getTitle());
            oldBlog.setBody(blog.getBody());
            repositoryBlog.save(oldBlog);
        }

        public void deleteBlog(Integer userId, Integer blogid){
            //check if Blog  exist

            Blog oldBlog=repositoryBlog.findBlogById(blogid);
            if(oldBlog==null )
            {
                throw new ApiException(" not found");
            }

            if(oldBlog.getUser().getId()!=userId) {
                throw new ApiException(" Blog doesn't belong to you");
            }
            repositoryBlog.delete(oldBlog);
        }
        public List<Blog> getAllBlogs(){
            return repositoryBlog.findAll();
        }

        public Blog findById(Integer id){
            Blog idBlog=repositoryBlog.findBlogById(id);
            if(idBlog==null){
                throw new ApiException("not found");
            }
            return idBlog;
        }
        public Blog findByTitle(String title){
            Blog titleBlog=repositoryBlog.findBlogByTitle(title);
            if(title==null){
                throw new ApiException("not found");
            }
            return titleBlog;
        }
    }

