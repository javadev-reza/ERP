package com.microservice.erp2017.security.model;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * AppPermission annotation, digunakan untuk method yang butuh authorized dari database
 * can use in method only.
 * @author Adik
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface  AppPermission {
	public static final int SAVE = 100;
	public static final int UPDATE = 200;
	public static final int DELETE = 300;
	public static final int PRINT = 400;
	public static final int VIEW = 500;
	public static final int SPECIALS = 600;
	int[] value();
}
