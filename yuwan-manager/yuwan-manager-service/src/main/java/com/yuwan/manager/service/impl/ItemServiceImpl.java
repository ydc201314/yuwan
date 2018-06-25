package com.yuwan.manager.service.impl;

import com.github.abel533.mapper.Mapper;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.yuwan.common.pojo.EasyUIResult;
import com.yuwan.manager.pojo.Item;
import com.yuwan.manager.pojo.ItemDesc;
import com.yuwan.manager.service.ItemDescService;
import com.yuwan.manager.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ItemServiceImpl extends BaseServiceImpl<Item> implements ItemService {

    @Autowired
    @Qualifier("itemMapper")
    private Mapper<Item> mapper;

    public Mapper<Item> getMapper() {
        return mapper;
    }

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

    @Override
    public EasyUIResult<Item> queryItemList(Integer page, Integer rows) {
        // 设置分页数据
        PageHelper.startPage(page, rows);
        List<Item> list = super.queryListByWhere(null);
        // 获取分页的详细数据
        PageInfo<Item> pageInfo = new PageInfo<Item>(list);

        // 封装返回对象
        EasyUIResult<Item> easyUIResult = new EasyUIResult<>();
        easyUIResult.setRows(list);
        easyUIResult.setTotal(pageInfo.getTotal());
        return easyUIResult;
    }

}
