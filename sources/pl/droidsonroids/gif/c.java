package pl.droidsonroids.gif;

import android.content.ContentResolver;
import android.content.res.AssetFileDescriptor;
import android.content.res.AssetManager;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.Rect;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Build;
import android.os.SystemClock;
import android.widget.MediaController;
import androidx.annotation.DrawableRes;
import androidx.annotation.IntRange;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RawRes;
import java.io.File;
import java.io.IOException;
import java.util.Locale;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
/* compiled from: GifDrawable.java */
/* loaded from: classes3.dex */
public class c extends Drawable implements Animatable, MediaController.MediaPlayerControl {
    final ScheduledThreadPoolExecutor a;
    volatile boolean b;
    long c;

    /* renamed from: d  reason: collision with root package name */
    private final Rect f8978d;

    /* renamed from: e  reason: collision with root package name */
    protected final Paint f8979e;

    /* renamed from: f  reason: collision with root package name */
    final Bitmap f8980f;

    /* renamed from: g  reason: collision with root package name */
    final GifInfoHandle f8981g;

    /* renamed from: h  reason: collision with root package name */
    final ConcurrentLinkedQueue<pl.droidsonroids.gif.a> f8982h;

    /* renamed from: i  reason: collision with root package name */
    private ColorStateList f8983i;

    /* renamed from: j  reason: collision with root package name */
    private PorterDuffColorFilter f8984j;

    /* renamed from: k  reason: collision with root package name */
    private PorterDuff.Mode f8985k;

    /* renamed from: l  reason: collision with root package name */
    final boolean f8986l;
    final g m;
    private final k n;
    private final Rect o;
    ScheduledFuture<?> p;
    private int q;
    private int r;
    private pl.droidsonroids.gif.m.a s;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: GifDrawable.java */
    /* loaded from: classes3.dex */
    public class a extends l {
        a(c cVar) {
            super(cVar);
        }

        @Override // pl.droidsonroids.gif.l
        public void a() {
            if (c.this.f8981g.reset()) {
                c.this.start();
            }
        }
    }

    /* compiled from: GifDrawable.java */
    /* loaded from: classes3.dex */
    class b extends l {
        final /* synthetic */ int b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        b(c cVar, int i2) {
            super(cVar);
            this.b = i2;
        }

        @Override // pl.droidsonroids.gif.l
        public void a() {
            c cVar = c.this;
            cVar.f8981g.seekToTime(this.b, cVar.f8980f);
            this.a.m.sendEmptyMessageAtTime(-1, 0L);
        }
    }

    public c(@NonNull Resources resources, @DrawableRes @RawRes int i2) throws Resources.NotFoundException, IOException {
        this(resources.openRawResourceFd(i2));
        float a2 = e.a(resources, i2);
        this.r = (int) (this.f8981g.getHeight() * a2);
        this.q = (int) (this.f8981g.getWidth() * a2);
    }

    private void b() {
        ScheduledFuture<?> scheduledFuture = this.p;
        if (scheduledFuture != null) {
            scheduledFuture.cancel(false);
        }
        this.m.removeMessages(-1);
    }

    private void k() {
        this.b = false;
        this.m.removeMessages(-1);
        this.f8981g.recycle();
    }

    private PorterDuffColorFilter m(ColorStateList colorStateList, PorterDuff.Mode mode) {
        if (colorStateList == null || mode == null) {
            return null;
        }
        return new PorterDuffColorFilter(colorStateList.getColorForState(getState(), 0), mode);
    }

    public void a(@NonNull pl.droidsonroids.gif.a aVar) {
        this.f8982h.add(aVar);
    }

    public int c() {
        return this.f8981g.getCurrentFrameIndex();
    }

    @Override // android.widget.MediaController.MediaPlayerControl
    public boolean canPause() {
        return true;
    }

    @Override // android.widget.MediaController.MediaPlayerControl
    public boolean canSeekBackward() {
        return f() > 1;
    }

    @Override // android.widget.MediaController.MediaPlayerControl
    public boolean canSeekForward() {
        return f() > 1;
    }

