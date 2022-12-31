package com.google.android.play.core.assetpacks;

import java.util.Map;
/* loaded from: classes2.dex */
final class q0 extends e {
    private final long a;
    private final Map<String, AssetPackState> b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public q0(long j2, Map<String, AssetPackState> map) {
        this.a = j2;
        this.b = map;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof e) {
            e eVar = (e) obj;
            if (this.a == eVar.g() && this.b.equals(eVar.f())) {
                return true;
            }
        }
        return false;
    }

    @Override // com.google.android.play.core.assetpacks.e
    public final Map<String, AssetPackState> f() {
        return this.b;
    }

    @Override // com.google.android.play.core.assetpacks.e
    public final long g() {
        return this.a;
    }

    public final int hashCode() {
        long j2 = this.a;
        return this.b.hashCode() ^ ((((int) (j2 ^ (j2 >>> 32))) ^ 1000003) * 1000003);
    }

    public final String toString() {
        long j2 = this.a;
        String valueOf = String.valueOf(this.b);
        StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 61);
        sb.append("AssetPackStates{totalBytes=");
        sb.append(j2);
        sb.append(", packStates=");
        sb.append(valueOf);
        sb.append("}");
        return sb.toString();
    }
}
