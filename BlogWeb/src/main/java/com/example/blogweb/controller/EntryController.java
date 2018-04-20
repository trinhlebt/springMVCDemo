package com.example.blogweb.controller;


import com.example.blogweb.entity.MyEntry;
import com.example.blogweb.model.MyEntryModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class EntryController {

    @Autowired
    private MyEntryModel entryModel;

    @RequestMapping(value = {"/", "entry-list"})
    public String listEntry(Model model){
//        model.addAttribute("listEntry", entryModel.findAll());
        return "entry-list";
    }

    @RequestMapping("/entry-save")
    public String insertEntry(Model model){
        model.addAttribute("entry", new MyEntry());
        return "entry-save";
    }

    @RequestMapping("/saveEntry")
    public String saveEntry(@ModelAttribute("MyEntry") MyEntry entry, Model model){
        entryModel.save(entry);
        model.addAttribute("listEntry", entryModel.findAll());
        return "redirect:entry-list";
    }

    @RequestMapping("/updateEntry")
    public String updateEntry(@ModelAttribute("MyEntry") MyEntry entry, Model model){
        entryModel.update(entry);
        model.addAttribute("listEntry", entryModel.findAll());
        return "redirect:entry-list";
    }

    @RequestMapping("/deleteEntry/{id}")
    public String deleteEntry(@PathVariable("MyEntry") int id, Model model){
        entryModel.delete(id);
        model.addAttribute("listEntry", entryModel.findAll());
        return "redirect:entry-list";
    }
}
