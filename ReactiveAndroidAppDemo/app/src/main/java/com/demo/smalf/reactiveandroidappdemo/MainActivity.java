package com.demo.smalf.reactiveandroidappdemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import com.demo.smalf.reactiveandroidappdemo.app.AppComponentsInjector;
import com.demo.smalf.reactiveandroidappdemo.app.ComponentsInjectors;
import com.demo.smalf.reactiveandroidappdemo.data.posts.DaggerPostsInjector;
import com.demo.smalf.reactiveandroidappdemo.data.posts.Post;
import com.demo.smalf.reactiveandroidappdemo.data.posts.PostsInjector;
import com.demo.smalf.reactiveandroidappdemo.data.posts.PostsLoader;
import com.demo.smalf.reactiveandroidappdemo.data.posts.PostsModule;
import com.demo.smalf.reactiveandroidappdemo.logging.Logger;
import com.demo.smalf.reactiveandroidappdemo.logging.LoggingComponents;
import com.demo.smalf.reactiveandroidappdemo.ui.PostsAdapter;

import java.util.Arrays;

import javax.inject.Inject;
import javax.inject.Named;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = MainActivity.class.getSimpleName();

    @Inject
    @Named(LoggingComponents.APP_LOGGER)
    Logger logger;

    private RecyclerView recyclerView;
    private Post[] posts;
    private PostsAdapter.OnItemClickedListener onItemClickedListener = (view, position) -> {
        if (posts != null && posts.length > 0) {
            Toast.makeText(this, "postId = " + posts[position].getId(), Toast.LENGTH_LONG).show();
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ComponentsInjectors.injector(AppComponentsInjector.class).inject(this);
        recyclerView = (RecyclerView) findViewById(R.id.posts_list);
        recyclerView.setLayoutManager(new LinearLayoutManager(this.getApplicationContext()));
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

        new PostsLoader(postsInjector).load(posts -> {
            MainActivity.this.posts = posts;
            final PostsAdapter adapter = new PostsAdapter(Arrays.asList(posts));
            adapter.setOnItemClickedListener(onItemClickedListener);
            recyclerView.setAdapter(adapter);
        });

    }

}
