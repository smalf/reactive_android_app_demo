package com.demo.smalf.reactiveandroidappdemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.demo.smalf.reactiveandroidappdemo.app.AppComponentsInjector;
import com.demo.smalf.reactiveandroidappdemo.app.ComponentsInjectors;
import com.demo.smalf.reactiveandroidappdemo.data.posts.DaggerPostsInjector;
import com.demo.smalf.reactiveandroidappdemo.data.posts.PostsInjector;
import com.demo.smalf.reactiveandroidappdemo.data.posts.PostsLoader;
import com.demo.smalf.reactiveandroidappdemo.data.posts.PostsModule;
import com.demo.smalf.reactiveandroidappdemo.logging.Logger;
import com.demo.smalf.reactiveandroidappdemo.logging.LoggingComponents;

import javax.inject.Inject;
import javax.inject.Named;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = MainActivity.class.getSimpleName();

    @Inject
    @Named(LoggingComponents.APP_LOGGER)
    Logger logger;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ComponentsInjectors.injector(AppComponentsInjector.class).inject(this);
    }

    @Override
    protected void onPostResume() {
        super.onPostResume();
        logger.d(TAG, "onPostResume::");
        loadPosts();
    }

    private void loadPosts() {
        logger.d(TAG, "loadPosts::");
        final PostsModule postsModule = PostsModule.builder().build();
        final PostsInjector postsInjector = DaggerPostsInjector.builder()
                //here we don't need any changes in Module so we can use it with default values.
                .postsModule(postsModule)
                .appComponentsInjector(ComponentsInjectors.injector(AppComponentsInjector.class))
                .build();

        new PostsLoader(postsInjector).load(posts -> logger.d(TAG, "[TESTING] posts = " + posts));
    }

}
