package us.pinguo.inspire.widget.fresco;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;
import com.facebook.imagepipeline.image.g;
import com.nostra13.universalimageloader.core.ImageLoader;
import kotlin.f;
import kotlin.h;
import kotlin.jvm.internal.s;
import rx.Observable;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action1;
import rx.schedulers.Schedulers;
import us.pinguo.foundation.e;
/* compiled from: GaussianBlurDrawable.kt */
/* loaded from: classes9.dex */
public final class GaussianBlurDrawable extends Drawable implements com.facebook.drawee.controller.c<g> {

    /* renamed from: f  reason: collision with root package name */
    private static final int f11352f = us.pinguo.foundation.t.b.a.a(e.b(), 160.0f);

    /* renamed from: g  reason: collision with root package name */
    private static final int f11353g = 20;
    private String a = "";
    private final Paint b = new Paint();
    private Bitmap c;

    /* renamed from: d  reason: collision with root package name */
    private boolean f11354d;

    /* renamed from: e  reason: collision with root package name */
    private final f f11355e;

    public GaussianBlurDrawable() {
        f b;
        b = h.b(GaussianBlurDrawable$bgPaint$2.INSTANCE);
        this.f11355e = b;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void h(com.facebook.imagepipeline.image.a imageInfo, GaussianBlurDrawable this$0, Subscriber subscriber) {
        s.h(imageInfo, "$imageInfo");
        s.h(this$0, "this$0");
        com.facebook.imagepipeline.animated.base.b y = imageInfo.y();
        com.facebook.imagepipeline.animated.base.c i2 = y == null ? null : y.i(0);
        int width = imageInfo.getWidth();
        int height = imageInfo.getHeight();
        com.facebook.common.references.a<Bitmap> a = com.facebook.drawee.backends.pipeline.c.b().n().a(width, height);
        if (i2 != null) {
            i2.a(width, height, a.A());
        }
        long currentTimeMillis = System.currentTimeMillis();
        Bitmap a2 = new us.pinguo.ui.widget.GaussianBlur.stackblur.c(a.A(), f11352f).a(f11353g);
        long currentTimeMillis2 = System.currentTimeMillis();
        if (this$0.a != null) {
            d.f.a.a.b.a o = ImageLoader.getInstance().o();
            String str = this$0.a;
            s.e(str);
            o.put(str, a2);
        }
        us.pinguo.common.log.a.k("blur time:" + (currentTimeMillis2 - currentTimeMillis) + "ms", new Object[0]);
        subscriber.onNext(a2);
        subscriber.onCompleted();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void i(GaussianBlurDrawable this$0, Bitmap it) {
        s.h(this$0, "this$0");
        s.g(it, "it");
        this$0.o(it);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void j(Throwable th) {
        us.pinguo.common.log.a.f(th);
    }

    private final Paint k() {
        return (Paint) this.f11355e.getValue();
    }

    @Override // com.facebook.drawee.controller.c
    public void b(String str, Throwable th) {
    }

    @Override // com.facebook.drawee.controller.c
    public void c(String str) {
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        s.h(canvas, "canvas");
        if (this.f11354d) {
            if (this.c != null) {
                Bitmap bitmap = this.c;
                s.e(bitmap);
                int width = bitmap.getWidth();
                Bitmap bitmap2 = this.c;
                s.e(bitmap2);
                Rect rect = new Rect(0, 0, width, bitmap2.getHeight());
                float centerX = getBounds().centerX();
                float width2 = (rect.width() * (getBounds().height() / rect.height())) / 2;
                RectF rectF = new RectF(centerX - width2, getBounds().top, centerX + width2, getBounds().bottom);
                Bitmap bitmap3 = this.c;
                s.e(bitmap3);
                canvas.drawBitmap(bitmap3, rect, rectF, this.b);
                return;
            }
            canvas.drawRect(getBounds(), k());
        }
    }

    @Override // com.facebook.drawee.controller.c
    public void e(String str, Object obj) {
    }

    @Override // com.facebook.drawee.controller.c
    public void f(String str, Throwable th) {
    }

    public final void g(final com.facebook.imagepipeline.image.a imageInfo) {
        s.h(imageInfo, "imageInfo");
        Bitmap bitmap = ImageLoader.getInstance().o().get(this.a);
        if (bitmap != null && !bitmap.isRecycled()) {
            us.pinguo.common.log.a.k(s.q("get cached bitmap:", this.a), new Object[0]);
            o(bitmap);
            return;
        }
        Observable.create(new Observable.OnSubscribe() { // from class: us.pinguo.inspire.widget.fresco.c
            @Override // rx.functions.Action1
            public final void call(Object obj) {
                GaussianBlurDrawable.h(com.facebook.imagepipeline.image.a.this, this, (Subscriber) obj);
            }
        }).subscribeOn(Schedulers.computation()).observeOn(AndroidSchedulers.mainThread()).subscribe(new Action1() { // from class: us.pinguo.inspire.widget.fresco.a
            @Override // rx.functions.Action1
            public final void call(Object obj) {
                GaussianBlurDrawable.i(GaussianBlurDrawable.this, (Bitmap) obj);
            }
        }, b.a);
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return -1;
    }

    protected final void o(Bitmap bitmap) {
        s.h(bitmap, "bitmap");
        this.c = bitmap;
        invalidateSelf();
    }

    @Override // com.facebook.drawee.controller.c
    /* renamed from: p */
    public void d(String str, g gVar, Animatable animatable) {
        if (this.f11354d && (gVar instanceof com.facebook.imagepipeline.image.a)) {
            g((com.facebook.imagepipeline.image.a) gVar);
        }
    }

    @Override // com.facebook.drawee.controller.c
    /* renamed from: q */
    public void a(String str, g gVar) {
    }

    public final void r(boolean z) {
        this.f11354d = z;
    }

    public final void s(String str) {
        this.a = str;
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i2) {
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
        this.b.setColorFilter(colorFilter);
    }
}
