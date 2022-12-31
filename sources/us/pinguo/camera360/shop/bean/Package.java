package us.pinguo.camera360.shop.bean;

import androidx.annotation.Nullable;
import java.util.Map;
import us.pinguo.camera360.shop.data.FilterType;
import us.pinguo.camera360.shop.data.show.ShowPkg;
import us.pinguo.camera360.shop.data.show.UnlockType;
/* loaded from: classes3.dex */
public class Package {
    public String icon;
    public String name;
    public long off_time;
    public long onsale_time;
    public PayInfo pay_info;
    public String pid;
    public int position;
    public String share_id;
    public String sid;
    public int type;
    public Map<String, Integer> typeCountInfo;
    public int unlock_type;
    public String vip_banner;
    public int music_tag = 0;
    public int icon_tag = 0;
    public String icon_tag_pic = null;
    public long category_onsale_time = 0;
    public long category_off_time = 0;
    public int vip = 0;
    public int tagContent = 0;
    public long tagOnTime = 0;
    public long tagOffTime = 0;
    public int unity_engine_filter = 0;
    public int camera_support = 1;

    /* JADX INFO: Access modifiers changed from: protected */
    public int getCount() {
        Map<String, Integer> map = this.typeCountInfo;
        int i2 = 0;
        if (map != null) {
            for (Map.Entry<String, Integer> entry : map.entrySet()) {
                i2 = entry.getValue().intValue();
            }
        }
        return i2;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Nullable
    public FilterType getFilterType(boolean z) {
        int i2 = this.type;
        if (i2 != 1) {
            if (i2 != 2) {
                if (i2 != 3) {
                    if (i2 == 7) {
                        return FilterType.AEffect;
                    }
                    if (i2 == 11) {
                        return FilterType.Loc;
                    }
                    if (i2 != 31) {
                        return null;
                    }
                }
                return FilterType.Sticker;
            }
            return FilterType.Scene;
        }
        return FilterType.Effect;
    }

    public ShowPkg toShowPkg(boolean z, boolean z2, long j2, boolean z3) {
        FilterType filterType;
        int i2 = (j2 > 0L ? 1 : (j2 == 0L ? 0 : -1));
        if ((i2 == 0 || (j2 >= this.onsale_time * 1000 && j2 <= this.off_time * 1000)) && (filterType = getFilterType(z3)) != null) {
            if (z2 || filterType != FilterType.Sticker) {
                if (i2 != 0 && filterType == FilterType.Sticker) {
                    long j3 = this.category_onsale_time;
                    if (j3 > 0) {
                        long j4 = this.category_off_time;
                        if (j4 > 0 && (j2 < j3 * 1000 || j2 > j4 * 1000)) {
                            return null;
                        }
                    }
                }
                ShowPkg showPkg = new ShowPkg(this.pid, this.icon, this.name, this.share_id, filterType, getCount(), this.onsale_time, this.off_time, this.unity_engine_filter, this.camera_support, this.tagContent, this.tagOnTime, this.tagOffTime);
                if (this.unity_engine_filter == 1 && this.camera_support == 0) {
                    showPkg.setCameraSupport(0);
                } else {
                    showPkg.setCameraSupport(1);
                }
                showPkg.setSid(this.sid);
                showPkg.setVipBanner(this.vip_banner);
                UnlockType type = UnlockType.getType(this.unlock_type);
                if ((z || type != UnlockType.PAY) && type != null) {
                    if (type == UnlockType.PAY && this.pay_info == null) {
                        return null;
                    }
                    if (showPkg.isFreeLabelVisible()) {
                        type = UnlockType.FREE;
                    }
                    showPkg.setUnlockType(type, this.pay_info);
                    showPkg.setPosition(this.position);
                    showPkg.setHasMusic(this.music_tag != 0);
                    showPkg.setTagPic(this.icon_tag == 1 ? this.icon_tag_pic : null);
                    showPkg.setVip(this.vip);
                    return showPkg;
                }
                return null;
            }
            return null;
        }
        return null;
    }
}
