package com.czy.controller;

import com.czy.common.constant.MessageCode;
import com.czy.common.exception.BusinessException;
import com.czy.entity.Goods;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by jacky on 2017/7/17.
 */
@RestController
public class GoodsController {

    /**
     * 通过id，获取商品信息
     *
     * @param id
     * @return
     */
    @RequestMapping(value = "/goods/{id}", method = RequestMethod.GET, produces = "application/json;charset=UTF-8")
    public Goods getGoodsById(@PathVariable("id") int id) throws BusinessException {

        Goods goods = new Goods();

        // TODO 模拟数据库操作

        if (id < 0) {
            throw new BusinessException(MessageCode.GOODS_NOT_EXISTS);
        }

        goods.setId(id);
        goods.setName("java从入门到精通");
        goods.setPrice(65.9f);
        return goods;
    }

    /**
     * 获取商品列表
     *
     * @param startId 起始商品id
     * @param limit   商品分页大小
     * @return
     * @throws BusinessException
     */
    @RequestMapping(value = "/goods", method = RequestMethod.GET, produces = "application/json;charset=UTF-8")
    public List<Goods> findGoodsList(@RequestParam("start_id") int startId, @RequestParam("limit") int limit) throws BusinessException {

        if (true) {
            int i = 1 / 0;
        }


        List<Goods> goodsList = new ArrayList<>();

        // TODO 模拟数据库操作，获取数据库数据、
        for (int i = startId; i < startId + limit; i++) {

            Goods goods = new Goods();
            goods.setId(i);
            goods.setName("java从入门到精通" + i);
            goods.setPrice(65.9f + i);

            goodsList.add(goods);
        }

        return goodsList;
    }
}
