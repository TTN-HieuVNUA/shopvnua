package com.hieu.repository;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.hieu.bean.TradeMark;
import com.hieu.repository.inter.TrademarkRepos;

@Repository
@Transactional
public class TrademarkRepository implements TrademarkRepos{

	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public List<TradeMark> getTradeMarksList() {
		List<TradeMark> tradeMarkslList = new ArrayList<TradeMark>();
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery("FROM TradeMark");
		tradeMarkslList = query.getResultList();
		return tradeMarkslList;
	}

	@Override
	public TradeMark findTradeMark(int id) {
		Session session = sessionFactory.getCurrentSession();
		TradeMark tradeMark = session.get(TradeMark.class, id);
		return tradeMark;
	}

}
