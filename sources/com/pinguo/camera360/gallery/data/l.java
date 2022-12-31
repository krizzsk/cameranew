package com.pinguo.camera360.gallery.data;

import android.app.Application;
import android.net.Uri;
import java.util.concurrent.atomic.AtomicBoolean;
/* compiled from: ChangeNotifier.java */
/* loaded from: classes3.dex */
public class l {
    private y a;
    private AtomicBoolean b;
    private Uri c;

    /* renamed from: d  reason: collision with root package name */
    private boolean f6370d;

    public l(y yVar, Uri uri, Application application) {
        this(yVar, uri, application, false);
    }

    public boolean a() {
        return this.b.compareAndSet(true, false);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean b(Uri uri) {
        Uri uri2;
        if (!this.f6370d || uri == null || (uri2 = this.c) == null) {
            return true;
        }
        return uri2.getPath() != null && this.c.getPath().equals(uri.getPath());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void c(boolean z) {
        if (this.b.compareAndSet(false, true)) {
            this.a.w();
        }
    }

    public l(y yVar, Uri uri, Application application, boolean z) {
        this.b = new AtomicBoolean(true);
        this.a = yVar;
        this.c = uri;
        this.f6370d = z;
        o.c(application).f(uri, this);
    }
}
