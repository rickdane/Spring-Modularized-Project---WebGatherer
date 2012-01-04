// WARNING: DO NOT EDIT THIS FILE. THIS FILE IS MANAGED BY SPRING ROO.
// You may push code into the target .java compilation unit if you wish to edit any member(s).

package com.rickdane.springmodularizedproject.module.user.web;

import com.rickdane.springmodularizedproject.module.user.domain.PersistentLogin;
import com.rickdane.springmodularizedproject.module.user.web.PersistentLoginController;
import java.io.UnsupportedEncodingException;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import org.joda.time.format.DateTimeFormat;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.util.UriUtils;
import org.springframework.web.util.WebUtils;

privileged aspect PersistentLoginController_Roo_Controller {
    
    @RequestMapping(method = RequestMethod.POST, produces = "text/html")
    public String PersistentLoginController.create(@Valid PersistentLogin persistentLogin, BindingResult bindingResult, Model uiModel, HttpServletRequest httpServletRequest) {
        if (bindingResult.hasErrors()) {
            populateEditForm(uiModel, persistentLogin);
            return "persistentlogins/create";
        }
        uiModel.asMap().clear();
        persistentLogin.persist();
        return "redirect:/persistentlogins/" + encodeUrlPathSegment(persistentLogin.getId().toString(), httpServletRequest);
    }
    
    @RequestMapping(params = "form", produces = "text/html")
    public String PersistentLoginController.createForm(Model uiModel) {
        populateEditForm(uiModel, new PersistentLogin());
        return "persistentlogins/create";
    }
    
    @RequestMapping(value = "/{id}", produces = "text/html")
    public String PersistentLoginController.show(@PathVariable("id") Long id, Model uiModel) {
        addDateTimeFormatPatterns(uiModel);
        uiModel.addAttribute("persistentlogin", PersistentLogin.findPersistentLogin(id));
        uiModel.addAttribute("itemId", id);
        return "persistentlogins/show";
    }
    
    @RequestMapping(produces = "text/html")
    public String PersistentLoginController.list(@RequestParam(value = "page", required = false) Integer page, @RequestParam(value = "size", required = false) Integer size, Model uiModel) {
        if (page != null || size != null) {
            int sizeNo = size == null ? 10 : size.intValue();
            final int firstResult = page == null ? 0 : (page.intValue() - 1) * sizeNo;
            uiModel.addAttribute("persistentlogins", PersistentLogin.findPersistentLoginEntries(firstResult, sizeNo));
            float nrOfPages = (float) PersistentLogin.countPersistentLogins() / sizeNo;
            uiModel.addAttribute("maxPages", (int) ((nrOfPages > (int) nrOfPages || nrOfPages == 0.0) ? nrOfPages + 1 : nrOfPages));
        } else {
            uiModel.addAttribute("persistentlogins", PersistentLogin.findAllPersistentLogins());
        }
        addDateTimeFormatPatterns(uiModel);
        return "persistentlogins/list";
    }
    
    @RequestMapping(method = RequestMethod.PUT, produces = "text/html")
    public String PersistentLoginController.update(@Valid PersistentLogin persistentLogin, BindingResult bindingResult, Model uiModel, HttpServletRequest httpServletRequest) {
        if (bindingResult.hasErrors()) {
            populateEditForm(uiModel, persistentLogin);
            return "persistentlogins/update";
        }
        uiModel.asMap().clear();
        persistentLogin.merge();
        return "redirect:/persistentlogins/" + encodeUrlPathSegment(persistentLogin.getId().toString(), httpServletRequest);
    }
    
    @RequestMapping(value = "/{id}", params = "form", produces = "text/html")
    public String PersistentLoginController.updateForm(@PathVariable("id") Long id, Model uiModel) {
        populateEditForm(uiModel, PersistentLogin.findPersistentLogin(id));
        return "persistentlogins/update";
    }
    
    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE, produces = "text/html")
    public String PersistentLoginController.delete(@PathVariable("id") Long id, @RequestParam(value = "page", required = false) Integer page, @RequestParam(value = "size", required = false) Integer size, Model uiModel) {
        PersistentLogin persistentLogin = PersistentLogin.findPersistentLogin(id);
        persistentLogin.remove();
        uiModel.asMap().clear();
        uiModel.addAttribute("page", (page == null) ? "1" : page.toString());
        uiModel.addAttribute("size", (size == null) ? "10" : size.toString());
        return "redirect:/persistentlogins";
    }
    
    void PersistentLoginController.addDateTimeFormatPatterns(Model uiModel) {
        uiModel.addAttribute("persistentLogin_last_used_date_format", DateTimeFormat.patternForStyle("M-", LocaleContextHolder.getLocale()));
    }
    
    void PersistentLoginController.populateEditForm(Model uiModel, PersistentLogin persistentLogin) {
        uiModel.addAttribute("persistentLogin", persistentLogin);
        addDateTimeFormatPatterns(uiModel);
    }
    
    String PersistentLoginController.encodeUrlPathSegment(String pathSegment, HttpServletRequest httpServletRequest) {
        String enc = httpServletRequest.getCharacterEncoding();
        if (enc == null) {
            enc = WebUtils.DEFAULT_CHARACTER_ENCODING;
        }
        try {
            pathSegment = UriUtils.encodePathSegment(pathSegment, enc);
        } catch (UnsupportedEncodingException uee) {}
        return pathSegment;
    }
    
}
