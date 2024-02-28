package mx.edu.utez.libros.repository;

import mx.edu.utez.libros.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book, Long> {
  List<Book> findByOrderByAutorAsc();
    List<Book> findByOrderByFechaDesc();
}