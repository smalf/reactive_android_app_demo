package com.demo.smalf.reactiveandroidappdemo.data.posts;

import android.support.annotation.NonNull;

import com.demo.smalf.reactiveandroidappdemo.app.ComponentsInjector;
import com.demo.smalf.reactiveandroidappdemo.data.AbstractLoader;

import javax.inject.Inject;

import rx.Observable;

/**
 * {@link com.demo.smalf.reactiveandroidappdemo.data.Loader} implementation for loading posts.
 *
 * @author Serhiy Malofeev
 */
public class PostsLoader extends AbstractLoader<Post[]> {

    @Inject
    Observable<Post[]> observable;

    public PostsLoader(@NonNull PostsInjector appComponentsInjector) {
        super(appComponentsInjector);
    }

    @Override
    protected void injectComponents(@NonNull ComponentsInjector componentsInjector) {
        if (componentsInjector instanceof PostsInjector) {
            ((PostsInjector) componentsInjector).inject(this);
        }
    }

    @Override
    public Observable<Post[]> getObservable() {
        return observable;
    }
}
