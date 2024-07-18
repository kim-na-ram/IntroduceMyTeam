package com.bootcamp.introductmyteam.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashMap;
import java.util.Map;

@Slf4j
@Controller
@RequestMapping("/member")
public class MemberController {
    private static Map<String, Long> page = new HashMap<String, Long>() {{
        put("naram", 1l);
        put("bang", 2l);
        put("adh", 3l);
        put("isack", 4l);
        put("jitaek", 5l);
    }};

    // pageName 대로 articleId를 전달
    @GetMapping("/{pageName}")
    public ModelAndView pageNumbering(@PathVariable("pageName") String pageName) {
        ModelAndView mav = new ModelAndView("member/"+pageName);
        mav.addObject("articleId", page.get(pageName));
        return mav;
    }
}
