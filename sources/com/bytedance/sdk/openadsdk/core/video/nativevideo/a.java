package com.bytedance.sdk.openadsdk.core.video.nativevideo;

import android.graphics.SurfaceTexture;
import android.view.SurfaceHolder;
import android.view.View;
/* compiled from: IMediaCallback.java */
/* loaded from: classes.dex */
public interface a {
    void a(b bVar, int i2);

    void a(b bVar, int i2, boolean z);

    void a(b bVar, SurfaceTexture surfaceTexture);

    void a(b bVar, SurfaceHolder surfaceHolder);

    void a(b bVar, SurfaceHolder surfaceHolder, int i2, int i3, int i4);

    void a(b bVar, View view);

    void a(b bVar, View view, boolean z, boolean z2);

    void b(b bVar, int i2);

    void b(b bVar, SurfaceTexture surfaceTexture);

    void b(b bVar, SurfaceHolder surfaceHolder);

    void b(b bVar, View view);

    void c(b bVar, View view);

    void d(b bVar, View view);

    void e(b bVar, View view);

    void f(b bVar, View view);

    void g();
}
