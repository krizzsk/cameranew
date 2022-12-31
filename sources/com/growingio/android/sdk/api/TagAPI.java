package com.growingio.android.sdk.api;

import android.text.TextUtils;
import android.util.Log;
import com.growingio.android.sdk.base.event.HttpCallBack;
import com.growingio.android.sdk.base.event.HttpEvent;
import com.growingio.android.sdk.collection.Constants;
import com.growingio.android.sdk.collection.NetworkConfig;
import com.growingio.android.sdk.models.Tag;
import com.growingio.android.sdk.models.ViewAttrs;
import com.growingio.android.sdk.utils.Util;
import com.growingio.eventcenter.EventCenter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.slf4j.Marker;
/* loaded from: classes2.dex */
public class TagAPI implements HttpCallBack {
    private static final String TAG = "GIO.TagAPI";
    List<Tag> tags = new ArrayList();

    @Override // com.growingio.android.sdk.base.event.HttpCallBack
    public void afterRequest(Integer num, byte[] bArr, long j2, Map<String, List<String>> map) {
        if (num.intValue() != 200 || bArr == null) {
            return;
        }
        this.tags.clear();
        JSONArray jSONArray = new JSONArray();
        try {
            jSONArray = new JSONArray(new String(bArr));
        } catch (JSONException e2) {
            Log.d(TAG, "generate tags error", e2);
        }
        for (int i2 = 0; i2 < jSONArray.length(); i2++) {
            try {
                Tag tag = new Tag(jSONArray.getJSONObject(i2));
                if (!tag.archived && Constants.PLATFORM_ANDROID.equalsIgnoreCase(tag.platform) && !TextUtils.isEmpty(tag.attrs.domain)) {
                    onReceiveTag(tag);
                }
            } catch (JSONException e3) {
                e3.printStackTrace();
            }
        }
    }

    void onReceiveTag(Tag tag) {
        String str;
        List<String> asList;
        boolean z;
        ViewAttrs viewAttrs = tag.filter;
        if (viewAttrs != null && (str = viewAttrs.xpath) != null && str.contains(",")) {
            String[] split = tag.filter.xpath.split(",");
            ArrayList arrayList = new ArrayList();
            for (String str2 : split) {
                if (str2.length() != 0 && str2.charAt(0) != '*' && str2.contains(Marker.ANY_MARKER)) {
                    arrayList.add(str2);
                }
            }
            if (!arrayList.isEmpty()) {
                asList = new ArrayList(arrayList);
                for (String str3 : split) {
                    Iterator it = arrayList.iterator();
                    while (true) {
                        if (it.hasNext()) {
                            if (Util.isIdentifyPatternServerXPath((String) it.next(), str3)) {
                                z = true;
                                break;
                            }
                        } else {
                            z = false;
                            break;
                        }
                    }
                    if (!z) {
                        asList.add(str3);
                    }
                }
            } else {
                asList = Arrays.asList(split);
            }
            for (String str4 : asList) {
                Tag copyWithoutScreenShot = tag.copyWithoutScreenShot();
                copyWithoutScreenShot.filter.xpath = str4;
                this.tags.add(copyWithoutScreenShot);
            }
            return;
        }
        this.tags.add(tag);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void run() {
        HttpEvent createCircleHttpEvent = HttpEvent.createCircleHttpEvent(NetworkConfig.getInstance().getTargetApiEventPoint(), null, true);
        createCircleHttpEvent.setCallBack(this);
        EventCenter.getInstance().post(createCircleHttpEvent);
    }
}
