package in.learning.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import in.learning.binding.Contact;
import in.learning.service.ContactService;
import org.slf4j.*;
@RestController
public class ContactRestController {
	
	@Autowired
	ContactService service;
	
	private static final Logger logger = LoggerFactory.getLogger(ContactRestController.class);
	
	@PostMapping("/contact")
	public String createContact(@RequestBody Contact contact) {
		logger.debug("Post started...");
		String status = service.saveContact(contact);
		logger.debug("Post completed....");
		return status;
	}
	
	@GetMapping("/contacts")
	public List<Contact> getContacts() {
		return service.getContacts();
	}
	@GetMapping("/contact/{contactId}")
	public Contact getContactById(@PathVariable Integer contactId) {
		return service.getContactById(contactId);
	}
	@PutMapping("/contact")
	public String updateContact(@RequestBody Contact contact) {
		return service.updateContact(contact);
	}
	@DeleteMapping("/contact/{contactId}")
	public String deleteContact(@PathVariable Integer contactId) {
		return service.deleteContactById(contactId);
	}

}
