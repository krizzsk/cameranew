package us.pinguo.common.network.common.header;
/* loaded from: classes4.dex */
public class PGUidHeader implements IPGHeader {
    public static final String HEADER_NAME = "X-PG-Uid";
    private final String mUid;

    public PGUidHeader(String str) {
        this.mUid = str;
    }

    @Override // us.pinguo.common.network.common.header.IPGHeader
    public String getName() {
        return HEADER_NAME;
    }

    @Override // us.pinguo.common.network.common.header.IPGHeader
    public String getValue() {
        return this.mUid;
    }
}
