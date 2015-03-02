package com.waytogo.myapp;

import java.util.Date;

//import org.apache.commons.codec.binary.Base64;

public class DSApiCalls {
	
	static String far="";
	static String noid="";
	static String them="";

	public static String getTheme()
	{
		//return "https://api.test.sabre.com/v1/lists/top/destinations?origin=dfw&destinationtype=DOMESTIC&theme=SKIING&topdestinations=2";
		return them;
	}
	
	
	public static void setTheme(String id1,String id2)
	{
		them = "https://api.test.sabre.com/v1/lists/top/destinations?origin="+id1+"&destinationtype=DOMESTIC&theme="+id2+"&topdestinations=2";
	}
	
	
	public static String getFares()
	{
		//return "https://api.test.sabre.com/v1/forecast/flights/fares?origin=jfk&destination=LAX&departuredate=2015-03-03&returndate=2015-03-05";
		return far;
	}
	
	public static void setFares(String id1, String id2, String id3, String id4)
	{
		far ="https://api.test.sabre.com/v1/shop/flights/fares?origin="+id1+"&destination="+id2+"&lengthofstay="+id3+"&maxfare="+id4;
		//System.out.println(far);
	}
	
	//far ="https://api.test.sabre.com/v1/forecast/flights/fares?origin="+id1+"&destination="+id2+"&departuredate="+id3+"&returndate="+id4;
	//System.out.println(far);

	public static String getDest()
	{
		return "https://api.tes.sabre.com/v1/shop/flights/fares?origin=dfw&lengthofstay=3&minfare=100&topdestinations=2";
	}
	
	public static String getNoIdea()
	{
	//return "https://api.test.sabre.com/v1/lists/top/destinations?origin=dfw&destinationtype=DOMESTIC&theme=BEACH&topdestinations=2";
	return noid;
	}
	public static void setNoidea(String id1)
	{
		noid = "https://api.test.sabre.com/v1/lists/top/destinations?origin="+id1+"&destinationtype=DOMESTIC&topdestinations=2";
	}
	/*public static void main(String[] args) {
		*/
		
/*
	}*/

}