    public int d() {
        int currentLoop = this.f8981g.getCurrentLoop();
        return (currentLoop == 0 || currentLoop < this.f8981g.getLoopCount()) ? currentLoop : currentLoop - 1;
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(@NonNull Canvas canvas) {
        boolean z;
        if (this.f8984j == null || this.f8979e.getColorFilter() != null) {
            z = false;
        } else {
            this.f8979e.setColorFilter(this.f8984j);
            z = true;
        }
        pl.droidsonroids.gif.m.a aVar = this.s;
        if (aVar == null) {
            canvas.drawBitmap(this.f8980f, this.o, this.f8978d, this.f8979e);
        } else {
            aVar.b(canvas, this.f8979e, this.f8980f);
        }
        if (z) {
            this.f8979e.setColorFilter(null);
        }
        if (this.f8986l && this.b) {
            long j2 = this.c;
            if (j2 != Long.MIN_VALUE) {
                long max = Math.max(0L, j2 - SystemClock.uptimeMillis());
                this.c = Long.MIN_VALUE;
                this.a.remove(this.n);
                this.p = this.a.schedule(this.n, max, TimeUnit.MILLISECONDS);
            }
        }
    }

    public int e() {
        return this.f8980f.getRowBytes() * this.f8980f.getHeight();
    }

    public int f() {
        return this.f8981g.getNumberOfFrames();
    }

    @NonNull
    public final Paint g() {
        return this.f8979e;
    }

    @Override // android.graphics.drawable.Drawable
    public int getAlpha() {
        return this.f8979e.getAlpha();
    }

    @Override // android.widget.MediaController.MediaPlayerControl
    public int getAudioSessionId() {
        return 0;
    }

    @Override // android.widget.MediaController.MediaPlayerControl
    public int getBufferPercentage() {
        return 100;
    }

    @Override // android.graphics.drawable.Drawable
    public ColorFilter getColorFilter() {
        return this.f8979e.getColorFilter();
    }

    @Override // android.widget.MediaController.MediaPlayerControl
    public int getCurrentPosition() {
        return this.f8981g.getCurrentPosition();
    }

    @Override // android.widget.MediaController.MediaPlayerControl
    public int getDuration() {
        return this.f8981g.getDuration();
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicHeight() {
        return this.r;
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicWidth() {
        return this.q;
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return (!this.f8981g.isOpaque() || this.f8979e.getAlpha() < 255) ? -2 : -1;
    }

    public boolean h() {
        return this.f8981g.isRecycled();
    }

    public void i() {
        this.a.execute(new a(this));
    }

    @Override // android.widget.MediaController.MediaPlayerControl
    public boolean isPlaying() {
        return this.b;
    }

    @Override // android.graphics.drawable.Animatable
    public boolean isRunning() {
        return this.b;
    }

    @Override // android.graphics.drawable.Drawable
    public boolean isStateful() {
        ColorStateList colorStateList;
        return super.isStateful() || ((colorStateList = this.f8983i) != null && colorStateList.isStateful());
    }

    public void j(@IntRange(from = 0, to = 65535) int i2) {
        this.f8981g.setLoopCount(i2);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void l(long j2) {
        if (this.f8986l) {
            this.c = 0L;
            this.m.sendEmptyMessageAtTime(-1, 0L);
            return;
        }
        b();
        this.p = this.a.schedule(this.n, Math.max(j2, 0L), TimeUnit.MILLISECONDS);
    }

    @Override // android.graphics.drawable.Drawable
    protected void onBoundsChange(Rect rect) {
        this.f8978d.set(rect);
        pl.droidsonroids.gif.m.a aVar = this.s;
        if (aVar != null) {
            aVar.a(rect);
        }
    }

    @Override // android.graphics.drawable.Drawable
    protected boolean onStateChange(int[] iArr) {
        PorterDuff.Mode mode;
        ColorStateList colorStateList = this.f8983i;
        if (colorStateList == null || (mode = this.f8985k) == null) {
            return false;
        }
        this.f8984j = m(colorStateList, mode);
        return true;
    }

    @Override // android.widget.MediaController.MediaPlayerControl
    public void pause() {
        stop();
    }

    @Override // android.widget.MediaController.MediaPlayerControl
    public void seekTo(@IntRange(from = 0, to = 2147483647L) int i2) {
        if (i2 >= 0) {
            this.a.execute(new b(this, i2));
            return;
        }
        throw new IllegalArgumentException("Position is not positive");
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(@IntRange(from = 0, to = 255) int i2) {
        this.f8979e.setAlpha(i2);
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(@Nullable ColorFilter colorFilter) {
        this.f8979e.setColorFilter(colorFilter);
    }

    @Override // android.graphics.drawable.Drawable
    @Deprecated
    public void setDither(boolean z) {
        this.f8979e.setDither(z);
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public void setFilterBitmap(boolean z) {
        this.f8979e.setFilterBitmap(z);
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public void setTintList(ColorStateList colorStateList) {
        this.f8983i = colorStateList;
        this.f8984j = m(colorStateList, this.f8985k);
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public void setTintMode(@NonNull PorterDuff.Mode mode) {
        this.f8985k = mode;
        this.f8984j = m(this.f8983i, mode);
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public boolean setVisible(boolean z, boolean z2) {
        boolean visible = super.setVisible(z, z2);
        if (!this.f8986l) {
            if (z) {
                if (z2) {
                    i();
                }
                if (visible) {
                    start();
                }
            } else if (visible) {
                stop();
            }
        }
        return visible;
    }

    @Override // android.graphics.drawable.Animatable, android.widget.MediaController.MediaPlayerControl
    public void start() {
        synchronized (this) {
            if (this.b) {
                return;
            }
            this.b = true;
            l(this.f8981g.restoreRemainder());
        }
    }

    @Override // android.graphics.drawable.Animatable
    public void stop() {
        synchronized (this) {
            if (this.b) {
                this.b = false;
                b();
                this.f8981g.saveRemainder();
            }
        }
    }

    public String toString() {
        return String.format(Locale.ENGLISH, "GIF: size: %dx%d, frames: %d, error: %d", Integer.valueOf(this.f8981g.getWidth()), Integer.valueOf(this.f8981g.getHeight()), Integer.valueOf(this.f8981g.getNumberOfFrames()), Integer.valueOf(this.f8981g.getNativeErrorCode()));
    }

    public c(@NonNull AssetManager assetManager, @NonNull String str) throws IOException {
        this(assetManager.openFd(str));
    }

    public c(@NonNull String str) throws IOException {
        this(new GifInfoHandle(str), null, null, true);
    }

    public c(@NonNull File file) throws IOException {
        this(file.getPath());
    }

    public c(@NonNull AssetFileDescriptor assetFileDescriptor) throws IOException {
        this(new GifInfoHandle(assetFileDescriptor), null, null, true);
    }

    public c(@Nullable ContentResolver contentResolver, @NonNull Uri uri) throws IOException {
        this(GifInfoHandle.openUri(contentResolver, uri), null, null, true);
    }

    c(GifInfoHandle gifInfoHandle, c cVar, ScheduledThreadPoolExecutor scheduledThreadPoolExecutor, boolean z) {
        this.b = true;
        this.c = Long.MIN_VALUE;
        this.f8978d = new Rect();
        this.f8979e = new Paint(6);
        this.f8982h = new ConcurrentLinkedQueue<>();
        k kVar = new k(this);
        this.n = kVar;
        this.f8986l = z;
        this.a = scheduledThreadPoolExecutor == null ? d.a() : scheduledThreadPoolExecutor;
        this.f8981g = gifInfoHandle;
        Bitmap bitmap = null;
        if (cVar != null) {
            synchronized (cVar.f8981g) {
                if (!cVar.f8981g.isRecycled() && cVar.f8981g.getHeight() >= gifInfoHandle.getHeight() && cVar.f8981g.getWidth() >= gifInfoHandle.getWidth()) {
                    cVar.k();
                    Bitmap bitmap2 = cVar.f8980f;
                    bitmap2.eraseColor(0);
                    bitmap = bitmap2;
                }
            }
        }
        if (bitmap == null) {
            this.f8980f = Bitmap.createBitmap(gifInfoHandle.getWidth(), gifInfoHandle.getHeight(), Bitmap.Config.ARGB_8888);
        } else {
            this.f8980f = bitmap;
        }
        if (Build.VERSION.SDK_INT >= 12) {
            this.f8980f.setHasAlpha(!gifInfoHandle.isOpaque());
        }
        this.o = new Rect(0, 0, gifInfoHandle.getWidth(), gifInfoHandle.getHeight());
        this.m = new g(this);
        kVar.a();
        this.q = gifInfoHandle.getWidth();
        this.r = gifInfoHandle.getHeight();
    }
}
