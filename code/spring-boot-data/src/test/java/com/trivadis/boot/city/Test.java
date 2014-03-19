package com.trivadis.boot.city;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

import sun.reflect.generics.reflectiveObjects.ParameterizedTypeImpl;

public class Test {
	public static void main(String[] args) {
		Type[] genericInterfaces = CityRepository.class.getGenericInterfaces();
		for(Type t : genericInterfaces){
			ParameterizedTypeImpl p = (ParameterizedTypeImpl) t;
			for(Type x : p.getActualTypeArguments()){
				System.out.println(x);
			}
		}
	}
}
