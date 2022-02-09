package com.springboot.k8s.springbootk8sapp.controllers;

import com.springboot.k8s.springbootk8sapp.data.entity.Books;
import com.springboot.k8s.springbootk8sapp.data.repository.BooksRepository;
import lombok.val;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class BooksController {

  // we can create service layer instead directly calling repositories inside controllers
  @Autowired BooksRepository booksRepository;

  @GetMapping("/books")
  public ResponseEntity<List<Books>> getAllBooks(@RequestParam(required = false) String title) {
    try {
      List<Books> tutorials = new ArrayList<>();
      if (title == null) booksRepository.findAll().forEach(tutorials::add);
      else booksRepository.findByTitleContaining(title).forEach(tutorials::add);
      if (tutorials.isEmpty()) {
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
      }
      return new ResponseEntity<>(tutorials, HttpStatus.OK);
    } catch (Exception e) {
      return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
    }
  }

  @GetMapping("/books/{id}")
  public ResponseEntity<Books> getBookById(@PathVariable("id") long id) {
    Optional<Books> tutorialData = booksRepository.findById(id);
    // We can throw more readable exception
    return tutorialData
        .map(books -> new ResponseEntity<>(books, HttpStatus.OK))
        .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
  }

  @PostMapping("/books")
  public ResponseEntity<Books> createBook(@RequestBody Books book) {
    try {
      // save is by default transactional
          booksRepository.save(book);
      return new ResponseEntity<>(HttpStatus.CREATED);
    } catch (Exception e) {
      return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
    }
  }

  @PutMapping("/books/{id}")
  public ResponseEntity<Books> updateBook(
      @PathVariable("id") long id, @RequestBody Books book) {
    Optional<Books> bookDate = booksRepository.findById(id);
    if (bookDate.isPresent()) {
      val bookToUpdate = bookDate.get();
      book.setTitle(book.getTitle());
      book.setDescription(book.getDescription());
      book.setPublished(book.isPublished());
      return new ResponseEntity<>(booksRepository.save(bookToUpdate), HttpStatus.OK);
    } else {
      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
  }

  @DeleteMapping("/books/{id}")
  public ResponseEntity<HttpStatus> deleteTutorial(@PathVariable("id") long id) {
    try {
      booksRepository.deleteById(id);
      return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    } catch (Exception e) {
      return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
    }
  }

  @DeleteMapping("/books")
  public ResponseEntity<HttpStatus> deleteAllTutorials() {
    try {
      booksRepository.deleteAll();
      return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    } catch (Exception e) {
      return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
    }
  }

  @GetMapping("/books/published")
  public ResponseEntity<List<Books>> findByPublished() {
    try {
      List<Books> tutorials = booksRepository.findByPublished(true);
      if (tutorials.isEmpty()) {
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
      }
      return new ResponseEntity<>(tutorials, HttpStatus.OK);
    } catch (Exception e) {
      return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
    }
  }
}
