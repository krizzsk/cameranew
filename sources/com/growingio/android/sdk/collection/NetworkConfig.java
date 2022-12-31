package com.growingio.android.sdk.collection;

import android.text.TextUtils;
import com.android.billingclient.api.BillingClient;
import com.growingio.android.sdk.utils.Util;
import us.pinguo.common.network.common.header.PGTransHeader;
/* loaded from: classes2.dex */
public class NetworkConfig {
    private static final String JAVA_CIRCLE_PLUGIN_URL = "%s/android/sdk/vds-plugin-v3.zip";
    private static NetworkConfig sInstance = new NetworkConfig();
    private final String DEFAULT_AD_HOST;
    private final String DEFAULT_ASSETS_HOST;
    private final String DEFAULT_DEEPLINK;
    private final String DEFAULT_END_POINT;
    private final String DEFAULT_FORMATTER_API_HOST;
    private final String DEFAULT_FORMATTER_CRASH_REPORT_V2;
    private final String DEFAULT_FORMATTER_TAGS_HOST;
    private final String DEFAULT_FORMATTER_TRACK_HOST;
    private final String DEFAULT_FORMATTER_WS_DATA_CHECK;
    private final String DEFAULT_FORMATTER_WS_ENDPOINT;
    private final String DEFAULT_FORMATTER_WS_HOST;
    private final String DEFAULT_HybridJSSDKUrlPrefix;
    private final String FORMATTER_CIRCLE_PAGE;
    private final String JS_CIRCLE_URL;
    private final String JS_HYBRID_URL;
    private final String JS_WEB_CIRCLE_URL;
    private String customAdHost;
    private String customApiHost;
    private String customEndPoint;
    private String customReportHost;
    private String customerAssetsHost;
    private String customerGtaHost;
    private String customerHybridJSSDKUrlPrefix;
    private String customerJavaCirclePluginHost;
    private String customerTagsHost;
    private String customerWsHost;
    private boolean isOP;
    private String zone;

    private NetworkConfig() {
        boolean ISOP = GConfig.ISOP();
        this.isOP = ISOP;
        this.DEFAULT_END_POINT = ISOP ? "" : "https://www.growingio.com";
        this.DEFAULT_FORMATTER_API_HOST = ISOP ? "" : "https://api%s.growingio.com/v3";
        this.DEFAULT_FORMATTER_CRASH_REPORT_V2 = ISOP ? "" : "https://crashapi%s.growingio.com/v2";
        this.DEFAULT_FORMATTER_TAGS_HOST = ISOP ? "" : "https://tags%s.growingio.com";
        this.DEFAULT_FORMATTER_WS_HOST = ISOP ? "" : "wss://gta%s.growingio.com";
        this.DEFAULT_FORMATTER_WS_ENDPOINT = ISOP ? "" : "/app/%s/circle/%s";
        this.DEFAULT_FORMATTER_WS_DATA_CHECK = "%s/feeds/apps/%s/exchanges/data-check/%s?clientType=sdk";
        this.DEFAULT_FORMATTER_TRACK_HOST = ISOP ? "" : "https://t%s.growingio.com/app";
        this.DEFAULT_ASSETS_HOST = ISOP ? "" : "https://assets.giocdn.com";
        this.DEFAULT_HybridJSSDKUrlPrefix = ISOP ? "" : "https://assets.giocdn.com/sdk/hybrid";
        this.DEFAULT_DEEPLINK = "https://t.growingio.com/app/%s/%s/devices";
        this.DEFAULT_AD_HOST = "https://t.growingio.com";
        this.FORMATTER_CIRCLE_PAGE = "%s/apps/circle/embedded.html";
        this.JS_HYBRID_URL = "%s/2.0/gio_hybrid.min.js?sdkVer=%s&platform=Android";
        this.JS_CIRCLE_URL = "%s/1.1/vds_hybrid_circle_plugin.min.js?sdkVer=%s&platform=Android";
        this.JS_WEB_CIRCLE_URL = "%s/2.0/vds_web_circle_plugin.min.js";
        this.zone = null;
        this.customReportHost = null;
        this.customEndPoint = null;
        this.customerGtaHost = null;
        this.customerTagsHost = null;
        this.customerWsHost = null;
        this.customerHybridJSSDKUrlPrefix = null;
        this.customerJavaCirclePluginHost = null;
        this.customerAssetsHost = null;
        this.customAdHost = null;
    }

    private String formatHost(String str) {
        String trim = str.trim();
        if (!Util.isHttpsUrl(trim) && !Util.isHttpUrl(trim)) {
            trim = Constants.HTTPS_PROTOCOL_PREFIX + trim;
        }
        return trim.endsWith("/") ? trim.substring(0, trim.length() - 1) : trim;
    }

    public static NetworkConfig getInstance() {
        return sInstance;
    }

    public String adHost() {
        return TextUtils.isEmpty(this.customAdHost) ? "https://t.growingio.com" : this.customAdHost;
    }

    public String apiEndPoint() {
        if (TextUtils.isEmpty(this.customApiHost)) {
            return String.format(this.DEFAULT_FORMATTER_API_HOST, zoneInfo());
        }
        return this.customApiHost + "/v3";
    }

    public String crashReportEndPoint() {
        return String.format(this.DEFAULT_FORMATTER_CRASH_REPORT_V2, zoneInfo());
    }

