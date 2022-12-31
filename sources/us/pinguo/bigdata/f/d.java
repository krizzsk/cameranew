package us.pinguo.bigdata.f;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
/* compiled from: BDUtils.java */
/* loaded from: classes3.dex */
public class d {
    public static List<String> a(String str, String str2, boolean z) {
        ArrayList arrayList = new ArrayList();
        c(arrayList, new File(str), str2, z);
        return arrayList;
    }

    public static String b(Context context) {
        try {
            NetworkInfo activeNetworkInfo = ((ConnectivityManager) context.getApplicationContext().getSystemService("connectivity")).getActiveNetworkInfo();
            if (activeNetworkInfo == null) {
                return "unknown";
            }
            int type = activeNetworkInfo.getType();
            if (type == 1) {
                return "wifi";
            }
            if (type == 0) {
                switch (activeNetworkInfo.getSubtype()) {
                    case 1:
                    case 2:
                    case 4:
                    case 7:
                    case 11:
                        return "2G";
                    case 3:
                    case 5:
                    case 6:
                    case 8:
                    case 9:
                    case 10:
                    case 12:
                    case 14:
                    case 15:
                        return "3G";
                    case 13:
                        return "4G";
                }
            }
            return "unknown";
        } catch (Exception e2) {
            e2.printStackTrace();
            return "unknown";
        }
    }

    private static List<String> c(List<String> list, File file, String str, boolean z) {
        if (file.isDirectory()) {
            File[] listFiles = file.listFiles();
            for (int i2 = 0; i2 < listFiles.length; i2++) {
                if (z || listFiles[i2].isFile()) {
                    c(list, listFiles[i2], str, z);
                }
            }
        } else {
            String absolutePath = file.getAbsolutePath();
            if (str.equals("") && str == null) {
                list.add(absolutePath);
            } else {
                int lastIndexOf = absolutePath.lastIndexOf(".");
                if (lastIndexOf != -1 && absolutePath.substring(lastIndexOf + 1, absolutePath.length()).equals(str)) {
                    list.add(absolutePath);
                }
            }
        }
        return list;
    }
}
