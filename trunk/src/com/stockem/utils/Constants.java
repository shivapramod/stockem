package com.stockem.utils;


public class Constants {

	public static String AUTHENTICATOR = "kashi.stm";
	public static String APP_PROPS = "app.prop";
	
	public static enum Environment { 
		STAGE("stage"),
		DEV("dev"),
		PROD("prod");
		
		private String value;
		Environment(String value){
            this.value = value;
         }
		
         public String toString(){
             return value;
         }
		
		};
}
