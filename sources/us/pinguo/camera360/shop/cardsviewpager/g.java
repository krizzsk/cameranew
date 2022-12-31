package us.pinguo.camera360.shop.cardsviewpager;

import android.os.Bundle;
import android.os.Parcelable;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.viewpager.widget.PagerAdapter;
import com.growingio.android.sdk.autoburry.VdsAgent;
import java.text.MessageFormat;
import java.util.ArrayList;
/* compiled from: CycleFragmentStatePagerAdapterWrapper.java */
/* loaded from: classes3.dex */
public abstract class g extends PagerAdapter {
    private final FragmentManager a;
    private FragmentTransaction b = null;
    private ArrayList<Fragment.SavedState> c = new ArrayList<>();

    /* renamed from: d  reason: collision with root package name */
    private ArrayList<Fragment> f9577d = new ArrayList<>();

    /* renamed from: e  reason: collision with root package name */
    private Fragment f9578e = null;

    /* renamed from: f  reason: collision with root package name */
    private int f9579f = 0;

    /* renamed from: g  reason: collision with root package name */
    private int f9580g = 1;

    public g(FragmentManager fragmentManager) {
        this.a = fragmentManager;
    }

    private int c(int i2) {
        return i2 % b();
    }

    private boolean d(int i2) {
        us.pinguo.common.log.a.d("CycleFragmentStatePagerAdapterWrapper", "isAvoidDestroyOriginPosition pendingDestroyOriginPosition #" + i2 + "mCurrentPrimaryOriginPosition #" + this.f9579f, new Object[0]);
        if (f()) {
            if (i2 == this.f9579f) {
                return true;
            }
            int b = b() - 1;
            int i3 = this.f9579f;
            if (this.f9580g + i3 >= b) {
                for (int i4 = 1; i4 <= this.f9580g; i4++) {
                    i3++;
                    if (i3 > b) {
                        i3 = 0;
                    }
                    us.pinguo.common.log.a.d("CycleFragmentStatePagerAdapterWrapper", "isAvoidDestroyOriginPosition right #" + i3, new Object[0]);
                    if (i2 == i3) {
                        return true;
                    }
                }
            }
            int i5 = this.f9579f;
            if (i5 - this.f9580g <= 0) {
                for (int i6 = 1; i6 <= this.f9580g; i6++) {
                    i5--;
                    if (i5 < 0) {
                        i5 = b;
                    }
                    us.pinguo.common.log.a.d("CycleFragmentStatePagerAdapterWrapper", "isAvoidDestroyOriginPosition left #" + i5, new Object[0]);
                    if (i2 == i5) {
                        return true;
                    }
                }
            }
            return false;
        }
        return false;
    }

    private boolean f() {
        return b() > (this.f9580g * 2) + 1;
    }

    public abstract Fragment a(int i2);

    public abstract int b();

