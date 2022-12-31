package us.pinguo.poker;

import android.os.Handler;
import android.os.SystemClock;
import android.util.Log;
import androidx.annotation.Nullable;
import com.google.firebase.crashlytics.internal.common.IdManager;
import java.io.File;
import java.io.IOException;
import us.pinguo.util.v;
/* compiled from: PokerTask.java */
/* loaded from: classes5.dex */
public class t extends Thread {
    private Handler a;
    private n b;
    private m c;

    /* renamed from: d  reason: collision with root package name */
    private u f11750d;

    /* renamed from: e  reason: collision with root package name */
    private l f11751e;

    public t(m mVar) {
        this.f11751e = null;
        this.c = mVar;
        this.f11751e = null;
    }

    private void d(j jVar, s sVar, String str) {
        us.pinguo.common.log.a.g("Poker", "3.", new Object[0]);
        if (!us.pinguo.util.q.f(v.a())) {
            m(this.b, 2, "no net");
            return;
        }
        l lVar = this.f11751e;
        if (lVar != null) {
            l(lVar);
            return;
        }
        us.pinguo.common.log.a.g("Poker", "3.3", new Object[0]);
        if (jVar == null) {
            us.pinguo.common.log.a.g("Poker", "4.", new Object[0]);
            try {
                jVar = p.a();
                l lVar2 = this.f11751e;
                if (lVar2 != null) {
                    l(lVar2);
                    return;
                }
                us.pinguo.common.log.a.g("Poker", "4.4", new Object[0]);
            } catch (Exception e2) {
                m(this.b, 3, Log.getStackTraceString(e2));
                return;
            }
        }
        us.pinguo.common.log.a.g("Poker", "5.", new Object[0]);
        try {
            if (!this.f11750d.b(sVar.a)) {
                p.j(sVar, jVar);
                this.f11750d.c(sVar.a);
            }
            l lVar3 = this.f11751e;
            if (lVar3 != null) {
                l(lVar3);
                return;
            }
            us.pinguo.common.log.a.g("Poker", "5.5", new Object[0]);
            us.pinguo.common.log.a.g("Poker", "6.", new Object[0]);
            try {
                q b = p.b(jVar.f11740e + "/api/art/create", this.c.f11743d, sVar.a);
                l lVar4 = this.f11751e;
                if (lVar4 != null) {
                    l(lVar4);
                    return;
                }
                us.pinguo.common.log.a.g("Poker", "6.6", new Object[0]);
                us.pinguo.common.log.a.g("Poker", "7.", new Object[0]);
                try {
                    SystemClock.sleep(2000L);
                    l lVar5 = this.f11751e;
                    if (lVar5 != null) {
                        l(lVar5);
                        return;
                    }
                    us.pinguo.common.log.a.g("Poker", "7.1", new Object[0]);
                    g(b, str);
                } catch (Exception e3) {
                    m(this.b, 3, Log.getStackTraceString(e3));
                }
            } catch (Exception e4) {
                m(this.b, 3, Log.getStackTraceString(e4));
            }
        } catch (Exception e5) {
            m(this.b, 3, Log.getStackTraceString(e5));
        }
    }

    @Nullable
    private j e() {
        try {
            return p.a();
        } catch (Exception unused) {
            return null;
        }
    }

    private byte[] f(String str) throws IOException {
        long currentTimeMillis = System.currentTimeMillis();
        while (Math.abs(System.currentTimeMillis() - currentTimeMillis) < 15000) {
            us.pinguo.common.log.a.g("Poker", "7.--", new Object[0]);
            long currentTimeMillis2 = System.currentTimeMillis();
            byte[] c = p.c(str);
            if (c != null) {
                return c;
            }
            if (this.f11751e != null) {
                return null;
            }
            us.pinguo.common.log.a.g("Poker", "7.--1", new Object[0]);
            long currentTimeMillis3 = System.currentTimeMillis() - currentTimeMillis2;
            if (currentTimeMillis3 < 1000) {
                SystemClock.sleep(1000 - currentTimeMillis3);
            }
            us.pinguo.common.log.a.g("Poker", "7.--2", new Object[0]);
            if (this.f11751e != null) {
                return null;
            }
        }
        throw new IOException("download jpg time out");
    }

