package com.pinguo.camera360.member;

import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.OnLifecycleEvent;
/* compiled from: NewPayWallLifecycleObserver.kt */
/* loaded from: classes3.dex */
public final class NewPayWallLifecycleObserver implements LifecycleObserver {
    @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
    public final void onDestroy() {
        u0 a = c1.a.a();
        if (a == null) {
            return;
        }
        a.a();
    }
}
