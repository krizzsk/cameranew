package com.pinguo.camera360.camera.businessPrefSetting;

import android.content.res.Resources;
import com.pinguo.camera360.k.a.a.a.c;
import java.util.HashMap;
import java.util.Map;
import us.pinguo.foundation.h;
import us.pinguo.librouter.application.BaseApplication;
import vStudio.Android.Camera360.R;
/* compiled from: CameraBusinessPreferenceGroup.java */
/* loaded from: classes3.dex */
public final class a {
    private static final Map<String, h> a = new HashMap();

    public static h a(String str) {
        h hVar = a.get(str);
        if (hVar == null) {
            return null;
        }
        return hVar;
    }

    private static void b() {
        Resources resources = BaseApplication.d().getResources();
        c cVar = new c("pref_camera_back_save_key", resources.getString(R.string.pref_camera_saveorg_title));
        String string = resources.getString(R.string.pref_switcher_default_on);
        String[] stringArray = resources.getStringArray(R.array.switcher_entriyvalues);
        String[] stringArray2 = resources.getStringArray(R.array.switcher_entries);
        cVar.k(new String[]{string});
        cVar.m(stringArray);
        cVar.l(stringArray2);
        a.put("pref_camera_back_save_key", cVar);
    }

    private static void c() {
        Resources resources = BaseApplication.d().getResources();
        c cVar = new c("pref_camera_recordlocation_key", resources.getString(R.string.pref_camera_recordlocation_title));
        String string = resources.getString(R.string.pref_switcher_default_off);
        String[] stringArray = resources.getStringArray(R.array.switcher_entriyvalues);
        String[] stringArray2 = resources.getStringArray(R.array.switcher_entries);
        cVar.k(new String[]{string});
        cVar.m(stringArray);
        cVar.l(stringArray2);
        a.put("pref_camera_recordlocation_key", cVar);
    }

    private static void d() {
        Resources resources = BaseApplication.d().getResources();
        h hVar = new h("pref_camera_jpegquality_key", resources.getString(R.string.pref_camera_jpegquality_title));
        String[] stringArray = resources.getStringArray(R.array.pref_camera_jpegquality_entryvalues);
        String[] stringArray2 = resources.getStringArray(R.array.pref_camera_jpegquality_entries);
        hVar.j("90");
        hVar.m(stringArray);
        hVar.l(stringArray2);
        a.put("pref_camera_jpegquality_key", hVar);
    }

    private static void e() {
        Resources resources = BaseApplication.d().getResources();
        h hVar = new h("key_camera_picture_resolution_ratio", resources.getString(R.string.pref_picture_resolutionratio_title));
        String string = resources.getString(R.string.pref_picture_resolutionratio_default);
        String[] stringArray = resources.getStringArray(R.array.pref_pic_resolutionratio_entryvalues);
        String[] stringArray2 = resources.getStringArray(R.array.pref_pic_resolutionratio_entry);
        hVar.m(stringArray);
        hVar.l(stringArray2);
        hVar.j(string);
        a.put("key_camera_picture_resolution_ratio", hVar);
    }

    public static void f() {
        d();
        h();
        b();
        g();
        c();
        e();
    }

    private static void g() {
        Resources resources = BaseApplication.d().getResources();
        c cVar = new c("pref_camera_saveorg_key", resources.getString(R.string.pref_camera_saveorg_title));
        String string = resources.getString(R.string.pref_switcher_default_off);
        String[] stringArray = resources.getStringArray(R.array.switcher_entriyvalues);
        String[] stringArray2 = resources.getStringArray(R.array.switcher_entries);
        cVar.k(new String[]{string});
        cVar.m(stringArray);
        cVar.l(stringArray2);
        a.put("pref_camera_saveorg_key", cVar);
    }

    private static void h() {
        Resources resources = BaseApplication.d().getResources();
        h hVar = new h("pref_camera_save_type_key", resources.getString(R.string.pref_camera_save_type_title));
        String string = resources.getString(R.string.pref_camera_save_type_default);
        String[] stringArray = resources.getStringArray(R.array.pref_camera_save_type_entryvalues);
        String[] stringArray2 = resources.getStringArray(R.array.pref_camera_save_type_entries);
        hVar.j(string);
        hVar.m(stringArray);
        hVar.l(stringArray2);
        a.put("pref_camera_save_type_key", hVar);
    }
}
