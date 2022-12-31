package us.pinguo.advsdk.utils;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkCapabilities;
import android.net.NetworkInfo;
import android.os.Build;
import android.text.TextUtils;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
/* compiled from: AdvUtils.java */
/* loaded from: classes3.dex */
public class e {
    public static String a = "";
    private static String b = "com.android.vending";
    private static String c = "com.facebook.katana";

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: AdvUtils.java */
    /* loaded from: classes3.dex */
    public class a implements Comparator<String> {
        a() {
        }

        @Override // java.util.Comparator
        /* renamed from: a */
        public int compare(String str, String str2) {
            return str.compareTo(str2);
        }
    }

    public static byte[] a(String str) throws UnsupportedEncodingException {
        byte[] bArr = new byte[24];
        byte[] bytes = str.getBytes("UTF-8");
        if (24 > bytes.length) {
            System.arraycopy(bytes, 0, bArr, 0, bytes.length);
        } else {
            System.arraycopy(bytes, 0, bArr, 0, 24);
        }
        return bArr;
    }

    public static int b(Context context) {
        ConnectivityManager connectivityManager;
        try {
            connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
        } catch (Exception e2) {
            e2.printStackTrace();
            connectivityManager = null;
        }
        if (connectivityManager == null) {
            return -1;
        }
        if (Build.VERSION.SDK_INT > 23) {
            NetworkCapabilities networkCapabilities = connectivityManager.getNetworkCapabilities(connectivityManager.getActiveNetwork());
            if (networkCapabilities == null) {
                return -1;
            }
            return networkCapabilities.hasTransport(1) ? 16 : 8;
        }
        NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
        if (activeNetworkInfo == null) {
            return -1;
        }
        return activeNetworkInfo.getType() == 1 ? 16 : 8;
    }

    public static byte[] c(byte[] bArr, String str) {
        if (bArr != null && str != null) {
            try {
                byte[] a2 = a(str);
                IvParameterSpec ivParameterSpec = new IvParameterSpec(str.getBytes("UTF-8"));
                SecretKeySpec secretKeySpec = new SecretKeySpec(a2, "DESede");
                Cipher cipher = Cipher.getInstance("DESede/CBC/PKCS5Padding");
                cipher.init(1, secretKeySpec, ivParameterSpec);
                return cipher.doFinal(bArr);
            } catch (NoSuchAlgorithmException e2) {
                e2.printStackTrace();
            } catch (Exception e3) {
                e3.printStackTrace();
            }
        }
        return null;
    }

    public static String d(Context context) {
        if (!TextUtils.isEmpty(a)) {
            return a;
        }
        StringBuffer stringBuffer = new StringBuffer();
        ArrayList arrayList = new ArrayList();
        if (i(context, b)) {
            arrayList.add("gp");
        }
        if (i(context, c)) {
            arrayList.add("fb");
        }
        for (int i2 = 0; i2 < arrayList.size(); i2++) {
            if (i2 != 0) {
                stringBuffer.append(",");
            }
            stringBuffer.append((String) arrayList.get(i2));
        }
        String stringBuffer2 = stringBuffer.toString();
        a = stringBuffer2;
        return stringBuffer2;
    }

    public static us.pinguo.advsdk.bean.a e(List<String> list, String str) {
        us.pinguo.advsdk.bean.a aVar = new us.pinguo.advsdk.bean.a();
        if (list != null && list.size() != 0) {
            String g2 = g(list);
            aVar.b = g2;
            try {
                aVar.c = c.b(g2, str);
            } catch (UnsupportedEncodingException unused) {
            }
        }
        return aVar;
    }

    public static us.pinguo.advsdk.bean.a f(Map<String, String> map, String str) {
        ArrayList arrayList = new ArrayList();
        for (Map.Entry<String, String> entry : map.entrySet()) {
            arrayList.add(entry.getKey() + "=" + entry.getValue());
        }
        return e(arrayList, str);
    }

    public static String g(List<String> list) {
        Collections.sort(list, new a());
        StringBuffer stringBuffer = new StringBuffer();
        for (String str : list) {
            stringBuffer.append(str);
        }
        return stringBuffer.toString();
    }

    public static String h(String str, Map<String, String> map) throws UnsupportedEncodingException {
        StringBuilder sb = new StringBuilder(str);
        int length = sb.length();
        if (map != null && map.size() != 0) {
            if (str.contains("?")) {
                if (sb.charAt(sb.length() - 1) != '?' && sb.charAt(sb.length() - 1) != '&') {
                    sb.append('&');
                }
            } else if (sb.charAt(sb.length() - 1) != '?') {
                sb.append('?');
            }
            for (Map.Entry<String, String> entry : map.entrySet()) {
                sb.append(entry.getKey());
                sb.append('=');
                if (entry.getValue() != null) {
                    sb.append(URLEncoder.encode(entry.getValue(), "UTF-8"));
                }
                sb.append('&');
            }
            sb.deleteCharAt(sb.length() - 1);
            return sb.toString();
        }
        int i2 = length - 1;
        if (sb.charAt(i2) == '?') {
            sb.deleteCharAt(i2);
        }
        return sb.toString();
    }

    /*  JADX ERROR: NullPointerException in pass: RegionMakerVisitor
        java.lang.NullPointerException
        	at java.base/java.util.BitSet.or(BitSet.java:941)
        	at jadx.core.utils.BlockUtils.getPathCross(BlockUtils.java:732)
        	at jadx.core.utils.BlockUtils.getPathCross(BlockUtils.java:811)
        	at jadx.core.dex.visitors.regions.IfMakerHelper.restructureIf(IfMakerHelper.java:88)
        	at jadx.core.dex.visitors.regions.RegionMaker.processIf(RegionMaker.java:706)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverse(RegionMaker.java:155)
        	at jadx.core.dex.visitors.regions.RegionMaker.makeRegion(RegionMaker.java:94)
        	at jadx.core.dex.visitors.regions.RegionMaker.processIf(RegionMaker.java:730)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverse(RegionMaker.java:155)
        	at jadx.core.dex.visitors.regions.RegionMaker.makeRegion(RegionMaker.java:94)
        	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:52)
        */
    public static boolean i(android.content.Context r2, java.lang.String r3) {
        /*
            r0 = 0
            if (r3 == 0) goto L1e
            java.lang.String r1 = ""
            boolean r1 = r1.equals(r3)
            if (r1 == 0) goto Lc
            goto L1e
        Lc:
            android.content.pm.PackageManager r2 = r2.getPackageManager()     // Catch: android.content.pm.PackageManager.NameNotFoundException -> L1e
            android.content.pm.ApplicationInfo r2 = r2.getApplicationInfo(r3, r0)     // Catch: android.content.pm.PackageManager.NameNotFoundException -> L1e
            if (r2 == 0) goto L1b
            java.lang.String r3 = "packageName is exsit ,pass it "
            us.pinguo.advsdk.utils.b.a(r3)     // Catch: android.content.pm.PackageManager.NameNotFoundException -> L1e
        L1b:
            if (r2 == 0) goto L1e
            r0 = 1
        L1e:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: us.pinguo.advsdk.utils.e.i(android.content.Context, java.lang.String):boolean");
    }
}
