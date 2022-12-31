package us.pinguo.camera360.shop.bean;
/* loaded from: classes3.dex */
public class ShopJson {
    public ShopData data;
    public String message;
    public int status;

    public boolean isOk() {
        ShopData shopData = this.data;
        return shopData != null && shopData.isOk();
    }
}
