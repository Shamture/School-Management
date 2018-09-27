package com.ecole.dao;

import java.util.List;

import com.ecole.beans.Contact;

public interface ContactDAO {

	public boolean ajouter(Contact contact);

	public boolean modifier(Contact contact);

	public Contact getContact(int id);

	public List<Contact> getNouveauContact();

	public List<Contact> getAllContact();

}
