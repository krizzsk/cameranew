package com.google.android.material.internal;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.core.view.OnApplyWindowInsetsListener;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import com.google.android.material.R;
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
/* loaded from: classes2.dex */
public class ScrimInsetsFrameLayout extends FrameLayout {
    @Nullable
    Drawable a;
    Rect b;
    private Rect c;

    /* renamed from: d  reason: collision with root package name */
    private boolean f4346d;

    /* renamed from: e  reason: collision with root package name */
    private boolean f4347e;

    /* loaded from: classes2.dex */
    class a implements OnApplyWindowInsetsListener {
        a() {
        }

        @Override // androidx.core.view.OnApplyWindowInsetsListener
        public WindowInsetsCompat onApplyWindowInsets(View view, @NonNull WindowInsetsCompat windowInsetsCompat) {
            ScrimInsetsFrameLayout scrimInsetsFrameLayout = ScrimInsetsFrameLayout.this;
            if (scrimInsetsFrameLayout.b == null) {
                scrimInsetsFrameLayout.b = new Rect();
            }
            ScrimInsetsFrameLayout.this.b.set(windowInsetsCompat.getSystemWindowInsetLeft(), windowInsetsCompat.getSystemWindowInsetTop(), windowInsetsCompat.getSystemWindowInsetRight(), windowInsetsCompat.getSystemWindowInsetBottom());
            ScrimInsetsFrameLayout.this.a(windowInsetsCompat);
            ScrimInsetsFrameLayout.this.setWillNotDraw(!windowInsetsCompat.hasSystemWindowInsets() || ScrimInsetsFrameLayout.this.a == null);
            ViewCompat.postInvalidateOnAnimation(ScrimInsetsFrameLayout.this);
            return windowInsetsCompat.consumeSystemWindowInsets();
        }
    }

    public ScrimInsetsFrameLayout(@NonNull Context context) {
        this(context, null);
    }

    protected void a(WindowInsetsCompat windowInsetsCompat) {
    }

    @Override // android.view.View
    public void draw(@NonNull Canvas canvas) {
        super.draw(canvas);
        int width = getWidth();
        int height = getHeight();
        if (this.b == null || this.a == null) {
            return;
        }
        int save = canvas.save();
        canvas.translate(getScrollX(), getScrollY());
        if (this.f4346d) {
            this.c.set(0, 0, width, this.b.top);
            this.a.setBounds(this.c);
            this.a.draw(canvas);
        }
        if (this.f4347e) {
            this.c.set(0, height - this.b.bottom, width, height);
            this.a.setBounds(this.c);
            this.a.draw(canvas);
        }
        Rect rect = this.c;
        Rect rect2 = this.b;
        rect.set(0, rect2.top, rect2.left, height - rect2.bottom);
        this.a.setBounds(this.c);
        this.a.draw(canvas);
        Rect rect3 = this.c;
        Rect rect4 = this.b;
        rect3.set(width - rect4.right, rect4.top, width, height - rect4.bottom);
        this.a.setBounds(this.c);
        this.a.draw(canvas);
        canvas.restoreToCount(save);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        Drawable drawable = this.a;
        if (drawable != null) {
            drawable.setCallback(this);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        Drawable drawable = this.a;
        if (drawable != null) {
            drawable.setCallback(null);
        }
    }

    public void setDrawBottomInsetForeground(boolean z) {
        this.f4347e = z;
    }

    public void setDrawTopInsetForeground(boolean z) {
        this.f4346d = z;
    }

    public void setScrimInsetForeground(@Nullable Drawable drawable) {
        this.a = drawable;
    }

    public ScrimInsetsFrameLayout(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public ScrimInsetsFrameLayout(@NonNull Context context, @Nullable AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.c = new Rect();
        this.f4346d = true;
        this.f4347e = true;
        TypedArray h2 = k.h(context, attributeSet, R.styleable.ScrimInsetsFrameLayout, i2, R.style.Widget_Design_ScrimInsetsFrameLayout, new int[0]);
        this.a = h2.getDrawable(R.styleable.ScrimInsetsFrameLayout_insetForeground);
        h2.recycle();
        setWillNotDraw(true);
        ViewCompat.setOnApplyWindowInsetsListener(this, new a());
    }
}
