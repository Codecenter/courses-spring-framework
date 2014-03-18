package exercise1;

import org.springframework.web.client.RestTemplate;

import solution1.BlogPostList;
import blog.model.BlogPost;

public class RestClient {
	public static void main(String[] args) {
		RestTemplate rest = new RestTemplate();
		
		BlogPostList list = rest.getForObject("http://localhost:8080/rest/blog/", 
				BlogPostList.class);
		System.out.println("Found " + list.getBlogPost().size() + " blog post(s):");
		for (BlogPost post : list.getBlogPost()) {
			System.out.println("#" + post.getId() + ": " + post.getTitle());
		}
		
		for (BlogPost post : list.getBlogPost()) {			
			int id = post.getId();
			System.out.println("\nLoading blog post by id " + id);
			
			post = rest.getForObject("http://localhost:8080/rest/blog/{id}", 
					BlogPost.class, id);
			
			System.out.println("- Id: " + post.getId());
			System.out.println("- Created: " + post.getCreated());
			System.out.println("- Title: " + post.getTitle());
			System.out.println("- Message: " + post.getMessage());
		}
	}
}
