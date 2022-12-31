package com.google.android.gms.tasks;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
/* compiled from: com.google.android.gms:play-services-tasks@@17.1.0 */
/* loaded from: classes2.dex */
public class h<TResult> {
    private final c0<TResult> a = new c0<>();

    @NonNull
    public g<TResult> a() {
        return this.a;
    }

    public void b(@NonNull Exception exc) {
        this.a.q(exc);
    }

    public void c(@Nullable TResult tresult) {
        this.a.r(tresult);
    }

    public boolean d(@NonNull Exception exc) {
        return this.a.u(exc);
    }

    public boolean e(@Nullable TResult tresult) {
        return this.a.v(tresult);
    }
}
