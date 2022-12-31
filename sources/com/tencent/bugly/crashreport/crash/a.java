package com.tencent.bugly.crashreport.crash;
/* compiled from: BUGLY */
/* loaded from: classes3.dex */
public final class a implements Comparable<a> {
    public long a = -1;
    public long b = -1;
    public String c = null;

    /* renamed from: d  reason: collision with root package name */
    public boolean f7851d = false;

    /* renamed from: e  reason: collision with root package name */
    public boolean f7852e = false;

    /* renamed from: f  reason: collision with root package name */
    public int f7853f = 0;

    @Override // java.lang.Comparable
    public final /* bridge */ /* synthetic */ int compareTo(a aVar) {
        int i2;
        a aVar2 = aVar;
        if (aVar2 == null || this.b - aVar2.b > 0) {
            return 1;
        }
        return i2 < 0 ? -1 : 0;
    }
}
