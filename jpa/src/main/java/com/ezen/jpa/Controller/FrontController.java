package com.ezen.jpa.Controller;

import com.ezen.jpa.DTO.MyDTO;
import com.ezen.jpa.Entity.MyEntity;
import com.ezen.jpa.Repository.MyRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;

@Controller
@Slf4j //인터넷 검색해보기
public class FrontController {

    @Autowired
    MyRepository myRepository;

    @GetMapping("/main")
    public String main() {
        return "main";
    }

    @GetMapping("/input")
    public String input() {
        return "input";
    }

    @PostMapping("/inputSave")
    public String inputSave(MyDTO dto) {
        MyEntity entity = dto.toEntity();
        myRepository.save(entity);
        return "redirect:/main";
    }
    @GetMapping("/output")
    public String outPut(Model mo) {
        ArrayList<MyEntity> list = myRepository.findAll();
        mo.addAttribute("list", list);
        return "output";
    }
    @GetMapping("/delete")
    public String delete(@RequestParam("id") long id) {
        MyEntity entity = myRepository.findById(id).orElse(null);
        if(entity != null) {
            myRepository.deleteById(id);
        }
        return "redirect:/main";
    }
    @GetMapping("/update")
    public String update(@RequestParam("id") long id,Model mo){
        MyEntity entity= myRepository.findById(id).orElse(null);
        log.info(entity.toString());
        mo.addAttribute("dto", entity); //반복할때는 이걸로
        mo.addAttribute("id", entity.getId());
        mo.addAttribute("name", entity.getName());
        mo.addAttribute("mobile", entity.getMobile());
        mo.addAttribute("age", entity.getAge());
        mo.addAttribute("address", entity.getAddress());
        mo.addAttribute("sb", entity.getSb());
        return "update";
    }
    @PostMapping("/updateSave")
    public String updateSave(MyDTO dto) {
        MyEntity entity = dto.toEntity();
        myRepository.save(entity);
        return "redirect:/main";
    }
















}
