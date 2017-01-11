package com.demo.smalf.reactiveandroidappdemo.logging;

import android.content.pm.ApplicationInfo;

import com.demo.smalf.reactiveandroidappdemo.app.AppComponents;
import com.demo.smalf.reactiveandroidappdemo.app.DemoAppScope;

import javax.inject.Named;

import dagger.Module;
import dagger.Provides;
import okhttp3.logging.HttpLoggingInterceptor;

/**
 * Provides application logger.
 *
 * @author Serhiy Malofeev
 */
@Module
public class LoggingModule {

    @Provides
    @DemoAppScope
    @Named(LoggingComponents.APP_LOGGER)
    public Logger provideAppLogger(
            final ApplicationInfo appInfo,
            final @Named(AppComponents.APP_IDENTIFIER) String applicationIdentifier
    ) {
        return ((appInfo.flags & ApplicationInfo.FLAG_DEBUGGABLE) != 0)
                ? new DefaultLogger(applicationIdentifier)
                : new SilentLogger();
    }

    @Provides
    @DemoAppScope
    @Named(LoggingComponents.SILENT_LOGGER)
    public Logger provideSilentLogger() {
        return new SilentLogger();
    }

    @Provides
    @DemoAppScope
    @Named(LoggingComponents.DEFAULT_LOGGER)
    public Logger provideDefaultLogger(
            final @Named(AppComponents.APP_IDENTIFIER) String applicationIdentifier
    ) {
        return new DefaultLogger(applicationIdentifier);
    }

    @Provides
    @DemoAppScope
    public HttpLoggingInterceptor.Level provideHttpLoggingLevel(
            final ApplicationInfo appInfo
    ) {
        return (((appInfo.flags & ApplicationInfo.FLAG_DEBUGGABLE) != 0))
                ? HttpLoggingInterceptor.Level.BODY
                : HttpLoggingInterceptor.Level.NONE;
    }
}
