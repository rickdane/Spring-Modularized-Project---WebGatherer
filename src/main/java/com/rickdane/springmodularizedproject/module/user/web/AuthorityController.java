package com.rickdane.springmodularizedproject.module.user.web;

import com.rickdane.springmodularizedproject.module.user.domain.Authority;
import org.springframework.roo.addon.web.mvc.controller.json.RooWebJson;
import org.springframework.roo.addon.web.mvc.controller.scaffold.RooWebScaffold;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/authoritys")
@Controller
@RooWebScaffold(path = "authoritys", formBackingObject = Authority.class)
@RooWebJson(jsonObject = Authority.class)
public class AuthorityController {
}
