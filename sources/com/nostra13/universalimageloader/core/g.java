package com.nostra13.universalimageloader.core;

import android.graphics.Bitmap;
import android.os.Handler;
import com.nostra13.universalimageloader.core.assist.LoadedFrom;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: ProcessAndDisplayImageTask.java */
/* loaded from: classes3.dex */
public final class g implements Runnable {
    private final d a;
    private final Bitmap b;
    private final f c;

    /* renamed from: d  reason: collision with root package name */
    private final Handler f5963d;

    public g(d dVar, Bitmap bitmap, f fVar, Handler handler) {
        this.a = dVar;
        this.b = bitmap;
        this.c = fVar;
        this.f5963d = handler;
    }

    @Override // java.lang.Runnable
    public void run() {
        d.f.a.b.d.a("PostProcess image before displaying [%s]", this.c.b);
        LoadAndDisplayImageTask.t(new b(this.c.f5959e.D().a(this.b), this.c, this.a, LoadedFrom.MEMORY_CACHE), this.c.f5959e.J(), this.f5963d, this.a);
    }
}
