package us.pinguo.common.network.encrypt;

import com.growingio.android.sdk.java_websocket.drafts.Draft_75;
/* loaded from: classes4.dex */
public class Base16 {
    public static byte[] decode(String str) {
        int length = str.length() / 2;
        byte[] bArr = new byte[length];
        for (int i2 = 0; i2 < length; i2++) {
            int i3 = i2 * 2;
            bArr[i2] = (byte) Integer.parseInt(str.substring(i3, i3 + 2), 16);
        }
        return bArr;
    }

    public static String encode(byte[] bArr) {
        StringBuffer stringBuffer = new StringBuffer(bArr.length * 2);
        for (int i2 = 0; i2 < bArr.length; i2++) {
            if ((bArr[i2] & Draft_75.END_OF_FRAME) < 16) {
                stringBuffer.append("0");
            }
            stringBuffer.append(Long.toString(bArr[i2] & Draft_75.END_OF_FRAME, 16));
        }
        return stringBuffer.toString();
    }
}
