package us.pinguo.inspire_proxy.media;

import android.annotation.TargetApi;
import android.content.Context;
import android.os.Build;
import android.util.AttributeSet;
import android.util.Log;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.View;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.lang.ref.WeakReference;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import tv.danmaku.ijk.media.player.IMediaPlayer;
import tv.danmaku.ijk.media.player.ISurfaceTextureHolder;
import us.pinguo.inspire_proxy.media.g;
/* loaded from: classes4.dex */
public class SurfaceRenderView extends SurfaceView implements g {
    private i a;
    private b b;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes4.dex */
    public static final class a implements g.b {
        private SurfaceRenderView a;
        private SurfaceHolder b;

        public a(@NonNull SurfaceRenderView surfaceRenderView, @Nullable SurfaceHolder surfaceHolder) {
            this.a = surfaceRenderView;
            this.b = surfaceHolder;
        }

        @Override // us.pinguo.inspire_proxy.media.g.b
        @NonNull
        public g a() {
            return this.a;
        }

        @Override // us.pinguo.inspire_proxy.media.g.b
        public void b(IMediaPlayer iMediaPlayer) {
            if (iMediaPlayer != null) {
                if (Build.VERSION.SDK_INT >= 16 && (iMediaPlayer instanceof ISurfaceTextureHolder)) {
                    ((ISurfaceTextureHolder) iMediaPlayer).setSurfaceTexture(null);
                }
                iMediaPlayer.setDisplay(this.b);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes4.dex */
    public static final class b implements SurfaceHolder.Callback {
        private SurfaceHolder a;
        private boolean b;
        private int c;

        /* renamed from: d  reason: collision with root package name */
        private int f11499d;

        /* renamed from: e  reason: collision with root package name */
        private int f11500e;

        /* renamed from: f  reason: collision with root package name */
        private WeakReference<SurfaceRenderView> f11501f;

        /* renamed from: g  reason: collision with root package name */
        private Map<g.a, Object> f11502g = new ConcurrentHashMap();

        public b(@NonNull SurfaceRenderView surfaceRenderView) {
            this.f11501f = new WeakReference<>(surfaceRenderView);
        }

        public void a(@NonNull g.a aVar) {
            a aVar2;
            this.f11502g.put(aVar, aVar);
            if (this.a != null) {
                aVar2 = new a(this.f11501f.get(), this.a);
                aVar.b(aVar2, this.f11499d, this.f11500e);
            } else {
                aVar2 = null;
            }
            if (this.b) {
                if (aVar2 == null) {
                    aVar2 = new a(this.f11501f.get(), this.a);
                }
                aVar.c(aVar2, this.c, this.f11499d, this.f11500e);
            }
        }

        public void b(@NonNull g.a aVar) {
            this.f11502g.remove(aVar);
        }

        @Override // android.view.SurfaceHolder.Callback
        public void surfaceChanged(SurfaceHolder surfaceHolder, int i2, int i3, int i4) {
            this.a = surfaceHolder;
            this.b = true;
            this.c = i2;
            this.f11499d = i3;
            this.f11500e = i4;
            a aVar = new a(this.f11501f.get(), this.a);
            for (g.a aVar2 : this.f11502g.keySet()) {
                aVar2.c(aVar, i2, i3, i4);
            }
        }

        @Override // android.view.SurfaceHolder.Callback
        public void surfaceCreated(SurfaceHolder surfaceHolder) {
            this.a = surfaceHolder;
            this.b = false;
            this.c = 0;
            this.f11499d = 0;
            this.f11500e = 0;
            a aVar = new a(this.f11501f.get(), this.a);
            for (g.a aVar2 : this.f11502g.keySet()) {
                aVar2.b(aVar, 0, 0);
            }
        }

        @Override // android.view.SurfaceHolder.Callback
        public void surfaceDestroyed(SurfaceHolder surfaceHolder) {
            this.a = null;
            this.b = false;
            this.c = 0;
            this.f11499d = 0;
            this.f11500e = 0;
            a aVar = new a(this.f11501f.get(), this.a);
            for (g.a aVar2 : this.f11502g.keySet()) {
                aVar2.a(aVar);
            }
        }
    }

    public SurfaceRenderView(Context context) {
        super(context);
        d(context);
    }

    private void d(Context context) {
        this.a = new i(this);
        this.b = new b(this);
        getHolder().addCallback(this.b);
        getHolder().setType(0);
    }

    @Override // us.pinguo.inspire_proxy.media.g
    public void a(g.a aVar) {
        this.b.b(aVar);
    }

    @Override // us.pinguo.inspire_proxy.media.g
    public boolean b() {
        return true;
    }

    @Override // us.pinguo.inspire_proxy.media.g
    public void c(g.a aVar) {
        this.b.a(aVar);
    }

    @Override // us.pinguo.inspire_proxy.media.g
    public View getView() {
        return this;
    }

    @Override // android.view.View
    public void onInitializeAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        super.onInitializeAccessibilityEvent(accessibilityEvent);
        accessibilityEvent.setClassName(SurfaceRenderView.class.getName());
    }

    @Override // android.view.View
    @TargetApi(14)
    public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        if (Build.VERSION.SDK_INT >= 14) {
            accessibilityNodeInfo.setClassName(SurfaceRenderView.class.getName());
        }
    }

    @Override // android.view.SurfaceView, android.view.View
    protected void onMeasure(int i2, int i3) {
        this.a.a(i2, i3);
        setMeasuredDimension(this.a.c(), this.a.b());
    }

    @Override // us.pinguo.inspire_proxy.media.g
    public void setAspectRatio(int i2) {
        this.a.d(i2);
        requestLayout();
    }

    @Override // us.pinguo.inspire_proxy.media.g
    public void setVideoRotation(int i2) {
        Log.e("", "SurfaceView doesn't support rotation (" + i2 + ")!\n");
    }

    @Override // us.pinguo.inspire_proxy.media.g
    public void setVideoSampleAspectRatio(int i2, int i3) {
        if (i2 <= 0 || i3 <= 0) {
            return;
        }
        this.a.f(i2, i3);
        requestLayout();
    }

    @Override // us.pinguo.inspire_proxy.media.g
    public void setVideoSize(int i2, int i3) {
        if (i2 <= 0 || i3 <= 0) {
            return;
        }
        this.a.g(i2, i3);
        getHolder().setFixedSize(i2, i3);
        requestLayout();
    }

    public SurfaceRenderView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        d(context);
    }

    public SurfaceRenderView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        d(context);
    }
}
