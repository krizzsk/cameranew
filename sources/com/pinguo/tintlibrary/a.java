package com.pinguo.tintlibrary;

import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.ColorFilter;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import androidx.collection.LruCache;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: PgTintHelper.java */
/* loaded from: classes3.dex */
public class a {

    /* renamed from: f  reason: collision with root package name */
    private static final PorterDuff.Mode f7074f = PorterDuff.Mode.SRC_IN;

    /* renamed from: g  reason: collision with root package name */
    private static final b f7075g = new b(6);
    private final View a;
    private c b;
    private c c;

    /* renamed from: d  reason: collision with root package name */
    private ColorFilter f7076d = null;

    /* renamed from: e  reason: collision with root package name */
    private ColorFilter f7077e = null;

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: PgTintHelper.java */
    /* loaded from: classes3.dex */
    public static class b extends LruCache<Integer, PorterDuffColorFilter> {
        public b(int i2) {
            super(i2);
        }

        private static int generateCacheKey(int i2, PorterDuff.Mode mode) {
            return ((i2 + 31) * 31) + mode.hashCode();
        }

        PorterDuffColorFilter get(int i2, PorterDuff.Mode mode) {
            return get(Integer.valueOf(generateCacheKey(i2, mode)));
        }

        PorterDuffColorFilter put(int i2, PorterDuff.Mode mode, PorterDuffColorFilter porterDuffColorFilter) {
            return put(Integer.valueOf(generateCacheKey(i2, mode)), porterDuffColorFilter);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: PgTintHelper.java */
    /* loaded from: classes3.dex */
    public class c {
        public ColorStateList a;
        public PorterDuff.Mode b;
        public boolean c;

        /* renamed from: d  reason: collision with root package name */
        public boolean f7078d;

        private c(a aVar) {
        }
    }

    public a(View view) {
        this.a = view;
    }

    private void c(Drawable drawable, c cVar, boolean z) {
        if (drawable == null || cVar == null) {
            return;
        }
        boolean z2 = cVar.f7078d;
        if (z2 || cVar.c) {
            PorterDuffColorFilter d2 = d(z2 ? cVar.a : null, cVar.c ? cVar.b : f7074f, this.a.getDrawableState());
            if (z) {
                if (this.f7076d != d2) {
                    drawable.setColorFilter(d2);
                    this.f7076d = d2;
                }
            } else if (this.f7077e != d2) {
                drawable.setColorFilter(d2);
                this.f7077e = d2;
            }
        }
    }

    private PorterDuffColorFilter d(ColorStateList colorStateList, PorterDuff.Mode mode, int[] iArr) {
        int colorForState;
        if (colorStateList == null || mode == null || (colorForState = colorStateList.getColorForState(iArr, 0)) == 0) {
            return null;
        }
        b bVar = f7075g;
        PorterDuffColorFilter porterDuffColorFilter = bVar.get(colorForState, mode);
        if (porterDuffColorFilter == null) {
            PorterDuffColorFilter porterDuffColorFilter2 = new PorterDuffColorFilter(colorForState, mode);
            bVar.put(colorForState, mode, porterDuffColorFilter2);
            return porterDuffColorFilter2;
        }
        return porterDuffColorFilter;
    }

    private PorterDuff.Mode h(int i2, PorterDuff.Mode mode) {
        if (i2 != 3) {
            if (i2 != 5) {
                if (i2 != 9) {
                    switch (i2) {
                        case 14:
                            return PorterDuff.Mode.MULTIPLY;
                        case 15:
                            return PorterDuff.Mode.SCREEN;
                        case 16:
                            return Build.VERSION.SDK_INT >= 11 ? PorterDuff.Mode.valueOf("ADD") : mode;
                        default:
                            return mode;
                    }
                }
                return PorterDuff.Mode.SRC_ATOP;
            }
            return PorterDuff.Mode.SRC_IN;
        }
        return PorterDuff.Mode.SRC_OVER;
    }

    public void a() {
        Drawable drawable;
        if (this.c != null) {
            View view = this.a;
            if (!(view instanceof ImageView) || (drawable = ((ImageView) view).getDrawable()) == null) {
                return;
            }
            c(drawable, this.c, false);
        }
    }

    public void b() {
        if (this.a.getBackground() == null || this.b == null) {
            return;
        }
        c(this.a.getBackground(), this.b, true);
    }

    public ColorStateList e() {
        c cVar = this.b;
        if (cVar != null) {
            return cVar.a;
        }
        return null;
    }

    public PorterDuff.Mode f() {
        c cVar = this.b;
        if (cVar != null) {
            return cVar.b;
        }
        return null;
    }

    public void g(AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes = this.a.getContext().obtainStyledAttributes(attributeSet, R.styleable.Tint, 0, 0);
        try {
            int i2 = R.styleable.Tint_PgBackgroundTint;
            if (obtainStyledAttributes.hasValue(i2)) {
                k(obtainStyledAttributes.getColorStateList(i2));
            }
            int i3 = R.styleable.Tint_PgBackgroundTintMode;
            if (obtainStyledAttributes.hasValue(i3)) {
                l(h(obtainStyledAttributes.getInt(i3, -1), null));
            }
            int i4 = R.styleable.Tint_PgImageTint;
            if (obtainStyledAttributes.hasValue(i4)) {
                i(obtainStyledAttributes.getColorStateList(i4));
            }
            int i5 = R.styleable.Tint_PgImageTintMode;
            if (obtainStyledAttributes.hasValue(i5)) {
                j(h(obtainStyledAttributes.getInt(i5, -1), null));
            }
        } finally {
            obtainStyledAttributes.recycle();
        }
    }

    public void i(ColorStateList colorStateList) {
        if (this.c == null) {
            this.c = new c();
        }
        c cVar = this.c;
        cVar.a = colorStateList;
        cVar.f7078d = true;
        a();
    }

    public void j(PorterDuff.Mode mode) {
        if (this.c == null) {
            this.c = new c();
        }
        c cVar = this.c;
        cVar.c = true;
        cVar.b = mode;
        a();
    }

    public void k(ColorStateList colorStateList) {
        if (this.b == null) {
            this.b = new c();
        }
        c cVar = this.b;
        cVar.a = colorStateList;
        cVar.f7078d = true;
        b();
    }

    public void l(PorterDuff.Mode mode) {
        if (this.b == null) {
            this.b = new c();
        }
        c cVar = this.b;
        cVar.c = true;
        cVar.b = mode;
        b();
    }
}
