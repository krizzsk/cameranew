package us.pinguo.repository2020.utils;

import android.graphics.Rect;
import java.util.Arrays;
import kotlin.jvm.internal.s;
import us.pinguo.u3dengine.api.NativeFaceDataItem;
import us.pinguo.u3dengine.api.NativeFacesData;
/* compiled from: FaceDetectorExtensions.kt */
/* loaded from: classes6.dex */
public final class i {
    private static final us.pinguo.facedetector.b a(us.pinguo.facedetector.b bVar) {
        int d2 = bVar.d();
        Rect rect = new Rect(bVar.g().left, bVar.g().top, bVar.g().right, bVar.g().bottom);
        float[] f2 = bVar.f();
        float[] copyOf = Arrays.copyOf(f2, f2.length);
        s.g(copyOf, "copyOf(this, size)");
        return new us.pinguo.facedetector.b(d2, rect, copyOf, bVar.e(), bVar.i(), bVar.h());
    }

    public static final us.pinguo.facedetector.c b(us.pinguo.facedetector.c cVar) {
        s.h(cVar, "<this>");
        int length = cVar.d().length;
        us.pinguo.facedetector.b[] bVarArr = new us.pinguo.facedetector.b[length];
        for (int i2 = 0; i2 < length; i2++) {
            bVarArr[i2] = a(cVar.d()[i2]);
        }
        return new us.pinguo.facedetector.c(bVarArr, cVar.f(), cVar.e());
    }

    private static final NativeFaceDataItem c(us.pinguo.facedetector.b bVar, boolean z) {
        NativeFaceDataItem nativeFaceDataItem = new NativeFaceDataItem();
        nativeFaceDataItem.setFaceID(bVar.d());
        nativeFaceDataItem.setPitch(bVar.e());
        if (z) {
            nativeFaceDataItem.setYaw(-bVar.i());
            nativeFaceDataItem.setRoll(-((float) (bVar.h() + 1.5707963267948966d)));
        } else {
            nativeFaceDataItem.setYaw(bVar.i());
            nativeFaceDataItem.setRoll((float) (bVar.h() + 4.71238898038469d));
        }
        return nativeFaceDataItem;
    }

    public static final NativeFacesData d(us.pinguo.facedetector.c cVar, boolean z, boolean z2) {
        s.h(cVar, "<this>");
        NativeFacesData nativeFacesData = new NativeFacesData();
        float[] fArr = new float[cVar.c() * 106 * 2];
        int f2 = z2 ? cVar.f() : cVar.e();
        int e2 = z2 ? cVar.e() : cVar.f();
        us.pinguo.facedetector.b[] d2 = cVar.d();
        int length = d2.length;
        int i2 = 0;
        int i3 = 0;
        while (i2 < length) {
            us.pinguo.facedetector.b bVar = d2[i2];
            i2++;
            int i4 = i3 + 1;
            float[] f3 = bVar.f();
            int length2 = f3.length;
            int i5 = 0;
            int i6 = 0;
            while (i5 < length2) {
                float f4 = f3[i5];
                i5++;
                int i7 = i6 + 1;
                if (i6 % 2 == 0) {
                    fArr[(i3 * 106 * 2) + i6] = f4 / f2;
                } else {
                    fArr[(i3 * 106 * 2) + i6] = f4 / e2;
                }
                i6 = i7;
            }
            i3 = i4;
        }
        nativeFacesData.setFaceCount(cVar.c());
        nativeFacesData.setPointsPtr(fArr);
        if (cVar.c() == 1) {
            nativeFacesData.setFace1(c(cVar.d()[0], z));
        } else if (cVar.c() == 2) {
            nativeFacesData.setFace1(c(cVar.d()[0], z));
            nativeFacesData.setFace2(c(cVar.d()[1], z));
        } else if (cVar.c() >= 3) {
            nativeFacesData.setFace1(c(cVar.d()[0], z));
            nativeFacesData.setFace2(c(cVar.d()[1], z));
            nativeFacesData.setFace3(c(cVar.d()[2], z));
        }
        return nativeFacesData;
    }

    public static /* synthetic */ NativeFacesData e(us.pinguo.facedetector.c cVar, boolean z, boolean z2, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            z2 = false;
        }
        return d(cVar, z, z2);
    }
}
