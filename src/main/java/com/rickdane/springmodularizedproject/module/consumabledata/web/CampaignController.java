package com.rickdane.springmodularizedproject.module.consumabledata.web;

import com.rickdane.springmodularizedproject.module.consumabledata.domain.Campaign;
import com.rickdane.springmodularizedproject.module.consumabledata.domain.CampaignEmailScrapeOptions;
import com.rickdane.springmodularizedproject.module.consumabledata.domain.Datarecord;
import com.rickdane.springmodularizedproject.module.consumabledata.domain.Website;
import com.rickdane.springmodularizedproject.module.userdata.domain.EmailTemplateCategory;

import java.util.Arrays;

import org.springframework.roo.addon.web.mvc.controller.json.RooWebJson;
import org.springframework.roo.addon.web.mvc.controller.scaffold.RooWebScaffold;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;

@RequestMapping("/campaigns")
@Controller
@RooWebScaffold(path = "campaigns", formBackingObject = Campaign.class)
@RooWebJson(jsonObject = Campaign.class)
public class CampaignController {


    @RequestMapping(value = "/selectForSession", produces = "text/html")
    public String selectList(Campaign campaign, Model uiModel) {
        uiModel.addAttribute("campaign", campaign);
        uiModel.addAttribute("campaigns", Campaign.findAllCampaigns());

        return "campaigns/selectForSession";
    }

    void populateEditForm(Model uiModel, Campaign campaign) {
        uiModel.addAttribute("campaign", campaign);
        uiModel.addAttribute("campaignemailscrapeoptionses", Arrays.asList(CampaignEmailScrapeOptions.values()));
        uiModel.addAttribute("datarecords", Datarecord.findAllDatarecords());
        uiModel.addAttribute("emailTemplateCategories", EmailTemplateCategory.findAllEmailTemplateCategorys());
    }
}
