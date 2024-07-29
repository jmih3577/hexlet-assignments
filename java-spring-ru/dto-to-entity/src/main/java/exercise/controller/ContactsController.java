package exercise.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import exercise.model.Contact;
import exercise.repository.ContactRepository;
import exercise.dto.ContactDTO;
import exercise.dto.ContactCreateDTO;

@RestController
@RequestMapping("/contacts")
public class ContactsController {

    @Autowired
    private ContactRepository contactRepository;

    // BEGIN
    @PostMapping(path = "")
    @ResponseStatus(HttpStatus.CREATED)
    public ContactDTO create(@RequestBody ContactCreateDTO cc){
        var con = convertToEntity(cc);
        contactRepository.save(con);
        return convertToDTO(con);
    }
    public Contact convertToEntity(ContactCreateDTO cc) {
        var contact = new Contact();
        contact.setPhone(cc.getPhone());
        contact.setFirstName(cc.getFirstName());
        contact.setLastName(cc.getLastName());
        return contact;
    }
    public ContactDTO convertToDTO(Contact cc) {
        var contactDTO = new ContactDTO();
        contactDTO.setId(cc.getId());
        contactDTO.setCreatedAt(cc.getCreatedAt());
        contactDTO.setUpdatedAt(cc.getUpdatedAt());
        contactDTO.setPhone(cc.getPhone());
        contactDTO.setFirstName(cc.getFirstName());
        contactDTO.setLastName(cc.getLastName());
        return contactDTO;
    }
    // END
}
