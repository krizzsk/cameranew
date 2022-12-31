package us.pinguo.svideo.utils;

import com.smp.soundtouchandroid.SoundTouch3rd;
/* compiled from: VoiceChangerUtil.java */
/* loaded from: classes6.dex */
public class e {
    private static float a = 1.0f;
    private static float b = 0.0f;
    private static float c = 1.0f;

    private static boolean a() {
        return (a == 1.0f && b == 0.0f && c == 1.0f) ? false : true;
    }

    public static double b() {
        return a * c;
    }

    public static byte[] c(byte[] bArr) {
        if (a()) {
            SoundTouch3rd.a(bArr);
        }
        return bArr;
    }
}
