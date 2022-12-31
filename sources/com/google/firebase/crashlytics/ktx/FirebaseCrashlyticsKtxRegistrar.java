package com.google.firebase.crashlytics.ktx;

import androidx.annotation.Keep;
import com.google.firebase.components.Component;
import com.google.firebase.components.ComponentRegistrar;
import com.google.firebase.platforminfo.LibraryVersionComponent;
import java.util.List;
import kotlin.collections.t;
/* compiled from: FirebaseCrashlytics.kt */
@Keep
/* loaded from: classes2.dex */
public final class FirebaseCrashlyticsKtxRegistrar implements ComponentRegistrar {
    @Override // com.google.firebase.components.ComponentRegistrar
    public List<Component<?>> getComponents() {
        List<Component<?>> e2;
        e2 = t.e(LibraryVersionComponent.create(FirebaseCrashlyticsKt.LIBRARY_NAME, "17.4.0"));
        return e2;
    }
}
