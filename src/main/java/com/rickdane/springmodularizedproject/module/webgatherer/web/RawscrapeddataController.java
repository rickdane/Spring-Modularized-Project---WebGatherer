package com.rickdane.springmodularizedproject.module.webgatherer.web;

import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;

import javax.persistence.TypedQuery;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import com.rickdane.springmodularizedproject.domain.User;
import com.rickdane.springmodularizedproject.module.consumabledata.domain.Campaign;
import com.rickdane.springmodularizedproject.module.consumabledata.domain.Emailaddress;
import com.rickdane.springmodularizedproject.module.consumabledata.domain.Website;
import com.rickdane.springmodularizedproject.module.webgatherer.domain.Rawscrapeddata;
import com.rickdane.springmodularizedproject.module.webgatherer.domain.Rawscrapeddatamigrationstatus;
import com.rickdane.springmodularizedproject.module.webgatherer.domain.Scraper;
import com.rickdane.springmodularizedproject.web.UserRegistrationForm;

import org.springframework.mail.SimpleMailMessage;
import org.springframework.roo.addon.web.mvc.controller.scaffold.RooWebScaffold;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@RequestMapping("/rawscrapeddatas")
@Controller
@RooWebScaffold(path = "rawscrapeddatas", formBackingObject = Rawscrapeddata.class)
public class RawscrapeddataController {

	@RequestMapping(params = "migrateForm", method = RequestMethod.GET)
	public String createMigrationForm(Model model) {
		RawscrapeddatamigrationForm form = new RawscrapeddatamigrationForm();
		model.addAttribute("Form", form);
		return "rawscrapeddatas/migrationForm";
	}

	@RequestMapping(method = RequestMethod.POST, produces = "text/html")
	public String create(@Valid Rawscrapeddata rawscrapeddata,
			BindingResult bindingResult, Model uiModel,
			HttpServletRequest httpServletRequest) {
		if (bindingResult.hasErrors()) {
			populateEditForm(uiModel, rawscrapeddata);
			return "rawscrapeddatas/create";
		}
		uiModel.asMap().clear();
		rawscrapeddata.persist();
		return "redirect:/rawscrapeddatas/"
				+ encodeUrlPathSegment(rawscrapeddata.getId().toString(),
						httpServletRequest);
	}

	@RequestMapping(value = "/migrateAction", method = RequestMethod.POST)
	public String create(
			@Valid RawscrapeddatamigrationForm rawscrapeddatamigrationForm,
			BindingResult result, Model uiModel, HttpServletRequest request) {
		// validator.validate(userRegistration, result);
		// if (result.hasErrors()) {
		//
		// return createForm(model);
		// } else

		TypedQuery<Campaign> q = Campaign
				.findCampaignsByNameEquals(rawscrapeddatamigrationForm
						.getCampaignName());
		Campaign campaign = q.getSingleResult();

		Set<Campaign> campaigns = new HashSet<Campaign>();
		campaigns.add(campaign);

		TypedQuery<Rawscrapeddata> queryR = Rawscrapeddata
				.findRawscrapeddatasByRawscrapeddatamigrationstatusAndCampaign(
						Rawscrapeddatamigrationstatus.NOT_MIGRATED, campaigns);

		List<Rawscrapeddata> rawscrapeddatas = queryR.getResultList();

		// TODO: this needs to be rethought as there are some complications with
		// the generated code and using it is clumsy
		for (Rawscrapeddata curRawscrapeddata : rawscrapeddatas) {

			Set<Campaign> matchingCampaigns = curRawscrapeddata.getCampaign();

			Campaign curCampaign = null;
			for (Campaign curCampaignIter : matchingCampaigns) {
				curCampaign = curCampaignIter;
				break;
			}

			migrateRawScrapedData(curRawscrapeddata);
		}

		String pausse = "";
		uiModel.addAttribute("token", "All raw scraped data has been migrated");
		return "token";
		// }
	}

	private void migrateRawScrapedData(Rawscrapeddata curRawscrapeddata) {
		String scrapedEmail = curRawscrapeddata.getEmailAddress();
		if (scrapedEmail != null) {

			String[] splitEmail = scrapedEmail.split("\\@");

			String domain = splitEmail[0].trim();

			TypedQuery<Website> queryW = Website
					.findWebsitesByDomainNameEquals(domain);

			Website website = null;
			if (queryW.getResultList().isEmpty()) {
				// no website exists yet for this domain so create it
				website = new Website();
				website.setDomainName(domain);
				website.persist();

			}
			else {
				website = queryW.getSingleResult();
			}

			// check if this email address already exists for this company
			Set<Website> matchWebsites = new HashSet<Website>();
			matchWebsites.add(website);
			TypedQuery<Emailaddress> queryEmail = Emailaddress
					.findEmailaddressesByWebsite(matchWebsites);

			List<Emailaddress> matchingEmails = queryEmail.getResultList();
			
			if (matchingEmails.isEmpty()) {
				Emailaddress newEmailAddress = new Emailaddress();
				newEmailAddress.setEmail(scrapedEmail);
				newEmailAddress.setWebsite(matchWebsites);
				newEmailAddress.persist();
			}

		}
		curRawscrapeddata.setRawscrapeddatamigrationstatus(Rawscrapeddatamigrationstatus.MIGRATED);
		curRawscrapeddata.persist();

	}
}
