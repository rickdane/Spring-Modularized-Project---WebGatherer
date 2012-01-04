package com.rickdane.springmodularizedproject.module.user.web;

import com.rickdane.springmodularizedproject.module.user.domain.PersistentLogin;
import org.springframework.roo.addon.web.mvc.controller.scaffold.RooWebScaffold;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/persistentlogins")
@Controller
@RooWebScaffold(path = "persistentlogins", formBackingObject = PersistentLogin.class)
public class PersistentLoginController {
}
