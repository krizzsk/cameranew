package com.facebook.ads.redexgen.X;

import android.content.Context;
import android.os.Build;
import android.os.SystemClock;
import android.view.MotionEvent;
/* renamed from: com.facebook.ads.redexgen.X.6R  reason: invalid class name */
/* loaded from: assets/audience_network.dex */
public final class C6R {
    public static String[] A03 = {"COmePc5O6jQNBThxNrU00eLA0sP62Ofb", "1OlTUJms59QGnZv6uedBszpwZ8CEYVJ", "oD0bBsFyrWHU6", "C7a4pm2tyO8SrXv1cdlxK2sPFdgwB5ae", "g8qGNC4JJd68o", "wdv0nL8gPgDp5YXIgWNDO16SJnt", "h7h0bvqqYit4L8HKMEE", "ho5Id5lQMxy9uaRyjuF"};
    public final Context A00;
    public final C6L A01;
    public final EnumC06396o A02;

    public C6R(Context context, C6L c6l, EnumC06396o enumC06396o) {
        this.A01 = c6l;
        this.A00 = context;
        this.A02 = enumC06396o;
    }

    public final void A00(MotionEvent motionEvent) {
        int i2;
        int i3;
        long elapsedRealtime = SystemClock.elapsedRealtime();
        Context context = this.A00;
        String packageName = context == null ? "" : context.getPackageName();
        EnumC06396o enumC06396o = this.A02;
        EnumC06396o enumC06396o2 = EnumC06396o.A0G;
        if (A03[7].length() != 16) {
            A03[6] = "q52vtyV4o3lWIqbyVHb";
            C06486x c06486x = enumC06396o == enumC06396o2 ? null : new C06486x(packageName);
            float f2 = 1.0f;
            char c = 1;
            switch (motionEvent.getActionMasked()) {
                case 0:
                case 1:
                case 3:
                case 5:
                case 6:
                    int actionIndex = motionEvent.getActionIndex();
                    int pointerId = motionEvent.getPointerId(actionIndex);
                    int pointerId2 = Build.VERSION.SDK_INT;
                    if (pointerId2 >= 14) {
                        i2 = motionEvent.getToolType(actionIndex);
                    } else {
                        i2 = -1;
                    }
                    this.A01.A02(new XZ(elapsedRealtime, c06486x, new C6V(motionEvent.getActionMasked(), pointerId, i2, new float[]{motionEvent.getRawX(), motionEvent.getRawY()}, motionEvent.getSize(actionIndex), Math.min(motionEvent.getPressure(actionIndex), 1.0f), motionEvent.getOrientation(actionIndex))), C6K.A0E);
                    return;
                case 2:
                case 4:
                    int i4 = 0;
                    while (i4 < motionEvent.getPointerCount()) {
                        int pointerId3 = motionEvent.getPointerId(i4);
                        String[] strArr = A03;
                        if (strArr[2].length() != strArr[4].length()) {
                            break;
                        } else {
                            String[] strArr2 = A03;
                            strArr2[1] = "FtxLtPKiBWyCq8d2bMsvLwchXj4m1FL";
                            strArr2[5] = "2ZHjPJSTqIAuT8ks3iUv9R1XL7D";
                            if (Build.VERSION.SDK_INT >= 14) {
                                i3 = motionEvent.getToolType(i4);
                            } else {
                                i3 = -1;
                            }
                            int actionMasked = motionEvent.getActionMasked();
                            float[] fArr = new float[2];
                            fArr[0] = motionEvent.getRawX();
                            fArr[c] = motionEvent.getRawY();
                            this.A01.A02(new XZ(elapsedRealtime, c06486x, new C6V(actionMasked, pointerId3, i3, fArr, motionEvent.getSize(i4), Math.min(motionEvent.getPressure(i4), f2), motionEvent.getOrientation(i4))), C6K.A0E);
                            i4++;
                            f2 = 1.0f;
                            c = 1;
                        }
                    }
                    return;
                default:
                    return;
            }
        }
        throw new RuntimeException();
    }
}
