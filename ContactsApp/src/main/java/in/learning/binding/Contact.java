package in.learning.binding;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "CONTACT_DTLS")
public class Contact {
	
	@Id
	@GeneratedValue
	private Integer contactId;
	private String contactName;
    private String contactEmail;
    private Long contactNum;
	public Integer getContactId() {
		return contactId;
	}
	public void setContactId(Integer contactId) {
		this.contactId = contactId;
	}
	public String getContactName() {
		return contactName;
	}
	public void setContactName(String contactName) {
		this.contactName = contactName;
	}
	public String getContactEmail() {
		return contactEmail;
	}
	public void setContactEmail(String contactEmail) {
		this.contactEmail = contactEmail;
	}
	public Long getContactNum() {
		return contactNum;
	}
	public void setContactNum(Long contactNum) {
		this.contactNum = contactNum;
	}
    
}
