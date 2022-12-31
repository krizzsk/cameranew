package us.pinguo.edit2020.view;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.NinePatch;
import android.graphics.Paint;
import android.graphics.Point;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import androidx.appcompat.content.res.AppCompatResources;
import java.util.LinkedHashMap;
import us.pinguo.edit2020.R;
/* compiled from: ImageCompareSliderView.kt */
/* loaded from: classes4.dex */
public final class ImageCompareSliderView extends View {
    private final Paint a;
    private final int b;
    private final int c;

    /* renamed from: d  reason: collision with root package name */
    private final Rect f10672d;

    /* renamed from: e  reason: collision with root package name */
    private final Rect f10673e;

    /* renamed from: f  reason: collision with root package name */
    private int f10674f;

    /* renamed from: g  reason: collision with root package name */
    private int f10675g;

    /* renamed from: h  reason: collision with root package name */
    private final Drawable f10676h;

    /* renamed from: i  reason: collision with root package name */
    private final Bitmap f10677i;

    /* renamed from: j  reason: collision with root package name */
    private final NinePatch f10678j;

    /* renamed from: k  reason: collision with root package name */
    private Point f10679k;

    /* renamed from: l  reason: collision with root package name */
    private Rect f10680l;
    private float m;
    private kotlin.jvm.b.l<? super Float, kotlin.u> n;
    private final a o;
    private final GestureDetector p;

