package com.example.OnlineBookStore.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

import com.example.OnlineBookStore.entity.Book;

@CrossOrigin("http://localhost:4200")
public interface BookRepository extends JpaRepository<Book,Long> {

	//It changes the rest end point http://localhost:8080/api/v1/books/search/findByCategoryId?id=4
	// By adding this @RestResource the restend point becomes http://localhost:8080/api/v1/books/search/categoryid?id=2
	@RestResource(path="categoryid")
	Page<Book> findByCategoryId(@Param("id")Long id,Pageable pageable);
}
