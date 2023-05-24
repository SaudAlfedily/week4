package com.example.blog.Repository;

import com.example.blog.Model.Blog;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BlogRepository extends JpaRepository<Blog,Integer> {
    Blog findBlogById(Integer id);

    List<Blog> findBlogByTitle(String title);
    List<Blog> findBlogByCategory(String category);

    @Modifying
    @Transactional
    @Query("UPDATE Blog ds SET ds.isPublished = true where ds.id=?1")
    void publish(Integer id);
}
