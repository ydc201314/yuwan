package com.yuwan.manager.controller;

import com.yuwan.manager.pojo.Item;
import com.yuwan.manager.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("item")
public class ItemController {
    @Autowired
    private ItemService itemService;
    @RequestMapping(method = RequestMethod.POST)
    @ResponseBody
    public void saveItem(Item item, String desc){
        this.itemService.save(item,desc);
    }
}
