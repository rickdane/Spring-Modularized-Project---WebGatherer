package com.rickdane.springmodularizedproject.module.consumabledata.web;

import com.rickdane.springmodularizedproject.module.consumabledata.domain.Emailaddress;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import org.springframework.roo.addon.web.mvc.controller.scaffold.RooWebScaffold;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@RequestMapping("/emailaddresses")
@Controller
@RooWebScaffold(path = "emailaddresses", formBackingObject = Emailaddress.class)
public class EmailaddressController {
	
    @RequestMapping(params = "findEmailaddressesByWebsite", produces = "text/html")
    public String findByWebsite(Model uiModel) {
        populateEditForm(uiModel, new Emailaddress());
        return "emailaddresses/findEmailaddressesByWebsite";
    }
	
}
