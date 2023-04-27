package in.learning.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import in.learning.binding.Contact;
import in.learning.repository.ContactRepository;

@Service
public class ContactServiceImpl implements ContactService {
	@Autowired
	ContactRepository repo;

	@Override
	public String saveContact(Contact contact) {
		contact = repo.save(contact);
		if( contact.getContactId() != null) {
			return "Contact creation successful : "+contact.getContactId();
		} else {
			return "Contact creation failed";
		}
	}

	@Override
	public List<Contact> getContacts() {

		
		return repo.findAll();
	}

	@Override
	public Contact getContactById(Integer contactId) {
		 Optional<Contact> findById = repo.findById(contactId);
		 
		 if( findById.isPresent()) {
			 return findById.get();
		 } else {
			 return null;
		 }
		
	}

	@Override
	public String updateContact(Contact contact) {
		
		if(repo.existsById(contact.getContactId())) {
			contact = repo.save(contact);
			return "Update Success";
		} else {
			return "Update Failure";
		}
	}

	@Override
	public String deleteContactById(Contact contact) {
		if(repo.existsById(contact.getContactId())) {
			repo.deleteById(contact.getContactId());
			return "Delete Success";
		} else {
			return "Delete Failure";
		}
	}
	

}
