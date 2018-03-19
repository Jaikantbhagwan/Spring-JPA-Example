package guru.springframework.spring5webapp.DevBootstrap;

import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import guru.springframework.spring5webapp.model.Author;
import guru.springframework.spring5webapp.model.Book;
import guru.springframework.spring5webapp.repositories.AuthorRepository;
import guru.springframework.spring5webapp.repositories.BookRepository;

@Component
public class DevBootstrap  implements ApplicationListener<ContextRefreshedEvent>{

	private AuthorRepository authorRepository;
	private BookRepository bookRepository;	
	
	
	public DevBootstrap(AuthorRepository authorRepository, BookRepository bookRepository) {		
		this.authorRepository = authorRepository;
		this.bookRepository = bookRepository;
	}

	@Override
	public void onApplicationEvent(ContextRefreshedEvent arg0) {
	initData();		
	}
	
	private void initData() {
		Author aut = new Author("Jaikant", "Singh");
		Book book = new Book("Domain Driven Design", "1234", "Sristi");
		
		aut.getBooks().add(book);
		book.getAuthors().add(aut);
		
		authorRepository.save(aut);
		bookRepository.save(book);
		
		Author aut1 = new Author("Srikant", "Singh");
		Book book1 = new Book("J2EE Development without EJB", "1231", "Wrox");
		
		aut.getBooks().add(book1);
		book.getAuthors().add(aut1);
		
		authorRepository.save(aut1);
		bookRepository.save(book1);
		
		
	
	}

}
