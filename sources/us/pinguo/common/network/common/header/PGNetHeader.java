package us.pinguo.common.network.common.header;
/* loaded from: classes4.dex */
public class PGNetHeader implements IPGHeader {
    public static final String HEADER_NAME = "X-PG-Net";
    private final String mNetType;

    public PGNetHeader(String str) {
        this.mNetType = str;
    }

    @Override // us.pinguo.common.network.common.header.IPGHeader
    public String getName() {
        return HEADER_NAME;
    }

    @Override // us.pinguo.common.network.common.header.IPGHeader
    public String getValue() {
        return this.mNetType;
    }
}
