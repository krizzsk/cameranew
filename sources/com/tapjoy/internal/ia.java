package com.tapjoy.internal;

import android.graphics.PointF;
import com.tapjoy.TJAdUnitConstants;
import java.util.ArrayList;
/* loaded from: classes3.dex */
public final class ia {

    /* renamed from: d  reason: collision with root package name */
    public static final bi f7666d = new bi() { // from class: com.tapjoy.internal.ia.1
        @Override // com.tapjoy.internal.bi
        public final /* synthetic */ Object a(bn bnVar) {
            return new ia(bnVar);
        }
    };
    public aa a;
    public PointF b;
    public ArrayList c = new ArrayList();

    public ia(bn bnVar) {
        this.a = aa.a;
        bnVar.h();
        while (bnVar.j()) {
            String l2 = bnVar.l();
            if (TJAdUnitConstants.String.BUTTONS.equals(l2)) {
                if (bnVar.k() == bs.BEGIN_ARRAY) {
                    bnVar.a(this.c, hz.n);
                } else {
                    bnVar.s();
                }
            } else if ("window_aspect_ratio".equals(l2)) {
                if (bnVar.a()) {
                    PointF pointF = new PointF();
                    bnVar.h();
                    while (bnVar.j()) {
                        String l3 = bnVar.l();
                        if ("width".equals(l3)) {
                            pointF.x = (float) bnVar.p();
                        } else if ("height".equals(l3)) {
                            pointF.y = (float) bnVar.p();
                        } else {
                            bnVar.s();
                        }
                    }
                    bnVar.i();
                    if (pointF.x != 0.0f && pointF.y != 0.0f) {
                        this.b = pointF;
                    }
                } else {
                    bnVar.s();
                }
            } else if ("orientation".equals(l2)) {
                String m = bnVar.m();
                if (TJAdUnitConstants.String.LANDSCAPE.equals(m)) {
                    this.a = aa.c;
                } else if (TJAdUnitConstants.String.PORTRAIT.equals(m)) {
                    this.a = aa.b;
                }
            } else {
                bnVar.s();
            }
        }
        bnVar.i();
    }
}
