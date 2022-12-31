package us.pinguo.common.network.common.header;
/* loaded from: classes4.dex */
public class PGUssTransHeader implements IPGHeader {
    private static final String HEADER_NAME = "X-PG-UssTrans";
    private String encrypt;

    /* loaded from: classes4.dex */
    public static final class Builder {
        private String encryptAlg;

        public PGUssTransHeader build() {
            return new PGUssTransHeader(this);
        }

        public Builder encryptAlg(String str) {
            this.encryptAlg = str;
            return this;
        }
    }

    public String getEncrypt() {
        return this.encrypt;
    }

    @Override // us.pinguo.common.network.common.header.IPGHeader
    public String getName() {
        return HEADER_NAME;
    }

    @Override // us.pinguo.common.network.common.header.IPGHeader
    public String getValue() {
        return this.encrypt;
    }

    private PGUssTransHeader(Builder builder) {
        this.encrypt = builder.encryptAlg;
    }
}
