package io.mitts.springdemo.recipedemo.repository;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;



//@RunWith(SpringRunner.class)
//@DataJpaTest
public class CategoryRepositoryTest {

//	@Autowired
	CategoryRepository repo;
	
	


//	@Before
	public void setUp() throws Exception {
	}

//	@Test
	public void test() {
		
		
		assertEquals(true,repo.findByDescription("Italian").isPresent());
		
		}

}
