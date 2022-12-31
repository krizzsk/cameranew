package us.pinguo.inspire.api;

import android.text.TextUtils;
import us.pinguo.common.network.BaseResponse;
import us.pinguo.foundation.m.f;
import us.pinguo.foundation.network.Fault;
import us.pinguo.inspire.Inspire;
import us.pinguo.user.s0;
/* loaded from: classes9.dex */
public class QiniuAuthToken {
    public static final String KEY_QINIU_AUTH_TOKEN = "key_qiniu_auth_token_";
    private static final String KEY_USER_IP = "key_user_ip";
    public static final String TYPE_COMMENT = "comment";
    public static final String TYPE_DIRECT = "direct";
    public static final String TYPE_IMAGE = "image";
    public static final String TYPE_VIDEO = "video";
    private static final String URL = "/pic/UploadAuth";
    private String mType;

    /* loaded from: classes9.dex */
    public static class Data {
        public String exist;
        public String expires;
        public String ip;
        public String token;
        public String url;
    }

    /* loaded from: classes9.dex */
    public static class Response extends BaseResponse<Data> {
        public double serverTime;
    }

    public QiniuAuthToken(String str) {
        this.mType = str;
    }

    public boolean exists() {
        return !TextUtils.isEmpty(get());
    }

    public String get() {
        return Inspire.c().getString(getKey(), "");
    }

    public String getIP() {
        return Inspire.c().getString(KEY_USER_IP, "");
    }

    public String getKey() {
        return KEY_QINIU_AUTH_TOKEN + this.mType;
    }

    protected String getUrl() {
        return URL;
    }

    public synchronized String refresh() throws Exception {
        com.android.volley.Response c;
        c = f.c(new Inspire.d<Response>() { // from class: us.pinguo.inspire.api.QiniuAuthToken.1
        }.url(getUrl()).put("type", this.mType).build());
        if (c.isSuccess()) {
            T t = c.result;
            if (((Response) t).status != 200) {
                if (((Response) t).status == 420) {
                    s0.getInstance().k();
                }
                T t2 = c.result;
                throw new Fault(((Response) t2).status, ((Response) t2).message);
            }
            Inspire.c().edit().putString(getKey(), ((Data) ((Response) c.result).data).token).commit();
            Inspire.c().edit().putString(KEY_USER_IP, ((Data) ((Response) c.result).data).ip).commit();
        } else {
            throw c.error;
        }
        return ((Data) ((Response) c.result).data).token;
    }
}
