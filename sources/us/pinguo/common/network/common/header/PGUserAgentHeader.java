package us.pinguo.common.network.common.header;

import android.text.TextUtils;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import us.pinguo.common.network.common.PGNetworkConstants;
import us.pinguo.common.network.encrypt.PGBase64;
/* loaded from: classes4.dex */
public class PGUserAgentHeader implements IPGHeader {
    private static final String CONNECTOR = "/";
    private static final String DIVIDER = " ";
    private static final String EMPTY_PARAM = "-";
    private static final String NAME = "X-PG-Agent";
    private String appName;
    private int appVersionCode;
    private String appVersionName;
    private String channelName;
    private String country;
    private String deviceId;
    private String deviceName;
    private String deviceVersion;
    private String language;
    private final String mValue;
    private String mcc;
    private String mnc;
    private String netLibName;
    private String netLibVersion;
    private String platformName;
    private String platformVersion;
    private int screenHeight;
    private int screenWidth;
    private String sdkName;
    private String sdkVersion;

    /* loaded from: classes4.dex */
    public static final class Builder {
        private String appName;
        private int appVersionCode;
        private String appVersionName;
        private String channelName;
        private String country;
        private String deviceId;
        private String deviceName;
        private String deviceVersion;
        private String language;
        private String mcc;
        private String mnc;
        private String netLibName;
        private String netLibVersion;
        private String platformName;
        private String platformVersion;
        private int screenHeight;
        private int screenWidth;

        public Builder appName(String str) {
            this.appName = str;
            return this;
        }

        public Builder appVersionCode(int i2) {
            this.appVersionCode = i2;
            return this;
        }

        public Builder appVersionName(String str) {
            this.appVersionName = str;
            return this;
        }

        public PGUserAgentHeader build() {
            return new PGUserAgentHeader(this);
        }

        public Builder channelName(String str) {
            this.channelName = str;
            return this;
        }

        public Builder country(String str) {
            this.country = str;
            return this;
        }

        public Builder deviceId(String str) {
            this.deviceId = str;
            return this;
        }

        public Builder deviceName(String str) {
            this.deviceName = str;
            return this;
        }

        public Builder deviceVersion(String str) {
            this.deviceVersion = str;
            return this;
        }

        public Builder language(String str) {
            this.language = str;
            return this;
        }

        public Builder mcc(String str) {
            this.mcc = str;
            return this;
        }

        public Builder mnc(String str) {
            this.mnc = str;
            return this;
        }

        public Builder netLibName(String str) {
            this.netLibName = str;
            return this;
        }

        public Builder netLibVersion(String str) {
            this.netLibVersion = str;
            return this;
        }

        public Builder platformName(String str) {
            this.platformName = str;
            return this;
        }

        public Builder platformVersion(String str) {
            this.platformVersion = str;
            return this;
        }

        public Builder screenHeight(int i2) {
            this.screenHeight = i2;
            return this;
        }

        public Builder screenWidth(int i2) {
            this.screenWidth = i2;
            return this;
        }
    }

    private static boolean checkNotEmpty(String... strArr) {
        if (strArr == null) {
            return false;
        }
        for (String str : strArr) {
            if (TextUtils.isEmpty(str)) {
                return false;
            }
        }
        return true;
    }

    private static StringBuilder makeParam(StringBuilder sb, String str, String str2) {
        if (sb != null) {
            String urlEncode = urlEncode(str);
            String urlEncode2 = urlEncode(str2);
            if (checkNotEmpty(urlEncode, urlEncode2)) {
                sb.append(DIVIDER);
                sb.append(urlEncode);
                sb.append(CONNECTOR);
                sb.append(urlEncode2);
            } else if (checkNotEmpty(urlEncode)) {
                sb.append(DIVIDER);
                sb.append(urlEncode);
            } else {
                sb.append(DIVIDER);
                sb.append("-");
            }
            return sb;
        }
        throw new AssertionError("StringBuilder can not be null");
    }

