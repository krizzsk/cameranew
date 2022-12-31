package us.pinguo.common.network.common.header;

import android.text.TextUtils;
import us.pinguo.common.log.a;
/* loaded from: classes4.dex */
public class PGTransHeader implements IPGHeader {
    public static final String CONNECTOR = "-";
    public static final String E1 = "E1";
    public static final String E2 = "E2";
    public static final String E3 = "E3";
    public static final String HEADER_NAME = "X-PG-Trans";
    public static final String HEADER_NAME_COMPAT = "X-Pg-Trans";
    public static final String S1 = "S1";
    private String encryptAlg;
    private String keyAlg;
    private int keyInclude;
    private final String mValue;
    private String sigAlg;

    /* loaded from: classes4.dex */
    public static final class Builder {
        private int keyInclude;
        private String encryptAlg = "";
        private String sigAlg = PGTransHeader.S1;
        private String keyAlg = PGTransHeader.S1;

        public PGTransHeader build() {
            return new PGTransHeader(this);
        }

        public Builder encryptAlg(String str) {
            this.encryptAlg = str;
            return this;
        }

        public Builder keyAlg(String str) {
            this.keyAlg = str;
            return this;
        }

        public Builder keyInclude(int i2) {
            this.keyInclude = i2;
            return this;
        }

        public Builder sigAlg(String str) {
            this.sigAlg = str;
            return this;
        }
    }

    public static PGTransHeader fromValue(String str) {
        if (!TextUtils.isEmpty(str)) {
            Builder builder = new Builder();
            String[] split = str.split(CONNECTOR);
            if (split.length == 4) {
                try {
                    builder.encryptAlg = split[0];
                    builder.sigAlg = split[1];
                    builder.keyAlg = split[2];
                    builder.keyInclude = Integer.parseInt(split[3]);
                    return builder.build();
                } catch (Exception e2) {
                    a.f(e2);
                }
            }
        }
        return null;
    }

    private String makeString() {
        return this.encryptAlg + CONNECTOR + this.sigAlg + CONNECTOR + this.keyAlg + CONNECTOR + this.keyInclude;
    }

    public String getEncryptAlg() {
        return this.encryptAlg;
    }

    public String getKeyAlg() {
        return this.keyAlg;
    }

    public int getKeyInclude() {
        return this.keyInclude;
    }

    @Override // us.pinguo.common.network.common.header.IPGHeader
    public String getName() {
        return HEADER_NAME;
    }

    public String getSigAlg() {
        return this.sigAlg;
    }

    @Override // us.pinguo.common.network.common.header.IPGHeader
    public String getValue() {
        return this.mValue;
    }

    private PGTransHeader(Builder builder) {
        this.encryptAlg = builder.encryptAlg;
        this.sigAlg = builder.sigAlg;
        this.keyAlg = builder.keyAlg;
        this.keyInclude = builder.keyInclude;
        this.mValue = makeString();
    }
}
