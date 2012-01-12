package com.rickdane.springmodularizedproject.module.consumabledata.web;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import com.rickdane.springmodularizedproject.module.consumabledata.domain.Website;
import org.springframework.roo.addon.web.mvc.controller.scaffold.RooWebScaffold;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@RequestMapping("/websites")
@Controller
@RooWebScaffold(path = "websites", formBackingObject = Website.class)
public class WebsiteController {
	
	
    @RequestMapping(method = RequestMethod.POST, produces = "text/html")
    public String create(@Valid Website website, BindingResult bindingResult, Model uiModel, HttpServletRequest httpServletRequest) {
        if (bindingResult.hasErrors()) {
            populateEditForm(uiModel, website);
            return "websites/create";
        }
        uiModel.asMap().clear();
        website.persist();
        return "redirect:/websites/" + encodeUrlPathSegment(website.getId().toString(), httpServletRequest);
    }
	
}
