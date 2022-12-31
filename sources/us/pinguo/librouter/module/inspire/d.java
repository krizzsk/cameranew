package us.pinguo.librouter.module.inspire;

import android.app.Activity;
import android.os.Parcelable;
import rx.Observable;
import us.pinguo.foundation.domain.OptionsSettingEntry;
/* compiled from: InspireInterface.java */
/* loaded from: classes5.dex */
public interface d {
    void a(Activity activity, int i2, int i3, String str);

    String b();

    String c(String str);

    Observable<OptionsSettingEntry> d(String str);

    Object e(String str, boolean z);

    f f();

    boolean g(Object obj);

    void h(Activity activity, Parcelable parcelable, String str, String str2, String str3, boolean z, int i2);

    Observable<OptionsSettingEntry> i(String str, OptionsSettingEntry optionsSettingEntry);
}
