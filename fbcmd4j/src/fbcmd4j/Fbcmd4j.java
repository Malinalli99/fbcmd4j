package fbcmd4j;

import java.net.MalformedURLException;
import java.net.URL;
import facebook4j.Facebook;
import facebook4j.FacebookException;
import facebook4j.FacebookFactory;
import facebook4j.Post;
import facebook4j.PostUpdate;
import facebook4j.ResponseList;
import facebook4j.User;
import facebook4j.auth.AccessToken;

public class Fbcmd4j {
	
	private static String appId = "269750423908018";
	private static String appSecret = "5f0c27e3ea874f724a36fa9730eecebc";
	private static String accessToken = "EAAD1Viox7rIBAIrUoKQ3e82KjVZCHSbAYwR4NpsrWZANUsu5PuX2yqwlFIHM8tHWYWKZBqZAZCO3eAYIoiO2ZAewBwsyZCNKQtCFpZCP2Oka5c7sMdMzpqV2N2ZCcL4Xftc2yq6CfVexmuswZCFnKRI1MI0ZCf8LMhSIEbIVee8852kROTssXH1k0IfmaZBzSuVXOakcP5vJzS7o08hLDHkCZBDtmk381UaoSMAhXtKD0nKuvtgZDZD";
	

	public static void main(String[] args) throws FacebookException, MalformedURLException {
		// TODO Auto-generated method stub
		
		Facebook facebook = new FacebookFactory().getInstance();
		facebook.setOAuthAppId(appId, appSecret);
		facebook.setOAuthAccessToken(new AccessToken (accessToken,null));
		
		//Informacion
		User user = facebook.getMe();
		System.out.println("Nombre del desarrollador: ");
		System.out.println("\t"+user.getName());
		
		
		//Publicar post
		PostUpdate post = new PostUpdate(new URL("http://facebook4.org"))
				.name("Facebook4j - A Java library for the Facebook Graph API")
				.caption("facebook4.org")
				.description("Facebook4j is a Java library for the Facebook Graph API.");
		facebook.postFeed(post);
		
		//Busqueda de personas
		ResponseList<User> results = facebook.searchUsers("LuisMi");
		System.out.println("Busqueda de personas con LuisMi");
		for (int i = 0; i<results.size(); i++) {
			User u = results.get(i);
			System.out.println("\t"+u.getName());
		}
		
		//Post con una o varias palabras
		ResponseList<Post> results2 = facebook.searchPosts("Holi");
		System.out.println("Busqueda de posts sobre holi");
		for (int i = 0; i<results2.size(); i++) {
			Post p = results2.get(i);
			System.out.println("\t"+p.getMessage());
		}
		facebook.postLink(new URL("https://facebook4j.github.io"));
		facebook.postLink(new URL("https://facebook4j.github.io"), "A Java library for the Facebook Graph API");
		
		
	}

}
