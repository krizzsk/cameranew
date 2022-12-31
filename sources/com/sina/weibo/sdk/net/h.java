package com.sina.weibo.sdk.net;

import android.text.TextUtils;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.HashMap;
/* loaded from: classes3.dex */
public final class h {
    private HashMap<String, String> r = new HashMap<>();

    public final String k() {
        StringBuilder sb = new StringBuilder();
        boolean z = true;
        for (String str : this.r.keySet()) {
            if (z) {
                z = false;
            } else {
                sb.append("&");
            }
            String str2 = this.r.get(str);
            if (!TextUtils.isEmpty(str2)) {
                try {
                    sb.append(URLEncoder.encode(str, "UTF-8"));
                    sb.append("=");
                    sb.append(URLEncoder.encode(str2, "UTF-8"));
                } catch (UnsupportedEncodingException e2) {
                    e2.printStackTrace();
                }
            }
        }
        return sb.toString();
    }

    public final void put(String str, String str2) {
        this.r.put(str, str2);
    }
}
