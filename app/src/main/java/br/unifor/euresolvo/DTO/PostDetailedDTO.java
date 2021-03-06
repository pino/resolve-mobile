package br.unifor.euresolvo.DTO;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import br.unifor.euresolvo.Models.Comment;
import br.unifor.euresolvo.Models.Post;
import br.unifor.euresolvo.Models.Solution;
import br.unifor.euresolvo.Models.User;

public class PostDetailedDTO implements Serializable {

	private static final long serialVersionUID = -6083320017667645716L;

	private Long id;
	private String title;
	private String content;
	private String date;
	private String authorUsername;
	private Set<Long> voteIds;
	private List<CommentDTO> comments;
	private List<SolutionDTO> solutions;

	public static PostDetailedDTO fromPost(Post post) {
		PostDetailedDTO dto = new PostDetailedDTO();
		dto.setId(post.getId());
		dto.setTitle(post.getTitle());
		dto.setDate(post.getDate());
		dto.setAuthorUsername(post.getAuthor().getUsername());
		dto.setContent(post.getContent());
		Set<Long> voteIds = new HashSet<>();
		if (post.getVotes() != null) {
			for (User u : post.getVotes()) {
				voteIds.add(u.getId());
			}
		}
		dto.setVoteIds(voteIds);
		List<CommentDTO> comments = new ArrayList<>();
		if (post.getComments() != null) {
			for (Comment c : post.getComments()) {
				comments.add(CommentDTO.fromComment(c));
			}
		}
		dto.setComments(comments);
		List<SolutionDTO> solutions = new ArrayList<>();
		if (post.getSolutions() != null) {
			for (Solution s : post.getSolutions()) {
				solutions.add(SolutionDTO.fromSolution(s));
			}
		}
		dto.setSolutions(solutions);
		return dto;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getAuthorUsername() {
		return authorUsername;
	}

	public void setAuthorUsername(String authorUsername) {
		this.authorUsername = authorUsername;
	}

	public Set<Long> getVoteIds() {
		return voteIds;
	}

	public void setVoteIds(Set<Long> voteIds) {
		this.voteIds = voteIds;
	}

	public List<CommentDTO> getComments() {
		return comments;
	}

	public void setComments(List<CommentDTO> comments) {
		this.comments = comments;
	}

	public List<SolutionDTO> getSolutions() {
		return solutions;
	}

	public void setSolutions(List<SolutionDTO> solutions) {
		this.solutions = solutions;
	}
}
