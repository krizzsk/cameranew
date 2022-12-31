package us.pinguo.advconfigdata.Interface;

import android.content.Context;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import us.pinguo.advconfigdata.Utils.AdvSystemUtils;
import us.pinguo.advconfigdata.database.AdvItem;
/* loaded from: classes3.dex */
public abstract class AdvConfig {
    private LifecycleListener mEmptyLifecycleListener = new SimpleLifecycleListener();

    /* loaded from: classes3.dex */
    public interface LifecycleListener {
        void onParseAdvError();

        void onReadAdvCacheFileError();

        void onRequestAdv();

        void onRequestAdvIOError();

        void onRequestAdvSecureError();

        void onRequestAdvSuccess();

        void onSaveAdvCacheFileError();

        void onSaveAdvCacheFileSuccess();
    }

    /* loaded from: classes3.dex */
    public static class SimpleLifecycleListener implements LifecycleListener {
        @Override // us.pinguo.advconfigdata.Interface.AdvConfig.LifecycleListener
        public void onParseAdvError() {
        }

        @Override // us.pinguo.advconfigdata.Interface.AdvConfig.LifecycleListener
        public void onReadAdvCacheFileError() {
        }

        @Override // us.pinguo.advconfigdata.Interface.AdvConfig.LifecycleListener
        public void onRequestAdv() {
        }

        @Override // us.pinguo.advconfigdata.Interface.AdvConfig.LifecycleListener
        public void onRequestAdvIOError() {
        }

        @Override // us.pinguo.advconfigdata.Interface.AdvConfig.LifecycleListener
        public void onRequestAdvSecureError() {
        }

        @Override // us.pinguo.advconfigdata.Interface.AdvConfig.LifecycleListener
        public void onRequestAdvSuccess() {
        }

        @Override // us.pinguo.advconfigdata.Interface.AdvConfig.LifecycleListener
        public void onSaveAdvCacheFileError() {
        }

        @Override // us.pinguo.advconfigdata.Interface.AdvConfig.LifecycleListener
        public void onSaveAdvCacheFileSuccess() {
        }
    }

    public abstract String getAppChannel();

    public abstract String getAppName();

    public String getAppVersion(Context context) {
        return AdvSystemUtils.getVersionName(context);
    }

    public String getAppVersionCode(Context context) {
        return AdvSystemUtils.getVersionCode(context);
    }

    public HashMap<String, String> getCustomRequestParams() {
        return null;
    }

    public List<AdvItem> getDefaultAdvItems(String str) {
        return new ArrayList();
    }

    public long getDefaultUpdateInterval() {
        return 7200L;
    }

    public String getDeviceID() {
        return "unknown";
    }

    public String getGeoLocation() {
        return "";
    }

    public String getGpId() {
        return "";
    }

    public abstract String getGrowingIOUserId();

    public abstract String getHttpRequestMD5Secret();

    public Map<String, String[]> getImageSuffixGuids() {
        HashMap hashMap = new HashMap();
        hashMap.put("广告位的guid", new String[]{"imageUrl的后缀", "iconUrl的后缀"});
        return hashMap;
    }

    public String getJumpLinkKey() {
        return "camera360";
    }

    public LifecycleListener getLifecycleListener() {
        return this.mEmptyLifecycleListener;
    }

    public String getLockScreenActivityAction() {
        return "";
    }

    public String getNewAddToday() {
        return "";
    }

    public List<String> getPreloadBeforeActiveGuids() {
        return new ArrayList();
    }

    public List<String> getPreloadDownloadedImageGuids() {
        return new ArrayList();
    }

    public abstract int getRequestMode();

    public abstract String getShowAppName();

    public Boolean getTSLEnable() {
        return Boolean.FALSE;
    }

    public long getThirdAdvFileCachedDuration(String str) {
        return 0L;
    }

    public String getUa() {
        return "";
    }

    public String getUserId() {
        return "";
    }

    public String getVipStatus() {
        return "";
    }

    public boolean isOnlyPreloadOneImageUrl(String str) {
        return false;
    }

    public boolean isOnlyShowHighestPriority(String str) {
        return false;
    }

    public boolean isStopAdv() {
        return false;
    }

    public void onAdvPreload(boolean z) {
    }

    public List<AdvItem> onInterceptDuringLoaded(String str, List<AdvItem> list) {
        return list;
    }
}
