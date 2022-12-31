package com.google.android.datatransport.cct.internal;

import androidx.annotation.Nullable;
import com.google.android.datatransport.cct.internal.ClientInfo;
/* compiled from: AutoValue_ClientInfo.java */
/* loaded from: classes.dex */
final class e extends ClientInfo {
    private final ClientInfo.ClientType a;
    private final com.google.android.datatransport.cct.internal.a b;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: AutoValue_ClientInfo.java */
    /* loaded from: classes.dex */
    public static final class b extends ClientInfo.a {
        private ClientInfo.ClientType a;
        private com.google.android.datatransport.cct.internal.a b;

        @Override // com.google.android.datatransport.cct.internal.ClientInfo.a
        public ClientInfo a() {
            return new e(this.a, this.b);
        }

        @Override // com.google.android.datatransport.cct.internal.ClientInfo.a
        public ClientInfo.a b(@Nullable com.google.android.datatransport.cct.internal.a aVar) {
            this.b = aVar;
            return this;
        }

        @Override // com.google.android.datatransport.cct.internal.ClientInfo.a
        public ClientInfo.a c(@Nullable ClientInfo.ClientType clientType) {
            this.a = clientType;
            return this;
        }
    }

    @Override // com.google.android.datatransport.cct.internal.ClientInfo
    @Nullable
    public com.google.android.datatransport.cct.internal.a b() {
        return this.b;
    }

    @Override // com.google.android.datatransport.cct.internal.ClientInfo
    @Nullable
    public ClientInfo.ClientType c() {
        return this.a;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof ClientInfo) {
            ClientInfo clientInfo = (ClientInfo) obj;
            ClientInfo.ClientType clientType = this.a;
            if (clientType != null ? clientType.equals(clientInfo.c()) : clientInfo.c() == null) {
                com.google.android.datatransport.cct.internal.a aVar = this.b;
                if (aVar == null) {
                    if (clientInfo.b() == null) {
                        return true;
                    }
                } else if (aVar.equals(clientInfo.b())) {
                    return true;
                }
            }
            return false;
        }
        return false;
    }

    public int hashCode() {
        ClientInfo.ClientType clientType = this.a;
        int hashCode = ((clientType == null ? 0 : clientType.hashCode()) ^ 1000003) * 1000003;
        com.google.android.datatransport.cct.internal.a aVar = this.b;
        return hashCode ^ (aVar != null ? aVar.hashCode() : 0);
    }

    public String toString() {
        return "ClientInfo{clientType=" + this.a + ", androidClientInfo=" + this.b + "}";
    }

    private e(@Nullable ClientInfo.ClientType clientType, @Nullable com.google.android.datatransport.cct.internal.a aVar) {
        this.a = clientType;
        this.b = aVar;
    }
}
