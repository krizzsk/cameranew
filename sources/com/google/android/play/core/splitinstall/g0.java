package com.google.android.play.core.splitinstall;

import androidx.annotation.Nullable;
import java.util.concurrent.atomic.AtomicReference;
/* loaded from: classes2.dex */
public final class g0 {
    private static final AtomicReference<f0> a = new AtomicReference<>(null);

    /* JADX INFO: Access modifiers changed from: package-private */
    @Nullable
    public static f0 a() {
        return a.get();
    }

    public static void b(f0 f0Var) {
        a.compareAndSet(null, f0Var);
    }
}
