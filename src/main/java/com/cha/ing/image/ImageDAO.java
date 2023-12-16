package com.cha.ing.image;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface ImageDAO {

	public int insertImage(ImageVO imageVO)throws Exception;
}
