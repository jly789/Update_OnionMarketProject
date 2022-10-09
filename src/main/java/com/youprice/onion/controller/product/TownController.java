package com.youprice.onion.controller.product;

import com.youprice.onion.dto.product.TownFindDTO;
import com.youprice.onion.entity.product.Category;
import com.youprice.onion.entity.product.Coordinate;
import com.youprice.onion.entity.product.Town;
import com.youprice.onion.service.member.MemberService;
import com.youprice.onion.service.member.impl.MemberServiceImpl;
import com.youprice.onion.service.product.CategoryService;
import com.youprice.onion.service.product.CoordinateService;
import com.youprice.onion.service.product.TownService;
import com.youprice.onion.service.product.impl.CategoryServiceImpl;
import com.youprice.onion.service.product.impl.CoordinateServiceImpl;
import com.youprice.onion.service.product.impl.TownServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@RequiredArgsConstructor
@Controller
@RequestMapping("town")
public class TownController {

    //!! 아이디 일시적으로 asd로설정

    private final TownService townService;
    private final MemberService memberService;
    private final CategoryService categoryService;
    private final CoordinateService coordinateService;

    @GetMapping("town")
    public String find(Model model, TownFindDTO townFinddto) {

        List<Category> finduniform = categoryService.finduniform();
        List<Category> footballboot = categoryService.footballboot();


        model.addAttribute("finduniform", finduniform);
        model.addAttribute("footballboot", footballboot);

        //model.addAttribute("town",town);


        return "product/town";
    }

    @PostMapping("townresult")
    public String find(Town town, Model model, TownFindDTO townFinddto, @RequestParam("wishtown") String wishtown) {


        List<Coordinate> Gangnam = coordinateService.FindGangnam();
        List<Coordinate> Songpa = coordinateService.FindSongpa();
        List<Coordinate> Gangdong = coordinateService.FindGangdong();


        model.addAttribute("Gangnam", Gangnam);
        model.addAttribute("Songpa", Songpa);
        model.addAttribute("Gangdong", Gangdong);

        model.addAttribute("wishtown", wishtown);


        return "product/townresult";
    }

    @PostMapping("town")
    public String towncreate(TownFindDTO townFinddto, @RequestParam("userId") String userId) {

        townService.townCreate(townFinddto, userId);
        return "redirect:/town/town";


    }
}
