package us.pinguo.loc;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Point;
import android.os.Build;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import com.adjust.sdk.Constants;
import com.facebook.AccessToken;
import com.tapjoy.TapjoyConstants;
import com.tencent.matrix.report.Issue;
import java.io.IOException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.Callable;
import kotlin.Pair;
import kotlin.collections.y;
import kotlin.text.Regex;
import org.json.JSONObject;
import us.pinguo.common.network.HttpRequest;
/* compiled from: LocNetworkSegmentation.kt */
/* loaded from: classes5.dex */
public final class s implements Callable<byte[]> {
    private String a;
    private boolean b;

    public s(String inputPath) {
        kotlin.jvm.internal.s.h(inputPath, "inputPath");
        this.a = inputPath;
    }

    private final String b(String str, String str2) {
        HttpRequest httpRequest = HttpRequest.get(str);
        httpRequest.connectTimeout(10000);
        httpRequest.readTimeout(10000);
        httpRequest.trustAllHosts();
        httpRequest.trustAllCerts();
        httpRequest.authorization(kotlin.jvm.internal.s.q("SIGN ", str2));
        int code = httpRequest.code();
        if (code == 200) {
            return new JSONObject(httpRequest.body()).optString("mask_url", null);
        }
        throw new IOException(kotlin.jvm.internal.s.q("http error, code:", Integer.valueOf(code)));
    }

    private final byte[] c() {
        us.pinguo.poker.j a = us.pinguo.poker.p.a();
        if (this.b) {
            return null;
        }
        Point m = us.pinguo.util.e.m(this.a);
        if (this.b) {
            return null;
        }
        Pair<String, String> k2 = us.pinguo.poker.p.k(this.a, m, a);
        if (this.b) {
            return null;
        }
        String first = k2.getFirst();
        kotlin.jvm.internal.s.g(first, "ret.first");
        String j2 = j(g(first), "167A5E48738A57FEB64AAAF60C57314664EC7C43");
        String d2 = d("167A5E48738A57FEB64AAAF60C57314664EC7C43");
        Locale ENGLISH = Locale.ENGLISH;
        kotlin.jvm.internal.s.g(ENGLISH, "ENGLISH");
        String lowerCase = d2.toLowerCase(ENGLISH);
        kotlin.jvm.internal.s.g(lowerCase, "this as java.lang.String).toLowerCase(locale)");
        String d3 = d(j2 + '+' + lowerCase);
        kotlin.jvm.internal.s.g(ENGLISH, "ENGLISH");
        String upperCase = d3.toUpperCase(ENGLISH);
        kotlin.jvm.internal.s.g(upperCase, "this as java.lang.String).toUpperCase(locale)");
        String first2 = k2.getFirst();
        kotlin.jvm.internal.s.g(first2, "ret.first");
        String b = b(i("https://idphoto-qa.camera360.com/images/ai-effect", e(first2)), upperCase);
        if (TextUtils.isEmpty(b) || this.b) {
            return null;
        }
        return us.pinguo.poker.p.c(b);
    }

    private final String d(String str) {
        try {
            MessageDigest messageDigest = MessageDigest.getInstance(Constants.MD5);
            byte[] bytes = str.getBytes(kotlin.text.d.a);
            kotlin.jvm.internal.s.g(bytes, "this as java.lang.String).getBytes(charset)");
            messageDigest.update(bytes);
            StringBuffer stringBuffer = new StringBuffer();
            byte[] digest = messageDigest.digest();
            int i2 = 0;
            int length = digest.length;
            while (i2 < length) {
                int i3 = i2 + 1;
                int i4 = digest[i2];
                if (i4 < 0) {
                    i4 += 256;
                }
                if (i4 < 16) {
                    stringBuffer.append("0");
                }
                stringBuffer.append(Integer.toHexString(i4));
                i2 = i3;
            }
            String stringBuffer2 = stringBuffer.toString();
            kotlin.jvm.internal.s.g(stringBuffer2, "buf.toString()");
            return stringBuffer2;
        } catch (NoSuchAlgorithmException e2) {
            e2.printStackTrace();
            return "";
        }
    }

