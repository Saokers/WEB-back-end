package com.sybinal.shop.mapper;

import com.sybinal.shop.model.OrderHistory;
import com.sybinal.shop.model.OrderHistoryExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface OrderHistoryMapper {

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table order_history
	 * @mbggenerated  Wed Oct 19 21:07:43 CST 2016
	 */
	int countByExample(OrderHistoryExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table order_history
	 * @mbggenerated  Wed Oct 19 21:07:43 CST 2016
	 */
	int deleteByExample(OrderHistoryExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table order_history
	 * @mbggenerated  Wed Oct 19 21:07:43 CST 2016
	 */
	int deleteByPrimaryKey(Integer id);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table order_history
	 * @mbggenerated  Wed Oct 19 21:07:43 CST 2016
	 */
	int insert(OrderHistory record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table order_history
	 * @mbggenerated  Wed Oct 19 21:07:43 CST 2016
	 */
	int insertSelective(OrderHistory record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table order_history
	 * @mbggenerated  Wed Oct 19 21:07:43 CST 2016
	 */
	List<OrderHistory> selectByExample(OrderHistoryExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table order_history
	 * @mbggenerated  Wed Oct 19 21:07:43 CST 2016
	 */
	OrderHistory selectByPrimaryKey(Integer id);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table order_history
	 * @mbggenerated  Wed Oct 19 21:07:43 CST 2016
	 */
	int updateByExampleSelective(@Param("record") OrderHistory record,
			@Param("example") OrderHistoryExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table order_history
	 * @mbggenerated  Wed Oct 19 21:07:43 CST 2016
	 */
	int updateByExample(@Param("record") OrderHistory record,
			@Param("example") OrderHistoryExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table order_history
	 * @mbggenerated  Wed Oct 19 21:07:43 CST 2016
	 */
	int updateByPrimaryKeySelective(OrderHistory record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table order_history
	 * @mbggenerated  Wed Oct 19 21:07:43 CST 2016
	 */
	int updateByPrimaryKey(OrderHistory record);
	

	int selectByHistoryCount();
}