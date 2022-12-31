package com.google.android.material.f;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Typeface;
import android.os.Build;
import android.text.TextPaint;
import android.util.Log;
import androidx.annotation.FontRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.annotation.StyleRes;
import androidx.annotation.VisibleForTesting;
import androidx.core.content.res.ResourcesCompat;
import androidx.core.view.ViewCompat;
import com.google.android.material.R;
/* compiled from: TextAppearance.java */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
/* loaded from: classes2.dex */
public class d {
    @Nullable
    public final ColorStateList a;
    @Nullable
    public final ColorStateList b;
    @Nullable
    public final String c;

    /* renamed from: d  reason: collision with root package name */
    public final int f4255d;

    /* renamed from: e  reason: collision with root package name */
    public final int f4256e;

    /* renamed from: f  reason: collision with root package name */
    public final float f4257f;

    /* renamed from: g  reason: collision with root package name */
    public final float f4258g;

    /* renamed from: h  reason: collision with root package name */
    public final float f4259h;

    /* renamed from: i  reason: collision with root package name */
    public final boolean f4260i;

    /* renamed from: j  reason: collision with root package name */
    public final float f4261j;

    /* renamed from: k  reason: collision with root package name */
    public float f4262k;
    @FontRes

    /* renamed from: l  reason: collision with root package name */
    private final int f4263l;
    private boolean m = false;
    private Typeface n;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: TextAppearance.java */
    /* loaded from: classes2.dex */
    public class a extends ResourcesCompat.FontCallback {
        final /* synthetic */ f a;

        a(f fVar) {
            this.a = fVar;
        }

        @Override // androidx.core.content.res.ResourcesCompat.FontCallback
        public void onFontRetrievalFailed(int i2) {
            d.this.m = true;
            this.a.a(i2);
        }

        @Override // androidx.core.content.res.ResourcesCompat.FontCallback
        public void onFontRetrieved(@NonNull Typeface typeface) {
            d dVar = d.this;
            dVar.n = Typeface.create(typeface, dVar.f4255d);
            d.this.m = true;
            this.a.b(d.this.n, false);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: TextAppearance.java */
    /* loaded from: classes2.dex */
    public class b extends f {
        final /* synthetic */ TextPaint a;
        final /* synthetic */ f b;

        b(TextPaint textPaint, f fVar) {
            this.a = textPaint;
            this.b = fVar;
        }

        @Override // com.google.android.material.f.f
        public void a(int i2) {
            this.b.a(i2);
        }

        @Override // com.google.android.material.f.f
        public void b(@NonNull Typeface typeface, boolean z) {
            d.this.l(this.a, typeface);
            this.b.b(typeface, z);
        }
    }

    public d(@NonNull Context context, @StyleRes int i2) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(i2, R.styleable.TextAppearance);
        this.f4262k = obtainStyledAttributes.getDimension(R.styleable.TextAppearance_android_textSize, 0.0f);
        this.a = c.a(context, obtainStyledAttributes, R.styleable.TextAppearance_android_textColor);
        c.a(context, obtainStyledAttributes, R.styleable.TextAppearance_android_textColorHint);
        c.a(context, obtainStyledAttributes, R.styleable.TextAppearance_android_textColorLink);
        this.f4255d = obtainStyledAttributes.getInt(R.styleable.TextAppearance_android_textStyle, 0);
        this.f4256e = obtainStyledAttributes.getInt(R.styleable.TextAppearance_android_typeface, 1);
        int e2 = c.e(obtainStyledAttributes, R.styleable.TextAppearance_fontFamily, R.styleable.TextAppearance_android_fontFamily);
        this.f4263l = obtainStyledAttributes.getResourceId(e2, 0);
        this.c = obtainStyledAttributes.getString(e2);
        obtainStyledAttributes.getBoolean(R.styleable.TextAppearance_textAllCaps, false);
        this.b = c.a(context, obtainStyledAttributes, R.styleable.TextAppearance_android_shadowColor);
        this.f4257f = obtainStyledAttributes.getFloat(R.styleable.TextAppearance_android_shadowDx, 0.0f);
        this.f4258g = obtainStyledAttributes.getFloat(R.styleable.TextAppearance_android_shadowDy, 0.0f);
        this.f4259h = obtainStyledAttributes.getFloat(R.styleable.TextAppearance_android_shadowRadius, 0.0f);
        obtainStyledAttributes.recycle();
        if (Build.VERSION.SDK_INT >= 21) {
            TypedArray obtainStyledAttributes2 = context.obtainStyledAttributes(i2, R.styleable.MaterialTextAppearance);
            int i3 = R.styleable.MaterialTextAppearance_android_letterSpacing;
            this.f4260i = obtainStyledAttributes2.hasValue(i3);
            this.f4261j = obtainStyledAttributes2.getFloat(i3, 0.0f);
            obtainStyledAttributes2.recycle();
            return;
        }
        this.f4260i = false;
        this.f4261j = 0.0f;
    }