    private final List<String> e(String str) {
        HashMap hashMap = new HashMap();
        String a = us.pinguo.foundation.utils.p.a(str);
        kotlin.jvm.internal.s.g(a, "encodeUrlParam(etag)");
        hashMap.put("key", a);
        hashMap.put("appname", "camera360");
        String a2 = us.pinguo.foundation.utils.p.a("9.9.27");
        kotlin.jvm.internal.s.g(a2, "encodeUrlParam(Debug.VERSION_NAME)");
        hashMap.put("appversion", a2);
        hashMap.put("platform", TapjoyConstants.TJC_DEVICE_PLATFORM_TYPE);
        hashMap.put(TapjoyConstants.TJC_DEVICE_OS_VERSION_NAME, String.valueOf(Build.VERSION.SDK_INT));
        Locale locale = Locale.getDefault();
        String a3 = us.pinguo.foundation.utils.p.a(locale.getLanguage() + '-' + ((Object) locale.getCountry()));
        kotlin.jvm.internal.s.g(a3, "encodeUrlParam(locale.la…e + \"-\" + locale.country)");
        hashMap.put("locale", a3);
        String a4 = us.pinguo.foundation.utils.p.a(us.pinguo.foundation.utils.i.a());
        kotlin.jvm.internal.s.g(a4, "encodeUrlParam(ChannelUtils.getChannelName())");
        hashMap.put("channel", a4);
        String device = Build.MODEL;
        if (!TextUtils.isEmpty(device)) {
            kotlin.jvm.internal.s.g(device, "device");
            device = new Regex(" ").replace(device, "");
        }
        String a5 = us.pinguo.foundation.utils.p.a(device);
        kotlin.jvm.internal.s.g(a5, "encodeUrlParam(device)");
        hashMap.put(TapjoyConstants.TJC_NOTIFICATION_DEVICE_PREFIX, a5);
        String a6 = us.pinguo.foundation.utils.p.a(j.a.f.e.a(us.pinguo.util.v.a()));
        kotlin.jvm.internal.s.g(a6, "encodeUrlParam(BDProxy.g…Context.getAppContext()))");
        hashMap.put("deviceId", a6);
        DisplayMetrics displayMetrics = Resources.getSystem().getDisplayMetrics();
        hashMap.put("screen_size", "" + displayMetrics.widthPixels + 'x' + displayMetrics.heightPixels);
        Context a7 = us.pinguo.util.v.a();
        kotlin.jvm.internal.s.g(a7, "getAppContext()");
        String d2 = us.pinguo.util.q.d(a7);
        if (d2 == null) {
            d2 = "";
        }
        hashMap.put("network", d2);
        hashMap.put(Issue.ISSUE_REPORT_TIME, String.valueOf(System.currentTimeMillis() / 1000));
        hashMap.put(AccessToken.USER_ID_KEY, "");
        hashMap.put("token", "");
        ArrayList arrayList = new ArrayList();
        for (Map.Entry entry : hashMap.entrySet()) {
            arrayList.add(((String) entry.getKey()) + '=' + ((String) entry.getValue()));
        }
        y.p(arrayList, e.a);
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final int f(String str, String s1) {
        kotlin.jvm.internal.s.g(s1, "s1");
        return str.compareTo(s1);
    }

    private final List<String> g(String str) {
        HashMap hashMap = new HashMap();
        hashMap.put("key", str);
        hashMap.put("appname", "camera360");
        hashMap.put("appversion", "9.9.27");
        hashMap.put("platform", TapjoyConstants.TJC_DEVICE_PLATFORM_TYPE);
        hashMap.put(TapjoyConstants.TJC_DEVICE_OS_VERSION_NAME, String.valueOf(Build.VERSION.SDK_INT));
        Locale locale = Locale.getDefault();
        hashMap.put("locale", locale.getLanguage() + '-' + ((Object) locale.getCountry()));
        String a = us.pinguo.foundation.utils.i.a();
        kotlin.jvm.internal.s.g(a, "getChannelName()");
        hashMap.put("channel", a);
        String device = Build.MODEL;
        if (!TextUtils.isEmpty(device)) {
            kotlin.jvm.internal.s.g(device, "device");
            device = new Regex(" ").replace(device, "");
        }
        kotlin.jvm.internal.s.g(device, "device");
        hashMap.put(TapjoyConstants.TJC_NOTIFICATION_DEVICE_PREFIX, device);
        String a2 = j.a.f.e.a(us.pinguo.util.v.a());
        kotlin.jvm.internal.s.g(a2, "getAid(UtilContext.getAppContext())");
        hashMap.put("deviceId", a2);
        DisplayMetrics displayMetrics = Resources.getSystem().getDisplayMetrics();
        hashMap.put("screen_size", "" + displayMetrics.widthPixels + 'x' + displayMetrics.heightPixels);
        Context a3 = us.pinguo.util.v.a();
        kotlin.jvm.internal.s.g(a3, "getAppContext()");
        String d2 = us.pinguo.util.q.d(a3);
        if (d2 == null) {
            d2 = "";
        }
        hashMap.put("network", d2);
        hashMap.put(Issue.ISSUE_REPORT_TIME, String.valueOf(System.currentTimeMillis() / 1000));
        hashMap.put(AccessToken.USER_ID_KEY, "");
        hashMap.put("token", "");
        ArrayList arrayList = new ArrayList();
        for (Map.Entry entry : hashMap.entrySet()) {
            arrayList.add(((String) entry.getKey()) + '=' + ((String) entry.getValue()));
        }
        y.p(arrayList, d.a);
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final int h(String str, String s1) {
        kotlin.jvm.internal.s.g(s1, "s1");
        return str.compareTo(s1);
    }

    private final String i(String str, List<String> list) {
        StringBuilder sb = new StringBuilder();
        for (String str2 : list) {
            sb.append(str2);
            sb.append('&');
        }
        sb.deleteCharAt(sb.length() - 1);
        return str + '?' + ((Object) sb);
    }

    private final String j(List<String> list, String str) {
        StringBuilder sb = new StringBuilder();
        for (String str2 : list) {
            sb.append(str2);
            sb.append('&');
        }
        sb.deleteCharAt(sb.length() - 1).append(str);
        String sb2 = sb.toString();
        kotlin.jvm.internal.s.g(sb2, "sb.toString()");
        String d2 = d(sb2);
        Locale ENGLISH = Locale.ENGLISH;
        kotlin.jvm.internal.s.g(ENGLISH, "ENGLISH");
        String lowerCase = d2.toLowerCase(ENGLISH);
        kotlin.jvm.internal.s.g(lowerCase, "this as java.lang.String).toLowerCase(locale)");
        return lowerCase;
    }

    @Override // java.util.concurrent.Callable
    /* renamed from: a */
    public byte[] call() {
        try {
            return c();
        } catch (Exception unused) {
            return null;
        }
    }

    public final void m(boolean z) {
        this.b = z;
    }
}
