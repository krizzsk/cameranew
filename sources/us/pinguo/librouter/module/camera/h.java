package us.pinguo.librouter.module.camera;

import java.util.ArrayList;
import java.util.List;
import us.pinguo.advconfigdata.database.AdvItem;
/* compiled from: InteractionDefaultInterface.java */
/* loaded from: classes5.dex */
public class h implements InteractionInterface {
    @Override // us.pinguo.librouter.module.camera.InteractionInterface
    public List<AdvItem> getBannerData(String str) {
        return new ArrayList();
    }

    @Override // us.pinguo.librouter.module.camera.InteractionInterface
    public boolean isInteractionAppWall(AdvItem advItem) {
        return false;
    }

    @Override // us.pinguo.librouter.module.camera.InteractionInterface
    public boolean isValidAppWall(AdvItem advItem) {
        return false;
    }

    @Override // us.pinguo.librouter.module.camera.InteractionInterface
    public void recordClosedTime() {
    }
}
