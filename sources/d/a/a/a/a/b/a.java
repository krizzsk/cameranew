package d.a.a.a.a.b;

import android.text.TextUtils;
import com.bytedance.sdk.openadsdk.core.o;
import com.google.android.gms.ads.identifier.AdvertisingIdClient;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.FutureTask;
import java.util.concurrent.TimeUnit;
/* compiled from: AdvertisingIdHelper.java */
/* loaded from: classes.dex */
public class a {
    private static a c;
    private String a = "";
    private final ExecutorService b = Executors.newSingleThreadExecutor();

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: AdvertisingIdHelper.java */
    /* loaded from: classes.dex */
    public class b implements Callable<String> {
        private b() {
        }

        @Override // java.util.concurrent.Callable
        /* renamed from: a */
        public String call() throws Exception {
            long currentTimeMillis = System.currentTimeMillis();
            try {
                AdvertisingIdClient.Info advertisingIdInfo = AdvertisingIdClient.getAdvertisingIdInfo(o.a());
                if (advertisingIdInfo != null) {
                    String id = advertisingIdInfo.getId();
                    com.bytedance.sdk.openadsdk.utils.o.b("gaid-", "getAdvertisingId: " + id);
                    a.f(id);
                }
            } catch (Throwable th) {
                com.bytedance.sdk.openadsdk.utils.o.c("AdvertisingIdHelper", "getAdvertisingIdInfo error", th);
            }
            try {
                AdvertisingIdClient.Info advertisingIdInfo2 = AdvertisingIdClient.getAdvertisingIdInfo(o.a());
                if (advertisingIdInfo2 != null) {
                    a.this.a = advertisingIdInfo2.getId();
                    advertisingIdInfo2.isLimitAdTrackingEnabled();
                }
            } catch (Throwable th2) {
                com.bytedance.sdk.openadsdk.utils.o.c("AdvertisingIdHelper", "getAdvertisingIdInfo error", th2);
            }
            com.bytedance.sdk.openadsdk.utils.o.b("AdvertisingIdHelper", "mGAId:" + a.this.a + " , get gaid consume time :" + (System.currentTimeMillis() - currentTimeMillis));
            return a.this.a;
        }
    }

    private a() {
    }

    public static a a() {
        if (c == null) {
            synchronized (a.class) {
                if (c == null) {
                    c = new a();
                }
            }
        }
        return c;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void f(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        com.bytedance.sdk.openadsdk.multipro.d.a.a("name_gaid", "gaid", str);
    }

    public String e() {
        try {
            this.a = com.bytedance.sdk.openadsdk.multipro.d.a.b("name_gaid", "gaid", "");
            com.bytedance.sdk.openadsdk.utils.o.c("gaid-", "getGAIdTimeOut-mGAId=" + this.a);
            if (TextUtils.isEmpty(this.a)) {
                FutureTask futureTask = new FutureTask(new b());
                this.b.execute(futureTask);
                this.a = (String) futureTask.get(500000L, TimeUnit.MICROSECONDS);
            }
        } catch (Throwable th) {
            com.bytedance.sdk.openadsdk.utils.o.c("AdvertisingIdHelper", "getGAIdTimeOut error", th);
        }
        return this.a;
    }
}
