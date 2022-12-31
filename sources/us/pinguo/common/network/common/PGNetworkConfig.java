package us.pinguo.common.network.common;

import android.app.Application;
import j.a.f.i;
import us.pinguo.bigdata.config.BDConfig;
import us.pinguo.common.log.a;
import us.pinguo.common.network.common.header.PGUserAgentHeader;
/* loaded from: classes4.dex */
public class PGNetworkConfig {
    private static PGNetworkConfig INSTANCE = null;
    private static final String TAG = "PGNetworkConfig";
    private String mCharset;
    private boolean mIsDebug = false;
    private PGUserAgentHeader mUserAgent;

    private PGNetworkConfig() {
    }

    public static PGNetworkConfig getInstance() {
        if (INSTANCE == null) {
            synchronized (PGNetworkConfig.class) {
                if (INSTANCE == null) {
                    INSTANCE = new PGNetworkConfig();
                }
            }
        }
        return INSTANCE;
    }

    public String getCharset() {
        return this.mCharset;
    }

    public PGUserAgentHeader getUserAgent() {
        return this.mUserAgent;
    }

    public void init(Application application, PGUserAgentHeader pGUserAgentHeader, String str, boolean z) {
        init(application, pGUserAgentHeader, str, false, z);
    }

    public boolean isDebug() {
        return this.mIsDebug;
    }

    public void resetLocale(String str, String str2) {
        PGUserAgentHeader pGUserAgentHeader = this.mUserAgent;
        if (pGUserAgentHeader != null) {
            if (pGUserAgentHeader.getLanguage().equals(str) && this.mUserAgent.getLanguage().equals(str2)) {
                return;
            }
            PGUserAgentHeader.Builder builder = new PGUserAgentHeader.Builder();
            builder.appName(this.mUserAgent.getAppName()).appVersionCode(this.mUserAgent.getAppVersionCode()).appVersionName(this.mUserAgent.getAppVersionName()).channelName(this.mUserAgent.getChannelName()).deviceId(this.mUserAgent.getDeviceId()).deviceName(this.mUserAgent.getDeviceName()).deviceVersion(this.mUserAgent.getDeviceVersion()).mcc(this.mUserAgent.getMcc()).mnc(this.mUserAgent.getMnc()).netLibName(this.mUserAgent.getNetLibName()).netLibVersion(this.mUserAgent.getNetLibVersion()).platformName(this.mUserAgent.getPlatformName()).platformVersion(this.mUserAgent.getPlatformVersion()).screenWidth(this.mUserAgent.getScreenWidth()).screenHeight(this.mUserAgent.getScreenHeight()).language(str).country(str2);
            this.mUserAgent = builder.build();
        }
    }

    public void init(Application application, PGUserAgentHeader pGUserAgentHeader, String str, boolean z, boolean z2) {
        if (pGUserAgentHeader != null) {
            this.mIsDebug = z;
            if (this.mUserAgent == null) {
                this.mUserAgent = pGUserAgentHeader;
                this.mCharset = str;
            } else {
                a.s("This config has been initialled! this call will take no effect", new Object[0]);
            }
            i.a.b(application);
            us.pinguo.bigdata.a.m(z2);
            us.pinguo.bigdata.a.c = z;
            us.pinguo.bigdata.a.g(new BDConfig.Builder(application).setDebug(z).build());
            a.c("Debug mode:" + this.mIsDebug, new Object[0]);
            return;
        }
        throw new IllegalArgumentException("PGUserAgentHeader can not be null!");
    }
}
