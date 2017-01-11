package com.demo.smalf.reactiveandroidappdemo.data;

import android.support.annotation.NonNull;

import com.demo.smalf.reactiveandroidappdemo.app.ComponentsInjector;
import com.demo.smalf.reactiveandroidappdemo.logging.Logger;
import com.demo.smalf.reactiveandroidappdemo.logging.LoggingComponents;

import javax.inject.Inject;
import javax.inject.Named;

import rx.Subscription;
import rx.functions.Action0;
import rx.functions.Action1;

/**
 * Abstract {@link Loader} implementation, provides template functionality for most part of {@link
 * Loader} implementations.
 * @param <DataT> The type of data that should be loaded by this class.
 *
 * @author Serhiy Malofeev
 */
public abstract class AbstractLoader<DataT> implements Loader<DataT> {
    protected final String tag = getClass().getSimpleName();

    protected AbstractLoader(@NonNull final ComponentsInjector appComponentsInjector) {
        injectComponents(appComponentsInjector);
    }

    @Inject
    @Named(LoggingComponents.APP_LOGGER)
    protected Logger logger;

    @Override
    public Subscription load(final Action1<? super DataT> onNext) {
        logger.d(tag, "load :: onNext = " + onNext);
        return getObservable().subscribe(onNext);
    }

    @Override
    public Subscription load(final Action1<? super DataT> onNext, final Action1<Throwable> onError) {
        logger.d(tag, "load :: onNext = " + onNext + ", onError = " + onError);
        return getObservable().subscribe(onNext, onError);
    }

    @Override
    public Subscription load(final Action1<? super DataT> onNext, final Action1<Throwable> onError, final Action0 onCompleted) {
        logger.d(tag, "load :: onNext = " + onNext + ", onError = " + onError + ", onCompleted = " + onCompleted);
        return getObservable().subscribe(onNext, onError, onCompleted);
    }

    protected abstract void injectComponents(@NonNull final ComponentsInjector componentsInjector);
}