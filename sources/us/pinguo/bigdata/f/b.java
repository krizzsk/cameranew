package us.pinguo.bigdata.f;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Locale;
/* compiled from: BDLogUtils.java */
/* loaded from: classes3.dex */
public class b {
    @NonNull
    public static String a(String str, String str2, HashMap<String, String> hashMap) throws UnsupportedEncodingException {
        StringBuilder sb = new StringBuilder();
        sb.append("uid:");
        sb.append(str);
        if (!TextUtils.isEmpty(str2)) {
            sb.append(" ");
            sb.append("event_id:");
            sb.append(str2.toLowerCase(Locale.ENGLISH));
        }
        if (hashMap != null && hashMap.size() > 0) {
            sb.append(" ");
            for (String str3 : hashMap.keySet()) {
                sb.append(str3);
                sb.append(":");
                sb.append(URLEncoder.encode(hashMap.get(str3).toLowerCase(Locale.ENGLISH), "utf-8"));
                sb.append(" ");
            }
        }
        return sb.toString().toLowerCase(Locale.ENGLISH);
    }

    @NonNull
    public static String b(String str, String str2, HashMap<String, String> hashMap) throws UnsupportedEncodingException {
        StringBuilder sb = new StringBuilder();
        sb.append("uid:");
        sb.append(str);
        if (!TextUtils.isEmpty(str2)) {
            sb.append(" ");
            sb.append("event_id:");
            sb.append(str2.toLowerCase(Locale.ENGLISH));
        }
        if (hashMap != null && hashMap.size() > 0) {
            sb.append(" ");
            for (String str3 : hashMap.keySet()) {
                sb.append(str3);
                sb.append(":");
                sb.append(URLEncoder.encode(hashMap.get(str3), "utf-8"));
                sb.append(" ");
            }
        }
        return sb.toString();
    }
}
