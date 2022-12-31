package com.growingio.android.sdk.collection;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.Point;
import android.text.TextUtils;
import android.util.Pair;
import androidx.annotation.VisibleForTesting;
import com.facebook.common.callercontext.ContextChain;
import com.growingio.android.sdk.base.event.DBInitDiagnose;
import com.growingio.android.sdk.deeplink.DeeplinkCallback;
import com.growingio.android.sdk.message.HandleType;
import com.growingio.android.sdk.message.MessageHandler;
import com.growingio.android.sdk.models.ActionEvent;
import com.growingio.android.sdk.models.ViewAttrs;
import com.growingio.android.sdk.monitor.marshaller.json.JsonMarshaller;
import com.growingio.android.sdk.pending.PendingStatus;
import com.growingio.android.sdk.utils.CustomerInterface;
import com.growingio.android.sdk.utils.LogUtil;
import com.growingio.android.sdk.utils.ProcessLock;
import com.growingio.android.sdk.utils.Util;
import com.growingio.eventcenter.EventCenter;
import com.growingio.eventcenter.bus.EventBus;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Locale;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class GConfig {
    public static final String AGENT_VERSION = "autotrack-2.9.4";
    public static boolean CIRCLE_USE_ID = false;
    public static boolean DEBUG = false;
    private static final String ESID_TYPE_ALL = "all";
    public static final String GROWING_VERSION = "autotrack-2.9.4_cc04ab80";
    private static final String PREF_CELLULAR_DATA_SIZE = "pref_cellular_data_size";
    private static final String PREF_DATE = "pref_date";
    private static final String PREF_DEVICE_ACTIVATED = "pref_device_activated";
    private static final String PREF_DEVICE_ACTIVATE_INFO = "pref_device_activate_info";
    private static final String PREF_DISABLE_ALL = "pref_disable_all";
    private static final String PREF_DISABLE_CELLULAR_IMPRESSION = "pref_disable_cellular_impression";
    private static final String PREF_ECSID_FILE_NAME = "growing_ecsid";
    private static final String PREF_ENABLE_IMP = "pref_enable_imp";
    private static final String PREF_ENABLE_THROTTLE = "pref_enable_throttle";
    public static final String PREF_FILE_NAME = "growing_profile";
    private static final String PREF_FLOAT_X = "pref_float_x";
    private static final String PREF_FLOAT_Y = "pref_float_y";
    private static final String PREF_SAMPLING_RATE = "pref_sampling_rate";
    private static final String PREF_SERVER_PREFERENCES_FILE_NAME = "growing_server_pref";
    private static final String PREF_SERVER_SETTINGS = "pref_server_settings";
    private static final String PREF_SETTINGS_ETAG = "pref_settings_etag";
    private static final String PREF_SHOW_CIRCLE_TIP = "pref_show_circle_tip";
    private static final String PREF_SHOW_TAG_SUCCESS = "pref_show_tag_success";
    public static final String PREF_USER_ID_IN_APP = "pref_user_id_in_app";
    private static final String PREF_VDS_PLUGIN_LAST_MODIFIED = "pref_vds_plugin_last_modified";
    private static final String TAG = "GIO.GConfig";
    public static boolean USE_ID = false;
    public static boolean USE_RN_NAVIGATOR_PAGE = false;
    public static boolean USE_RN_OPTIMIZED_PATH = false;
    public static boolean collectWebViewUserAgent = true;
    public static boolean isReplace = false;
    public static boolean isRnMode = false;
    public static boolean sCanHook = false;
    public static String sGrowingScheme = null;
    public static boolean supportMultiCircle = true;
    private DeeplinkCallback deeplinkCallback;
    private CustomerInterface.Encryption encryptEntity;
    private ProcessLock esidLock;
    private boolean gDisableCellularImp;
    private boolean gEnableImp;
    private boolean gEnabled;
    private boolean gThrottle;
    private int imageViewCollectionSize;
    private boolean isImageViewCollectionEnable;
    private boolean isMultiProcessEnabled;
    private String mAppVersion;
    private long mCellularDataLimit;
    private String mChannel;
    private OnConfigChangeListener mConfigChangeListener;
    private Context mContext;
    private SimpleDateFormat mDateFormat;
    private boolean mDiagnoseEnabled;
    private boolean mDisableCellularImp;
    private boolean mEnableImp;
    private boolean mEnabled;
    private long mFlushInterval;
    private boolean mGDPREnabled;
    private HashMap<String, ArrayList<ViewAttrs>> mInstantFilters;
    private boolean mInstantFiltersInitialized;
    private boolean mIsHashTagEnable;
    private double mSampling;
    private SharedPreferences mServerSharedPreference;
    private long mSessionInterval;
    private SharedPreferences mSharedPreference;
    private boolean mShowTags;
    public boolean mTestMode;
    private boolean mThrottle;
    private int mTotalCellularDataSize;
    private boolean mTrackAllFragment;
    private boolean mTrackWebView;
    private int mUploadBulkSize;
    private boolean sDisableCellularImp;
    private boolean sEnableImp;
    private boolean sEnabled;
    private boolean sThrottle;

    @VisibleForTesting
    GConfig() {
        this.mDateFormat = new SimpleDateFormat("yyyy_MM_dd", Locale.US);
        this.mDiagnoseEnabled = DEBUG;
        this.mShowTags = false;
        this.mEnabled = true;
        this.mEnableImp = true;
        this.mDisableCellularImp = false;
        this.mThrottle = false;
        this.gEnabled = true;
        this.gEnableImp = false;
        this.gDisableCellularImp = false;
        this.gThrottle = false;
        this.sEnabled = true;
        this.sEnableImp = true;
        this.sDisableCellularImp = false;
        this.sThrottle = false;
        this.mGDPREnabled = true;
        this.mSampling = -1.0d;
        this.mIsHashTagEnable = false;
        this.mInstantFiltersInitialized = false;
        this.isMultiProcessEnabled = false;
        this.isImageViewCollectionEnable = true;
        this.imageViewCollectionSize = 2048;
        this.deeplinkCallback = null;
        this.encryptEntity = null;
        this.mConfigChangeListener = null;
    }

    public static boolean ISOP() {
        return false;
    }

    public static boolean ISRN() {
        return false;
    }

    public static void disableRNNavigatorPage() {
        USE_RN_NAVIGATOR_PAGE = false;
    }

    public static void disableRNOptimizedPath() {
        USE_RN_OPTIMIZED_PATH = false;
    }

    public static void enableRNNavigatorPage() {
        USE_RN_NAVIGATOR_PAGE = true;
        USE_RN_OPTIMIZED_PATH = true;
    }

    public static void enableRNOptimizedPath() {
        USE_RN_OPTIMIZED_PATH = true;
    }

    /* JADX WARN: Can't wrap try/catch for region: R(14:1|(2:2|3)|(4:4|5|(1:7)|8)|9|10|11|12|14|15|16|17|18|19|(1:(0))) */
    /* JADX WARN: Can't wrap try/catch for region: R(9:(4:4|5|(1:7)|8)|11|12|14|15|16|17|18|19) */
    /* JADX WARN: Code restructure failed: missing block: B:34:0x0077, code lost:
        r9 = th;
     */
    /* JADX WARN: Code restructure failed: missing block: B:35:0x0078, code lost:
        r1 = r8;
     */
    /* JADX WARN: Code restructure failed: missing block: B:36:0x007a, code lost:
        r9 = e;
     */
    /* JADX WARN: Code restructure failed: missing block: B:37:0x007b, code lost:
        r1 = r8;
     */
    /* JADX WARN: Code restructure failed: missing block: B:40:0x007f, code lost:
        r9 = e;
     */
    /* JADX WARN: Code restructure failed: missing block: B:41:0x0080, code lost:
        r9.printStackTrace();
     */
    /* JADX WARN: Code restructure failed: missing block: B:42:0x0083, code lost:
        if (r1 != null) goto L27;
     */
    /* JADX WARN: Code restructure failed: missing block: B:43:0x0085, code lost:
        r1.close();
     */
    /* JADX WARN: Code restructure failed: missing block: B:45:0x0089, code lost:
        r8 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:46:0x008a, code lost:
        r8.printStackTrace();
     */
    /* JADX WARN: Code restructure failed: missing block: B:49:0x00a0, code lost:
        if (r1 != null) goto L33;
     */
    /* JADX WARN: Code restructure failed: missing block: B:50:0x00a2, code lost:
        r1.close();
     */
    /* JADX WARN: Code restructure failed: missing block: B:52:0x00a6, code lost:
        r8 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:53:0x00a7, code lost:
        r8.printStackTrace();
     */
    /* JADX WARN: Code restructure failed: missing block: B:54:0x00aa, code lost:
        throw r9;
     */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:16:0x0030 -> B:58:0x0050). Please submit an issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private android.util.Pair<java.lang.Integer, java.lang.Integer> getAndAddEsidFromFile(java.lang.String r8, int r9) {
        /*
            r7 = this;
            java.lang.String r0 = "growing_ecsid"
            com.growingio.android.sdk.utils.ProcessLock r1 = r7.esidLock
            r2 = 1000(0x3e8, float:1.401E-42)
            r1.acquire(r2)
            r1 = 0
            java.io.ObjectInputStream r2 = new java.io.ObjectInputStream     // Catch: java.lang.Throwable -> L34 java.lang.Exception -> L45
            android.content.Context r3 = r7.mContext     // Catch: java.lang.Throwable -> L34 java.lang.Exception -> L45
            java.io.FileInputStream r3 = r3.openFileInput(r0)     // Catch: java.lang.Throwable -> L34 java.lang.Exception -> L45
            r2.<init>(r3)     // Catch: java.lang.Throwable -> L34 java.lang.Exception -> L45
            java.lang.Object r3 = r2.readObject()     // Catch: java.lang.Throwable -> L1c java.lang.ClassNotFoundException -> L1f java.lang.Exception -> L46
            com.growingio.android.sdk.models.EventSID r3 = (com.growingio.android.sdk.models.EventSID) r3     // Catch: java.lang.Throwable -> L1c java.lang.ClassNotFoundException -> L1f java.lang.Exception -> L46
            goto L24
        L1c:
            r8 = move-exception
            r1 = r2
            goto L35
        L1f:
            r3 = move-exception
            r3.printStackTrace()     // Catch: java.lang.Throwable -> L1c java.lang.Exception -> L46
            r3 = r1
        L24:
            if (r3 != 0) goto L2b
            com.growingio.android.sdk.models.EventSID r3 = new com.growingio.android.sdk.models.EventSID
            r3.<init>()
        L2b:
            r2.close()     // Catch: java.io.IOException -> L2f
            goto L50
        L2f:
            r2 = move-exception
            r2.printStackTrace()
            goto L50
        L34:
            r8 = move-exception
        L35:
            com.growingio.android.sdk.models.EventSID r9 = new com.growingio.android.sdk.models.EventSID
            r9.<init>()
            if (r1 == 0) goto L44
            r1.close()     // Catch: java.io.IOException -> L40
            goto L44
        L40:
            r9 = move-exception
            r9.printStackTrace()
        L44:
            throw r8
        L45:
            r2 = r1
        L46:
            com.growingio.android.sdk.models.EventSID r3 = new com.growingio.android.sdk.models.EventSID
            r3.<init>()
            if (r2 == 0) goto L50
            r2.close()     // Catch: java.io.IOException -> L2f
        L50:
            int r2 = r3.getSid(r8)
            java.lang.String r4 = "all"
            int r5 = r3.getSid(r4)
            int r6 = r2 + r9
            com.growingio.android.sdk.models.EventSID r8 = r3.setSid(r8, r6)
            int r9 = r9 + r5
            r8.setSid(r4, r9)
            java.io.ObjectOutputStream r8 = new java.io.ObjectOutputStream     // Catch: java.lang.Throwable -> L7d java.io.IOException -> L7f
            android.content.Context r9 = r7.mContext     // Catch: java.lang.Throwable -> L7d java.io.IOException -> L7f
            r4 = 0
            java.io.FileOutputStream r9 = r9.openFileOutput(r0, r4)     // Catch: java.lang.Throwable -> L7d java.io.IOException -> L7f
            r8.<init>(r9)     // Catch: java.lang.Throwable -> L7d java.io.IOException -> L7f
            r8.writeObject(r3)     // Catch: java.lang.Throwable -> L77 java.io.IOException -> L7a
            r8.close()     // Catch: java.io.IOException -> L89
            goto L8d
        L77:
            r9 = move-exception
            r1 = r8
            goto La0
        L7a:
            r9 = move-exception
            r1 = r8
            goto L80
        L7d:
            r9 = move-exception
            goto La0
        L7f:
            r9 = move-exception
        L80:
            r9.printStackTrace()     // Catch: java.lang.Throwable -> L7d
            if (r1 == 0) goto L8d
            r1.close()     // Catch: java.io.IOException -> L89
            goto L8d
        L89:
            r8 = move-exception
            r8.printStackTrace()
        L8d:
            com.growingio.android.sdk.utils.ProcessLock r8 = r7.esidLock
            r8.release()
            android.util.Pair r8 = new android.util.Pair
            java.lang.Integer r9 = java.lang.Integer.valueOf(r5)
            java.lang.Integer r0 = java.lang.Integer.valueOf(r2)
            r8.<init>(r9, r0)
            return r8
        La0:
            if (r1 == 0) goto Laa
            r1.close()     // Catch: java.io.IOException -> La6
            goto Laa
        La6:
            r8 = move-exception
            r8.printStackTrace()
        Laa:
            throw r9
        */
        throw new UnsupportedOperationException("Method not decompiled: com.growingio.android.sdk.collection.GConfig.getAndAddEsidFromFile(java.lang.String, int):android.util.Pair");
    }

    private Pair<Integer, Integer> getAndAddEsidFromSP(String str, int i2) {
        SharedPreferences sharedPreferences = this.mContext.getSharedPreferences(PREF_ECSID_FILE_NAME, 0);
        int i3 = sharedPreferences.getInt(str, 0);
        int i4 = sharedPreferences.getInt("all", 0);
        sharedPreferences.edit().putInt(str, i3 + i2).putInt("all", i2 + i4).commit();
        return new Pair<>(Integer.valueOf(i4), Integer.valueOf(i3));
    }

    public static String getProjectId() {
        return null;
    }

    private SharedPreferences getServerPreferences() {
        return this.mServerSharedPreference;
    }

    private SharedPreferences getSharedPreferences() {
        return this.mSharedPreference;
    }

    public static String getUrlScheme() {
        return null;
    }

    public static boolean isInstrumented() {
        return true;
    }

    private boolean isNewDay() {
        SharedPreferences sharedPreferences = getSharedPreferences();
        String format = this.mDateFormat.format(new Date(System.currentTimeMillis()));
        if (TextUtils.equals(format, sharedPreferences.getString(PREF_DATE, ""))) {
            return false;
        }
        sharedPreferences.edit().putString(PREF_DATE, format).commit();
        return true;
    }

    public static boolean isUsingRNNavigatorPage() {
        return USE_RN_NAVIGATOR_PAGE;
    }

    public static boolean isUsingRNOptimizedPath() {
        return USE_RN_OPTIMIZED_PATH;
    }

    private void readCellularDataSize() {
        if (isNewDay()) {
            this.mTotalCellularDataSize = 0;
            getSharedPreferences().edit().putInt(PREF_CELLULAR_DATA_SIZE, 0).commit();
            return;
        }
        this.mTotalCellularDataSize = getSharedPreferences().getInt(PREF_CELLULAR_DATA_SIZE, 0);
    }

    private void readConfigFromPref() {
        SharedPreferences sharedPreferences = getSharedPreferences();
        if (sharedPreferences.contains(PREF_ENABLE_THROTTLE)) {
            this.sThrottle = sharedPreferences.getBoolean(PREF_ENABLE_THROTTLE, false);
        }
        if (sharedPreferences.contains(PREF_ENABLE_IMP)) {
            this.sEnableImp = sharedPreferences.getBoolean(PREF_ENABLE_IMP, true);
        }
        if (sharedPreferences.contains(PREF_DISABLE_CELLULAR_IMPRESSION)) {
            this.sDisableCellularImp = sharedPreferences.getBoolean(PREF_DISABLE_CELLULAR_IMPRESSION, false);
        }
        if (sharedPreferences.contains(PREF_DISABLE_ALL)) {
            this.sEnabled = !sharedPreferences.getBoolean(PREF_DISABLE_ALL, false);
        }
        if (sharedPreferences.contains(PREF_SAMPLING_RATE)) {
            this.mSampling = sharedPreferences.getFloat(PREF_SAMPLING_RATE, 1.0f);
        }
        if (sharedPreferences.contains(PREF_SERVER_SETTINGS)) {
            getServerPreferences().edit().putString(PREF_SERVER_SETTINGS, sharedPreferences.getString(PREF_SERVER_SETTINGS, null)).commit();
            sharedPreferences.edit().remove(PREF_SERVER_SETTINGS).commit();
        }
        readCellularDataSize();
    }

    private void updateServerSettings(String str) {
        if (str == null) {
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            SharedPreferences.Editor edit = getSharedPreferences().edit();
            boolean z = true;
            if (jSONObject.has("disabled")) {
                boolean z2 = !jSONObject.getBoolean("disabled");
                this.sEnabled = z2;
                if (!z2) {
                    LogUtil.i(TAG, "GrowingIO Warning ：GIO 服务端下发关闭 SDK 指令，采集数据、圈选等功能关闭");
                }
                edit.putBoolean(PREF_DISABLE_ALL, !this.sEnabled);
            }
            if (jSONObject.has("sampling")) {
                double d2 = jSONObject.getDouble("sampling");
                this.mSampling = d2;
                edit.putFloat(PREF_SAMPLING_RATE, (float) d2);
            }
            if (jSONObject.has("throttle")) {
                boolean z3 = jSONObject.getBoolean("throttle");
                this.sThrottle = z3;
                edit.putBoolean(PREF_ENABLE_THROTTLE, z3);
            }
            if (jSONObject.has(ActionEvent.IMP_TYPE_NAME)) {
                boolean z4 = jSONObject.getBoolean(ActionEvent.IMP_TYPE_NAME);
                this.sEnableImp = z4;
                edit.putBoolean(PREF_ENABLE_IMP, z4);
            }
            if (jSONObject.has("net")) {
                if (jSONObject.getBoolean("net")) {
                    z = false;
                }
                this.sDisableCellularImp = z;
                edit.putBoolean(PREF_DISABLE_CELLULAR_IMPRESSION, z);
            }
            edit.commit();
            if (jSONObject.has(JsonMarshaller.TAGS)) {
                updateWhiteListTags(jSONObject.getJSONArray(JsonMarshaller.TAGS));
            }
        } catch (Exception e2) {
            LogUtil.e(TAG, e2.getMessage(), e2);
        }
    }

    private void updateWhiteListTags(JSONArray jSONArray) throws JSONException {
        this.mInstantFilters = new HashMap<>();
        for (int i2 = 0; i2 < jSONArray.length(); i2++) {
            JSONObject jSONObject = jSONArray.getJSONObject(i2);
            String optString = jSONObject.optString("x");
            if (!TextUtils.isEmpty(optString)) {
                int optInt = jSONObject.optInt("idx", -1);
                ViewAttrs viewAttrs = new ViewAttrs();
                String optString2 = jSONObject.optString(ContextChain.TAG_PRODUCT, null);
                String optString3 = jSONObject.optString("d");
                viewAttrs.domain = optString3;
                viewAttrs.webElem = optString3.contains(Constants.WEB_PART_SEPARATOR);
                viewAttrs.xpath = optString;
                viewAttrs.content = jSONObject.optString("v", null);
                viewAttrs.index = optInt != -1 ? String.valueOf(optInt) : null;
                ArrayList<ViewAttrs> arrayList = this.mInstantFilters.get(optString2);
                if (arrayList == null) {
                    arrayList = new ArrayList<>(1);
                    this.mInstantFilters.put(optString2, arrayList);
                }
                arrayList.add(viewAttrs);
            }
        }
    }

    public boolean canSendByCellular() {
        readCellularDataSize();
        return ((long) this.mTotalCellularDataSize) < this.mCellularDataLimit;
    }

    public void cleanUserId() {
        CoreInitialize.growingIOIPC().setUserId(null);
        OnConfigChangeListener onConfigChangeListener = this.mConfigChangeListener;
        if (onConfigChangeListener != null) {
            onConfigChangeListener.onUserIdChanged(null);
        }
    }

    public void disableAll() {
        if (getSharedPreferences().contains(PREF_DISABLE_ALL)) {
            return;
        }
        this.mEnabled = false;
    }

    public void disableImpression() {
        this.gEnableImp = false;
        mergeUserAndServerSettings();
    }

    public void enableAll() {
        this.mEnabled = true;
    }

    public void enableImpression() {
        this.gEnableImp = true;
        mergeUserAndServerSettings();
    }

    public String getActivateInfo() {
        return getSharedPreferences().getString(PREF_DEVICE_ACTIVATE_INFO, "");
    }

    public Pair<Integer, Integer> getAndAddEsid(String str, int i2) {
        if (isMultiProcessEnabled()) {
            return getAndAddEsidFromFile(str, i2);
        }
        return getAndAddEsidFromSP(str, i2);
    }

    public String getAppUserId() {
        return CoreInitialize.growingIOIPC().getUserId();
    }

    public String getAppVersion() {
        if (this.mAppVersion == null) {
            try {
                this.mAppVersion = this.mContext.getPackageManager().getPackageInfo(this.mContext.getPackageName(), 0).versionName;
            } catch (Throwable th) {
                LogUtil.e(TAG, th.getMessage(), th);
            }
        }
        return this.mAppVersion;
    }

    public String getChannel() {
        return this.mChannel;
    }

    public OnConfigChangeListener getConfigChangeListener() {
        return this.mConfigChangeListener;
    }

    public DeeplinkCallback getDeeplinkCallback() {
        return this.deeplinkCallback;
    }

    public CustomerInterface.Encryption getEncryptEntity() {
        return this.encryptEntity;
    }

    public Point getFloatPosition() {
        SharedPreferences sharedPreferences = getSharedPreferences();
        return new Point(sharedPreferences.getInt(PREF_FLOAT_X, -1), sharedPreferences.getInt(PREF_FLOAT_Y, -1));
    }

    public long getFlushInterval() {
        return this.mFlushInterval;
    }

    public int getImageViewCollectionSize() {
        return this.imageViewCollectionSize;
    }

    public HashMap<String, ArrayList<ViewAttrs>> getInstantFilters() {
        return this.mInstantFilters;
    }

    public double getSampling() {
        return this.mSampling;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public long getSessionInterval() {
        return this.mSessionInterval;
    }

    public String getSettingsETag() {
        return getSharedPreferences().getString(PREF_SETTINGS_ETAG, "");
    }

    public int getUploadBulkSize() {
        return this.mUploadBulkSize;
    }

    public long getVdsPluginLastModified() {
        return getSharedPreferences().getLong(PREF_VDS_PLUGIN_LAST_MODIFIED, 0L);
    }

    public String getsGrowingScheme() {
        return sGrowingScheme;
    }

    public void increaseCellularDataSize(int i2) {
        if (isNewDay()) {
            getSharedPreferences().edit().putInt(PREF_CELLULAR_DATA_SIZE, i2).commit();
            this.mTotalCellularDataSize = i2;
            return;
        }
        int i3 = getSharedPreferences().getInt(PREF_CELLULAR_DATA_SIZE, 0) + i2;
        this.mTotalCellularDataSize = i3;
        LogUtil.d(TAG, "cellular data usage: ", Integer.valueOf(i3));
        getSharedPreferences().edit().putInt(PREF_CELLULAR_DATA_SIZE, this.mTotalCellularDataSize).commit();
    }

    public boolean isCellularImpDisabled() {
        return this.mDisableCellularImp;
    }

    public boolean isDeviceActivated() {
        LogUtil.d(TAG, "pref_device_activated:" + getSharedPreferences().getBoolean(PREF_DEVICE_ACTIVATED, false));
        return getSharedPreferences().getBoolean(PREF_DEVICE_ACTIVATED, false) || ISOP();
    }

    public boolean isDiagnoseEnabled() {
        return this.mDiagnoseEnabled;
    }

    public boolean isEnabled() {
        return this.mGDPREnabled && this.mEnabled;
    }

    public boolean isHashTagEnable() {
        return this.mIsHashTagEnable;
    }

    public boolean isImageViewCollectionEnable() {
        return this.isImageViewCollectionEnable;
    }

    public boolean isMultiProcessEnabled() {
        return this.isMultiProcessEnabled;
    }

    public boolean isTestMode() {
        return this.mTestMode || PendingStatus.isEnable();
    }

    public boolean isThrottled() {
        return this.mThrottle;
    }

    public void mergeUserAndServerSettings() {
        boolean z = true;
        this.mEnableImp = this.gEnableImp && this.sEnableImp;
        this.mEnabled = this.gEnabled && this.sEnabled;
        this.mDisableCellularImp = this.gDisableCellularImp || this.sDisableCellularImp;
        if (!this.gThrottle && !this.sThrottle) {
            z = false;
        }
        this.mThrottle = z;
    }

    public void onBgInit(DeviceUUIDFactory deviceUUIDFactory) {
        readConfigFromPref();
        mergeUserAndServerSettings();
        if (this.mDiagnoseEnabled) {
            if (Util.isInSampling(deviceUUIDFactory.getDeviceId(), DEBUG ? 1.0d : 0.01d)) {
                EventBus.getDefault().getExecutorService().submit(new Runnable() { // from class: com.growingio.android.sdk.collection.GConfig.1
                    @Override // java.lang.Runnable
                    public void run() {
                        EventCenter.getInstance().post(new DBInitDiagnose());
                    }
                });
            } else {
                this.mDiagnoseEnabled = false;
            }
        }
        LogUtil.d(TAG, toString());
    }

    public boolean prepareInstantFilters() {
        if (!this.mInstantFiltersInitialized) {
            this.mInstantFiltersInitialized = true;
            String string = getServerPreferences().getString(PREF_SERVER_SETTINGS, null);
            if (string != null) {
                try {
                    updateWhiteListTags(new JSONObject(string).getJSONArray(JsonMarshaller.TAGS));
                } catch (JSONException e2) {
                    e2.printStackTrace();
                }
            }
        }
        return this.mInstantFilters != null;
    }

    public void saveETagForSettings(String str) {
        getSharedPreferences().edit().putString(PREF_SETTINGS_ETAG, str).commit();
    }

    @TargetApi(9)
    public void saveFloatPosition(int i2, int i3) {
        getSharedPreferences().edit().putInt(PREF_FLOAT_X, i2).putInt(PREF_FLOAT_Y, i3).apply();
    }

    @TargetApi(9)
    public void saveServerSettings(String str) {
        getServerPreferences().edit().putString(PREF_SERVER_SETTINGS, str).apply();
        updateServerSettings(str);
        mergeUserAndServerSettings();
        MessageHandler.handleMessage(524288, str);
    }

    public void setActivateInfo(String str) {
        LogUtil.d(TAG, "PREF_DEVICE_ACTIVATE_INFO 保存：" + str);
        getSharedPreferences().edit().putString(PREF_DEVICE_ACTIVATE_INFO, str).apply();
    }

    public void setAppUserId(String str) {
        CoreInitialize.growingIOIPC().setUserId(str);
        OnConfigChangeListener onConfigChangeListener = this.mConfigChangeListener;
        if (onConfigChangeListener != null) {
            onConfigChangeListener.onUserIdChanged(str);
        }
    }

    public void setChannel(String str) {
        this.mChannel = str;
    }

    public void setConfigChangeListener(OnConfigChangeListener onConfigChangeListener) {
        this.mConfigChangeListener = onConfigChangeListener;
    }

    public void setDeviceActivated() {
        getSharedPreferences().edit().putBoolean(PREF_DEVICE_ACTIVATED, true).apply();
        MessageHandler.handleMessage(HandleType.CONFIG_DEVICE_ACTIVATED, new Object[0]);
    }

    public void setGDPREnabled(boolean z) {
        this.mGDPREnabled = z;
        if (z) {
            return;
        }
        LogUtil.i(TAG, "GrowingIO Warning ：SDK 关闭采集数据、圈选等功能");
    }

    @TargetApi(9)
    public void setShowCircleTip(boolean z) {
        getSharedPreferences().edit().putBoolean(PREF_SHOW_CIRCLE_TIP, z).apply();
    }

    @TargetApi(9)
    public void setShowTagSuccess(boolean z) {
        getSharedPreferences().edit().putBoolean(PREF_SHOW_TAG_SUCCESS, z).apply();
    }

    public void setShowTags(boolean z) {
        this.mShowTags = z;
    }

    public void setThrottle(boolean z) {
        if (getSharedPreferences().contains(PREF_ENABLE_THROTTLE)) {
            return;
        }
        this.mThrottle = z;
    }

    @TargetApi(9)
    public void setVdsPluginLastModified(long j2) {
        getSharedPreferences().edit().putLong(PREF_VDS_PLUGIN_LAST_MODIFIED, j2).apply();
    }

    public boolean shouldSendImp() {
        return this.mEnableImp;
    }

    public boolean shouldShowCircleTip() {
        return getSharedPreferences().getBoolean(PREF_SHOW_CIRCLE_TIP, true);
    }

    public boolean shouldShowTagSuccess() {
        return getSharedPreferences().getBoolean(PREF_SHOW_TAG_SUCCESS, true);
    }

    public boolean shouldShowTags() {
        return this.mShowTags;
    }

    public boolean shouldTrackAllFragment() {
        return this.mTrackAllFragment;
    }

    public boolean shouldTrackWebView() {
        return this.mTrackWebView;
    }

    public String toString() {
        return "GrowingIO 配置信息：\nDEBUG: " + DEBUG + "\nEnabled: " + this.mEnabled + "\nUSE_ID: " + USE_ID + "\nContext: " + this.mContext + "\nTest Mode: " + this.mTestMode + "\nUpload bulk size: " + this.mUploadBulkSize + "\nFlush interval: " + this.mFlushInterval + "\nSession interval: " + this.mSessionInterval + "\nChannel: " + this.mChannel + "\nTrack all fragments: " + this.mTrackAllFragment + "\nEnable WebView: " + this.mTrackWebView + "\nEnable HashTag: " + this.mIsHashTagEnable + "\nCellular data limit: " + this.mCellularDataLimit + "\nTotal cellular data size: " + this.mTotalCellularDataSize + "\nSampling: " + this.mSampling + "\nEnable impression: " + shouldSendImp() + "\nThrottle: " + this.mThrottle + "\nDisable cellular impression: " + this.mDisableCellularImp + "\nInstant filter initialized: " + this.mInstantFiltersInitialized;
    }

    public GConfig(AbstractConfiguration abstractConfiguration) {
        this.mDateFormat = new SimpleDateFormat("yyyy_MM_dd", Locale.US);
        this.mDiagnoseEnabled = DEBUG;
        this.mShowTags = false;
        this.mEnabled = true;
        this.mEnableImp = true;
        this.mDisableCellularImp = false;
        this.mThrottle = false;
        this.gEnabled = true;
        this.gEnableImp = false;
        this.gDisableCellularImp = false;
        this.gThrottle = false;
        this.sEnabled = true;
        this.sEnableImp = true;
        this.sDisableCellularImp = false;
        this.sThrottle = false;
        this.mGDPREnabled = true;
        this.mSampling = -1.0d;
        this.mIsHashTagEnable = false;
        this.mInstantFiltersInitialized = false;
        this.isMultiProcessEnabled = false;
        this.isImageViewCollectionEnable = true;
        this.imageViewCollectionSize = 2048;
        this.deeplinkCallback = null;
        this.encryptEntity = null;
        this.mConfigChangeListener = null;
        this.mContext = abstractConfiguration.context.getApplicationContext();
        DEBUG = abstractConfiguration.debugMode;
        isRnMode = abstractConfiguration.rnMode;
        this.mFlushInterval = abstractConfiguration.flushInterval;
        this.mUploadBulkSize = abstractConfiguration.bulkSize;
        this.mSessionInterval = abstractConfiguration.sessionInterval;
        this.gEnabled = !abstractConfiguration.disabled;
        this.gDisableCellularImp = abstractConfiguration.disableCellularImp;
        this.gEnableImp = !abstractConfiguration.disableImpression;
        this.gThrottle = abstractConfiguration.throttle;
        this.mGDPREnabled = abstractConfiguration.gdprEnabled;
        this.mCellularDataLimit = abstractConfiguration.cellularDataLimit;
        this.mTestMode = abstractConfiguration.testMode;
        supportMultiCircle = abstractConfiguration.spmc;
        collectWebViewUserAgent = abstractConfiguration.collectWebViewUserAgent;
        this.mDiagnoseEnabled = abstractConfiguration.diagnose;
        this.mChannel = abstractConfiguration.channel;
        this.mTrackAllFragment = abstractConfiguration.trackAllFragments;
        this.mTrackWebView = abstractConfiguration.trackWebView;
        this.mIsHashTagEnable = abstractConfiguration.isHashTagEnable;
        boolean z = abstractConfiguration.useID;
        USE_ID = z;
        CIRCLE_USE_ID = z;
        sGrowingScheme = abstractConfiguration.urlScheme;
        this.isMultiProcessEnabled = abstractConfiguration.mutiprocess;
        this.isImageViewCollectionEnable = true ^ abstractConfiguration.disableImageViewCollection;
        this.deeplinkCallback = abstractConfiguration.callback;
        this.encryptEntity = abstractConfiguration.encryptEntity;
        this.esidLock = new ProcessLock(this.mContext, "growingio.lock");
        this.mSharedPreference = this.mContext.getSharedPreferences(PREF_FILE_NAME, 0);
        this.mServerSharedPreference = this.mContext.getSharedPreferences(PREF_SERVER_PREFERENCES_FILE_NAME, 0);
    }
}
