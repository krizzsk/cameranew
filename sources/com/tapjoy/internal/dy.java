package com.tapjoy.internal;

import android.os.AsyncTask;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public abstract class dy extends AsyncTask {

    /* renamed from: d  reason: collision with root package name */
    a f7388d;

    /* renamed from: e  reason: collision with root package name */
    protected final b f7389e;

    /* loaded from: classes3.dex */
    public interface a {
        void a();
    }

    /* loaded from: classes3.dex */
    public interface b {
        JSONObject a();

        void a(JSONObject jSONObject);
    }

    public dy(b bVar) {
        this.f7389e = bVar;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.os.AsyncTask
    /* renamed from: a */
    public void onPostExecute(String str) {
        a aVar = this.f7388d;
        if (aVar != null) {
            aVar.a();
        }
    }
}
