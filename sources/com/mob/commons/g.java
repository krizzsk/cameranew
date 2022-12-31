package com.mob.commons;

import android.os.Build;
import android.os.LocaleList;
import android.text.TextUtils;
import com.mob.MobSDK;
import com.mob.PrivacyPolicy;
import com.mob.tools.MobLog;
import com.mob.tools.log.NLog;
import com.mob.tools.network.KVPair;
import com.mob.tools.network.NetworkHelper;
import com.mob.tools.utils.DeviceHelper;
import com.mob.tools.utils.Hashon;
import com.tencent.bugly.BuglyStrategy;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Locale;
import tv.danmaku.ijk.media.player.IjkMediaMeta;
/* compiled from: PolicyFetcher.java */
/* loaded from: classes2.dex */
public class g {
    private static final String a = i.a() + "/privacy/policy";
    private int b = h.g();
    private String c = h.f();

    /* renamed from: d  reason: collision with root package name */
    private int f5880d = h.i();

    /* renamed from: e  reason: collision with root package name */
    private String f5881e = h.h();

    /* renamed from: f  reason: collision with root package name */
    private String f5882f = h.j();

    private boolean c(int i2, Locale locale) {
        if (i2 == 1) {
            if (!TextUtils.isEmpty(this.f5881e) && this.f5880d >= a.h()) {
                return locale == null || locale.toString().equals(this.f5882f);
            }
            return false;
        } else if (i2 != 2 || TextUtils.isEmpty(this.c) || this.b < a.h()) {
            return false;
        } else {
            return locale == null || locale.toString().equals(this.f5882f);
        }
    }

    public PrivacyPolicy a(int i2, Locale locale) throws Throwable {
        if (i2 != 1 && i2 != 2) {
            throw new IllegalArgumentException("Parameter 'type' should be either 1 or 2");
        }
        if (locale == null) {
            if (Build.VERSION.SDK_INT >= 24) {
                LocaleList locales = MobSDK.getContext().getResources().getConfiguration().getLocales();
                if (locales != null && !locales.isEmpty()) {
                    locale = locales.get(0);
                }
            } else {
                locale = MobSDK.getContext().getResources().getConfiguration().locale;
            }
        }
        if (c(i2, locale)) {
            if (i2 == 1) {
                return new PrivacyPolicy(this.f5881e);
            }
            return new PrivacyPolicy(this.c);
        }
        return b(i2, locale);
    }

    public PrivacyPolicy b(int i2, Locale locale) throws Throwable {
        int g2;
        DeviceHelper deviceHelper = DeviceHelper.getInstance(MobSDK.getContext());
        String appkey = MobSDK.getAppkey();
        String packageName = deviceHelper.getPackageName();
        ArrayList<KVPair<String>> arrayList = new ArrayList<>();
        arrayList.add(new KVPair<>("type", String.valueOf(i2)));
        arrayList.add(new KVPair<>("appkey", appkey));
        arrayList.add(new KVPair<>("apppkg", packageName));
        if (i2 == 1) {
            g2 = h.i();
        } else {
            g2 = h.g();
        }
        arrayList.add(new KVPair<>("ppVersion", String.valueOf(g2)));
        arrayList.add(new KVPair<>(IjkMediaMeta.IJKM_KEY_LANGUAGE, locale.toString()));
        NetworkHelper.NetworkTimeOut networkTimeOut = new NetworkHelper.NetworkTimeOut();
        networkTimeOut.readTimout = BuglyStrategy.a.MAX_USERDATA_VALUE_LENGTH;
        networkTimeOut.connectionTimeout = 10000;
        ArrayList<KVPair<String>> arrayList2 = new ArrayList<>();
        arrayList2.add(new KVPair<>("User-Identity", MobProductCollector.getUserIdentity()));
        NLog mobLog = MobLog.getInstance();
        StringBuilder sb = new StringBuilder();
        sb.append("Request: ");
        String str = a;
        sb.append(str);
        sb.append("\nHeaders: ");
        sb.append(arrayList2);
        sb.append("\nValues: ");
        sb.append(arrayList);
        mobLog.d(sb.toString(), new Object[0]);
        String httpGet = new NetworkHelper().httpGet(str, arrayList, arrayList2, networkTimeOut);
        NLog mobLog2 = MobLog.getInstance();
        mobLog2.d("Response: " + httpGet, new Object[0]);
        Hashon hashon = new Hashon();
        HashMap fromJson = hashon.fromJson(httpGet);
        if (fromJson != null) {
            if ("200".equals(String.valueOf(fromJson.get("code")))) {
                Object obj = fromJson.get("data");
                if (obj != null) {
                    String fromObject = hashon.fromObject(obj);
                    if (!TextUtils.isEmpty(fromObject)) {
                        a(i2, locale.toString(), fromObject);
                        return new PrivacyPolicy(fromObject);
                    }
                    throw new Throwable("Response is illegal: " + httpGet);
                }
                throw new Throwable("Response is illegal: " + httpGet);
            }
            throw new Throwable("Response code is not 200: " + httpGet);
        }
        throw new Throwable("Response is illegal: " + httpGet);
    }

    private void a(int i2, String str, String str2) {
        PrivacyPolicy privacyPolicy = new PrivacyPolicy(str2);
        if (i2 == 1) {
            this.f5881e = str2;
            this.f5880d = privacyPolicy.getPpVersion();
            h.f(this.f5881e);
            h.b(this.f5880d);
        } else if (i2 == 2) {
            this.c = str2;
            this.b = privacyPolicy.getPpVersion();
            h.e(this.c);
            h.a(this.b);
        }
        this.f5882f = str;
        h.g(str);
    }
}
