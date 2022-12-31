package com.google.android.datatransport.cct.internal;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.datatransport.cct.internal.f;
import com.google.auto.value.AutoValue;
/* compiled from: LogEvent.java */
@AutoValue
/* loaded from: classes.dex */
public abstract class k {

    /* compiled from: LogEvent.java */
    @AutoValue.Builder
    /* loaded from: classes.dex */
    public static abstract class a {
        @NonNull
        public abstract k a();

        @NonNull
        public abstract a b(@Nullable Integer num);

        @NonNull
        public abstract a c(long j2);

        @NonNull
        public abstract a d(long j2);

        @NonNull
        public abstract a e(@Nullable NetworkConnectionInfo networkConnectionInfo);

        @NonNull
        abstract a f(@Nullable byte[] bArr);

        @NonNull
        abstract a g(@Nullable String str);

        @NonNull
        public abstract a h(long j2);
    }

    private static a a() {
        return new f.b();
    }

    @NonNull
    public static a i(@NonNull String str) {
        a a2 = a();
        a2.g(str);
        return a2;
    }

    @NonNull
    public static a j(@NonNull byte[] bArr) {
        a a2 = a();
        a2.f(bArr);
        return a2;
    }

    @Nullable
    public abstract Integer b();

    public abstract long c();

    public abstract long d();

    @Nullable
    public abstract NetworkConnectionInfo e();

    @Nullable
    public abstract byte[] f();

    @Nullable
    public abstract String g();

    public abstract long h();
}
