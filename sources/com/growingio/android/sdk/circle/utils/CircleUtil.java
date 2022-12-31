package com.growingio.android.sdk.circle.utils;
/* loaded from: classes2.dex */
public class CircleUtil {
    private static final String TAG = "GIO.CircleUtil";

    /* JADX WARN: Removed duplicated region for block: B:40:0x00ce  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x00d1  */
    /* JADX WARN: Removed duplicated region for block: B:44:0x00d7 A[Catch: UnsupportedEncodingException -> 0x0186, JSONException -> 0x018d, TryCatch #2 {UnsupportedEncodingException -> 0x0186, JSONException -> 0x018d, blocks: (B:3:0x000a, B:5:0x0016, B:6:0x001f, B:8:0x0023, B:10:0x0029, B:11:0x0030, B:13:0x0047, B:16:0x004e, B:18:0x0084, B:23:0x008c, B:25:0x009c, B:31:0x00b3, B:33:0x00bc, B:35:0x00c0, B:38:0x00c9, B:42:0x00d3, B:44:0x00d7, B:45:0x00e9, B:47:0x00f2, B:49:0x00f8, B:50:0x00ff, B:53:0x010d, B:54:0x011c, B:56:0x0125, B:59:0x012b, B:61:0x0133, B:62:0x013f, B:63:0x0142, B:65:0x0151, B:66:0x0160, B:68:0x0171, B:69:0x0180, B:27:0x00a2, B:29:0x00ad), top: B:77:0x000a }] */
    /* JADX WARN: Removed duplicated region for block: B:53:0x010d A[Catch: UnsupportedEncodingException -> 0x0186, JSONException -> 0x018d, TRY_ENTER, TryCatch #2 {UnsupportedEncodingException -> 0x0186, JSONException -> 0x018d, blocks: (B:3:0x000a, B:5:0x0016, B:6:0x001f, B:8:0x0023, B:10:0x0029, B:11:0x0030, B:13:0x0047, B:16:0x004e, B:18:0x0084, B:23:0x008c, B:25:0x009c, B:31:0x00b3, B:33:0x00bc, B:35:0x00c0, B:38:0x00c9, B:42:0x00d3, B:44:0x00d7, B:45:0x00e9, B:47:0x00f2, B:49:0x00f8, B:50:0x00ff, B:53:0x010d, B:54:0x011c, B:56:0x0125, B:59:0x012b, B:61:0x0133, B:62:0x013f, B:63:0x0142, B:65:0x0151, B:66:0x0160, B:68:0x0171, B:69:0x0180, B:27:0x00a2, B:29:0x00ad), top: B:77:0x000a }] */
    /* JADX WARN: Removed duplicated region for block: B:56:0x0125 A[Catch: UnsupportedEncodingException -> 0x0186, JSONException -> 0x018d, TRY_LEAVE, TryCatch #2 {UnsupportedEncodingException -> 0x0186, JSONException -> 0x018d, blocks: (B:3:0x000a, B:5:0x0016, B:6:0x001f, B:8:0x0023, B:10:0x0029, B:11:0x0030, B:13:0x0047, B:16:0x004e, B:18:0x0084, B:23:0x008c, B:25:0x009c, B:31:0x00b3, B:33:0x00bc, B:35:0x00c0, B:38:0x00c9, B:42:0x00d3, B:44:0x00d7, B:45:0x00e9, B:47:0x00f2, B:49:0x00f8, B:50:0x00ff, B:53:0x010d, B:54:0x011c, B:56:0x0125, B:59:0x012b, B:61:0x0133, B:62:0x013f, B:63:0x0142, B:65:0x0151, B:66:0x0160, B:68:0x0171, B:69:0x0180, B:27:0x00a2, B:29:0x00ad), top: B:77:0x000a }] */
    /* JADX WARN: Removed duplicated region for block: B:65:0x0151 A[Catch: UnsupportedEncodingException -> 0x0186, JSONException -> 0x018d, TryCatch #2 {UnsupportedEncodingException -> 0x0186, JSONException -> 0x018d, blocks: (B:3:0x000a, B:5:0x0016, B:6:0x001f, B:8:0x0023, B:10:0x0029, B:11:0x0030, B:13:0x0047, B:16:0x004e, B:18:0x0084, B:23:0x008c, B:25:0x009c, B:31:0x00b3, B:33:0x00bc, B:35:0x00c0, B:38:0x00c9, B:42:0x00d3, B:44:0x00d7, B:45:0x00e9, B:47:0x00f2, B:49:0x00f8, B:50:0x00ff, B:53:0x010d, B:54:0x011c, B:56:0x0125, B:59:0x012b, B:61:0x0133, B:62:0x013f, B:63:0x0142, B:65:0x0151, B:66:0x0160, B:68:0x0171, B:69:0x0180, B:27:0x00a2, B:29:0x00ad), top: B:77:0x000a }] */
    /* JADX WARN: Removed duplicated region for block: B:68:0x0171 A[Catch: UnsupportedEncodingException -> 0x0186, JSONException -> 0x018d, TryCatch #2 {UnsupportedEncodingException -> 0x0186, JSONException -> 0x018d, blocks: (B:3:0x000a, B:5:0x0016, B:6:0x001f, B:8:0x0023, B:10:0x0029, B:11:0x0030, B:13:0x0047, B:16:0x004e, B:18:0x0084, B:23:0x008c, B:25:0x009c, B:31:0x00b3, B:33:0x00bc, B:35:0x00c0, B:38:0x00c9, B:42:0x00d3, B:44:0x00d7, B:45:0x00e9, B:47:0x00f2, B:49:0x00f8, B:50:0x00ff, B:53:0x010d, B:54:0x011c, B:56:0x0125, B:59:0x012b, B:61:0x0133, B:62:0x013f, B:63:0x0142, B:65:0x0151, B:66:0x0160, B:68:0x0171, B:69:0x0180, B:27:0x00a2, B:29:0x00ad), top: B:77:0x000a }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static org.json.JSONObject getImpressObj(com.growingio.android.sdk.models.ViewNode r11) {
        /*
            Method dump skipped, instructions count: 404
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.growingio.android.sdk.circle.utils.CircleUtil.getImpressObj(com.growingio.android.sdk.models.ViewNode):org.json.JSONObject");
    }
}
