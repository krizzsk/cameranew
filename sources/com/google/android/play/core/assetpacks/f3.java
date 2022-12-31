package com.google.android.play.core.assetpacks;

import androidx.annotation.Nullable;
import java.util.Arrays;
/* loaded from: classes2.dex */
final class f3 {
    private final String a;
    private final long b;
    private final int c;

    /* renamed from: d  reason: collision with root package name */
    private final boolean f4734d;

    /* renamed from: e  reason: collision with root package name */
    private final boolean f4735e;

    /* renamed from: f  reason: collision with root package name */
    private final byte[] f4736f;

    f3() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public f3(@Nullable String str, long j2, int i2, boolean z, boolean z2, @Nullable byte[] bArr) {
        this();
        this.a = str;
        this.b = j2;
        this.c = i2;
        this.f4734d = z;
        this.f4735e = z2;
        this.f4736f = bArr;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static f3 a(@Nullable String str, long j2, int i2, boolean z, byte[] bArr, boolean z2) {
        return new f3(str, j2, i2, z, z2, bArr);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final boolean b() {
        if (d() == null) {
            return false;
        }
        return d().endsWith("/");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final boolean c() {
        return f() == 0;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Nullable
    public String d() {
        return this.a;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public long e() {
        return this.b;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof f3) {
            f3 f3Var = (f3) obj;
            String str = this.a;
            if (str != null ? str.equals(f3Var.d()) : f3Var.d() == null) {
                if (this.b == f3Var.e() && this.c == f3Var.f() && this.f4734d == f3Var.g() && this.f4735e == f3Var.h()) {
                    if (Arrays.equals(this.f4736f, f3Var instanceof f3 ? f3Var.f4736f : f3Var.i())) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int f() {
        return this.c;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean g() {
        return this.f4734d;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean h() {
        return this.f4735e;
    }

    public int hashCode() {
        String str = this.a;
        int hashCode = str == null ? 0 : str.hashCode();
        long j2 = this.b;
        return ((((((((((hashCode ^ 1000003) * 1000003) ^ ((int) (j2 ^ (j2 >>> 32)))) * 1000003) ^ this.c) * 1000003) ^ (true != this.f4734d ? 1237 : 1231)) * 1000003) ^ (true == this.f4735e ? 1231 : 1237)) * 1000003) ^ Arrays.hashCode(this.f4736f);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Nullable
    public byte[] i() {
        return this.f4736f;
    }

    public String toString() {
        String str = this.a;
        long j2 = this.b;
        int i2 = this.c;
        boolean z = this.f4734d;
        boolean z2 = this.f4735e;
        String arrays = Arrays.toString(this.f4736f);
        StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 126 + String.valueOf(arrays).length());
        sb.append("ZipEntry{name=");
        sb.append(str);
        sb.append(", size=");
        sb.append(j2);
        sb.append(", compressionMethod=");
        sb.append(i2);
        sb.append(", isPartial=");
        sb.append(z);
        sb.append(", isEndOfArchive=");
        sb.append(z2);
        sb.append(", headerBytes=");
        sb.append(arrays);
        sb.append("}");
        return sb.toString();
    }
}
