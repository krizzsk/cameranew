package com.facebook.s.a.b.d;

import android.net.Uri;
import javax.annotation.Nullable;
/* compiled from: AnimationFrameCacheKey.java */
/* loaded from: classes.dex */
public class a implements com.facebook.cache.common.b {
    private final String a;
    private final boolean b;

    public a(int i2, boolean z) {
        this.a = "anim://" + i2;
        this.b = z;
    }

    @Override // com.facebook.cache.common.b
    public String a() {
        return this.a;
    }

    @Override // com.facebook.cache.common.b
    public boolean b(Uri uri) {
        return uri.toString().startsWith(this.a);
    }

    @Override // com.facebook.cache.common.b
    public boolean c() {
        return false;
    }

    @Override // com.facebook.cache.common.b
    public boolean equals(@Nullable Object obj) {
        if (this.b) {
            if (this == obj) {
                return true;
            }
            if (obj == null || a.class != obj.getClass()) {
                return false;
            }
            return this.a.equals(((a) obj).a);
        }
        return super.equals(obj);
    }

    @Override // com.facebook.cache.common.b
    public int hashCode() {
        if (!this.b) {
            return super.hashCode();
        }
        return this.a.hashCode();
    }
}
