package com.ironsource.mediationsdk.o0;

import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import android.util.Pair;
import com.google.firebase.remoteconfig.RemoteConfigConstants;
import com.ironsource.environment.c;
import com.ironsource.environment.e;
import com.ironsource.mediationsdk.IronsourceObjectPublisherDataHolder;
import com.ironsource.mediationsdk.logger.IronLog;
import com.ironsource.mediationsdk.utils.IronSourceUtils;
import com.ironsource.mediationsdk.utils.g;
import com.tapjoy.TapjoyConstants;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.Iterator;
import java.util.List;
import java.util.Vector;
import java.util.concurrent.ConcurrentHashMap;
import us.pinguo.common.network.common.header.PGTransHeader;
/* compiled from: ServerURL.java */
/* loaded from: classes2.dex */
public class b {
    private static String a = "https://init.supersonicads.com/sdk/v";
    private static String b = "?request=";

    private static String a(Vector<Pair<String, String>> vector) throws UnsupportedEncodingException {
        Iterator<Pair<String, String>> it = vector.iterator();
        String str = "";
        while (it.hasNext()) {
            Pair<String, String> next = it.next();
            if (str.length() > 0) {
                str = str + "&";
            }
            str = str + ((String) next.first) + "=" + URLEncoder.encode((String) next.second, "UTF-8");
        }
        return str;
    }

    private static String b(String str) {
        return a + str + b;
    }

    public static String c(Context context, String str, String str2, String str3, String str4, Vector<Pair<String, String>> vector) throws UnsupportedEncodingException {
        Vector vector2 = new Vector();
        vector2.add(new Pair("platform", TapjoyConstants.TJC_DEVICE_PLATFORM_TYPE));
        vector2.add(new Pair("applicationKey", str));
        vector2.add(new Pair("applicationUserId", str2));
        vector2.add(new Pair(RemoteConfigConstants.RequestFieldKey.SDK_VERSION, IronSourceUtils.I()));
        if (IronSourceUtils.K() == 0) {
            vector2.add(new Pair("serr", String.valueOf(IronSourceUtils.K())));
        }
        if (!TextUtils.isEmpty(com.ironsource.mediationsdk.k0.a.a().c())) {
            vector2.add(new Pair("pluginType", com.ironsource.mediationsdk.k0.a.a().c()));
        }
        if (!TextUtils.isEmpty(com.ironsource.mediationsdk.k0.a.a().d())) {
            vector2.add(new Pair("pluginVersion", com.ironsource.mediationsdk.k0.a.a().d()));
        }
        if (!TextUtils.isEmpty(com.ironsource.mediationsdk.k0.a.a().b())) {
            vector2.add(new Pair("plugin_fw_v", com.ironsource.mediationsdk.k0.a.a().b()));
        }
        if (!TextUtils.isEmpty(str3)) {
            vector2.add(new Pair("advId", str3));
        }
        if (!TextUtils.isEmpty(str4)) {
            vector2.add(new Pair("mt", str4));
        }
        String h2 = c.h(context, context.getPackageName());
        if (!TextUtils.isEmpty(h2)) {
            vector2.add(new Pair("appVer", h2));
        }
        vector2.add(new Pair("osVer", Build.VERSION.SDK_INT + ""));
        vector2.add(new Pair("devMake", Build.MANUFACTURER));
        vector2.add(new Pair("devModel", Build.MODEL));
        vector2.add(new Pair("fs", (IronSourceUtils.w(context) ? 1 : 0) + ""));
        ConcurrentHashMap<String, List<String>> b2 = IronsourceObjectPublisherDataHolder.getInstance().b();
        if (b2.containsKey("is_child_directed")) {
            vector2.add(new Pair("coppa", b2.get("is_child_directed").get(0)));
        }
        String h3 = IronSourceUtils.h(context);
        if (!TextUtils.isEmpty(h3)) {
            vector2.add(new Pair("connType", h3));
        }
        if (vector != null) {
            vector2.addAll(vector);
        }
        String e2 = IronSourceUtils.getInstance().e();
        if (e2.length() != 0) {
            vector2.add(new Pair("browserUserAgent", e2));
        }
        String str5 = null;
        try {
            str5 = e.n(context) + PGTransHeader.CONNECTOR + e.o(context);
        } catch (Exception e3) {
            e3.printStackTrace();
        }
        if (str5 != null && str5.length() != 0) {
            vector2.add(new Pair("deviceLang", str5));
        }
        if (context != null) {
            vector2.add(new Pair("bundleId", context.getPackageName()));
            vector2.add(new Pair("mcc", "" + d.e.c.a.b(context)));
            vector2.add(new Pair("mnc", "" + d.e.c.a.c(context)));
            String H = e.H(context);
            if (!TextUtils.isEmpty(H)) {
                vector2.add(new Pair("icc", H));
            }
            String G = e.G(context);
            if (!TextUtils.isEmpty(G)) {
                vector2.add(new Pair("mCar", G));
            }
        }
        String u = e.u();
        if (!TextUtils.isEmpty(u)) {
            vector2.add(new Pair("tz", u));
        }
        vector2.add(new Pair("tzOff", "" + e.v()));
        String g2 = e.g(context);
        if (!TextUtils.isEmpty(g2)) {
            vector2.add(new Pair("auid", g2));
        }
        String a2 = a(vector2);
        IronLog.INTERNAL.info("parameters for url: " + a2);
        return b(IronSourceUtils.I()) + URLEncoder.encode(g.e("C38FB23A402222A0C17D34A92F971D1F", a2), "UTF-8");
    }
}
