package com.google.android.play.core.assetpacks;

import androidx.annotation.Nullable;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public final class o0 extends a {
    private final int b;
    private final String c;

    /* renamed from: d  reason: collision with root package name */
    private final String f4787d;

    /* JADX INFO: Access modifiers changed from: package-private */
    public o0(int i2, @Nullable String str, @Nullable String str2) {
        this.b = i2;
        this.c = str;
        this.f4787d = str2;
    }

    @Override // com.google.android.play.core.assetpacks.a
    @Nullable
    public final String c() {
        return this.f4787d;
    }

    @Override // com.google.android.play.core.assetpacks.a
    public final int d() {
        return this.b;
    }

    @Override // com.google.android.play.core.assetpacks.a
    @Nullable
    public final String e() {
        return this.c;
    }

    public final boolean equals(Object obj) {
        String str;
        if (obj == this) {
            return true;
        }
        if (obj instanceof a) {
            a aVar = (a) obj;
            if (this.b == aVar.d() && ((str = this.c) != null ? str.equals(aVar.e()) : aVar.e() == null)) {
                String str2 = this.f4787d;
                String c = aVar.c();
                if (str2 != null ? str2.equals(c) : c == null) {
                    return true;
                }
            }
        }
        return false;
    }

    public final int hashCode() {
        int i2 = (this.b ^ 1000003) * 1000003;
        String str = this.c;
        int hashCode = (i2 ^ (str == null ? 0 : str.hashCode())) * 1000003;
        String str2 = this.f4787d;
        return hashCode ^ (str2 != null ? str2.hashCode() : 0);
    }

    public final String toString() {
        int i2 = this.b;
        String str = this.c;
        String str2 = this.f4787d;
        StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 68 + String.valueOf(str2).length());
        sb.append("AssetPackLocation{packStorageMethod=");
        sb.append(i2);
        sb.append(", path=");
        sb.append(str);
        sb.append(", assetsPath=");
        sb.append(str2);
        sb.append("}");
        return sb.toString();
    }
}
