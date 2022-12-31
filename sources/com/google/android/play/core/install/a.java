package com.google.android.play.core.install;

import java.util.Objects;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public final class a extends InstallState {
    private final int a;
    private final long b;
    private final long c;

    /* renamed from: d  reason: collision with root package name */
    private final int f4855d;

    /* renamed from: e  reason: collision with root package name */
    private final String f4856e;

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(int i2, long j2, long j3, int i3, String str) {
        this.a = i2;
        this.b = j2;
        this.c = j3;
        this.f4855d = i3;
        Objects.requireNonNull(str, "Null packageName");
        this.f4856e = str;
    }

    @Override // com.google.android.play.core.install.InstallState
    public final long b() {
        return this.b;
    }

    @Override // com.google.android.play.core.install.InstallState
    public final int c() {
        return this.f4855d;
    }

    @Override // com.google.android.play.core.install.InstallState
    public final int d() {
        return this.a;
    }

    @Override // com.google.android.play.core.install.InstallState
    public final String e() {
        return this.f4856e;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof InstallState) {
            InstallState installState = (InstallState) obj;
            if (this.a == installState.d() && this.b == installState.b() && this.c == installState.f() && this.f4855d == installState.c() && this.f4856e.equals(installState.e())) {
                return true;
            }
        }
        return false;
    }

    @Override // com.google.android.play.core.install.InstallState
    public final long f() {
        return this.c;
    }

    public final int hashCode() {
        int i2 = this.a;
        long j2 = this.b;
        long j3 = this.c;
        return ((((((((i2 ^ 1000003) * 1000003) ^ ((int) (j2 ^ (j2 >>> 32)))) * 1000003) ^ ((int) ((j3 >>> 32) ^ j3))) * 1000003) ^ this.f4855d) * 1000003) ^ this.f4856e.hashCode();
    }

    public final String toString() {
        int i2 = this.a;
        long j2 = this.b;
        long j3 = this.c;
        int i3 = this.f4855d;
        String str = this.f4856e;
        StringBuilder sb = new StringBuilder(str.length() + 164);
        sb.append("InstallState{installStatus=");
        sb.append(i2);
        sb.append(", bytesDownloaded=");
        sb.append(j2);
        sb.append(", totalBytesToDownload=");
        sb.append(j3);
        sb.append(", installErrorCode=");
        sb.append(i3);
        sb.append(", packageName=");
        sb.append(str);
        sb.append("}");
        return sb.toString();
    }
}