    /* compiled from: ImageCompareSliderView.kt */
    /* loaded from: classes4.dex */
    public static final class a extends GestureDetector.SimpleOnGestureListener {
        a() {
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f2, float f3) {
            if (motionEvent == null) {
                return super.onScroll(motionEvent, motionEvent2, f2, f3);
            }
            if (motionEvent2 == null) {
                return super.onScroll(motionEvent, motionEvent2, f2, f3);
            }
            ImageCompareSliderView imageCompareSliderView = ImageCompareSliderView.this;
            imageCompareSliderView.setRate(((imageCompareSliderView.f10674f * ImageCompareSliderView.this.c()) - f2) / ImageCompareSliderView.this.f10674f);
            if (ImageCompareSliderView.this.c() <= 0.0625f) {
                ImageCompareSliderView.this.setRate(0.0625f);
            } else if (ImageCompareSliderView.this.c() > 0.9375f) {
                ImageCompareSliderView.this.setRate(0.9375f);
            }
            kotlin.jvm.b.l<Float, kotlin.u> b = ImageCompareSliderView.this.b();
            if (b != null) {
                b.invoke(Float.valueOf(ImageCompareSliderView.this.c()));
            }
            us.pinguo.common.log.a.c(kotlin.jvm.internal.s.q("rate:", Float.valueOf(ImageCompareSliderView.this.c())), new Object[0]);
            ImageCompareSliderView.this.invalidate();
            return super.onScroll(motionEvent, motionEvent2, f2, f3);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ImageCompareSliderView(Context context) {
        super(context);
        kotlin.jvm.internal.s.h(context, "context");
        new LinkedHashMap();
        Paint paint = new Paint(1);
        this.a = paint;
        this.b = us.pinguo.common.widget.i.a.a(32);
        this.c = us.pinguo.common.widget.i.a.a(2);
        this.f10672d = new Rect();
        this.f10673e = new Rect();
        this.f10676h = AppCompatResources.getDrawable(getContext(), R.drawable.btn_compare_slide);
        Bitmap decodeResource = BitmapFactory.decodeResource(getResources(), R.drawable.bg_img_compare_slider);
        this.f10677i = decodeResource;
        this.f10678j = new NinePatch(decodeResource, decodeResource.getNinePatchChunk(), null);
        this.f10680l = new Rect();
        this.m = 0.5f;
        paint.setStyle(Paint.Style.FILL);
        paint.setColor(-1);
        Context context2 = getContext();
        kotlin.jvm.internal.s.g(context2, "context");
        paint.setStrokeWidth(us.pinguo.util.g.b(context2, 2.0f));
        a aVar = new a();
        this.o = aVar;
        this.p = new GestureDetector(getContext(), aVar);
    }

    public final kotlin.jvm.b.l<Float, kotlin.u> b() {
        return this.n;
    }

    public final float c() {
        return this.m;
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        kotlin.jvm.internal.s.h(canvas, "canvas");
        this.f10674f = getWidth();
        int height = getHeight();
        this.f10675g = height;
        Rect rect = this.f10673e;
        int i2 = this.f10674f;
        float f2 = this.m;
        rect.set((int) (i2 * f2), 0, (int) ((i2 * f2) + this.c), height);
        this.f10672d.set((int) ((this.f10674f * this.m) - (this.b / 2)), this.f10675g - us.pinguo.common.widget.i.a.a(36), (int) ((this.f10674f * this.m) + (this.b / 2)), this.f10675g - us.pinguo.common.widget.i.a.a(12));
        this.f10678j.draw(canvas, this.f10673e);
        Drawable drawable = this.f10676h;
        if (drawable != null) {
            drawable.setBounds(this.f10672d);
        }
        Drawable drawable2 = this.f10676h;
        if (drawable2 == null) {
            return;
        }
        drawable2.draw(canvas);
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        Integer valueOf = motionEvent == null ? null : Integer.valueOf(motionEvent.getActionMasked());
        if (valueOf != null && valueOf.intValue() == 0) {
            Rect rect = this.f10680l;
            Rect rect2 = this.f10672d;
            int width = rect2.left - (rect2.width() / 2);
            Rect rect3 = this.f10672d;
            int height = rect3.top - (rect3.height() / 2);
            Rect rect4 = this.f10672d;
            int width2 = rect4.right + (rect4.width() / 2);
            Rect rect5 = this.f10672d;
            rect.set(width, height, width2, rect5.bottom + (rect5.height() / 2));
            this.f10679k = new Point((int) motionEvent.getX(), (int) motionEvent.getY());
        } else if (valueOf != null && valueOf.intValue() == 1) {
            this.f10679k = null;
        }
        Rect rect6 = this.f10680l;
        Point point = this.f10679k;
        if (rect6.contains(point == null ? 0 : point.x, point != null ? point.y : 0)) {
            this.p.onTouchEvent(motionEvent);
            return true;
        }
        return super.onTouchEvent(motionEvent);
    }

    public final void setOnCompareSlide(kotlin.jvm.b.l<? super Float, kotlin.u> lVar) {
        this.n = lVar;
    }

    public final void setRate(float f2) {
        if (f2 == this.m) {
            return;
        }
        this.m = f2;
        invalidate();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ImageCompareSliderView(Context context, AttributeSet attrs) {
        super(context, attrs);
        kotlin.jvm.internal.s.h(context, "context");
        kotlin.jvm.internal.s.h(attrs, "attrs");
        new LinkedHashMap();
        Paint paint = new Paint(1);
        this.a = paint;
        this.b = us.pinguo.common.widget.i.a.a(32);
        this.c = us.pinguo.common.widget.i.a.a(2);
        this.f10672d = new Rect();
        this.f10673e = new Rect();
        this.f10676h = AppCompatResources.getDrawable(getContext(), R.drawable.btn_compare_slide);
        Bitmap decodeResource = BitmapFactory.decodeResource(getResources(), R.drawable.bg_img_compare_slider);
        this.f10677i = decodeResource;
        this.f10678j = new NinePatch(decodeResource, decodeResource.getNinePatchChunk(), null);
        this.f10680l = new Rect();
        this.m = 0.5f;
        paint.setStyle(Paint.Style.FILL);
        paint.setColor(-1);
        Context context2 = getContext();
        kotlin.jvm.internal.s.g(context2, "context");
        paint.setStrokeWidth(us.pinguo.util.g.b(context2, 2.0f));
        a aVar = new a();
        this.o = aVar;
        this.p = new GestureDetector(getContext(), aVar);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ImageCompareSliderView(Context context, AttributeSet attrs, int i2) {
        super(context, attrs, i2);
        kotlin.jvm.internal.s.h(context, "context");
        kotlin.jvm.internal.s.h(attrs, "attrs");
        new LinkedHashMap();
        Paint paint = new Paint(1);
        this.a = paint;
        this.b = us.pinguo.common.widget.i.a.a(32);
        this.c = us.pinguo.common.widget.i.a.a(2);
        this.f10672d = new Rect();
        this.f10673e = new Rect();
        this.f10676h = AppCompatResources.getDrawable(getContext(), R.drawable.btn_compare_slide);
        Bitmap decodeResource = BitmapFactory.decodeResource(getResources(), R.drawable.bg_img_compare_slider);
        this.f10677i = decodeResource;
        this.f10678j = new NinePatch(decodeResource, decodeResource.getNinePatchChunk(), null);
        this.f10680l = new Rect();
        this.m = 0.5f;
        paint.setStyle(Paint.Style.FILL);
        paint.setColor(-1);
        Context context2 = getContext();
        kotlin.jvm.internal.s.g(context2, "context");
        paint.setStrokeWidth(us.pinguo.util.g.b(context2, 2.0f));
        a aVar = new a();
        this.o = aVar;
        this.p = new GestureDetector(getContext(), aVar);
    }
}
