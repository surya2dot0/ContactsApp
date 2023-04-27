package in.learning.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import in.learning.binding.Contact;

public interface ContactRepository extends JpaRepository<Contact, Integer> {
	
	public List<Contact> findByActiveSw(String status);
	
	

}
