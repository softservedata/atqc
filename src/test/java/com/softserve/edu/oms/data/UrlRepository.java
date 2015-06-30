package com.softserve.edu.oms.data;

public class UrlRepository {
	public static enum Urls {
		LOCAL_HOST("http://localhost:8080/OMS/login.htm"),
		SSU_HOST("http://ssu-oms:8180/OMS/login.htm");
		private String field;

		private Urls(String field) {
			this.field = field;
		}

		@Override
		public String toString() {
			return this.field;
		}
	}
	
//	public static String getClass86Url() {
//		return "http://class86:8080/OMS/login.htm";
//	}
//
//	public static String getSsuUrl() {
//		return "http://ssu-oms:8180/OMS/login.htm";
//	}
}
