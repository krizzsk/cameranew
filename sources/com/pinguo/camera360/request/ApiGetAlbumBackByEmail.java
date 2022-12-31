package com.pinguo.camera360.request;

import android.content.Context;
import androidx.core.app.NotificationCompat;
import java.util.HashMap;
import java.util.Map;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action1;
import us.pinguo.common.network.RxVolley;
import us.pinguo.common.network.common.header.PGTransHeader;
import us.pinguo.common.network.pgrequest.PGRequest;
import us.pinguo.inspire.module.profile.activity.GuestProfileFragment;
import us.pinguo.user.LoginConfig;
/* loaded from: classes3.dex */
public class ApiGetAlbumBackByEmail extends j.a.c.a.a<AlbumGetBackResponse> {
    private String mEmail;
    private String mUserId;

    public ApiGetAlbumBackByEmail(Context context, String str, String str2) {
        super(context);
        this.mEmail = str;
        this.mUserId = str2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public /* synthetic */ void b(j.a.c.b.d dVar, String str) {
        try {
            postResponse(dVar, (AlbumGetBackResponse) new com.google.gson.e().j(str, AlbumGetBackResponse.class));
        } catch (Exception e2) {
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
    public void get(final j.a.c.b.d<AlbumGetBackResponse> dVar) {
        HashMap hashMap = new HashMap();
        LoginConfig.c(this.mContext, hashMap);
        hashMap.put(GuestProfileFragment.USER_ID, this.mUserId);
        hashMap.put(NotificationCompat.CATEGORY_EMAIL, this.mEmail);
        us.pinguo.foundation.m.d.c(hashMap, "Nh02nt\\\":;-9/-`^$3bf0Nhf893>,/{1|");
        PGRequest.Builder builder = new PGRequest.Builder(String.class);
        for (Map.Entry entry : hashMap.entrySet()) {
            builder.addParam((String) entry.getKey(), entry.getValue());
        }
        builder.withMethod(1).withDomain(us.pinguo.camera360.shop.download.a.a).withUriPath("/api/user/apply-for-yun").withEncryptAlg(PGTransHeader.E1);
        RxVolley.create(builder.build()).observeOn(AndroidSchedulers.mainThread()).subscribe(new Action1() { // from class: com.pinguo.camera360.request.c
            @Override // rx.functions.Action1
            public final void call(Object obj) {
                ApiGetAlbumBackByEmail.this.b(dVar, (String) obj);
            }
        }, new Action1() { // from class: com.pinguo.camera360.request.d
            @Override // rx.functions.Action1
            public final void call(Object obj) {
                ApiGetAlbumBackByEmail.this.d(dVar, (Throwable) obj);
            }
        });
    }
}
