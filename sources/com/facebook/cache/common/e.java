package com.facebook.cache.common;

import android.net.Uri;
import com.facebook.common.internal.h;
import javax.annotation.Nullable;
/* compiled from: SimpleCacheKey.java */
/* loaded from: classes.dex */
public class e implements b {
    final String a;
    final boolean b;

    public e(String str) {
        this(str, false);
    }

    @Override // com.facebook.cache.common.b
    public String a() {
        return this.a;
    }

    @Override // com.facebook.cache.common.b
    public boolean b(Uri uri) {
        return this.a.contains(uri.toString());
    }

    @Override // com.facebook.cache.common.b
    public boolean c() {
        return this.b;
    }

    @Override // com.facebook.cache.common.b
    public boolean equals(@Nullable Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof e) {
            return this.a.equals(((e) obj).a);
        }
        return false;
    }

    @Override // com.facebook.cache.common.b
    public int hashCode() {
        return this.a.hashCode();
    }

    public String toString() {
        return this.a;
    }

    public e(String str, boolean z) {
        h.g(str);
        this.a = str;
        this.b = z;
    }
}
