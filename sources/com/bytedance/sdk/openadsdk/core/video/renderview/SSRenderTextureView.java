package com.bytedance.sdk.openadsdk.core.video.renderview;

import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.SurfaceTexture;
import android.util.AttributeSet;
import android.view.SurfaceHolder;
import android.view.TextureView;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.RequiresApi;
import com.bytedance.sdk.openadsdk.core.video.renderview.b;
@RequiresApi(api = 14)
@TargetApi(14)
/* loaded from: classes.dex */
public class SSRenderTextureView extends TextureView implements TextureView.SurfaceTextureListener, b {
    private a a;
    private b.a b;

    public SSRenderTextureView(Context context) {
        this(context, null);
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.renderview.b
    public void a(a aVar) {
        this.a = aVar;
        setSurfaceTextureListener(this);
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.renderview.b
    public SurfaceHolder getHolder() {
        return null;
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.renderview.b
    public View getView() {
        return this;
    }

    @Override // android.view.TextureView, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
    }

    @Override // android.view.View
    protected void onDetachedFromWindow() {
        try {
            super.onDetachedFromWindow();
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    @Override // android.view.TextureView, android.view.View
    protected void onSizeChanged(int i2, int i3, int i4, int i5) {
        super.onSizeChanged(i2, i3, i4, i5);
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i2, int i3) {
        a aVar = this.a;
        if (aVar != null) {
            aVar.a(surfaceTexture, i2, i3);
        }
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
        a aVar = this.a;
        return aVar != null && aVar.a(surfaceTexture);
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture, int i2, int i3) {
        a aVar = this.a;
        if (aVar != null) {
            aVar.b(surfaceTexture, i2, i3);
        }
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public void onSurfaceTextureUpdated(SurfaceTexture surfaceTexture) {
        a aVar = this.a;
        if (aVar != null) {
            aVar.b(surfaceTexture);
        }
    }

    @Override // android.view.View
    protected void onWindowVisibilityChanged(int i2) {
        super.onWindowVisibilityChanged(i2);
        b.a aVar = this.b;
        if (aVar != null) {
            aVar.a(i2);
        }
    }

    public void setWindowVisibilityChangedListener(b.a aVar) {
        this.b = aVar;
    }

    public SSRenderTextureView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.renderview.b
    public void a(int i2, int i3) {
        ViewGroup.LayoutParams layoutParams = getLayoutParams();
        layoutParams.height = i3;
        layoutParams.width = i2;
        setLayoutParams(layoutParams);
    }
}
