package in.learning.service;

import java.util.List;

import in.learning.binding.Contact;

public interface ContactService {
	
	public String saveContact(Contact contact);
	public List<Contact> getContacts();
	public Contact getContactById(Integer contactId);
	public String updateContact(Contact contact);
	public String deleteContactById(Integer contactId);

}
