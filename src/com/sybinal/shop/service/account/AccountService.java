package com.sybinal.shop.service.account;

import java.util.List;
import java.util.Map;

import com.sybinal.shop.model.Account;

public interface AccountService {

	public Account getAccountByUser(Map<String, Object> reqMap);
	
	public int rechargeAccount(Account account);
	
	public int payOrderByEwallet(Account account);
	
	public List<Account> getAccountByUserId(Map<String, Object> reqMap);
}
