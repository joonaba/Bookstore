package hh.palvelinohjelmointi.hh.palvelinohjelmointi.bookstore;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import hh.palvelinohjelmointi.hh.palvelinohjelmointi.bookstore.domain.Category;
import  hh.palvelinohjelmointi.hh.palvelinohjelmointi.bookstore.domain.CategoryRepository;
import  hh.palvelinohjelmointi.hh.palvelinohjelmointi.bookstore.domain.Book;
import hh.palvelinohjelmointi.hh.palvelinohjelmointi.bookstore.domain.BookRepository;

@SpringBootApplication
public class Application {
	private static final Logger log = LoggerFactory.getLogger(Application.class);
	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
	
	@Bean
	public CommandLineRunner bookDemo(BookRepository brepository, CategoryRepository crepository) {
		return (args) -> {
			log.info("save a couple of books");
			crepository.save(new Category("Fantasy"));
			crepository.save(new Category("Scifi"));
			crepository.save(new Category("Nonfiction"));
			crepository.save(new Category("Comics"));
			
				
			
			log.info("fetch all books");
			for (Book book : brepository.findAll()) {
				log.info(book.toString());
			}

		};
}}
