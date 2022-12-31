package us.pinguo.share.core;

import java.util.HashMap;
import java.util.Map;
/* loaded from: classes6.dex */
final class ConfigAllBean {
    private Map<ShareSite, ConfigSiteBean> DevInfor = new HashMap();
    private String ShareAppKey;

    ConfigAllBean() {
    }

    public Map<ShareSite, ConfigSiteBean> getDevInfor() {
        return this.DevInfor;
    }

    public String getShareAppKey() {
        return this.ShareAppKey;
    }

    public void setDevInfor(Map<ShareSite, ConfigSiteBean> map) {
        this.DevInfor = map;
    }

    public void setShareAppKey(String str) {
        this.ShareAppKey = str;
    }
}
