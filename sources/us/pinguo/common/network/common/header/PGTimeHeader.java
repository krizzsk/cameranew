package us.pinguo.common.network.common.header;
/* loaded from: classes4.dex */
public class PGTimeHeader implements IPGHeader {
    public static final String HEADER_NAME = "X-PG-Time";
    public static final String HEADER_NAME_COMPAT = "X-Pg-Time";
    private final String mValue;

    private PGTimeHeader(String str) {
        this.mValue = str;
    }

    public static PGTimeHeader fromValue(String str) {
        return new PGTimeHeader(str);
    }

    @Override // us.pinguo.common.network.common.header.IPGHeader
    public String getName() {
        return HEADER_NAME;
    }

    @Override // us.pinguo.common.network.common.header.IPGHeader
    public String getValue() {
        return this.mValue;
    }

    public PGTimeHeader() {
        this.mValue = String.valueOf(System.currentTimeMillis() / 1000);
    }
}
