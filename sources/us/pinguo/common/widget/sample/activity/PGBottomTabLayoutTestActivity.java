package us.pinguo.common.widget.sample.activity;

import android.os.Bundle;
import android.view.View;
import androidx.appcompat.app.AppCompatActivity;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.jvm.internal.s;
import us.pinguo.common.widget.R;
import us.pinguo.common.widget.tab.PGEditBottomTabLayout;
/* compiled from: PGBottomTabLayoutTestActivity.kt */
/* loaded from: classes4.dex */
public final class PGBottomTabLayoutTestActivity extends AppCompatActivity {
    public Map<Integer, View> a;

    public PGBottomTabLayoutTestActivity() {
        super(R.layout.activity_pg_bottom_tab_layout);
        this.a = new LinkedHashMap();
    }

    public View _$_findCachedViewById(int i2) {
        Map<Integer, View> map = this.a;
        View view = map.get(Integer.valueOf(i2));
        if (view == null) {
            View findViewById = findViewById(i2);
            if (findViewById == null) {
                return null;
            }
            map.put(Integer.valueOf(i2), findViewById);
            return findViewById;
        }
        return view;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        int i2 = R.id.tabEdit2;
        PGEditBottomTabLayout tabEdit2 = (PGEditBottomTabLayout) _$_findCachedViewById(i2);
        s.g(tabEdit2, "tabEdit2");
        PGEditBottomTabLayout.h(tabEdit2, new String[]{"测试Tab"}, false, null, 6, null);
        ((PGEditBottomTabLayout) _$_findCachedViewById(i2)).B();
        int i3 = R.id.tabEdit3;
        PGEditBottomTabLayout tabEdit3 = (PGEditBottomTabLayout) _$_findCachedViewById(i3);
        s.g(tabEdit3, "tabEdit3");
        PGEditBottomTabLayout.h(tabEdit3, new String[]{"测试Tab1", "测试Tab2"}, true, null, 4, null);
        ((PGEditBottomTabLayout) _$_findCachedViewById(i3)).B();
        int i4 = R.id.tabEdit4;
        PGEditBottomTabLayout tabEdit4 = (PGEditBottomTabLayout) _$_findCachedViewById(i4);
        s.g(tabEdit4, "tabEdit4");
        PGEditBottomTabLayout.h(tabEdit4, new String[]{"测试Tab1", "测试Tab2", "测试Tab3"}, true, null, 4, null);
        ((PGEditBottomTabLayout) _$_findCachedViewById(i4)).B();
        int i5 = R.id.tabEdit5;
        PGEditBottomTabLayout tabEdit5 = (PGEditBottomTabLayout) _$_findCachedViewById(i5);
        s.g(tabEdit5, "tabEdit5");
        PGEditBottomTabLayout.h(tabEdit5, new String[]{"测试Tab1", "测试Tab2", "测试Tab3", "测试Tab4"}, true, null, 4, null);
        ((PGEditBottomTabLayout) _$_findCachedViewById(i5)).B();
        int i6 = R.id.tabEdit6;
        PGEditBottomTabLayout tabEdit6 = (PGEditBottomTabLayout) _$_findCachedViewById(i6);
        s.g(tabEdit6, "tabEdit6");
        PGEditBottomTabLayout.h(tabEdit6, new String[]{"测试Tab1", "测试Tab2", "测试Tab3", "测试Tab4", "测试Tab5", "测试Tab6"}, true, null, 4, null);
        ((PGEditBottomTabLayout) _$_findCachedViewById(i6)).B();
    }
}
