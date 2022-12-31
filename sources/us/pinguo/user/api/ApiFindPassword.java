package us.pinguo.user.api;

import android.content.Context;
import android.text.TextUtils;
import androidx.core.app.NotificationCompat;
import java.util.HashMap;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action1;
import us.pinguo.common.network.RxVolley;
import us.pinguo.common.network.request.VolleyRequest;
import us.pinguo.user.LoginConfig;
import us.pinguo.user.api.ApiFindPassword;
import us.pinguo.user.t0;
/* loaded from: classes6.dex */
public class ApiFindPassword extends j.a.c.a.a<Response> {
    private String a;

    /* loaded from: classes6.dex */
    public static class Response {
        public String message;
        public int status;
    }

    public ApiFindPassword(Context context, String str) {
        super(context);
        this.a = str;
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
        if (TextUtils.isEmpty(this.a)) {
            postError(dVar, new IllegalArgumentException("email illegal"));
            return;
        }
        HashMap hashMap = new HashMap();
        LoginConfig.b(this.mContext, hashMap);
        hashMap.put(NotificationCompat.CATEGORY_EMAIL, this.a);
        us.pinguo.foundation.m.d.b(hashMap);
        VolleyRequest.Builder builder = new VolleyRequest.Builder(Response.class);
        builder.withMethod(1).withUrl(t0.B).withEncrypt(true ^ us.pinguo.foundation.d.f10985d).addParams(hashMap);
        RxVolley.create(builder.build()).observeOn(AndroidSchedulers.mainThread()).subscribe(new Action1() { // from class: us.pinguo.user.api.i
            @Override // rx.functions.Action1
            public final void call(Object obj) {
                ApiFindPassword.this.b(dVar, (ApiFindPassword.Response) obj);
            }
        }, new Action1() { // from class: us.pinguo.user.api.j
            @Override // rx.functions.Action1
            public final void call(Object obj) {
                ApiFindPassword.this.d(dVar, (Throwable) obj);
            }
        });
    }
}
