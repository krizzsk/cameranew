package com.growingio.android.sdk.models;

import android.app.Activity;
import android.text.TextUtils;
import com.growingio.android.sdk.utils.LogUtil;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class PageEvent extends VPAEvent {
    public static final String TYPE_NAME = "page";
    private String mLastPage;
    private String mOrientation;
    private long mPtm;
    private String mTitle;

    public PageEvent(String str, String str2, long j2) {
        super(j2);
        this.mOrientation = "PORTRAIT";
        this.mPageName = str;
        this.mPtm = j2;
        this.mLastPage = str2;
        Activity foregroundActivity = getAPPState().getForegroundActivity();
        if (foregroundActivity != null) {
            this.mOrientation = foregroundActivity.getResources().getConfiguration().orientation != 1 ? "LANDSCAPE" : "PORTRAIT";
            if (TextUtils.isEmpty(foregroundActivity.getTitle())) {
                return;
            }
            this.mTitle = foregroundActivity.getTitle().toString();
        }
    }

    public String getLastPage() {
        return this.mLastPage;
    }

    public String getTitle() {
        return this.mTitle;
    }

    @Override // com.growingio.android.sdk.models.VPAEvent
    public String getType() {
        return TYPE_NAME;
    }

    @Override // com.growingio.android.sdk.models.VPAEvent
    public JSONObject toJson() {
        JSONObject commonProperty = getCommonProperty();
        try {
            JSONObject appVariable = getAPPState().getAppVariable();
            if (appVariable != null && appVariable.length() > 0) {
                commonProperty.put("var", appVariable);
            }
            patchNetworkState(commonProperty);
            commonProperty.put("tm", this.mPtm);
            if (!TextUtils.isEmpty(this.mLastPage)) {
                commonProperty.put("rp", this.mLastPage);
            }
            commonProperty.put("o", this.mOrientation);
            commonProperty.put("tl", this.mTitle);
        } catch (JSONException e2) {
            LogUtil.d(VPAEvent.TAG, "generate page event error", e2);
        }
        return commonProperty;
    }
}
