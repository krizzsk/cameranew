package com.pinguo.camera360.sticker;

import java.io.File;
import us.pinguo.camera360.shop.data.FilterType;
import us.pinguo.camera360.shop.data.g;
import us.pinguo.camera360.shop.data.install.t;
import us.pinguo.repository2020.database.filter.FilterItemTable;
/* loaded from: classes3.dex */
public class StickerItem extends g {
    public StickerItem(FilterItemTable filterItemTable) {
        super(filterItemTable);
    }

    @Override // us.pinguo.camera360.shop.data.g
    public String getFilterKey() {
        return FilterType.Sticker.getType();
    }

    public UnityData getUnityData() {
        return null;
    }

    public String getUnityFolder() {
        String b = t.b(getPackageMd5(), getFilterId());
        UnityData unityData = getUnityData();
        if (unityData == null) {
            return null;
        }
        return b + unityData.folder + File.separator;
    }

    @Override // us.pinguo.camera360.shop.data.g
    public boolean hasMusic() {
        return false;
    }
}
