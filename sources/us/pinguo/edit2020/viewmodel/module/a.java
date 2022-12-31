package us.pinguo.edit2020.viewmodel.module;

import android.graphics.Bitmap;
import android.graphics.PointF;
import android.graphics.Rect;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.List;
import kotlin.jvm.b.l;
import kotlin.jvm.internal.s;
import kotlin.u;
import us.pinguo.edit2020.bean.x;
import us.pinguo.edit2020.bean.y;
/* compiled from: AIEditImageRestorationModule.kt */
/* loaded from: classes4.dex */
public final class a {
    private us.pinguo.facedetector.c c;

    /* renamed from: e  reason: collision with root package name */
    private l<? super Boolean, u> f10883e;
    private String a = "";
    private String b = "";

    /* renamed from: d  reason: collision with root package name */
    private float f10882d = 0.5f;

    public final l<Boolean, u> a() {
        return this.f10883e;
    }

    public final String b() {
        return this.a;
    }

    public final Bitmap c(Bitmap bitmap, Rect rect) {
        s.h(rect, "rect");
        Bitmap bitmap2 = null;
        if (bitmap == null) {
            return null;
        }
        int width = rect.width();
        int height = rect.height();
        if (bitmap.getWidth() >= rect.left && bitmap.getWidth() >= rect.left + width && bitmap.getHeight() >= rect.top && bitmap.getHeight() >= rect.top + height && width > 0 && height > 0) {
            bitmap2 = Bitmap.createBitmap(width, height, Bitmap.Config.ARGB_8888);
            byte[] bArr = new byte[width * height * 4];
            int max = Math.max(0, rect.top);
            int max2 = Math.max(0, rect.left);
            int i2 = rect.top + height;
            while (max < i2) {
                int i3 = max + 1;
                int i4 = rect.left + width;
                int i5 = max2;
                while (i5 < i4) {
                    int i6 = i5 + 1;
                    int i7 = ((max - rect.top) * width) + (i5 - rect.left);
                    int pixel = bitmap.getPixel(i5, max);
                    int i8 = i7 * 4;
                    bArr[i8 + 0] = (byte) ((16711680 & pixel) >> 16);
                    bArr[i8 + 1] = (byte) ((65280 & pixel) >> 8);
                    bArr[i8 + 2] = (byte) (pixel & 255);
                    bArr[i8 + 3] = (byte) 255;
                    i5 = i6;
                }
                max = i3;
            }
            bitmap2.copyPixelsFromBuffer(ByteBuffer.wrap(bArr));
        }
        return bitmap2;
    }

    public final List<List<PointF>> d(us.pinguo.facedetector.c cVar) {
        us.pinguo.facedetector.b[] d2;
        if (cVar == null || !cVar.h()) {
            return null;
        }
        Integer[] numArr = {74, 77, 46, 84, 90};
        ArrayList arrayList = new ArrayList();
        for (us.pinguo.facedetector.b bVar : cVar.d()) {
            ArrayList arrayList2 = new ArrayList();
            for (int i2 = 0; i2 < 5; i2++) {
                int intValue = numArr[i2].intValue();
                PointF pointF = new PointF();
                pointF.x = bVar.l(intValue);
                pointF.y = bVar.m(intValue);
                arrayList2.add(pointF);
            }
            arrayList.add(arrayList2);
        }
        return arrayList;
    }

    public final us.pinguo.facedetector.c e() {
        return this.c;
    }

    public final String f() {
        return this.b;
    }

    public final float g() {
        return this.f10882d;
    }

    public final List<x> h() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(new y());
        return arrayList;
    }

    public final void i(l<? super Boolean, u> lVar) {
        this.f10883e = lVar;
    }

    public final void j(String str) {
        s.h(str, "<set-?>");
        this.a = str;
    }

    public final void k(us.pinguo.facedetector.c cVar) {
        this.c = cVar;
    }

    public final void l(String str) {
        s.h(str, "<set-?>");
        this.b = str;
    }

    public final void m(float f2) {
        this.f10882d = f2;
    }
}
