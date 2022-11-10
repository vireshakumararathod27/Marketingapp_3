package com.marketingapp_3.services;

import java.util.List;

import com.marketingapp_3.entities.Lead;

public interface LeadService {
	public void saveOneLead(Lead l);

	public List<Lead> listAllLeads();

	public void deleteOneLead(long id);

	public Lead getById(long id);


}
