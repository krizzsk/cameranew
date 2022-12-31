package us.pinguo.common.network.common.header;
/* loaded from: classes4.dex */
public class PGDebugHeader implements IPGHeader {
    private static final String NAME = "X-PG-Debug";
    private boolean debug;

    public PGDebugHeader(boolean z) {
        this.debug = z;
    }

    @Override // us.pinguo.common.network.common.header.IPGHeader
    public String getName() {
        return NAME;
    }

    @Override // us.pinguo.common.network.common.header.IPGHeader
    public String getValue() {
        if (this.debug) {
            return "true";
        }
        return null;
    }
}
