package cn.sharesdk.framework.a;

import android.text.TextUtils;
import cn.sharesdk.framework.ShareSDK;
import com.mob.tools.network.HTTPPart;
import com.mob.tools.network.KVPair;
import com.mob.tools.network.NetworkHelper;
import com.mob.tools.network.RawNetworkCallback;
import java.util.ArrayList;
/* compiled from: SSDKNetworkHelper.java */
/* loaded from: classes.dex */
public class b extends NetworkHelper {
    private static b a;

    private b() {
    }

    public static b a() {
        if (a == null) {
            a = new b();
        }
        return a;
    }

    public String b(String str, ArrayList<KVPair<String>> arrayList, String str2, int i2) throws Throwable {
        return a(str, arrayList, null, str2, i2);
    }

    public String b(String str, ArrayList<KVPair<String>> arrayList, ArrayList<KVPair<String>> arrayList2, NetworkHelper.NetworkTimeOut networkTimeOut, String str2, int i2) throws Throwable {
        a(str2, i2);
        return super.jsonPost(str, arrayList, arrayList2, networkTimeOut);
    }

    public String a(String str, ArrayList<KVPair<String>> arrayList, String str2, int i2) throws Throwable {
        return a(str, arrayList, (ArrayList<KVPair<String>>) null, (NetworkHelper.NetworkTimeOut) null, str2, i2);
    }

    public String a(String str, ArrayList<KVPair<String>> arrayList, ArrayList<KVPair<String>> arrayList2, NetworkHelper.NetworkTimeOut networkTimeOut, String str2, int i2) throws Throwable {
        a(str2, i2);
        return super.httpGet(str, arrayList, arrayList2, networkTimeOut);
    }

    public String a(String str, ArrayList<KVPair<String>> arrayList, KVPair<String> kVPair, String str2, int i2) throws Throwable {
        return a(str, arrayList, kVPair, (ArrayList<KVPair<String>>) null, str2, i2);
    }

    public String a(String str, ArrayList<KVPair<String>> arrayList, KVPair<String> kVPair, ArrayList<KVPair<String>> arrayList2, String str2, int i2) throws Throwable {
        return a(str, arrayList, kVPair, arrayList2, null, str2, i2);
    }

    public String a(String str, ArrayList<KVPair<String>> arrayList, KVPair<String> kVPair, ArrayList<KVPair<String>> arrayList2, NetworkHelper.NetworkTimeOut networkTimeOut, String str2, int i2) throws Throwable {
        a(str2, i2);
        return super.httpPost(str, arrayList, kVPair, arrayList2, networkTimeOut);
    }

    public void a(String str, ArrayList<KVPair<String>> arrayList, HTTPPart hTTPPart, RawNetworkCallback rawNetworkCallback, String str2, int i2) throws Throwable {
        a(str2, i2);
        super.rawPost(str, arrayList, hTTPPart, rawNetworkCallback, (NetworkHelper.NetworkTimeOut) null);
    }

    private void a(String str, int i2) {
        if (TextUtils.isEmpty(str) || i2 <= 0) {
            return;
        }
        ShareSDK.logApiEvent(str, i2);
    }
}
