package com.zsc.ims.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.zsc.ims.domain.entity.Menu;

import java.util.List;

public interface MenuMapper extends BaseMapper<Menu> {
    List<String> selectPermsByUserId(Integer id);
}
