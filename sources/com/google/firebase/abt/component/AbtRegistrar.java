package com.google.firebase.abt.component;

import android.content.Context;
import androidx.annotation.Keep;
import com.google.firebase.abt.BuildConfig;
import com.google.firebase.analytics.connector.AnalyticsConnector;
import com.google.firebase.components.Component;
import com.google.firebase.components.ComponentContainer;
import com.google.firebase.components.ComponentFactory;
import com.google.firebase.components.ComponentRegistrar;
import com.google.firebase.components.Dependency;
import com.google.firebase.platforminfo.LibraryVersionComponent;
import java.util.Arrays;
import java.util.List;
@Keep
/* loaded from: classes2.dex */
public class AbtRegistrar implements ComponentRegistrar {
    public static /* synthetic */ AbtComponent lambda$getComponents$0(ComponentContainer componentContainer) {
        return new AbtComponent((Context) componentContainer.get(Context.class), (AnalyticsConnector) componentContainer.get(AnalyticsConnector.class));
    }

    @Override // com.google.firebase.components.ComponentRegistrar
    public List<Component<?>> getComponents() {
        ComponentFactory componentFactory;
        Component.Builder add = Component.builder(AbtComponent.class).add(Dependency.required(Context.class)).add(Dependency.optional(AnalyticsConnector.class));
        componentFactory = AbtRegistrar$$Lambda$1.instance;
        return Arrays.asList(add.factory(componentFactory).build(), LibraryVersionComponent.create("fire-abt", BuildConfig.VERSION_NAME));
    }
}
