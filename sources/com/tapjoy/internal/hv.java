package com.tapjoy.internal;

import android.graphics.Point;
import com.tapjoy.TJAdUnitConstants;
import java.net.URL;
import us.pinguo.inspire.api.QiniuAuthToken;
/* loaded from: classes3.dex */
public final class hv {

    /* renamed from: d  reason: collision with root package name */
    public static final bi f7651d = new bi() { // from class: com.tapjoy.internal.hv.1
        private static Point b(bn bnVar) {
            bnVar.h();
            Point point = null;
            while (bnVar.j()) {
                if ("offset".equals(bnVar.l())) {
                    bnVar.h();
                    int i2 = 0;
                    int i3 = 0;
                    while (bnVar.j()) {
                        String l2 = bnVar.l();
                        if ("x".equals(l2)) {
                            i2 = bnVar.r();
                        } else if ("y".equals(l2)) {
                            i3 = bnVar.r();
                        } else {
                            bnVar.s();
                        }
                    }
                    bnVar.i();
                    point = new Point(i2, i3);
                } else {
                    bnVar.s();
                }
            }
            bnVar.i();
            return point;
        }

        @Override // com.tapjoy.internal.bi
        public final /* synthetic */ Object a(bn bnVar) {
            bnVar.h();
            hx hxVar = null;
            Point point = null;
            Point point2 = null;
            while (bnVar.j()) {
                String l2 = bnVar.l();
                if (QiniuAuthToken.TYPE_IMAGE.equals(l2)) {
                    String m = bnVar.m();
                    if (!jq.c(m)) {
                        hxVar = new hx(new URL(m));
                    }
                } else if (TJAdUnitConstants.String.LANDSCAPE.equals(l2)) {
                    point = b(bnVar);
                } else if (TJAdUnitConstants.String.PORTRAIT.equals(l2)) {
                    point2 = b(bnVar);
                } else {
                    bnVar.s();
                }
            }
            bnVar.i();
            return new hv(hxVar, point, point2);
        }
    };
    public final hx a;
    public final Point b;
    public final Point c;

    public hv(hx hxVar, Point point, Point point2) {
        this.a = hxVar;
        this.b = point;
        this.c = point2;
    }
}
