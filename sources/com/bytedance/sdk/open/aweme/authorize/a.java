package com.bytedance.sdk.open.aweme.authorize;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import com.bytedance.sdk.open.aweme.authorize.model.Authorization;
import com.bytedance.sdk.open.aweme.authorize.model.VerifyObject;
import com.bytedance.sdk.open.aweme.common.constants.ParamKeyConstants;
import com.bytedance.sdk.open.aweme.utils.SignatureUtils;
import com.tapjoy.TapjoyConstants;
import java.util.List;
/* loaded from: classes.dex */
public class a {
    public static String a(Context context, Authorization.Request request, String str, String str2) {
        StringBuilder sb = new StringBuilder();
        if (!TextUtils.isEmpty(request.optionalScope1)) {
            String[] split = request.optionalScope1.split(",");
            for (int i2 = 0; i2 < split.length; i2++) {
                if (sb.length() > 0) {
                    sb.append(",");
                }
                sb.append(split[i2] + ",1");
            }
        }
        if (!TextUtils.isEmpty(request.optionalScope0)) {
            String[] split2 = request.optionalScope0.split(",");
            for (int i3 = 0; i3 < split2.length; i3++) {
                if (sb.length() > 0) {
                    sb.append(",");
                }
                sb.append(split2[i3] + ",0");
            }
        }
        StringBuilder sb2 = new StringBuilder();
        String str3 = request.scope;
        if (str3 != null) {
            sb2.append(str3);
        }
        VerifyObject verifyObject = request.verifyObject;
        if (verifyObject != null && verifyObject.verifyScope != null) {
            if (sb2.length() > 0) {
                sb2.append(',');
            }
            sb2.append(request.verifyObject.verifyScope);
        }
        List<String> md5Signs = SignatureUtils.getMd5Signs(context, request.getCallerPackage());
        Bundle bundle = request.extras;
        return new Uri.Builder().scheme("https").authority(str).path(str2).appendQueryParameter(ParamKeyConstants.WebViewConstants.QUERY_RESPONSE_TYPE, "code").appendQueryParameter(ParamKeyConstants.WebViewConstants.QUERY_REDIRECT_URI, request.redirectUri).appendQueryParameter(ParamKeyConstants.WebViewConstants.QUERY_CLIENT_KEY, request.getClientKey()).appendQueryParameter("state", request.state).appendQueryParameter("from", ParamKeyConstants.WebViewConstants.VALUE_FROM_OPENSDK).appendQueryParameter("scope", sb2.toString()).appendQueryParameter(ParamKeyConstants.WebViewConstants.QUERY_OPTIONAL_SCOPE, sb.toString()).appendQueryParameter("signature", SignatureUtils.packageSignature(md5Signs)).appendQueryParameter(ParamKeyConstants.WebViewConstants.QUERY_ENCRIPTION_PACKAGE, com.bytedance.sdk.open.aweme.utils.a.a(request.getCallerPackage())).appendQueryParameter(ParamKeyConstants.WebViewConstants.QUERY_PLATFORM, TapjoyConstants.TJC_DEVICE_PLATFORM_TYPE).appendQueryParameter(ParamKeyConstants.WebViewConstants.LIVE_ENTER_FROM_KEY, bundle != null ? bundle.getString(ParamKeyConstants.WebViewConstants.LIVE_ENTER_FROM_KEY, "") : "").build().toString();
    }
}
