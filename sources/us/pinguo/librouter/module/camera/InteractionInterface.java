package us.pinguo.librouter.module.camera;

import java.util.List;
import us.pinguo.advconfigdata.database.AdvItem;
/* loaded from: classes5.dex */
public interface InteractionInterface {
    List<AdvItem> getBannerData(String str);

    boolean isInteractionAppWall(AdvItem advItem);

    boolean isValidAppWall(AdvItem advItem);

    void recordClosedTime();
}
