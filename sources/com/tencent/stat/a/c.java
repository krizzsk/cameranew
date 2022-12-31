package com.tencent.stat.a;

import java.util.Arrays;
import java.util.Properties;
/* loaded from: classes3.dex */
public class c {
    String a;
    String[] b;
    Properties c;

    public c() {
        this.c = null;
    }

    public c(String str, String[] strArr, Properties properties) {
        this.c = null;
        this.a = str;
        this.b = strArr;
        this.c = properties;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof c) {
            c cVar = (c) obj;
            boolean z = this.a.equals(cVar.a) && Arrays.equals(this.b, cVar.b);
            Properties properties = this.c;
            return properties != null ? z && properties.equals(cVar.c) : z && cVar.c == null;
        }
        return false;
    }

    public int hashCode() {
        String str = this.a;
        int hashCode = str != null ? str.hashCode() : 0;
        String[] strArr = this.b;
        if (strArr != null) {
            hashCode ^= Arrays.hashCode(strArr);
        }
        Properties properties = this.c;
        return properties != null ? hashCode ^ properties.hashCode() : hashCode;
    }

    public String toString() {
        String str;
        String str2 = this.a;
        String[] strArr = this.b;
        if (strArr != null) {
            String str3 = strArr[0];
            for (int i2 = 1; i2 < this.b.length; i2++) {
                str3 = str3 + "," + this.b[i2];
            }
            str = "[" + str3 + "]";
        } else {
            str = "";
        }
        if (this.c != null) {
            str = str + this.c.toString();
        }
        return str2 + str;
    }
}
