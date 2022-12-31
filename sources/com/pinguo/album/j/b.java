package com.pinguo.album.j;

import android.annotation.TargetApi;
import android.graphics.Matrix;
import android.view.MotionEvent;
/* compiled from: MotionEventHelper.java */
/* loaded from: classes3.dex */
public final class b {
    private static MotionEvent.PointerCoords[] a(MotionEvent motionEvent) {
        int pointerCount = motionEvent.getPointerCount();
        MotionEvent.PointerCoords[] pointerCoordsArr = new MotionEvent.PointerCoords[pointerCount];
        for (int i2 = 0; i2 < pointerCount; i2++) {
            pointerCoordsArr[i2] = new MotionEvent.PointerCoords();
            motionEvent.getPointerCoords(i2, pointerCoordsArr[i2]);
        }
        return pointerCoordsArr;
    }

    private static int[] b(MotionEvent motionEvent) {
        int pointerCount = motionEvent.getPointerCount();
        int[] iArr = new int[pointerCount];
        for (int i2 = 0; i2 < pointerCount; i2++) {
            iArr[i2] = motionEvent.getPointerId(i2);
        }
        return iArr;
    }

    private static float c(Matrix matrix, float f2) {
        float[] fArr;
        double d2;
        double d3 = f2;
        matrix.mapVectors(new float[]{(float) Math.sin(d3), -((float) Math.cos(d3))});
        float atan2 = (float) Math.atan2(fArr[0], -fArr[1]);
        double d4 = atan2;
        if (d4 < -1.5707963267948966d) {
            d2 = d4 + 3.141592653589793d;
        } else if (d4 <= 1.5707963267948966d) {
            return atan2;
        } else {
            d2 = d4 - 3.141592653589793d;
        }
        return (float) d2;
    }

    public static MotionEvent d(MotionEvent motionEvent, Matrix matrix) {
        if (com.pinguo.album.common.a.f6015d) {
            return e(motionEvent, matrix);
        }
        return f(motionEvent, matrix);
    }

    @TargetApi(11)
    private static MotionEvent e(MotionEvent motionEvent, Matrix matrix) {
        MotionEvent obtain = MotionEvent.obtain(motionEvent);
        obtain.transform(matrix);
        return obtain;
    }

    private static MotionEvent f(MotionEvent motionEvent, Matrix matrix) {
        long downTime = motionEvent.getDownTime();
        long eventTime = motionEvent.getEventTime();
        int action = motionEvent.getAction();
        int pointerCount = motionEvent.getPointerCount();
        int[] b = b(motionEvent);
        MotionEvent.PointerCoords[] a = a(motionEvent);
        int metaState = motionEvent.getMetaState();
        float xPrecision = motionEvent.getXPrecision();
        float yPrecision = motionEvent.getYPrecision();
        int deviceId = motionEvent.getDeviceId();
        int edgeFlags = motionEvent.getEdgeFlags();
        int source = motionEvent.getSource();
        int flags = motionEvent.getFlags();
        float[] fArr = new float[a.length * 2];
        int i2 = 0;
        while (i2 < pointerCount) {
            int i3 = i2 * 2;
            fArr[i3] = a[i2].x;
            fArr[i3 + 1] = a[i2].y;
            i2++;
            edgeFlags = edgeFlags;
        }
        int i4 = edgeFlags;
        matrix.mapPoints(fArr);
        int i5 = 0;
        while (i5 < pointerCount) {
            int i6 = i5 * 2;
            int i7 = deviceId;
            a[i5].x = fArr[i6];
            a[i5].y = fArr[i6 + 1];
            a[i5].orientation = c(matrix, a[i5].orientation);
            i5++;
            deviceId = i7;
        }
        return MotionEvent.obtain(downTime, eventTime, action, pointerCount, b, a, metaState, xPrecision, yPrecision, deviceId, i4, source, flags);
    }
}
