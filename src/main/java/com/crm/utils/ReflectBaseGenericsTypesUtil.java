package com.crm.utils;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

/**
 * 得到当前对象父类"泛型类型"(参数化类型)
 * @author 余峻豪
 *
 */
@SuppressWarnings("unchecked")
public class ReflectBaseGenericsTypesUtil {
	
	/**
	 * 例 : BaseDao<User> 得到 User 
	 */
	public static <T> Class<T> getBaseGenericsTypes(Class<?> clazz){

		Class<T> baseGenerics = null;
		
		ParameterizedType type = (ParameterizedType) clazz.getGenericSuperclass();
		
		Type[] types = type.getActualTypeArguments();
		
		baseGenerics = (Class<T>) types[0];
		
		return baseGenerics;
	}
	
}
