package com.bytedance.sdk.openadsdk.core.video.renderview;

import android.content.Context;
import android.view.SurfaceHolder;
import android.view.View;
import android.view.ViewGroup;
import com.bytedance.sdk.openadsdk.core.video.renderview.b;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes.dex */
public class SSRenderSurfaceView extends SSSurfaceView implements SurfaceHolder.Callback, b {
    private static final ArrayList<c> c = new ArrayList<>();
    private WeakReference<a> a;
    private c b;

    /* renamed from: d  reason: collision with root package name */
    private b.a f1849d;

    public SSRenderSurfaceView(Context context) {
        super(context);
        a();
    }

    private void a() {
        c cVar = new c(this);
        this.b = cVar;
        c.add(cVar);
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.renderview.b
    public View getView() {
        return this;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.bytedance.sdk.openadsdk.core.video.renderview.SSSurfaceView, android.view.SurfaceView, android.view.View
    public void onWindowVisibilityChanged(int i2) {
        super.onWindowVisibilityChanged(i2);
        b.a aVar = this.f1849d;
        if (aVar != null) {
            aVar.a(i2);
        }
    }

    public void setWindowVisibilityChangedListener(b.a aVar) {
        this.f1849d = aVar;
    }

    @Override // android.view.SurfaceHolder.Callback
    public void surfaceChanged(SurfaceHolder surfaceHolder, int i2, int i3, int i4) {
        WeakReference<a> weakReference = this.a;
        if (weakReference == null || weakReference.get() == null) {
            return;
        }
        this.a.get().a(surfaceHolder, i2, i3, i4);
    }

    @Override // android.view.SurfaceHolder.Callback
    public void surfaceCreated(SurfaceHolder surfaceHolder) {
        WeakReference<a> weakReference = this.a;
        if (weakReference == null || weakReference.get() == null) {
            return;
        }
        this.a.get().a(surfaceHolder);
    }

    @Override // android.view.SurfaceHolder.Callback
    public void surfaceDestroyed(SurfaceHolder surfaceHolder) {
        WeakReference<a> weakReference = this.a;
        if (weakReference == null || weakReference.get() == null) {
            return;
        }
        this.a.get().b(surfaceHolder);
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.renderview.b
    public void a(a aVar) {
        this.a = new WeakReference<>(aVar);
        SurfaceHolder holder = getHolder();
        holder.setFormat(-3);
        Iterator<c> it = c.iterator();
        while (it.hasNext()) {
            c next = it.next();
            if (next.a() == null) {
                holder.removeCallback(next);
                it.remove();
            }
        }
        holder.addCallback(this.b);
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.renderview.b
    public void a(int i2, int i3) {
        ViewGroup.LayoutParams layoutParams = getLayoutParams();
        layoutParams.height = i3;
        layoutParams.width = i2;
        setLayoutParams(layoutParams);
    }
}
