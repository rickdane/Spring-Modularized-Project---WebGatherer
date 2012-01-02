package com.rickdane.springmodularizedproject.module.consumabledata.web;

import com.rickdane.springmodularizedproject.module.consumabledata.domain.Datarecord;
import org.springframework.roo.addon.web.mvc.controller.scaffold.RooWebScaffold;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/datarecords")
@Controller
@RooWebScaffold(path = "datarecords", formBackingObject = Datarecord.class)
public class DatarecordController {
}
