package com.example.blog.Service;

import com.example.blog.ApiException.ApiException;
import com.example.blog.Model.Blog;
import com.example.blog.Repository.BlogRepository;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class BlogService {
private final BlogRepository blogRepository;

    public List<Blog> getAllBlogs(){


        return blogRepository.findAll();
    }
    public void addBlog(Blog blog){

        blogRepository.save(blog);
    }

    public void updateBlog(Integer id,Blog blog){

        Blog oldBlog =blogRepository.findBlogById(id);
        if(oldBlog==null){

            throw new ApiException("Blog not found");
        }
        oldBlog.setBody(blog.getBody());
        oldBlog.setCategory(blog.getCategory());
        oldBlog.setTitle(blog.getTitle());
        // i prevent him to publish with the update i want the blog to be published only with ChangePublishedStatesToTrue method
        blogRepository.save(oldBlog);

    }
    public void deleteBlog(Integer id){
        Blog oldBlog=blogRepository.findBlogById(id);
        if(oldBlog==null){
            throw new ApiException("Blog not found");
        }
        blogRepository.deleteById(id);

    }


    public Blog findBlogById( Integer id){
        Blog blog=blogRepository.findBlogById(id);
        if (blog == null) {
            throw new ApiException("blog not found");

        }
        return blog;
    }

    public List<Blog> findBlogByTitle(String title){

        List<Blog> blogs=  blogRepository.findBlogByTitle(title);
        if (blogs==null){
            throw new ApiException("there is no blog with this title");
        }

        return blogs;

    }

    public List<Blog> findBlogByCategory(String category){

        List<Blog> blogs=  blogRepository.findBlogByCategory(category);
        if (blogs==null){
            throw new ApiException("there is no blog with this category");
        }

        return blogs;}

public void ChangePublishedStatesToTrue(Integer id){
Blog blog =blogRepository.findBlogById(id);
if (blog==null){

    throw new ApiException("there is no blog with this id");
}

blogRepository.publish(id);

}

}
