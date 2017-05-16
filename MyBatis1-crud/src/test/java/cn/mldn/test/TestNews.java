package cn.mldn.test;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.junit.Test;

import cn.mldn.util.MyBatisSessionFactory;
import cn.mldn.vo.Member;
import junit.framework.TestCase;

public class TestNews {
	@Test
	public void testCount() {
		long currentPage = 5;
		int lineSize = 2;
		String keyWord = "饿";
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("column", "name");
		map.put("keyWord", "%" + keyWord + "%");
		map.put("start", (currentPage - 1) * lineSize);
		map.put("lineSize", lineSize);
		Long count = MyBatisSessionFactory.getSession()
				.selectOne("cn.mldn.mapping.MembersNS.getAllCount", map);
		System.out.println(count);
	}
	
	@Test
	public void testSplit() {
		long currentPage = 5;
		int lineSize = 2;
		String keyWord = "饿";
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("column", "name");
		map.put("keyWord", "%" + keyWord + "%");
		map.put("start", (currentPage - 1) * lineSize);
		map.put("lineSize", lineSize);
		List<Member> all = MyBatisSessionFactory.getSession()
				.selectList("cn.mldn.mapping.MembersNS.findAllSplit", map);
		System.out.println(all);
	}

	@Test
	public void testMap() {
		Map<Long, HashMap<Long, Object>> map = MyBatisSessionFactory
				.getSession()
				.selectMap("cn.mldn.mapping.MembersNS.findMap", "mid");
		Iterator<Map.Entry<Long, HashMap<Long, Object>>> iter = map.entrySet()
				.iterator();
		while (iter.hasNext()) {
			Map.Entry<Long, HashMap<Long, Object>> me = iter.next();
			System.out.println(me.getKey() + " = " + me.getValue());
			Iterator<Map.Entry<Long, Object>> meIter = me.getValue().entrySet()
					.iterator();
			while (meIter.hasNext()) {
				Map.Entry<Long, Object> me2 = meIter.next();
				System.out.println(
						"\t|- " + me2.getKey() + " = " + me2.getValue());
			}
		}
	}

	@Test
	public void testAll() {
		List<Member> all = MyBatisSessionFactory.getSession()
				.selectList("cn.mldn.mapping.MembersNS.findAll");
		System.out.println(all);
		TestCase.assertTrue(all.size() > 0);
	}

	@Test
	public void testGet() {
		// 直接返回一个News的处理对象
		Member vo = MyBatisSessionFactory.getSession()
				.selectOne("cn.mldn.mapping.MembersNS.findById", 1L);
		System.out.println(vo);
		TestCase.assertNotNull(vo);
	}

	@Test
	public void testDelete() {
		int count = MyBatisSessionFactory.getSession()
				.delete("cn.mldn.mapping.MembersNS.doDelete", 2L);
		MyBatisSessionFactory.getSession().commit();
		MyBatisSessionFactory.close();
		TestCase.assertEquals(count, 1);
	}

	@Test
	public void testEdit() {
		Member vo = new Member();
		vo.setMid(2L);
		vo.setName("下午捆了吗？");
		vo.setNote("捆也没用，继续上课，好好学习，天天向上。");
		int count = MyBatisSessionFactory.getSession()
				.update("cn.mldn.mapping.MembersNS.doUpdate", vo);
		MyBatisSessionFactory.getSession().commit();
		MyBatisSessionFactory.close();
		System.out.println(vo);
		TestCase.assertEquals(count, 1);
	}

	@Test
	public void testAdd() {
		Member vo = new Member();
		int count =0;
		for (int i = 0; i < 50; i++) {
			
			vo.setName("中午肚子饿了么？");
			vo.setNote("继续好好上课吧，别想太多了，不下课，好好学习，天天向上。");
			count = MyBatisSessionFactory.getSession()
					.insert("cn.mldn.mapping.MembersNS.doCreate", vo);
		}
		
		MyBatisSessionFactory.getSession().commit();
		MyBatisSessionFactory.close();
		System.out.println(vo);
		TestCase.assertEquals(count, 1);
	}

}