    private void g(q qVar, String str) {
        try {
            try {
                byte[] f2 = f(qVar.a);
                l lVar = this.f11751e;
                if (lVar != null) {
                    l(lVar);
                    return;
                }
                if (a(f2, str)) {
                    f2 = us.pinguo.util.k.c(str);
                }
                o(this.b, f2, str);
            } catch (Exception e2) {
                m(this.b, 3, Log.getStackTraceString(e2));
            }
        } catch (Exception e3) {
            m(this.b, 3, Log.getStackTraceString(e3));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void h(l lVar) {
        if (lVar != null) {
            lVar.a();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void i(n nVar, int i2, String str) {
        if (nVar != null) {
            nVar.b(i2, str);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void j(n nVar, s sVar) {
        if (nVar != null) {
            nVar.c(sVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void k(n nVar, byte[] bArr, String str) {
        if (nVar != null) {
            nVar.a(bArr, str);
        }
    }

    private void l(final l lVar) {
        this.a.post(new Runnable() { // from class: us.pinguo.poker.i
            @Override // java.lang.Runnable
            public final void run() {
                t.h(l.this);
            }
        });
    }

    private void m(final n nVar, final int i2, final String str) {
        l lVar = this.f11751e;
        if (lVar != null) {
            l(lVar);
        } else {
            this.a.post(new Runnable() { // from class: us.pinguo.poker.h
                @Override // java.lang.Runnable
                public final void run() {
                    t.i(n.this, i2, str);
                }
            });
        }
    }

    private void n(final n nVar, final s sVar) {
        l lVar = this.f11751e;
        if (lVar != null) {
            l(lVar);
        } else {
            this.a.post(new Runnable() { // from class: us.pinguo.poker.g
                @Override // java.lang.Runnable
                public final void run() {
                    t.j(n.this, sVar);
                }
            });
        }
    }

    private void o(final n nVar, final byte[] bArr, final String str) {
        l lVar = this.f11751e;
        if (lVar != null) {
            l(lVar);
        } else {
            this.a.post(new Runnable() { // from class: us.pinguo.poker.f
                @Override // java.lang.Runnable
                public final void run() {
                    t.k(n.this, bArr, str);
                }
            });
        }
    }

    protected boolean a(byte[] bArr, String str) {
        us.pinguo.util.k.i(str, bArr);
        return false;
    }

    protected s b(s sVar, String str) {
        return sVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void c(l lVar) {
        this.f11751e = lVar;
    }

    public void p(Handler handler, u uVar, n nVar) {
        this.a = handler;
        this.b = nVar;
        this.f11750d = uVar;
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public void run() {
        us.pinguo.common.log.a.g("Poker", "0.", new Object[0]);
        j e2 = e();
        l lVar = this.f11751e;
        if (lVar != null) {
            l(lVar);
            return;
        }
        us.pinguo.common.log.a.g("Poker", IdManager.DEFAULT_VERSION_NAME, new Object[0]);
        us.pinguo.common.log.a.g("Poker", "1.", new Object[0]);
        try {
            s d2 = m.d(this.c, e2 == null ? 200 : e2.f11741f);
            n(this.b, d2);
            l lVar2 = this.f11751e;
            if (lVar2 != null) {
                l(lVar2);
                return;
            }
            us.pinguo.common.log.a.g("Poker", "1.1", new Object[0]);
            us.pinguo.common.log.a.g("Poker", "2.", new Object[0]);
            String a = this.c.a();
            if (new File(a).exists()) {
                byte[] c = us.pinguo.util.k.c(a);
                if (c != null) {
                    o(this.b, c, a);
                    return;
                } else {
                    m(this.b, 1, "FileIOUtils.readFile2Bytes fail");
                    return;
                }
            }
            l lVar3 = this.f11751e;
            if (lVar3 != null) {
                l(lVar3);
                return;
            }
            b(d2, a);
            us.pinguo.common.log.a.g("Poker", "2.2", new Object[0]);
            d(e2, d2, a);
        } catch (IOException e3) {
            m(this.b, 1, Log.getStackTraceString(e3));
        }
    }

    public t(Handler handler, m mVar, u uVar, n nVar) {
        this.f11751e = null;
        this.a = handler;
        this.b = nVar;
        this.c = mVar;
        this.f11750d = uVar;
        this.f11751e = null;
    }
}
