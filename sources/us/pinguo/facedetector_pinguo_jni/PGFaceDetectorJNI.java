package us.pinguo.facedetector_pinguo_jni;
/* compiled from: PGFaceDetectorJNI.kt */
/* loaded from: classes4.dex */
public final class PGFaceDetectorJNI {
    static {
        System.loadLibrary("pg_face_detector");
    }

    public final native boolean nativeClear(long j2);

    public final native long nativeCreateHandler();

    public final native boolean nativeInit(long j2, int i2, float f2, float f3, String str, String str2, String str3);

    public final native boolean nativeRewindTrackingState(long j2);

    public final native float[] nativeRun(long j2, int i2, byte[] bArr, int i3, int i4, int i5, int i6, boolean z);

    public final native boolean nativeWaitDetectionFinish(long j2);
}
