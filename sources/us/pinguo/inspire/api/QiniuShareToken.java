package us.pinguo.inspire.api;
/* loaded from: classes9.dex */
public class QiniuShareToken extends QiniuAuthToken {
    public static final String KEY_QINIU_SHARE_TOKEN = "key_qiniu_share_token_";
    public static final String TYPE_SHARE_VIDEO = "video";
    private static final String URL = "/share/UploadAuth";
    private String mType;

    public QiniuShareToken(String str) {
        super(str);
        this.mType = str;
    }

    @Override // us.pinguo.inspire.api.QiniuAuthToken
    public String getKey() {
        return KEY_QINIU_SHARE_TOKEN + this.mType;
    }

    @Override // us.pinguo.inspire.api.QiniuAuthToken
    protected String getUrl() {
        return URL;
    }
}
