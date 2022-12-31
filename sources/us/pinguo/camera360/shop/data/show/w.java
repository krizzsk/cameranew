package us.pinguo.camera360.shop.data.show;

import android.os.Handler;
import android.text.TextUtils;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.google.gson.JsonSyntaxException;
import com.pinguo.lib.GsonUtilKt;
import com.tencent.open.SocialConstants;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CountDownLatch;
import org.json.JSONArray;
import rx.functions.Action1;
import us.pinguo.camera360.shop.bean.PkgDetailData;
import us.pinguo.camera360.shop.bean.PkgDetailJson;
import us.pinguo.camera360.shop.manager.ExceptionStatManager;
import us.pinguo.common.network.RxVolley;
import us.pinguo.common.network.pgrequest.PGRequest;
import us.pinguo.foundation.utils.AsyncTask;
import us.pinguo.user.User;
/* compiled from: ShowDetailCache.java */
/* loaded from: classes4.dex */
public class w {
    private static final String c = "w";
    private Map<String, c> a = new ConcurrentHashMap();
    private Handler b;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: ShowDetailCache.java */
    /* loaded from: classes4.dex */
    public class a implements r {
        final /* synthetic */ String a;
        final /* synthetic */ q b;

        a(String str, q qVar) {
            this.a = str;
            this.b = qVar;
        }

        @Override // us.pinguo.camera360.shop.data.show.r
        public void a(Map<String, ShowDetail> map) {
            ShowDetail showDetail = map.get(this.a);
            if (showDetail == null) {
                w.this.C(this.b, new IOException("empty data"));
            } else {
                w.this.D(this.b, showDetail);
            }
        }

