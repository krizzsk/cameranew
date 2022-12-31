package com.bytedance.sdk.open.douyin.ui;

import android.content.Intent;
import android.content.res.Configuration;
import android.graphics.Color;
import android.os.Bundle;
import android.widget.RelativeLayout;
import com.bytedance.sdk.open.aweme.authorize.model.Authorization;
import com.bytedance.sdk.open.aweme.authorize.ui.BaseWebAuthorizeActivity;
import com.bytedance.sdk.open.aweme.common.handler.IApiEventHandler;
import com.bytedance.sdk.open.aweme.common.model.BaseResp;
import com.bytedance.sdk.open.aweme.utils.ViewUtils;
import com.bytedance.sdk.open.douyin.DouYinOpenApiFactory;
import com.bytedance.sdk.open.douyin.api.DouYinOpenApi;
/* loaded from: classes.dex */
public class DouYinWebAuthorizeActivity extends BaseWebAuthorizeActivity {
    public static final String a = "open.douyin.com";
    public static final String b = "api.snssdk.com";
    public static final String c = "/platform/oauth/connect/";

    /* renamed from: d  reason: collision with root package name */
    protected static final String f1296d = "douyinapi.DouYinEntryActivity";

    /* renamed from: e  reason: collision with root package name */
    private DouYinOpenApi f1297e;

    @Override // com.bytedance.sdk.open.aweme.authorize.ui.BaseWebAuthorizeActivity
    protected String errorCode2Message(int i2) {
        return "";
    }

    @Override // com.bytedance.sdk.open.aweme.authorize.ui.BaseWebAuthorizeActivity
    protected String getAuthPath() {
        return c;
    }

    @Override // com.bytedance.sdk.open.aweme.authorize.ui.BaseWebAuthorizeActivity
    protected String getDomain() {
        return b;
    }

    @Override // com.bytedance.sdk.open.aweme.authorize.ui.BaseWebAuthorizeActivity
    protected String getHost() {
        return a;
    }

    @Override // com.bytedance.sdk.open.aweme.authorize.ui.BaseWebAuthorizeActivity
    protected boolean handleIntent(Intent intent, IApiEventHandler iApiEventHandler) {
        return this.f1297e.handleIntent(intent, iApiEventHandler);
    }

    @Override // com.bytedance.sdk.open.aweme.authorize.ui.BaseWebAuthorizeActivity
    protected boolean isNetworkAvailable() {
        return true;
    }

    @Override // android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
    }

    @Override // com.bytedance.sdk.open.aweme.authorize.ui.BaseWebAuthorizeActivity, android.app.Activity
    protected void onCreate(Bundle bundle) {
        this.f1297e = DouYinOpenApiFactory.create(this);
        super.onCreate(bundle);
        ViewUtils.setStatusBarColor(this, 0);
    }

    @Override // com.bytedance.sdk.open.aweme.authorize.ui.BaseWebAuthorizeActivity
    protected void sendInnerResponse(Authorization.Request request, BaseResp baseResp) {
        if (baseResp != null && this.mContentWebView != null) {
            if (baseResp.extras == null) {
                baseResp.extras = new Bundle();
            }
            baseResp.extras.putString("wap_authorize_url", this.mContentWebView.getUrl());
        }
        sendInnerResponse(f1296d, request, baseResp);
    }

    @Override // com.bytedance.sdk.open.aweme.authorize.ui.BaseWebAuthorizeActivity
    protected void setContainerViewBgColor() {
        RelativeLayout relativeLayout = this.mContainer;
        if (relativeLayout != null) {
            relativeLayout.setBackgroundColor(Color.parseColor("#161823"));
        }
    }
}
