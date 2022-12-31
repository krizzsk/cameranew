package us.pinguo.advconfigdata.AdvThird;

import android.text.TextUtils;
import java.io.Serializable;
import java.util.List;
/* loaded from: classes3.dex */
public class AdvThirdItem implements Serializable {
    private static final long serialVersionUID = -1230450744445494461L;
    public String adTitle;
    public List<String> clickUrl;
    public String downloadedIconPath;
    public String from;
    public String headurl;
    public String icon;
    public List<String> impressionUrl;
    public String thirdJumpUrl;

    public boolean equals(Object obj) {
        boolean z = true;
        if (this == obj) {
            return true;
        }
        if (obj instanceof AdvThirdItem) {
            AdvThirdItem advThirdItem = (AdvThirdItem) obj;
            String str = advThirdItem.icon;
            boolean equals = str != null ? str.equals(this.icon) : this.icon == null;
            String str2 = advThirdItem.thirdJumpUrl;
            boolean equals2 = equals & (str2 != null ? str2.equals(this.thirdJumpUrl) : this.thirdJumpUrl == null);
            String str3 = advThirdItem.from;
            if (str3 != null) {
                z = str3.equals(this.from);
            } else if (this.from != null) {
                z = false;
            }
            return equals2 & z;
        }
        return false;
    }

    public boolean isAdvFromCamera360() {
        return !TextUtils.isEmpty(this.from) && "camera360".equals(this.from);
    }
}
