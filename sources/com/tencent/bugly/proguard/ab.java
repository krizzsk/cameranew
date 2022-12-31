package com.tencent.bugly.proguard;

import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import androidx.core.location.LocationRequestCompat;
import com.tencent.bugly.crashreport.crash.jni.NativeCrashHandler;
import java.util.ArrayList;
import java.util.List;
/* compiled from: BUGLY */
/* loaded from: classes3.dex */
public final class ab extends Thread {
    private boolean a = false;
    private boolean b = false;
    private List<aa> c = new ArrayList();

    /* renamed from: d  reason: collision with root package name */
    private List<ac> f7922d = new ArrayList();

    /* renamed from: e  reason: collision with root package name */
    private ArrayList<aa> f7923e = new ArrayList<>();

    private int e() {
        int i2 = 0;
        for (int i3 = 0; i3 < this.c.size(); i3++) {
            try {
                i2 = Math.max(i2, this.c.get(i3).c());
            } catch (Exception e2) {
                x.b(e2);
            }
        }
        return i2;
    }

    public final void a() {
        a(new Handler(Looper.getMainLooper()), 5000L);
    }

    public final void b() {
        for (int i2 = 0; i2 < this.c.size(); i2++) {
            try {
                if (this.c.get(i2).d().equals(Looper.getMainLooper().getThread().getName())) {
                    x.c("remove handler::%s", this.c.get(i2));
                    this.c.remove(i2);
                }
            } catch (Exception e2) {
                x.b(e2);
                return;
            }
        }
    }

    public final boolean c() {
        this.a = true;
        if (isAlive()) {
            try {
                interrupt();
            } catch (Exception e2) {
                x.b(e2);
            }
            return true;
        }
        return false;
    }

    public final boolean d() {
        if (isAlive()) {
            return false;
        }
        try {
            start();
            return true;
        } catch (Exception e2) {
            x.b(e2);
            return false;
        }
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public final void run() {
        while (!this.a) {
            for (int i2 = 0; i2 < this.c.size(); i2++) {
                try {
                    this.c.get(i2).a();
                } catch (Exception e2) {
                    x.b(e2);
                } catch (OutOfMemoryError e3) {
                    x.b(e3);
                }
            }
            long uptimeMillis = SystemClock.uptimeMillis();
            for (long j2 = 2000; j2 > 0 && !isInterrupted(); j2 = 2000 - (SystemClock.uptimeMillis() - uptimeMillis)) {
                Thread.sleep(j2);
            }
            int e4 = e();
            if (e4 != 0 && e4 != 1) {
                this.f7923e.clear();
                for (int i3 = 0; i3 < this.c.size(); i3++) {
                    aa aaVar = this.c.get(i3);
                    if (aaVar.b()) {
                        this.f7923e.add(aaVar);
                        aaVar.a(LocationRequestCompat.PASSIVE_INTERVAL);
                    }
                }
                NativeCrashHandler nativeCrashHandler = NativeCrashHandler.getInstance();
                if (nativeCrashHandler != null && nativeCrashHandler.isEnableCatchAnrTrace()) {
                    nativeCrashHandler.dumpAnrNativeStack();
                    x.c("jni mannual dump anr trace", new Object[0]);
                } else {
                    x.c("do not enable jni mannual dump anr trace", new Object[0]);
                }
                int i4 = 0;
                while (true) {
                    if (this.b) {
                        break;
                    }
                    x.c("do not enable anr continue check", new Object[0]);
                    Thread.sleep(2000L);
                    i4++;
                    if (i4 == 15) {
                        this.f7923e.clear();
                        break;
                    }
                }
                for (int i5 = 0; i5 < this.f7923e.size(); i5++) {
                    aa aaVar2 = this.f7923e.get(i5);
                    for (int i6 = 0; i6 < this.f7922d.size(); i6++) {
                        x.e("main thread blocked,now begin to upload anr stack", new Object[0]);
                        this.f7922d.get(i6).a(aaVar2);
                        this.b = false;
                    }
                }
            }
        }
    }

    private void a(Handler handler, long j2) {
        if (handler == null) {
            x.e("addThread handler should not be null", new Object[0]);
            return;
        }
        String name = handler.getLooper().getThread().getName();
        for (int i2 = 0; i2 < this.c.size(); i2++) {
            try {
                if (this.c.get(i2).d().equals(handler.getLooper().getThread().getName())) {
                    x.e("addThread fail ,this thread has been added in monitor queue", new Object[0]);
                    return;
                }
            } catch (Exception e2) {
                x.b(e2);
            }
        }
        this.c.add(new aa(handler, name, 5000L));
    }

    public final void b(ac acVar) {
        this.f7922d.remove(acVar);
    }

    public final void a(ac acVar) {
        if (this.f7922d.contains(acVar)) {
            x.c("addThreadMonitorListeners fail ,this threadMonitorListener has been added in monitor queue", new Object[0]);
        } else {
            this.f7922d.add(acVar);
        }
    }

    public final void a(boolean z) {
        this.b = true;
    }
}
