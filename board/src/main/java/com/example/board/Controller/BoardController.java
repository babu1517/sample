package com.example.board.Controller;

import com.example.board.DTO.BoardDTO;
import com.example.board.Entity.BoardEntity;
import com.example.board.Service.BoardService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.time.LocalDate;
import java.util.ArrayList;

@Controller
@RequestMapping(value = "/board/*")
@Slf4j
public class BoardController {
    @Autowired
    BoardService boardService;
    @GetMapping("main")
    public String main(){
        return "main";
    }
    @GetMapping("input")
    public String input(BoardDTO boardDTO,Model model){
        model.addAttribute("boardDTO",new BoardDTO());
        return "board/input";
    }
    @PostMapping("inputsave")
    public String inputsave(@ModelAttribute("boardDTO") @Valid BoardDTO boardDTO, BindingResult rs)
    {
        if(rs.hasErrors())
        {
            return "board/input";
        }
        else {
            boardDTO.setWriteday(LocalDate.now());
            BoardEntity boardEntity= boardDTO.toEntity();
            boardService.inputsave(boardEntity);
            return "redirect:/board/main";
        }
    }
    @GetMapping("out")
    public String out(Model model, @RequestParam(required = false,defaultValue ="0", value = "page") int page){
        log.info(page+"페이지");
        Page<BoardEntity> listPage = boardService.list(page);
        int totalPage = listPage.getTotalPages();
        int nowpage = listPage.getPageable().getPageNumber()+1;//현재페이지
        model.addAttribute("nowpage",nowpage);
        model.addAttribute("list",listPage.getContent());
        model.addAttribute("totalPage",totalPage);
        ArrayList<BoardEntity> list = boardService.out();
        return "board/out";
    }
    @GetMapping("detail")
    public String detail(@RequestParam("id") long id,Model model){
        boardService.updateReadcnt(id);
        BoardEntity boardEntity = boardService.detail(id);
        model.addAttribute("boardEntity",boardEntity);
        return "board/detail";
    }
    @PostMapping("updatesave")
    public String updatesave(BoardDTO boardDTO){
        boardDTO.setWriteday(LocalDate.now());
        BoardEntity boardEntity = boardDTO.toEntity();
        boardService.updatesave(boardEntity);
        return "main";
    }
}
