package solution1;

import java.util.Collection;
import java.util.LinkedList;
import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import blog.model.BlogPost;

/**
 * Required if we want to use XML.
 */
@XmlRootElement(name = "BlogPostList")
public class BlogPostList {
	private List<BlogPost> blogPost;

	public BlogPostList() {
	}
	
	public BlogPostList(Collection<BlogPost> blogPost) {
		this.blogPost = new LinkedList<BlogPost>(blogPost);
	}
	
	@XmlElement(name = "BlogPost")
	public List<BlogPost> getBlogPost() {
		if (blogPost == null) {
			blogPost = new LinkedList<BlogPost>();
		}
		return blogPost;
	}

	public void setBlogPost(List<BlogPost> blogPost) {
		this.blogPost = blogPost;
	}
}
