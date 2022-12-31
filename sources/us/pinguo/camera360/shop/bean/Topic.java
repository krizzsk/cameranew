package us.pinguo.camera360.shop.bean;

import java.util.Map;
import us.pinguo.camera360.shop.data.show.ShowPkg;
import us.pinguo.camera360.shop.data.show.ShowTopic;
import us.pinguo.camera360.shop.data.show.UnlockType;
/* loaded from: classes3.dex */
public class Topic {
    public String banner;
    public String description;
    public String icon;
    public String name;
    public long off_time;
    public long onsale_time;
    public String[] package_ids;
    public PayInfo pay_info;
    public String topic_id;
    public int type;
    public int unlock_type;
    public int vip = 0;

    private boolean isValid(long j2) {
        if (j2 != 0) {
            long j3 = this.onsale_time;
            if (j3 > 0) {
                long j4 = this.off_time;
                if (j4 > 0) {
                    return j2 >= j3 * 1000 && j2 <= j4 * 1000;
                }
                return true;
            }
            return true;
        }
        return true;
    }

    public ShowTopic toShowTopicForPkg(long j2, Map<String, ShowPkg> map) {
        if (isValid(j2) && this.package_ids != null) {
            ShowTopic showTopic = new ShowTopic(this.topic_id, this.icon, this.name, this.banner, this.description, this.onsale_time);
            for (String str : this.package_ids) {
                ShowPkg showPkg = map.get(str);
                if (showPkg != null) {
                    showTopic.getPkgs().add(showPkg);
                }
            }
            if (showTopic.getPkgs().isEmpty()) {
                return null;
            }
            return showTopic;
        }
        return null;
    }

    public ShowTopic toShowTopicForSticker(boolean z, long j2, Map<String, ShowPkg> map) {
        if (isValid(j2) && this.package_ids != null) {
            ShowTopic showTopic = new ShowTopic(this.topic_id, this.icon, this.name, this.banner, this.description, this.onsale_time);
            for (String str : this.package_ids) {
                ShowPkg showPkg = map.get(str);
                if (showPkg != null) {
                    showTopic.getPkgs().add(showPkg);
                }
            }
            if (showTopic.getPkgs().isEmpty()) {
                return null;
            }
            UnlockType type = UnlockType.getType(this.unlock_type);
            if (z || type != UnlockType.PAY) {
                if (type == null) {
                    type = UnlockType.FREE;
                }
                if (type == UnlockType.PAY && this.pay_info == null) {
                    return null;
                }
                showTopic.setUnlockType(type, this.pay_info);
                showTopic.setVip(this.vip);
                return showTopic;
            }
            return null;
        }
        return null;
    }
}
