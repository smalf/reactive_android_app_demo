package com.demo.smalf.reactiveandroidappdemo.net.services;

import com.demo.smalf.reactiveandroidappdemo.data.posts.Post;

import retrofit2.http.GET;
import rx.Observable;

/**
 * Defines contract for posts service.
 *
 * @author Serhiy Malofeev
 */
public interface PostsService {
    @GET("posts")
    Observable<Post[]> loadPosts();
}
