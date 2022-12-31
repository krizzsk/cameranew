package us.pinguo.poker;

import android.os.Handler;
import android.os.Looper;
import us.pinguo.androidsdk.PGNativeMethod;
/* compiled from: PokerManager.java */
/* loaded from: classes5.dex */
public class o {

    /* renamed from: d  reason: collision with root package name */
    private static o f11747d = new o();
    private Handler a;
    private u b;
    private t c = null;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: PokerManager.java */
    /* loaded from: classes5.dex */
    public class a implements n {
        final /* synthetic */ n a;

        a(n nVar) {
            this.a = nVar;
        }

        @Override // us.pinguo.poker.n
        public void a(byte[] bArr, String str) {
            o.this.c = null;
            us.pinguo.common.log.a.g("Poker", "onPokerSuccess:" + str, new Object[0]);
            n nVar = this.a;
            if (nVar != null) {
                nVar.a(bArr, str);
            }
        }

        @Override // us.pinguo.poker.n
        public void b(int i2, String str) {
            o.this.c = null;
            us.pinguo.common.log.a.g("Poker", "onPokerFailed:" + str, new Object[0]);
            n nVar = this.a;
            if (nVar != null) {
                nVar.b(i2, str);
            }
        }

        @Override // us.pinguo.poker.n
        public void c(s sVar) {
            us.pinguo.common.log.a.g("Poker", "onPokerScaledImage:" + sVar.b, new Object[0]);
            n nVar = this.a;
            if (nVar != null) {
                nVar.c(sVar);
            }
        }
    }

    /* compiled from: PokerManager.java */
    /* loaded from: classes5.dex */
    class b implements n {
        final /* synthetic */ n a;

        b(n nVar) {
            this.a = nVar;
        }

        @Override // us.pinguo.poker.n
        public void a(byte[] bArr, String str) {
            o.this.c = null;
            us.pinguo.common.log.a.g("Poker", "onPokerSuccess:" + str, new Object[0]);
            n nVar = this.a;
            if (nVar != null) {
                nVar.a(bArr, str);
            }
        }

        @Override // us.pinguo.poker.n
        public void b(int i2, String str) {
            o.this.c = null;
            us.pinguo.common.log.a.g("Poker", "onPokerFailed:" + str, new Object[0]);
            n nVar = this.a;
            if (nVar != null) {
                nVar.b(i2, str);
            }
        }

        @Override // us.pinguo.poker.n
        public void c(s sVar) {
            us.pinguo.common.log.a.g("Poker", "onPokerScaledImage:" + sVar.b, new Object[0]);
            n nVar = this.a;
            if (nVar != null) {
                nVar.c(sVar);
            }
        }
    }

    public o() {
        this.a = null;
        this.b = null;
        this.a = new Handler(Looper.getMainLooper());
        this.b = new u();
    }

    public static o e() {
        return f11747d;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: f */
    public /* synthetic */ void g(l lVar) {
        if (lVar != null) {
            lVar.a();
            this.c = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void h(n nVar) {
        if (nVar != null) {
            nVar.b(5, "running");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void i(n nVar) {
        if (nVar != null) {
            nVar.b(5, "running");
        }
    }

    public static byte[] j(String str, String str2, int i2) {
        return PGNativeMethod.effectImgStrengthAdjust(str, str2, i2);
    }

    public synchronized boolean b(final l lVar) {
        t tVar = this.c;
        if (tVar != null) {
            tVar.c(new l() { // from class: us.pinguo.poker.c
                @Override // us.pinguo.poker.l
                public final void a() {
                    o.this.g(lVar);
                }
            });
            this.c = null;
            return true;
        }
        this.c = null;
        return false;
    }

    public synchronized void c(t tVar, final n nVar) {
        if (this.c != null) {
            this.a.post(new Runnable() { // from class: us.pinguo.poker.b
                @Override // java.lang.Runnable
                public final void run() {
                    o.h(n.this);
                }
            });
            return;
        }
        tVar.p(this.a, this.b, new b(nVar));
        this.c = tVar;
        tVar.start();
    }

    public synchronized void d(m mVar, final n nVar) {
        if (this.c != null) {
            this.a.post(new Runnable() { // from class: us.pinguo.poker.d
                @Override // java.lang.Runnable
                public final void run() {
                    o.i(n.this);
                }
            });
            return;
        }
        t tVar = new t(this.a, mVar, this.b, new a(nVar));
        this.c = tVar;
        tVar.start();
    }
}
