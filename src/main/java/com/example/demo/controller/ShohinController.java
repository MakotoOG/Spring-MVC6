package com.example.demo.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.dao.ShohinDAO;
import com.example.demo.model.Shohin;

@Controller
public class ShohinController 
{
	@GetMapping("/shohin_select_form")
    private String readForm(Model model)
	{
		ShohinDAO sdao = new ShohinDAO();
    	List<Shohin> shohin = sdao.selectShohin();
    	model.addAttribute("shohin_list", shohin);
        return "shohin_select_form";
    }
    
    @PostMapping("/shohin_select_form")
    private String selectForm(@RequestParam String keyword, Model model)
    {
    	ShohinDAO sdao = new ShohinDAO();
    	List<Shohin> shohin = sdao.selectShohin(keyword);
    	model.addAttribute("shohin_list", shohin);
        return "shohin_select_form";
    }
}
