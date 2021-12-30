package com.hieu.repository.inter;

import java.util.List;

import com.hieu.bean.TradeMark;

public interface TrademarkRepos {

	public List<TradeMark> getTradeMarksList();
	
	public TradeMark findTradeMark(int id);
}
