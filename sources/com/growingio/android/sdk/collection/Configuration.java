package com.growingio.android.sdk.collection;

import com.growingio.android.sdk.utils.CustomerInterface;
/* loaded from: classes2.dex */
public class Configuration extends AbstractConfiguration {
    private boolean enableNotificationTrack;

    public Configuration(String str) {
        super(str);
    }

    public Configuration disableImageViewCollection(boolean z) {
        this.disableImageViewCollection = z;
        return this;
    }

    public Configuration enablePushTrack() {
        this.enableNotificationTrack = true;
        return this;
    }

    public boolean isEnableNotificationTrack() {
        return this.enableNotificationTrack;
    }

    public Configuration setDisableImpression(boolean z) {
        this.disableImpression = z;
        return this;
    }

    public Configuration setEncryptEntity(CustomerInterface.Encryption encryption) {
        this.encryptEntity = encryption;
        return this;
    }

    public Configuration setHashTagEnable(boolean z) {
        this.isHashTagEnable = z;
        return this;
    }

    public Configuration setHybridJSSDKUrlPrefix(String str) {
        this.hybridJSSDKUrlPrefix = str;
        return this;
    }

    public Configuration setImageViewCollectionBitmapSize(int i2) {
        this.imageViewCollectionBitmapSize = i2;
        return this;
    }

    public Configuration setJavaCirclePluginHost(String str) {
        this.javaCirclePluginHost = str;
        return this;
    }

    public Configuration setTrackWebView(boolean z) {
        this.trackWebView = z;
        return this;
    }

    public String toString() {
        return "Configuration{hybridJSSDKUrlPrefix='" + this.hybridJSSDKUrlPrefix + "', javaCirclePluginHost='" + this.javaCirclePluginHost + "', disableImpression=" + this.disableImpression + ", trackWebView=" + this.trackWebView + ", isHashTagEnable=" + this.isHashTagEnable + ", disableImageViewCollection=" + this.disableImageViewCollection + ", imageViewCollectionBitmapSize=" + this.imageViewCollectionBitmapSize + ", trackAllFragments=" + this.trackAllFragments + ", useID=" + this.useID + ", context=" + this.context + ", projectId='" + this.projectId + "', urlScheme='" + this.urlScheme + "', deviceId='" + this.deviceId + "', channel='" + this.channel + "', trackerHost='" + this.trackerHost + "', dataHost='" + this.dataHost + "', reportHost='" + this.reportHost + "', tagsHost='" + this.tagsHost + "', gtaHost='" + this.gtaHost + "', wsHost='" + this.wsHost + "', zone='" + this.zone + "', enablePushTrack='" + this.enableNotificationTrack + "', sampling=" + this.sampling + ", disabled=" + this.disabled + ", gdprEnabled=" + this.gdprEnabled + ", throttle=" + this.throttle + ", debugMode=" + this.debugMode + ", testMode=" + this.testMode + ", spmc=" + this.spmc + ", collectWebViewUserAgent=" + this.collectWebViewUserAgent + ", diagnose=" + this.diagnose + ", disableCellularImp=" + this.disableCellularImp + ", bulkSize=" + this.bulkSize + ", sessionInterval=" + this.sessionInterval + ", flushInterval=" + this.flushInterval + ", cellularDataLimit=" + this.cellularDataLimit + ", mutiprocess=" + this.mutiprocess + ", callback=" + this.callback + ", rnMode=" + this.rnMode + ", encryptEntity=" + this.encryptEntity + '}';
    }

    public Configuration trackAllFragments() {
        this.trackAllFragments = true;
        return this;
    }

    public Configuration() {
    }
}
