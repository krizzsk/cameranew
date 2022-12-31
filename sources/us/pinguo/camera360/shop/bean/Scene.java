package us.pinguo.camera360.shop.bean;

import us.pinguo.camera360.shop.data.show.ShowScene;
/* loaded from: classes3.dex */
public class Scene {
    public String id;
    public String name;
    public String[] package_ids;
    public String[] products_in_camera;
    public String[] topic_group_ids;
    public int vip = 0;
    public int editPriority = 0;
    public int show_in_camera = 0;

    public ShowScene getShowPage() {
        ShowScene showScene = new ShowScene(this.id, this.name);
        showScene.setVip(this.vip);
        return showScene;
    }
}
