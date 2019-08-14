package com.han.adminlogin.config.redis;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

import javax.annotation.Resource;
import java.util.Map;
import java.util.concurrent.TimeUnit;

/**
 *@author sunq
 *@date2019/8/13 16:57
 *@Description redis工具类
 */

@Component
public class RedisUtils {

	@Resource
	private RedisTemplate<String, Object> redisTemplate;

	/**
	 *  指定缓存失效时间
	 * @param key
	 * @param time
	 * @return
	 */
	public boolean expire(String key, long time) {

		try {
			if (time > 0) {
				redisTemplate.expire(key, time, TimeUnit.SECONDS);
			}
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	/**
	 *  根据key获取过期时间
	 * @param key
	 * @return
	 */
	public long getExpire(String key) {
		return redisTemplate.getExpire(key);
	}

	/**
	 *  判断 key 是否存在
	 * @param key
	 * @return
	 */
	public boolean hasKey(String key) {
		try {
			return redisTemplate.hasKey(key);
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}


	/**
	 *  删除缓存
	 * @param key 可以传 一个或多个
	 */
	public void del(String... key) {
		if (key != null && key.length > 0) {
			if (key.length == 1) {
				redisTemplate.delete(key[0]);
			} else {
				redisTemplate.delete(CollectionUtils.arrayToList(key));
			}
		}
	}

	// =========================================String==================================
	/**
	 * 普通缓存获取
	 * @param key
	 * @return
	 */
	public Object get(String key){
		return key == null ? null : redisTemplate.opsForValue().get(key);
	}

	/**
	 * 普通缓存放入
	 * @param key
	 * @param value
	 * @return
	 */
	public boolean set(String key, Object value){
		try {
			redisTemplate.opsForValue().set(key, value);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	/**
	 *  普通缓存放入并设置过期时间
	 * @param key
	 * @param value
	 * @param time
	 * @return
	 */
	public boolean set(String key, Object value, long time){
		try {
			if (time > 0){
				redisTemplate.opsForValue().set(key, value, time, TimeUnit.SECONDS);
			}else {
				set(key, value);
			}
			return true;
		}catch (Exception e){
			e.printStackTrace();
			return false;
		}
	}

	/**
	 *  递增
	 * @param key
	 * @param delta 要增加几
	 * @return
	 */
	public long incr(String key, long delta){
		if (delta < 0){
			throw new RuntimeException("递增因子必须大于0");
		}
		return redisTemplate.opsForValue().increment(key, delta);
	}


	/**
	 *  递增
	 * @param key
	 * @param delta 要减少几
	 * @return
	 */
	public long decr(String key, long delta){
		if (delta < 0){
			throw new RuntimeException("递减因子必须大于0");
		}
		return redisTemplate.opsForValue().increment(key, -delta);
	}

	// =====================String end========================================

	//======================Map start=========================================

	/**
	 *  HashGet
	 * @param key
	 * @param item
	 * @return
	 */
	public Object hget(String key, String item){
		return redisTemplate.opsForHash().get(key, item);
	}

	/**
	 *  获取所有 hashKey 对应的所有的键值
	 * @param key
	 * @return
	 */
	public Map<Object, Object> hmget(String key){
		return redisTemplate.opsForHash().entries(key);
	}

	/**
	 *  hashSet
	 * @param key
	 * @param map
	 * @return
	 */
	public boolean hmset(String key, Map<String, Object> map){
		try {
			redisTemplate.opsForHash().putAll(key, map);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	/**
	 *  hashSet并设置时间
	 * @param key
	 * @param map
	 * @param time
	 * @return
	 */
	public boolean hmset(String key, Map<String, Object> map, long time){
		try {
			redisTemplate.opsForHash().putAll(key, map);
			if (time > 0){
				expire(key, time);
			}
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	/**
	 *  向一张 hash表 中放入数据，如果不存在将创建
	 * @param key
	 * @param item
	 * @param value
	 * @return
	 */
	public boolean hset(String key, String item, Object value){
		try {
			redisTemplate.opsForHash().put(key, item, value);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}


	/**
	 *  向一张hash表中放入数据,如果不存在将创建
	 * @param key
	 * @param item
	 * @param value
	 * @param time 时间(秒) 注意:如果已存在的hash表有时间,这里将会替换原有的时间
	 * @return
	 */
	public boolean hset(String key, String item, Object value, long time){
		try {
			redisTemplate.opsForHash().put(key, item, value);
			if (time > 0 ){
				expire(key, time);
			}
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	/**
	 *  删除 hash表 中的值
	 * @param key
	 * @param item
	 */
	public void hdel(String key, Object... item){
		redisTemplate.opsForHash().delete(key, item);
	}

	/**
	 *  判断 hash表 中是否有该项的值
	 * @param key 键 不能为null
	 * @param item 项 不能为null
	 * @return
	 */
	public boolean hHashKey(String key, String item){
		return redisTemplate.opsForHash().hasKey(key, item);
	}


	/**
	 *  hash 递增，如果不存在就会创建一个， 并把新增后的值返回
	 * @param key
	 * @param item
	 * @param by
	 * @return
	 */
	public double hincr(String key, String item, double by){
		return redisTemplate.opsForHash().increment(key, item, by);
	}

	/**
	 *  hash 递减
	 * @param key
	 * @param item
	 * @param by
	 * @return
	 */
	public double hdecr(String key, String item, double by){
		return redisTemplate.opsForHash().increment(key, item, -by);
	}








}
