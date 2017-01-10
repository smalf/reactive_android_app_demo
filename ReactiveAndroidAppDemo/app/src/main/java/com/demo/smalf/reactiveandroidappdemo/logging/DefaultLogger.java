package com.demo.smalf.reactiveandroidappdemo.logging;

import android.util.Log;

/**
 * Default implementation of {@link Logger} that logs
 * all messages.
 *
 * @author Serhiy Malofeev
 */
class DefaultLogger implements Logger {

    private String applicationIdentifier;

    public DefaultLogger(final String applicationIdentifier) {
        this.applicationIdentifier = applicationIdentifier + ": ";
    }

    @Override
    public int d(final String tag, final String msg) {
        return Log.d(applicationIdentifier + tag, msg);
    }

    @Override
    public int d(final String tag, final String msg, final Throwable tr) {
        return Log.d(applicationIdentifier + tag, msg, tr);
    }

    @Override
    public int e(final String tag, final String msg) {
        return Log.e(applicationIdentifier + tag, msg);
    }

    @Override
    public int e(final String tag, final String msg, final Throwable tr) {
        return Log.e(applicationIdentifier + tag, msg, tr);
    }

    @Override
    public int i(final String tag, final String msg) {
        return Log.i(applicationIdentifier + tag, msg);
    }

    @Override
    public int i(final String tag, final String msg, final Throwable tr) {
        return Log.i(applicationIdentifier + tag, msg, tr);
    }

    @Override
    public int v(final String tag, final String msg) {
        return Log.v(applicationIdentifier + tag, msg);
    }

    @Override
    public int v(final String tag, final String msg, final Throwable tr) {
        return Log.v(applicationIdentifier + tag, msg, tr);
    }

    @Override
    public int w(final String tag, final Throwable tr) {
        return Log.w(applicationIdentifier + tag, tr);
    }

    @Override
    public int w(final String tag, final String msg, final Throwable tr) {
        return Log.w(applicationIdentifier + tag, msg, tr);
    }

    @Override
    public int w(final String tag, final String msg) {
        return Log.w(applicationIdentifier + tag, msg);
    }
}
