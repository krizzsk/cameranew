package us.pinguo.camera360.shop.bean;
/* loaded from: classes3.dex */
public class ShopData {
    public int interval;
    public Package[] packages;
    public Scene[] scenes;
    public Topic[] topics;
    public int version;

    public boolean isOk() {
        Scene[] sceneArr;
        Package[] packageArr = this.packages;
        return packageArr != null && packageArr.length > 0 && (sceneArr = this.scenes) != null && sceneArr.length > 0;
    }
}
