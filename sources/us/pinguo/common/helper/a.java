package us.pinguo.common.helper;

import android.graphics.PointF;
import kotlin.jvm.internal.s;
/* compiled from: GestureHelper.kt */
/* loaded from: classes4.dex */
public final class a {
    public static final a a = new a();

    private a() {
    }

    public final float a(PointF startPoint, PointF endPoint) {
        s.h(startPoint, "startPoint");
        s.h(endPoint, "endPoint");
        return (float) Math.atan2(endPoint.y - startPoint.y, endPoint.x - startPoint.x);
    }

    public final PointF b(PointF startPoint, PointF endPoint) {
        s.h(startPoint, "startPoint");
        s.h(endPoint, "endPoint");
        float f2 = 2;
        return new PointF((startPoint.x + endPoint.x) / f2, (startPoint.y + endPoint.y) / f2);
    }

    public final float c(PointF startPoint, PointF endPoint) {
        s.h(startPoint, "startPoint");
        s.h(endPoint, "endPoint");
        float f2 = startPoint.x;
        float f3 = endPoint.x;
        float f4 = startPoint.y;
        float f5 = endPoint.y;
        return (float) Math.sqrt(((f2 - f3) * (f2 - f3)) + ((f4 - f5) * (f4 - f5)));
    }

    public final boolean d(PointF curPoint, PointF pointLT, PointF pointRT, PointF pointLB, PointF pointRB) {
        float f2;
        float f3;
        s.h(curPoint, "curPoint");
        s.h(pointLT, "pointLT");
        s.h(pointRT, "pointRT");
        s.h(pointLB, "pointLB");
        s.h(pointRB, "pointRB");
        PointF[] pointFArr = {pointLT, pointLB, pointRB, pointRT};
        int i2 = 0;
        int i3 = 0;
        while (i2 < 4) {
            int i4 = i2 + 1;
            PointF pointF = pointFArr[i2];
            PointF pointF2 = pointFArr[i4 % 4];
            float f4 = pointF.y;
            float f5 = pointF2.y;
            if (!(f4 == f5) && curPoint.y >= Math.min(f4, f5) && curPoint.y <= Math.max(pointF.y, pointF2.y)) {
                double d2 = curPoint.y - pointF.y;
                float f6 = pointF2.x;
                if (((d2 * (f6 - f3)) / (pointF2.y - f2)) + pointF.x > curPoint.x) {
                    i3++;
                }
            }
            i2 = i4;
        }
        return i3 % 2 == 1;
    }
}
