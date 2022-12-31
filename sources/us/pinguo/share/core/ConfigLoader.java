package us.pinguo.share.core;

import android.text.TextUtils;
import cn.sharesdk.framework.ShareSDK;
import java.util.HashMap;
import us.pinguo.share.core.a.h;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes6.dex */
public final class ConfigLoader {
    ConfigLoader() {
    }

    public static void initShareSDKParam(ConfigAllBean configAllBean) {
        for (ShareSite shareSite : configAllBean.getDevInfor().keySet()) {
            HashMap hashMap = new HashMap();
            ConfigSiteBean configSiteBean = configAllBean.getDevInfor().get(shareSite);
            if (!TextUtils.isEmpty(configSiteBean.getAppKey())) {
                hashMap.put("AppKey", configSiteBean.getAppKey());
            }
            if (!TextUtils.isEmpty(configSiteBean.getAppId())) {
                hashMap.put("AppId", configSiteBean.getAppId());
            }
            if (!TextUtils.isEmpty(configSiteBean.getAppSecret())) {
                hashMap.put("AppSecret", configSiteBean.getAppSecret());
            }
            if (!TextUtils.isEmpty(configSiteBean.getRedirectUrl())) {
                hashMap.put("RedirectUrl", configSiteBean.getRedirectUrl());
            }
            if (!TextUtils.isEmpty(configSiteBean.getConsumerSecret())) {
                hashMap.put("ConsumerSecret", configSiteBean.getConsumerSecret());
            }
            if (!TextUtils.isEmpty(configSiteBean.getConsumerKey())) {
                hashMap.put("ConsumerKey", configSiteBean.getConsumerKey());
            }
            if (!TextUtils.isEmpty(configSiteBean.getClientId())) {
                hashMap.put("ClientId", configSiteBean.getClientId());
            }
            if (!TextUtils.isEmpty(configSiteBean.getClientSecret())) {
                hashMap.put("ClientSecret", configSiteBean.getClientSecret());
            }
            if (!TextUtils.isEmpty(configSiteBean.getCallbackUrl())) {
                hashMap.put("CallbackUrl", configSiteBean.getCallbackUrl());
            }
            if (!TextUtils.isEmpty(configSiteBean.getBypassApproval())) {
                hashMap.put("BypassApproval", configSiteBean.getBypassApproval());
            }
            if (!TextUtils.isEmpty(configSiteBean.getEnable())) {
                hashMap.put("Enable", configSiteBean.getEnable());
            }
            if (!TextUtils.isEmpty(configSiteBean.getShareByAppClient())) {
                hashMap.put("ShareByAppClient", configSiteBean.getShareByAppClient());
            }
            if (!TextUtils.isEmpty(configSiteBean.getId())) {
                hashMap.put("Id", configSiteBean.getId());
            }
            if (!TextUtils.isEmpty(configSiteBean.getSortId())) {
                hashMap.put("SortId", configSiteBean.getSortId());
            }
            if (hashMap.size() != 0) {
                String b = h.b(shareSite);
                if (!TextUtils.isEmpty(b)) {
                    ShareSDK.setPlatformDevInfo(b, hashMap);
                }
            }
        }
    }
}
