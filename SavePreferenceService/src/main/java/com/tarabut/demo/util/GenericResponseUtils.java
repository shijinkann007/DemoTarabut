package com.tarabut.demo.util;

import java.util.Arrays;

import com.tarabut.demo.dto.GenericResponse;

public class GenericResponseUtils {

	public static GenericResponse buildGenericResponseOK(Object data) {
 		return new GenericResponse("ok",200,null,data);
	}

	public static GenericResponse buildGenericResponseOK(String message) {
 		return new GenericResponse("ok",200,Arrays.asList(message),null);

 	}

	public static GenericResponse buildGenericResponseError(Throwable t) {
  		return new GenericResponse("Error",400,Arrays.asList(t.getCause().getMessage()),null);

	}

	public static GenericResponse buildGenericResponseError(Object body) {
   		return new GenericResponse("error",400, null,body);

	}

	public static GenericResponse buildGenericResponseError(String message, Object body) {
  		return new GenericResponse("error",400,Arrays.asList(message),body);

 	}

	public static GenericResponse buildGenericResponseError(String message) {
  		return new GenericResponse("error",400,Arrays.asList(message),null);

	}
}
