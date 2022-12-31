package com.google.android.play.core.splitinstall;

import android.app.PendingIntent;
import android.content.Intent;
import androidx.annotation.Nullable;
import java.util.List;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public final class f extends d {
    private final int a;
    private final int b;
    private final int c;

    /* renamed from: d  reason: collision with root package name */
    private final long f4874d;

    /* renamed from: e  reason: collision with root package name */
    private final long f4875e;

    /* renamed from: f  reason: collision with root package name */
    private final List<String> f4876f;

    /* renamed from: g  reason: collision with root package name */
    private final List<String> f4877g;

    /* renamed from: h  reason: collision with root package name */
    private final PendingIntent f4878h;

    /* renamed from: i  reason: collision with root package name */
    private final List<Intent> f4879i;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(int i2, int i3, int i4, long j2, long j3, @Nullable List<String> list, @Nullable List<String> list2, @Nullable PendingIntent pendingIntent, @Nullable List<Intent> list3) {
        this.a = i2;
        this.b = i3;
        this.c = i4;
        this.f4874d = j2;
        this.f4875e = j3;
        this.f4876f = list;
        this.f4877g = list2;
        this.f4878h = pendingIntent;
        this.f4879i = list3;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.play.core.splitinstall.d
    @Nullable
    public final List<String> b() {
        return this.f4876f;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.play.core.splitinstall.d
    @Nullable
    public final List<String> c() {
        return this.f4877g;
    }

    @Override // com.google.android.play.core.splitinstall.d
    public final long d() {
        return this.f4874d;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.play.core.splitinstall.d
    @Nullable
    public final List<Intent> e() {
        return this.f4879i;
    }

    public final boolean equals(Object obj) {
        List<String> list;
        List<String> list2;
        PendingIntent pendingIntent;
        if (obj == this) {
            return true;
        }
        if (obj instanceof d) {
            d dVar = (d) obj;
            if (this.a == dVar.l() && this.b == dVar.m() && this.c == dVar.g() && this.f4874d == dVar.d() && this.f4875e == dVar.n() && ((list = this.f4876f) != null ? list.equals(dVar.b()) : dVar.b() == null) && ((list2 = this.f4877g) != null ? list2.equals(dVar.c()) : dVar.c() == null) && ((pendingIntent = this.f4878h) != null ? pendingIntent.equals(dVar.k()) : dVar.k() == null)) {
                List<Intent> list3 = this.f4879i;
                List<Intent> e2 = dVar.e();
                if (list3 != null ? list3.equals(e2) : e2 == null) {
                    return true;
                }
            }
        }
        return false;
    }

    @Override // com.google.android.play.core.splitinstall.d
    public final int g() {
        return this.c;
    }

    public final int hashCode() {
        int i2 = this.a;
        int i3 = this.b;
        int i4 = this.c;
        long j2 = this.f4874d;
        long j3 = this.f4875e;
        int i5 = (((((((((i2 ^ 1000003) * 1000003) ^ i3) * 1000003) ^ i4) * 1000003) ^ ((int) ((j2 >>> 32) ^ j2))) * 1000003) ^ ((int) ((j3 >>> 32) ^ j3))) * 1000003;
        List<String> list = this.f4876f;
        int hashCode = (i5 ^ (list == null ? 0 : list.hashCode())) * 1000003;
        List<String> list2 = this.f4877g;
        int hashCode2 = (hashCode ^ (list2 == null ? 0 : list2.hashCode())) * 1000003;
        PendingIntent pendingIntent = this.f4878h;
        int hashCode3 = (hashCode2 ^ (pendingIntent == null ? 0 : pendingIntent.hashCode())) * 1000003;
        List<Intent> list3 = this.f4879i;
        return hashCode3 ^ (list3 != null ? list3.hashCode() : 0);
    }

    @Override // com.google.android.play.core.splitinstall.d
    @Nullable
    @Deprecated
    public final PendingIntent k() {
        return this.f4878h;
    }

    @Override // com.google.android.play.core.splitinstall.d
    public final int l() {
        return this.a;
    }

    @Override // com.google.android.play.core.splitinstall.d
    public final int m() {
        return this.b;
    }

    @Override // com.google.android.play.core.splitinstall.d
    public final long n() {
        return this.f4875e;
    }

    public final String toString() {
        int i2 = this.a;
        int i3 = this.b;
        int i4 = this.c;
        long j2 = this.f4874d;
        long j3 = this.f4875e;
        String valueOf = String.valueOf(this.f4876f);
        String valueOf2 = String.valueOf(this.f4877g);
        String valueOf3 = String.valueOf(this.f4878h);
        String valueOf4 = String.valueOf(this.f4879i);
        int length = String.valueOf(valueOf).length();
        int length2 = String.valueOf(valueOf2).length();
        StringBuilder sb = new StringBuilder(length + 251 + length2 + String.valueOf(valueOf3).length() + String.valueOf(valueOf4).length());
        sb.append("SplitInstallSessionState{sessionId=");
        sb.append(i2);
        sb.append(", status=");
        sb.append(i3);
        sb.append(", errorCode=");
        sb.append(i4);
        sb.append(", bytesDownloaded=");
        sb.append(j2);
        sb.append(", totalBytesToDownload=");
        sb.append(j3);
        sb.append(", moduleNamesNullable=");
        sb.append(valueOf);
        sb.append(", languagesNullable=");
        sb.append(valueOf2);
        sb.append(", resolutionIntent=");
        sb.append(valueOf3);
        sb.append(", splitFileIntents=");
        sb.append(valueOf4);
        sb.append("}");
        return sb.toString();
    }
}
