package com.yuwan.manager.service.impl;

import com.yuwan.manager.pojo.Item;
import com.yuwan.manager.pojo.ItemDesc;
import com.yuwan.manager.service.ItemDescService;
import com.yuwan.manager.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ItemServiceImpl extends BaseServiceImpl<Item> implements ItemService {
    @Autowired
    private ItemDescService itemDescService;
    @Override
    public void save(Item item, String desc) {
        item.setStatus(1);
        super.save(item);
        ItemDesc itemDesc = new ItemDesc();
        itemDesc.setItemDesc(desc);
        itemDesc.setItemId(item.getId());
        this.itemDescService.save(itemDesc);
    }
}
