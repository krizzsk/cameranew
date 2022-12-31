package us.pinguo.inspire.module.feeds.model;

import us.pinguo.inspire.module.discovery.entity.InspireFeed;
import us.pinguo.inspire.module.feeds.cell.FeedsPhotoCell;
/* loaded from: classes9.dex */
public class FeedsHotManager {
    public static final String KEY_CACHE_EXIST = "cache_exist";

    public static us.pinguo.widget.common.cell.recycler.b initPhotoCell(InspireFeed inspireFeed) {
        FeedsPhotoCell feedsPhotoCell = new FeedsPhotoCell(inspireFeed);
        feedsPhotoCell.setShowTime(false);
        return feedsPhotoCell;
    }

    public static boolean isVrPhoto(int i2, int i3) {
        return i2 >= i3 * 2;
    }
}
