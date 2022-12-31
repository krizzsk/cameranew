package com.growingio.android.sdk.collection;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.content.Context;
import android.os.Build;
import android.provider.Settings;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import android.webkit.WebSettings;
import android.webkit.WebView;
import com.google.android.gms.ads.identifier.AdvertisingIdClient;
import com.growingio.android.sdk.utils.ClassExistHelper;
import com.growingio.android.sdk.utils.LogUtil;
import com.growingio.android.sdk.utils.OaidHelper1010;
import com.growingio.android.sdk.utils.OaidHelper1013;
import com.growingio.android.sdk.utils.OaidHelper1025;
import com.growingio.android.sdk.utils.PermissionUtil;
import com.growingio.android.sdk.utils.PersistUtil;
import com.tapjoy.TapjoyConstants;
import java.net.Inet4Address;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.nio.charset.Charset;
import java.util.Enumeration;
import java.util.UUID;
/* loaded from: classes2.dex */
public class DeviceUUIDFactory {
    private static final String PREFS_DEVICE_ID = "device_id";
    private static final String PREFS_FILE = "device_id.xml";
    boolean androidIdEnable;
    private CoreAppState coreAppState;
    private String deviceId;
    private String googleAdId;
    boolean googleIdEnable;
    boolean imeiEnable;
    private String oaid;
    boolean oaidEnable;
    private final String TAG = "Gio.DeviceUUIDFactory";
    private final String ORIGIN_IMEI = "";
    private String imei = "";
    private String androidId = null;
    private String ip = null;
    private String userAgent = "";

    /* JADX INFO: Access modifiers changed from: package-private */
    public DeviceUUIDFactory() {
    }

    @SuppressLint({"HardwareIds"})
    @TargetApi(9)
    private void calculateDeviceId(Context context) {
        initAndroidID(context);
        if (!TextUtils.isEmpty(this.androidId) && !"9774d56d682e549c".equals(this.androidId)) {
            this.deviceId = UUID.nameUUIDFromBytes(this.androidId.getBytes(Charset.forName("UTF-8"))).toString();
        } else {
            initIMEI();
            if (!TextUtils.isEmpty(this.imei)) {
                this.deviceId = UUID.nameUUIDFromBytes(this.imei.getBytes(Charset.forName("UTF-8"))).toString();
            }
        }
        if (TextUtils.isEmpty(this.deviceId)) {
            this.deviceId = UUID.randomUUID().toString();
        }
        PersistUtil.saveDeviceId(this.deviceId);
    }

    private void getOldDeviceId(Context context) {
        String string = context.getSharedPreferences(PREFS_FILE, 0).getString(PREFS_DEVICE_ID, null);
        if (TextUtils.isEmpty(string)) {
            return;
        }
        this.deviceId = string;
        PersistUtil.saveDeviceId(string);
    }

    private synchronized void initDeviceId(Context context) {
        if (TextUtils.isEmpty(this.deviceId)) {
            String fetchDeviceId = PersistUtil.fetchDeviceId();
            this.deviceId = fetchDeviceId;
            if (TextUtils.isEmpty(fetchDeviceId)) {
                getOldDeviceId(context);
                if (!TextUtils.isEmpty(this.deviceId)) {
                    return;
                }
                calculateDeviceId(context);
            }
        }
    }

    private synchronized void initGoogleAdId(Context context) {
        if (this.googleIdEnable && ClassExistHelper.issHasAdvertisingIdClient()) {
            this.googleAdId = AdvertisingIdClient.getAdvertisingIdInfo(context).getId();
        } else {
            this.googleAdId = null;
        }
    }

    @SuppressLint({"HardwareIds"})
    private synchronized void initIMEI() {
        if (this.imeiEnable && ("".equals(this.imei) || this.imei == null)) {
            if (PermissionUtil.checkReadPhoneStatePermission()) {
                this.imei = ((TelephonyManager) this.coreAppState.getGlobalContext().getSystemService("phone")).getDeviceId();
            }
        }
    }

