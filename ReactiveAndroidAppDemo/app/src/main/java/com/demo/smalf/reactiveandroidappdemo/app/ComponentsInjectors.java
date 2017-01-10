package com.demo.smalf.reactiveandroidappdemo.app;

import android.support.annotation.NonNull;

import java.util.HashMap;
import java.util.Map;

/**
 * Provides app components injectors.
 *
 * @author Serhiy Malofeev
 */
public class ComponentsInjectors {

    private static final Map<Class<? extends ComponentsInjector>, ComponentsInjector> COMPONENTS_INJECTORS = new HashMap<>();

    private ComponentsInjectors() {
    }

    static void add(
            @NonNull final ComponentsInjector injector,
            @NonNull final Class<? extends ComponentsInjector> asClass
    ) {
        COMPONENTS_INJECTORS.put(asClass, injector);
    }

    @SuppressWarnings("unchecked")
    public static <ComponentsInjectorT extends ComponentsInjector> ComponentsInjectorT injector(
            @NonNull final Class<ComponentsInjectorT> clazz
    ) {
        return (ComponentsInjectorT) COMPONENTS_INJECTORS.get(clazz);
    }
}