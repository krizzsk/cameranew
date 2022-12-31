package com.growingio.android.sdk.models;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.growingio.android.sdk.collection.Constants;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class WebEvent extends VPAEvent {
    private JSONObject mJsonEvent;
    private String mOriginalEvent;
    private String mPageName;
    private int mSize;
    private ViewNode mTargetNode;
    private String type;

    public WebEvent(String str, @Nullable ViewNode viewNode, @NonNull String str2) {
        super(System.currentTimeMillis());
        this.mSize = 0;
        this.type = "hybrid";
        this.mOriginalEvent = str;
        this.mTargetNode = viewNode;
        this.mPageName = str2;
    }

    private void addPrefix(JSONObject jSONObject, String str, String str2) throws JSONException {
        String string = jSONObject.getString(str);
        if (string != null) {
            jSONObject.put(str, str2 + Constants.WEB_PART_SEPARATOR + string);
        }
    }

    @Override // com.growingio.android.sdk.models.VPAEvent
    public String getFullType() {
        return this.type.equals(ActionEvent.CLICK_TYPE_NAME) ? "click" : this.type;
    }

    @Override // com.growingio.android.sdk.models.VPAEvent
    public String getType() {
        return this.type;
    }

    @Override // com.growingio.android.sdk.models.VPAEvent
    public int size() {
        return this.mSize;
    }

    /* JADX WARN: Removed duplicated region for block: B:42:0x0102 A[Catch: Exception -> 0x010c, TryCatch #0 {Exception -> 0x010c, blocks: (B:5:0x000d, B:7:0x004b, B:8:0x0050, B:10:0x005a, B:12:0x0064, B:15:0x006f, B:17:0x0079, B:19:0x0086, B:20:0x008b, B:22:0x0095, B:24:0x009b, B:40:0x00fc, B:42:0x0102, B:43:0x0109, B:25:0x00a1, B:27:0x00b0, B:29:0x00b8, B:32:0x00c0, B:33:0x00cc, B:35:0x00de, B:36:0x00e1, B:38:0x00e7, B:39:0x00f9), top: B:48:0x000d }] */
    @Override // com.growingio.android.sdk.models.VPAEvent
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public org.json.JSONObject toJson() {
        /*
            Method dump skipped, instructions count: 274
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.growingio.android.sdk.models.WebEvent.toJson():org.json.JSONObject");
    }
}
