package com.tapjoy.internal;

import java.lang.ref.WeakReference;
import javax.annotation.concurrent.ThreadSafe;
@ThreadSafe
/* loaded from: classes3.dex */
public final class by {
    public WeakReference a;

    public final Object a() {
        WeakReference weakReference = this.a;
        if (weakReference != null) {
            return weakReference.get();
        }
        return null;
    }

    public final void a(Object obj) {
        this.a = new WeakReference(obj);
    }
}