    private String makeString() {
        StringBuilder sb = new StringBuilder();
        makeParam(sb, this.sdkName, this.sdkVersion);
        makeParam(sb, this.appName, this.appVersionName);
        makeParam(sb, this.channelName, String.valueOf(this.appVersionCode));
        makeParam(sb, this.platformName, this.platformVersion);
        makeParam(sb, this.deviceName, this.deviceVersion);
        makeParam(sb, this.netLibName, this.netLibVersion);
        if (this.screenWidth != 0 && this.screenHeight != 0) {
            makeParam(sb, this.screenWidth + "x" + this.screenHeight, null);
        }
        makeParam(sb, this.deviceId, null);
        makeParam(sb, this.language + "_" + this.country, null);
        makeParam(sb, this.mcc, this.mnc);
        return sb.toString().trim();
    }

    private static String urlEncode(String str) {
        if (TextUtils.isEmpty(str)) {
            return str;
        }
        try {
            return URLEncoder.encode(str, "UTF-8");
        } catch (UnsupportedEncodingException e2) {
            e2.printStackTrace();
            return str;
        }
    }

    public String getAppName() {
        return this.appName;
    }

    public int getAppVersionCode() {
        return this.appVersionCode;
    }

    public String getAppVersionName() {
        return this.appVersionName;
    }

    public String getChannelName() {
        return this.channelName;
    }

    public String getCountry() {
        return this.country;
    }

    public String getDeviceId() {
        return this.deviceId;
    }

    public String getDeviceName() {
        return this.deviceName;
    }

    public String getDeviceVersion() {
        return this.deviceVersion;
    }

    public String getLanguage() {
        return this.language;
    }

    public String getMcc() {
        return this.mcc;
    }

    public String getMnc() {
        return this.mnc;
    }

    @Override // us.pinguo.common.network.common.header.IPGHeader
    public String getName() {
        return NAME;
    }

    public String getNetLibName() {
        return this.netLibName;
    }

    public String getNetLibVersion() {
        return this.netLibVersion;
    }

    public String getPlatformName() {
        return this.platformName;
    }

    public String getPlatformVersion() {
        return this.platformVersion;
    }

    public int getScreenHeight() {
        return this.screenHeight;
    }

    public int getScreenWidth() {
        return this.screenWidth;
    }

    public String getSdkName() {
        return this.sdkName;
    }

    public String getSdkVersion() {
        return this.sdkVersion;
    }

    public IPGHeader getUaDebugHeader() {
        return new IPGHeader() { // from class: us.pinguo.common.network.common.header.PGUserAgentHeader.1
            @Override // us.pinguo.common.network.common.header.IPGHeader
            public String getName() {
                return "X-PG-Agent-Debug";
            }

            @Override // us.pinguo.common.network.common.header.IPGHeader
            public String getValue() {
                return PGUserAgentHeader.this.mValue;
            }
        };
    }

    @Override // us.pinguo.common.network.common.header.IPGHeader
    public String getValue() {
        return PGBase64.encodeToString(this.mValue.getBytes(), 2);
    }

    private PGUserAgentHeader(Builder builder) {
        this.sdkName = PGNetworkConstants.SDK_NAME;
        this.sdkVersion = "1.0";
        this.appName = builder.appName;
        this.appVersionName = builder.appVersionName;
        this.channelName = builder.channelName;
        this.appVersionCode = builder.appVersionCode;
        this.platformName = builder.platformName;
        this.platformVersion = builder.platformVersion;
        this.deviceName = builder.deviceName;
        this.deviceVersion = builder.deviceVersion;
        this.netLibName = builder.netLibName;
        this.netLibVersion = builder.netLibVersion;
        this.screenWidth = builder.screenWidth;
        this.screenHeight = builder.screenHeight;
        this.deviceId = builder.deviceId;
        this.language = builder.language;
        this.country = builder.country;
        this.mcc = builder.mcc;
        this.mnc = builder.mnc;
        this.mValue = makeString();
    }
}
