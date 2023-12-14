package com.cha.ing.commons;

import java.sql.Date;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class CommonsVO {

	private String regId;
	private Date regDate;
	private String modId;
	private Date modDate;
}
