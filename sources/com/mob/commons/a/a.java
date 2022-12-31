package com.mob.commons.a;

import android.os.Handler;
import android.os.Message;
import com.mob.MobSDK;
import com.mob.commons.FBListener;
import com.mob.tools.MobHandlerThread;
import com.mob.tools.MobLog;
import com.mob.tools.log.NLog;
import com.mob.tools.utils.SharePrefrenceHelper;
import java.util.HashMap;
import java.util.Map;
/* compiled from: ActClt.java */
/* loaded from: classes2.dex */
public class a extends d implements Handler.Callback {
    private SharePrefrenceHelper a;
    private FBListener b = null;
    private long c = 0;

    /* renamed from: d  reason: collision with root package name */
    private HashMap<Long, Long> f5858d;

    /* renamed from: e  reason: collision with root package name */
    private boolean f5859e;

    /* renamed from: f  reason: collision with root package name */
    private boolean f5860f;

    /* renamed from: g  reason: collision with root package name */
    private Handler f5861g;

    a() {
        new Thread() { // from class: com.mob.commons.a.a.1
            @Override // java.lang.Thread, java.lang.Runnable
            public void run() {
                a.this.a();
            }
        }.start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void i() {
        try {
            HashMap<String, Object> hashMap = new HashMap<>();
            hashMap.put("type", "PV");
            hashMap.put("datetime", Long.valueOf(com.mob.commons.b.a()));
            com.mob.commons.c.a().a(com.mob.commons.b.a(), hashMap);
        } catch (Throwable th) {
            MobLog.getInstance().w(th);
        }
    }

    private synchronized void j() {
        if (this.a == null) {
            SharePrefrenceHelper sharePrefrenceHelper = new SharePrefrenceHelper(MobSDK.getContext());
            this.a = sharePrefrenceHelper;
            sharePrefrenceHelper.open("top_time");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void k() {
        try {
            if (this.f5858d == null) {
                this.f5858d = new HashMap<>();
            }
            long a = com.mob.commons.b.a();
            NLog mobLog = MobLog.getInstance();
            mobLog.d("[cache] foregndAt: " + this.c + ", duration: " + (a - this.c), new Object[0]);
            this.f5858d.put(Long.valueOf(this.c), Long.valueOf(a));
            a(this.f5858d);
        } catch (Throwable th) {
            MobLog.getInstance().w(th);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void l() {
        try {
            j();
            HashMap<Long, Long> c = c();
            if (c != null && !c.isEmpty()) {
                for (Map.Entry<Long, Long> entry : c.entrySet()) {
                    long longValue = entry.getKey().longValue();
                    long longValue2 = entry.getValue().longValue();
                    long j2 = longValue2 - longValue;
                    NLog mobLog = MobLog.getInstance();
                    mobLog.d("foregndAt: " + longValue + ", until: " + longValue2 + ", runtimes: " + j2, new Object[0]);
                    HashMap<String, Object> hashMap = new HashMap<>();
                    hashMap.put("type", "BACK_INFO");
                    hashMap.put("datetime", Long.valueOf(com.mob.commons.b.a()));
                    HashMap hashMap2 = new HashMap();
                    hashMap2.put("until", Long.valueOf(longValue2));
                    hashMap2.put("runtimes", Long.valueOf(j2));
                    hashMap.put("data", hashMap2);
                    com.mob.commons.c.a().a(com.mob.commons.b.a(), hashMap);
                }
                HashMap<Long, Long> hashMap3 = this.f5858d;
                if (hashMap3 != null) {
                    hashMap3.clear();
                }
                a((HashMap<Long, Long>) null);
            }
        } catch (Throwable th) {
            MobLog.getInstance().w(th);
        }
    }

    @Override // com.mob.commons.a.d
    protected void b() {
        if (this.b != null) {
            m.a().b(this.b);
        }
    }

    public HashMap<Long, Long> c() {
        HashMap<Long, Long> hashMap;
        try {
            j();
            hashMap = (HashMap) this.a.get("key_active_log");
        } catch (Throwable th) {
            MobLog.getInstance().d(th);
            hashMap = null;
        }
        return hashMap == null ? new HashMap<>() : hashMap;
    }

    protected void a() {
        this.f5859e = com.mob.commons.b.p();
        boolean m = com.mob.commons.b.m();
        this.f5860f = m;
        if (this.f5859e || m) {
            this.b = new FBListener() { // from class: com.mob.commons.a.a.2
                @Override // com.mob.commons.FBListener
                public void onFBChanged(boolean z, boolean z2, long j2) {
                    if (z2) {
                        a.this.c = com.mob.commons.b.a();
                        if (a.this.f5859e) {
                            a aVar = a.this;
                            aVar.f5861g = MobHandlerThread.newHandler(aVar);
                            a.this.f5861g.sendEmptyMessage(0);
                        }
                    }
                    if (z) {
                        if (!z2) {
                            a.this.c = com.mob.commons.b.a();
                            a.this.f5861g.sendEmptyMessage(1);
                        }
                        if (a.this.f5860f) {
                            a.this.i();
                        }
                    } else if (!a.this.f5859e || j2 <= 0) {
                    } else {
                        a.this.k();
                        a.this.l();
                        a.this.f5861g.removeMessages(1);
                    }
                }
            };
            m.a().a(this.b);
        }
    }

    @Override // com.mob.commons.a.d
    protected void a(Message message) {
        int i2 = message.what;
        if (i2 == 0) {
            l();
            this.f5861g.sendEmptyMessage(1);
        } else if (i2 != 1) {
        } else {
            k();
            this.f5861g.sendEmptyMessageDelayed(1, com.mob.commons.b.q() * 1000);
        }
    }

    public void a(HashMap<Long, Long> hashMap) {
        j();
        if (hashMap != null && !hashMap.isEmpty()) {
            this.a.put("key_active_log", hashMap);
        } else {
            this.a.remove("key_active_log");
        }
    }
}
