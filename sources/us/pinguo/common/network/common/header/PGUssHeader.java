package us.pinguo.common.network.common.header;

import us.pinguo.common.network.common.PGSecureUtils;
import us.pinguo.common.network.encrypt.Base16;
/* loaded from: classes4.dex */
public class PGUssHeader implements IPGHeader {
    private static final String HEADER_NAME = "X-PG-Uss";
    private String encryptAlg;
    private byte[] key;
    private String token;
    private String uss;

    /* loaded from: classes4.dex */
    public static final class Builder {
        private String encryptAlg;
        private byte[] key;
        private String token;

        public PGUssHeader build() {
            return new PGUssHeader(this);
        }

        public Builder encryptAlg(String str) {
            this.encryptAlg = str;
            return this;
        }

        public Builder key(byte[] bArr) {
            this.key = bArr;
            return this;
        }

        public Builder token(String str) {
            this.token = str;
            return this;
        }
    }

    @Override // us.pinguo.common.network.common.header.IPGHeader
    public String getName() {
        return HEADER_NAME;
    }

    @Override // us.pinguo.common.network.common.header.IPGHeader
    public String getValue() {
        return this.uss;
    }

    private PGUssHeader(Builder builder) {
        this.token = builder.token;
        this.key = builder.key;
        String str = builder.encryptAlg;
        this.encryptAlg = str;
        this.uss = Base16.encode(PGSecureUtils.encrypt(str, this.token.getBytes(), this.key));
    }
}
