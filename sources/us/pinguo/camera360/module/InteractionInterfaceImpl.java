package us.pinguo.camera360.module;

import androidx.annotation.Keep;
import com.pinguo.camera360.adv.interaction.Interaction;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import us.pinguo.advconfigdata.AdvConfigManager;
import us.pinguo.advconfigdata.database.AdvItem;
import us.pinguo.foundation.utils.z;
import us.pinguo.librouter.module.camera.InteractionInterface;
import vStudio.Android.Camera360.R;
@Keep
/* loaded from: classes3.dex */
public class InteractionInterfaceImpl implements InteractionInterface {

    /* loaded from: classes3.dex */
    private static class a {
        private static final InteractionInterfaceImpl a = new InteractionInterfaceImpl();
    }

    private List<AdvItem> getDefaultBanner(String str) {
        ArrayList arrayList = new ArrayList();
        AdvItem advItem = new AdvItem();
        if ("72ba7c334d1aec71e75f82397c2c82f0".equals(str)) {
            advItem.imgDefault = R.drawable.challenge_banner_default;
            advItem.interactionUri = "app://inspire/pctaskinfo?task_id=5a3390dc22336c657ceb4ba0";
        } else {
            advItem.imgDefault = R.drawable.home_banner_default;
            if (z.b(Locale.getDefault())) {
                advItem.interactionUri = "app://camera360/cameraFilter?pkgId=5836bbbdb773028b3d368c98&filterId=5836ba2ab773028b2a327510&cameraType=1&isSticker=false";
            } else {
                advItem.interactionUri = "market://details?id=photo.studio.editor.selfie.camera";
            }
        }
        arrayList.add(advItem);
        return arrayList;
    }

    public static InteractionInterface getInstance() {
        return a.a;
    }

    public void detectPicToPublish() {
        j.a.e.d.a();
    }

    @Override // us.pinguo.librouter.module.camera.InteractionInterface
    public List<AdvItem> getBannerData(String str) {
        List<AdvItem> items = AdvConfigManager.getInstance().getItems(str);
        if (items != null && items.size() > 0) {
            ArrayList arrayList = new ArrayList();
            for (AdvItem advItem : items) {
                AdvItem loadDownloadedImage = AdvConfigManager.getInstance().loadDownloadedImage(advItem);
                if (loadDownloadedImage != null) {
                    arrayList.add(loadDownloadedImage);
                }
            }
            return arrayList.size() > 0 ? arrayList : getDefaultBanner(str);
        }
        return getDefaultBanner(str);
    }

    @Override // us.pinguo.librouter.module.camera.InteractionInterface
    public boolean isInteractionAppWall(AdvItem advItem) {
        return Interaction.isInteractionAppWall(advItem);
    }

    @Override // us.pinguo.librouter.module.camera.InteractionInterface
    public boolean isValidAppWall(AdvItem advItem) {
        return advItem != null;
    }

    @Override // us.pinguo.librouter.module.camera.InteractionInterface
    public void recordClosedTime() {
        j.a.e.d.j();
    }
}
