package com.crm.service.impl;

import org.springframework.stereotype.Service;

import com.crm.core.base.BaseServiceImpl;
import com.crm.dao.GoodsDao;
import com.crm.domain.Goods;
import com.crm.service.GoodsService;
@Service
public class GoodsServiceImpl extends BaseServiceImpl<Goods, GoodsDao> implements GoodsService{

}
