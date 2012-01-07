package com.rickdane.springmodularizedproject.module.consumabledata.web;

import com.rickdane.springmodularizedproject.module.consumabledata.domain.Campaign;
import org.springframework.roo.addon.web.mvc.controller.json.RooWebJson;
import org.springframework.roo.addon.web.mvc.controller.scaffold.RooWebScaffold;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/campaigns")
@Controller
@RooWebScaffold(path = "campaigns", formBackingObject = Campaign.class)
@RooWebJson(jsonObject = Campaign.class)
public class CampaignController {
}
