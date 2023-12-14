package com.cha.ing.image;

import com.cha.ing.commons.CommonsVO;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class ImageVO extends CommonsVO {

	private Long imageNo;
	private String id;
	private String imagePath;
	private String imageName;
	private String imageOriginalName;

}
