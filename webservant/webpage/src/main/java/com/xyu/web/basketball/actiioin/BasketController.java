package com.xyu.web.basketball.actiioin;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by yuxia on 2016-01-17.
 */
@Controller
@RequestMapping("basket")
public class BasketController {
	@RequestMapping({"index",""})
	public String index() {
		return "basket/basket-index";
	}
}
