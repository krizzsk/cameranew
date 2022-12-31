package com.pinguo.camera360.request;

import com.pinguo.lib.GsonUtilKt;
import com.tencent.bugly.crashreport.CrashReport;
import java.util.HashMap;
import java.util.Map;
import kotlin.jvm.b.l;
import kotlin.jvm.internal.s;
import kotlin.u;
import us.pinguo.bigalbum.db.BigAlbumStore;
import us.pinguo.common.network.HttpStringRequest;
import us.pinguo.foundation.utils.NoProguard;
import us.pinguo.inspire.Inspire;
import us.pinguo.inspire.module.profile.GeoResp;
import us.pinguo.user.t0;
/* compiled from: ApiGetLocationFromLatlong.kt */
/* loaded from: classes3.dex */
public final class ApiGetLocationFromLatlong extends HttpStringRequest {
    private l<? super GeoResp, u> callback;
    private final String latitude;
    private final String longitude;

    /* compiled from: ApiGetLocationFromLatlong.kt */
    /* loaded from: classes3.dex */
    public static final class ResponseData implements NoProguard {
        private final GeoResp data;
        private final String message;
        private final float serverTime;
        private final int status;

        public ResponseData(float f2, String message, int i2, GeoResp data) {
            s.h(message, "message");
            s.h(data, "data");
            this.serverTime = f2;
            this.message = message;
            this.status = i2;
            this.data = data;
        }

        public static /* synthetic */ ResponseData copy$default(ResponseData responseData, float f2, String str, int i2, GeoResp geoResp, int i3, Object obj) {
            if ((i3 & 1) != 0) {
                f2 = responseData.serverTime;
            }
            if ((i3 & 2) != 0) {
                str = responseData.message;
            }
            if ((i3 & 4) != 0) {
                i2 = responseData.status;
            }
            if ((i3 & 8) != 0) {
                geoResp = responseData.data;
            }
            return responseData.copy(f2, str, i2, geoResp);
        }

        public final float component1() {
            return this.serverTime;
        }

        public final String component2() {
            return this.message;
        }

        public final int component3() {
            return this.status;
        }

        public final GeoResp component4() {
            return this.data;
        }

        public final ResponseData copy(float f2, String message, int i2, GeoResp data) {
            s.h(message, "message");
            s.h(data, "data");
            return new ResponseData(f2, message, i2, data);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof ResponseData) {
                ResponseData responseData = (ResponseData) obj;
                return s.c(Float.valueOf(this.serverTime), Float.valueOf(responseData.serverTime)) && s.c(this.message, responseData.message) && this.status == responseData.status && s.c(this.data, responseData.data);
            }
            return false;
        }

        public final GeoResp getData() {
            return this.data;
        }

        public final String getMessage() {
            return this.message;
        }

        public final float getServerTime() {
            return this.serverTime;
        }

        public final int getStatus() {
            return this.status;
        }

        public int hashCode() {
            return (((((Float.floatToIntBits(this.serverTime) * 31) + this.message.hashCode()) * 31) + this.status) * 31) + this.data.hashCode();
        }

        public String toString() {
            return "ResponseData(serverTime=" + this.serverTime + ", message=" + this.message + ", status=" + this.status + ", data=" + this.data + ')';
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ApiGetLocationFromLatlong(String latitude, String longitude) {
        super(1, t0.G);
        s.h(latitude, "latitude");
        s.h(longitude, "longitude");
        this.latitude = latitude;
        this.longitude = longitude;
    }

    public final void executeSuccess(l<? super GeoResp, u> callback) {
        s.h(callback, "callback");
        this.callback = callback;
        execute();
    }

    @Override // com.android.volley.Request
    protected Map<String, String> getParams() {
        HashMap hashMap = new HashMap();
        hashMap.put(BigAlbumStore.PhotoColumns.LATITUDE, this.latitude);
        hashMap.put(BigAlbumStore.PhotoColumns.LONGITUDE, this.longitude);
        new Inspire.b().append(hashMap);
        return hashMap;
    }

    @Override // us.pinguo.common.network.HttpRequestBase
    protected void onErrorResponse(Exception exc) {
        if (exc != null) {
            exc.printStackTrace();
        }
        this.callback = null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // us.pinguo.common.network.HttpRequestBase
    public void onResponse(String response) {
        s.h(response, "response");
        try {
            ResponseData responseData = (ResponseData) GsonUtilKt.getCachedGson().j(response, ResponseData.class);
            if (responseData == null) {
                new NullPointerException().printStackTrace();
            } else if (responseData.getStatus() != 200) {
                new Exception(responseData.getMessage()).printStackTrace();
            } else {
                us.pinguo.common.log.a.c("onResponse:" + responseData.getData() + ", " + ((Object) responseData.getData().info.country) + '-' + ((Object) responseData.getData().info.province) + '-' + ((Object) responseData.getData().info.city) + '-', new Object[0]);
                l<? super GeoResp, u> lVar = this.callback;
                if (lVar != null) {
                    lVar.invoke(responseData.getData());
                }
                this.callback = null;
            }
        } catch (Exception unused) {
            CrashReport.postCatchedException(new IllegalStateException(s.q("LocationResponseException:", response)));
        }
    }
}
