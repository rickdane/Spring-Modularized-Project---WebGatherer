package com.rickdane.springmodularizedproject.module.user.web;

import com.rickdane.springmodularizedproject.module.user.domain.Appuser;
import com.rickdane.springmodularizedproject.module.user.domain.Authority;
import com.rickdane.springmodularizedproject.module.user.domain.PersistentLogin;
import java.util.Calendar;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import org.springframework.roo.addon.web.mvc.controller.json.RooWebJson;
import org.springframework.roo.addon.web.mvc.controller.scaffold.RooWebScaffold;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@RequestMapping("/appusers")
@Controller
@RooWebScaffold(path = "appusers", formBackingObject = Appuser.class)
@RooWebJson(jsonObject = Appuser.class)
public class AppuserController {

    @RequestMapping(method = RequestMethod.POST, produces = "text/html")
    public String create(@Valid Appuser appuser, BindingResult bindingResult, Model uiModel, HttpServletRequest httpServletRequest) {
        if (bindingResult.hasErrors()) {
            populateEditForm(uiModel, appuser);
            return "appusers/create";
        }
        uiModel.asMap().clear();
        if (appuser.getId() == null) {
            Authority authority = new Authority();
            authority.setUsername(appuser.getUsername());
            authority.setAuthority("webgatherer");
            authority.persist();
            Calendar calendar = Calendar.getInstance();
            PersistentLogin persistentLogin = new PersistentLogin();
            persistentLogin.setSeries("1");
            persistentLogin.setUsername(appuser.getUsername());
            persistentLogin.setToken("2309fjksa");
            persistentLogin.setSeries("series2903");
            persistentLogin.setLast_used(calendar);
            persistentLogin.persist();
        }
        appuser.persist();
        return "redirect:/appusers/" + encodeUrlPathSegment(appuser.getId().toString(), httpServletRequest);
    }
}
