package us.pinguo.user.api;

import android.content.Context;
import java.util.HashMap;
import org.json.JSONException;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action1;
import rx.schedulers.Schedulers;
import us.pinguo.common.network.RxVolley;
import us.pinguo.common.network.request.VolleyRequest;
import us.pinguo.user.LoginConfig;
import us.pinguo.user.t0;
/* compiled from: ApiChangeNickname.java */
/* loaded from: classes6.dex */
public class x extends j.a.c.a.a<UserInfoResponse> {
    private String a;

    public x(Context context, String str) {
        super(context);
        this.a = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public /* synthetic */ void b(j.a.c.b.d dVar, String str) {
        try {
            postResponse(dVar, new UserInfoResponse(str, ""));
        } catch (JSONException e2) {
            e2.printStackTrace();
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
        HashMap hashMap = new HashMap();
        LoginConfig.b(this.mContext, hashMap);
        hashMap.put("nickname", this.a);
        us.pinguo.foundation.m.d.b(hashMap);
        VolleyRequest.Builder builder = new VolleyRequest.Builder(String.class);
        builder.withMethod(1).withUrl(t0.C).withEncrypt(true ^ us.pinguo.foundation.d.f10985d).addParams(hashMap);
        RxVolley.create(builder.build()).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(new Action1() { // from class: us.pinguo.user.api.c
            @Override // rx.functions.Action1
            public final void call(Object obj) {
                x.this.b(dVar, (String) obj);
            }
        }, new Action1() { // from class: us.pinguo.user.api.d
            @Override // rx.functions.Action1
            public final void call(Object obj) {
                x.this.d(dVar, (Throwable) obj);
            }
        });
    }
}
