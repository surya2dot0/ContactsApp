package in.learning.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import in.learning.binding.Contact;

public interface ContactRepository extends JpaRepository<Contact, Integer> {
	
	

}
