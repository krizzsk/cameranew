package us.pinguo.inspire.router;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import rx.Observable;
import us.pinguo.foundation.base.InspireContentActivity;
import us.pinguo.foundation.domain.OptionsSettingEntry;
import us.pinguo.inspire.Inspire;
import us.pinguo.inspire.module.profile.OptionSettingLoader;
import us.pinguo.inspire.module.publish.InspirePublishFragment;
import us.pinguo.librouter.module.inspire.d;
import us.pinguo.librouter.module.inspire.f;
import us.pinguo.push.PushPreference;
/* compiled from: InspireInterfaceImpl.java */
/* loaded from: classes9.dex */
public class a implements d {
    private f a;

    @Override // us.pinguo.librouter.module.inspire.d
    public void a(Activity activity, int i2, int i3, String str) {
        Intent intent = new Intent(activity, InspireContentActivity.class);
        intent.putExtra(InspireContentActivity.FRAGMENT_NAME, InspirePublishFragment.class.getName());
        intent.putExtra(InspirePublishFragment.PUBLISH_EXTRA_MEDIA_TYPE, i2);
        intent.putExtra(InspirePublishFragment.PUBLISH_EXTRA_ENTRANCE_TYPE, i3);
        intent.putExtra(InspirePublishFragment.PUBLISH_EXTRA_IMAGE_PATH, str);
        activity.startActivity(intent);
    }

    @Override // us.pinguo.librouter.module.inspire.d
    public String b() {
        return new PushPreference(Inspire.a()).d("clientId", "");
    }

    @Override // us.pinguo.librouter.module.inspire.d
    public String c(String str) {
        return us.pinguo.inspire.widget.j.b.j(str);
    }

    @Override // us.pinguo.librouter.module.inspire.d
    public Observable<OptionsSettingEntry> d(String str) {
        return OptionSettingLoader.fetchOptionConfig(str);
    }

    @Override // us.pinguo.librouter.module.inspire.d
    public Object e(String str, boolean z) {
        return new us.pinguo.inspire_proxy.c.a(str, z);
    }

    @Override // us.pinguo.librouter.module.inspire.d
    public f f() {
        if (this.a == null) {
            this.a = new c();
        }
        return this.a;
    }

    @Override // us.pinguo.librouter.module.inspire.d
    public boolean g(Object obj) {
        return ((obj instanceof us.pinguo.share.c.f) || (obj instanceof us.pinguo.inspire_proxy.c.a)) ? false : true;
    }

    @Override // us.pinguo.librouter.module.inspire.d
    public void h(Activity activity, Parcelable parcelable, String str, String str2, String str3, boolean z, int i2) {
        Intent intent = new Intent(activity, InspireContentActivity.class);
        intent.putExtra(InspireContentActivity.FRAGMENT_NAME, InspirePublishFragment.class.getName());
        Bundle bundle = new Bundle();
        bundle.putParcelable("task", parcelable);
        bundle.putString("key_participant_from", str);
        bundle.putString("key_exist_pic_url", str3);
        if (z) {
            bundle.putString("key_first_frame_path", str2);
        }
        intent.putExtras(bundle);
        activity.startActivityForResult(intent, i2);
    }

    @Override // us.pinguo.librouter.module.inspire.d
    public Observable<OptionsSettingEntry> i(String str, OptionsSettingEntry optionsSettingEntry) {
        return OptionSettingLoader.setOptionConfig(str, optionsSettingEntry);
    }
}
