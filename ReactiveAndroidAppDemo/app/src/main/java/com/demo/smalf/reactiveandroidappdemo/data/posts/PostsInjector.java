package com.demo.smalf.reactiveandroidappdemo.data.posts;

import com.demo.smalf.reactiveandroidappdemo.app.ActivityScope;
import com.demo.smalf.reactiveandroidappdemo.app.AppComponentsInjector;
import com.demo.smalf.reactiveandroidappdemo.app.ComponentsInjector;

import dagger.Component;

/**
 * @author Serhiy Malofeev
 */
@ActivityScope
@Component(modules = {PostsModule.class}, dependencies = {AppComponentsInjector.class})
public interface PostsInjector extends ComponentsInjector {

    void inject(PostsLoader loader);

}
