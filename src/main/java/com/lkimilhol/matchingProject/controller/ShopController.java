package com.lkimilhol.matchingProject.controller;

import com.lkimilhol.matchingProject.domain.Shop;
import com.lkimilhol.matchingProject.request.CreateShop;
import com.lkimilhol.matchingProject.response.ResultBody;
import com.lkimilhol.matchingProject.service.ShopService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import javax.validation.Valid;

@Controller
@RequiredArgsConstructor
public class ShopController {

    private final ShopService shopService;

    @ResponseStatus(HttpStatus.OK)
    @RequestMapping(value = "/shop/new", method = RequestMethod.POST)
    @ResponseBody
    public ResponseEntity<ResultBody> addMember(
            @Valid CreateShop createShop
            ) {
        Shop shop = shopService.addShop(createShop);
        return ResponseEntity.ok(new ResultBody(shop));
    }
}
