package com.bytedance.sdk.openadsdk.h.e;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.bytedance.sdk.openadsdk.h.i;
import com.growingio.android.sdk.deeplink.DeeplinkCallback;
import java.io.InputStream;
import java.util.List;
import tv.danmaku.ijk.media.player.IjkMediaCodecInfo;
/* compiled from: AbsResponseWrapper.java */
/* loaded from: classes.dex */
public abstract class a {
    List<i.b> a;
    f b;

    public abstract int a();

    /* JADX INFO: Access modifiers changed from: protected */
    public i.b a(String str) {
        List<i.b> list;
        if (str != null && (list = this.a) != null && list.size() > 0) {
            for (i.b bVar : this.a) {
                if (str.equals(bVar.a)) {
                    return bVar;
                }
            }
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public String a(int i2) {
        switch (i2) {
            case 200:
                return "OK";
            case 201:
                return "Created";
            case 202:
                return "Accepted";
            case 203:
                return "Non-Authoritative";
            case 204:
                return "No Content";
            case 205:
                return "Reset Content";
            case 206:
                return "Partial Content";
            default:
                switch (i2) {
                    case IjkMediaCodecInfo.RANK_SECURE /* 300 */:
                        return "Multiple Choices";
                    case 301:
                        return "Moved Permanently";
                    case 302:
                        return "Temporary Redirect";
                    case 303:
                        return "See Other";
                    case 304:
                        return "Not Modified";
                    case 305:
                        return "Use Proxy";
                    default:
                        switch (i2) {
                            case 400:
                                return "Bad Request";
                            case 401:
                                return "Unauthorized";
                            case TypedValues.CycleType.TYPE_VISIBILITY /* 402 */:
                                return "Payment Required";
                            case TypedValues.CycleType.TYPE_ALPHA /* 403 */:
                                return "Forbidden";
                            case DeeplinkCallback.ERROR_LINK_NOT_EXIST /* 404 */:
                                return "Not Found";
                            case 405:
                                return "Method Not Allowed";
                            case DeeplinkCallback.ERROR_APP_NOT_ACCEPT /* 406 */:
                                return "Not Acceptable";
                            case 407:
                                return "Proxy Authentication Required";
                            case DeeplinkCallback.ERROR_TIMEOUT /* 408 */:
                                return "Request Time-Out";
                            case 409:
                                return "Conflict";
                            case 410:
                                return "Gone";
                            case 411:
                                return "Length Required";
                            case DeeplinkCallback.ERROR_URL_FORMAT_ERROR /* 412 */:
                                return "Precondition Failed";
                            case 413:
                                return "Request Entity Too Large";
                            case 414:
                                return "Request-URI Too Large";
                            case 415:
                                return "Unsupported Media Type";
                            default:
                                switch (i2) {
                                    case 500:
                                        return "Internal Server Error";
                                    case TypedValues.PositionType.TYPE_TRANSITION_EASING /* 501 */:
                                        return "Not Implemented";
                                    case TypedValues.PositionType.TYPE_DRAWPATH /* 502 */:
                                        return "Bad Gateway";
                                    case TypedValues.PositionType.TYPE_PERCENT_WIDTH /* 503 */:
                                        return "Service Unavailable";
                                    case TypedValues.PositionType.TYPE_PERCENT_HEIGHT /* 504 */:
                                        return "Gateway Timeout";
                                    case TypedValues.PositionType.TYPE_SIZE_PERCENT /* 505 */:
                                        return "HTTP Version Not Supported";
                                    default:
                                        return "";
                                }
                        }
                }
        }
    }

    public abstract String a(String str, String str2);

    public abstract boolean b();

    public abstract List<i.b> c();

    public abstract InputStream d();

    public abstract String e();

    public abstract String f();

    public f g() {
        return this.b;
    }
}
