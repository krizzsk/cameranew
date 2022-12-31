package us.pinguo.paylibcenter;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import java.util.ArrayList;
import us.pinguo.paylibcenter.PayHelp;
/* compiled from: PayGoogleCenterInterface.java */
/* loaded from: classes5.dex */
public interface h {
    String a(String str);

    boolean b(int i2, int i3, Intent intent);

    void c();

    PayHelp.SubsState d(String str);

    void e(Activity activity, String str, boolean z, int i2, PayCallback payCallback);

    void f();

    long g(String str);

    boolean h(Context context, ArrayList arrayList, ArrayList arrayList2, PayHelp.i iVar);

    void i(boolean z);
}
