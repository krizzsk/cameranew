package com.bytedance.sdk.openadsdk.core.video.renderview;

import android.view.SurfaceHolder;
import android.view.View;
/* compiled from: IRenderView.java */
/* loaded from: classes.dex */
public interface b {

    /* compiled from: IRenderView.java */
    /* loaded from: classes.dex */
    public interface a {
        void a(int i2);
    }

    void a(int i2, int i3);

    void a(com.bytedance.sdk.openadsdk.core.video.renderview.a aVar);

    SurfaceHolder getHolder();

    View getView();

    void setVisibility(int i2);
}
