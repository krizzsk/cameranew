package us.pinguo.foundation;

import android.os.Build;
import android.os.Environment;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import us.pinguo.foundation.utils.y;
/* compiled from: GAdapter.java */
/* loaded from: classes4.dex */
public class f {
    public static final String a;
    private static final String b;
    private static final String c;

    /* renamed from: d  reason: collision with root package name */
    public static final boolean f10996d;

    /* renamed from: e  reason: collision with root package name */
    public static final boolean f10997e;

    /* renamed from: f  reason: collision with root package name */
    public static final boolean f10998f;

    /* renamed from: g  reason: collision with root package name */
    public static final boolean f10999g;

    /* renamed from: h  reason: collision with root package name */
    public static final boolean f11000h;

    /* renamed from: i  reason: collision with root package name */
    private static boolean f11001i;

    /* renamed from: j  reason: collision with root package name */
    private static final boolean f11002j;

    /* renamed from: k  reason: collision with root package name */
    private static final boolean f11003k;

    /* renamed from: l  reason: collision with root package name */
    private static final boolean f11004l;
    private static final boolean m;
    public static final boolean n;
    public static final boolean o;
    private static final boolean p;
    private static final boolean q;
    private static final boolean r;
    private static final boolean s;
    private static final boolean t;
    private static final String[] u;
    private static final String[] v;
    private static final ArrayList<String> w;
    public static final boolean x;
    public static boolean y;

    static {
        String str = Build.MODEL;
        a = str;
        String str2 = Build.BRAND;
        b = str2;
        String str3 = Build.VERSION.RELEASE;
        c = str3;
        "EVA-AL10".equals(str);
        f10996d = str.equals("Coolpad 5892");
        str.startsWith("HTC Sensation Z710e");
        str.startsWith("SM-G9006W");
        str2.equals("Meitu Kiss");
        if (str2.equals("ZTE")) {
            str.equals("ZTE V889D");
        }
        boolean equals = str2.equals("Meizu");
        f10997e = equals;
        str.equals("ZTE U930");
        boolean z = equals && str.equals("M9");
        f10998f = z;
        if (equals) {
            str.equals("PRO 6");
        }
        str.equals("HUAWEI U9508");
        boolean z2 = equals && str.equals("M032");
        f10999g = z2;
        str.equals("m2 note");
        f11000h = str.equals("mobiistar_LAI_Yuna_S");
        f11001i = z || z2;
        f11002j = str.equals("MB525") && str3.startsWith("2.");
        "LT26i".equals(str);
        "SM-G955F".equals(str);
        if (!"HUAWEI".equalsIgnoreCase(str2)) {
            "HONOR".equalsIgnoreCase(str2);
        }
        str.equals("GT-S5360");
        str.equals("GT-S5830");
        f11003k = str.equals("MI 2");
        f11004l = str.equals("MI 2S");
        m = str.equals("MI 2A");
        str.equals("MI 3");
        if (str.equals("SHW-M250S")) {
            str3.equals("4.0.3");
        }
        n = str.startsWith("TAH-AN00") || str.startsWith("TAH-N29");
        o = "Philips X596".equals(str);
        str.equals("SHW-M250S");
        if (str.equals("GT-I9100G")) {
            boolean z3 = us.pinguo.util.c.b;
        }
        if (str.equals("LG-P970")) {
            str3.equals("4.0.4");
        }
        boolean equals2 = str.equals("U8860");
        p = equals2;
        boolean equals3 = str.equals("Nexus 4");
        q = equals3;
        str.equals("Nexus 5X");
        str.equals("Nexus 6");
        boolean startsWith = str.startsWith("MI ");
        r = startsWith;
        boolean equals4 = str.equals("HTC 802w");
        s = equals4;
        if (str.equals("XT912")) {
            str3.equals("2.3.6");
        }
        boolean equals5 = str.equals("X909");
        t = equals5;
        "Lenovo S680".equals(str);
        str.equals("vivo X710L");
        str.equals("HIKe 828A");
        if (str.equals("LS-5015")) {
            str2.equals("LYF");
        }
        String[] strArr = {"CPH1969", "CPH1987", "CPH1911", "CPH1912", "CPH1913"};
        u = strArr;
        c(strArr, str);
        String[] strArr2 = {"CPH1969", "CPH1987", "CPH1911", "CPH1912", "CPH1913"};
        v = strArr2;
        c(strArr2, str);
        ArrayList<String> arrayList = new ArrayList<>();
        w = arrayList;
        if (Build.VERSION.SDK_INT == 18) {
            arrayList.add("ASUS_T00F");
            arrayList.add("ASUS_T00J");
            arrayList.add("ASUS_T00G");
            arrayList.add("ASUS_T00I");
            arrayList.add("ASUS_K00E");
        }
        if (!equals2 && !equals3 && !equals4 && !equals5) {
            "GT-I8552".equals(a);
        }
        if (equals && a.equals("M040")) {
            a(c, "4.2.1");
        }
        x = startsWith;
        "samsung".equals(Build.BRAND);
        String str4 = a;
        y = "SM-G355H".equals(str4) || "SM-G355M".equals(str4);
        String str5 = Build.MODEL;
        "ASUS_Z007".equals(str5);
        "Mi Note 3".equals(str5);
    }

    private static boolean a(String str, String str2) {
        String[] split = str.split("\\.");
        String[] split2 = str2.split("\\.");
        int length = split.length > split2.length ? split.length : split2.length;
        int i2 = 0;
        while (i2 < length) {
            if ((i2 == split.length ? 0 : Integer.parseInt(split[i2])) < (i2 == split2.length ? 0 : Integer.parseInt(split2[i2]))) {
                return false;
            }
            i2++;
        }
        return true;
    }

    public static String b() {
        StringBuilder sb = new StringBuilder();
        sb.append(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DCIM).getAbsolutePath());
        String str = File.separator;
        sb.append(str);
        String sb2 = sb.toString();
        if (f11001i) {
            return sb2;
        }
        return sb2 + "Camera" + str;
    }

    private static boolean c(Object[] objArr, Object obj) {
        if (obj != null && objArr != null) {
            for (Object obj2 : objArr) {
                if (obj.equals(obj2)) {
                    return true;
                }
            }
        }
        return false;
    }

    public static boolean d() {
        return y.c(Build.SUPPORTED_ABIS, "arm64-v8a") >= 0 || y.c(Build.SUPPORTED_64_BIT_ABIS, "arm64-v8a") >= 0;
    }

    public static boolean e() {
        us.pinguo.common.log.a.k("MODEL = " + a, new Object[0]);
        ArrayList<String> arrayList = w;
        if (arrayList.size() == 0) {
            return true;
        }
        Iterator<String> it = arrayList.iterator();
        while (it.hasNext()) {
            if (it.next().contains(a)) {
                return false;
            }
        }
        return true;
    }
}
