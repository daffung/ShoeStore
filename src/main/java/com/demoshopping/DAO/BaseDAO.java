package com.demoshopping.DAO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class BaseDAO {
  @Autowired
  JdbcTemplate _jdbcTemplate;
}
