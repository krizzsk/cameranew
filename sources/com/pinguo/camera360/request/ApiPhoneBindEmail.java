package com.pinguo.camera360.request;

import android.content.Context;
import androidx.core.app.NotificationCompat;
import com.tapjoy.TapjoyConstants;
import java.util.HashMap;
import org.json.JSONException;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action1;
import us.pinguo.common.network.RxVolley;
import us.pinguo.common.network.request.VolleyRequest;
import us.pinguo.user.LoginConfig;
import us.pinguo.user.api.UserInfoResponse;
import us.pinguo.user.t0;
/* loaded from: classes3.dex */
public class ApiPhoneBindEmail extends j.a.c.a.a<UserInfoResponse> {
    private String mEmail;

    public ApiPhoneBindEmail(Context context, String str) {
        super(context);
        this.mEmail = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public /* synthetic */ void b(j.a.c.b.d dVar, String str) {
        try {
            us.pinguo.common.log.a.k("response:" + str, new Object[0]);
            postResponse(dVar, new UserInfoResponse(str, TapjoyConstants.TJC_CONNECTION_TYPE_MOBILE));
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
        HashMap hashMap = new HashMap();
        LoginConfig.b(this.mContext, hashMap);
        hashMap.put(NotificationCompat.CATEGORY_EMAIL, this.mEmail);
        us.pinguo.foundation.m.d.b(hashMap);
        VolleyRequest.Builder builder = new VolleyRequest.Builder(String.class);
        builder.withMethod(1).withUrl(t0.w).withEncrypt(true ^ us.pinguo.foundation.d.f10985d).addParams(hashMap);
        RxVolley.create(builder.build()).observeOn(AndroidSchedulers.mainThread()).subscribe(new Action1() { // from class: com.pinguo.camera360.request.f
            @Override // rx.functions.Action1
            public final void call(Object obj) {
                ApiPhoneBindEmail.this.b(dVar, (String) obj);
            }
        }, new Action1() { // from class: com.pinguo.camera360.request.e
            @Override // rx.functions.Action1
            public final void call(Object obj) {
                ApiPhoneBindEmail.this.d(dVar, (Throwable) obj);
            }
        });
    }
}
