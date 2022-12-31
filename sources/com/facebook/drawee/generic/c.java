package com.facebook.drawee.generic;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import com.facebook.drawee.drawable.p;
import javax.annotation.Nullable;
/* compiled from: GenericDraweeHierarchyInflater.java */
/* loaded from: classes.dex */
public class c {
    @Nullable
    private static Drawable a(Context context, TypedArray typedArray, int i2) {
        int resourceId = typedArray.getResourceId(i2, 0);
        if (resourceId == 0) {
            return null;
        }
        return context.getResources().getDrawable(resourceId);
    }

    private static RoundingParams b(b bVar) {
        if (bVar.s() == null) {
            bVar.L(new RoundingParams());
        }
        return bVar.s();
    }

    @Nullable
    private static p.c c(TypedArray typedArray, int i2) {
        switch (typedArray.getInt(i2, -2)) {
            case -1:
                return null;
            case 0:
                return p.c.a;
            case 1:
                return p.c.b;
            case 2:
                return p.c.c;
            case 3:
                return p.c.f2563d;
            case 4:
                return p.c.f2564e;
            case 5:
                return p.c.f2565f;
            case 6:
                return p.c.f2566g;
            case 7:
                return p.c.f2567h;
            case 8:
                return p.c.f2568i;
            default:
                throw new RuntimeException("XML attribute not specified!");
        }
    }

    public static b d(Context context, @Nullable AttributeSet attributeSet) {
        if (com.facebook.imagepipeline.f.b.d()) {
            com.facebook.imagepipeline.f.b.a("GenericDraweeHierarchyBuilder#inflateBuilder");
        }
        b bVar = new b(context.getResources());
        e(bVar, context, attributeSet);
        if (com.facebook.imagepipeline.f.b.d()) {
            com.facebook.imagepipeline.f.b.b();
        }
        return bVar;
    }

    /* JADX WARN: Code restructure failed: missing block: B:117:0x01cb, code lost:
        if (r14 != false) goto L124;
     */
    /* JADX WARN: Code restructure failed: missing block: B:132:0x01e5, code lost:
        if (r5 != false) goto L124;
     */
    /* JADX WARN: Code restructure failed: missing block: B:133:0x01e7, code lost:
        r4 = true;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static com.facebook.drawee.generic.b e(com.facebook.drawee.generic.b r18, android.content.Context r19, @javax.annotation.Nullable android.util.AttributeSet r20) {
        /*
            Method dump skipped, instructions count: 585
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.drawee.generic.c.e(com.facebook.drawee.generic.b, android.content.Context, android.util.AttributeSet):com.facebook.drawee.generic.b");
    }
}
