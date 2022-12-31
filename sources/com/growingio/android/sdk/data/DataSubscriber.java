package com.growingio.android.sdk.data;

import android.content.Context;
import android.util.Pair;
import com.facebook.common.callercontext.ContextChain;
import com.growingio.android.sdk.base.event.DBInitDiagnose;
import com.growingio.android.sdk.base.event.HttpCallBack;
import com.growingio.android.sdk.base.event.HttpEvent;
import com.growingio.android.sdk.base.event.OnCloseBufferEvent;
import com.growingio.android.sdk.collection.Constants;
import com.growingio.android.sdk.collection.CoreAppState;
import com.growingio.android.sdk.collection.DeviceUUIDFactory;
import com.growingio.android.sdk.collection.GConfig;
import com.growingio.android.sdk.data.db.MessageUploader;
import com.growingio.android.sdk.data.net.HttpService;
import com.growingio.android.sdk.models.ActionEvent;
import com.growingio.android.sdk.models.ActionStruct;
import com.growingio.android.sdk.models.VPAEvent;
import com.growingio.android.sdk.models.ViewAttrs;
import com.growingio.android.sdk.models.WebEvent;
import com.growingio.android.sdk.utils.GJSONStringer;
import com.growingio.android.sdk.utils.LogUtil;
import com.growingio.android.sdk.utils.Util;
import com.growingio.cp_annotation.Subscribe;
import com.growingio.eventcenter.bus.SubscriberMethod;
import com.growingio.eventcenter.bus.ThreadMode;
import com.growingio.eventcenter.bus.meta.Subscriber;
import java.util.ArrayList;
import java.util.HashMap;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class DataSubscriber implements Subscriber {
    private GConfig config;
    private Context context;
    private CoreAppState coreAppState;
    private MessageUploader mMessageUploader;
    private final String TAG = "GIO.DataSubscriber";
    private GJSONStringer jsonStringer = new GJSONStringer();

    public DataSubscriber(Context context, GConfig gConfig, CoreAppState coreAppState, DeviceUUIDFactory deviceUUIDFactory, MessageUploader messageUploader) {
        this.context = context;
        this.config = gConfig;
        this.coreAppState = coreAppState;
        this.mMessageUploader = messageUploader;
    }

    private Pair<String, String> extractInstantEvent(VPAEvent vPAEvent) {
        HashMap<String, ArrayList<ViewAttrs>> instantFilters = this.config.getInstantFilters();
        ArrayList<ViewAttrs> arrayList = instantFilters.get(null);
        if (vPAEvent instanceof ActionEvent) {
            ArrayList<ViewAttrs> arrayList2 = instantFilters.get(vPAEvent.mPageName);
            if ((arrayList2 != null ? arrayList2.size() : 0) + (arrayList != null ? arrayList.size() : 0) == 0) {
                return new Pair<>(null, this.jsonStringer.convertToString(vPAEvent.toJson()));
            }
            ActionEvent actionEvent = (ActionEvent) vPAEvent;
            ActionEvent copyWithoutElements = actionEvent.copyWithoutElements();
            ActionEvent copyWithoutElements2 = actionEvent.copyWithoutElements();
            for (ActionStruct actionStruct : actionEvent.elems) {
                if ((arrayList != null && Util.isInstant(actionStruct, arrayList)) || (arrayList2 != null && Util.isInstant(actionStruct, arrayList2))) {
                    copyWithoutElements.elems.add(actionStruct);
                } else {
                    copyWithoutElements2.elems.add(actionStruct);
                }
            }
            return new Pair<>(copyWithoutElements.size() > 0 ? this.jsonStringer.convertToString(copyWithoutElements.toJson()) : null, copyWithoutElements2.size() > 0 ? this.jsonStringer.convertToString(copyWithoutElements2.toJson()) : null);
        }
        if (vPAEvent instanceof WebEvent) {
            JSONObject json = ((WebEvent) vPAEvent).toJson();
            try {
                String string = json.getString("d");
                ArrayList<ViewAttrs> arrayList3 = instantFilters.get(json.getString(ContextChain.TAG_PRODUCT));
                ArrayList<ViewAttrs> arrayList4 = instantFilters.get(vPAEvent.mPageName + Constants.WEB_PART_SEPARATOR + '*');
                if ((arrayList3 != null ? arrayList3.size() : 0) + (arrayList != null ? arrayList.size() : 0) + (arrayList4 != null ? arrayList4.size() : 0) == 0) {
                    return new Pair<>(null, this.jsonStringer.convertToString(vPAEvent.toJson()));
                }
                JSONArray jSONArray = json.getJSONArray("e");
                JSONArray jSONArray2 = new JSONArray();
                JSONArray jSONArray3 = new JSONArray();
                int length = jSONArray.length();
                while (r5 < length) {
                    JSONObject jSONObject = jSONArray.getJSONObject(r5);
                    if ((arrayList != null && Util.isInstant(jSONObject, arrayList, string)) || ((arrayList4 != null && Util.isInstant(jSONObject, arrayList4, string)) || (arrayList3 != null && Util.isInstant(jSONObject, arrayList3, string)))) {
                        jSONArray2.put(jSONObject);
                    } else {
                        jSONArray3.put(jSONObject);
                    }
                    r5++;
                }
                return new Pair<>(jSONArray2.length() > 0 ? this.jsonStringer.convertToString(json.put("e", jSONArray2)) : null, jSONArray3.length() > 0 ? this.jsonStringer.convertToString(json.put("e", jSONArray3)) : null);
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
        }
        return new Pair<>(null, null);
    }

    private void patchEsid(VPAEvent vPAEvent, JSONObject jSONObject) {
        int size = vPAEvent.size();
        try {
            if (vPAEvent.getType().equals(ActionEvent.IMP_TYPE_NAME)) {
                return;
            }
            Pair<Integer, Integer> andAddEsid = this.config.getAndAddEsid(vPAEvent.getType(), size);
            if (vPAEvent instanceof ActionEvent) {
                JSONArray jSONArray = jSONObject.getJSONArray("e");
                int length = jSONArray.length();
                for (int i2 = 0; i2 < length; i2++) {
                    JSONObject jSONObject2 = jSONArray.getJSONObject(i2);
                    jSONObject2.put(VPAEvent.GLOBAL_EVENT_SEQUENCE_ID, ((Integer) andAddEsid.first).intValue() + i2);
                    jSONObject2.put(VPAEvent.EACH_TYPE_EVENT_SEQUENCE_ID, ((Integer) andAddEsid.second).intValue() + i2);
                }
                return;
            }
            jSONObject.put(VPAEvent.GLOBAL_EVENT_SEQUENCE_ID, andAddEsid.first);
            jSONObject.put(VPAEvent.EACH_TYPE_EVENT_SEQUENCE_ID, andAddEsid.second);
        } catch (JSONException e2) {
            LogUtil.d("GIO.DataSubscriber", e2);
        }
    }

    /* JADX WARN: Can't wrap try/catch for region: R(20:6|7|(4:12|13|14|(9:22|(1:24)|(1:30)|31|(4:56|57|58|59)(5:35|(3:37|(1:39)(1:41)|40)|42|(1:46)|47)|48|(1:52)|53|55)(1:20))|63|13|14|(1:16)|22|(0)|(3:26|28|30)|31|(1:33)|56|57|58|59|48|(2:50|52)|53|55) */
    /* JADX WARN: Code restructure failed: missing block: B:52:0x00b4, code lost:
        r7 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:53:0x00b5, code lost:
        r7.printStackTrace();
     */
    /* JADX WARN: Removed duplicated region for block: B:25:0x004b A[Catch: all -> 0x00f6, TryCatch #0 {all -> 0x00f6, blocks: (B:8:0x0010, B:10:0x0014, B:15:0x0021, B:18:0x0027, B:20:0x003c, B:23:0x0045, B:25:0x004b, B:27:0x005a, B:29:0x0062, B:32:0x006b, B:34:0x0070, B:36:0x0078, B:38:0x0080, B:42:0x008b, B:43:0x0093, B:45:0x0097, B:47:0x009f, B:55:0x00c5, B:57:0x00d4, B:59:0x00da, B:60:0x00ec, B:49:0x00a8, B:50:0x00b0, B:54:0x00b8, B:53:0x00b5), top: B:65:0x0010, inners: #1 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private void saveMessage(com.growingio.android.sdk.models.VPAEvent r10) {
        /*
            Method dump skipped, instructions count: 268
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.growingio.android.sdk.data.DataSubscriber.saveMessage(com.growingio.android.sdk.models.VPAEvent):void");
    }

    @Override // com.growingio.eventcenter.bus.meta.Subscriber
    public void do$Action(String str, Object obj) {
        if (str.equals("#onDBEvent(com.growingio.android.sdk.base.event.DBInitDiagnose")) {
            onDBEvent((DBInitDiagnose) obj);
        } else if (str.equals("#onGIOEvent(com.growingio.android.sdk.models.VPAEvent")) {
            onGIOEvent((VPAEvent) obj);
        } else if (str.equals("#onCloseBuffer(com.growingio.android.sdk.base.event.OnCloseBufferEvent")) {
            onCloseBuffer((OnCloseBufferEvent) obj);
        } else if (str.equals("#onHttpEvent(com.growingio.android.sdk.base.event.HttpEvent")) {
            onHttpEvent((HttpEvent) obj);
        } else {
            System.out.println("No such method to delegate");
        }
    }

    @Override // com.growingio.eventcenter.bus.meta.Subscriber
    public SubscriberMethod[] get$SubscriberMethods() {
        ThreadMode threadMode = ThreadMode.BACKGROUND;
        return new SubscriberMethod[]{new SubscriberMethod("onDBEvent", DBInitDiagnose.class, "#onDBEvent(com.growingio.android.sdk.base.event.DBInitDiagnose", threadMode, 0, false), new SubscriberMethod("onGIOEvent", VPAEvent.class, "#onGIOEvent(com.growingio.android.sdk.models.VPAEvent", threadMode, 0, false), new SubscriberMethod("onCloseBuffer", OnCloseBufferEvent.class, "#onCloseBuffer(com.growingio.android.sdk.base.event.OnCloseBufferEvent", threadMode, 0, false), new SubscriberMethod("onHttpEvent", HttpEvent.class, "#onHttpEvent(com.growingio.android.sdk.base.event.HttpEvent", threadMode, 0, false)};
    }

    @Subscribe(threadMode = ThreadMode.BACKGROUND)
    public synchronized void onCloseBuffer(OnCloseBufferEvent onCloseBufferEvent) {
        LogUtil.d("GIO.DataSubscriber", "receive close buffer event, and close buffer");
        this.jsonStringer.closeBuffer();
    }

    @Subscribe(threadMode = ThreadMode.BACKGROUND)
    public synchronized void onDBEvent(DBInitDiagnose dBInitDiagnose) {
        DiagnoseLog.initialize(this.context);
    }

    @Subscribe(threadMode = ThreadMode.BACKGROUND)
    public synchronized void onGIOEvent(VPAEvent vPAEvent) {
        saveMessage(vPAEvent);
    }

    @Subscribe(threadMode = ThreadMode.BACKGROUND)
    public void onHttpEvent(HttpEvent httpEvent) {
        HttpService build = new HttpService.Builder().body(httpEvent.getData()).headers(httpEvent.getHeaders()).ifModifiedSince(httpEvent.getmSinceModified()).uri(httpEvent.getUrl()).requestMethod(httpEvent.getRequestMethod() == HttpEvent.REQUEST_METHOD.POST ? "POST" : "GET").build();
        Pair<Integer, byte[]> performRequest = build.performRequest();
        HttpCallBack callBack = httpEvent.getCallBack();
        if (callBack != null) {
            callBack.afterRequest((Integer) performRequest.first, (byte[]) performRequest.second, build.getLastModified(), build.getResponseHeaders());
        }
    }
}
