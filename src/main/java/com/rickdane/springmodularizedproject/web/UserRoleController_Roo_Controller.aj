// WARNING: DO NOT EDIT THIS FILE. THIS FILE IS MANAGED BY SPRING ROO.
// You may push code into the target .java compilation unit if you wish to edit any member(s).

package com.rickdane.springmodularizedproject.web;

import com.rickdane.springmodularizedproject.domain.Role;
import com.rickdane.springmodularizedproject.domain.User;
import com.rickdane.springmodularizedproject.domain.UserRole;
import com.rickdane.springmodularizedproject.web.UserRoleController;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.util.UriUtils;
import org.springframework.web.util.WebUtils;

privileged aspect UserRoleController_Roo_Controller {
    
    @RequestMapping(method = RequestMethod.POST, produces = "text/html")
    public String UserRoleController.create(@Valid UserRole userRole, BindingResult bindingResult, Model uiModel, HttpServletRequest httpServletRequest) {
        if (bindingResult.hasErrors()) {
            populateEditForm(uiModel, userRole);
            return "userroles/create";
        }
        uiModel.asMap().clear();
        userRole.persist();
        return "redirect:/userroles/" + encodeUrlPathSegment(userRole.getId().toString(), httpServletRequest);
    }
    
    @RequestMapping(params = "form", produces = "text/html")
    public String UserRoleController.createForm(Model uiModel) {
        populateEditForm(uiModel, new UserRole());
        List<String[]> dependencies = new ArrayList<String[]>();
        if (User.countUsers() == 0) {
            dependencies.add(new String[] { "user", "users" });
        }
        if (Role.countRoles() == 0) {
            dependencies.add(new String[] { "role", "roles" });
        }
        uiModel.addAttribute("dependencies", dependencies);
        return "userroles/create";
    }
    
    @RequestMapping(value = "/{id}", produces = "text/html")
    public String UserRoleController.show(@PathVariable("id") Long id, Model uiModel) {
        uiModel.addAttribute("userrole", UserRole.findUserRole(id));
        uiModel.addAttribute("itemId", id);
        return "userroles/show";
    }
    
    @RequestMapping(produces = "text/html")
    public String UserRoleController.list(@RequestParam(value = "page", required = false) Integer page, @RequestParam(value = "size", required = false) Integer size, Model uiModel) {
        if (page != null || size != null) {
            int sizeNo = size == null ? 10 : size.intValue();
            final int firstResult = page == null ? 0 : (page.intValue() - 1) * sizeNo;
            uiModel.addAttribute("userroles", UserRole.findUserRoleEntries(firstResult, sizeNo));
            float nrOfPages = (float) UserRole.countUserRoles() / sizeNo;
            uiModel.addAttribute("maxPages", (int) ((nrOfPages > (int) nrOfPages || nrOfPages == 0.0) ? nrOfPages + 1 : nrOfPages));
        } else {
            uiModel.addAttribute("userroles", UserRole.findAllUserRoles());
        }
        return "userroles/list";
    }
    
    @RequestMapping(method = RequestMethod.PUT, produces = "text/html")
    public String UserRoleController.update(@Valid UserRole userRole, BindingResult bindingResult, Model uiModel, HttpServletRequest httpServletRequest) {
        if (bindingResult.hasErrors()) {
            populateEditForm(uiModel, userRole);
            return "userroles/update";
        }
        uiModel.asMap().clear();
        userRole.merge();
        return "redirect:/userroles/" + encodeUrlPathSegment(userRole.getId().toString(), httpServletRequest);
    }
    
    @RequestMapping(value = "/{id}", params = "form", produces = "text/html")
    public String UserRoleController.updateForm(@PathVariable("id") Long id, Model uiModel) {
        populateEditForm(uiModel, UserRole.findUserRole(id));
        return "userroles/update";
    }
    
    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE, produces = "text/html")
    public String UserRoleController.delete(@PathVariable("id") Long id, @RequestParam(value = "page", required = false) Integer page, @RequestParam(value = "size", required = false) Integer size, Model uiModel) {
        UserRole userRole = UserRole.findUserRole(id);
        userRole.remove();
        uiModel.asMap().clear();
        uiModel.addAttribute("page", (page == null) ? "1" : page.toString());
        uiModel.addAttribute("size", (size == null) ? "10" : size.toString());
        return "redirect:/userroles";
    }
    
    void UserRoleController.populateEditForm(Model uiModel, UserRole userRole) {
        uiModel.addAttribute("userRole", userRole);
        uiModel.addAttribute("roles", Role.findAllRoles());
        uiModel.addAttribute("users", User.findAllUsers());
    }
    
    String UserRoleController.encodeUrlPathSegment(String pathSegment, HttpServletRequest httpServletRequest) {
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
