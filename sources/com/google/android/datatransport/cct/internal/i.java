package com.google.android.datatransport.cct.internal;

import androidx.annotation.Nullable;
import com.google.android.datatransport.cct.internal.NetworkConnectionInfo;
/* compiled from: AutoValue_NetworkConnectionInfo.java */
/* loaded from: classes.dex */
final class i extends NetworkConnectionInfo {
    private final NetworkConnectionInfo.NetworkType a;
    private final NetworkConnectionInfo.MobileSubtype b;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: AutoValue_NetworkConnectionInfo.java */
    /* loaded from: classes.dex */
    public static final class b extends NetworkConnectionInfo.a {
        private NetworkConnectionInfo.NetworkType a;
        private NetworkConnectionInfo.MobileSubtype b;

        @Override // com.google.android.datatransport.cct.internal.NetworkConnectionInfo.a
        public NetworkConnectionInfo a() {
            return new i(this.a, this.b);
        }

        @Override // com.google.android.datatransport.cct.internal.NetworkConnectionInfo.a
        public NetworkConnectionInfo.a b(@Nullable NetworkConnectionInfo.MobileSubtype mobileSubtype) {
            this.b = mobileSubtype;
            return this;
        }

        @Override // com.google.android.datatransport.cct.internal.NetworkConnectionInfo.a
        public NetworkConnectionInfo.a c(@Nullable NetworkConnectionInfo.NetworkType networkType) {
            this.a = networkType;
            return this;
        }
    }

    @Override // com.google.android.datatransport.cct.internal.NetworkConnectionInfo
    @Nullable
    public NetworkConnectionInfo.MobileSubtype b() {
        return this.b;
    }

    @Override // com.google.android.datatransport.cct.internal.NetworkConnectionInfo
    @Nullable
    public NetworkConnectionInfo.NetworkType c() {
        return this.a;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof NetworkConnectionInfo) {
            NetworkConnectionInfo networkConnectionInfo = (NetworkConnectionInfo) obj;
            NetworkConnectionInfo.NetworkType networkType = this.a;
            if (networkType != null ? networkType.equals(networkConnectionInfo.c()) : networkConnectionInfo.c() == null) {
                NetworkConnectionInfo.MobileSubtype mobileSubtype = this.b;
                if (mobileSubtype == null) {
                    if (networkConnectionInfo.b() == null) {
                        return true;
                    }
                } else if (mobileSubtype.equals(networkConnectionInfo.b())) {
                    return true;
                }
            }
            return false;
        }
        return false;
    }

    public int hashCode() {
        NetworkConnectionInfo.NetworkType networkType = this.a;
        int hashCode = ((networkType == null ? 0 : networkType.hashCode()) ^ 1000003) * 1000003;
        NetworkConnectionInfo.MobileSubtype mobileSubtype = this.b;
        return hashCode ^ (mobileSubtype != null ? mobileSubtype.hashCode() : 0);
    }

    public String toString() {
        return "NetworkConnectionInfo{networkType=" + this.a + ", mobileSubtype=" + this.b + "}";
    }

    private i(@Nullable NetworkConnectionInfo.NetworkType networkType, @Nullable NetworkConnectionInfo.MobileSubtype mobileSubtype) {
        this.a = networkType;
        this.b = mobileSubtype;
    }
}
