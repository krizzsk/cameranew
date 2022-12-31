package cn.sharesdk.wechat.utils;

import android.os.Bundle;
import cn.sharesdk.framework.Platform;
import cn.sharesdk.framework.PlatformActionListener;
import cn.sharesdk.framework.authorize.AuthorizeListener;
import com.bytedance.sdk.open.aweme.common.constants.ParamKeyConstants;
import com.mob.tools.utils.Hashon;
import java.util.HashMap;
/* compiled from: WechatHandler.java */
/* loaded from: classes.dex */
public class k {
    private Platform a;
    private Platform.ShareParams b;
    private PlatformActionListener c;

    /* renamed from: d  reason: collision with root package name */
    private AuthorizeListener f316d;

    /* renamed from: e  reason: collision with root package name */
    private h f317e;

    public k(Platform platform) {
        this.a = platform;
    }

    public void a(AuthorizeListener authorizeListener) {
        this.f316d = authorizeListener;
    }

    public Platform b() {
        return this.a;
    }

    public PlatformActionListener c() {
        return this.c;
    }

    public void a(Platform.ShareParams shareParams, PlatformActionListener platformActionListener) {
        this.b = shareParams;
        this.c = platformActionListener;
    }

    public void a(h hVar) {
        this.f317e = hVar;
    }

    public void a(WechatResp wechatResp) {
        AuthorizeListener authorizeListener;
        PlatformActionListener platformActionListener;
        PlatformActionListener platformActionListener2;
        int i2 = wechatResp.f306g;
        if (i2 == -4) {
            HashMap hashMap = new HashMap();
            hashMap.put(ParamKeyConstants.WebViewConstants.REDIRECT_QUERY_ERROR_CODE, Integer.valueOf(wechatResp.f306g));
            hashMap.put("errStr", wechatResp.f307h);
            hashMap.put("transaction", wechatResp.f308i);
            Throwable th = new Throwable(new Hashon().fromHashMap(hashMap));
            if (wechatResp.a() == 1 && (authorizeListener = this.f316d) != null) {
                authorizeListener.onError(th);
            }
        } else if (i2 == -3) {
            HashMap hashMap2 = new HashMap();
            hashMap2.put(ParamKeyConstants.WebViewConstants.REDIRECT_QUERY_ERROR_CODE, Integer.valueOf(wechatResp.f306g));
            hashMap2.put("errStr", wechatResp.f307h);
            hashMap2.put("transaction", wechatResp.f308i);
            Throwable th2 = new Throwable(new Hashon().fromHashMap(hashMap2));
            int a = wechatResp.a();
            if (a != 1) {
                if (a == 2 && (platformActionListener = this.c) != null) {
                    platformActionListener.onError(this.a, 9, th2);
                    return;
                }
                return;
            }
            AuthorizeListener authorizeListener2 = this.f316d;
            if (authorizeListener2 != null) {
                authorizeListener2.onError(th2);
            }
        } else if (i2 == -2) {
            int a2 = wechatResp.a();
            if (a2 != 1) {
                if (a2 == 2 && (platformActionListener2 = this.c) != null) {
                    platformActionListener2.onCancel(this.a, 9);
                    return;
                }
                return;
            }
            AuthorizeListener authorizeListener3 = this.f316d;
            if (authorizeListener3 != null) {
                authorizeListener3.onCancel();
            }
        } else if (i2 != 0) {
            HashMap hashMap3 = new HashMap();
            hashMap3.put("req", wechatResp.getClass().getSimpleName());
            hashMap3.put(ParamKeyConstants.WebViewConstants.REDIRECT_QUERY_ERROR_CODE, Integer.valueOf(wechatResp.f306g));
            hashMap3.put("errStr", wechatResp.f307h);
            hashMap3.put("transaction", wechatResp.f308i);
            Throwable th3 = new Throwable(new Hashon().fromHashMap(hashMap3));
            PlatformActionListener platformActionListener3 = this.c;
            if (platformActionListener3 != null) {
                platformActionListener3.onError(this.a, 9, th3);
            }
            AuthorizeListener authorizeListener4 = this.f316d;
            if (authorizeListener4 != null) {
                authorizeListener4.onError(th3);
            }
        } else {
            int a3 = wechatResp.a();
            if (a3 != 1) {
                if (a3 == 2 && this.c != null) {
                    HashMap<String, Object> hashMap4 = new HashMap<>();
                    hashMap4.put("ShareParams", this.b);
                    this.c.onComplete(this.a, 9, hashMap4);
                }
            } else if (this.f316d != null) {
                Bundle bundle = new Bundle();
                wechatResp.b(bundle);
                this.f317e.a(bundle, this.f316d);
            }
        }
    }

    public Platform.ShareParams a() {
        return this.b;
    }
}
