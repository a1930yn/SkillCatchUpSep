package com.example.skillcatchupsep.api.controller;

import com.example.skillcatchupsep.api.PrefixEntity;
import com.example.skillcatchupsep.api.service.PrefixService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.codec.ServerSentEvent;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Controller
@RequestMapping("list")

public class ListController {
    @Autowired
    PrefixService prefixService;

    @RequestMapping(method = RequestMethod.GET)
    String listDisasters(Model model) {
        List<PrefixEntity> prefix = prefixService.findTop30();
        model.addAttribute("prefix", prefix);
        return "list";
    }
    public String GetList() {
        return "list";
    }
}

