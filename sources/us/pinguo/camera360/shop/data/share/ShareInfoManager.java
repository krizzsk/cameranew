package us.pinguo.camera360.shop.data.share;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import androidx.collection.ArrayMap;
import androidx.core.util.Pair;
import com.android.volley.AuthFailureError;
import java.io.IOException;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import us.pinguo.camera360.shop.bean.ShareInfo;
import us.pinguo.camera360.shop.bean.ShareJson;
import us.pinguo.common.network.HttpStringRequest;
import us.pinguo.foundation.utils.AsyncTask;
import us.pinguo.foundation.utils.v;
import us.pinguo.librouter.application.BaseApplication;
import us.pinguo.user.User;
import us.pinguo.user.u0;
/* loaded from: classes3.dex */
public class ShareInfoManager implements Handler.Callback {

    /* renamed from: e  reason: collision with root package name */
    private static ShareInfoManager f9615e;
    private Pair<String, a> a;
    private Map<String, f> b = new ArrayMap();
    private Context c = BaseApplication.d();

    /* renamed from: d  reason: collision with root package name */
    private Handler f9616d = new Handler(Looper.getMainLooper(), this);

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public class a extends HttpStringRequest {
        private c a;
        private String b;

        /* JADX INFO: Access modifiers changed from: package-private */
        /* renamed from: us.pinguo.camera360.shop.data.share.ShareInfoManager$a$a  reason: collision with other inner class name */
        /* loaded from: classes3.dex */
        public class C0370a extends AsyncTask<String, Void, f> {
            C0370a() {
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // us.pinguo.foundation.utils.AsyncTask
            /* renamed from: a */
            public f doInBackground(String... strArr) {
                int i2;
                try {
                    ShareJson shareJson = (ShareJson) new com.google.gson.e().j(strArr[0], ShareJson.class);
                    if (!shareJson.isOk()) {
                        throw new IOException("data error");
                    } else if (shareJson == null || !((i2 = shareJson.status) == 200 || i2 == 420 || i2 == 10220)) {
                        ShareInfoManager.this.n(new IOException("error data"), a.this.a);
                        return null;
                    } else if (i2 == 420) {
                        ShareInfoManager.this.n(new IOException("user time out"), a.this.a);
                        User.E();
                        return null;
                    } else if (!shareJson.isOk()) {
                        ShareInfoManager.this.n(new IOException("error data"), a.this.a);
                        return null;
                    } else {
                        ShareInfo shareInfo = shareJson.data.info;
                        f fVar = new f(shareInfo.getText(), shareInfo.getImg(), shareInfo.getLink(), shareInfo.getName(), shareInfo.getIcon(), shareInfo.getFbicon(), shareInfo.getChannel(), System.currentTimeMillis());
                        fVar.n(shareInfo.getTag(), shareInfo.getAccount(), shareInfo.getRenturnLink());
                        fVar.l(shareJson.data.activity);
                        fVar.m(ShareInfoManager.this.g());
                        return fVar;
                    }
                } catch (Exception e2) {
                    us.pinguo.common.log.a.e("ShareInfoManager", "e=" + e2.getMessage());
                    a aVar = a.this;
                    ShareInfoManager.this.n(e2, aVar.a);
                    return null;
                }
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // us.pinguo.foundation.utils.AsyncTask
            /* renamed from: b */
            public void onPostExecute(f fVar) {
                if (fVar == null) {
                    return;
                }
                ShareInfoManager.this.b.put(a.this.b, fVar);
                a aVar = a.this;
                ShareInfoManager.this.o(fVar, aVar.a);
            }
        }

        public a(int i2, String str, String str2) {
            super(i2, str);
            this.b = str2;
        }

        public void c(c cVar) {
            this.a = cVar;
        }

        @Override // com.android.volley.Request
        protected Map<String, String> getParams() throws AuthFailureError {
            HashMap hashMap = new HashMap();
            u0.c(BaseApplication.d(), hashMap);
            hashMap.put("shareId", this.b);
            us.pinguo.foundation.m.d.c(hashMap, "Nh02nt\\\":;-9/-`^$3bf0Nhf893>,/{1|");
            return hashMap;
        }

        @Override // us.pinguo.common.network.HttpRequestBase
        protected void onErrorResponse(Exception exc) {
            us.pinguo.common.log.a.e("ShareInfoManager", "e=" + exc.getMessage());
            ShareInfoManager.this.n(exc, this.a);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // us.pinguo.common.network.HttpRequestBase
        public void onResponse(String str) {
            new C0370a().execute(str);
        }
    }

    private ShareInfoManager() {
    }

    private boolean e(String str, String str2) {
        if (g().equals(str2)) {
            return false;
        }
        this.b.remove(str);
        return true;
    }

    private boolean f(String str, f fVar) {
        if (System.currentTimeMillis() - fVar.c() > 7200000) {
            this.b.remove(str);
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String g() {
        Locale a2 = v.a();
        String language = a2.getLanguage();
        String lowerCase = a2.getCountry().toLowerCase(Locale.ENGLISH);
        return language + "_" + lowerCase;
    }

    public static ShareInfoManager getInstance() {
        if (f9615e == null) {
            f9615e = new ShareInfoManager();
        }
        return f9615e;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: j */
    public /* synthetic */ void k(c cVar, Exception exc) {
        cVar.a(exc);
        this.a = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: l */
    public /* synthetic */ void m(c cVar, f fVar) {
        cVar.b(fVar);
        this.a = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void n(final Exception exc, final c cVar) {
        this.f9616d.post(new Runnable() { // from class: us.pinguo.camera360.shop.data.share.b
            @Override // java.lang.Runnable
            public final void run() {
                ShareInfoManager.this.k(cVar, exc);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void o(final f fVar, final c cVar) {
        this.f9616d.post(new Runnable() { // from class: us.pinguo.camera360.shop.data.share.a
            @Override // java.lang.Runnable
            public final void run() {
                ShareInfoManager.this.m(cVar, fVar);
            }
        });
    }

    public f h(String str) {
        f fVar = this.b.get(str);
        if (fVar == null || f(str, fVar) || e(str, fVar.h())) {
            return null;
        }
        return fVar;
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(Message message) {
        return false;
    }

    public void i(String str, c cVar) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        Pair<String, a> pair = this.a;
        if (pair != null) {
            if (pair.first.equals(str)) {
                this.a.second.c(cVar);
                return;
            } else {
                this.a.second.cancel();
                this.a = null;
            }
        }
        a aVar = new a(1, us.pinguo.camera360.shop.download.a.f9706d, str);
        this.a = Pair.create(str, aVar);
        aVar.c(cVar);
        aVar.setRetryPolicy(u0.a());
        aVar.execute();
    }
}
