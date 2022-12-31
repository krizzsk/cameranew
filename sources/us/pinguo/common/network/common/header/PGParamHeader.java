package us.pinguo.common.network.common.header;

import android.text.TextUtils;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import us.pinguo.common.network.encrypt.PGBase64;
/* loaded from: classes4.dex */
public class PGParamHeader implements IPGHeader {
    private static final String CONNECTOR = "/";
    private static final String DIVIDER = " ";
    private static final String EMPTY_PARAM = "-";
    private static final String NAME = "X-PG-Param";
    private float lan;
    private float lon;
    private final String mValue = makeString();
    private String timeZone;

    public PGParamHeader(float f2, float f3, String str) {
        this.lan = f2;
        this.lon = f3;
        this.timeZone = str;
    }

    private static boolean checkNotEmpty(String... strArr) {
        if (strArr == null) {
            return false;
        }
        for (String str : strArr) {
            if (TextUtils.isEmpty(str)) {
                return false;
            }
        }
        return true;
    }

    private static StringBuilder makeParam(StringBuilder sb, String str, String str2) {
        if (sb != null) {
            String urlEncode = urlEncode(str);
            String urlEncode2 = urlEncode(str2);
            if (checkNotEmpty(urlEncode, urlEncode2)) {
                sb.append(DIVIDER);
                sb.append(urlEncode);
                sb.append(CONNECTOR);
                sb.append(urlEncode2);
            } else if (checkNotEmpty(urlEncode)) {
                sb.append(DIVIDER);
                sb.append(urlEncode);
            } else {
                sb.append(DIVIDER);
                sb.append("-");
            }
            return sb;
        }
        throw new AssertionError("StringBuilder can not be null");
    }

    private String makeString() {
        StringBuilder sb = new StringBuilder();
        float f2 = this.lan;
        if (f2 != 0.0f && this.lon != 0.0f) {
            makeParam(sb, String.valueOf(f2), String.valueOf(this.lon));
        }
        if (!TextUtils.isEmpty(this.timeZone)) {
            makeParam(sb, this.timeZone, null);
        }
        return sb.toString().trim();
    }

    private static String urlEncode(String str) {
        if (TextUtils.isEmpty(str)) {
            return str;
        }
        try {
            return URLEncoder.encode(str, "UTF-8");
        } catch (UnsupportedEncodingException e2) {
            e2.printStackTrace();
            return str;
        }
    }

    @Override // us.pinguo.common.network.common.header.IPGHeader
    public String getName() {
        return NAME;
    }

    @Override // us.pinguo.common.network.common.header.IPGHeader
    public String getValue() {
        return PGBase64.encodeToString(this.mValue.getBytes(), 2);
    }
}
