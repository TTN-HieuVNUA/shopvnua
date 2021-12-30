package com.hieu.repository;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.hieu.bean.Account;
import com.hieu.bean.Role;
import com.hieu.regex.Encode;
import com.hieu.regex.RegexPattern;
import com.hieu.repository.inter.AccountRepos;

@Repository
@Transactional
public class AccountRepository implements AccountRepos {

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public boolean regiser(String name, String email, String password) {
		Encode encode = new Encode();
		RegexPattern regexPattern = new RegexPattern();
		Session session = sessionFactory.getCurrentSession();

		if (regexPattern.checkEmail(email)) {
			// ma hoa password va xoa ki tu dac biet trong ten
			String passw = encode.encodePassword(password);
			String names = regexPattern.deleteSpicialCharacter(name);
			Account account = new Account();
			account.setUsername(email);
			account.setPassword(passw);
			account.setStatus(0);
			account.setName(names);
			// set quyen la user binh thuong
			Role role = session.get(Role.class, 3);
			session.save(account);
			role.getListaccount().add(account);
			return true;
		}

		return false;
	}

	@Override
	public boolean checkAccount(String username, String password) {
		Encode encode = new Encode();
		String passw = encode.encodePassword(password);

		Session session = sessionFactory.getCurrentSession();
		CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
		CriteriaQuery<Account> query = criteriaBuilder.createQuery(Account.class);
		Root<Account> root = query.from(Account.class);

		Predicate p1 = criteriaBuilder.equal(root.get("username").as(String.class), username);
		Predicate p2 = criteriaBuilder.equal(root.get("password").as(String.class), passw);
		query.where(criteriaBuilder.and(p1, p2));

		Query q = session.createQuery(query);
		if (q.getSingleResult() != null) {
			return true;
		} else {
			return false;
		}
	}

	@Override
	public Account findAccount(String username) {
		Session session = sessionFactory.getCurrentSession();
		CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
		CriteriaQuery<Account> query = criteriaBuilder.createQuery(Account.class);
		Root<Account> root = query.from(Account.class);
		
		Predicate p1 = criteriaBuilder.equal(root.get("username").as(String.class), username);
		
		query.where(criteriaBuilder.and(p1));

		Query q = session.createQuery(query);
		Account account = (Account) q.getSingleResult();
		return account;
	}

	@Override
	public List<String> getRoleName(Account account) {
		List<Role> listRole = account.getLisRoles();
		System.out.println(listRole);
		List<String> listRoleName = new ArrayList<String>();
		for(int i=0; i<listRole.size(); i++) {
			listRoleName.add(listRole.get(i).getRoleName());
		}
		return listRoleName;
	}
	

}
