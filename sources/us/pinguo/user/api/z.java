package us.pinguo.user.api;

import android.content.Context;
import androidx.core.app.NotificationCompat;
import com.tencent.matrix.report.Issue;
import java.util.HashMap;
import org.json.JSONException;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action1;
import us.pinguo.common.network.RxVolley;
import us.pinguo.common.network.request.VolleyRequest;
import us.pinguo.user.LoginConfig;
import us.pinguo.user.t0;
/* compiled from: ApiEmailRegister.java */
/* loaded from: classes6.dex */
public class z extends j.a.c.a.a<UserInfoResponse> {
    private String a;
    private String b;
    private boolean c;

    public z(Context context, String str, String str2, boolean z) {
        super(context);
        this.a = str;
        this.b = str2;
        this.c = z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public /* synthetic */ void b(j.a.c.b.d dVar, String str) {
        try {
            us.pinguo.common.log.a.k("response:" + str, new Object[0]);
            postResponse(dVar, new UserInfoResponse(str, NotificationCompat.CATEGORY_EMAIL));
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
    public void get(final j.a.c.b.d<UserInfoResponse> dVar) {
        String g2 = us.pinguo.util.i.g(this.b);
        HashMap hashMap = new HashMap();
        LoginConfig.b(this.mContext, hashMap);
        hashMap.put(NotificationCompat.CATEGORY_EMAIL, this.a);
        hashMap.put("password", g2);
        hashMap.put(Issue.ISSUE_REPORT_TIME, String.valueOf(System.currentTimeMillis() / 1000));
        hashMap.put("isNeedBind", this.c ? "0" : "1");
        us.pinguo.foundation.m.d.b(hashMap);
        VolleyRequest.Builder builder = new VolleyRequest.Builder(String.class);
        builder.withMethod(1).withUrl(t0.q).withEncrypt(true ^ us.pinguo.foundation.d.f10985d).addParams(hashMap);
        RxVolley.create(builder.build()).observeOn(AndroidSchedulers.mainThread()).subscribe(new Action1() { // from class: us.pinguo.user.api.h
            @Override // rx.functions.Action1
            public final void call(Object obj) {
                z.this.b(dVar, (String) obj);
            }
        }, new Action1() { // from class: us.pinguo.user.api.g
            @Override // rx.functions.Action1
            public final void call(Object obj) {
                z.this.d(dVar, (Throwable) obj);
            }
        });
    }
}
