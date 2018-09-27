package com.ecole.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ecole.beans.Contact;
import com.ecole.dao.ContactDAO;

@Service
public class ContactServiceImpl implements ContactService {

	@Autowired
	private ContactDAO contactDAO;

	@Transactional
	public boolean ajouter(Contact contact) {
		return contactDAO.ajouter(contact);
	}

	@Transactional
	public boolean modifier(Contact contact) {
		return contactDAO.modifier(contact);
	}

	@Transactional
	public Contact getContact(int id) {
		return contactDAO.getContact(id);
	}

	@Transactional
	public List<Contact> getNouveauContact() {
		return contactDAO.getNouveauContact();
	}

	@Transactional
	public List<Contact> getAllContact() {
		return contactDAO.getAllContact();
	}

}
