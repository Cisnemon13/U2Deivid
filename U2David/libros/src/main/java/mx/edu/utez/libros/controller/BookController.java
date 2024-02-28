package mx.edu.utez.libros.controller;

import mx.edu.utez.libros.model.Book;
import mx.edu.utez.libros.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/books")
@CrossOrigin(origins = "https://localhost:5173")
public class BookController {

    @Autowired
    private BookService bookService;
    @PostMapping
    public Book save(@RequestBody(required = true)Book book) {return bookService.save(book);
    }
    @GetMapping
    public List<Book> findAll() {
       return bookService.findAll();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteBook(@PathVariable Long id) {
       boolean deleted = bookService.deleteBook(id);
       if(deleted){
           return ResponseEntity.noContent().build();
       }else{
           return ResponseEntity.notFound().build();
       }
    }

    @PatchMapping("{id}")
    public ResponseEntity<Book> updateBook(@PathVariable Long id, @RequestBody Book book) {
        Book updateBook = bookService.updateBook(id, book);
        if(updateBook != null){
            return ResponseEntity.ok(updateBook);
        }else{
            return  ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/autorDesc")
    public List<Book> getLatestBooks() {
        return service.getBooksOrderedByFechaDesc();
    }

    @GetMapping("/autorAsc")
    public List<Book> getAutorAsc() {
        return service.getBooksOrderedByAutorAsc();
    }
}