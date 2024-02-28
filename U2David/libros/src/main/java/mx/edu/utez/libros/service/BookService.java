package mx.edu.utez.libros.service;

import mx.edu.utez.libros.model.Book;
import mx.edu.utez.libros.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookService {

    @Autowired
    private BookRepository bookRepository;

    public List<Book> findAll() {
        return bookRepository.findAll();
    }

    public Book save(Book book) {
        return bookRepository.save(book);
    }


    public boolean deleteBook(Long id) {
        if (bookRepository.existsById(id)) {
            bookRepository.deleteById(id);
            return true;
        } else {
            return false;
        }
    }

    public Book updateBook(Long id, Book book) {
        Optional<Book> existingMovieOptional = bookRepository.findById(id);
        if (existingMovieOptional.isPresent()) {
            Book existingMovie = existingMovieOptional.get();
            existingMovie.setName(book.getName());
            existingMovie.setAuthor(book.getAuthor());
            existingMovie.setPublicationDate(book.getPublicationDate());
            return bookRepository.save(existingMovie);
        } else {
            return null;
        }
    }
	
	public List<Book> getBooksOrderedByFechaDesc() {
        return bookRepository.findByOrderByFechaDesc();
    }

    public List<Book> getBooksOrderedByAutorAsc() {
        return bookRepository.findByOrderByAutorAsc();
    }
}