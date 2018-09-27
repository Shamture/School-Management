package com.ecole.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ecole.beans.Groupe;
import com.ecole.dao.GroupeDAO;

@Service
public class GroupeServiceImpl implements GroupeService {

	@Autowired
	private GroupeDAO groupeDAO;

	public boolean ajouter(Groupe g) {
		// TODO Auto-generated method stub
		return false;
	}

	@Transactional
	public Map<Integer, String> getGroupsListNames() {
		Map<Integer, String> map = new HashMap<Integer, String>();
		List<Groupe> list = groupeDAO.getGroupList();
		for (Groupe gr : list) {
			map.put(gr.getId(), gr.toString());
		}

		return map;

	}

	@Transactional
	public List<Groupe> getListeGroupe() {
		return groupeDAO.getGroupList();
	}

}
