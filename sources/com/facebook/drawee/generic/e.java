package com.facebook.drawee.generic;

import android.content.res.Resources;
import android.graphics.PointF;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.NinePatchDrawable;
import android.os.Build;
import com.facebook.common.internal.h;
import com.facebook.drawee.drawable.RoundedCornersDrawable;
import com.facebook.drawee.drawable.g;
import com.facebook.drawee.drawable.j;
import com.facebook.drawee.drawable.k;
import com.facebook.drawee.drawable.l;
import com.facebook.drawee.drawable.n;
import com.facebook.drawee.drawable.o;
import com.facebook.drawee.drawable.p;
import com.facebook.drawee.generic.RoundingParams;
import javax.annotation.Nullable;
/* compiled from: WrappingUtils.java */
/* loaded from: classes.dex */
public class e {
    private static final Drawable a = new ColorDrawable(0);

    private static Drawable a(Drawable drawable, RoundingParams roundingParams, Resources resources) {
        if (drawable instanceof BitmapDrawable) {
            BitmapDrawable bitmapDrawable = (BitmapDrawable) drawable;
            k kVar = new k(resources, bitmapDrawable.getBitmap(), bitmapDrawable.getPaint());
            b(kVar, roundingParams);
            return kVar;
        } else if (drawable instanceof NinePatchDrawable) {
            n nVar = new n((NinePatchDrawable) drawable);
            b(nVar, roundingParams);
            return nVar;
        } else if ((drawable instanceof ColorDrawable) && Build.VERSION.SDK_INT >= 11) {
            l a2 = l.a((ColorDrawable) drawable);
            b(a2, roundingParams);
            return a2;
        } else {
            com.facebook.common.logging.a.z("WrappingUtils", "Don't know how to round that drawable: %s", drawable);
            return drawable;
        }
    }

    static void b(j jVar, RoundingParams roundingParams) {
        jVar.d(roundingParams.i());
        jVar.m(roundingParams.d());
        jVar.c(roundingParams.b(), roundingParams.c());
        jVar.f(roundingParams.g());
        jVar.j(roundingParams.k());
        jVar.i(roundingParams.h());
    }

    static com.facebook.drawee.drawable.c c(com.facebook.drawee.drawable.c cVar) {
        while (true) {
            Drawable b = cVar.b();
            if (b == cVar || !(b instanceof com.facebook.drawee.drawable.c)) {
                break;
            }
            cVar = (com.facebook.drawee.drawable.c) b;
        }
        return cVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static Drawable d(@Nullable Drawable drawable, @Nullable RoundingParams roundingParams, Resources resources) {
        try {
            if (com.facebook.imagepipeline.f.b.d()) {
                com.facebook.imagepipeline.f.b.a("WrappingUtils#maybeApplyLeafRounding");
            }
            if (drawable != null && roundingParams != null && roundingParams.j() == RoundingParams.RoundingMethod.BITMAP_ONLY) {
                if (drawable instanceof g) {
                    com.facebook.drawee.drawable.c c = c((g) drawable);
                    c.a(a(c.a(a), roundingParams, resources));
                    return drawable;
                }
                Drawable a2 = a(drawable, roundingParams, resources);
                if (com.facebook.imagepipeline.f.b.d()) {
                    com.facebook.imagepipeline.f.b.b();
                }
                return a2;
            }
            if (com.facebook.imagepipeline.f.b.d()) {
                com.facebook.imagepipeline.f.b.b();
            }
            return drawable;
        } finally {
            if (com.facebook.imagepipeline.f.b.d()) {
                com.facebook.imagepipeline.f.b.b();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static Drawable e(@Nullable Drawable drawable, @Nullable RoundingParams roundingParams) {
        try {
            if (com.facebook.imagepipeline.f.b.d()) {
                com.facebook.imagepipeline.f.b.a("WrappingUtils#maybeWrapWithRoundedOverlayColor");
            }
            if (drawable != null && roundingParams != null && roundingParams.j() == RoundingParams.RoundingMethod.OVERLAY_COLOR) {
                RoundedCornersDrawable roundedCornersDrawable = new RoundedCornersDrawable(drawable);
                b(roundedCornersDrawable, roundingParams);
                roundedCornersDrawable.r(roundingParams.f());
                return roundedCornersDrawable;
            }
            if (com.facebook.imagepipeline.f.b.d()) {
                com.facebook.imagepipeline.f.b.b();
            }
            return drawable;
        } finally {
            if (com.facebook.imagepipeline.f.b.d()) {
                com.facebook.imagepipeline.f.b.b();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Nullable
    public static Drawable f(@Nullable Drawable drawable, @Nullable p.c cVar) {
        return g(drawable, cVar, null);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Nullable
    public static Drawable g(@Nullable Drawable drawable, @Nullable p.c cVar, @Nullable PointF pointF) {
        if (com.facebook.imagepipeline.f.b.d()) {
            com.facebook.imagepipeline.f.b.a("WrappingUtils#maybeWrapWithScaleType");
        }
        if (drawable != null && cVar != null) {
            o oVar = new o(drawable, cVar);
            if (pointF != null) {
                oVar.u(pointF);
            }
            if (com.facebook.imagepipeline.f.b.d()) {
                com.facebook.imagepipeline.f.b.b();
            }
            return oVar;
        }
        if (com.facebook.imagepipeline.f.b.d()) {
            com.facebook.imagepipeline.f.b.b();
        }
        return drawable;
    }

    static void h(j jVar) {
        jVar.d(false);
        jVar.g(0.0f);
        jVar.c(0, 0.0f);
        jVar.f(0.0f);
        jVar.j(false);
        jVar.i(false);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void i(com.facebook.drawee.drawable.c cVar, @Nullable RoundingParams roundingParams, Resources resources) {
        com.facebook.drawee.drawable.c c = c(cVar);
        Drawable b = c.b();
        if (roundingParams != null && roundingParams.j() == RoundingParams.RoundingMethod.BITMAP_ONLY) {
            if (b instanceof j) {
                b((j) b, roundingParams);
            } else if (b != null) {
                c.a(a);
                c.a(a(b, roundingParams, resources));
            }
        } else if (b instanceof j) {
            h((j) b);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void j(com.facebook.drawee.drawable.c cVar, @Nullable RoundingParams roundingParams) {
        Drawable b = cVar.b();
        if (roundingParams != null && roundingParams.j() == RoundingParams.RoundingMethod.OVERLAY_COLOR) {
            if (b instanceof RoundedCornersDrawable) {
                RoundedCornersDrawable roundedCornersDrawable = (RoundedCornersDrawable) b;
                b(roundedCornersDrawable, roundingParams);
                roundedCornersDrawable.r(roundingParams.f());
                return;
            }
            cVar.a(e(cVar.a(a), roundingParams));
        } else if (b instanceof RoundedCornersDrawable) {
            Drawable drawable = a;
            cVar.a(((RoundedCornersDrawable) b).o(drawable));
            drawable.setCallback(null);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static o k(com.facebook.drawee.drawable.c cVar, p.c cVar2) {
        Drawable f2 = f(cVar.a(a), cVar2);
        cVar.a(f2);
        h.h(f2, "Parent has no child drawable!");
        return (o) f2;
    }
}
