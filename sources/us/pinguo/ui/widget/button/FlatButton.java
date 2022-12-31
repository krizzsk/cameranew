package us.pinguo.ui.widget.button;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.StateListDrawable;
import android.os.Build;
import android.util.AttributeSet;
import android.widget.Button;
import us.pinguo.ui.R;
/* loaded from: classes6.dex */
public class FlatButton extends Button {
    private StateListDrawable a;
    private CharSequence b;
    private ColorStateList c;

    /* renamed from: d  reason: collision with root package name */
    private float f12272d;

    /* renamed from: e  reason: collision with root package name */
    private float f12273e;

    public FlatButton(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        k(context, attributeSet);
    }

    private Drawable a(TypedArray typedArray) {
        GradientDrawable gradientDrawable = (GradientDrawable) f(R.drawable.process_button_rect_normal).mutate();
        gradientDrawable.setCornerRadius(d());
        int color = typedArray.getColor(R.styleable.FlatButton_pb_colorNormal, c(R.color.process_button_blue_normal));
        if (this.f12273e > 0.0f) {
            gradientDrawable.setColor(0);
            gradientDrawable.setStroke((int) this.f12273e, color);
        } else {
            gradientDrawable.setColor(color);
        }
        return gradientDrawable;
    }

    private Drawable b(TypedArray typedArray) {
        GradientDrawable gradientDrawable = (GradientDrawable) f(R.drawable.process_button_rect_pressed).mutate();
        gradientDrawable.setCornerRadius(d());
        int color = typedArray.getColor(R.styleable.FlatButton_pb_colorPressed, c(R.color.process_button_blue_pressed));
        if (this.f12273e > 0.0f) {
            gradientDrawable.setColor(0);
            gradientDrawable.setStroke((int) this.f12273e, color);
        } else {
            gradientDrawable.setColor(color);
        }
        return gradientDrawable;
    }

    private void k(Context context, AttributeSet attributeSet) {
        this.a = new StateListDrawable();
        if (attributeSet != null) {
            l(context, attributeSet);
        }
        this.b = getText().toString();
        this.c = getTextColors();
        setBackgroundCompat(this.a);
    }

    private void l(Context context, AttributeSet attributeSet) {
        TypedArray j2 = j(context, attributeSet, R.styleable.FlatButton);
        if (j2 == null) {
            return;
        }
        try {
            this.f12272d = j2.getDimension(R.styleable.FlatButton_pb_cornerRadius, e(R.dimen.process_button_corner_radius));
            this.f12273e = j2.getDimension(R.styleable.FlatButton_pb_stroke, 0.0f);
            this.a.addState(new int[]{16842919}, b(j2));
            this.a.addState(new int[]{16842908}, b(j2));
            this.a.addState(new int[]{16842913}, b(j2));
            this.a.addState(new int[0], a(j2));
        } finally {
            j2.recycle();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public int c(int i2) {
        return getResources().getColor(i2);
    }

    public float d() {
        return this.f12272d;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public float e(int i2) {
        return getResources().getDimension(i2);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public Drawable f(int i2) {
        return getResources().getDrawable(i2);
    }

    public StateListDrawable g() {
        return this.a;
    }

    public CharSequence h() {
        return this.b;
    }

    public ColorStateList i() {
        return this.c;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public TypedArray j(Context context, AttributeSet attributeSet, int[] iArr) {
        return context.obtainStyledAttributes(attributeSet, iArr, 0, 0);
    }

    @SuppressLint({"NewApi"})
    public void setBackgroundCompat(Drawable drawable) {
        int paddingLeft = getPaddingLeft();
        int paddingTop = getPaddingTop();
        int paddingRight = getPaddingRight();
        int paddingBottom = getPaddingBottom();
        if (Build.VERSION.SDK_INT >= 16) {
            setBackground(drawable);
        } else {
            setBackgroundDrawable(drawable);
        }
        setPadding(paddingLeft, paddingTop, paddingRight, paddingBottom);
    }

    public void setNormalText(CharSequence charSequence) {
        this.b = charSequence;
    }

    public FlatButton(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        k(context, attributeSet);
    }

    public FlatButton(Context context) {
        super(context);
        k(context, null);
    }
}
