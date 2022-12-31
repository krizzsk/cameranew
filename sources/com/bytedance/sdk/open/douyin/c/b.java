package com.bytedance.sdk.open.douyin.c;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import com.bytedance.sdk.open.aweme.authorize.AuthImpl;
import com.bytedance.sdk.open.aweme.authorize.handler.SendAuthDataHandler;
import com.bytedance.sdk.open.aweme.authorize.model.Authorization;
import com.bytedance.sdk.open.aweme.common.constants.ParamKeyConstants;
import com.bytedance.sdk.open.aweme.common.handler.IApiEventHandler;
import com.bytedance.sdk.open.aweme.common.handler.IDataHandler;
import com.bytedance.sdk.open.aweme.share.Share;
import com.bytedance.sdk.open.aweme.share.ShareDataHandler;
import com.bytedance.sdk.open.aweme.share.ShareImpl;
import com.bytedance.sdk.open.douyin.ShareToContact;
import com.bytedance.sdk.open.douyin.api.DouYinOpenApi;
import com.bytedance.sdk.open.douyin.c;
import com.bytedance.sdk.open.douyin.model.OpenRecord;
import com.bytedance.sdk.open.douyin.ui.DouYinWebAuthorizeActivity;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes.dex */
public class b implements DouYinOpenApi {

    /* renamed from: g  reason: collision with root package name */
    private static final String f1289g = "douyinapi.DouYinEntryActivity";

    /* renamed from: h  reason: collision with root package name */
    private static final String f1290h = "share.SystemShareActivity";

    /* renamed from: i  reason: collision with root package name */
    private static final int f1291i = 1;

    /* renamed from: j  reason: collision with root package name */
    private static final int f1292j = 2;
    private Map<Integer, IDataHandler> a = new HashMap(2);
    private c b;
    private com.bytedance.sdk.open.douyin.b c;

    /* renamed from: d  reason: collision with root package name */
    private ShareImpl f1293d;

    /* renamed from: e  reason: collision with root package name */
    private AuthImpl f1294e;

    /* renamed from: f  reason: collision with root package name */
    private WeakReference<Activity> f1295f;

    public b(Activity activity, String str) {
        WeakReference<Activity> weakReference = new WeakReference<>(activity);
        this.f1295f = weakReference;
        this.f1293d = new ShareImpl(weakReference.get(), str);
        this.f1294e = new AuthImpl(this.f1295f.get(), str);
        this.b = new c(this.f1295f.get(), str);
        this.c = new com.bytedance.sdk.open.douyin.b(this.f1295f.get(), str);
        this.a.put(1, new SendAuthDataHandler());
        this.a.put(2, new ShareDataHandler());
    }

    private boolean a(Authorization.Request request) {
        return this.f1294e.authorizeWeb(DouYinWebAuthorizeActivity.class, request);
    }

    @Override // com.bytedance.sdk.open.douyin.api.DouYinOpenApi
    public boolean authorize(Authorization.Request request) {
        if (request == null) {
            return false;
        }
        a aVar = new a(this.f1295f.get());
        return aVar.isAppSupportAuthorization() ? this.f1294e.authorizeNative(request, aVar.getPackageName(), aVar.getRemoteAuthEntryActivity(), f1289g, com.bytedance.sdk.open.douyin.a.f1279g, com.bytedance.sdk.open.douyin.a.f1280h) : a(request);
    }

    @Override // com.bytedance.sdk.open.douyin.api.DouYinOpenApi
    public boolean handleIntent(Intent intent, IApiEventHandler iApiEventHandler) {
        if (iApiEventHandler == null) {
            return false;
        }
        if (intent == null) {
            iApiEventHandler.onErrorIntent(intent);
            return false;
        }
        Bundle extras = intent.getExtras();
        if (extras == null) {
            iApiEventHandler.onErrorIntent(intent);
            return false;
        }
        int i2 = extras.getInt(ParamKeyConstants.BaseParams.TYPE);
        if (i2 == 0) {
            i2 = extras.getInt(ParamKeyConstants.ShareParams.TYPE);
        }
        switch (i2) {
            case 1:
            case 2:
                return this.a.get(1).handle(i2, extras, iApiEventHandler);
            case 3:
            case 4:
                return this.a.get(2).handle(i2, extras, iApiEventHandler);
            case 5:
            case 6:
                return new com.bytedance.sdk.open.douyin.b.b().handle(i2, extras, iApiEventHandler);
            case 7:
            case 8:
                return new com.bytedance.sdk.open.douyin.b.a().handle(i2, extras, iApiEventHandler);
            default:
                return this.a.get(1).handle(i2, extras, iApiEventHandler);
        }
    }

    @Override // com.bytedance.sdk.open.douyin.api.DouYinOpenApi
    public boolean isAppInstalled() {
        return new a(this.f1295f.get()).isAppInstalled();
    }

    @Override // com.bytedance.sdk.open.douyin.api.DouYinOpenApi
    public boolean isAppSupportAuthorization() {
        return new a(this.f1295f.get()).isAppSupportAuthorization();
    }

    @Override // com.bytedance.sdk.open.douyin.api.DouYinOpenApi
    public boolean isAppSupportShare() {
        return new a(this.f1295f.get()).isAppSupportShare();
    }

    @Override // com.bytedance.sdk.open.douyin.api.DouYinOpenApi
    public boolean isAppSupportShareToContacts() {
        return new a(this.f1295f.get()).b();
    }

    @Override // com.bytedance.sdk.open.douyin.api.DouYinOpenApi
    public boolean isAppSupportShareToPublish() {
        return new a(this.f1295f.get()).d();
    }

    @Override // com.bytedance.sdk.open.douyin.api.DouYinOpenApi
    public boolean isShareSupportFileProvider() {
        return new a(this.f1295f.get()).e();
    }

    @Override // com.bytedance.sdk.open.douyin.api.DouYinOpenApi
    public boolean isSupportOpenRecordPage() {
        return new a(this.f1295f.get()).c();
    }

    @Override // com.bytedance.sdk.open.douyin.api.DouYinOpenApi
    public boolean openRecordPage(OpenRecord.Request request) {
        com.bytedance.sdk.open.douyin.b bVar;
        a aVar = new a(this.f1295f.get());
        if (!aVar.c() || (bVar = this.c) == null) {
            return false;
        }
        bVar.a(f1289g, aVar.getPackageName(), "opensdk.OpenCameraActivity", request, com.bytedance.sdk.open.douyin.a.f1279g, com.bytedance.sdk.open.douyin.a.f1280h);
        return true;
    }

    @Override // com.bytedance.sdk.open.douyin.api.DouYinOpenApi
    public boolean share(Share.Request request) {
        if (request == null) {
            return false;
        }
        a aVar = new a(this.f1295f.get());
        if (this.f1295f.get() == null || !aVar.isAppSupportShare()) {
            return false;
        }
        return this.f1293d.share(f1289g, aVar.getPackageName(), f1290h, request, aVar.getRemoteAuthEntryActivity(), com.bytedance.sdk.open.douyin.a.f1279g, com.bytedance.sdk.open.douyin.a.f1280h);
    }

    @Override // com.bytedance.sdk.open.douyin.api.DouYinOpenApi
    public boolean shareToContacts(ShareToContact.Request request) {
        a aVar = new a(this.f1295f.get());
        if (aVar.b()) {
            this.b.a(f1289g, aVar.getPackageName(), "openshare.ShareToContactsActivity", request);
            return true;
        }
        return false;
    }
}
