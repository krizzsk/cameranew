package com.google.android.play.core.assetpacks;

import java.util.Objects;
/* loaded from: classes2.dex */
final class p0 extends AssetPackState {
    private final String a;
    private final int b;
    private final int c;

    /* renamed from: d  reason: collision with root package name */
    private final long f4789d;

    /* renamed from: e  reason: collision with root package name */
    private final long f4790e;

    /* renamed from: f  reason: collision with root package name */
    private final int f4791f;

    /* JADX INFO: Access modifiers changed from: package-private */
    public p0(String str, int i2, int i3, long j2, long j3, int i4) {
        Objects.requireNonNull(str, "Null name");
        this.a = str;
        this.b = i2;
        this.c = i3;
        this.f4789d = j2;
        this.f4790e = j3;
        this.f4791f = i4;
    }

    @Override // com.google.android.play.core.assetpacks.AssetPackState
    public final long c() {
        return this.f4789d;
    }

    @Override // com.google.android.play.core.assetpacks.AssetPackState
    public final int d() {
        return this.c;
    }

    @Override // com.google.android.play.core.assetpacks.AssetPackState
    public final String e() {
        return this.a;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof AssetPackState) {
            AssetPackState assetPackState = (AssetPackState) obj;
            if (this.a.equals(assetPackState.e()) && this.b == assetPackState.f() && this.c == assetPackState.d() && this.f4789d == assetPackState.c() && this.f4790e == assetPackState.g() && this.f4791f == assetPackState.h()) {
                return true;
            }
        }
        return false;
    }

    @Override // com.google.android.play.core.assetpacks.AssetPackState
    public final int f() {
        return this.b;
    }

    @Override // com.google.android.play.core.assetpacks.AssetPackState
    public final long g() {
        return this.f4790e;
    }

    @Override // com.google.android.play.core.assetpacks.AssetPackState
    public final int h() {
        return this.f4791f;
    }

    public final int hashCode() {
        int hashCode = this.a.hashCode();
        int i2 = this.b;
        int i3 = this.c;
        long j2 = this.f4789d;
        long j3 = this.f4790e;
        return ((((((((((hashCode ^ 1000003) * 1000003) ^ i2) * 1000003) ^ i3) * 1000003) ^ ((int) ((j2 >>> 32) ^ j2))) * 1000003) ^ ((int) ((j3 >>> 32) ^ j3))) * 1000003) ^ this.f4791f;
    }

    public final String toString() {
        String str = this.a;
        int i2 = this.b;
        int i3 = this.c;
        long j2 = this.f4789d;
        long j3 = this.f4790e;
        int i4 = this.f4791f;
        StringBuilder sb = new StringBuilder(str.length() + 185);
        sb.append("AssetPackState{name=");
        sb.append(str);
        sb.append(", status=");
        sb.append(i2);
        sb.append(", errorCode=");
        sb.append(i3);
        sb.append(", bytesDownloaded=");
        sb.append(j2);
        sb.append(", totalBytesToDownload=");
        sb.append(j3);
        sb.append(", transferProgressPercentage=");
        sb.append(i4);
        sb.append("}");
        return sb.toString();
    }
}
