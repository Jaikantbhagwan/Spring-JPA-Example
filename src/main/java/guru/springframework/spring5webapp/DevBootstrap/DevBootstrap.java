package guru.springframework.spring5webapp.DevBootstrap;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.redirectedUrl;

import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import guru.springframework.spring5webapp.model.Author;
import guru.springframework.spring5webapp.model.Book;
import guru.springframework.spring5webapp.model.Publisher;
import guru.springframework.spring5webapp.repositories.AuthorRepository;
import guru.springframework.spring5webapp.repositories.BookRepository;
import guru.springframework.spring5webapp.repositories.PublisherRepository;

@Component
public class DevBootstrap  implements ApplicationListener<ContextRefreshedEvent>{

	private AuthorRepository authorRepository;
	private BookRepository bookRepository;	
	private PublisherRepository publisherRepository;
	
	
	public DevBootstrap(AuthorRepository authorRepository, BookRepository bookRepository, PublisherRepository publisherRepository) {		
		this.authorRepository = authorRepository;
		this.bookRepository = bookRepository;
		this.publisherRepository = publisherRepository;
	}

	@Override
	public void onApplicationEvent(ContextRefreshedEvent arg0) {
	initData();		
	}
	
	private void initData() {
		Publisher publisher = new Publisher();
		publisher.setName("Jack Pub");
		publisher.setAddress("XYZ");
		
		publisherRepository.save(publisher);
		
		Publisher publisher1 = new Publisher();
		publisher1.setName("WROX");
		publisher1.setAddress("ABC");
		
		publisherRepository.save(publisher1);
		
		Author aut = new Author("Jaikant", "Singh");
		Book book = new Book("Domain Driven Design", "1234", publisher);
		
		aut.getBooks().add(book);
		book.getAuthors().add(aut);
		
		authorRepository.save(aut);
		bookRepository.save(book);
		
		Author aut1 = new Author("Srikant", "Singh");
		Book book1 = new Book("J2EE Development without EJB", "1231", publisher1);
		
		aut.getBooks().add(book1);
		book.getAuthors().add(aut1);
		
		authorRepository.save(aut1);
		bookRepository.save(book1);
		
		
	
	}

}
