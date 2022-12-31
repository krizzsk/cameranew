package us.pinguo.inspire_proxy.media;

import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.SurfaceTexture;
import android.os.Build;
import android.util.AttributeSet;
import android.util.Log;
import android.view.Surface;
import android.view.TextureView;
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
import tv.danmaku.ijk.media.player.ISurfaceTextureHost;
import us.pinguo.inspire_proxy.media.g;
@TargetApi(14)
/* loaded from: classes4.dex */
public class TextureRenderView extends TextureView implements g {
    private i a;
    private b b;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes4.dex */
    public static final class a implements g.b {
        private TextureRenderView a;
        private SurfaceTexture b;
        private ISurfaceTextureHost c;

        public a(@NonNull TextureRenderView textureRenderView, @Nullable SurfaceTexture surfaceTexture, @NonNull ISurfaceTextureHost iSurfaceTextureHost) {
            this.a = textureRenderView;
            this.b = surfaceTexture;
            this.c = iSurfaceTextureHost;
        }

        @Override // us.pinguo.inspire_proxy.media.g.b
        @NonNull
        public g a() {
            return this.a;
        }

        @Override // us.pinguo.inspire_proxy.media.g.b
        @TargetApi(16)
        public void b(IMediaPlayer iMediaPlayer) {
            if (iMediaPlayer == null) {
                return;
            }
            if (Build.VERSION.SDK_INT >= 16 && (iMediaPlayer instanceof ISurfaceTextureHolder)) {
                ISurfaceTextureHolder iSurfaceTextureHolder = (ISurfaceTextureHolder) iMediaPlayer;
                this.a.b.e(false);
                SurfaceTexture surfaceTexture = iSurfaceTextureHolder.getSurfaceTexture();
                if (surfaceTexture != null) {
                    this.a.setSurfaceTexture(surfaceTexture);
                    return;
                }
                iSurfaceTextureHolder.setSurfaceTexture(this.b);
                iSurfaceTextureHolder.setSurfaceTextureHost(this.a.b);
                return;
            }
            iMediaPlayer.setSurface(c());
        }

        @Nullable
        public Surface c() {
            if (this.b == null) {
                return null;
            }
            return new Surface(this.b);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes4.dex */
    public static final class b implements TextureView.SurfaceTextureListener, ISurfaceTextureHost {
        private SurfaceTexture a;
        private boolean b;
        private int c;

        /* renamed from: d  reason: collision with root package name */
        private int f11503d;

        /* renamed from: h  reason: collision with root package name */
        private WeakReference<TextureRenderView> f11507h;

        /* renamed from: e  reason: collision with root package name */
        private boolean f11504e = true;

        /* renamed from: f  reason: collision with root package name */
        private boolean f11505f = false;

        /* renamed from: g  reason: collision with root package name */
        private boolean f11506g = false;

        /* renamed from: i  reason: collision with root package name */
        private Map<g.a, Object> f11508i = new ConcurrentHashMap();

        public b(@NonNull TextureRenderView textureRenderView) {
            this.f11507h = new WeakReference<>(textureRenderView);
        }

        public void b(@NonNull g.a aVar) {
            a aVar2;
            this.f11508i.put(aVar, aVar);
            if (this.a != null) {
                aVar2 = new a(this.f11507h.get(), this.a, this);
                aVar.b(aVar2, this.c, this.f11503d);
            } else {
                aVar2 = null;
            }
            if (this.b) {
                if (aVar2 == null) {
                    aVar2 = new a(this.f11507h.get(), this.a, this);
                }
                aVar.c(aVar2, 0, this.c, this.f11503d);
            }
        }

        public void c() {
            Log.d("TextureRenderView", "didDetachFromWindow()");
            this.f11506g = true;
        }

        public void d(@NonNull g.a aVar) {
            this.f11508i.remove(aVar);
        }

        public void e(boolean z) {
            this.f11504e = z;
        }

        public void f() {
            Log.d("TextureRenderView", "willDetachFromWindow()");
            this.f11505f = true;
        }

        @Override // android.view.TextureView.SurfaceTextureListener
        public void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i2, int i3) {
            this.a = surfaceTexture;
            this.b = false;
            this.c = 0;
            this.f11503d = 0;
            a aVar = new a(this.f11507h.get(), surfaceTexture, this);
            for (g.a aVar2 : this.f11508i.keySet()) {
                aVar2.b(aVar, 0, 0);
            }
        }

        @Override // android.view.TextureView.SurfaceTextureListener
        public boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
            this.a = surfaceTexture;
            this.b = false;
            this.c = 0;
            this.f11503d = 0;
            a aVar = new a(this.f11507h.get(), surfaceTexture, this);
            for (g.a aVar2 : this.f11508i.keySet()) {
                aVar2.a(aVar);
            }
            Log.d("TextureRenderView", "onSurfaceTextureDestroyed: destroy: " + this.f11504e);
            return this.f11504e;
        }

