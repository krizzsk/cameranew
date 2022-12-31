package com.growingio.android.sdk.collection;

import android.view.View;
import androidx.annotation.FloatRange;
import com.growingio.android.sdk.utils.LogUtil;
import java.lang.ref.WeakReference;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class ImpressionMark {
    private long delayTime;
    private final String eventId;
    private String globalId;
    private Number num;
    private JSONObject variable;
    private final WeakReference<View> view;
    private boolean collectV = true;
    private float visibleScale = 0.0f;

    public ImpressionMark(View view, String str) {
        this.view = new WeakReference<>(view);
        this.eventId = str;
    }

    public long getDelayTimeMills() {
        return this.delayTime;
    }

    public String getEventId() {
        return this.eventId;
    }

    public String getGlobalId() {
        return this.globalId;
    }

    public Number getNum() {
        return this.num;
    }

    public JSONObject getVariable() {
        return this.variable;
    }

    public View getView() {
        return this.view.get();
    }

    public float getVisibleScale() {
        return this.visibleScale;
    }

    public boolean isCollectContent() {
        return this.collectV;
    }

    public ImpressionMark setCollectContent(boolean z) {
        this.collectV = z;
        return this;
    }

    public ImpressionMark setDelayTimeMills(long j2) {
        this.delayTime = j2;
        return this;
    }

    public ImpressionMark setGlobalId(String str) {
        this.globalId = str;
        return this;
    }

    @Deprecated
    public ImpressionMark setNum(Number number) {
        this.num = number;
        return this;
    }

    public ImpressionMark setVariable(JSONObject jSONObject) {
        this.variable = jSONObject;
        return this;
    }

    public ImpressionMark setVisibleScale(@FloatRange(from = 0.0d, to = 1.0d) float f2) {
        if (f2 >= 0.0f && f2 <= 1.0f) {
            this.visibleScale = f2;
            return this;
        }
        String str = "visibleScale 区间为[0, 1], current visibleScale is " + f2;
        if (!GConfig.DEBUG) {
            LogUtil.e("GIO.ImpressionMark", str);
            return this;
        }
        throw new IllegalArgumentException(str);
    }
}
