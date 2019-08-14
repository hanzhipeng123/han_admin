package com.han.adminlogin.config.redis;

import org.springframework.core.convert.converter.Converter;
import org.springframework.core.serializer.support.DeserializingConverter;
import org.springframework.core.serializer.support.SerializingConverter;
import org.springframework.data.redis.serializer.RedisSerializer;
import org.springframework.data.redis.serializer.SerializationException;

/**
 *@author sunq
 *@date2019/8/13 16:48
 *@Description 定义序列化所有类的对象
 */

public class RedisObjectSerializer implements RedisSerializer<Object> {

	// 为了方便进行对象与字节数组的转换，首先准备出两个转换器

	private Converter<Object, byte[]> serializingConverter = new SerializingConverter();
	private Converter<byte[], Object> deSerializingConverter = new DeserializingConverter();

	private static final byte[] EMPTY_BYTE_ARRAY = new byte[0];    // 做一个空数组，不是null

	@Override
	public byte[] serialize(Object o) throws SerializationException {
		if (o == null) {	 // 这个时候没有要序列化的对象出现，所以返回的字节数组应该就是一个空数组
			return EMPTY_BYTE_ARRAY;
		}
		return this.serializingConverter.convert(o);
	}

	@Override
	public Object deserialize(byte[] bytes) throws SerializationException {
		if (bytes == null || bytes.length == 0) {
			return null;
		}
		return deSerializingConverter.convert(bytes);
	}
}

