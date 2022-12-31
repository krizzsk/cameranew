package com.bumptech.glide.load.engine.cache;

import android.content.Context;
import com.bumptech.glide.load.engine.cache.d;
import java.io.File;
/* loaded from: classes.dex */
public final class ExternalCacheDiskCacheFactory extends d {

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
            File externalCacheDir = this.a.getExternalCacheDir();
            if (externalCacheDir == null) {
                return null;
            }
            return this.b != null ? new File(externalCacheDir, this.b) : externalCacheDir;
        }
    }

    public ExternalCacheDiskCacheFactory(Context context) {
        this(context, "image_manager_disk_cache", 262144000);
    }

    public ExternalCacheDiskCacheFactory(Context context, String str, int i2) {
        super(new a(context, str), i2);
    }
}
