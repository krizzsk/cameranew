package d.e.d.o;

import androidx.core.view.PointerIconCompat;
import com.growingio.android.sdk.java_websocket.framing.CloseFrame;
/* compiled from: Utils.java */
/* loaded from: classes2.dex */
public class d {
    public static String a(int i2) {
        String str = "not defined message for " + i2;
        if (i2 != 404) {
            switch (i2) {
                case 1004:
                    return "malformed url exception";
                case CloseFrame.NOCODE /* 1005 */:
                    break;
                case 1006:
                    return "http empty response";
                default:
                    switch (i2) {
                        case 1008:
                            return "socket timeout exception";
                        case 1009:
                            return "io exception";
                        case 1010:
                            return "uri syntax exception";
                        case 1011:
                            return "http error code";
                        default:
                            switch (i2) {
                                case PointerIconCompat.TYPE_ZOOM_IN /* 1018 */:
                                    return "file not found exception";
                                case PointerIconCompat.TYPE_ZOOM_OUT /* 1019 */:
                                    return "out of memory exception";
                                case PointerIconCompat.TYPE_GRAB /* 1020 */:
                                    return "failed to create folder for file";
                                default:
                                    return str;
                            }
                    }
            }
        }
        return "http not found";
    }
}
