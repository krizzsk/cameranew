package com.danikula.videocache.p;

import android.text.TextUtils;
import com.danikula.videocache.l;
/* compiled from: Md5FileNameGenerator.java */
/* loaded from: classes.dex */
public class f implements c {
    private String b(String str) {
        int lastIndexOf = str.lastIndexOf(46);
        return (lastIndexOf == -1 || lastIndexOf <= str.lastIndexOf(47) || (lastIndexOf + 2) + 4 <= str.length()) ? "" : str.substring(lastIndexOf + 1, str.length());
    }

    @Override // com.danikula.videocache.p.c
    public String a(String str) {
        String b = b(str);
        String d2 = l.d(str);
        if (TextUtils.isEmpty(b)) {
            return d2;
        }
        return d2 + "." + b;
    }
}
