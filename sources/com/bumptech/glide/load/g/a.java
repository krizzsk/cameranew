package com.bumptech.glide.load.g;

import android.content.res.AssetManager;
import android.util.Log;
import com.bumptech.glide.Priority;
import java.io.IOException;
/* compiled from: AssetPathFetcher.java */
/* loaded from: classes.dex */
public abstract class a<T> implements c<T> {
    private final String a;
    private final AssetManager b;
    private T c;

    public a(AssetManager assetManager, String str) {
        this.b = assetManager;
        this.a = str;
    }

    @Override // com.bumptech.glide.load.g.c
    public void a() {
        T t = this.c;
        if (t == null) {
            return;
        }
        try {
            c(t);
        } catch (IOException e2) {
            if (Log.isLoggable("AssetUriFetcher", 2)) {
                Log.v("AssetUriFetcher", "Failed to close data", e2);
            }
        }
    }

    @Override // com.bumptech.glide.load.g.c
    public T b(Priority priority) throws Exception {
        T d2 = d(this.b, this.a);
        this.c = d2;
        return d2;
    }

    protected abstract void c(T t) throws IOException;

    @Override // com.bumptech.glide.load.g.c
    public void cancel() {
    }

    protected abstract T d(AssetManager assetManager, String str) throws IOException;

    @Override // com.bumptech.glide.load.g.c
    public String getId() {
        return this.a;
    }
}
