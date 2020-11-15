package com.sybinal.shop.controller.api;

import java.lang.reflect.InvocationTargetException;
import java.util.Date;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.sybinal.shop.common.ApiResponseEnum;
import com.sybinal.shop.common.ApiResponseObject;
import com.sybinal.shop.model.Cart;
import com.sybinal.shop.model.Product;
import com.sybinal.shop.model.Sku;
import com.sybinal.shop.service.api.cart.CartService;
import com.sybinal.shop.service.catalog.ProductService;
import com.sybinal.shop.service.catalog.SkuService;
import com.sybinal.shop.service.order.OrderService;
import com.sybinal.shop.service.sequence.SequenceService;
import com.sybinal.shop.utils.Constants;
import com.sybinal.shop.utils.DateUtils;

@RestController
@RequestMapping("api/v1")
public class CartApiController extends AbstractApiController {

	@Autowired
	OrderService orderService;

	@Autowired
	ProductService productService;

	@Autowired
	SkuService skuService;

	@Autowired
	CartService cartService;

	@Autowired
	SequenceService sequenceService;

	/**
	 * 新增购物车
	 * @param cart
	 * @return
	 * @throws IllegalAccessException
	 * @throws InvocationTargetException
	 */
	@RequestMapping(value = "/cart/add", method = RequestMethod.POST, headers = "Accept=application/json")
	public ApiResponseObject saveOrder(@RequestBody Cart cart)
			throws IllegalAccessException, InvocationTargetException {
		if (StringUtils.isEmpty(cart.getUserId())) {
			return reponseJSON(ApiResponseEnum.FAIL.getCode(), ApiResponseEnum.FAIL.getName(), null);
		}
		Product product = productService.getProductByid(cart.getProductId());
		if (product == null) {
			return reponseJSON(ApiResponseEnum.FAIL.getCode(), ApiResponseEnum.FAIL.getName(), null);
		}
		// 需要计算库存
		if (product.getInventoryFlag() == 0) {
			if (!StringUtils.isEmpty(cart.getOptionValueKeyGroup())) {
				Sku sku = skuService.getSkyById(cart.getSkuId());
				if (sku != null) {
					if (cart.getQuantity() > sku.getQuantity()) {
						return reponseJSON(ApiResponseEnum.FAIL.getCode(), "库存不足", sku);
					}
				}
			} else {
				if (cart.getQuantity() > product.getQuantity()) {
					return reponseJSON(ApiResponseEnum.FAIL.getCode(), "库存不足", product);
				}
			}
		}
		cart.setCreateTime(new Date());		
		Integer i = cartService.searchCart(cart);
		if(i != 0){
			cart.setQuantity(cart.getQuantity()+i);;
			cartService.updateQuantity(cart);
		}else{
		String id = sequenceService.getSequence(Constants.SEQUENCE_TYPE_I,
				Constants.SEQUENCE_TYPE_I
						+ DateUtils.getFormatDate(cart.getCreateTime(), Constants.SYSTEM_DATE_FOMART_1),
				Constants.SEQUENCE_COUNTER);
		cart.setId(id);
		cartService.addCart(cart);
		}
		return reponseJSON(ApiResponseEnum.SUCCESS.getCode(), ApiResponseEnum.SUCCESS.getName(), 1);
	}

	/**
	 * 移除购物车
	 */
	@RequestMapping(value = "/cart/items/remove", method = RequestMethod.POST, headers = "Accept=application/json")
	public ApiResponseObject removeOrder(@RequestBody Cart cart)
			throws IllegalAccessException, InvocationTargetException {
		if (StringUtils.isEmpty(cart.getUserId())) {
			return this.reponseJSON(ApiResponseEnum.FAIL.getCode(), ApiResponseEnum.ERROR_PARAM.getName(), null);
		} else if (StringUtils.isEmpty(cart.getProductId())) {
			return this.reponseJSON(ApiResponseEnum.ERROR_PARAM.getCode(), ApiResponseEnum.ERROR_PARAM.getName(), null);
		}
		cartService.removeCart(cart);
		return reponseJSON(ApiResponseEnum.SUCCESS.getCode(), ApiResponseEnum.SUCCESS.getName(), 1);
	}

