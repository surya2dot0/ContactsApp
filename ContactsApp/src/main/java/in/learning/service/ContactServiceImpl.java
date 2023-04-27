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
		contact.setActiveSw("Y");
		contact = repo.save(contact);
		if( contact.getContactId() != null) {
			return "Contact creation successful : "+contact.getContactId();
		} else {
			return "Contact creation failed";
		}
	}

	@Override
	public List<Contact> getContacts() {

		
		return repo.findByActiveSw("Y");
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
	public String deleteContactById(Integer contactId) {
		/*
		 if(repo.existsById(contactId)) { repo.deleteById(contactId); return
		 "Delete Success"; } else { return "Delete Failure"; }
		 */
		
	 Optional<Contact> findById = repo.findById(contactId);
		 
		 if( findById.isPresent()) {
			 Contact c = findById.get();
			 c.setActiveSw("N");
			 repo.save(c);
			 return "Successful Deletion";
		 } else {
			 return "Record doesn't exist";
		 }
		
	}
	

}
