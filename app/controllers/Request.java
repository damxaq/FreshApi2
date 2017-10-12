package controllers;

import com.google.gson.Gson;

import play.mvc.Controller;

public class Request extends Controller{

	public static void index(){
		
		
		Gson gson = new Gson();
		int[] ints ={1, 2, 3, 4, 5};
		String[] strings = {"abc", "def", "cfg"};
		
		gson.toJson(ints);
		gson.toJson(strings);
		
		/*String jsons = "{'address':'https://api.freshmail.com/rest/subscribers_list/lists',"
				+ " 'XRestApiKey':'1912cf4c2a8b21303a3b32f65d3b3496',"
				+ " 'GET_data':'/rest/subscribers_list/lists', "
				+ " 'XRestApiSign':'707f36f31be89146842598b68e2580e5363c1f35'}";
		Request parsed = new Gson().fromJson(jsons, Request.class);
		*/
		render();
		renderJSON(gson);
	}
	
}
