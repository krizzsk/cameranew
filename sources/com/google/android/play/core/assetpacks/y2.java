package com.google.android.play.core.assetpacks;

import androidx.annotation.Nullable;
/* loaded from: classes2.dex */
final class y2 {
    private final int a;
    private final String b;
    private final long c;

    /* renamed from: d  reason: collision with root package name */
    private final long f4835d;

    /* renamed from: e  reason: collision with root package name */
    private final int f4836e;

    y2() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public y2(int i2, @Nullable String str, long j2, long j3, int i3) {
        this();
        this.a = i2;
        this.b = str;
        this.c = j2;
        this.f4835d = j3;
        this.f4836e = i3;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int a() {
        return this.a;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Nullable
    public String b() {
        return this.b;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public long c() {
        return this.c;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public long d() {
        return this.f4835d;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int e() {
        return this.f4836e;
    }

    public boolean equals(Object obj) {
        String str;
        if (obj == this) {
            return true;
        }
        if (obj instanceof y2) {
            y2 y2Var = (y2) obj;
            if (this.a == y2Var.a() && ((str = this.b) != null ? str.equals(y2Var.b()) : y2Var.b() == null) && this.c == y2Var.c() && this.f4835d == y2Var.d() && this.f4836e == y2Var.e()) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        int i2 = (this.a ^ 1000003) * 1000003;
        String str = this.b;
        int hashCode = str == null ? 0 : str.hashCode();
        long j2 = this.c;
        long j3 = this.f4835d;
        return ((((((i2 ^ hashCode) * 1000003) ^ ((int) (j2 ^ (j2 >>> 32)))) * 1000003) ^ ((int) ((j3 >>> 32) ^ j3))) * 1000003) ^ this.f4836e;
    }

    public String toString() {
        int i2 = this.a;
        String str = this.b;
        long j2 = this.c;
        long j3 = this.f4835d;
        int i3 = this.f4836e;
        StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 157);
        sb.append("SliceCheckpoint{fileExtractionStatus=");
        sb.append(i2);
        sb.append(", filePath=");
        sb.append(str);
        sb.append(", fileOffset=");
        sb.append(j2);
        sb.append(", remainingBytes=");
        sb.append(j3);
        sb.append(", previousChunk=");
        sb.append(i3);
        sb.append("}");
        return sb.toString();
    }
}
