package us.pinguo.loc;

import android.content.Context;
import android.content.SharedPreferences;
import java.io.File;
import java.io.IOException;
import java.util.concurrent.atomic.AtomicBoolean;
import rx.Observable;
import rx.Subscriber;
import rx.Subscription;
import rx.functions.Func1;
import us.pinguo.PGEquinox.PGEquinoxEngine;
import us.pinguo.foundation.utils.m0;
/* compiled from: LocResLoader.java */
/* loaded from: classes5.dex */
public class t {
    private static boolean a;
    private static volatile boolean b;
    private static AtomicBoolean c = new AtomicBoolean(false);

    /* renamed from: d  reason: collision with root package name */
    private static volatile int f11549d;

    /* renamed from: e  reason: collision with root package name */
    private static a f11550e;

    /* renamed from: f  reason: collision with root package name */
    private static Subscription f11551f;

    /* compiled from: LocResLoader.java */
    /* loaded from: classes5.dex */
    public interface a {
        void a(int i2);

        void b();

        void c(boolean z);
    }

    private static boolean a() {
        return new File(e()).exists() && new File(j()).exists() && new File(c()).exists() && new File(f()).exists() && new File(i()).exists() && new File(k()).exists();
    }

    public static boolean b(Context context, boolean z) {
        SharedPreferences h2 = h(context);
        boolean z2 = h2.getBoolean("loc_prepared_v8", false);
        us.pinguo.common.log.a.k("checkRes,prepared:" + z2, new Object[0]);
        if (z2 && z) {
            long currentTimeMillis = System.currentTimeMillis();
            boolean a2 = a();
            long currentTimeMillis2 = System.currentTimeMillis() - currentTimeMillis;
            us.pinguo.common.log.a.k("检查文件耗时:" + currentTimeMillis2 + "ms", new Object[0]);
            if (!a2) {
                h2.edit().putBoolean("loc_prepared_v8", false).apply();
            }
            return a2;
        }
        return z2;
    }

    public static String c() {
        return g(us.pinguo.foundation.e.b()).getAbsolutePath() + "/" + us.pinguo.foundation.n.b.a() + "/libPinguoDNN.so";
    }

    public static File d(Context context) {
        File g2 = g(context);
        if (!g2.exists()) {
            g2.mkdirs();
        }
        return new File(g2, "loc_res.zip");
    }

    public static String e() {
        return g(us.pinguo.foundation.e.b()).getAbsolutePath() + "/" + us.pinguo.foundation.n.b.a() + "/libPGEquinoxEngine.so";
    }

    public static String f() {
        return g(us.pinguo.foundation.e.b()).getAbsolutePath() + "/pinguo_hair_model.pmm";
    }

    public static File g(Context context) {
        return new File(context.getFilesDir(), "loc");
    }

    public static SharedPreferences h(Context context) {
        return context.getSharedPreferences("loc", 0);
    }

    public static String i() {
        return g(us.pinguo.foundation.e.b()).getAbsolutePath() + "/pinguo_makeup_model.zip";
    }

    public static String j() {
        return g(us.pinguo.foundation.e.b()).getAbsolutePath() + "/" + us.pinguo.foundation.n.b.a() + "/libPGMakeUpLab.so";
    }

    public static String k() {
        return g(us.pinguo.foundation.e.b()).getAbsolutePath() + "/pinguo_portrait_model.pmm";
    }

    public static void l(Context context) throws UnsatisfiedLinkError {
        if (a) {
            return;
        }
        a = true;
        String e2 = e();
        String j2 = j();
        String c2 = c();
        us.pinguo.common.log.a.k("加载底层库+", new Object[0]);
        PGEquinoxEngine.loadLibraries(e2, j2, c2);
        us.pinguo.common.log.a.k("加载底层库-", new Object[0]);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void n(Context context, Subscriber subscriber) {
        if (b) {
            b = false;
            us.pinguo.common.log.a.k("删除大片老资源。。。", new Object[0]);
            File g2 = g(context);
            us.pinguo.util.l.i(g2);
            g2.mkdirs();
        }
        subscriber.onNext(0);
        subscriber.onCompleted();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ Integer p(File file, Context context, Integer num) {
        us.pinguo.common.log.a.k("大片资源下载进度:" + num, new Object[0]);
        if (num.intValue() == 100) {
            try {
                us.pinguo.common.log.a.k("大片资源下载完成,开始解压", new Object[0]);
                m0.d(file.getAbsolutePath(), g(context).getAbsolutePath());
                us.pinguo.common.log.a.k("大片资源下载完成,解压完成", new Object[0]);
            } catch (IOException e2) {
                throw new RuntimeException(e2);
            }
        }
        return num;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void q(Integer num) {
        f11549d = num.intValue();
        a aVar = f11550e;
        if (aVar != null) {
            aVar.a(f11549d);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void r(Throwable th) {
        c.set(false);
        us.pinguo.common.log.a.e("大片资源下载失败", th);
        a aVar = f11550e;
        if (aVar != null) {
            aVar.c(false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void s() {
        us.pinguo.common.log.a.k("大片资源下载完成,onComplete", new Object[0]);
        c.set(false);
        us.pinguo.foundation.e.b().getSharedPreferences("loc", 0).edit().putBoolean("loc_prepared_v8", true).commit();
        a aVar = f11550e;
        if (aVar != null) {
            aVar.c(true);
        }
    }

    public static void t(a aVar) {
        f11550e = aVar;
    }

    public static void u(Context context, boolean z) {
        h(context).edit().putBoolean("loc_prepared_v8", z).apply();
    }

    public static void v(final Context context, boolean z) {
        if (z && !c.get()) {
            us.pinguo.foundation.r.d a2 = us.pinguo.foundation.r.d.a();
            LocLoadingState locLoadingState = LocLoadingState.DOWN_LOADING;
            a2.b(new o(0, locLoadingState));
            if (f11549d > 0) {
                us.pinguo.foundation.r.d.a().b(new o(f11549d, locLoadingState));
            }
            final File d2 = d(context);
            final us.pinguo.foundation.utils.download.d dVar = new us.pinguo.foundation.utils.download.d("", d2.getAbsolutePath(), "http://activity.c360dn.com/5cff0ed3036b582974.zip");
            c.set(true);
            f11551f = Observable.create(new Observable.OnSubscribe() { // from class: us.pinguo.loc.h
                @Override // rx.functions.Action1
                public final void call(Object obj) {
                    t.n(context, (Subscriber) obj);
                }
            }).flatMap(new Func1() { // from class: us.pinguo.loc.g
                @Override // rx.functions.Func1
                public final Object call(Object obj) {
                    Observable b2;
                    Integer num = (Integer) obj;
                    b2 = us.pinguo.foundation.utils.download.c.b(us.pinguo.foundation.utils.download.d.this);
                    return b2;
                }
            }).map(new Func1() { // from class: us.pinguo.loc.j
                @Override // rx.functions.Func1
                public final Object call(Object obj) {
                    Integer num = (Integer) obj;
                    t.p(d2, context, num);
                    return num;
                }
            }).subscribe(i.a, f.a, k.a);
        }
    }
}
