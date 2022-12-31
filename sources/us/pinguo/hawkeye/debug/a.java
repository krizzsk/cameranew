package us.pinguo.hawkeye.debug;

import java.text.DecimalFormat;
/* compiled from: DebugProfile.java */
/* loaded from: classes4.dex */
class a implements Comparable<a> {
    public String a;
    public long b;
    public String c;

    public a(String str, long j2, double d2) {
        this.a = str;
        this.b = j2;
        this.c = new DecimalFormat("0.00#%").format(d2);
    }

    @Override // java.lang.Comparable
    /* renamed from: a */
    public int compareTo(a aVar) {
        return (int) (aVar.b - this.b);
    }
}
