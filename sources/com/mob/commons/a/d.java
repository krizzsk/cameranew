package com.mob.commons.a;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.Process;
import com.mob.commons.LockAction;
import com.mob.tools.MobHandlerThread;
import com.mob.tools.MobLog;
import com.mob.tools.log.NLog;
import com.mob.tools.utils.FileLocker;
import java.io.File;
import java.util.HashMap;
/* compiled from: BaseClt.java */
/* loaded from: classes2.dex */
public class d implements Handler.Callback {
    private static HashMap<String, d> c = new HashMap<>();

    /* renamed from: d  reason: collision with root package name */
    private static HashMap<String, Object> f5862d = new HashMap<>();
    private MobHandlerThread a;
    private boolean b = false;

    /* renamed from: e  reason: collision with root package name */
    private Handler f5863e;

    protected void a(Message message) {
    }

    protected void b() {
    }

    final void d() {
        try {
            Handler handler = this.f5863e;
            if (handler != null) {
                handler.removeCallbacksAndMessages(null);
            }
            MobHandlerThread mobHandlerThread = this.a;
            if (mobHandlerThread != null) {
                mobHandlerThread.quit();
            }
            this.f5863e = null;
            this.a = null;
        } catch (Throwable th) {
            MobLog.getInstance().d(th);
        }
        b();
        this.b = true;
        c.put(getClass().getSimpleName(), null);
    }

    protected File e() {
        return null;
    }

    protected boolean f() {
        return true;
    }

    protected void g() {
    }

    @Override // android.os.Handler.Callback
    public final boolean handleMessage(Message message) {
        if (com.mob.commons.b.u()) {
            d();
            return false;
        }
        a(message);
        return false;
    }

    public static final synchronized void a(Class<? extends d>... clsArr) {
        synchronized (d.class) {
            if (clsArr != null) {
                if (clsArr.length != 0) {
                    for (Class<? extends d> cls : clsArr) {
                        if (cls != null) {
                            String simpleName = cls.getSimpleName();
                            if (c.get(simpleName) == null) {
                                d newInstance = cls.newInstance();
                                c.put(simpleName, newInstance);
                                newInstance.a();
                            }
                        }
                    }
                }
            }
        }
    }

    private void a() {
        final File e2 = e();
        if (e2 == null) {
            return;
        }
        MobHandlerThread mobHandlerThread = new MobHandlerThread() { // from class: com.mob.commons.a.d.1
            @Override // com.mob.tools.MobHandlerThread
            protected void onLooperPrepared(Looper looper) {
                try {
                    d.this.f5863e = new Handler(looper, d.this);
                    d.this.g();
                } catch (Throwable th) {
                    MobLog.getInstance().d(th);
                }
            }

            @Override // com.mob.tools.MobHandlerThread, java.lang.Thread, java.lang.Runnable
            public void run() {
                try {
                    if (com.mob.commons.d.a(e2, new LockAction() { // from class: com.mob.commons.a.d.1.1
                        @Override // com.mob.commons.LockAction
                        public boolean run(FileLocker fileLocker) {
                            try {
                                NLog mobLog = MobLog.getInstance();
                                mobLog.d("synchronizeProcess success clt: " + d.this.getClass().getSimpleName() + ", file: " + e2.getPath() + ", pid: " + Process.myPid() + ", isStop: " + d.this.b, new Object[0]);
                                if (!d.this.b) {
                                    boolean F = com.mob.commons.b.F();
                                    boolean f2 = d.this.f();
                                    NLog mobLog2 = MobLog.getInstance();
                                    mobLog2.d("Clt entrance. forb: " + F + ", coll: " + f2, new Object[0]);
                                    if (!F && f2) {
                                        a();
                                    }
                                }
                            } catch (Throwable th) {
                                MobLog.getInstance().d(th);
                            }
                            return false;
                        }
                    })) {
                        return;
                    }
                    NLog mobLog = MobLog.getInstance();
                    mobLog.w("synchronizeProcess failed clt: " + d.this.getClass().getSimpleName() + ", file: " + e2.getPath());
                    d.c.put(getClass().getSimpleName(), null);
                } catch (Throwable th) {
                    MobLog.getInstance().d(th);
                }
            }

            /* JADX INFO: Access modifiers changed from: private */
            public void a() {
                super.run();
            }
        };
        this.a = mobHandlerThread;
        mobHandlerThread.start();
    }
}
