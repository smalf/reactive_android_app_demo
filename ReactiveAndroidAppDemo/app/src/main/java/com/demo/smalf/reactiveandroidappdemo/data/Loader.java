package com.demo.smalf.reactiveandroidappdemo.data;

import rx.Observable;
import rx.Subscription;
import rx.functions.Action0;
import rx.functions.Action1;

/**
 * Defines contract for data loader.
 * @param <DataT> The type of data that should be loaded by this class.
 *
 * @author Serhiy Malofeev
 */
public interface Loader<DataT> {

    Subscription load(final Action1<? super DataT> onNext);
    Subscription load(final Action1<? super DataT> onNext, final Action1<Throwable> onError);
    Subscription load(final Action1<? super DataT> onNext, final Action1<Throwable> onError, final Action0 onCompleted);

    Observable<DataT> getObservable();

}