    private synchronized void initIp() {
        if (PermissionUtil.hasInternetPermission()) {
            Enumeration<NetworkInterface> networkInterfaces = NetworkInterface.getNetworkInterfaces();
            while (networkInterfaces.hasMoreElements()) {
                Enumeration<InetAddress> inetAddresses = networkInterfaces.nextElement().getInetAddresses();
                while (inetAddresses.hasMoreElements()) {
                    InetAddress nextElement = inetAddresses.nextElement();
                    if ((nextElement instanceof Inet4Address) && !nextElement.isLoopbackAddress()) {
                        this.ip = nextElement.getHostAddress() != null ? nextElement.getHostAddress() : "";
                    }
                }
            }
        }
    }

    private synchronized void initOAID(Context context) {
        if (this.oaidEnable) {
            if (ClassExistHelper.isHasMSA1025()) {
                this.oaid = new OaidHelper1025().getOaid(context);
            } else if (ClassExistHelper.isHasMSA1013()) {
                this.oaid = new OaidHelper1013().getOaid(context);
            } else if (ClassExistHelper.isHasMSA1010()) {
                this.oaid = new OaidHelper1010().getOaid(context);
            }
        }
    }

    public String getAndroidId() {
        if (this.androidId == null) {
            initAndroidID(this.coreAppState.getGlobalContext());
        }
        return this.androidId;
    }

    public String getDeviceId() {
        return this.deviceId;
    }

    public String getGoogleAdId() {
        if (this.googleAdId == null) {
            initGoogleAdId(this.coreAppState.getGlobalContext());
        }
        return this.googleAdId;
    }

    public String getIMEI() {
        if ("".equals(this.imei)) {
            initIMEI();
        }
        return this.imei;
    }

    public String getIp() {
        if (this.ip == null) {
            initIp();
        }
        return this.ip;
    }

    public String getOaid() {
        if (this.oaid == null) {
            initOAID(this.coreAppState.getGlobalContext());
        }
        return this.oaid;
    }

    public String getUserAgent() {
        return this.userAgent;
    }

    public synchronized void initAndroidID(Context context) {
        if (this.androidIdEnable && this.androidId == null) {
            this.androidId = Settings.System.getString(context.getContentResolver(), TapjoyConstants.TJC_ANDROID_ID);
        }
    }

    public void initUserAgent(Context context) {
        if (context == null || !TextUtils.isEmpty(this.userAgent)) {
            return;
        }
        String property = System.getProperty("http.agent");
        this.userAgent = property;
        if (TextUtils.isEmpty(property) && PermissionUtil.hasInternetPermission() && GConfig.collectWebViewUserAgent) {
            try {
                this.userAgent = new WebView(context).getSettings().getUserAgentString();
            } catch (Exception e2) {
                LogUtil.e("Gio.DeviceUUIDFactory", e2.getMessage());
                if (Build.VERSION.SDK_INT >= 17) {
                    try {
                        this.userAgent = WebSettings.getDefaultUserAgent(context);
                    } catch (Exception e3) {
                        LogUtil.e("Gio.DeviceUUIDFactory", e3.getMessage());
                    }
                }
            }
        }
    }

    public DeviceUUIDFactory setAndroidIdEnable(boolean z) {
        this.androidIdEnable = z;
        return this;
    }

    public void setCoreAppState(CoreAppState coreAppState) {
        this.coreAppState = coreAppState;
    }

    public void setDeviceId(String str) {
        this.deviceId = str;
    }

    public DeviceUUIDFactory setGoogleIdEnable(boolean z) {
        this.googleIdEnable = z;
        return this;
    }

    public DeviceUUIDFactory setImeiEnable(boolean z) {
        this.imeiEnable = z;
        return this;
    }

    public DeviceUUIDFactory(Context context, Configuration configuration) {
        this.imeiEnable = configuration.imeiEnable;
        this.googleIdEnable = configuration.googleIdEnable;
        this.androidIdEnable = configuration.androidIdEnable;
        this.oaidEnable = configuration.oaidEnable;
        if (TextUtils.isEmpty(configuration.deviceId)) {
            PersistUtil.init(context);
            initDeviceId(context);
            return;
        }
        setDeviceId(configuration.deviceId);
    }
}
