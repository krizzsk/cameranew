package us.pinguo.svideo.utils.gles;

import android.view.Surface;
/* compiled from: WindowSurface.java */
/* loaded from: classes6.dex */
public class e extends c {
    private Surface c;

    /* renamed from: d  reason: collision with root package name */
    private boolean f12082d;

    public e(a aVar, Surface surface, boolean z) {
        super(aVar);
        a(surface);
        this.c = surface;
        this.f12082d = z;
    }

    public void f() {
        d();
        Surface surface = this.c;
        if (surface != null) {
            if (this.f12082d) {
                surface.release();
            }
            this.c = null;
        }
    }
}
