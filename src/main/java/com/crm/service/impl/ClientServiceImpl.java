package com.crm.service.impl;

import org.springframework.stereotype.Service;

import com.crm.core.base.BaseServiceImpl;
import com.crm.dao.ClientDao;
import com.crm.domain.Client;
import com.crm.service.ClientService;
@Service
public class ClientServiceImpl extends BaseServiceImpl<Client, ClientDao> implements ClientService{

}
