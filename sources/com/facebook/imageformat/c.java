package com.facebook.imageformat;

import com.growingio.android.sdk.utils.NetworkUtil;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;
/* compiled from: ImageFormat.java */
/* loaded from: classes.dex */
public class c {
    public static final c b = new c(NetworkUtil.NETWORK_UNKNOWN, null);
    private final String a;

    /* compiled from: ImageFormat.java */
    /* loaded from: classes.dex */
    public interface a {
        @Nullable
        c a(@Nonnull byte[] bArr, int i2);

        int b();
    }

    public c(String str, @Nullable String str2) {
        this.a = str;
    }

    public String a() {
        return this.a;
    }

    public String toString() {
        return a();
    }
}
