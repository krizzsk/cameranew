package com.growingio.android.sdk.collection;

import android.app.Application;
import androidx.work.WorkRequest;
import com.growingio.android.sdk.deeplink.DeeplinkCallback;
import com.growingio.android.sdk.message.MessageHandler;
import com.growingio.android.sdk.message.RealTimeMessageCallBack;
import com.growingio.android.sdk.utils.CustomerInterface;
import tv.danmaku.ijk.media.player.IjkMediaCodecInfo;
/* loaded from: classes2.dex */
public class AbstractConfiguration {
    String adHost;
    String channel;
    Application context;
    String deviceId;
    CustomerInterface.Encryption encryptEntity;
    String packageName;
    String projectId;
    boolean rnMode;
    String trackerHost;
    String urlScheme;
    String zone;
    String dataHost = null;
    String reportHost = null;
    String tagsHost = null;
    String gtaHost = null;
    String wsHost = null;
    String assetsHost = null;
    double sampling = 1.0d;
    boolean disabled = false;
    boolean gdprEnabled = true;
    boolean throttle = false;
    boolean debugMode = false;
    boolean testMode = false;
    boolean spmc = false;
    boolean collectWebViewUserAgent = true;
    boolean diagnose = false;
    boolean disableCellularImp = false;
    int bulkSize = IjkMediaCodecInfo.RANK_SECURE;
    long sessionInterval = WorkRequest.DEFAULT_BACKOFF_DELAY_MILLIS;
    long flushInterval = 15000;
    long cellularDataLimit = 10485760;
    boolean mutiprocess = false;
    DeeplinkCallback callback = null;
    boolean imeiEnable = true;
    boolean androidIdEnable = true;
    boolean googleIdEnable = true;
    boolean oaidEnable = true;
    boolean uploadExceptionEnable = true;
    String hybridJSSDKUrlPrefix = null;
    String javaCirclePluginHost = null;
    boolean disableImpression = true;
    boolean trackWebView = true;
    boolean isHashTagEnable = false;
    boolean disableImageViewCollection = true;
    int imageViewCollectionBitmapSize = 2048;
    boolean trackAllFragments = false;
    boolean useID = true;

    /* JADX INFO: Access modifiers changed from: package-private */
    public AbstractConfiguration(String str) {
        this.projectId = str;
    }

    public Configuration addRealTimeMessageCallBack(RealTimeMessageCallBack realTimeMessageCallBack) {
        MessageHandler.addCallBack(realTimeMessageCallBack);
        return (Configuration) this;
    }

    public Configuration collectWebViewUserAgent(boolean z) {
        this.collectWebViewUserAgent = z;
        return (Configuration) this;
    }

    public Configuration disableCellularImp() {
        this.disableCellularImp = true;
        return (Configuration) this;
    }

    public Configuration disableDataCollect() {
        this.gdprEnabled = false;
        return (Configuration) this;
    }

    public Configuration setAdHost(String str) {
        this.adHost = str;
        return (Configuration) this;
    }

    public Configuration setAndroidIdEnable(boolean z) {
        this.androidIdEnable = z;
        return (Configuration) this;
    }

    public Configuration setApp(Application application) {
        this.context = application;
        return (Configuration) this;
    }

    public Configuration setAssetsHost(String str) {
        this.assetsHost = str;
        return (Configuration) this;
    }

    public Configuration setBulkSize(int i2) {
        this.bulkSize = i2;
        return (Configuration) this;
    }

    public Configuration setCellularDataLimit(long j2) {
        this.cellularDataLimit = j2;
        return (Configuration) this;
    }

    public Configuration setChannel(String str) {
        this.channel = str;
        return (Configuration) this;
    }

    public Configuration setContext(Application application) {
        this.context = application;
        return (Configuration) this;
    }

    public Configuration setDataHost(String str) {
        this.dataHost = str;
        return (Configuration) this;
    }

    public Configuration setDebugMode(boolean z) {
        this.debugMode = z;
        return (Configuration) this;
    }

    public Configuration setDeeplinkCallback(DeeplinkCallback deeplinkCallback) {
        this.callback = deeplinkCallback;
        return (Configuration) this;
    }

    public Configuration setDeviceId(String str) {
        this.deviceId = str;
        return (Configuration) this;
    }

    public Configuration setDiagnose(boolean z) {
        this.diagnose = z;
        return (Configuration) this;
    }

    public Configuration setDisabled(boolean z) {
        this.disabled = z;
        return (Configuration) this;
    }

    public Configuration setFlushInterval(long j2) {
        this.flushInterval = j2;
        return (Configuration) this;
    }

    public Configuration setGoogleAdIdEnable(boolean z) {
        this.googleIdEnable = z;
        return (Configuration) this;
    }

    public Configuration setGtaHost(String str) {
        this.gtaHost = str;
        return (Configuration) this;
    }

    public Configuration setImeiEnable(boolean z) {
        this.imeiEnable = z;
        return (Configuration) this;
    }

    public Configuration setMutiprocess(boolean z) {
        this.mutiprocess = z;
        return (Configuration) this;
    }

    public Configuration setOAIDEnable(boolean z) {
        this.oaidEnable = z;
        return (Configuration) this;
    }

    public Configuration setPackageName(String str) {
        this.packageName = str;
        return (Configuration) this;
    }

    public Configuration setProjectId(String str) {
        this.projectId = str;
        return (Configuration) this;
    }

    public Configuration setReportHost(String str) {
        this.reportHost = str;
        return (Configuration) this;
    }

    public Configuration setRnMode(boolean z) {
        this.rnMode = z;
        return (Configuration) this;
    }

    public Configuration setSampling(double d2) {
        this.sampling = d2;
        return (Configuration) this;
    }

    public Configuration setSessionInterval(long j2) {
        this.sessionInterval = j2;
        return (Configuration) this;
    }

    public Configuration setTagsHost(String str) {
        this.tagsHost = str;
        return (Configuration) this;
    }

    public Configuration setTestMode(boolean z) {
        this.testMode = z;
        return (Configuration) this;
    }

    public Configuration setThrottle(boolean z) {
        this.throttle = z;
        return (Configuration) this;
    }

    public Configuration setTrackerHost(String str) {
        this.trackerHost = str;
        return (Configuration) this;
    }

    public Configuration setURLScheme(String str) {
        this.urlScheme = str;
        return (Configuration) this;
    }

    public Configuration setUploadExceptionEnable(boolean z) {
        this.uploadExceptionEnable = z;
        return (Configuration) this;
    }

    public Configuration setWsHost(String str) {
        this.wsHost = str;
        return (Configuration) this;
    }

    public Configuration setZone(String str) {
        this.zone = str;
        return (Configuration) this;
    }

    public Configuration supportMultiProcessCircle(boolean z) {
        this.spmc = z;
        return (Configuration) this;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public AbstractConfiguration() {
    }
}
