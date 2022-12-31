package com.google.android.datatransport.runtime.backends;

import androidx.annotation.Nullable;
import com.google.android.datatransport.runtime.backends.a;
import com.google.auto.value.AutoValue;
/* compiled from: BackendRequest.java */
@AutoValue
/* loaded from: classes2.dex */
public abstract class f {

    /* compiled from: BackendRequest.java */
    @AutoValue.Builder
    /* loaded from: classes2.dex */
    public static abstract class a {
        public abstract f a();

        public abstract a b(Iterable<com.google.android.datatransport.runtime.h> iterable);

        public abstract a c(@Nullable byte[] bArr);
    }

    public static a a() {
        return new a.b();
    }

    public abstract Iterable<com.google.android.datatransport.runtime.h> b();

    @Nullable
    public abstract byte[] c();
}
