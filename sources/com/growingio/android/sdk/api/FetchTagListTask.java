package com.growingio.android.sdk.api;

import android.annotation.TargetApi;
import com.adjust.sdk.Constants;
import com.growingio.android.sdk.base.event.HttpCallBack;
import com.growingio.android.sdk.base.event.HttpEvent;
import com.growingio.android.sdk.collection.CoreAppState;
import com.growingio.android.sdk.collection.CoreInitialize;
import com.growingio.android.sdk.collection.GConfig;
import com.growingio.android.sdk.collection.NetworkConfig;
import com.growingio.android.sdk.utils.LogUtil;
import com.growingio.eventcenter.EventCenter;
import java.math.BigInteger;
import java.nio.charset.Charset;
import java.security.MessageDigest;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import us.pinguo.common.network.HttpRequest;
/* loaded from: classes2.dex */
public class FetchTagListTask implements HttpCallBack {
    @TargetApi(9)
    private String getSignature(String str, String str2, String str3, String str4) {
        try {
            MessageDigest messageDigest = MessageDigest.getInstance(Constants.SHA1);
            messageDigest.update(String.format(Locale.US, "api=%s&%s&%s&%s", str, str3, str4, str2).getBytes(Charset.forName("UTF-8")));
            String bigInteger = new BigInteger(1, messageDigest.digest()).toString(16);
            if (bigInteger.length() >= 40) {
                return bigInteger;
            }
            StringBuilder sb = new StringBuilder(40);
            int length = 40 - bigInteger.length();
            while (true) {
                int i2 = length - 1;
                if (length > 0) {
                    sb.append("0");
                    length = i2;
                } else {
                    sb.append(bigInteger);
                    return sb.toString();
                }
            }
        } catch (Exception e2) {
            e2.printStackTrace();
            return null;
        }
    }

    @Override // com.growingio.android.sdk.base.event.HttpCallBack
    public void afterRequest(Integer num, byte[] bArr, long j2, Map<String, List<String>> map) {
        GConfig config = CoreInitialize.config();
        if (num.intValue() == 200) {
            config.saveServerSettings(new String(bArr));
            if (map == null || !map.containsKey(HttpRequest.HEADER_ETAG)) {
                return;
            }
            List<String> list = map.get(HttpRequest.HEADER_ETAG);
            if (list.size() > 0) {
                config.saveETagForSettings(list.get(0));
            }
        }
    }

    public void run() {
        try {
            CoreAppState coreAppState = CoreInitialize.coreAppState();
            GConfig config = CoreInitialize.config();
            if (coreAppState == null) {
                return;
            }
            String format = String.format(Locale.US, "/products/%s/android/%s/settings", coreAppState.getProjectId(), coreAppState.getSPN());
            String str = "timestamp=" + System.currentTimeMillis();
            String str2 = "cv=" + coreAppState.getGlobalContext().getPackageManager().getPackageInfo(coreAppState.getGlobalContext().getPackageName(), 0).versionName;
            String signature = getSignature(format, str, "av=autotrack-2.9.4_cc04ab80", str2);
            if (signature == null) {
                return;
            }
            HashMap hashMap = new HashMap(1);
            hashMap.put(HttpRequest.HEADER_IF_NONE_MATCH, config.getSettingsETag());
            String format2 = String.format(Locale.US, "%s%s?%s&%s&%s&sign=%s", NetworkConfig.getInstance().tagsHost(), format, "av=autotrack-2.9.4_cc04ab80", str2, str, signature);
            HttpEvent httpEvent = new HttpEvent();
            httpEvent.setUrl(format2);
            httpEvent.setRequestMethod(HttpEvent.REQUEST_METHOD.GET);
            httpEvent.setHeaders(hashMap);
            httpEvent.setCallBack(this);
            EventCenter.getInstance().post(httpEvent);
        } catch (Throwable th) {
            LogUtil.d(th);
        }
    }
}
