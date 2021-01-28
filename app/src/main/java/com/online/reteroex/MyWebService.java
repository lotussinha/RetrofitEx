package com.online.reteroex;

import com.online.reteroex.model.Comment;
import com.online.reteroex.model.Post;
import com.online.reteroex.model.Register;

import java.util.List;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.Retrofit.Builder;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface MyWebService {

   // String BASE_URL = "https://jsonplaceholder.typicode.com/";
    // https://console.egpaid.com/authuser/register
   String BASE_URL = "https://console.egpaid.com/";
    String FEED = "posts";

    Retrofit retrofit = new Retrofit.Builder().
            baseUrl(BASE_URL).
            addConverterFactory(GsonConverterFactory.create())
            .build();

    @GET(FEED)
    Call<List<Post>> getPosts();

   /* @GET("posts/{id}/comments")
    Call<List<Comment>> getComments(@Path("id") int userid);*/

   /* @GET("comments")
    Call<List<Comment>> getComments(@Query("postId") int postid);*/

    @GET("comments")
    Call<List<Comment>> getComments(@Query("postId") int postid,
                                    @Query("_sort") String sortBy,
                                    @Query("_order") String orderBy);

    @POST("posts")
    Call<Post> createPost(@Body Post post);

    @POST("authuser/register")
   // @Headers({"Content-Type: application/json"})
    @Headers({"APIKEY:mCH9hxghsSHVmgYDYhVKZJt2bsxJLN"})
    Call<Register> createRegister(@Body Register register);
}
