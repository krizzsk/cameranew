package com.google.android.play.core.splitinstall;

import androidx.annotation.Nullable;
import java.util.concurrent.atomic.AtomicReference;
/* JADX WARN: $VALUES field not found */
/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* loaded from: classes2.dex */
public final class l implements w {
    public static final l a = new l();
    private static final AtomicReference<x> b = new AtomicReference<>(null);

    private l() {
    }

    @Override // com.google.android.play.core.splitinstall.w
    @Nullable
    public final x a() {
        return b.get();
    }

    public final void a(x xVar) {
        b.set(xVar);
    }
}
