package com.google.firebase.messaging.ktx;

import com.google.firebase.components.Component;
import com.google.firebase.components.ComponentRegistrar;
import com.google.firebase.platforminfo.LibraryVersionComponent;
import java.util.List;
import kotlin.collections.t;
/* compiled from: Messaging.kt */
/* loaded from: classes2.dex */
public final class FirebaseMessagingKtxRegistrar implements ComponentRegistrar {
    @Override // com.google.firebase.components.ComponentRegistrar
    public List<Component<?>> getComponents() {
        List<Component<?>> e2;
        e2 = t.e(LibraryVersionComponent.create(MessagingKt.LIBRARY_NAME, "21.0.1"));
        return e2;
    }
}
