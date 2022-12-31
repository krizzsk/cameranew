package us.pinguo.camera360.shop.cardsviewpager;

import android.os.Bundle;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import java.util.ArrayList;
import java.util.List;
import us.pinguo.camera360.shop.data.show.ShowScene;
/* compiled from: StoreCardFragmentAdapter.java */
/* loaded from: classes3.dex */
public class i extends g {

    /* renamed from: h  reason: collision with root package name */
    private List<ShowScene> f9581h;

    public i(FragmentManager fragmentManager) {
        super(fragmentManager);
        this.f9581h = new ArrayList();
    }

    @Override // us.pinguo.camera360.shop.cardsviewpager.g
    public Fragment a(int i2) {
        Fragment storeCardFragment;
        ShowScene showScene = this.f9581h.get(i2);
        if (showScene.getVip() != 0) {
            storeCardFragment = new StoreVipFragment();
        } else {
            storeCardFragment = new StoreCardFragment();
        }
        Bundle bundle = new Bundle();
        bundle.putSerializable("store_show", showScene);
        bundle.putInt("show_pos", i2);
        storeCardFragment.setArguments(bundle);
        return storeCardFragment;
    }

    @Override // us.pinguo.camera360.shop.cardsviewpager.g
    public int b() {
        return this.f9581h.size();
    }

    public ShowScene g(int i2) {
        if (i2 < 0 || i2 >= this.f9581h.size()) {
            return null;
        }
        return this.f9581h.get(i2);
    }

    public void h(List<ShowScene> list) {
        this.f9581h.clear();
        this.f9581h.addAll(list);
    }
}
