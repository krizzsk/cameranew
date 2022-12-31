package com.pinguo.camera360.request;

import android.content.Context;
import java.util.HashMap;
import java.util.Map;
import us.pinguo.common.network.HttpStringRequest;
import us.pinguo.inspire.module.profile.activity.GuestProfileFragment;
import us.pinguo.user.LoginConfig;
/* loaded from: classes3.dex */
public class ApiGetAlbumBackStatus extends j.a.c.a.a<AlbumGetBackStatusResponse> {
    public static final String URL_GET_ALBUM_BACK_STATUS = us.pinguo.camera360.shop.download.a.a + "/api/user/check_yun_status";
    private String mUserId;

    public ApiGetAlbumBackStatus(Context context, String str) {
        super(context);
        this.mUserId = str;
    }

    @Override // j.a.c.a.a, j.a.c.b.b
    public void get(final j.a.c.b.d<AlbumGetBackStatusResponse> dVar) {
        execute(new HttpStringRequest(1, URL_GET_ALBUM_BACK_STATUS) { // from class: com.pinguo.camera360.request.ApiGetAlbumBackStatus.1
            @Override // com.android.volley.Request
            protected Map<String, String> getParams() {
                HashMap hashMap = new HashMap();
                LoginConfig.c(((j.a.c.a.a) ApiGetAlbumBackStatus.this).mContext, hashMap);
                hashMap.put(GuestProfileFragment.USER_ID, ApiGetAlbumBackStatus.this.mUserId);
                us.pinguo.foundation.m.d.c(hashMap, "Nh02nt\\\":;-9/-`^$3bf0Nhf893>,/{1|");
                return hashMap;
            }

            @Override // us.pinguo.common.network.HttpRequestBase
            protected void onErrorResponse(Exception exc) {
                us.pinguo.common.log.a.k("修改性别返回 error:" + exc.toString(), new Object[0]);
                ApiGetAlbumBackStatus.this.postError(dVar, exc);
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // us.pinguo.common.network.HttpRequestBase
            public void onResponse(String str) {
                try {
                    ApiGetAlbumBackStatus.this.postResponse(dVar, (AlbumGetBackStatusResponse) new com.google.gson.e().j(str, AlbumGetBackStatusResponse.class));
                } catch (Exception e2) {
                    e2.printStackTrace();
                    ApiGetAlbumBackStatus.this.postError(dVar, e2);
                }
            }
        });
    }
}
