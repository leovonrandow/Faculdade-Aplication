package com.example.alunosSpringBoot.controller;

import com.example.alunosSpringBoot.model.Aluno;
import com.example.alunosSpringBoot.service.AlunoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class AlunoController {

    @Autowired
    private AlunoService alunoService;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ModelAndView index() {
        ModelAndView mav = new ModelAndView("index");
        mav.addObject("alunos", alunoService.getAllAlunos());
        return mav;
    }

    @RequestMapping(value = "/insert", method = RequestMethod.GET)
    public ModelAndView insert() {
        return new ModelAndView("insert", "aluno", new Aluno());
    }

    @RequestMapping(value = "/insert", method = RequestMethod.POST)
    public String submitInsert(@ModelAttribute("aluno")Aluno aluno, BindingResult result, ModelMap model) {
        if (result.hasErrors()) {
            return "error";
        }
        alunoService.insertAluno(aluno);
        return "redirect:";
    }

    @RequestMapping(value = "/delete", method = RequestMethod.GET)
    public ModelAndView delete(Integer id) {
        return new ModelAndView("delete", "aluno", alunoService.getAlunoById(id).get());
    }

    @RequestMapping(value = "/delete", method = RequestMethod.POST)
    public String submitDelete(@ModelAttribute("aluno")Aluno aluno, BindingResult result, ModelMap model) {
        if (result.hasErrors()) {
            return "error";
        }
        alunoService.deleteAlunoById(aluno.getId());
        return "redirect:";
    }
    @RequestMapping(value = "/update", method = RequestMethod.GET)
    public ModelAndView update(Integer id) {
        return new ModelAndView("update", "aluno", alunoService.getAlunoById(id).get());
    }
    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public String submitUpdate(@ModelAttribute("aluno")Aluno aluno, BindingResult result, ModelMap model) {
        if (result.hasErrors()) {
            return "error";
        }
        alunoService.updateAluno(aluno);
        return "redirect:";
    }

    @RequestMapping(value = "/read", method = RequestMethod.GET)
    public ModelAndView read() {
        ModelAndView mav = new ModelAndView("read");
        mav.addObject("alunos", alunoService.getAllAlunos());
        return mav;
    }

}
