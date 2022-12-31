package us.pinguo.ui.widget;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.text.Layout;
import android.text.StaticLayout;
import android.text.TextPaint;
import android.text.TextWatcher;
import android.text.method.SingleLineTransformationMethod;
import android.text.method.TransformationMethod;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.View;
import android.widget.TextView;
import java.util.ArrayList;
import java.util.Iterator;
import us.pinguo.foundation.R;
/* compiled from: AutofitHelper.java */
/* loaded from: classes6.dex */
public class e {
    private TextView a;
    private TextPaint b;
    private float c;

    /* renamed from: d  reason: collision with root package name */
    private int f12281d;

    /* renamed from: e  reason: collision with root package name */
    private float f12282e;

    /* renamed from: f  reason: collision with root package name */
    private float f12283f;

    /* renamed from: g  reason: collision with root package name */
    private float f12284g;

    /* renamed from: h  reason: collision with root package name */
    private boolean f12285h;

    /* renamed from: i  reason: collision with root package name */
    private boolean f12286i;

    /* renamed from: j  reason: collision with root package name */
    private ArrayList<d> f12287j;

    /* renamed from: k  reason: collision with root package name */
    private TextWatcher f12288k = new c();

    /* renamed from: l  reason: collision with root package name */
    private View.OnLayoutChangeListener f12289l = new b();

    /* compiled from: AutofitHelper.java */
    /* loaded from: classes6.dex */
    private class b implements View.OnLayoutChangeListener {
        private b() {
        }

        @Override // android.view.View.OnLayoutChangeListener
        public void onLayoutChange(View view, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9) {
            e.this.c();
        }
    }

    /* compiled from: AutofitHelper.java */
    /* loaded from: classes6.dex */
    private class c extends us.pinguo.foundation.ui.g {
        private c() {
        }

