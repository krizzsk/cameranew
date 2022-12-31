package com.facebook.imagepipeline.image;

import java.io.Closeable;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import javax.annotation.Nullable;
/* compiled from: CloseableImage.java */
/* loaded from: classes.dex */
public abstract class c implements Closeable, g {
    private static final Set<String> b = new HashSet(Arrays.asList("encoded_size", "encoded_width", "encoded_height", "uri_source", "image_format", "bitmap_config", "is_rounded"));
    private Map<String, Object> a = new HashMap();

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public abstract void close();

    public i d() {
        return h.f2818d;
    }

    protected void finalize() throws Throwable {
        if (isClosed()) {
            return;
        }
        com.facebook.common.logging.a.z("CloseableImage", "finalize: %s %x still open.", getClass().getSimpleName(), Integer.valueOf(System.identityHashCode(this)));
        try {
            close();
        } finally {
            super.finalize();
        }
    }

    @Override // com.facebook.imagepipeline.image.f
    public Map<String, Object> getExtras() {
        return this.a;
    }

    public abstract boolean isClosed();

    public abstract int t();

    public boolean v() {
        return false;
    }

    public void w(String str, Object obj) {
        if (b.contains(str)) {
            this.a.put(str, obj);
        }
    }

    public void x(@Nullable Map<String, Object> map) {
        if (map == null) {
            return;
        }
        for (String str : b) {
            Object obj = map.get(str);
            if (obj != null) {
                this.a.put(str, obj);
            }
        }
    }
}
