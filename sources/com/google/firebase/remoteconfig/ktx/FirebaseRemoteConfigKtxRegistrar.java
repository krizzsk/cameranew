package com.google.firebase.remoteconfig.ktx;

import androidx.annotation.Keep;
import com.google.firebase.components.Component;
import com.google.firebase.components.ComponentRegistrar;
import com.google.firebase.platforminfo.LibraryVersionComponent;
import java.util.List;
import kotlin.collections.t;
/* compiled from: RemoteConfig.kt */
@Keep
/* loaded from: classes2.dex */
public final class FirebaseRemoteConfigKtxRegistrar implements ComponentRegistrar {
    @Override // com.google.firebase.components.ComponentRegistrar
    public List<Component<?>> getComponents() {
        List<Component<?>> e2;
        e2 = t.e(LibraryVersionComponent.create(RemoteConfigKt.LIBRARY_NAME, "20.0.4"));
        return e2;
    }
}
