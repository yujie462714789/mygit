package com.service;

import java.util.Map;

import com.common.domain.User;
import com.dao.GenericDao;

public interface UserService 
{
   public User queryByMap(Map map); 
}