    public String getAppLinkParamsUrl(String str, boolean z) {
        CoreAppState coreAppState = CoreInitialize.coreAppState();
        String projectId = coreAppState.getProjectId();
        String spn = coreAppState.getSPN();
        String str2 = z ? BillingClient.SkuType.INAPP : "defer";
        return "https://t.growingio.com/app/at6/" + str2 + "/android/" + projectId + "/" + spn + "/" + str;
    }

    public String getAssetsHost() {
        return TextUtils.isEmpty(this.customerAssetsHost) ? this.DEFAULT_ASSETS_HOST : this.customerAssetsHost;
    }

    public String getCirclePageUrl() {
        return String.format("%s/apps/circle/embedded.html", getAssetsHost());
    }

    public String getDeeplinkHost() {
        return "https://t.growingio.com/app/%s/%s/devices";
    }

    public String getEndPoint() {
        return TextUtils.isEmpty(this.customEndPoint) ? this.DEFAULT_END_POINT : this.customEndPoint;
    }

    public String getGtaHost() {
        return this.customerGtaHost;
    }

    public String getJSWebCircleUrl() {
        Object[] objArr = new Object[1];
        objArr[0] = TextUtils.isEmpty(this.customerHybridJSSDKUrlPrefix) ? this.DEFAULT_HybridJSSDKUrlPrefix : this.customerHybridJSSDKUrlPrefix;
        return String.format("%s/2.0/vds_web_circle_plugin.min.js", objArr);
    }

    public String getJS_CIRCLE_URL() {
        Object[] objArr = new Object[2];
        objArr[0] = TextUtils.isEmpty(this.customerHybridJSSDKUrlPrefix) ? this.DEFAULT_HybridJSSDKUrlPrefix : this.customerHybridJSSDKUrlPrefix;
        objArr[1] = GConfig.GROWING_VERSION;
        return String.format("%s/1.1/vds_hybrid_circle_plugin.min.js?sdkVer=%s&platform=Android", objArr);
    }

    public String getJS_HYBRID_URL() {
        Object[] objArr = new Object[2];
        objArr[0] = TextUtils.isEmpty(this.customerHybridJSSDKUrlPrefix) ? this.DEFAULT_HybridJSSDKUrlPrefix : this.customerHybridJSSDKUrlPrefix;
        objArr[1] = GConfig.GROWING_VERSION;
        return String.format("%s/2.0/gio_hybrid.min.js?sdkVer=%s&platform=Android", objArr);
    }

    public String getJavaCirclePluginUrl() {
        return String.format(JAVA_CIRCLE_PLUGIN_URL, getAssetsHost());
    }

    public String getMobileLinkUrl() {
        return getEndPoint() + Constants.WEB_CIRCLE_TAIL;
    }

    public String getTargetApiEventPoint() {
        return getEndPoint() + Constants.EVENT_TAIL;
    }

    public String getTargetApiRealTimePoint() {
        return getEndPoint() + Constants.REALTIME_TAIL;
    }

    public String getWSEndPointFormatter() {
        StringBuilder sb;
        String str;
        if (TextUtils.isEmpty(this.customerWsHost)) {
            sb = new StringBuilder();
            str = String.format(this.DEFAULT_FORMATTER_WS_HOST, zoneInfo());
        } else {
            sb = new StringBuilder();
            str = this.customerWsHost;
        }
        sb.append(str);
        sb.append(this.DEFAULT_FORMATTER_WS_ENDPOINT);
        return sb.toString();
    }

    public String getWsDataCheckUrl(String str, String str2, String str3) {
        return String.format("%s/feeds/apps/%s/exchanges/data-check/%s?clientType=sdk", str, str2, str3);
    }

    public String getXPathRankAPI() {
        return getEndPoint() + Constants.XRANK_TAIL;
    }

    public void setAdHost(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        this.customAdHost = str;
    }

    public void setApiHost(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        this.customApiHost = formatHost(str);
    }

    public void setAssetsHost(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        this.customerAssetsHost = formatHost(str);
    }

    public void setDEFAULT_HybridJSSDKUrlPrefix(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        this.customerHybridJSSDKUrlPrefix = formatHost(str);
    }

    public void setDataHost(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        this.customEndPoint = formatHost(str);
    }

    public void setGtaHost(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        this.customerGtaHost = formatHost(str);
    }

    @Deprecated
    public void setJavaCirclePluginHost(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        this.customerJavaCirclePluginHost = formatHost(str);
    }

    public void setReportHost(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        this.customReportHost = formatHost(str);
    }

    public void setTagsHost(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        this.customerTagsHost = formatHost(str);
    }

    public void setWsHost(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        this.customerWsHost = str;
    }

    public void setZone(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        this.zone = str;
    }

    public String tagsHost() {
        return TextUtils.isEmpty(this.customerTagsHost) ? String.format(this.DEFAULT_FORMATTER_TAGS_HOST, zoneInfo()) : this.customerTagsHost;
    }

    public String trackHost() {
        return TextUtils.isEmpty(this.customReportHost) ? String.format(this.DEFAULT_FORMATTER_TRACK_HOST, zoneInfo()) : this.customReportHost;
    }

    public String zoneInfo() {
        if (TextUtils.isEmpty(this.zone)) {
            return "";
        }
        return PGTransHeader.CONNECTOR + this.zone;
    }
}
