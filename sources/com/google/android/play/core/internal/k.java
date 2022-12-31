package com.google.android.play.core.internal;

import androidx.annotation.Nullable;
/* loaded from: classes2.dex */
public abstract class k implements Runnable {
    @Nullable
    private final com.google.android.play.core.tasks.p<?> a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public k() {
        this.a = null;
    }

    public k(@Nullable com.google.android.play.core.tasks.p<?> pVar) {
        this.a = pVar;
    }

    protected abstract void a();

    /* JADX INFO: Access modifiers changed from: package-private */
    @Nullable
    public final com.google.android.play.core.tasks.p<?> b() {
        return this.a;
    }

    @Override // java.lang.Runnable
    public final void run() {
        try {
            a();
        } catch (Exception e2) {
            com.google.android.play.core.tasks.p<?> pVar = this.a;
            if (pVar != null) {
                pVar.d(e2);
            }
        }
    }
}
