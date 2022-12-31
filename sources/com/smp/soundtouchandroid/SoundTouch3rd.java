package com.smp.soundtouchandroid;
/* loaded from: classes3.dex */
public class SoundTouch3rd {
    static {
        System.loadLibrary("soundtouch3rd");
        System.loadLibrary("soundtouchmain");
        setup(0, 2, 1, 2, 1.0f, 1.0f);
    }

    private SoundTouch3rd() {
    }

    public static byte[] a(byte[] bArr) {
        putBytes(0, bArr, bArr.length);
        getBytes(0, bArr, bArr.length);
        return bArr;
    }

    private static final native synchronized void clearBytes(int i2);

    private static final native synchronized void finish(int i2, int i3);

    private static final native synchronized int getBytes(int i2, byte[] bArr, int i3);

    private static final native synchronized long getOutputBufferSize(int i2);

    private static final native synchronized void putBytes(int i2, byte[] bArr, int i3);

    private static final native synchronized void setPitchSemi(int i2, float f2);

    private static final native synchronized void setRate(int i2, float f2);

    private static final native synchronized void setRateChange(int i2, float f2);

    private static final native synchronized void setSpeech(int i2, boolean z);

    private static final native synchronized void setTempo(int i2, float f2);

    private static final native synchronized void setTempoChange(int i2, float f2);

    private static final native synchronized void setup(int i2, int i3, int i4, int i5, float f2, float f3);
}
