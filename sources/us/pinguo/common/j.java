package us.pinguo.common;
/* compiled from: KeyValueEntry.java */
/* loaded from: classes4.dex */
public class j {
    private final String a;
    private String b;
    private String[] c;

    public j(String str, String str2) {
        this.a = str;
        this.b = str2;
    }

    public void a() {
        String[] strArr;
        String[] strArr2 = this.c;
        if (strArr2 == null || strArr2.length == 0) {
            return;
        }
        StringBuilder sb = new StringBuilder();
        for (String str : this.c) {
            if (str.equals(this.b)) {
                return;
            }
            sb.append(str);
            sb.append(",");
        }
        sb.deleteCharAt(sb.length() - 1);
        throw new RuntimeException("error value:" + this.b + ",  only accept:" + ((Object) sb));
    }

    public String b() {
        return this.a;
    }

    public String c() {
        return this.b;
    }

    public void d(String str) {
        this.b = str;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof j) && b().equals(((j) obj).b());
    }

    public int hashCode() {
        return b().hashCode();
    }

    public j(String str, String str2, String[] strArr) {
        this.a = str;
        this.b = str2;
        this.c = strArr;
    }
}
