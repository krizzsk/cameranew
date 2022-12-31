package us.pinguo.camera360.shop.bean;
/* loaded from: classes3.dex */
public class ShareData {
    public String activity = null;
    public String id;
    public ShareInfo info;

    public boolean isOk() {
        ShareInfo shareInfo = this.info;
        return (shareInfo == null || shareInfo.getChannel().length == 0) ? false : true;
    }
}
