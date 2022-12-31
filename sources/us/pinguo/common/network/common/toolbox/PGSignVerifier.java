package us.pinguo.common.network.common.toolbox;

import us.pinguo.common.network.common.PGSecureUtils;
import us.pinguo.common.network.common.header.PGSignHeader;
import us.pinguo.common.network.common.header.PGTimeHeader;
import us.pinguo.common.network.common.header.PGTransHeader;
import us.pinguo.common.network.common.header.PGUserAgentHeader;
/* loaded from: classes4.dex */
public class PGSignVerifier {
    public static boolean verrify(String str, PGTransHeader pGTransHeader, PGUserAgentHeader pGUserAgentHeader, byte[] bArr, String str2, String str3, PGTimeHeader pGTimeHeader) {
        try {
            return str.equals(new PGSignHeader.Builder().key(PGSecureUtils.genRawDataKey(pGTransHeader.getKeyAlg(), pGTransHeader.getKeyInclude(), pGUserAgentHeader.getAppName(), pGUserAgentHeader.getDeviceId(), str3, pGTimeHeader.getValue())).uaStr(pGUserAgentHeader.getValue()).body(bArr).uriPath(str2).timeStr(pGTimeHeader.getValue()).pgEncryption(pGTransHeader).build().getValue());
        } catch (Exception e2) {
            e2.printStackTrace();
            return false;
        }
    }

    public static boolean verrify(String str, PGTransHeader pGTransHeader, PGUserAgentHeader pGUserAgentHeader, byte[] bArr, String str2, byte[] bArr2, PGTimeHeader pGTimeHeader) {
        try {
            return str.equals(new PGSignHeader.Builder().key(bArr2).uaStr(pGUserAgentHeader.getValue()).body(bArr).uriPath(str2).timeStr(pGTimeHeader.getValue()).pgEncryption(pGTransHeader).build().getValue());
        } catch (Exception e2) {
            e2.printStackTrace();
            return false;
        }
    }
}
