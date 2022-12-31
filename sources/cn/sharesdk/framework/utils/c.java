package cn.sharesdk.framework.utils;

import android.util.Base64;
import com.mob.tools.network.KVPair;
import com.tapjoy.TapjoyConstants;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import us.pinguo.common.network.HttpRequest;
/* compiled from: Oauth1Signer.java */
/* loaded from: classes.dex */
public class c {
    private b a = new b();
    private d b = new d("-._~", false);

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: Oauth1Signer.java */
    /* renamed from: cn.sharesdk.framework.utils.c$1  reason: invalid class name */
    /* loaded from: classes.dex */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[a.values().length];
            a = iArr;
            try {
                iArr[a.HMAC_SHA1.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                a[a.PLAINTEXT.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    /* compiled from: Oauth1Signer.java */
    /* loaded from: classes.dex */
    public enum a {
        HMAC_SHA1,
        PLAINTEXT
    }

    /* compiled from: Oauth1Signer.java */
    /* loaded from: classes.dex */
    public static class b {
        public String a;
        public String b;
        public String c;

        /* renamed from: d  reason: collision with root package name */
        public String f215d;

        /* renamed from: e  reason: collision with root package name */
        public String f216e;
    }

    public void a(String str, String str2, String str3) {
        b bVar = this.a;
        bVar.a = str;
        bVar.b = str2;
        bVar.f216e = str3;
    }

    public ArrayList<KVPair<String>> b(String str, ArrayList<KVPair<String>> arrayList) throws Throwable {
        return b(str, arrayList, a.HMAC_SHA1);
    }

    public ArrayList<KVPair<String>> c(String str, ArrayList<KVPair<String>> arrayList, a aVar) throws Throwable {
        return a(str, "PUT", arrayList, aVar);
    }

    public ArrayList<KVPair<String>> b(String str, ArrayList<KVPair<String>> arrayList, a aVar) throws Throwable {
        return a(str, "GET", arrayList, aVar);
    }

    private String b(ArrayList<KVPair<String>> arrayList) {
        if (arrayList == null || arrayList.size() <= 0) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        int i2 = 0;
        Iterator<KVPair<String>> it = arrayList.iterator();
        while (it.hasNext()) {
            KVPair<String> next = it.next();
            if (i2 > 0) {
                sb.append('&');
            }
            sb.append(next.name);
            sb.append('=');
            sb.append(next.value);
            i2++;
        }
        return sb.toString();
    }

    public b a() {
        return this.a;
    }

    public ArrayList<KVPair<String>> a(String str, ArrayList<KVPair<String>> arrayList) throws Throwable {
        return a(str, arrayList, a.HMAC_SHA1);
    }

    public ArrayList<KVPair<String>> a(String str, ArrayList<KVPair<String>> arrayList, a aVar) throws Throwable {
        return a(str, "POST", arrayList, aVar);
    }

    public void a(String str, String str2) {
        b bVar = this.a;
        bVar.c = str;
        bVar.f215d = str2;
    }

    private ArrayList<KVPair<String>> a(String str, String str2, ArrayList<KVPair<String>> arrayList, a aVar) throws Throwable {
        String trim;
        long currentTimeMillis = System.currentTimeMillis();
        int i2 = AnonymousClass1.a[aVar.ordinal()];
        String str3 = null;
        if (i2 == 1) {
            SecretKeySpec secretKeySpec = new SecretKeySpec((a(this.a.b) + '&' + a(this.a.f215d)).getBytes("utf-8"), "HMAC-SHA1");
            Mac mac = Mac.getInstance("HMAC-SHA1");
            mac.init(secretKeySpec);
            String b2 = b(a(currentTimeMillis, arrayList, "HMAC-SHA1"));
            trim = new String(Base64.encode(mac.doFinal((str2 + '&' + a(str) + '&' + a(b2)).getBytes("utf-8")), 0)).trim();
            str3 = "HMAC-SHA1";
        } else if (i2 != 2) {
            trim = null;
        } else {
            str3 = "PLAINTEXT";
            trim = a(this.a.b) + '&' + a(this.a.f215d);
        }
        ArrayList<KVPair<String>> a2 = a(currentTimeMillis, str3);
        a2.add(new KVPair<>(TapjoyConstants.TJC_NOTIFICATION_OAUTH_SIGNATURE, trim));
        return a2;
    }

    public String a(String str) {
        return str == null ? "" : this.b.escape(str);
    }

    private ArrayList<KVPair<String>> a(long j2, ArrayList<KVPair<String>> arrayList, String str) {
        HashMap hashMap = new HashMap();
        if (arrayList != null) {
            Iterator<KVPair<String>> it = arrayList.iterator();
            while (it.hasNext()) {
                KVPair<String> next = it.next();
                hashMap.put(a(next.name), a(next.value));
            }
        }
        ArrayList<KVPair<String>> a2 = a(j2, str);
        if (a2 != null) {
            Iterator<KVPair<String>> it2 = a2.iterator();
            while (it2.hasNext()) {
                KVPair<String> next2 = it2.next();
                hashMap.put(a(next2.name), a(next2.value));
            }
        }
        int size = hashMap.size();
        String[] strArr = new String[size];
        int i2 = 0;
        for (Map.Entry entry : hashMap.entrySet()) {
            strArr[i2] = (String) entry.getKey();
            i2++;
        }
        Arrays.sort(strArr);
        ArrayList<KVPair<String>> arrayList2 = new ArrayList<>();
        for (int i3 = 0; i3 < size; i3++) {
            String str2 = strArr[i3];
            arrayList2.add(new KVPair<>(str2, hashMap.get(str2)));
        }
        return arrayList2;
    }

    private ArrayList<KVPair<String>> a(long j2, String str) {
        ArrayList<KVPair<String>> arrayList = new ArrayList<>();
        arrayList.add(new KVPair<>("oauth_consumer_key", this.a.a));
        arrayList.add(new KVPair<>(TapjoyConstants.TJC_NOTIFICATION_OAUTH_SIGNATURE_METHOD, str));
        arrayList.add(new KVPair<>("oauth_timestamp", String.valueOf(j2 / 1000)));
        arrayList.add(new KVPair<>("oauth_nonce", String.valueOf(j2)));
        arrayList.add(new KVPair<>("oauth_version", "1.0"));
        String str2 = this.a.c;
        if (str2 != null && str2.length() > 0) {
            arrayList.add(new KVPair<>("oauth_token", str2));
        }
        return arrayList;
    }

    public ArrayList<KVPair<String>> a(ArrayList<KVPair<String>> arrayList) {
        StringBuilder sb = new StringBuilder("OAuth ");
        Iterator<KVPair<String>> it = arrayList.iterator();
        int i2 = 0;
        while (it.hasNext()) {
            KVPair<String> next = it.next();
            if (i2 > 0) {
                sb.append(',');
            }
            String a2 = a(next.value);
            sb.append(next.name);
            sb.append("=\"");
            sb.append(a2);
            sb.append("\"");
            i2++;
        }
        ArrayList<KVPair<String>> arrayList2 = new ArrayList<>();
        arrayList2.add(new KVPair<>(HttpRequest.HEADER_AUTHORIZATION, sb.toString()));
        arrayList2.add(new KVPair<>(HttpRequest.HEADER_CONTENT_TYPE, HttpRequest.CONTENT_TYPE_FORM));
        return arrayList2;
    }
}
