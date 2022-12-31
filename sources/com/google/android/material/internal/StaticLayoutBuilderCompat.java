package com.google.android.material.internal;

import android.os.Build;
import android.text.Layout;
import android.text.StaticLayout;
import android.text.TextDirectionHeuristic;
import android.text.TextDirectionHeuristics;
import android.text.TextPaint;
import android.text.TextUtils;
import androidx.annotation.IntRange;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.core.util.Preconditions;
import java.lang.reflect.Constructor;
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
/* loaded from: classes2.dex */
final class StaticLayoutBuilderCompat {
    static final int n;
    private static boolean o;
    @Nullable
    private static Constructor<StaticLayout> p;
    @Nullable
    private static Object q;
    private CharSequence a;
    private final TextPaint b;
    private final int c;

    /* renamed from: e  reason: collision with root package name */
    private int f4349e;

    /* renamed from: l  reason: collision with root package name */
    private boolean f4356l;

    /* renamed from: d  reason: collision with root package name */
    private int f4348d = 0;

    /* renamed from: f  reason: collision with root package name */
    private Layout.Alignment f4350f = Layout.Alignment.ALIGN_NORMAL;

    /* renamed from: g  reason: collision with root package name */
    private int f4351g = Integer.MAX_VALUE;

    /* renamed from: h  reason: collision with root package name */
    private float f4352h = 0.0f;

    /* renamed from: i  reason: collision with root package name */
    private float f4353i = 1.0f;

    /* renamed from: j  reason: collision with root package name */
    private int f4354j = n;

    /* renamed from: k  reason: collision with root package name */
    private boolean f4355k = true;
    @Nullable
    private TextUtils.TruncateAt m = null;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public static class StaticLayoutBuilderCompatException extends Exception {
        StaticLayoutBuilderCompatException(Throwable th) {
            super("Error thrown initializing StaticLayout " + th.getMessage(), th);
        }
    }

    static {
        n = Build.VERSION.SDK_INT >= 23 ? 1 : 0;
    }

    private StaticLayoutBuilderCompat(CharSequence charSequence, TextPaint textPaint, int i2) {
        this.a = charSequence;
        this.b = textPaint;
        this.c = i2;
        this.f4349e = charSequence.length();
    }

    private void b() throws StaticLayoutBuilderCompatException {
        Class<?> cls;
        if (o) {
            return;
        }
        try {
            boolean z = this.f4356l && Build.VERSION.SDK_INT >= 23;
            if (Build.VERSION.SDK_INT >= 18) {
                cls = TextDirectionHeuristic.class;
                q = z ? TextDirectionHeuristics.RTL : TextDirectionHeuristics.LTR;
            } else {
                ClassLoader classLoader = StaticLayoutBuilderCompat.class.getClassLoader();
                String str = this.f4356l ? "RTL" : "LTR";
                Class<?> loadClass = classLoader.loadClass("android.text.TextDirectionHeuristic");
                Class<?> loadClass2 = classLoader.loadClass("android.text.TextDirectionHeuristics");
                q = loadClass2.getField(str).get(loadClass2);
                cls = loadClass;
            }
            Class cls2 = Integer.TYPE;
            Class cls3 = Float.TYPE;
            Constructor<StaticLayout> declaredConstructor = StaticLayout.class.getDeclaredConstructor(CharSequence.class, cls2, cls2, TextPaint.class, cls2, Layout.Alignment.class, cls, cls3, cls3, Boolean.TYPE, TextUtils.TruncateAt.class, cls2, cls2);
            p = declaredConstructor;
            declaredConstructor.setAccessible(true);
            o = true;
        } catch (Exception e2) {
            throw new StaticLayoutBuilderCompatException(e2);
        }
    }

    @NonNull
    public static StaticLayoutBuilderCompat c(@NonNull CharSequence charSequence, @NonNull TextPaint textPaint, @IntRange(from = 0) int i2) {
        return new StaticLayoutBuilderCompat(charSequence, textPaint, i2);
    }

    public StaticLayout a() throws StaticLayoutBuilderCompatException {
        if (this.a == null) {
            this.a = "";
        }
        int max = Math.max(0, this.c);
        CharSequence charSequence = this.a;
        if (this.f4351g == 1) {
            charSequence = TextUtils.ellipsize(charSequence, this.b, max, this.m);
        }
        int min = Math.min(charSequence.length(), this.f4349e);
        this.f4349e = min;
        if (Build.VERSION.SDK_INT >= 23) {
            if (this.f4356l && this.f4351g == 1) {
                this.f4350f = Layout.Alignment.ALIGN_OPPOSITE;
            }
            StaticLayout.Builder obtain = StaticLayout.Builder.obtain(charSequence, this.f4348d, min, this.b, max);
            obtain.setAlignment(this.f4350f);
            obtain.setIncludePad(this.f4355k);
            obtain.setTextDirection(this.f4356l ? TextDirectionHeuristics.RTL : TextDirectionHeuristics.LTR);
            TextUtils.TruncateAt truncateAt = this.m;
            if (truncateAt != null) {
                obtain.setEllipsize(truncateAt);
            }
            obtain.setMaxLines(this.f4351g);
            float f2 = this.f4352h;
            if (f2 != 0.0f || this.f4353i != 1.0f) {
                obtain.setLineSpacing(f2, this.f4353i);
            }
            if (this.f4351g > 1) {
                obtain.setHyphenationFrequency(this.f4354j);
            }
            return obtain.build();
        }
        b();
        try {
            return (StaticLayout) ((Constructor) Preconditions.checkNotNull(p)).newInstance(charSequence, Integer.valueOf(this.f4348d), Integer.valueOf(this.f4349e), this.b, Integer.valueOf(max), this.f4350f, Preconditions.checkNotNull(q), Float.valueOf(1.0f), Float.valueOf(0.0f), Boolean.valueOf(this.f4355k), null, Integer.valueOf(max), Integer.valueOf(this.f4351g));
        } catch (Exception e2) {
            throw new StaticLayoutBuilderCompatException(e2);
        }
    }

    @NonNull
    public StaticLayoutBuilderCompat d(@NonNull Layout.Alignment alignment) {
        this.f4350f = alignment;
        return this;
    }

    @NonNull
    public StaticLayoutBuilderCompat e(@Nullable TextUtils.TruncateAt truncateAt) {
        this.m = truncateAt;
        return this;
    }

    @NonNull
    public StaticLayoutBuilderCompat f(int i2) {
        this.f4354j = i2;
        return this;
    }

    @NonNull
    public StaticLayoutBuilderCompat g(boolean z) {
        this.f4355k = z;
        return this;
    }

    public StaticLayoutBuilderCompat h(boolean z) {
        this.f4356l = z;
        return this;
    }

    @NonNull
    public StaticLayoutBuilderCompat i(float f2, float f3) {
        this.f4352h = f2;
        this.f4353i = f3;
        return this;
    }

    @NonNull
    public StaticLayoutBuilderCompat j(@IntRange(from = 0) int i2) {
        this.f4351g = i2;
        return this;
    }
}
