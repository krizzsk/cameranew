package net.surina.soundtouch;
/* loaded from: classes3.dex */
public final class SoundTouch {
    long a;

    static {
        System.loadLibrary("soundtouch");
        System.loadLibrary("soundtouchmain");
    }

    public SoundTouch() {
        this.a = 0L;
        this.a = newInstance();
    }

    private final native void deleteInstance(long j2);

    public static final native String getErrorString();

    public static final native String getVersionString();

    private static final native long newInstance();

    private final native int processFile(long j2, String str, String str2);

    private final native void setPitchSemiTones(long j2, float f2);

    private final native void setSpeed(long j2, float f2);

    private final native void setTempo(long j2, float f2);

    public int a(String str, String str2) {
        return processFile(this.a, str, str2);
    }

    public void b(float f2) {
        setTempo(this.a, f2);
    }
}
