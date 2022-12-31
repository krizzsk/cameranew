package us.pinguo.u3dengine.api;

import kotlin.jvm.internal.s;
/* compiled from: UnityDataObject.kt */
/* loaded from: classes6.dex */
public final class NativeFacesData {
    private NativeFaceDataItem face1;
    private NativeFaceDataItem face2;
    private NativeFaceDataItem face3;
    private int faceCount;
    private float[] pointsPtr = new float[0];
    private float temperature;

    public final NativeFaceDataItem getFace1() {
        return this.face1;
    }

    public final NativeFaceDataItem getFace2() {
        return this.face2;
    }

    public final NativeFaceDataItem getFace3() {
        return this.face3;
    }

    public final int getFaceCount() {
        return this.faceCount;
    }

    public final float[] getPointsPtr() {
        return this.pointsPtr;
    }

    public final float getTemperature() {
        return this.temperature;
    }

    public final void setFace1(NativeFaceDataItem nativeFaceDataItem) {
        this.face1 = nativeFaceDataItem;
    }

    public final void setFace2(NativeFaceDataItem nativeFaceDataItem) {
        this.face2 = nativeFaceDataItem;
    }

    public final void setFace3(NativeFaceDataItem nativeFaceDataItem) {
        this.face3 = nativeFaceDataItem;
    }

    public final void setFaceCount(int i2) {
        this.faceCount = i2;
    }

    public final void setPointsPtr(float[] fArr) {
        s.h(fArr, "<set-?>");
        this.pointsPtr = fArr;
    }

    public final void setTemperature(float f2) {
        this.temperature = f2;
    }
}
