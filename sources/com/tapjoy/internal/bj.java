package com.tapjoy.internal;

import android.graphics.Point;
import android.graphics.Rect;
import com.tapjoy.TJAdUnitConstants;
/* loaded from: classes3.dex */
public final class bj {
    public static final bi a = new bi() { // from class: com.tapjoy.internal.bj.1
        @Override // com.tapjoy.internal.bi
        public final /* synthetic */ Object a(bn bnVar) {
            Point point = new Point();
            bnVar.h();
            while (bnVar.j()) {
                String l2 = bnVar.l();
                if ("x".equals(l2)) {
                    point.x = bnVar.r();
                } else if ("y".equals(l2)) {
                    point.y = bnVar.r();
                } else {
                    bnVar.s();
                }
            }
            bnVar.i();
            return point;
        }
    };
    public static final bi b = new bi() { // from class: com.tapjoy.internal.bj.2
        @Override // com.tapjoy.internal.bi
        public final /* synthetic */ Object a(bn bnVar) {
            Rect rect = new Rect();
            int i2 = AnonymousClass3.a[bnVar.k().ordinal()];
            if (i2 == 1) {
                bnVar.f();
                rect.left = bnVar.r();
                rect.top = bnVar.r();
                rect.right = bnVar.r();
                rect.bottom = bnVar.r();
                while (bnVar.j()) {
                    bnVar.s();
                }
                bnVar.g();
            } else if (i2 == 2) {
                bnVar.h();
                while (bnVar.j()) {
                    String l2 = bnVar.l();
                    if (TJAdUnitConstants.String.LEFT.equals(l2)) {
                        rect.left = bnVar.r();
                    } else if (TJAdUnitConstants.String.TOP.equals(l2)) {
                        rect.top = bnVar.r();
                    } else if (TJAdUnitConstants.String.RIGHT.equals(l2)) {
                        rect.right = bnVar.r();
                    } else if (TJAdUnitConstants.String.BOTTOM.equals(l2)) {
                        rect.bottom = bnVar.r();
                    } else {
                        bnVar.s();
                    }
                }
                bnVar.i();
            } else {
                throw new IllegalStateException("Unexpected token: " + bnVar.k());
            }
            return rect;
        }
    };

    /* renamed from: com.tapjoy.internal.bj$3  reason: invalid class name */
    /* loaded from: classes3.dex */
    static /* synthetic */ class AnonymousClass3 {
        static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[bs.values().length];
            a = iArr;
            try {
                iArr[bs.BEGIN_ARRAY.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                a[bs.BEGIN_OBJECT.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }
}
