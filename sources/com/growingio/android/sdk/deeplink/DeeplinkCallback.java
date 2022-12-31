package com.growingio.android.sdk.deeplink;

import java.util.Map;
/* loaded from: classes2.dex */
public interface DeeplinkCallback {
    public static final int ERROR_APP_NOT_ACCEPT = 406;
    public static final int ERROR_EXCEPTION = 6;
    public static final int ERROR_LINK_NOT_EXIST = 404;
    public static final int ERROR_NET_FAIL = 5;
    public static final int ERROR_TIMEOUT = 408;
    public static final int ERROR_UNKNOWN = 400;
    public static final int ERROR_URL_FORMAT_ERROR = 412;
    public static final int ILLEGAL_URI = 2;
    public static final int NO_QUERY = 3;
    public static final int PARSE_ERROR = 1;
    public static final int SUCCESS = 0;

    void onReceive(Map<String, String> map, int i2, long j2);
}
