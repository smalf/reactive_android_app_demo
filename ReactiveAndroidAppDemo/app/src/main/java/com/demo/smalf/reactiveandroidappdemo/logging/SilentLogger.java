package com.demo.smalf.reactiveandroidappdemo.logging;

/**
 * Silent {@link com.wunderground.android.radar.utils.logging.Logger} implementation that does not
 * perform logging.
 *
 * @author Vitaliy Slupko
 */
public class SilentLogger implements Logger {

    @Override
    public int d(final String tag, final String msg) {
        return 0;
    }

    @Override
    public int d(final String tag, final String msg, final Throwable tr) {
        return 0;
    }

    @Override
    public int e(final String tag, final String msg) {
        return 0;
    }

    @Override
    public int e(final String tag, final String msg, final Throwable tr) {
        return 0;
    }

    @Override
    public int i(final String tag, final String msg) {
        return 0;
    }

    @Override
    public int i(final String tag, final String msg, final Throwable tr) {
        return 0;
    }

    @Override
    public int v(final String tag, final String msg) {
        return 0;
    }

    @Override
    public int v(final String tag, final String msg, final Throwable tr) {
        return 0;
    }

    @Override
    public int w(final String tag, final Throwable tr) {
        return 0;
    }

    @Override
    public int w(final String tag, final String msg, final Throwable tr) {
        return 0;
    }

    @Override
    public int w(final String tag, final String msg) {
        return 0;
    }
}
