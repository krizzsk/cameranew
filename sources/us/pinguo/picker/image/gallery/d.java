package us.pinguo.picker.image.gallery;

import android.app.Application;
import android.net.Uri;
import java.util.concurrent.atomic.AtomicBoolean;
/* compiled from: ChangeNotifier.java */
/* loaded from: classes5.dex */
public class d {
    private o a;
    private AtomicBoolean b;
    private Uri c;

    /* renamed from: d  reason: collision with root package name */
    private boolean f11695d;

    public d(o oVar, Uri uri, Application application) {
        this(oVar, uri, application, false);
    }

    public boolean a() {
        return this.b.compareAndSet(true, false);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean b(Uri uri) {
        Uri uri2;
        if (!this.f11695d || uri == null || (uri2 = this.c) == null) {
            return true;
        }
        return uri2.getPath() != null && this.c.getPath().equals(uri.getPath());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void c(boolean z) {
        if (this.b.compareAndSet(false, true)) {
            this.a.m();
        }
    }

    public d(o oVar, Uri uri, Application application, boolean z) {
        this.b = new AtomicBoolean(true);
        this.a = oVar;
        this.c = uri;
        this.f11695d = z;
        f.b(application).e(uri, this);
    }
}
