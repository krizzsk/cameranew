package us.pinguo.camera360.shop.data.install;

import us.pinguo.foundation.utils.AsyncTask;
/* compiled from: BaseUninstallTask.java */
/* loaded from: classes3.dex */
public abstract class g extends AsyncTask<String, Integer, Integer> {
    private final us.pinguo.camera360.shop.data.h a;
    private final w b;

    public g(us.pinguo.camera360.shop.data.h hVar, w wVar) {
        this.a = hVar;
        this.b = wVar;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // us.pinguo.foundation.utils.AsyncTask
    /* renamed from: a */
    public Integer doInBackground(String... strArr) {
        return Integer.valueOf(d(this.a));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // us.pinguo.foundation.utils.AsyncTask
    /* renamed from: b */
    public void onPostExecute(Integer num) {
        super.onPostExecute(num);
        this.b.a(num.intValue());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // us.pinguo.foundation.utils.AsyncTask
    /* renamed from: c */
    public void onProgressUpdate(Integer... numArr) {
        super.onProgressUpdate(numArr);
    }

    public abstract int d(us.pinguo.camera360.shop.data.h hVar);
}
