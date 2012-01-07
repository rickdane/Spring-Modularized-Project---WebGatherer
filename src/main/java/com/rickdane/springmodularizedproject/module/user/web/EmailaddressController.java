package com.rickdane.springmodularizedproject.module.user.web;

import com.rickdane.springmodularizedproject.module.user.domain.Emailaddress;
import org.springframework.roo.addon.web.mvc.controller.json.RooWebJson;
import org.springframework.roo.addon.web.mvc.controller.scaffold.RooWebScaffold;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/emailaddresses")
@Controller
@RooWebScaffold(path = "emailaddresses", formBackingObject = Emailaddress.class)
@RooWebJson(jsonObject = Emailaddress.class)
public class EmailaddressController {
}
