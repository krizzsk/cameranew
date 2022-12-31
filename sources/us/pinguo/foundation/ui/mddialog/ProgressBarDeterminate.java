package us.pinguo.foundation.ui.mddialog;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.LayerDrawable;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.View;
import android.widget.RelativeLayout;
import us.pinguo.foundation.R;
/* loaded from: classes4.dex */
public class ProgressBarDeterminate extends CustomView {

    /* renamed from: d  reason: collision with root package name */
    int f11080d;

    /* renamed from: e  reason: collision with root package name */
    int f11081e;

    /* renamed from: f  reason: collision with root package name */
    int f11082f;

    /* renamed from: g  reason: collision with root package name */
    int f11083g;

    /* renamed from: h  reason: collision with root package name */
    View f11084h;

    /* renamed from: i  reason: collision with root package name */
    int f11085i;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes4.dex */
    public class a implements Runnable {
        a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) ProgressBarDeterminate.this.f11084h.getLayoutParams();
            layoutParams.height = ProgressBarDeterminate.this.getHeight();
            ProgressBarDeterminate.this.f11084h.setLayoutParams(layoutParams);
        }
    }

    public ProgressBarDeterminate(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f11080d = 100;
        this.f11081e = 0;
        this.f11082f = 0;
        this.f11083g = Color.parseColor("#1E88E5");
        this.f11085i = -1;
        e(attributeSet);
    }

    private int a(float f2, Resources resources) {
        return (int) TypedValue.applyDimension(1, f2, resources.getDisplayMetrics());
    }

    public int b() {
        return this.f11080d;
    }

    public int c() {
        return this.f11082f;
    }

    protected int d() {
        int i2 = this.f11083g;
        return Color.argb(128, (i2 >> 16) & 255, (i2 >> 8) & 255, (i2 >> 0) & 255);
    }

    protected void e(AttributeSet attributeSet) {
        this.f11084h = new View(getContext());
        this.f11084h.setLayoutParams(new RelativeLayout.LayoutParams(1, 1));
        this.f11084h.setBackgroundResource(R.drawable.background_md_horizontal_progress);
        addView(this.f11084h);
        int attributeResourceValue = attributeSet.getAttributeResourceValue("http://schemas.android.com/apk/res/android", "background", -1);
        if (attributeResourceValue != -1) {
            setBackgroundColor(getResources().getColor(attributeResourceValue));
        } else {
            int attributeIntValue = attributeSet.getAttributeIntValue("http://schemas.android.com/apk/res/android", "background", -1);
            if (attributeIntValue != -1) {
                setBackgroundColor(attributeIntValue);
            } else {
                setBackgroundColor(Color.parseColor("#1E88E5"));
            }
        }
        this.f11081e = attributeSet.getAttributeIntValue("http://schemas.android.com/apk/res-auto", "min", 0);
        this.f11080d = attributeSet.getAttributeIntValue("http://schemas.android.com/apk/res-auto", "max", 100);
        this.f11082f = attributeSet.getAttributeIntValue("http://schemas.android.com/apk/res-auto", "progress", this.f11081e);
        setMinimumHeight(a(3.0f, getResources()));
        post(new a());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // us.pinguo.foundation.ui.mddialog.CustomView, android.view.View
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        int i2 = this.f11085i;
        if (i2 != -1) {
            setProgress(i2);
        }
    }

    @Override // android.view.View
    public void setBackgroundColor(int i2) {
        this.f11083g = i2;
        if (isEnabled()) {
            this.b = this.f11083g;
        }
        ((GradientDrawable) ((LayerDrawable) this.f11084h.getBackground()).findDrawableByLayerId(R.id.shape_bacground)).setColor(i2);
        super.setBackgroundColor(d());
    }

    public void setMax(int i2) {
        this.f11080d = i2;
    }

    public void setMin(int i2) {
        this.f11081e = i2;
    }

    public void setProgress(int i2) {
        if (getWidth() == 0) {
            this.f11085i = i2;
            return;
        }
        this.f11082f = i2;
        int i3 = this.f11080d;
        if (i2 > i3) {
            i2 = i3;
        }
        int i4 = this.f11081e;
        if (i2 < i4) {
            i2 = i4;
        }
        double d2 = i2 / (i3 - i4);
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.f11084h.getLayoutParams();
        layoutParams.width = (int) (getWidth() * d2);
        layoutParams.height = getHeight();
        this.f11084h.setLayoutParams(layoutParams);
        this.f11085i = -1;
    }
}
