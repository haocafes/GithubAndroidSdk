package com.alorma.github.sdk.services.gists;

import com.alorma.github.sdk.bean.dto.request.CommentRequest;
import com.alorma.github.sdk.bean.dto.request.EditGistRequestDTO;
import com.alorma.github.sdk.bean.dto.response.Gist;
import com.alorma.github.sdk.bean.dto.response.GithubComment;

import java.util.List;

import retrofit.Callback;
import retrofit.client.Response;
import retrofit.http.Body;
import retrofit.http.DELETE;
import retrofit.http.Field;
import retrofit.http.GET;
import retrofit.http.PATCH;
import retrofit.http.POST;
import retrofit.http.Path;
import retrofit.http.Query;
import rx.Observable;

/**
 * Created by Bernat on 08/07/2014.
 */
public interface GistsService {

	//Async
	@GET("/gists")
	void userGistsListAsync(Callback<List<Gist>> callback);

	@GET("/gists")
	void userGistsListAsync(@Query("page") int page, Callback<List<Gist>> callback);

	@GET("/users/{username}/gists")
	void userGistsListAsync(@Path("username") String username, Callback<List<Gist>> callback);

	@GET("/users/{username}/gists")
	void userGistsListAsync(@Path("username") String username, @Query("page") int page, Callback<List<Gist>> callback);

	@GET("/gists/starred")
	void userStarredGistsList(Callback<List<Gist>> callback);

	@GET("/gists/starred")
	void userStarredGistsList(@Query("page") int page, Callback<List<Gist>> callback);

	@GET("/gists/{id}/comments")
	void comments(@Path("id") String id, Callback<List<GithubComment>> callback);

	@GET("/gists/{id}/comments")
	void comments(@Path("id") String id, @Query("page") int page, Callback<List<GithubComment>> callback);

	@GET("/gists/public")
	void publicGistsList(Callback<List<Gist>> callback);

	@GET("/gists/public")
	void publicGistsList(@Query("page") int page, Callback<List<Gist>> callback);


	@GET("/gists/starred")
	List<Gist> userStarredGistsListSync();

	@GET("/gists/starred")
	List<Gist> userStarredGistsListSync(@Query("page") int page);

	@GET("/gists/{id}/comments")
	List<GithubComment> comments(@Path("id") String id);

	@GET("/gists/{id}/comments")
	List<GithubComment> comments(@Path("id") String id, @Query("page") int page);

	@GET("/gists")
	List<Gist> userGistsList();

	@GET("/gists")
	List<Gist> userGistsList(@Query("page") int page);

	@GET("/users/{username}/gists")
	List<Gist> userGistsList(@Path("username") String username);

	@GET("/users/{username}/gists")
	List<Gist> userGistsList(@Path("username") String username, @Query("page") int page);

	@GET("/gists/public")
	List<Gist> publicGistsList();

	@GET("/gists/public")
	List<Gist> publicGistsList(@Query("page") int page);






	@GET("/gists/{id}")
	Observable<Gist> gistDetail(@Path("id") String id);

	@POST("/gists")
	Observable<Gist> publish(@Body Gist gist);

	@POST("/gists/{id}/comments")
	Observable<GithubComment> publishComment(@Path("id") String id, @Body CommentRequest body);

	@PATCH("/gists/{id}")
	Observable<Gist> edit(@Path("id") String id, @Body EditGistRequestDTO editGistRequestDTO);

	@DELETE("/gists/{id}/comments/{comment_id}")
	Observable<Response> deleteComment(@Path("id") String id, @Path("comment_id") String commentId);

	@POST("/gists/{id}/comments/{comment_id}")
	Observable<GithubComment> editComment(@Path("id") String gistId, @Path("comment_id") String commentId, @Body CommentRequest body);

}