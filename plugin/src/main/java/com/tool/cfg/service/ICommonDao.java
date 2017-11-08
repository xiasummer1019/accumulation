package com.tool.cfg.service;

import java.util.List;

/**
 * 通用的dao方法
 */
public interface ICommonDao<T> {
      <K> T findOne(K k);
      <K> List<T> findAll(K k);
      <K> void deleteOne(K k);
      <K> void insert(K k);
      <K> void update(K k);
}
