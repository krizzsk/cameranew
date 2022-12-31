package com.google.firebase.analytics.ktx;

import com.google.firebase.components.Component;
import com.google.firebase.components.ComponentRegistrar;
import com.google.firebase.platforminfo.LibraryVersionComponent;
import java.util.List;
import kotlin.collections.t;
/* compiled from: com.google.firebase:firebase-analytics-ktx@@18.0.2 */
/* loaded from: classes2.dex */
public final class FirebaseAnalyticsKtxRegistrar implements ComponentRegistrar {
    @Override // com.google.firebase.components.ComponentRegistrar
    public final List<Component<?>> getComponents() {
        List<Component<?>> e2;
        e2 = t.e(LibraryVersionComponent.create(AnalyticsKt.LIBRARY_NAME, "18.0.2"));
        return e2;
    }
}
