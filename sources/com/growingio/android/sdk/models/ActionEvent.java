package com.growingio.android.sdk.models;

import com.growingio.android.sdk.utils.LogUtil;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class ActionEvent extends VPAEvent {
    public static final String CHANGE_TYPE_NAME = "chng";
    public static final String CLICK_TYPE_NAME = "clck";
    public static final String FULL_CLICK_TYPE_NAME = "click";
    public static final String IMP_TYPE_NAME = "imp";
    private static String TAG = "GIO.ActionEvent";
    public List<ActionStruct> elems;
    private boolean instant;
    private long ptm;
    private String type;

    private ActionEvent(String str) {
        super(System.currentTimeMillis());
        this.elems = new ArrayList();
        this.type = str;
    }

    public static ActionEvent makeChangeEvent() {
        ActionEvent actionEvent = new ActionEvent(CHANGE_TYPE_NAME);
        actionEvent.instant = true;
        return actionEvent;
    }

    public static ActionEvent makeClickEvent() {
        ActionEvent actionEvent = new ActionEvent(CLICK_TYPE_NAME);
        actionEvent.instant = true;
        return actionEvent;
    }

    public static ActionEvent makeImpEvent() {
        ActionEvent actionEvent = new ActionEvent(IMP_TYPE_NAME);
        actionEvent.instant = false;
        return actionEvent;
    }

    public ActionEvent copyWithoutElements() {
        ActionEvent actionEvent = new ActionEvent(this.type);
        actionEvent.ptm = this.ptm;
        actionEvent.instant = this.instant;
        actionEvent.time = this.time;
        actionEvent.mPageName = this.mPageName;
        return actionEvent;
    }

    @Override // com.growingio.android.sdk.models.VPAEvent
    public String getFullType() {
        return this.type.equals(CLICK_TYPE_NAME) ? "click" : this.type;
    }

    @Override // com.growingio.android.sdk.models.VPAEvent
    public String getType() {
        return this.type;
    }

    public boolean isInstant() {
        return this.instant;
    }

    public void setPageTime(long j2) {
        this.ptm = j2;
    }

    @Override // com.growingio.android.sdk.models.VPAEvent
    public int size() {
        return this.elems.size();
    }

    @Override // com.growingio.android.sdk.models.VPAEvent
    public JSONObject toJson() {
        if (this.elems.size() > 0) {
            JSONObject commonProperty = getCommonProperty();
            try {
                JSONArray jSONArray = new JSONArray();
                for (ActionStruct actionStruct : this.elems) {
                    jSONArray.put(actionStruct.toJson());
                }
                commonProperty.put("ptm", this.ptm);
                commonProperty.put("e", jSONArray);
                return commonProperty;
            } catch (JSONException e2) {
                LogUtil.d(TAG, "generate common event property error", e2);
                return commonProperty;
            }
        }
        return null;
    }

    public String toString() {
        return this.type + " event with " + this.elems.size() + " elements ActionEvent@" + hashCode();
    }

    /* renamed from: clone */
    public ActionEvent m20clone() {
        ActionEvent actionEvent = new ActionEvent(this.type);
        actionEvent.instant = this.instant;
        actionEvent.ptm = this.ptm;
        actionEvent.time = this.time;
        actionEvent.mPageName = this.mPageName;
        ArrayList arrayList = new ArrayList();
        actionEvent.elems = arrayList;
        arrayList.addAll(this.elems);
        return actionEvent;
    }
}
