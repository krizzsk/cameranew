package com.airbnb.lottie;

import androidx.annotation.Nullable;
import java.util.Arrays;
/* compiled from: LottieResult.java */
/* loaded from: classes.dex */
public final class m<V> {
    @Nullable
    private final V a;
    @Nullable
    private final Throwable b;

    public m(V v) {
        this.a = v;
        this.b = null;
    }

    @Nullable
    public Throwable a() {
        return this.b;
    }

    @Nullable
    public V b() {
        return this.a;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof m) {
            m mVar = (m) obj;
            if (b() == null || !b().equals(mVar.b())) {
                if (a() == null || mVar.a() == null) {
                    return false;
                }
                return a().toString().equals(a().toString());
            }
            return true;
        }
        return false;
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{b(), a()});
    }

    public m(Throwable th) {
        this.b = th;
        this.a = null;
    }
}
