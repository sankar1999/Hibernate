package com.database;

import com.database.jpa.PersonJpaRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;

//@SpringBootApplication
public class SpringBootDatabaseApplication implements CommandLineRunner {

	private Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	private PersonJpaRepository repository;

	public static void main(String[] args) {
		SpringApplication.run(SpringBootDatabaseApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		logger.info("Find By Id 1002 -> {}", repository.findById(1003));
	}


//	@Override
//	public void run(String... args) throws Exception {
//		logger.info("All Users -> {}", dao.findAll());
//	}

//	@Override
//	public void run(String... args) throws Exception {
//		logger.info("Find By Id 1002 -> {}", dao.findById(1003));
//	}

//	@Override
//	public void run(String... args) throws Exception {
//		logger.info("Find By Name Justin -> {}", dao.findByName("Justin"));
//	}

//	@Override
//	public void run(String... args) throws Exception {
//		logger.info("Deleting Id 1004 -> No of Rows Deleted - {}", dao.deleteById(1004));
//		logger.info("Deleting Id 1002 -> No of Rows Deleted - {}", dao.deleteById(1002));
//	}


//	@Override
//	public void run(String... args) throws Exception {
//		logger.info("Inserting 1005 -> {}", dao.insert(new Person(
//				1005, "Willow", "Dubai", new Date()
//		)));
//		logger.info("Updating 1005 -> {}", dao.update(new Person(
//				1001, "Updated", "Update Location", new Date()
//		)));
//		logger.info("All Users -> {}", dao.findAll());
//
//	}
}
