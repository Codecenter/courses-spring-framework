package solution2;

import java.util.List;

import org.springframework.web.client.RestTemplate;

import solution1.BlogPostList;
import blog.model.BlogPost;
import blog.services.BlogService;

public class RestBlogService implements BlogService {
	private RestTemplate rest;
	private String baseUrl;
	
	public RestBlogService(String baseUrl) {
		rest = new RestTemplate();
		this.baseUrl = baseUrl;
	}
	
	protected String url(String path) {
		if (!path.startsWith("/")) {
			path = "/" + path;
		}
		return baseUrl + path;
	}
	
	@Override
	public List<BlogPost> getBlogPosts() {
		BlogPostList list = rest.getForObject(url("/blog"), BlogPostList.class);
		return list.getBlogPost();
	}

	@Override
	public BlogPost getBlogPost(int id) {
		return rest.getForObject(url("/blog/{id}"), BlogPost.class, id);
	}

	@Override
	public BlogPost storeBlogPost(BlogPost post) {
		if (post.getId() == null) {
			return rest.postForObject(url("/blog"), post, BlogPost.class);
		}
		else {
			rest.put(url("/blog/{id}"), post, post.getId());
			return post;
		}
	}

	@Override
	public void deleteBlogPost(int id) {
		rest.delete(url("/blog/{id}"), id);
	}
}
