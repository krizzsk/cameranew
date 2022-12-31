package us.pinguo.common.network.common.toolbox;

import android.text.TextUtils;
import java.util.Map;
import us.pinguo.common.network.common.header.PGSignHeader;
import us.pinguo.common.network.common.header.PGTimeHeader;
import us.pinguo.common.network.common.header.PGTransHeader;
/* loaded from: classes4.dex */
public class PGHeaderParser {
    public static String parsePGSign(Map<String, String> map) {
        String str = map.get(PGSignHeader.HEADER_NAME);
        return TextUtils.isEmpty(str) ? map.get(PGSignHeader.HEADER_NAME_COMPAT) : str;
    }

    public static PGTimeHeader parsePGTime(Map<String, String> map) {
        String str = map.get(PGTimeHeader.HEADER_NAME);
        if (TextUtils.isEmpty(str)) {
            str = map.get(PGTimeHeader.HEADER_NAME_COMPAT);
        }
        return PGTimeHeader.fromValue(str);
    }

    public static PGTransHeader parsePGTrans(Map<String, String> map) {
        String str = map.get(PGTransHeader.HEADER_NAME);
        if (TextUtils.isEmpty(str)) {
            str = map.get(PGTransHeader.HEADER_NAME_COMPAT);
        }
        return PGTransHeader.fromValue(str);
    }
}
