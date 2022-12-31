package us.pinguo.user.api;

import android.content.Context;
import com.tapjoy.TapjoyConstants;
import com.tencent.matrix.report.Issue;
import java.util.HashMap;
import java.util.Iterator;
import org.json.JSONException;
import org.json.JSONObject;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action1;
import rx.schedulers.Schedulers;
import us.pinguo.common.network.RxVolley;
import us.pinguo.common.network.request.VolleyRequest;
import us.pinguo.user.LoginConfig;
import us.pinguo.user.t0;
/* compiled from: ApiPhoneRegister.java */
/* loaded from: classes6.dex */
public class b0 extends j.a.c.a.a<a> {
    private String a;
    private String b;

    /* compiled from: ApiPhoneRegister.java */
    /* loaded from: classes6.dex */
    public static class a {
        public int a;
        public String b;
    }

    public b0(Context context, String str, String str2) {
        super(context);
        this.a = str;
        this.b = str2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public /* synthetic */ void b(j.a.c.b.d dVar, String str) {
        try {
            us.pinguo.common.log.a.k("response:" + str, new Object[0]);
            JSONObject jSONObject = new JSONObject(str);
            Iterator<String> keys = jSONObject.keys();
            a aVar = new a();
            while (keys.hasNext()) {
                String next = keys.next();
                if (next.equals("status")) {
                    aVar.a = jSONObject.getInt(next);
                } else if (next.equals("data")) {
                    try {
                        jSONObject.getBoolean(next);
                    } catch (Exception unused) {
                    }
                } else if (next.equals("message")) {
                    aVar.b = jSONObject.getString(next);
                }
            }
            postResponse(dVar, aVar);
        } catch (JSONException e2) {
            postError(dVar, e2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: c */
    public /* synthetic */ void d(j.a.c.b.d dVar, Throwable th) {
        postError(dVar, null);
        th.getStackTrace();
    }

    @Override // j.a.c.a.a, j.a.c.b.b
    public void get(final j.a.c.b.d<a> dVar) {
        String g2 = us.pinguo.util.i.g(this.b);
        HashMap hashMap = new HashMap();
        LoginConfig.b(this.mContext, hashMap);
        hashMap.put(TapjoyConstants.TJC_CONNECTION_TYPE_MOBILE, this.a);
        hashMap.put("password", g2);
        hashMap.put(Issue.ISSUE_REPORT_TIME, String.valueOf(System.currentTimeMillis() / 1000));
        us.pinguo.foundation.m.d.b(hashMap);
        VolleyRequest.Builder builder = new VolleyRequest.Builder(String.class);
        builder.withMethod(1).withUrl(t0.r).withEncrypt(true ^ us.pinguo.foundation.d.f10985d).addParams(hashMap);
        RxVolley.create(builder.build()).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(new Action1() { // from class: us.pinguo.user.api.p
            @Override // rx.functions.Action1
            public final void call(Object obj) {
                b0.this.b(dVar, (String) obj);
            }
        }, new Action1() { // from class: us.pinguo.user.api.o
            @Override // rx.functions.Action1
            public final void call(Object obj) {
                b0.this.d(dVar, (Throwable) obj);
            }
        });
    }
}
