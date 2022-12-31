package com.bumptech.glide.load.g;

import android.content.ContentResolver;
import android.content.Context;
import android.net.Uri;
import android.util.Log;
import com.bumptech.glide.Priority;
import java.io.FileNotFoundException;
import java.io.IOException;
/* compiled from: LocalUriFetcher.java */
/* loaded from: classes.dex */
public abstract class g<T> implements c<T> {
    private final Uri a;
    private final Context b;
    private T c;

    public g(Context context, Uri uri) {
        this.b = context.getApplicationContext();
        this.a = uri;
    }

    @Override // com.bumptech.glide.load.g.c
    public void a() {
        T t = this.c;
        if (t != null) {
            try {
                c(t);
            } catch (IOException e2) {
                if (Log.isLoggable("LocalUriFetcher", 2)) {
                    Log.v("LocalUriFetcher", "failed to close data", e2);
                }
            }
        }
    }

    @Override // com.bumptech.glide.load.g.c
    public final T b(Priority priority) throws Exception {
        T d2 = d(this.a, this.b.getContentResolver());
        this.c = d2;
        return d2;
    }

    protected abstract void c(T t) throws IOException;

    @Override // com.bumptech.glide.load.g.c
    public void cancel() {
    }

    protected abstract T d(Uri uri, ContentResolver contentResolver) throws FileNotFoundException;

    @Override // com.bumptech.glide.load.g.c
    public String getId() {
        return this.a.toString();
    }
}
