package com.springboot.k8s.springbootk8sapp.data.repository;

import com.springboot.k8s.springbootk8sapp.data.entity.Books;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BooksRepository extends JpaRepository<Books, Long> {

  List<Books> findByPublished(boolean published);

  List<Books> findByTitleContaining(String title);
}
