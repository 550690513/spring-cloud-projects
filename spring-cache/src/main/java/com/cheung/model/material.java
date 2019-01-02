package com.cheung.model;

import lombok.Data;

import java.math.BigDecimal;

/**
 * @author Cheung
 * @date 2019/01/02
 */
@Data
public class material {

	private Integer id;

	private String name;

	private BigDecimal quality;

	private String desc;

}
