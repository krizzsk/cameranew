package us.pinguo.advconfigdata;

import android.content.Context;
import android.os.AsyncTask;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import com.google.firebase.remoteconfig.RemoteConfigConstants;
import com.tapjoy.TapjoyConstants;
import com.tencent.stat.DeviceInfo;
import java.io.File;
import java.io.IOException;
import java.security.GeneralSecurityException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import tv.danmaku.ijk.media.player.IjkMediaMeta;
import us.pinguo.advconfigdata.AdvAddition.AdvPVTask;
import us.pinguo.advconfigdata.AdvDex.ExecuteAdvDex;
import us.pinguo.advconfigdata.AdvThird.AdvThirdItem;
import us.pinguo.advconfigdata.AdvThird.AdvThirdItemAdapter;
import us.pinguo.advconfigdata.AdvThird.AdvThirdItemCache;
import us.pinguo.advconfigdata.AdvThird.AdvThirdItemListener;
import us.pinguo.advconfigdata.AdvThird.AdvThirdLoadTask;
import us.pinguo.advconfigdata.AdvThird.AdvThirdManager;
import us.pinguo.advconfigdata.DispatcherData.AdvDataKeeper;
import us.pinguo.advconfigdata.DispatcherData.AdvUpdateTask;
import us.pinguo.advconfigdata.DownLoadImage.AdvImageDownloader;
import us.pinguo.advconfigdata.Interface.AdConfigManagerInterface;
import us.pinguo.advconfigdata.Interface.AdvConfig;
import us.pinguo.advconfigdata.Interface.AdvDataChangeListener;
import us.pinguo.advconfigdata.Interface.AdvDownLoadLisenter;
import us.pinguo.advconfigdata.Interface.AdvStaticsticInterface;
import us.pinguo.advconfigdata.Statictis.AdvStaticsticManager;
import us.pinguo.advconfigdata.Utils.AdvConstants;
import us.pinguo.advconfigdata.Utils.AdvLog;
import us.pinguo.advconfigdata.Utils.AdvPrefUtil;
import us.pinguo.advconfigdata.Utils.AdvSystemUtils;
import us.pinguo.advconfigdata.Utils.AdvTimeUtils;
import us.pinguo.advconfigdata.Utils.AdvUtils;
import us.pinguo.advconfigdata.Utils.SPUtils;
import us.pinguo.advconfigdata.database.AdvItem;
import us.pinguo.inspire.module.profile.activity.GuestProfileFragment;
/* loaded from: classes3.dex */
public class AdvConfigManager extends AdConfigManagerInterface {
    static String s = "https://dispatchertest.360in.com";
    static String t = "https://dispatchertest-dev.camera360.com";
    static String u = "https://dispatcher.360in.com";
    static String v = "https://dispatcher.camera360.com";
    private Context a;
    private AdvUpdateTask b;
    private AdvImageDownloader c;

    /* renamed from: d  reason: collision with root package name */
    private AdvDataKeeper f9005d;

    /* renamed from: g  reason: collision with root package name */
    private String f9008g;

    /* renamed from: h  reason: collision with root package name */
    private String f9009h;

    /* renamed from: j  reason: collision with root package name */
    private AdvConfig f9011j;

    /* renamed from: k  reason: collision with root package name */
    private String f9012k;

    /* renamed from: l  reason: collision with root package name */
    private volatile boolean f9013l;
    private AdvDataChangeListener m;
    private AdvThirdItemCache p;
    private ArrayList<String> r;
    static String w = "https://dispatcher.camera360.com";
    public static String AD_REQUEST_URL = w + "/api/v1/list";
    public static String AD_REPORT_DECODE_ERROR = w + "/api/report/parserErr";
    public static String AD_CALLBACK_REPAIR = w + "/api/task/callback";
    private static AdvConfigManager x = new AdvConfigManager();

    /* renamed from: e  reason: collision with root package name */
    private HashMap<String, Integer> f9006e = new HashMap<>();

    /* renamed from: f  reason: collision with root package name */
    private HashMap<String, Integer> f9007f = new HashMap<>();

    /* renamed from: i  reason: collision with root package name */
    private Runnable f9010i = new a();
    private HashMap<String, AdvThirdLoadTask> o = new HashMap<>();
    private boolean q = true;
    private Handler n = new Handler(Looper.getMainLooper());

