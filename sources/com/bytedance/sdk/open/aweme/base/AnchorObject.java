package com.bytedance.sdk.open.aweme.base;

import android.os.Bundle;
import android.text.TextUtils;
import com.bytedance.sdk.open.aweme.common.constants.ParamKeyConstants;
import com.google.gson.JsonSyntaxException;
import com.google.gson.e;
import com.google.gson.s.c;
/* loaded from: classes.dex */
public class AnchorObject {
    @c("anchor_business_type")
    int mAnchorBusinessType;
    @c("anchor_content")
    String mAnchorContent;
    @c("anchor_title")
    String mAnchorTitle;

    public static AnchorObject unserialize(Bundle bundle) {
        if (bundle == null) {
            return null;
        }
        String string = bundle.getString(ParamKeyConstants.ShareParams.SHARE_ANCHOR_INFO);
        try {
            if (!TextUtils.isEmpty(string)) {
                return (AnchorObject) new e().j(string, AnchorObject.class);
            }
        } catch (JsonSyntaxException e2) {
            e2.printStackTrace();
        }
        return null;
    }

    public int getAnchorBusinessType() {
        return this.mAnchorBusinessType;
    }

    public String getAnchorContent() {
        return this.mAnchorContent;
    }

    public String getAnchorTitle() {
        return this.mAnchorTitle;
    }

    public void serialize(Bundle bundle) {
        if (bundle == null) {
            return;
        }
        bundle.putString(ParamKeyConstants.ShareParams.SHARE_ANCHOR_INFO, new e().s(this));
    }

    public void setAnchorBusinessType(int i2) {
        this.mAnchorBusinessType = i2;
    }

    public void setAnchorContent(String str) {
        this.mAnchorContent = str;
    }

    public void setAnchorTitle(String str) {
        this.mAnchorTitle = str;
    }
}