    private void d() {
        String str;
        if (this.n == null && (str = this.c) != null) {
            this.n = Typeface.create(str, this.f4255d);
        }
        if (this.n == null) {
            int i2 = this.f4256e;
            if (i2 == 1) {
                this.n = Typeface.SANS_SERIF;
            } else if (i2 == 2) {
                this.n = Typeface.SERIF;
            } else if (i2 != 3) {
                this.n = Typeface.DEFAULT;
            } else {
                this.n = Typeface.MONOSPACE;
            }
            this.n = Typeface.create(this.n, this.f4255d);
        }
    }

    private boolean i(Context context) {
        if (e.a()) {
            return true;
        }
        int i2 = this.f4263l;
        return (i2 != 0 ? ResourcesCompat.getCachedFont(context, i2) : null) != null;
    }

    public Typeface e() {
        d();
        return this.n;
    }

    @NonNull
    @VisibleForTesting
    public Typeface f(@NonNull Context context) {
        if (this.m) {
            return this.n;
        }
        if (!context.isRestricted()) {
            try {
                Typeface font = ResourcesCompat.getFont(context, this.f4263l);
                this.n = font;
                if (font != null) {
                    this.n = Typeface.create(font, this.f4255d);
                }
            } catch (Resources.NotFoundException | UnsupportedOperationException unused) {
            } catch (Exception e2) {
                Log.d("TextAppearance", "Error loading font " + this.c, e2);
            }
        }
        d();
        this.m = true;
        return this.n;
    }

    public void g(@NonNull Context context, @NonNull TextPaint textPaint, @NonNull f fVar) {
        l(textPaint, e());
        h(context, new b(textPaint, fVar));
    }

    public void h(@NonNull Context context, @NonNull f fVar) {
        if (i(context)) {
            f(context);
        } else {
            d();
        }
        int i2 = this.f4263l;
        if (i2 == 0) {
            this.m = true;
        }
        if (this.m) {
            fVar.b(this.n, true);
            return;
        }
        try {
            ResourcesCompat.getFont(context, i2, new a(fVar), null);
        } catch (Resources.NotFoundException unused) {
            this.m = true;
            fVar.a(1);
        } catch (Exception e2) {
            Log.d("TextAppearance", "Error loading font " + this.c, e2);
            this.m = true;
            fVar.a(-3);
        }
    }

    public void j(@NonNull Context context, @NonNull TextPaint textPaint, @NonNull f fVar) {
        k(context, textPaint, fVar);
        ColorStateList colorStateList = this.a;
        textPaint.setColor(colorStateList != null ? colorStateList.getColorForState(textPaint.drawableState, colorStateList.getDefaultColor()) : ViewCompat.MEASURED_STATE_MASK);
        float f2 = this.f4259h;
        float f3 = this.f4257f;
        float f4 = this.f4258g;
        ColorStateList colorStateList2 = this.b;
        textPaint.setShadowLayer(f2, f3, f4, colorStateList2 != null ? colorStateList2.getColorForState(textPaint.drawableState, colorStateList2.getDefaultColor()) : 0);
    }

    public void k(@NonNull Context context, @NonNull TextPaint textPaint, @NonNull f fVar) {
        if (i(context)) {
            l(textPaint, f(context));
        } else {
            g(context, textPaint, fVar);
        }
    }

    public void l(@NonNull TextPaint textPaint, @NonNull Typeface typeface) {
        textPaint.setTypeface(typeface);
        int i2 = (~typeface.getStyle()) & this.f4255d;
        textPaint.setFakeBoldText((i2 & 1) != 0);
        textPaint.setTextSkewX((i2 & 2) != 0 ? -0.25f : 0.0f);
        textPaint.setTextSize(this.f4262k);
        if (Build.VERSION.SDK_INT < 21 || !this.f4260i) {
            return;
        }
        textPaint.setLetterSpacing(this.f4261j);
    }
}
