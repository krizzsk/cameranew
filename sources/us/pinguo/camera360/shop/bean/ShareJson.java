package us.pinguo.camera360.shop.bean;
/* loaded from: classes3.dex */
public class ShareJson {
    public ShareData data;
    public String message;
    public int status;

    public boolean isOk() {
        ShareData shareData = this.data;
        return shareData != null && shareData.isOk();
    }
}
