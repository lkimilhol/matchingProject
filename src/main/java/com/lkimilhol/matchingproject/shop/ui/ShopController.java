package com.lkimilhol.matchingproject.shop.ui;

import com.lkimilhol.matchingproject.shop.domain.Shop;
import com.lkimilhol.matchingproject.shop.dto.ShopDto;
import com.lkimilhol.matchingproject.request.CreateShop;
import com.lkimilhol.matchingproject.response.ResultBody;
import com.lkimilhol.matchingproject.shop.application.ShopService;
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
    @PostMapping(value = "/shops")
    @ResponseBody
    public ResponseEntity<ResultBody> addShop(
            @Valid CreateShop createShop
            ) {
        Shop shop = shopService.addShop(createShop);
        return ResponseEntity.ok(new ResultBody(getShopDto(shop)));
    }

    //TODO 리퀘스트 바디로 수정 할 것
    @ResponseStatus(HttpStatus.OK)
    @GetMapping(value = "/shops/{shopName}")
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
