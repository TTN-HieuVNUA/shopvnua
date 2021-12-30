package com.hieu.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hieu.bean.TradeMark;
import com.hieu.repository.inter.TrademarkRepos;
import com.hieu.service.inter.TradeMarkSv;

@Service
public class TradeMarkService implements TradeMarkSv{

	@Autowired
	private TrademarkRepos trademarkRepos;
	
	@Override
	public List<TradeMark> getListTradeMarks() {
		// TODO Auto-generated method stub
		return trademarkRepos.getTradeMarksList();
	}

}