        @Override // android.view.TextureView.SurfaceTextureListener
        public void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture, int i2, int i3) {
            this.a = surfaceTexture;
            this.b = true;
            this.c = i2;
            this.f11503d = i3;
            a aVar = new a(this.f11507h.get(), surfaceTexture, this);
            for (g.a aVar2 : this.f11508i.keySet()) {
                aVar2.c(aVar, 0, i2, i3);
            }
        }

        @Override // android.view.TextureView.SurfaceTextureListener
        public void onSurfaceTextureUpdated(SurfaceTexture surfaceTexture) {
        }

        @Override // tv.danmaku.ijk.media.player.ISurfaceTextureHost
        public void releaseSurfaceTexture(SurfaceTexture surfaceTexture) {
            if (surfaceTexture == null) {
                Log.d("TextureRenderView", "releaseSurfaceTexture: null");
            } else if (this.f11506g) {
                if (surfaceTexture != this.a) {
                    Log.d("TextureRenderView", "releaseSurfaceTexture: didDetachFromWindow(): release different SurfaceTexture");
                    surfaceTexture.release();
                } else if (!this.f11504e) {
                    Log.d("TextureRenderView", "releaseSurfaceTexture: didDetachFromWindow(): release detached SurfaceTexture");
                    surfaceTexture.release();
                } else {
                    Log.d("TextureRenderView", "releaseSurfaceTexture: didDetachFromWindow(): already released by TextureView");
                }
            } else if (this.f11505f) {
                if (surfaceTexture != this.a) {
                    Log.d("TextureRenderView", "releaseSurfaceTexture: willDetachFromWindow(): release different SurfaceTexture");
                    surfaceTexture.release();
                } else if (!this.f11504e) {
                    Log.d("TextureRenderView", "releaseSurfaceTexture: willDetachFromWindow(): re-attach SurfaceTexture to TextureView");
                    e(true);
                } else {
                    Log.d("TextureRenderView", "releaseSurfaceTexture: willDetachFromWindow(): will released by TextureView");
                }
            } else if (surfaceTexture != this.a) {
                Log.d("TextureRenderView", "releaseSurfaceTexture: alive: release different SurfaceTexture");
                surfaceTexture.release();
            } else if (!this.f11504e) {
                Log.d("TextureRenderView", "releaseSurfaceTexture: alive: re-attach SurfaceTexture to TextureView");
                e(true);
            } else {
                Log.d("TextureRenderView", "releaseSurfaceTexture: alive: will released by TextureView");
            }
        }
    }

    public TextureRenderView(Context context) {
        super(context);
        f(context);
    }

    private void f(Context context) {
        this.a = new i(this);
        b bVar = new b(this);
        this.b = bVar;
        setSurfaceTextureListener(bVar);
    }

    @Override // us.pinguo.inspire_proxy.media.g
    public void a(g.a aVar) {
        this.b.d(aVar);
    }

    @Override // us.pinguo.inspire_proxy.media.g
    public boolean b() {
        return false;
    }

    @Override // us.pinguo.inspire_proxy.media.g
    public void c(g.a aVar) {
        this.b.b(aVar);
    }

    public g.b e() {
        return new a(this, this.b.a, this.b);
    }

    @Override // us.pinguo.inspire_proxy.media.g
    public View getView() {
        return this;
    }

    @Override // android.view.View
    protected void onDetachedFromWindow() {
        this.b.f();
        super.onDetachedFromWindow();
        this.b.c();
    }

    @Override // android.view.View
    public void onInitializeAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        super.onInitializeAccessibilityEvent(accessibilityEvent);
        accessibilityEvent.setClassName(TextureRenderView.class.getName());
    }

    @Override // android.view.View
    public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        accessibilityNodeInfo.setClassName(TextureRenderView.class.getName());
    }

    @Override // android.view.View
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
        this.a.e(i2);
        setRotation(i2);
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
        requestLayout();
    }

    public TextureRenderView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        f(context);
    }

    public TextureRenderView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        f(context);
    }
}