    @Override // androidx.viewpager.widget.PagerAdapter
    public void destroyItem(ViewGroup viewGroup, int i2, Object obj) {
        int c = c(i2);
        us.pinguo.common.log.a.d("CycleFragmentStatePagerAdapterWrapper", "destroyItem originPos item #" + c + "mCurrentPrimaryPosition #" + this.f9579f, new Object[0]);
        if (d(c)) {
            return;
        }
        Fragment fragment = (Fragment) obj;
        if (this.b == null) {
            this.b = this.a.beginTransaction();
        }
        us.pinguo.common.log.a.d("CycleFragmentStatePagerAdapterWrapper", "Removing item #" + c + "position #" + i2 + ": f=" + obj + " v=" + fragment.getView(), new Object[0]);
        while (this.c.size() <= c) {
            this.c.add(null);
        }
        this.c.set(c, fragment.isAdded() ? this.a.saveFragmentInstanceState(fragment) : null);
        this.f9577d.set(c, null);
        this.b.remove(fragment);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void e(int i2) {
        this.f9580g = i2;
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public void finishUpdate(ViewGroup viewGroup) {
        FragmentTransaction fragmentTransaction = this.b;
        if (fragmentTransaction != null) {
            fragmentTransaction.commitNowAllowingStateLoss();
            this.b = null;
        }
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public int getCount() {
        int b = b();
        int i2 = (10000 / b) * b;
        us.pinguo.common.log.a.d("CycleFragmentStatePagerAdapterWrapper", MessageFormat.format("mOriginCount={0},count={1}", Integer.valueOf(b), Integer.valueOf(i2)), new Object[0]);
        return i2;
    }

    public Fragment getItem(int i2) {
        if (i2 < 0 || i2 >= this.f9577d.size()) {
            return null;
        }
        return this.f9577d.get(i2);
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public Object instantiateItem(ViewGroup viewGroup, int i2) {
        Fragment.SavedState savedState;
        int c = c(i2);
        if (this.b == null) {
            this.b = this.a.beginTransaction();
        }
        Fragment a = a(c);
        us.pinguo.common.log.a.d("CycleFragmentStatePagerAdapterWrapper", "instantiateItem Adding item #" + c + ":position #" + i2 + ": f=" + a, new Object[0]);
        if (this.c.size() > c && (savedState = this.c.get(c)) != null) {
            a.setInitialSavedState(savedState);
        }
        while (this.f9577d.size() <= c) {
            this.f9577d.add(null);
        }
        a.setMenuVisibility(false);
        a.setUserVisibleHint(false);
        this.f9577d.set(c, a);
        FragmentTransaction fragmentTransaction = this.b;
        int id = viewGroup.getId();
        VdsAgent.onFragmentTransactionAdd(fragmentTransaction, id, a, fragmentTransaction.add(id, a));
        return a;
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public boolean isViewFromObject(View view, Object obj) {
        return ((Fragment) obj).getView() == view;
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public void restoreState(Parcelable parcelable, ClassLoader classLoader) {
        if (parcelable != null) {
            Bundle bundle = (Bundle) parcelable;
            bundle.setClassLoader(classLoader);
            Parcelable[] parcelableArray = bundle.getParcelableArray("states");
            this.c.clear();
            this.f9577d.clear();
            if (parcelableArray != null) {
                for (Parcelable parcelable2 : parcelableArray) {
                    this.c.add((Fragment.SavedState) parcelable2);
                }
            }
            for (String str : bundle.keySet()) {
                if (str.startsWith("f")) {
                    int parseInt = Integer.parseInt(str.substring(1));
                    Fragment fragment = this.a.getFragment(bundle, str);
                    if (fragment != null) {
                        while (this.f9577d.size() <= parseInt) {
                            this.f9577d.add(null);
                        }
                        fragment.setMenuVisibility(false);
                        this.f9577d.set(parseInt, fragment);
                    } else {
                        Log.w("CycleFragmentStatePagerAdapterWrapper", "Bad fragment at key " + str);
                    }
                }
            }
        }
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public Parcelable saveState() {
        Bundle bundle;
        if (this.c.size() > 0) {
            bundle = new Bundle();
            Fragment.SavedState[] savedStateArr = new Fragment.SavedState[this.c.size()];
            this.c.toArray(savedStateArr);
            bundle.putParcelableArray("states", savedStateArr);
        } else {
            bundle = null;
        }
        for (int i2 = 0; i2 < this.f9577d.size(); i2++) {
            Fragment fragment = this.f9577d.get(i2);
            if (fragment != null && fragment.isAdded()) {
                if (bundle == null) {
                    bundle = new Bundle();
                }
                this.a.putFragment(bundle, "f" + i2, fragment);
            }
        }
        return bundle;
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public void setPrimaryItem(ViewGroup viewGroup, int i2, Object obj) {
        int c = c(i2);
        us.pinguo.common.log.a.d("CycleFragmentStatePagerAdapterWrapper", "setPrimaryItem originPos item #" + c + "position #" + i2, new Object[0]);
        this.f9579f = c;
        Fragment fragment = (Fragment) obj;
        Fragment fragment2 = this.f9578e;
        if (fragment != fragment2) {
            if (fragment2 != null) {
                fragment2.setMenuVisibility(false);
                this.f9578e.setUserVisibleHint(false);
            }
            if (fragment != null) {
                fragment.setMenuVisibility(true);
                fragment.setUserVisibleHint(true);
            }
            this.f9578e = fragment;
        }
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public void startUpdate(ViewGroup viewGroup) {
        if (viewGroup.getId() != -1) {
            return;
        }
        throw new IllegalStateException("ViewPager with adapter " + this + " requires a view id");
    }
}
