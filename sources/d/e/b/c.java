package d.e.b;

import android.os.AsyncTask;
import android.util.Pair;
import java.util.ArrayList;
import us.pinguo.common.network.HttpRequest;
/* compiled from: EventsSender.java */
/* loaded from: classes2.dex */
public class c extends AsyncTask<Object, Void, Boolean> {
    private ArrayList a;
    private d b;

    public c(d dVar) {
        this.b = dVar;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.os.AsyncTask
    /* renamed from: a */
    public Boolean doInBackground(Object... objArr) {
        try {
            this.a = (ArrayList) objArr[2];
            boolean z = true;
            ArrayList arrayList = new ArrayList();
            arrayList.add(new Pair(HttpRequest.HEADER_CONTENT_TYPE, HttpRequest.CONTENT_TYPE_JSON));
            if (d.e.c.c.d((String) objArr[1], (String) objArr[0], arrayList).a != 200) {
                z = false;
            }
            return Boolean.valueOf(z);
        } catch (Exception unused) {
            return Boolean.FALSE;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.os.AsyncTask
    /* renamed from: b */
    public void onPostExecute(Boolean bool) {
        d dVar = this.b;
        if (dVar != null) {
            dVar.a(this.a, bool.booleanValue());
        }
    }
}
