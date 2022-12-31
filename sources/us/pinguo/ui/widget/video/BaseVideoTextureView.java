package us.pinguo.ui.widget.video;

import android.content.Context;
import android.graphics.SurfaceTexture;
import android.util.AttributeSet;
import android.view.Surface;
import android.view.TextureView;
import android.view.View;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import com.growingio.android.sdk.autoburry.VdsAgent;
/* loaded from: classes6.dex */
public class BaseVideoTextureView extends TextureView implements TextureView.SurfaceTextureListener {
    private Surface a;
    private View b;
    private boolean c;

    /* renamed from: d  reason: collision with root package name */
    private TextureView.SurfaceTextureListener f12324d;

    /* renamed from: e  reason: collision with root package name */
    private a f12325e;

    /* renamed from: f  reason: collision with root package name */
    private View f12326f;

    /* renamed from: g  reason: collision with root package name */
    private View f12327g;

    /* renamed from: h  reason: collision with root package name */
    private int f12328h;

    /* loaded from: classes6.dex */
    public interface a {
        void e(BaseVideoTextureView baseVideoTextureView, Surface surface);
    }

    public BaseVideoTextureView(Context context) {
        super(context);
        this.f12328h = 0;
        c();
    }

    private void c() {
        super.setSurfaceTextureListener(this);
        setFocusable(true);
        setFocusableInTouchMode(true);
        requestFocus();
    }

    public void a(boolean z) {
        this.c = z;
    }

    public Surface b() {
        return this.a;
    }

    @Override // android.view.View
    public void onInitializeAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        super.onInitializeAccessibilityEvent(accessibilityEvent);
        accessibilityEvent.setClassName(BaseVideoTextureView.class.getName());
    }

    @Override // android.view.View
    public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        accessibilityNodeInfo.setClassName(BaseVideoTextureView.class.getName());
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i2, int i3) {
        this.a = new Surface(surfaceTexture);
        TextureView.SurfaceTextureListener surfaceTextureListener = this.f12324d;
        if (surfaceTextureListener != null) {
            surfaceTextureListener.onSurfaceTextureAvailable(surfaceTexture, i2, i3);
        }
        a aVar = this.f12325e;
        if (aVar != null) {
            aVar.e(this, this.a);
        }
        this.f12328h = 0;
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
        this.a.release();
        this.a = null;
        TextureView.SurfaceTextureListener surfaceTextureListener = this.f12324d;
        if (surfaceTextureListener != null) {
            return surfaceTextureListener.onSurfaceTextureDestroyed(surfaceTexture);
        }
        return false;
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture, int i2, int i3) {
        TextureView.SurfaceTextureListener surfaceTextureListener = this.f12324d;
        if (surfaceTextureListener != null) {
            surfaceTextureListener.onSurfaceTextureSizeChanged(surfaceTexture, i2, i3);
        }
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public void onSurfaceTextureUpdated(SurfaceTexture surfaceTexture) {
        if (this.c) {
            View view = this.b;
            if (view != null && view.getVisibility() == 0 && this.f12328h >= 2) {
                View view2 = this.b;
                view2.setVisibility(8);
                VdsAgent.onSetViewVisibility(view2, 8);
            }
            View view3 = this.f12326f;
            if (view3 != null && view3.getVisibility() == 0) {
                View view4 = this.f12326f;
                view4.setVisibility(8);
                VdsAgent.onSetViewVisibility(view4, 8);
            }
            View view5 = this.f12327g;
            if (view5 != null && view5.getVisibility() == 0) {
                View view6 = this.f12327g;
                view6.setVisibility(8);
                VdsAgent.onSetViewVisibility(view6, 8);
            }
        }
        TextureView.SurfaceTextureListener surfaceTextureListener = this.f12324d;
        if (surfaceTextureListener != null) {
            surfaceTextureListener.onSurfaceTextureUpdated(surfaceTexture);
        }
        this.f12328h++;
    }

    public void setCoverView(View view) {
        this.b = view;
    }

    public void setOnSurfaceReNewListener(a aVar) {
        this.f12325e = aVar;
    }

    public void setPlayView(View view) {
        this.f12327g = view;
    }

    public void setProgressView(View view) {
        this.f12326f = view;
    }

    @Override // android.view.TextureView
    public void setSurfaceTextureListener(TextureView.SurfaceTextureListener surfaceTextureListener) {
        this.f12324d = surfaceTextureListener;
    }

    public BaseVideoTextureView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
        c();
    }

    public BaseVideoTextureView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.f12328h = 0;
        c();
    }
}
