package us.pinguo.user.api;

import android.content.Context;
import com.tencent.matrix.report.Issue;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action1;
import rx.schedulers.Schedulers;
import us.pinguo.common.network.BaseResponse;
import us.pinguo.common.network.RxVolley;
import us.pinguo.common.network.request.VolleyRequest;
import us.pinguo.inspire.module.profile.activity.GuestProfileFragment;
import us.pinguo.user.LoginConfig;
import us.pinguo.user.api.ApiModifyPassword;
import us.pinguo.user.t0;
/* loaded from: classes6.dex */
public class ApiModifyPassword extends j.a.c.a.a<Response> {
    private String a;
    private String b;
    private String c;

    /* loaded from: classes6.dex */
    public static class Response extends BaseResponse<Data> {

        /* loaded from: classes6.dex */
        public static class Data {
            public String token;
            public long tokenEnd;
            public long tokenExpire;
        }
    }

    public ApiModifyPassword(Context context, String str, String str2, String str3) {
        super(context);
        this.a = str;
        this.b = str2;
        this.c = str3;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public /* synthetic */ void b(j.a.c.b.d dVar, Response response) {
        postResponse(dVar, response);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: c */
    public /* synthetic */ void d(j.a.c.b.d dVar, Throwable th) {
        postError(dVar, null);
        th.getStackTrace();
    }

    @Override // j.a.c.a.a, j.a.c.b.b
    public void get(final j.a.c.b.d<Response> dVar) {
        String g2 = us.pinguo.util.i.g(this.a);
        HashMap hashMap = new HashMap();
        LoginConfig.b(this.mContext, hashMap);
        hashMap.put("password", g2);
        hashMap.put(GuestProfileFragment.USER_ID, us.pinguo.foundation.utils.p.a(this.b));
        hashMap.put("token", us.pinguo.foundation.utils.p.a(this.c));
        hashMap.put(Issue.ISSUE_REPORT_TIME, String.valueOf(System.currentTimeMillis() / 1000));
        us.pinguo.foundation.m.d.b(hashMap);
        try {
            us.pinguo.common.log.a.k("url:" + us.pinguo.foundation.utils.p.c(t0.E, hashMap), new Object[0]);
        } catch (UnsupportedEncodingException e2) {
            e2.printStackTrace();
        }
        VolleyRequest.Builder builder = new VolleyRequest.Builder(Response.class);
        builder.withMethod(1).withUrl(t0.E).withEncrypt(true ^ us.pinguo.foundation.d.f10985d).addParams(hashMap);
        RxVolley.create(builder.build()).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(new Action1() { // from class: us.pinguo.user.api.k
            @Override // rx.functions.Action1
            public final void call(Object obj) {
                ApiModifyPassword.this.b(dVar, (ApiModifyPassword.Response) obj);
            }
        }, new Action1() { // from class: us.pinguo.user.api.l
            @Override // rx.functions.Action1
            public final void call(Object obj) {
                ApiModifyPassword.this.d(dVar, (Throwable) obj);
            }
        });
    }
}
