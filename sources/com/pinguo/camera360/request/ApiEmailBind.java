package com.pinguo.camera360.request;

import android.content.Context;
import android.text.TextUtils;
import androidx.core.app.NotificationCompat;
import java.util.HashMap;
import org.json.JSONException;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action1;
import us.pinguo.common.network.RxVolley;
import us.pinguo.common.network.request.VolleyRequest;
import us.pinguo.user.LoginConfig;
import us.pinguo.user.api.UserInfoResponse;
import us.pinguo.user.t0;
import us.pinguo.util.i;
/* loaded from: classes3.dex */
public class ApiEmailBind extends j.a.c.a.a<UserInfoResponse> {
    private String mEmail;
    private String mPassword;
    private String withVipInfo;

    public ApiEmailBind(Context context, String str, String str2) {
        super(context);
        this.mEmail = str;
        this.mPassword = str2;
        this.withVipInfo = "1";
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
        hashMap.put(NotificationCompat.CATEGORY_EMAIL, this.mEmail);
        if (!TextUtils.isEmpty(this.mPassword)) {
            hashMap.put("password", i.g(this.mPassword));
        }
        hashMap.put("withVipInfo", this.withVipInfo);
        us.pinguo.foundation.m.d.b(hashMap);
        VolleyRequest.Builder builder = new VolleyRequest.Builder(String.class);
        builder.withMethod(1).withUrl(t0.D).withEncrypt(true ^ us.pinguo.foundation.d.f10985d).addParams(hashMap);
        RxVolley.create(builder.build()).observeOn(AndroidSchedulers.mainThread()).subscribe(new Action1() { // from class: com.pinguo.camera360.request.a
            @Override // rx.functions.Action1
            public final void call(Object obj) {
                ApiEmailBind.this.b(dVar, (String) obj);
            }
        }, new Action1() { // from class: com.pinguo.camera360.request.b
            @Override // rx.functions.Action1
            public final void call(Object obj) {
                ApiEmailBind.this.d(dVar, (Throwable) obj);
            }
        });
    }
}
