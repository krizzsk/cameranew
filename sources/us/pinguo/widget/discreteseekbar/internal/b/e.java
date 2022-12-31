package us.pinguo.widget.discreteseekbar.internal.b;

import android.content.res.ColorStateList;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Animatable;
import androidx.annotation.NonNull;
/* compiled from: ThumbDrawable.java */
/* loaded from: classes6.dex */
public class e extends c implements Animatable {

    /* renamed from: e  reason: collision with root package name */
    private final int f12573e;

    /* renamed from: f  reason: collision with root package name */
    private boolean f12574f;

    /* renamed from: g  reason: collision with root package name */
    private boolean f12575g;

    /* renamed from: h  reason: collision with root package name */
    private Runnable f12576h;

    /* compiled from: ThumbDrawable.java */
    /* loaded from: classes6.dex */
    class a implements Runnable {
        a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            e.this.f12574f = true;
            e.this.invalidateSelf();
            e.this.f12575g = false;
        }
    }

    public e(@NonNull ColorStateList colorStateList, int i2) {
        super(colorStateList);
        this.f12576h = new a();
        this.f12573e = i2;
    }

    @Override // us.pinguo.widget.discreteseekbar.internal.b.c
    public void a(Canvas canvas, Paint paint) {
        if (this.f12574f) {
            return;
        }
        Rect bounds = getBounds();
        canvas.drawCircle(bounds.centerX(), bounds.centerY(), this.f12573e / 2, paint);
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicHeight() {
        return this.f12573e;
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicWidth() {
        return this.f12573e;
    }

    public void h() {
        this.f12574f = false;
        this.f12575g = false;
        unscheduleSelf(this.f12576h);
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Animatable
    public boolean isRunning() {
        return this.f12575g;
    }

    @Override // android.graphics.drawable.Animatable
    public void start() {
    }

    @Override // android.graphics.drawable.Animatable
    public void stop() {
        h();
    }
}
