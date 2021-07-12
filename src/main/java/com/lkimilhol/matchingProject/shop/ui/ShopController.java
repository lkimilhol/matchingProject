package com.lkimilhol.matchingProject.shop.ui;

import com.lkimilhol.matchingProject.shop.domain.Shop;
import com.lkimilhol.matchingProject.shop.dto.ShopDto;
import com.lkimilhol.matchingProject.request.CreateShop;
import com.lkimilhol.matchingProject.response.ResultBody;
import com.lkimilhol.matchingProject.shop.application.ShopService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
@RequiredArgsConstructor
public class ShopController {

    private final ShopService shopService;

    @ResponseStatus(HttpStatus.OK)
    @RequestMapping(value = "/shop/new", method = RequestMethod.POST)
    @ResponseBody
    public ResponseEntity<ResultBody> addShop(
            @Valid CreateShop createShop
            ) {
        Shop shop = shopService.addShop(createShop);
        return ResponseEntity.ok(new ResultBody(getShopDto(shop)));
    }

    @ResponseStatus(HttpStatus.OK)
    @RequestMapping(value = "/shop/{shopName}", method = RequestMethod.GET)
    @ResponseBody
    public ResponseEntity<ResultBody> getShop(
            @PathVariable String shopName
    ) {
        Shop shop = shopService.getShop(shopName);
        return ResponseEntity.ok(new ResultBody(getShopDto(shop)));
    }

    private ShopDto getShopDto(Shop shop) {
        return ShopDto.builder().shop(shop).build();
    }
}
