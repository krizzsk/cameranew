package com.facebook.cache.common;

import android.net.Uri;
import java.util.List;
import javax.annotation.Nullable;
/* compiled from: MultiCacheKey.java */
/* loaded from: classes.dex */
public class d implements b {
    final List<b> a;

    @Override // com.facebook.cache.common.b
    public String a() {
        return this.a.get(0).a();
    }

    @Override // com.facebook.cache.common.b
    public boolean b(Uri uri) {
        for (int i2 = 0; i2 < this.a.size(); i2++) {
            if (this.a.get(i2).b(uri)) {
                return true;
            }
        }
        return false;
    }

    @Override // com.facebook.cache.common.b
    public boolean c() {
        return false;
    }

    public List<b> d() {
        return this.a;
    }

    @Override // com.facebook.cache.common.b
    public boolean equals(@Nullable Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof d) {
            return this.a.equals(((d) obj).a);
        }
        return false;
    }

    @Override // com.facebook.cache.common.b
    public int hashCode() {
        return this.a.hashCode();
    }

    public String toString() {
        return "MultiCacheKey:" + this.a.toString();
    }
}