	/**
	 * 移除全部购物车
	 */
	@RequestMapping(value = "/cart/items/removeall", method = RequestMethod.POST, headers = "Accept=application/json")
	public ApiResponseObject removeAllOrder(@RequestBody Cart cart)
			throws IllegalAccessException, InvocationTargetException {
		if (StringUtils.isEmpty(cart.getUserId())) {
			return this.reponseJSON(ApiResponseEnum.FAIL.getCode(), ApiResponseEnum.ERROR_PARAM.getName(), null);
		}
		cartService.removeAllCart(cart);
		return reponseJSON(ApiResponseEnum.SUCCESS.getCode(), ApiResponseEnum.SUCCESS.getName(), 1);
	}

	/**
	 * 查询购物车详细
	 */
	@RequestMapping(value = "/cart", method = RequestMethod.POST, headers = "Accept=application/json")
	public ApiResponseObject getOrderItem(@RequestBody Cart cart)
			throws IllegalAccessException, InvocationTargetException {
		if (StringUtils.isEmpty(cart.getUserId())) {
			return this.reponseJSON(ApiResponseEnum.FAIL.getCode(), ApiResponseEnum.FAIL.getName(), null);
		}
		Map<String, Object> cartItem = cartService.getCart(cart);
		if (cartItem == null) {
			return this.reponseJSON(ApiResponseEnum.ERROR_DATA_EMPTY.getCode(),
					ApiResponseEnum.ERROR_DATA_EMPTY.getName(), null);
		}
		return reponseJSON(ApiResponseEnum.SUCCESS.getCode(), ApiResponseEnum.SUCCESS.getName(), cartItem);
	}

	/**
	 * 修改购物车
	 */
	@RequestMapping(value = "cart/items/update", method = RequestMethod.POST, headers = "Accept=application/json;charset=utf-8")
	public ApiResponseObject modOrder(@RequestBody Cart cart)
			throws IllegalAccessException, InvocationTargetException {
		if (StringUtils.isEmpty(cart.getUserId())) {
			return reponseJSON(ApiResponseEnum.FAIL.getCode(), ApiResponseEnum.FAIL.getName(), null);
		}
		System.out.println(cart.toString());
		for (Cart cartItem : cart.getCartItemList()) {
			cartItem.setUserId(cart.getUserId());
			cartService.updateQuantity(cartItem);
			Product product = productService.getProductByid(cartItem.getProductId());
			if (product == null) {
				return reponseJSON(ApiResponseEnum.FAIL.getCode(), ApiResponseEnum.FAIL.getName(), null);
			}
			// 需要计算库存
			if (product.getInventoryFlag() == 0) {
				if (!StringUtils.isEmpty(cart.getOptionValueKeyGroup())) {
					Sku sku = skuService.getSkyById(cart.getSkuId());
					if (sku != null) {
						if (cart.getQuantity() > sku.getQuantity()) {
							return reponseJSON(ApiResponseEnum.FAIL.getCode(), "库存不足", sku);
						}
					}
				} else {
					if (cart.getQuantity() > product.getQuantity()) {
						return reponseJSON(ApiResponseEnum.FAIL.getCode(), "库存不足", product);
					}
				}
			}
		}
		return reponseJSON(ApiResponseEnum.SUCCESS.getCode(), ApiResponseEnum.SUCCESS.getName(), 1);
	}

	/**
	 * 查询购物车数量
	 * 
	 * @param cart
	 * @return
	 * @throws IllegalAccessException
	 * @throws InvocationTargetException
	 */
	@RequestMapping(value = "/cart/count", method = RequestMethod.POST, headers = "Accept=application/json")
	public ApiResponseObject getOrderCount(@RequestBody Cart cart)
			throws IllegalAccessException, InvocationTargetException {
		System.out.println(cart.getUserId());
		if (StringUtils.isEmpty(cart.getUserId())) {
			return this.reponseJSON(ApiResponseEnum.FAIL.getCode(), ApiResponseEnum.FAIL.getName(), null);
		}
		return reponseJSON(ApiResponseEnum.SUCCESS.getCode(), ApiResponseEnum.SUCCESS.getName(),cartService.getCartCount(cart));
	}

}
