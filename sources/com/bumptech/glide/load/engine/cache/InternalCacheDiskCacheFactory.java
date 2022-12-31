package com.bumptech.glide.load.engine.cache;

import android.content.Context;
import com.bumptech.glide.load.engine.cache.d;
import java.io.File;
/* loaded from: classes.dex */
public final class InternalCacheDiskCacheFactory extends d {

    /* loaded from: classes.dex */
    class a implements d.a {
        final /* synthetic */ Context a;
        final /* synthetic */ String b;

        a(Context context, String str) {
            this.a = context;
            this.b = str;
        }

        @Override // com.bumptech.glide.load.engine.cache.d.a
        public File a() {
            File cacheDir = this.a.getCacheDir();
            if (cacheDir == null) {
                return null;
            }
            return this.b != null ? new File(cacheDir, this.b) : cacheDir;
        }
    }

    public InternalCacheDiskCacheFactory(Context context) {
        this(context, "image_manager_disk_cache", 262144000);
    }

    public InternalCacheDiskCacheFactory(Context context, String str, int i2) {
        super(new a(context, str), i2);
    }
}
