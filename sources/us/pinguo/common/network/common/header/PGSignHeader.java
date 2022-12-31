package us.pinguo.common.network.common.header;

import android.text.TextUtils;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import us.pinguo.common.log.a;
import us.pinguo.common.network.common.PGNetworkConstants;
import us.pinguo.common.network.encrypt.Base16;
import us.pinguo.common.network.encrypt.HmacSHA256;
/* loaded from: classes4.dex */
public class PGSignHeader implements IPGHeader {
    private static final String DEIVIDER = "\n";
    public static final String HEADER_NAME = "X-PG-Sig";
    public static final String HEADER_NAME_COMPAT = "X-Pg-Sig";
    private byte[] body;
    private byte[] key;
    private final String mValue;
    private String timeStr;
    private PGTransHeader transHeader;
    private String uaStr;
    private String uriPath;

    /* loaded from: classes4.dex */
    public static final class Builder {
        private byte[] body;
        private byte[] key;
        private PGTransHeader pgEncryption;
        private String timeStr;
        private String uaStr;
        private String uriPath;

        public Builder body(byte[] bArr) {
            this.body = bArr;
            return this;
        }

        public PGSignHeader build() {
            return new PGSignHeader(this);
        }

        public Builder key(byte[] bArr) {
            this.key = bArr;
            return this;
        }

        public Builder pgEncryption(PGTransHeader pGTransHeader) {
            this.pgEncryption = pGTransHeader;
            return this;
        }

        public Builder timeStr(String str) {
            this.timeStr = str;
            return this;
        }

        public Builder uaStr(String str) {
            this.uaStr = str;
            return this;
        }

        public Builder uriPath(String str) {
            this.uriPath = str;
            return this;
        }
    }

    private String getSign() {
        if (needSign()) {
            try {
                byte[] bytes = (DEIVIDER + this.uriPath + DEIVIDER + this.transHeader.getValue() + DEIVIDER + this.uaStr + DEIVIDER + this.timeStr).getBytes();
                byte[] bArr = this.body;
                if (bArr != null) {
                    byte[] bArr2 = new byte[bArr.length + bytes.length];
                    System.arraycopy(bArr, 0, bArr2, 0, bArr.length);
                    System.arraycopy(bytes, 0, bArr2, this.body.length, bytes.length);
                    bytes = bArr2;
                }
                if (PGNetworkConstants.DEBUG_LOG) {
                    a.d("PGNet", "signData:" + bytes, new Object[0]);
                }
                return Base16.encode(HmacSHA256.hash(bytes, this.key));
            } catch (InvalidKeyException e2) {
                e2.printStackTrace();
                throw new RuntimeException("get sign error!");
            } catch (NoSuchAlgorithmException e3) {
                e3.printStackTrace();
                throw new RuntimeException("get sign error!");
            }
        }
        return null;
    }

    private boolean needSign() {
        PGTransHeader pGTransHeader;
        return (this.key == null || (pGTransHeader = this.transHeader) == null || TextUtils.isEmpty(pGTransHeader.getKeyAlg())) ? false : true;
    }

    @Override // us.pinguo.common.network.common.header.IPGHeader
    public String getName() {
        return HEADER_NAME;
    }

    @Override // us.pinguo.common.network.common.header.IPGHeader
    public String getValue() {
        return this.mValue;
    }

    private PGSignHeader(Builder builder) {
        this.body = builder.body;
        this.uriPath = builder.uriPath;
        this.transHeader = builder.pgEncryption;
        this.uaStr = builder.uaStr;
        this.timeStr = builder.timeStr;
        this.key = builder.key;
        this.mValue = getSign();
    }
}
