package com.rickdane.springmodularizedproject.module.consumabledata.web;

import com.rickdane.springmodularizedproject.module.consumabledata.domain.Datarecord;
import org.springframework.roo.addon.web.mvc.controller.json.RooWebJson;
import org.springframework.roo.addon.web.mvc.controller.scaffold.RooWebScaffold;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@RooWebJson(jsonObject = Datarecord.class)
@Controller
@RequestMapping("/datarecords")
@RooWebScaffold(path = "datarecords", formBackingObject = Datarecord.class)
public class DatarecordController {
}
