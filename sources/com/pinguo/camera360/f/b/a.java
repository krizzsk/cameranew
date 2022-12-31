package com.pinguo.camera360.f.b;

import android.app.NotificationManager;
import android.content.Context;
import android.media.AudioManager;
import android.media.SoundPool;
import android.os.Build;
import com.tencent.bugly.crashreport.CrashReport;
import us.pinguo.foundation.f;
import us.pinguo.librouter.application.BaseApplication;
import vStudio.Android.Camera360.R;
/* compiled from: SoundManager.java */
/* loaded from: classes3.dex */
public final class a {

    /* renamed from: f  reason: collision with root package name */
    private static final String f6285f = "com.pinguo.camera360.f.b.a";

    /* renamed from: g  reason: collision with root package name */
    private static a f6286g;
    private AudioManager a;
    private int b;
    private int c;

    /* renamed from: d  reason: collision with root package name */
    private SoundPool f6287d;

    /* renamed from: e  reason: collision with root package name */
    private NotificationManager f6288e;

    private a(Context context) {
        this.f6288e = null;
        AudioManager audioManager = (AudioManager) context.getApplicationContext().getSystemService("audio");
        this.a = audioManager;
        int a = a(audioManager.getRingerMode());
        this.b = a;
        this.c = a;
        SoundPool soundPool = new SoundPool(1, 3, 100);
        this.f6287d = soundPool;
        try {
            soundPool.load(context, R.raw.timer, 0);
        } catch (Throwable th) {
            CrashReport.postCatchedException(new RuntimeException("error load raw wav files", th));
        }
        try {
            this.f6287d.load(context, R.raw.focusbeep, 0);
            this.f6287d.load(context, R.raw.staged_shot_complete, 0);
        } catch (Throwable th2) {
            CrashReport.postCatchedException(new RuntimeException("error load raw ogg files", th2));
        }
        this.f6288e = (NotificationManager) context.getSystemService("notification");
    }

    private int a(int i2) {
        int i3 = this.b;
        if (i2 != 0) {
            if (i2 != 1) {
                if (i2 != 2) {
                    return i3;
                }
                return 2;
            }
            return 1;
        }
        return 0;
    }

    private int b(int i2) {
        int ringerMode = this.a.getRingerMode();
        if (i2 != 0) {
            if (i2 != 1) {
                if (i2 != 2) {
                    return ringerMode;
                }
                return 2;
            }
            return 1;
        }
        return 0;
    }

    public static synchronized a c() {
        a aVar;
        synchronized (a.class) {
            if (f6286g == null) {
                f6286g = new a(BaseApplication.d());
            }
            a aVar2 = f6286g;
            if (aVar2.f6287d == null) {
                aVar2.f6287d = new SoundPool(1, 3, 100);
            }
            aVar = f6286g;
        }
        return aVar;
    }

    public void d() {
        String str = f6285f;
        us.pinguo.common.log.a.m(str, "restoreSysRingerMode sysRingerMode = " + this.c, new Object[0]);
        e(this.c);
    }

    public void e(int i2) {
        if (Build.VERSION.SDK_INT < 23 || this.f6288e.isNotificationPolicyAccessGranted()) {
            int b = b(i2);
            String str = f6285f;
            us.pinguo.common.log.a.m(str, "setRingerMode sysMode = " + b, new Object[0]);
            if (!f.x) {
                this.a.setRingerMode(b);
            } else if (b != 0) {
                this.a.setRingerMode(b);
            }
            this.b = i2;
        }
    }
}
