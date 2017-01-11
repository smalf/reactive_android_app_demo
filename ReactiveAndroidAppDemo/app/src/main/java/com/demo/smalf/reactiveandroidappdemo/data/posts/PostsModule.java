package com.demo.smalf.reactiveandroidappdemo.data.posts;

import android.support.annotation.NonNull;

import com.demo.smalf.reactiveandroidappdemo.app.ActivityScope;
import com.demo.smalf.reactiveandroidappdemo.net.services.PostService;
import com.demo.smalf.reactiveandroidappdemo.net.services.PostsService;

import dagger.Module;
import dagger.Provides;
import rx.Observable;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Provides posts components, that could be changed in run time.
 *
 * @author Serhiy Malofeev
 */
@Module
public class PostsModule {
    public static final int POST_ID_UNDEFINED = -1;

    private Integer postId;

    private PostsModule(Builder builder) {
        this.postId = builder.postId;
    }

    public static Builder builder() {
        return new Builder();
    }

    public static final class Builder {
        private Integer postId = POST_ID_UNDEFINED;

        private Builder() {
        }

        /**
         * Sets the id of the post that should be loaded.
         *
         * @param postId
         * @return current instance of builder
         */
        public Builder postId(@NonNull Integer postId) {
            this.postId = postId;
            return this;
        }

        public PostsModule build() {
            return new PostsModule(this);
        }
    }

    /**
     * Sets the id of the post that should be loaded.
     *
     * @param postId
     * @return current instance of builder
     */
    public void postId(@NonNull Integer postId) {
        this.postId = postId;
    }

    @Provides
    @ActivityScope
    Observable<Post[]> providePostsRequestObservable(
            final PostsService postsService
    ) {
        return postsService
                .loadPosts()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread());
    }

    @Provides
    @ActivityScope
    Observable<Post> providePostRequestObservable(
            final PostService postsService
    ) {
        return postsService
                .loadPost(postId)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread());
    }

}
