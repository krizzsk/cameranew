package us.pinguo.camera2020.view;

import android.media.SoundPool;
import us.pinguo.camera2020.R;
/* compiled from: CameraSoundManager.kt */
/* loaded from: classes3.dex */
public final class l2 {
    public static final l2 a = new l2();
    private static SoundPool b = null;
    private static int c = 0;

    /* renamed from: d  reason: collision with root package name */
    private static int f9434d = 0;

    /* renamed from: e  reason: collision with root package name */
    private static int f9435e = 0;

    /* renamed from: f  reason: collision with root package name */
    private static int f9436f = 0;

    /* renamed from: g  reason: collision with root package name */
    private static boolean f9437g = true;

    /* renamed from: h  reason: collision with root package name */
    private static boolean f9438h;

    private l2() {
    }

    private final void c() {
        if (b != null) {
            return;
        }
        SoundPool soundPool = new SoundPool(1, 3, 100);
        f9434d = i(soundPool, R.raw.timer);
        c = i(soundPool, R.raw.focusbeep);
        f9435e = i(soundPool, R.raw.shut);
        f9436f = i(soundPool, R.raw.mutecamera);
        b = soundPool;
    }

    private final void d(int i2) {
        SoundPool soundPool;
        if (i2 == 0 || (soundPool = b) == null) {
            return;
        }
        soundPool.play(i2, 1.0f, 1.0f, 0, 0, 1.0f);
    }

    private final int i(SoundPool soundPool, int i2) {
        try {
            return soundPool.load(us.pinguo.util.v.a(), i2, 0);
        } catch (Throwable unused) {
            return 0;
        }
    }

    public final boolean a() {
        return f9438h;
    }

    public final void b(boolean z) {
        k(z);
        if (z) {
            return;
        }
        c();
    }

    public final void e() {
        if (f9438h || !f9437g) {
            return;
        }
        d(c);
    }

    public final void f() {
        if (f9438h) {
            if (us.pinguo.camera2020.utils.b.a.a()) {
                d(f9436f);
                return;
            }
            return;
        }
        d(f9435e);
    }

    public final void g() {
        if (f9438h) {
            return;
        }
        d(f9434d);
    }

    public final void h() {
        SoundPool soundPool = b;
        if (soundPool != null) {
            soundPool.release();
        }
        b = null;
    }

    public final void j(boolean z) {
        f9437g = z;
    }

    public final void k(boolean z) {
        f9438h = z;
        c();
    }
}