        @Override // us.pinguo.foundation.ui.g, android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
            e.this.c();
        }
    }

    /* compiled from: AutofitHelper.java */
    /* loaded from: classes6.dex */
    public interface d {
        void a(float f2, float f3);
    }

    private e(TextView textView) {
        float f2 = textView.getContext().getResources().getDisplayMetrics().scaledDensity;
        this.a = textView;
        this.b = new TextPaint();
        t(textView.getTextSize());
        this.f12281d = h(textView);
        this.f12282e = f2 * 7.0f;
        this.f12283f = this.c;
        this.f12284g = 0.5f;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c() {
        System.currentTimeMillis();
        float textSize = this.a.getTextSize();
        this.f12286i = true;
        d(this.a, this.b, this.f12282e, this.f12283f, this.f12281d, this.f12284g);
        this.f12286i = false;
        float textSize2 = this.a.getTextSize();
        if (textSize2 != textSize) {
            k(textSize2, textSize);
        }
    }

    private static void d(TextView textView, TextPaint textPaint, float f2, float f3, int i2, float f4) {
        int width;
        if (i2 <= 0 || i2 == Integer.MAX_VALUE || (width = (textView.getWidth() - textView.getPaddingLeft()) - textView.getPaddingRight()) <= 0) {
            return;
        }
        if (textView.getCompoundDrawables() != null) {
            Drawable[] compoundDrawables = textView.getCompoundDrawables();
            for (int i3 = 0; i3 < compoundDrawables.length; i3++) {
                if (compoundDrawables[i3] != null) {
                    width -= compoundDrawables[i3].getBounds().width();
                }
            }
            if (width <= 0 || (width = width - textView.getCompoundDrawablePadding()) <= 0) {
                return;
            }
        }
        CharSequence text = textView.getText();
        TransformationMethod transformationMethod = textView.getTransformationMethod();
        if (transformationMethod != null) {
            text = transformationMethod.getTransformation(text, textView);
        }
        Context context = textView.getContext();
        Resources system = Resources.getSystem();
        if (context != null) {
            system = context.getResources();
        }
        DisplayMetrics displayMetrics = system.getDisplayMetrics();
        textPaint.set(textView.getPaint());
        textPaint.setTextSize(f3);
        float f5 = ((i2 != 1 || textPaint.measureText(text, 0, text.length()) <= ((float) width)) && g(text, textPaint, f3, (float) width, displayMetrics) <= i2) ? f3 : f(text, textPaint, width, i2, f2, f3, f4, displayMetrics);
        if (f5 < f2) {
            f5 = f2;
        }
        textView.setTextSize(0, f5);
    }

    public static e e(TextView textView, AttributeSet attributeSet, int i2) {
        e eVar = new e(textView);
        boolean z = true;
        if (attributeSet != null) {
            Context context = textView.getContext();
            float j2 = eVar.j();
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.AutofitTextView, i2, 0);
            z = obtainStyledAttributes.getBoolean(R.styleable.AutofitTextView_sizeToFit, true);
            int dimensionPixelSize = obtainStyledAttributes.getDimensionPixelSize(R.styleable.AutofitTextView_minTextSize, (int) eVar.i());
            float f2 = obtainStyledAttributes.getFloat(R.styleable.AutofitTextView_precision, j2);
            obtainStyledAttributes.recycle();
            eVar.p(0, dimensionPixelSize);
            eVar.q(f2);
        }
        eVar.l(z);
        return eVar;
    }

    private static float f(CharSequence charSequence, TextPaint textPaint, float f2, int i2, float f3, float f4, float f5, DisplayMetrics displayMetrics) {
        StaticLayout staticLayout;
        int i3;
        float f6;
        float f7 = (f3 + f4) / 2.0f;
        textPaint.setTextSize(TypedValue.applyDimension(0, f7, displayMetrics));
        if (i2 != 1) {
            staticLayout = new StaticLayout(charSequence, textPaint, (int) f2, Layout.Alignment.ALIGN_NORMAL, 1.0f, 0.0f, true);
            i3 = staticLayout.getLineCount();
        } else {
            staticLayout = null;
            i3 = 1;
        }
        if (i3 > i2) {
            return f4 - f3 < f5 ? f3 : f(charSequence, textPaint, f2, i2, f3, f7, f5, displayMetrics);
        } else if (i3 < i2) {
            return f(charSequence, textPaint, f2, i2, f7, f4, f5, displayMetrics);
        } else {
            float f8 = 0.0f;
            if (i2 == 1) {
                f6 = textPaint.measureText(charSequence, 0, charSequence.length());
            } else {
                for (int i4 = 0; i4 < i3; i4++) {
                    if (staticLayout.getLineWidth(i4) > f8) {
                        f8 = staticLayout.getLineWidth(i4);
                    }
                }
                f6 = f8;
            }
            if (f4 - f3 < f5) {
                return f3;
            }
            if (f6 > f2) {
                return f(charSequence, textPaint, f2, i2, f3, f7, f5, displayMetrics);
            }
            return f6 < f2 ? f(charSequence, textPaint, f2, i2, f7, f4, f5, displayMetrics) : f7;
        }
    }

    private static int g(CharSequence charSequence, TextPaint textPaint, float f2, float f3, DisplayMetrics displayMetrics) {
        textPaint.setTextSize(TypedValue.applyDimension(0, f2, displayMetrics));
        return new StaticLayout(charSequence, textPaint, (int) f3, Layout.Alignment.ALIGN_NORMAL, 1.0f, 0.0f, true).getLineCount();
    }

    private static int h(TextView textView) {
        TransformationMethod transformationMethod = textView.getTransformationMethod();
        if (transformationMethod == null || !(transformationMethod instanceof SingleLineTransformationMethod)) {
            if (Build.VERSION.SDK_INT >= 16) {
                return textView.getMaxLines();
            }
            return -1;
        }
        return 1;
    }

    private void k(float f2, float f3) {
        ArrayList<d> arrayList = this.f12287j;
        if (arrayList == null) {
            return;
        }
        Iterator<d> it = arrayList.iterator();
        while (it.hasNext()) {
            it.next().a(f2, f3);
        }
    }

    private void r(float f2) {
        if (f2 != this.f12283f) {
            this.f12283f = f2;
            c();
        }
    }

    private void s(float f2) {
        if (f2 != this.f12282e) {
            this.f12282e = f2;
            c();
        }
    }

    private void t(float f2) {
        if (this.c != f2) {
            this.c = f2;
        }
    }

    public e b(d dVar) {
        if (this.f12287j == null) {
            this.f12287j = new ArrayList<>();
        }
        this.f12287j.add(dVar);
        return this;
    }

    public float i() {
        return this.f12282e;
    }

    public float j() {
        return this.f12284g;
    }

    public e l(boolean z) {
        if (this.f12285h != z) {
            this.f12285h = z;
            if (z) {
                this.a.addTextChangedListener(this.f12288k);
                this.a.addOnLayoutChangeListener(this.f12289l);
                c();
            } else {
                this.a.removeTextChangedListener(this.f12288k);
                this.a.removeOnLayoutChangeListener(this.f12289l);
                this.a.setTextSize(0, this.c);
            }
        }
        return this;
    }

    public e m(int i2) {
        if (this.f12281d != i2) {
            this.f12281d = i2;
            c();
        }
        return this;
    }

    public e n(float f2) {
        o(2, f2);
        return this;
    }

    public e o(int i2, float f2) {
        Context context = this.a.getContext();
        Resources system = Resources.getSystem();
        if (context != null) {
            system = context.getResources();
        }
        r(TypedValue.applyDimension(i2, f2, system.getDisplayMetrics()));
        return this;
    }

    public e p(int i2, float f2) {
        Context context = this.a.getContext();
        Resources system = Resources.getSystem();
        if (context != null) {
            system = context.getResources();
        }
        s(TypedValue.applyDimension(i2, f2, system.getDisplayMetrics()));
        return this;
    }

    public e q(float f2) {
        if (this.f12284g != f2) {
            this.f12284g = f2;
            c();
        }
        return this;
    }

    public void u(int i2, float f2) {
        if (this.f12286i) {
            return;
        }
        Context context = this.a.getContext();
        Resources system = Resources.getSystem();
        if (context != null) {
            system = context.getResources();
        }
        t(TypedValue.applyDimension(i2, f2, system.getDisplayMetrics()));
    }
}