    /* loaded from: classes3.dex */
    class a implements Runnable {
        a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            AdvConfigManager.this.u();
        }
    }

    /* loaded from: classes3.dex */
    class b extends AsyncTask<Object, Object, Object> {
        b() {
        }

        @Override // android.os.AsyncTask
        protected Object doInBackground(Object[] objArr) {
            AdvConfigManager.this.f9005d.A();
            return null;
        }
    }

    /* loaded from: classes3.dex */
    class c implements Comparator<AdvItem> {
        c(AdvConfigManager advConfigManager) {
        }

        @Override // java.util.Comparator
        /* renamed from: a */
        public int compare(AdvItem advItem, AdvItem advItem2) {
            double d2 = advItem.priority;
            double d3 = advItem2.priority;
            if (d2 > d3) {
                return -1;
            }
            return d2 < d3 ? 1 : 0;
        }
    }

    /* loaded from: classes3.dex */
    class d implements Runnable {
        d() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (AdvConfigManager.this.m != null) {
                AdvConfigManager.this.m.onAdvDataChange();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public class e extends AdvThirdItemAdapter {
        e(AdvConfigManager advConfigManager) {
        }

        @Override // us.pinguo.advconfigdata.AdvThird.AdvThirdItemAdapter, us.pinguo.advconfigdata.AdvThird.AdvThirdItemListener
        public void onAdvLoaded(AdvThirdItem advThirdItem) {
            AdvConfigManager.getInstance().loadDownloadedImage(advThirdItem);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public class f implements AdvThirdItemListener {
        AdvThirdItemListener a;
        String b;

        f(String str, AdvThirdItemListener advThirdItemListener) {
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
            AdvThirdItem advThirdItem = AdvConfigManager.this.p.get(this.b);
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
                AdvConfigManager.this.p.put(this.b, advThirdItem);
            } else {
                AdvThirdItem advThirdItem2 = AdvConfigManager.this.p.get(this.b);
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

    private AdvConfigManager() {
    }

    private String a() {
        return AdvPrefUtil.getInstance().getString(AdvConstants.KEY_FIRST_STARTTIME);
    }

    private boolean b() {
        Locale locale = this.a.getResources().getConfiguration().locale;
        return "zh".equalsIgnoreCase(locale.getLanguage()) && "cn".equalsIgnoreCase(locale.getCountry());
    }

    private void c() {
        String string = AdvPrefUtil.getInstance().getString(AdvConstants.KEY_LAST_VERSION);
        String appVersion = getAdvConfig().getAppVersion(this.a);
        if (TextUtils.isEmpty(appVersion)) {
            return;
        }
        if (TextUtils.isEmpty(string) || !appVersion.equals(string)) {
            AdvPrefUtil.getInstance().putString(AdvConstants.KEY_LAST_VERSION, appVersion);
            AdvPrefUtil.getInstance().putString(AdvConstants.KEY_FIRST_STARTTIME, String.valueOf(System.currentTimeMillis() / 1000));
        }
    }

    public static AdvConfigManager getInstance() {
        return x;
    }

    private boolean h(AdvItem advItem, String str, String str2) {
        if (advItem == null) {
            return true;
        }
        boolean z = !AdvUtils.isHttpUrl(advItem.imageUrl) || (str != null && new File(str).exists());
        boolean z2 = !AdvUtils.isHttpUrl(advItem.iconUrl) || (str2 != null && new File(str2).exists());
        if (z && z2) {
            return true;
        }
        if (!z && !TextUtils.isEmpty(str)) {
            this.c.download(advItem.imageUrl, str, null);
        }
        if (!z2 && !TextUtils.isEmpty(str2)) {
            this.c.download(advItem.iconUrl, str2, null);
        }
        return false;
    }

    private String i() {
        StringBuilder sb = new StringBuilder();
        ArrayList arrayList = new ArrayList();
        for (String str : this.f9007f.keySet()) {
            String[] split = str.split("__");
            if (split.length == 2) {
                String str2 = split[0];
                String str3 = split[1];
                arrayList.clear();
                if (!TextUtils.isEmpty(str2)) {
                    arrayList.add(str2);
                }
                if (this.f9005d.r(arrayList, str3)) {
                    sb.append(str);
                    sb.append(',');
                    sb.append(this.f9007f.get(str));
                    sb.append(';');
                }
            }
        }
        if (sb.length() > 0 && sb.charAt(sb.length() - 1) == ';') {
            sb.deleteCharAt(sb.length() - 1);
        }
        return sb.toString();
    }

    private int j(String str, int i2) {
        if (this.f9006e == null) {
            this.f9006e = new HashMap<>();
        }
        if (i2 == 1) {
            return 0;
        }
        if (this.f9006e.size() == 0) {
            r();
        }
        int intValue = this.f9006e.get(str) != null ? (this.f9006e.get(str).intValue() + 1) % i2 : 0;
        this.f9006e.put(str, Integer.valueOf(intValue));
        postSavePrefs();
        return intValue;
    }

    private String k() {
        StringBuilder sb = new StringBuilder();
        for (String str : this.f9006e.keySet()) {
            sb.append(str);
            sb.append(',');
            sb.append(this.f9006e.get(str));
            sb.append(';');
        }
        if (sb.length() > 0 && sb.charAt(sb.length() - 1) == ';') {
            sb.deleteCharAt(sb.length() - 1);
        }
        return sb.toString();
    }

    private AdvItem l(String str, AdvLoadDataType advLoadDataType, boolean z) {
        List<AdvItem> m = m(str, advLoadDataType, z);
        if (m == null || m.size() <= 0) {
            return null;
        }
        AdvItem advItem = m.get(j(str, m.size()));
        advItem.exePvTaskShow();
        return advItem;
    }

    private List<AdvItem> m(String str, AdvLoadDataType advLoadDataType, boolean z) {
        ArrayList n;
        boolean z2;
        if (!this.f9013l) {
            return new ArrayList();
        }
        if (this.f9011j.isStopAdv()) {
            n = this.f9011j.getDefaultAdvItems(str);
        } else if (advLoadDataType == AdvLoadDataType.FORCE_ONLY_NETWORK) {
            n = this.f9005d.n(str, z);
        } else if (advLoadDataType == AdvLoadDataType.ONLY_DEFAULT) {
            n = this.f9011j.getDefaultAdvItems(str);
        } else if (advLoadDataType == AdvLoadDataType.NETWORK_AND_DEFAULT) {
            n = new ArrayList();
            List<AdvItem> defaultAdvItems = this.f9011j.getDefaultAdvItems(str);
            List<AdvItem> n2 = this.f9005d.n(str, z);
            if (n2 != null) {
                n.addAll(n2);
            }
            if (defaultAdvItems != null) {
                n.addAll(defaultAdvItems);
            }
        } else {
            n = this.f9005d.n(str, z);
            if (n == null || n.size() <= 0) {
                n = this.f9011j.getDefaultAdvItems(str);
            }
        }
        if (n != null && n.size() > 0) {
            Iterator<AdvItem> it = n.iterator();
            while (true) {
                boolean z3 = false;
                boolean z4 = true;
                if (!it.hasNext()) {
                    break;
                }
                AdvItem next = it.next();
                if (next.displayCount > 0 && getGuidDisplayCount(str, next.advId) + 1 > next.displayCount) {
                    it.remove();
                    z3 = true;
                }
                if (!p(next) || z3) {
                    z4 = z3;
                } else {
                    it.remove();
                }
                if (!q(next) && !z4) {
                    it.remove();
                }
            }
            Iterator<AdvItem> it2 = n.iterator();
            while (true) {
                if (!it2.hasNext()) {
                    z2 = false;
                    break;
                } else if (it2.next().showSingle) {
                    z2 = true;
                    break;
                }
            }
            if ((z2 | getInstance().getAdvConfig().isOnlyShowHighestPriority(str)) && n.size() > 1) {
                ArrayList arrayList = new ArrayList();
                arrayList.add(n.get(0));
                n = arrayList;
            }
            return getInstance().getAdvConfig().onInterceptDuringLoaded(str, n);
        }
        return new ArrayList();
    }

    private void n(AdvConfig advConfig) {
        SPUtils.putMultiProcess(this.a, AdvConstants.KEY_LOCK_SCREEN_ACTION, advConfig.getLockScreenActivityAction());
    }

    private boolean o(String... strArr) {
        for (String str : strArr) {
            if (!TextUtils.isEmpty(str) && !new File(getDownFilePath(str)).exists()) {
                return false;
            }
        }
        return true;
    }

    private boolean p(AdvItem advItem) {
        if (this.q || advItem == null) {
            return false;
        }
        if (this.r == null) {
            ArrayList<String> arrayList = new ArrayList<>();
            this.r = arrayList;
            arrayList.add(AdvConstants.ADV_TYPE_FILTER);
            this.r.add(AdvConstants.ADV_TYPE_OPERATION);
            this.r.add(AdvConstants.ADV_TYPE_ATTRIBUTE);
        }
        return !this.r.contains(advItem.advType);
    }

    private boolean q(AdvItem advItem) {
        int i2;
        String newAddToday = this.f9011j.getNewAddToday();
        if (TextUtils.isEmpty(newAddToday) || (i2 = advItem.newAddToday) == 2 || String.valueOf(i2).equals(newAddToday)) {
            String vipStatus = this.f9011j.getVipStatus();
            if (TextUtils.isEmpty(vipStatus) || advItem.vipStatusArray == null) {
                return true;
            }
            for (int i3 = 0; i3 < advItem.vipStatusArray.length(); i3++) {
                if (vipStatus.equals(advItem.vipStatusArray.optString(i3))) {
                    return true;
                }
            }
            return false;
        }
        return false;
    }

    private void r() {
        this.f9006e.clear();
        String string = AdvPrefUtil.getInstance().getString("guid_show_index_key");
        if (string.length() > 0) {
            String[] split = string.split(";");
            if (split.length > 0) {
                for (String str : split) {
                    try {
                        String[] split2 = str.split(",");
                        if (split2.length == 2) {
                            this.f9006e.put(split2[0], Integer.valueOf(Integer.parseInt(split2[1])));
                        }
                    } catch (Exception unused) {
                    }
                }
            }
        }
        this.f9007f.clear();
        String string2 = AdvPrefUtil.getInstance().getString("guid_display_count_key");
        if (string2.length() > 0) {
            String[] split3 = string2.split(";");
            if (split3.length > 0) {
                for (String str2 : split3) {
                    try {
                        String[] split4 = str2.split(",");
                        if (split4.length == 2) {
                            String str3 = split4[0];
                            if (str3.split("__").length == 2) {
                                this.f9007f.put(str3, Integer.valueOf(Integer.parseInt(split4[1])));
                            }
                        }
                    } catch (Exception unused2) {
                    }
                }
            }
        }
        String string3 = AdvPrefUtil.getInstance().getString("app_init_stamp_key");
        this.f9012k = string3;
        if (TextUtils.isEmpty(string3)) {
            this.f9012k = String.valueOf(AdvTimeUtils.currentTimeMillisInLocal() / 1000);
            AdvPrefUtil.getInstance().putString("app_init_stamp_key", this.f9012k);
        }
    }

    private void s(AdvItem advItem) {
        if (advItem == null) {
            return;
        }
        if (!TextUtils.isEmpty(advItem.imageUrl)) {
            this.c.download(advItem.imageUrl, getDownFilePath(advItem.imageUrl), null);
            if (!getAdvConfig().isOnlyPreloadOneImageUrl(advItem.guid)) {
                for (int i2 = 0; i2 < advItem.mImageList.size(); i2++) {
                    this.c.download(advItem.mImageList.get(i2).originImageUrl, getDownFilePath(advItem.mImageList.get(i2).originImageUrl), null);
                }
            }
        }
        if (!TextUtils.isEmpty(advItem.iconUrl)) {
            this.c.download(advItem.iconUrl, getDownFilePath(advItem.iconUrl), null);
            if (!getAdvConfig().isOnlyPreloadOneImageUrl(advItem.guid)) {
                for (int i3 = 0; i3 < advItem.mIconList.size(); i3++) {
                    this.c.download(advItem.mIconList.get(i3).originImageUrl, getDownFilePath(advItem.mIconList.get(i3).originImageUrl), null);
                }
            }
        }
        t(advItem.mVideoUrl, advItem.topNavMenuImg, advItem.topNavLogoImg, advItem.topNavVipImg, advItem.bottomLeftIconBgUrl, advItem.bottomLeftIconUrl, advItem.bottomRightIconBgUrl, advItem.bottomRightIconUrl);
    }

    private void t(String... strArr) {
        for (String str : strArr) {
            if (!TextUtils.isEmpty(str)) {
                this.c.download(str, getDownFilePath(str), null);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void u() {
        String k2 = k();
        String i2 = i();
        String str = this.f9008g;
        if (str == null || !str.equals(k2)) {
            this.f9008g = k2;
            AdvPrefUtil.getInstance().putString("guid_show_index_key", k2);
        }
        String str2 = this.f9009h;
        if (str2 == null || !str2.equals(i2)) {
            this.f9009h = i2;
            AdvPrefUtil.getInstance().putString("guid_display_count_key", i2);
        }
    }

    public void ExeUrls(List<String> list) {
        if (list == null || list.size() <= 0) {
            return;
        }
        new AdvPVTask().execute(list);
    }

    public void ExecuteDexStatics() {
        new ExecuteAdvDex(this.a).StartThread();
    }

    public String GetAppName() {
        AdvConfig advConfig = this.f9011j;
        return advConfig == null ? "" : advConfig.getAppName();
    }

    public int GetAttachValue(String str, int i2) {
        return !this.f9013l ? i2 : this.f9005d.d(str, i2);
    }

    public boolean GetBestieAdvResultStatus() {
        if (this.f9013l) {
            return this.f9005d.b("rpShowAdv", Boolean.FALSE);
        }
        return false;
    }

    public boolean GetChallengeAdvResultStatus() {
        if (this.f9013l) {
            return this.f9005d.b("ptRpShowAdv", Boolean.FALSE);
        }
        return false;
    }

    public String GetJumpKey() {
        AdvConfig advConfig = this.f9011j;
        if (advConfig == null) {
            return "camera360";
        }
        String jumpLinkKey = advConfig.getJumpLinkKey();
        return TextUtils.isEmpty(jumpLinkKey) ? "camera360" : jumpLinkKey;
    }

    public boolean GetKuaifaOpen() {
        if (this.f9013l) {
            return this.f9005d.b("appWallKuaiFa", Boolean.FALSE);
        }
        return false;
    }

    public boolean GetOpenKey(String str, Boolean bool) {
        if (this.f9013l) {
            return this.f9005d.b(str, bool);
        }
        return false;
    }

    public String GetShowAppName() {
        AdvConfig advConfig = this.f9011j;
        return advConfig == null ? "" : advConfig.getShowAppName();
    }

    @Override // us.pinguo.advconfigdata.Interface.AdConfigManagerInterface
    public void addGuidDisplayCount(String str, String str2) {
        String str3 = str + "__" + str2;
        if (this.f9007f.get(str3) == null) {
            this.f9007f.put(str3, 1);
        } else {
            HashMap<String, Integer> hashMap = this.f9007f;
            hashMap.put(str3, Integer.valueOf(hashMap.get(str3).intValue() + 1));
        }
        postSavePrefs();
    }

    public byte[] advDecrypt(byte[] bArr, String str) {
        return AdvUtils.decrypt3Des(bArr, str);
    }

    public byte[] advEncrypt(byte[] bArr, String str) {
        return AdvUtils.encrypt3Des(bArr, str);
    }

    @Override // us.pinguo.advconfigdata.Interface.AdConfigManagerInterface
    public void forceUpdate(boolean z) {
        if (this.f9013l) {
            this.b.j(true, z);
        }
    }

    public AdvConfig getAdvConfig() {
        return this.f9011j;
    }

    @Override // us.pinguo.advconfigdata.Interface.AdConfigManagerInterface
    public boolean getAdvControlFlag(String str, boolean z) {
        return !this.f9013l ? z : this.f9005d.h(str, z);
    }

    @Override // us.pinguo.advconfigdata.Interface.AdConfigManagerInterface
    public int getAdvControlInt(String str, int i2) {
        return !this.f9013l ? i2 : this.f9005d.i(str, i2);
    }

    public AdvDataKeeper getAdvDataKeeper() {
        return this.f9005d;
    }

    @Override // us.pinguo.advconfigdata.Interface.AdConfigManagerInterface
    public int getAdvDataVersion() {
        if (this.f9013l) {
            return this.f9005d.m();
        }
        return 0;
    }

    public Map<String, String> getCommonHttpParams() {
        HashMap hashMap = new HashMap();
        hashMap.put("platform", TapjoyConstants.TJC_DEVICE_PLATFORM_TYPE);
        hashMap.put(IjkMediaMeta.IJKM_KEY_LANGUAGE, Locale.getDefault().toString());
        hashMap.put(RemoteConfigConstants.RequestFieldKey.APP_VERSION, this.f9011j.getAppVersion(this.a));
        hashMap.put("appVersionCode", this.f9011j.getAppVersionCode(this.a));
        hashMap.put("channel", this.f9011j.getAppChannel());
        hashMap.put("appName", this.f9011j.getAppName());
        hashMap.put("growingIOUserId", this.f9011j.getGrowingIOUserId());
        if (this.f9011j.getRequestMode() == AdvConstants.MODE_OFFICE) {
            hashMap.put("checkSum", AdvPrefUtil.getInstance().getString(AdvConstants.KEY_CHECKSUM));
        }
        hashMap.put("curtime", String.valueOf(System.currentTimeMillis()));
        String a2 = a();
        if (!TextUtils.isEmpty(a2)) {
            hashMap.put("upgradeTime", a2);
        }
        String geoLocation = this.f9011j.getGeoLocation();
        if (geoLocation != null && !geoLocation.isEmpty()) {
            hashMap.put("geoInfo", geoLocation);
        }
        String str = Build.MODEL;
        if (!TextUtils.isEmpty(str)) {
            str = str.replaceAll(" ", "");
        }
        hashMap.put(TapjoyConstants.TJC_NOTIFICATION_DEVICE_PREFIX, str);
        String gpId = this.f9011j.getGpId();
        if (!TextUtils.isEmpty(gpId)) {
            hashMap.put("gpid", gpId);
        }
        String deviceID = AdvSystemUtils.getDeviceID(this.a);
        hashMap.put(DeviceInfo.TAG_ANDROID_ID, deviceID);
        hashMap.put("deviceId", deviceID);
        hashMap.put("systemVersion", Build.VERSION.RELEASE);
        hashMap.put("systemVersionCode", Build.VERSION.SDK_INT + "");
        String userId = this.f9011j.getUserId();
        if (!TextUtils.isEmpty(userId)) {
            hashMap.put(GuestProfileFragment.USER_ID, userId);
        }
        if (w.equals(s)) {
            hashMap.put("version", "0");
        } else {
            hashMap.put("version", String.valueOf(this.f9005d.m()));
        }
        if (!TextUtils.isEmpty(getInstance().getInitStamp())) {
            hashMap.put("initStamp", getInstance().getInitStamp());
        }
        String vipStatus = this.f9011j.getVipStatus();
        String newAddToday = this.f9011j.getNewAddToday();
        if (!TextUtils.isEmpty(vipStatus)) {
            hashMap.put("vipStatus", vipStatus);
        }
        if (!TextUtils.isEmpty(newAddToday)) {
            hashMap.put("newAddToday", newAddToday);
        }
        HashMap<String, String> customRequestParams = this.f9011j.getCustomRequestParams();
        if (customRequestParams != null) {
            hashMap.putAll(customRequestParams);
        }
        return hashMap;
    }

    public Context getContext() {
        return this.a;
    }

    public String getDownFilePath(String str) {
        AdvImageDownloader advImageDownloader = this.c;
        if (advImageDownloader == null) {
            return null;
        }
        return advImageDownloader.getDownloadedImageCachePath(this.a, str);
    }

    @Override // us.pinguo.advconfigdata.Interface.AdConfigManagerInterface
    public int getGuidDisplayCount(String str, String str2) {
        String str3 = str + "__" + str2;
        if (this.f9007f.get(str3) != null) {
            return this.f9007f.get(str3).intValue();
        }
        return 0;
    }

    public String getHomeAdvSdk() {
        if (this.f9013l) {
            return this.f9005d.c("fpSdkType");
        }
        return null;
    }

    public AdvImageDownloader getImageDownloader() {
        return this.c;
    }

    @Override // us.pinguo.advconfigdata.Interface.AdConfigManagerInterface
    public String getInitStamp() {
        return !this.f9013l ? "" : this.f9012k;
    }

    @Override // us.pinguo.advconfigdata.Interface.AdConfigManagerInterface
    public AdvItem getItem(String str) {
        return l(str, AdvLoadDataType.ONLY_NETWORK, false);
    }

    public AdvItem getItemDefault(String str) {
        return l(str, AdvLoadDataType.ONLY_NETWORK, true);
    }

    public AdvItem getItemHightPrioritys(String str) {
        AdvLoadDataType advLoadDataType = AdvLoadDataType.ONLY_NETWORK;
        List<AdvItem> m = m(str, advLoadDataType, false);
        if (m == null || m.size() <= 0) {
            m = m(str, advLoadDataType, true);
        }
        if (m == null || m.size() <= 0) {
            return null;
        }
        AdvItem advItem = m.get(0);
        advItem.exePvTaskShow();
        return advItem;
    }

    @Override // us.pinguo.advconfigdata.Interface.AdConfigManagerInterface
    public List<AdvItem> getItems(String str) {
        return getItems(str, AdvLoadDataType.ONLY_NETWORK);
    }

    @Override // us.pinguo.advconfigdata.Interface.AdConfigManagerInterface
    public List<AdvItem> getItemsNotForUI(String str) {
        return m(str, AdvLoadDataType.ONLY_NETWORK, false);
    }

    @Override // us.pinguo.advconfigdata.Interface.AdConfigManagerInterface
    public AdvItem getNextItem(String str, String str2, boolean z) {
        List<AdvItem> items;
        if (!TextUtils.isEmpty(str2) && (items = getItems(str2)) != null && items.size() > 0) {
            int i2 = 0;
            if (TextUtils.isEmpty(str)) {
                if (!z) {
                    return items.get(0);
                }
                while (i2 < items.size()) {
                    AdvItem loadDownloadedImage = loadDownloadedImage(items.get(i2));
                    if (loadDownloadedImage != null) {
                        return loadDownloadedImage;
                    }
                    i2++;
                }
                return null;
            }
            int i3 = -1;
            int i4 = 0;
            while (true) {
                if (i4 >= items.size()) {
                    break;
                } else if (str.equals(items.get(i4).advId)) {
                    i3 = i4;
                    break;
                } else {
                    i4++;
                }
            }
            if (z) {
                for (int i5 = i3 + 1; i5 < items.size(); i5++) {
                    AdvItem loadDownloadedImage2 = loadDownloadedImage(items.get(i5));
                    if (loadDownloadedImage2 != null) {
                        return loadDownloadedImage2;
                    }
                }
                while (i2 <= i3) {
                    AdvItem loadDownloadedImage3 = loadDownloadedImage(items.get(i2));
                    if (loadDownloadedImage3 != null) {
                        return loadDownloadedImage3;
                    }
                    i2++;
                }
                return null;
            }
            for (int i6 = i3 + 1; i6 < items.size(); i6++) {
                AdvItem advItem = items.get(i6);
                if (advItem != null) {
                    return advItem;
                }
            }
            while (i2 <= i3) {
                AdvItem advItem2 = items.get(i2);
                if (advItem2 != null) {
                    return advItem2;
                }
                i2++;
            }
        }
        return null;
    }

    public boolean getPlanBopen() {
        if (this.f9013l) {
            return this.f9005d.e();
        }
        return true;
    }

    public Handler getUIHandler() {
        return this.n;
    }

    @Override // us.pinguo.advconfigdata.Interface.AdConfigManagerInterface
    public void init(Context context, AdvConfig advConfig, AdvStaticsticInterface advStaticsticInterface) {
        this.a = context.getApplicationContext();
        this.f9011j = advConfig;
        AdvStaticsticManager.GetInstance().Init(advStaticsticInterface);
        int requestMode = this.f9011j.getRequestMode();
        AdvPrefUtil.getInstance().init(this.a);
        if (requestMode == AdvConstants.MODE_QA) {
            w = s;
        } else if (requestMode == AdvConstants.MODE_DEV) {
            w = t;
        } else if (requestMode == AdvConstants.MODE_OFFICE) {
            if (b()) {
                w = v;
            } else {
                w = u;
            }
            AdvLog.mbLog = false;
        }
        AD_REQUEST_URL = w + "/api/v1/list";
        AD_CALLBACK_REPAIR = w + "/api/task/callback";
        c();
        this.b = new AdvUpdateTask(this.a);
        this.c = new AdvImageDownloader(this.a);
        this.f9005d = new AdvDataKeeper(this.a);
        AdvThirdManager.InitThirdManager(this.a);
        this.p = new AdvThirdItemCache(this.a);
        r();
        this.f9013l = true;
        n(this.f9011j);
    }

    @Override // us.pinguo.advconfigdata.Interface.AdConfigManagerInterface
    public boolean isAdvIdExists(List<String> list, String str) {
        if (this.f9013l) {
            return this.f9005d.r(list, str);
        }
        return false;
    }

    public boolean isSupportTelCharge() {
        if (this.f9013l) {
            return this.f9005d.b("isOpenTelCharge", Boolean.TRUE);
        }
        return false;
    }

    @Override // us.pinguo.advconfigdata.Interface.AdConfigManagerInterface
    public AdvItem loadDownloadedImage(String str) {
        if (this.f9013l) {
            return loadDownloadedImage(getItem(str));
        }
        return null;
    }

    @Override // us.pinguo.advconfigdata.Interface.AdConfigManagerInterface
    public boolean loadImage(String str, AdvDownLoadLisenter advDownLoadLisenter) {
        if (this.f9013l && !TextUtils.isEmpty(str)) {
            if (AdvUtils.isHttpUrl(str)) {
                this.c.download(str, getDownFilePath(str), advDownLoadLisenter);
                return true;
            } else if (advDownLoadLisenter != null) {
                advDownLoadLisenter.onLoadFailed(str, 4, "url is not http");
                return true;
            } else {
                return true;
            }
        }
        return false;
    }

    @Override // us.pinguo.advconfigdata.Interface.AdConfigManagerInterface
    public AdvItem loadPopupAdvItem(String str, String str2) {
        if (this.f9013l && !TextUtils.isEmpty(str2)) {
            List<AdvItem> itemsNotForUI = getItemsNotForUI(str);
            ArrayList arrayList = new ArrayList();
            for (AdvItem advItem : itemsNotForUI) {
                if (str2.equals(advItem.popPosition)) {
                    arrayList.add(advItem);
                }
            }
            Collections.sort(arrayList, new c(this));
            AdvItem advItem2 = arrayList.size() >= 1 ? (AdvItem) arrayList.get(0) : null;
            AdvItem advItem3 = arrayList.size() >= 2 ? (AdvItem) arrayList.get(1) : null;
            if (advItem2 == null) {
                return null;
            }
            String downFilePath = getDownFilePath(advItem2.imageUrl);
            String downFilePath2 = getDownFilePath(advItem2.iconUrl);
            if (h(advItem2, downFilePath, downFilePath2)) {
                advItem2.downloadedFilePath = downFilePath;
                advItem2.downloadedIconPath = downFilePath2;
                if (advItem3 != null) {
                    h(advItem3, getDownFilePath(advItem3.imageUrl), getDownFilePath(advItem3.iconUrl));
                }
                return advItem2;
            }
        }
        return null;
    }

    public void loadThirdAdv(String str, String str2, AdvThirdItemListener advThirdItemListener, boolean z) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            if (advThirdItemListener != null) {
                advThirdItemListener.onAdvFailed();
                return;
            }
            return;
        }
        f fVar = new f(str, advThirdItemListener);
        AdvThirdLoadTask advThirdLoadTask = this.o.get(str);
        if (advThirdLoadTask != null && !advThirdLoadTask.isFinished() && !advThirdLoadTask.isCancelled()) {
            advThirdLoadTask.setListener(fVar);
        } else if (z) {
            AdvThirdItem advThirdItem = this.p.get(str);
            if (advThirdItemListener != null) {
                if (advThirdItem != null) {
                    advThirdItemListener.onAdvLoaded(advThirdItem);
                } else {
                    advThirdItemListener.onAdvFailed();
                }
            }
        } else {
            AdvThirdLoadTask advThirdLoadTask2 = new AdvThirdLoadTask();
            advThirdLoadTask2.setListener(fVar);
            advThirdLoadTask2.execute(str2);
            this.o.put(str, advThirdLoadTask2);
        }
    }

    @Override // us.pinguo.advconfigdata.Interface.AdConfigManagerInterface
    public void minusGuidDisplayCount(String str, String str2) {
        String str3 = str + "__" + str2;
        if (this.f9007f.get(str3) != null) {
            int intValue = this.f9007f.get(str3).intValue() - 1;
            if (intValue < 0) {
                intValue = 0;
            }
            this.f9007f.put(str3, Integer.valueOf(intValue));
        }
    }

    public void notifyChange() {
        if (this.m != null) {
            this.n.post(new d());
        }
    }

    public void postSavePrefs() {
        this.n.removeCallbacks(this.f9010i);
        this.n.post(this.f9010i);
    }

    public void preload() {
        List<AdvItem> p;
        this.f9011j.onAdvPreload(this.f9005d.g("preload"));
        int currentNetType = AdvUtils.currentNetType(this.a);
        if (currentNetType >= 4 && (p = this.f9005d.p(this.f9011j.getPreloadDownloadedImageGuids(), false)) != null && p.size() > 0) {
            for (AdvItem advItem : p) {
                if (advItem.nonWifiPicPreload || currentNetType == 16) {
                    if (AdvThirdManager.getThirdManager().needLoadThirdAdv(advItem.interactionUri)) {
                        AdvThirdManager.getThirdManager().loadThirdAdv((AdvThirdItemListener) new e(this), false, advItem.guid, advItem.interactionUri);
                    } else {
                        s(advItem);
                    }
                }
            }
        }
    }

    public void refresh() {
        preload();
    }

    @Override // us.pinguo.advconfigdata.Interface.AdConfigManagerInterface
    public String requestUrl(String str) throws IOException, GeneralSecurityException {
        return requestUrl(str, null);
    }

    @Override // us.pinguo.advconfigdata.Interface.AdConfigManagerInterface
    public void resetAdvVersion() {
        if (this.f9013l) {
            new b().execute(new Object[0]);
        }
    }

    @Override // us.pinguo.advconfigdata.Interface.AdConfigManagerInterface
    public void scheduleUpdate() {
        if (this.f9013l) {
            this.b.j(false, true);
        }
    }

    public void setAdEnable(boolean z) {
        this.q = z;
    }

    @Override // us.pinguo.advconfigdata.Interface.AdConfigManagerInterface
    public void setAdvChangeListener(AdvDataChangeListener advDataChangeListener) {
        if (this.f9013l) {
            this.m = advDataChangeListener;
        }
    }

    public void setIsInited(Boolean bool) {
        this.f9013l = bool.booleanValue();
    }

    @Override // us.pinguo.advconfigdata.Interface.AdConfigManagerInterface
    public List<AdvItem> getItems(String str, AdvLoadDataType advLoadDataType) {
        List<AdvItem> m = m(str, advLoadDataType, false);
        if (m == null || m.size() <= 0) {
            m = m(str, advLoadDataType, true);
        }
        for (int i2 = 0; i2 < m.size(); i2++) {
            m.get(i2).exePvTaskShow();
        }
        return m;
    }

    public String requestUrl(String str, HashMap<String, String> hashMap) throws IOException, GeneralSecurityException {
        Map<String, String> commonHttpParams = getInstance().getCommonHttpParams();
        if (hashMap != null) {
            for (String str2 : hashMap.keySet()) {
                commonHttpParams.put(str2, hashMap.get(str2));
            }
        }
        String sigByParamMap = AdvUtils.getSigByParamMap(commonHttpParams, getInstance().getAdvConfig().getHttpRequestMD5Secret());
        String url = AdvUtils.getUrl(str, commonHttpParams);
        return AdvUtils.get(url + "&sig=" + sigByParamMap);
    }

    public void setAdEnable(boolean z, String... strArr) {
        this.q = z;
        this.r = new ArrayList<>();
        for (String str : strArr) {
            this.r.add(str);
        }
    }

    public String GetOpenKey(String str, String str2) {
        return !this.f9013l ? str2 : this.f9005d.a(str, str2);
    }

    public boolean getAdvControlFlag(String str) {
        return getAdvControlFlag(str, false);
    }

    /* JADX WARN: Removed duplicated region for block: B:41:0x00a1  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x00a4  */
    /* JADX WARN: Removed duplicated region for block: B:44:0x00a8  */
    /* JADX WARN: Removed duplicated region for block: B:65:0x013a  */
    /* JADX WARN: Removed duplicated region for block: B:71:0x0147  */
    @Override // us.pinguo.advconfigdata.Interface.AdConfigManagerInterface
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public us.pinguo.advconfigdata.database.AdvItem loadDownloadedImage(us.pinguo.advconfigdata.database.AdvItem r13) {
        /*
            Method dump skipped, instructions count: 348
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: us.pinguo.advconfigdata.AdvConfigManager.loadDownloadedImage(us.pinguo.advconfigdata.database.AdvItem):us.pinguo.advconfigdata.database.AdvItem");
    }

    public void addGuidDisplayCount(AdvItem advItem) {
        if (advItem == null) {
            return;
        }
        addGuidDisplayCount(advItem.guid, advItem.advId);
    }

    @Override // us.pinguo.advconfigdata.Interface.AdConfigManagerInterface
    public AdvThirdItem loadDownloadedImage(AdvThirdItem advThirdItem) {
        if (this.f9013l && advThirdItem != null && AdvUtils.isHttpUrl(advThirdItem.icon)) {
            boolean z = false;
            String downFilePath = getDownFilePath(advThirdItem.icon);
            if (!AdvUtils.isHttpUrl(advThirdItem.icon) || (downFilePath != null && new File(downFilePath).exists())) {
                z = true;
            }
            if (z) {
                advThirdItem.downloadedIconPath = downFilePath;
                return advThirdItem;
            }
            if (!TextUtils.isEmpty(downFilePath)) {
                this.c.download(advThirdItem.icon, downFilePath, null);
            }
            return null;
        }
        return null;
    }
}
