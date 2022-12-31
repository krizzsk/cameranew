package us.pinguo.facedetector.pinguo;

import us.pinguo.facedetector.ImageMode;
/* loaded from: classes4.dex */
public final /* synthetic */ class a {
    public static final /* synthetic */ int[] a;

    static {
        int[] iArr = new int[ImageMode.values().length];
        a = iArr;
        iArr[ImageMode.RGBA.ordinal()] = 1;
        iArr[ImageMode.RGB.ordinal()] = 2;
        iArr[ImageMode.BGR.ordinal()] = 3;
        iArr[ImageMode.GRAY.ordinal()] = 4;
        iArr[ImageMode.NV21.ordinal()] = 5;
    }
}
