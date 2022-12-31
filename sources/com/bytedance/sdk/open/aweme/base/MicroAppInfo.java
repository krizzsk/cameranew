package com.bytedance.sdk.open.aweme.base;

import android.os.Bundle;
import android.text.TextUtils;
import com.bytedance.sdk.open.aweme.common.constants.ParamKeyConstants;
import com.google.firebase.remoteconfig.RemoteConfigConstants;
import com.google.gson.JsonSyntaxException;
import com.google.gson.e;
import com.google.gson.s.c;
import com.tencent.open.SocialConstants;
/* loaded from: classes.dex */
public class MicroAppInfo {
    @c(RemoteConfigConstants.RequestFieldKey.APP_ID)
    private String appId;
    @c("appTitle")
    private String appTitle;
    @c("appUrl")
    private String appUrl;
    @c(SocialConstants.PARAM_COMMENT)
    private String description;

    public static MicroAppInfo unserialize(Bundle bundle) {
        if (bundle == null) {
            return null;
        }
        String string = bundle.getString(ParamKeyConstants.ShareParams.SHARE_MICROAPP_INFO);
        try {
            if (!TextUtils.isEmpty(string)) {
                return (MicroAppInfo) new e().j(string, MicroAppInfo.class);
            }
        } catch (JsonSyntaxException e2) {
            e2.printStackTrace();
        }
        return null;
    }

    public String getAppId() {
        return this.appId;
    }

    public String getAppTitle() {
        return this.appTitle;
    }

    public String getAppUrl() {
        return this.appUrl;
    }

    public String getDescription() {
        return this.description;
    }

    public void serialize(Bundle bundle) {
        if (bundle == null) {
            return;
        }
        bundle.putString(ParamKeyConstants.ShareParams.SHARE_MICROAPP_INFO, new e().s(this));
    }

    public void setAppId(String str) {
        this.appId = str;
    }

    public void setAppTitle(String str) {
        this.appTitle = str;
    }

    public void setAppUrl(String str) {
        this.appUrl = str;
    }

    public void setDescription(String str) {
        this.description = str;
    }
}
