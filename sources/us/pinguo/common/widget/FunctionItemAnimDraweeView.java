package us.pinguo.common.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.Outline;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.Shader;
import android.graphics.drawable.Animatable;
import android.net.Uri;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewOutlineProvider;
import java.io.File;
import java.util.LinkedHashMap;
import kotlin.jvm.internal.s;
/* compiled from: FunctionItemAnimDraweeView.kt */
/* loaded from: classes4.dex */
public final class FunctionItemAnimDraweeView extends RatioWebpAnimImageView {

    /* renamed from: j  reason: collision with root package name */
    private Animatable f9959j;

    /* renamed from: k  reason: collision with root package name */
    private float f9960k;

    /* renamed from: l  reason: collision with root package name */
    private Canvas f9961l;
    private Bitmap m;
    private final Paint n;
    private boolean o;

    /* compiled from: FunctionItemAnimDraweeView.kt */
    /* loaded from: classes4.dex */
    public static final class a extends ViewOutlineProvider {
        a() {
        }

        @Override // android.view.ViewOutlineProvider
        public void getOutline(View view, Outline outline) {
            if (outline == null) {
                return;
            }
            s.e(view);
            outline.setRoundRect(0, 0, view.getWidth(), view.getHeight(), FunctionItemAnimDraweeView.this.f9960k);
        }
    }

    /* compiled from: FunctionItemAnimDraweeView.kt */
    /* loaded from: classes4.dex */
    public static final class b extends com.facebook.drawee.controller.b<com.facebook.imagepipeline.image.g> {
        final /* synthetic */ int c;

        b(int i2) {
            this.c = i2;
        }

        @Override // com.facebook.drawee.controller.b, com.facebook.drawee.controller.c
        /* renamed from: h */
        public void d(String str, com.facebook.imagepipeline.image.g gVar, Animatable animatable) {
            if (animatable != null) {
                FunctionItemAnimDraweeView.this.o = true;
            }
            if (animatable == null || gVar == null) {
                return;
            }
            try {
                FunctionItemAnimDraweeView.this.setMAnimTable(animatable);
                ((com.facebook.s.a.c.a) animatable).h(new h(((com.facebook.s.a.c.a) animatable).d(), this.c));
                ((com.facebook.s.a.c.a) animatable).start();
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FunctionItemAnimDraweeView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        s.h(context, "context");
        new LinkedHashMap();
        this.n = new Paint();
        l(context, attributeSet);
    }

    private final void l(Context context, AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, us.pinguo.commonui.R.styleable.CornerImageView);
        s.g(obtainStyledAttributes, "context.obtainStyledAttr…tyleable.CornerImageView)");
        this.f9960k = obtainStyledAttributes.getDimension(us.pinguo.commonui.R.styleable.CornerImageView_cornerRadius, 30.0f);
        obtainStyledAttributes.recycle();
    }

    private final void p() {
        if (this.f9961l != null) {
            us.pinguo.common.log.a.k("eraseColor start", new Object[0]);
            Bitmap bitmap = this.m;
            if (bitmap != null) {
                bitmap.eraseColor(0);
            }
            us.pinguo.common.log.a.k("eraseColor end", new Object[0]);
            return;
        }
        us.pinguo.common.log.a.k("createBitmap start", new Object[0]);
        this.m = Bitmap.createBitmap(getWidth(), getHeight(), Bitmap.Config.ARGB_8888);
        us.pinguo.common.log.a.k("createBitmap end", new Object[0]);
        Bitmap bitmap2 = this.m;
        s.e(bitmap2);
        this.f9961l = new Canvas(bitmap2);
        Paint paint = this.n;
        Bitmap bitmap3 = this.m;
        s.e(bitmap3);
        Shader.TileMode tileMode = Shader.TileMode.CLAMP;
        paint.setShader(new BitmapShader(bitmap3, tileMode, tileMode));
    }

    private final void setWebpAnimRes(Object obj, int i2) {
        b bVar = new b(i2);
        com.facebook.drawee.b.a d2 = d();
        Uri uri = null;
        Animatable e2 = d2 == null ? null : d2.e();
        if (e2 != null) {
            e2.stop();
        }
        if (obj instanceof String) {
            uri = com.facebook.common.util.d.d(new File((String) obj));
        } else if (obj instanceof Integer) {
            uri = com.facebook.common.util.d.e(((Number) obj).intValue());
        }
        com.facebook.drawee.backends.pipeline.e a2 = com.facebook.drawee.backends.pipeline.c.h().a(uri);
        a2.A(bVar);
        setController(a2.build());
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onDraw(Canvas canvas) {
        s.h(canvas, "canvas");
        if (this.o) {
            if (us.pinguo.util.c.f12472f) {
                if (s.c(getOutlineProvider(), ViewOutlineProvider.BACKGROUND)) {
                    setOutlineProvider(new a());
                    setClipToOutline(true);
                }
                super.onDraw(canvas);
                return;
            }
            p();
            super.onDraw(this.f9961l);
            RectF rectF = new RectF(getPaddingLeft(), getPaddingTop(), getWidth() - getPaddingRight(), getHeight() - getPaddingBottom());
            float f2 = this.f9960k;
            canvas.drawRoundRect(rectF, f2, f2, this.n);
            return;
        }
        if (!(this.f9960k == 0.0f)) {
            p();
            super.onDraw(this.f9961l);
            RectF rectF2 = new RectF(getPaddingLeft(), getPaddingTop(), getWidth() - getPaddingRight(), getHeight() - getPaddingBottom());
            float f3 = this.f9960k;
            canvas.drawRoundRect(rectF2, f3, f3, this.n);
            return;
        }
        super.onDraw(canvas);
    }

    public final void setImagePath(Object obj) {
        this.o = false;
        s.e(obj);
        setWebpAnimRes(obj, 0);
    }

    public final void setMAnimTable(Animatable animatable) {
        this.f9959j = animatable;
    }
}