        @Override // us.pinguo.camera360.shop.data.show.r
        public void b(Exception exc) {
            w.this.C(this.b, exc);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: ShowDetailCache.java */
    /* loaded from: classes4.dex */
    public class b implements q {
        final /* synthetic */ ShowDetail[] a;
        final /* synthetic */ CountDownLatch b;

        b(w wVar, ShowDetail[] showDetailArr, CountDownLatch countDownLatch) {
            this.a = showDetailArr;
            this.b = countDownLatch;
        }

        @Override // us.pinguo.camera360.shop.data.show.q
        public void a(Exception exc) {
            this.b.countDown();
        }

        @Override // us.pinguo.camera360.shop.data.show.q
        public void b(ShowDetail showDetail) {
            this.a[0] = showDetail;
            this.b.countDown();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: ShowDetailCache.java */
    /* loaded from: classes4.dex */
    public class c {
        ShowDetail a;
        long b;

        private c(w wVar) {
        }

        /* synthetic */ c(w wVar, v vVar) {
            this(wVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: ShowDetailCache.java */
    /* loaded from: classes4.dex */
    public class d extends AsyncTask<String, Void, Object> {
        private final r a;
        private final PGRequest<String> b;
        private String c;

        d(r rVar, PGRequest<String> pGRequest) {
            this.a = rVar;
            this.b = pGRequest;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // us.pinguo.foundation.utils.AsyncTask
        /* renamed from: a */
        public Object doInBackground(String... strArr) {
            try {
                this.c = strArr[0];
                return (PkgDetailJson) GsonUtilKt.getCachedGson().j(this.c, PkgDetailJson.class);
            } catch (Exception e2) {
                if (this.b != null && (e2 instanceof JsonSyntaxException)) {
                    ExceptionStatManager.getInstance().f(this.b, e2.getMessage());
                }
                e2.printStackTrace();
                return e2;
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // us.pinguo.foundation.utils.AsyncTask
        public void onPostExecute(Object obj) {
            PkgDetailData[] pkgDetailDataArr;
            if (obj instanceof Exception) {
                w.this.A(this.a, (Exception) obj);
            } else if (!(obj instanceof PkgDetailJson)) {
                w.this.A(this.a, new RuntimeException("error result"));
            } else {
                PkgDetailJson pkgDetailJson = (PkgDetailJson) obj;
                if (pkgDetailJson.status == 200 && (pkgDetailDataArr = pkgDetailJson.data) != null && pkgDetailDataArr.length != 0) {
                    HashMap hashMap = new HashMap();
                    for (PkgDetailData pkgDetailData : pkgDetailJson.data) {
                        ShowDetail p = w.p(pkgDetailData);
                        if (p != null) {
                            c cVar = new c(w.this, null);
                            cVar.a = p;
                            cVar.b = System.currentTimeMillis();
                            w.this.a.put(w.this.l(p.getId()), cVar);
                            hashMap.put(p.getId(), p);
                            if (this.b != null && this.c != null) {
                                try {
                                    us.pinguo.util.k.l(w.this.i(p.getId()), this.c);
                                } catch (Exception e2) {
                                    us.pinguo.common.log.a.f(e2);
                                }
                            }
                        }
                    }
                    w.this.B(this.a, hashMap);
                    return;
                }
                if (this.b != null) {
                    ExceptionStatManager.getInstance().g(this.b, Integer.valueOf(pkgDetailJson.status));
                }
                w.this.A(this.a, new IOException("error status:" + pkgDetailJson.status + "   or null data"));
            }
        }
    }

    public w(Handler handler) {
        this.b = handler;
        us.pinguo.util.l.f(j());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void A(final r rVar, final Exception exc) {
        if (rVar == null) {
            return;
        }
        this.b.post(new Runnable() { // from class: us.pinguo.camera360.shop.data.show.g
            @Override // java.lang.Runnable
            public final void run() {
                r.this.b(exc);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void B(final r rVar, final Map<String, ShowDetail> map) {
        if (rVar == null) {
            return;
        }
        this.b.post(new Runnable() { // from class: us.pinguo.camera360.shop.data.show.b
            @Override // java.lang.Runnable
            public final void run() {
                r.this.a(map);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void C(final q qVar, final Exception exc) {
        if (qVar == null) {
            return;
        }
        this.b.post(new Runnable() { // from class: us.pinguo.camera360.shop.data.show.c
            @Override // java.lang.Runnable
            public final void run() {
                q.this.a(exc);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void D(final q qVar, final ShowDetail showDetail) {
        if (qVar == null) {
            return;
        }
        this.b.post(new Runnable() { // from class: us.pinguo.camera360.shop.data.show.a
            @Override // java.lang.Runnable
            public final void run() {
                q.this.b(showDetail);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public File i(String str) {
        return new File(j() + l(str));
    }

    private String j() {
        return us.pinguo.util.v.c() + "/shop/";
    }

    private String k(String[] strArr) {
        JSONArray jSONArray = new JSONArray();
        for (String str : strArr) {
            if (!TextUtils.isEmpty(str)) {
                jSONArray.put(str);
            }
        }
        return jSONArray.toString();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String l(String str) {
        Locale a2 = us.pinguo.foundation.utils.v.a();
        return str + '_' + a2.getLanguage() + a2.getCountry();
    }

    private synchronized ShowDetail o(String str, boolean z) {
        ShowDetail[] showDetailArr;
        CountDownLatch countDownLatch = new CountDownLatch(1);
        showDetailArr = new ShowDetail[1];
        E(str, new b(this, showDetailArr, countDownLatch), z);
        try {
            countDownLatch.await();
        } catch (InterruptedException unused) {
        }
        return showDetailArr[0];
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static ShowDetail p(PkgDetailData pkgDetailData) {
        if (pkgDetailData == null) {
            return null;
        }
        return pkgDetailData.toShowDetail();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: u */
    public /* synthetic */ void v(r rVar, PGRequest pGRequest, String str) {
        String str2 = c;
        us.pinguo.common.log.a.m(str2, "response-> thread=" + Thread.currentThread().getName(), new Object[0]);
        new d(rVar, pGRequest).execute(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: w */
    public /* synthetic */ void x(long j2, final r rVar, final PGRequest pGRequest, final String str) {
        us.pinguo.foundation.statistics.i iVar = us.pinguo.foundation.statistics.h.b;
        iVar.n((System.currentTimeMillis() - j2) + "", "/api/product/detail", FirebaseAnalytics.Param.SUCCESS);
        us.pinguo.foundation.utils.f.c(new Runnable() { // from class: us.pinguo.camera360.shop.data.show.d
            @Override // java.lang.Runnable
            public final void run() {
                w.this.v(rVar, pGRequest, str);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: y */
    public /* synthetic */ void z(long j2, PGRequest pGRequest, r rVar, Throwable th) {
        us.pinguo.foundation.statistics.i iVar = us.pinguo.foundation.statistics.h.b;
        iVar.n((System.currentTimeMillis() - j2) + "", "/api/product/detail", "failed");
        ExceptionStatManager.getInstance().h(pGRequest, th);
        us.pinguo.foundation.e.e(th);
        us.pinguo.common.log.a.f(th);
        A(rVar, new Exception(th));
    }

    public void E(String str, q qVar, boolean z) {
        a aVar = new a(str, qVar);
        if (z) {
            File i2 = i(str);
            if (Math.abs(System.currentTimeMillis() - i2.lastModified()) <= 7200000) {
                new d(aVar, null).execute(us.pinguo.util.k.d(i2));
                return;
            }
        }
        G(new String[]{str}, aVar);
    }

    public ShowDetail F(String str) {
        c cVar = this.a.get(l(str));
        if (cVar == null || Math.abs(cVar.b - System.currentTimeMillis()) > 7200000) {
            return null;
        }
        return cVar.a;
    }

    public void G(String[] strArr, final r rVar) {
        PGRequest.Builder builder = new PGRequest.Builder(String.class);
        builder.withMethod(1).withDomain(us.pinguo.camera360.shop.download.a.a).withUriPath("/api/product/detail");
        if (User.d().n()) {
            builder.withUid(User.d().h().userId);
        }
        builder.addParam("ids", k(strArr));
        us.pinguo.foundation.statistics.h.b.n("", "/api/product/detail", SocialConstants.TYPE_REQUEST);
        final long currentTimeMillis = System.currentTimeMillis();
        final PGRequest build = builder.build();
        RxVolley.create(build).subscribe(new Action1() { // from class: us.pinguo.camera360.shop.data.show.e
            @Override // rx.functions.Action1
            public final void call(Object obj) {
                w.this.x(currentTimeMillis, rVar, build, (String) obj);
            }
        }, new Action1() { // from class: us.pinguo.camera360.shop.data.show.f
            @Override // rx.functions.Action1
            public final void call(Object obj) {
                w.this.z(currentTimeMillis, build, rVar, (Throwable) obj);
            }
        });
    }

    public ShowDetail m(String str) {
        ShowDetail F = F(str);
        return F != null ? F : o(str, true);
    }

    public ShowDetail n(String str) {
        return o(str, false);
    }
}
