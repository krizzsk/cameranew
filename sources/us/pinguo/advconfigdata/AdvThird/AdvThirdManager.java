package us.pinguo.advconfigdata.AdvThird;

import android.content.Context;
import android.net.Uri;
import android.os.Build;
import android.provider.Settings;
import android.text.TextUtils;
import com.tapjoy.TapjoyConstants;
import java.util.HashMap;
import java.util.Map;
import us.pinguo.advconfigdata.AdvConfigManager;
import us.pinguo.advconfigdata.Utils.AdvUtils;
/* loaded from: classes3.dex */
public class AdvThirdManager {
    private static AdvThirdManager mAdvThirdManager;
    private AdvThirdItemCache mAdvThirdItemCache;
    private Context mAppContext;
    private HashMap<String, AdvThirdLoadTask> mThirdLoadTaskMap = new HashMap<>();

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public class a implements AdvThirdItemListener {
        AdvThirdItemListener a;
        String b;

        a(String str, AdvThirdItemListener advThirdItemListener) {
            this.b = str;
            this.a = advThirdItemListener;
        }

        @Override // us.pinguo.advconfigdata.AdvThird.AdvThirdItemListener
        public void onAdvCanceled() {
            AdvThirdItemListener advThirdItemListener = this.a;
            if (advThirdItemListener != null) {
                advThirdItemListener.onAdvCanceled();
            }
        }

        @Override // us.pinguo.advconfigdata.AdvThird.AdvThirdItemListener
        public void onAdvFailed() {
            AdvThirdItem advThirdItem = AdvThirdManager.this.mAdvThirdItemCache.get(this.b);
            if (advThirdItem != null) {
                AdvThirdItemListener advThirdItemListener = this.a;
                if (advThirdItemListener != null) {
                    advThirdItemListener.onAdvLoaded(advThirdItem);
                    return;
                }
                return;
            }
            AdvThirdItemListener advThirdItemListener2 = this.a;
            if (advThirdItemListener2 != null) {
                advThirdItemListener2.onAdvFailed();
            }
        }

        @Override // us.pinguo.advconfigdata.AdvThird.AdvThirdItemListener
        public void onAdvLoaded(AdvThirdItem advThirdItem) {
            if (!advThirdItem.isAdvFromCamera360()) {
                AdvThirdManager.this.mAdvThirdItemCache.put(this.b, advThirdItem);
            } else {
                AdvThirdItem advThirdItem2 = AdvThirdManager.this.mAdvThirdItemCache.get(this.b);
                if (advThirdItem2 != null) {
                    advThirdItem = advThirdItem2;
                }
            }
            AdvThirdItemListener advThirdItemListener = this.a;
            if (advThirdItemListener != null) {
                advThirdItemListener.onAdvLoaded(advThirdItem);
            }
        }
    }

    private AdvThirdManager(Context context) {
        this.mAdvThirdItemCache = new AdvThirdItemCache(context);
        this.mAppContext = context;
    }

    public static void InitThirdManager(Context context) {
        if (mAdvThirdManager == null) {
            mAdvThirdManager = new AdvThirdManager(context);
        }
    }

    public static AdvThirdManager getThirdManager() {
        return mAdvThirdManager;
    }

    public AdvThirdItem getThirdAdvCached(String str) {
        return getThirdAdvFromCache(str);
    }

    public AdvThirdItem getThirdAdvFromCache(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        return this.mAdvThirdItemCache.get(str);
    }

    public Map<String, String> getThirdLoadHttpParams() {
        Map<String, String> commonHttpParams = AdvConfigManager.getInstance().getCommonHttpParams();
        try {
            String string = Settings.Secure.getString(this.mAppContext.getContentResolver(), TapjoyConstants.TJC_ANDROID_ID);
            if (!TextUtils.isEmpty(string)) {
                commonHttpParams.put("anid", string);
            }
        } catch (Exception unused) {
        }
        try {
            String lowerCase = Build.MANUFACTURER.toLowerCase();
            if (!TextUtils.isEmpty(lowerCase)) {
                commonHttpParams.put("bn", lowerCase);
            }
        } catch (Exception unused2) {
        }
        int currentNetType = AdvUtils.currentNetType(this.mAppContext);
        commonHttpParams.put("net", currentNetType != 2 ? currentNetType != 4 ? currentNetType != 8 ? currentNetType != 16 ? "unknown" : "wifi" : "4G" : "3G" : "2G");
        commonHttpParams.put("dataType", "json");
        if (!TextUtils.isEmpty(AdvConfigManager.getInstance().getAdvConfig().getUa())) {
            commonHttpParams.put("ua", AdvConfigManager.getInstance().getAdvConfig().getUa());
        }
        return commonHttpParams;
    }

    void loadThirdAdv(String str, String str2, AdvThirdItemListener advThirdItemListener, boolean z) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            if (advThirdItemListener != null) {
                advThirdItemListener.onAdvFailed();
                return;
            }
            return;
        }
        a aVar = new a(str, advThirdItemListener);
        AdvThirdLoadTask advThirdLoadTask = this.mThirdLoadTaskMap.get(str);
        if (advThirdLoadTask != null && !advThirdLoadTask.isFinished() && !advThirdLoadTask.isCancelled()) {
            advThirdLoadTask.setListener(aVar);
        } else if (z) {
            AdvThirdItem advThirdItem = this.mAdvThirdItemCache.get(str);
            if (advThirdItemListener != null) {
                if (advThirdItem != null) {
                    advThirdItemListener.onAdvLoaded(advThirdItem);
                } else {
                    advThirdItemListener.onAdvFailed();
                }
            }
        } else {
            AdvThirdLoadTask advThirdLoadTask2 = new AdvThirdLoadTask();
            advThirdLoadTask2.setListener(aVar);
            advThirdLoadTask2.execute(str2);
            this.mThirdLoadTaskMap.put(str, advThirdLoadTask2);
        }
    }

    public boolean needLoadThirdAdv(String str) {
        String str2;
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        try {
            str2 = Uri.parse(str).getScheme();
        } catch (Exception unused) {
            str2 = null;
        }
        return "callApi".equals(str2);
    }

    public void loadThirdAdv(AdvThirdItemListener advThirdItemListener, boolean z, String str, String str2) {
        String str3 = null;
        try {
            Uri parse = Uri.parse(str2);
            if ("callApi".equals(parse.getScheme())) {
                str3 = parse.getQueryParameter("link");
            }
        } catch (Exception unused) {
        }
        if (!TextUtils.isEmpty(str3)) {
            loadThirdAdv(str, str3, advThirdItemListener, z);
        } else if (advThirdItemListener != null) {
            advThirdItemListener.onAdvFailed();
        }
    }
}
