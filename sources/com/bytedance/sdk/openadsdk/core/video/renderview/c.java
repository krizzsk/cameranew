package com.bytedance.sdk.openadsdk.core.video.renderview;

import android.view.SurfaceHolder;
import java.lang.ref.WeakReference;
/* compiled from: WeakSurfaceCallback.java */
/* loaded from: classes.dex */
public class c implements SurfaceHolder.Callback {
    private final WeakReference<SurfaceHolder.Callback> a;

    public c(SurfaceHolder.Callback callback) {
        this.a = new WeakReference<>(callback);
    }

    public SurfaceHolder.Callback a() {
        return this.a.get();
    }

    @Override // android.view.SurfaceHolder.Callback
    public void surfaceChanged(SurfaceHolder surfaceHolder, int i2, int i3, int i4) {
        SurfaceHolder.Callback callback = this.a.get();
        if (callback != null) {
            callback.surfaceChanged(surfaceHolder, i2, i3, i4);
        }
    }

    @Override // android.view.SurfaceHolder.Callback
    public void surfaceCreated(SurfaceHolder surfaceHolder) {
        SurfaceHolder.Callback callback = this.a.get();
        if (callback != null) {
            callback.surfaceCreated(surfaceHolder);
        }
    }

    @Override // android.view.SurfaceHolder.Callback
    public void surfaceDestroyed(SurfaceHolder surfaceHolder) {
        SurfaceHolder.Callback callback = this.a.get();
        if (callback != null) {
            callback.surfaceDestroyed(surfaceHolder);
        }
    }
}
