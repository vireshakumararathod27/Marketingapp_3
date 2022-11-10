package com.marketingapp_3.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.marketingapp_3.dto.LeadData;
import com.marketingapp_3.entities.Lead;
import com.marketingapp_3.services.LeadService;
import com.marketingapp_3.util.EmailService;
import com.marketingapp_3.util.EmailServiceImpl;

@Controller 
public class LeadController {
	@Autowired
	private EmailService emailService;
	
	@Autowired
	private LeadService leadService;
	
	@RequestMapping("/viewLeadPage")
	public String viewCreateLeadPage() {
		return"create_lead";
	}
	
	@RequestMapping(value="/saveLead", method = RequestMethod.POST)
	public String saveLead(@ModelAttribute("lead") Lead l, ModelMap model) {
		leadService.saveOneLead(l);
		emailService.sendSimpleMail(l.getEmail(), "Test", "Test Email");
		model.addAttribute("msg","Lead is saved;");
	return"create_lead";
		
	}
	
//	@RequestMapping(value="/saveLead", method = RequestMethod.POST)
	//public String saveLead(@RequestParam("firstName") String fname, @RequestParam("lastName") String lname,@RequestParam("email") String email, @RequestParam("mobile") String mobile ) {
		//Lead lead = new Lead();
//	lead.setFirstName(fname);
	//	lead.setLastName(lname);
	//	lead.setEmail(email);
	//	lead.setMobile(mobile);
		//leadService.saveOneLead(l);
		//return"create_lead";
	//}
	
	@RequestMapping("/listall")
	public String listAllLeads (ModelMap model) {
		List<Lead> leads = leadService.listAllLeads();
		model.addAttribute("leads", leads);
		return"list_leads";

	}
		@RequestMapping("/deleteLead")
		public String deleteLead(@RequestParam("id") long id, ModelMap model) {
			leadService.deleteOneLead(id);
			List<Lead> leads = leadService.listAllLeads();
			model.addAttribute("leads", leads);
			return"list_leads";
		}
		@RequestMapping("/updateLead")
		public String updateLead(@RequestParam("id") long id, Model model) {
			Lead lead = leadService.getById(id);
			model.addAttribute("lead", lead);
			return"update_lead";
			
		}
		
		@RequestMapping(value="/updateOneLead", method = RequestMethod.POST)
		public String updateOneLead(@ModelAttribute("lead") Lead l, ModelMap model) {
			leadService.saveOneLead(l);
			List<Lead> leads = leadService.listAllLeads();
			model.addAttribute("leads", leads);
			return"list_leads";
			
	}
}
	


