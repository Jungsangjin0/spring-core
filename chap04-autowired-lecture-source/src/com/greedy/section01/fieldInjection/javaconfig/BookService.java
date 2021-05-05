package com.greedy.section01.fieldInjection.javaconfig;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookService {

//	private BookDAO bookDAO = new BookDAOImpl();
	@Autowired
	private BookDAO bookDAO;
	
	public List<BookDTO> selectAllBooks() {
		
		return bookDAO.selectBookList();
	}
	
	public BookDTO searchBookBySequence(int sequence) {
		return bookDAO.selectOneBook(sequence);
	}
}
