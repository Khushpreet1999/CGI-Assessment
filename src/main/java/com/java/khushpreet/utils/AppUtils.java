package com.java.khushpreet.utils;
import com.java.khushpreet.models.Person;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;


import org.json.JSONObject;

public class AppUtils {
	public static Person parseAgeResponse(String responseBody, Person person) {
		JSONObject response = new JSONObject(responseBody);
		person.setAge(response.getInt("age"));
		return person;
	}
	public static Person parseGenderResponse(String responseBody, Person person) {
		JSONObject response = new JSONObject(responseBody);
		person.setGender(response.getString("gender"));
		person.setPropbality(response.getFloat("probability"));
		return person;
	}
	
public static String getAgeReponse (String name) {
		
		BufferedReader reader;
		HttpURLConnection conn = null;
		String line;
		String response = "";
		//Take http response as a string 
		StringBuilder responseContent = new StringBuilder();
		try{
			URL url = new URL("https://api.agify.io?name=" + name);
			 conn = (HttpURLConnection) url.openConnection();
			
			// Request setup
			conn.setRequestMethod("GET");
			
			// Test if the response from the server is successful
			int status = conn.getResponseCode();
			//If it is 200 then it is succesfull
			if (status >= 300) {
				reader = new BufferedReader(new InputStreamReader(conn.getErrorStream()));
				while ((line = reader.readLine()) != null) {
					responseContent.append(line);
				}
				reader.close();
			}
			else {
				reader = new BufferedReader(new InputStreamReader(conn.getInputStream()));
				while ((line = reader.readLine()) != null) {
					responseContent.append(line);
				}
				reader.close();
			}
			
		 response = responseContent.toString();
		
		}
		catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}finally {
			if(conn!=null)
			{
			conn.disconnect();
		}
		}
		return response;
	}
public static String getGenderReponse(String name) {
	
	BufferedReader reader;
	HttpURLConnection conn = null;
	String line;
	String response = "";
	StringBuilder responseContent = new StringBuilder();
	try{
		URL url = new URL("https://api.genderize.io?name=" + name);
		conn = (HttpURLConnection) url.openConnection();
		
		// Request setup
		conn.setRequestMethod("GET");
		
		// Test if the response from the server is successful
		int status = conn.getResponseCode();
		
		if (status >= 300) {
			reader = new BufferedReader(new InputStreamReader(conn.getErrorStream()));
			//We will read the response line by line
			while ((line = reader.readLine()) != null) {
				responseContent.append(line);
			}
			reader.close();
		}
		else {
			reader = new BufferedReader(new InputStreamReader(conn.getInputStream()));
			while ((line = reader.readLine()) != null) {
				responseContent.append(line);
			}
			reader.close();
		}
		
		response = responseContent.toString();
	}
	catch (MalformedURLException e) {
		e.printStackTrace();
	} catch (IOException e) {
		e.printStackTrace();
	}
	finally {
		if(conn!=null)
		{
		conn.disconnect();
	}
	}
	return response;
}
}

