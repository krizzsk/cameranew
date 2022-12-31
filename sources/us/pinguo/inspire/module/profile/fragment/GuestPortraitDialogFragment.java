package us.pinguo.inspire.module.profile.fragment;

import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.os.Handler;
import android.os.Parcelable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.annotation.Nullable;
import androidx.core.view.ViewCompat;
import androidx.fragment.app.FragmentManager;
import java.util.ArrayList;
import rx.Subscription;
import rx.subscriptions.CompositeSubscription;
import us.pinguo.inspire.widget.AttentionButton;
import us.pinguo.inspire.widget.photopager.FullScreenPhoto;
import us.pinguo.inspire.widget.photopager.PictureViewPagerDialogFragment;
import us.pinguo.inspire.widget.photopager.a;
import us.pinguo.user.R;
import us.pinguo.user.model.ProfileAuthorInfo;
import us.pinguo.user.s0;
import us.pinguo.user.ui.PGLoginMainActivity;
/* loaded from: classes9.dex */
public class GuestPortraitDialogFragment extends PictureViewPagerDialogFragment implements us.pinguo.foundation.base.c, a.f {
    private AttentionButton mAttentionButton;
    private Handler mHandler = new Handler();
    private ProfileAuthorInfo mProfileAuthorInfo;
    private CompositeSubscription mSubscriptions;

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void a0(float f2, ImageView imageView) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: b0 */
    public /* synthetic */ boolean c0() {
        if (s0.getInstance().e()) {
            return false;
        }
        us.pinguo.foundation.statistics.h.a.g("", us.pinguo.inspire.cell.recycler.a.PAGE_TYPE_OTHER, "show");
        Intent intent = new Intent();
        intent.setClass(getActivity(), PGLoginMainActivity.class);
        getActivity().startActivity(intent);
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: d0 */
    public /* synthetic */ void e0() {
        ProfileAuthorInfo profileAuthorInfo = this.mProfileAuthorInfo;
        if (profileAuthorInfo != null) {
            this.mAttentionButton.j(profileAuthorInfo, false, profileAuthorInfo.userId, getResources().getColor(R.color.attention_bg_color), this, true);
        }
    }

    private Bundle getSafeArguments() {
        return getArguments() == null ? new Bundle() : getArguments();
    }

    public static void showFullScreenPics(FragmentManager fragmentManager, Bitmap bitmap, ProfileAuthorInfo profileAuthorInfo, FullScreenPhoto fullScreenPhoto, PictureViewPagerDialogFragment.c cVar) {
        PictureViewPagerDialogFragment.sBitmaps = new Bitmap[]{bitmap};
        GuestPortraitDialogFragment guestPortraitDialogFragment = new GuestPortraitDialogFragment();
        Bundle bundle = new Bundle();
        bundle.putInt(PictureViewPagerDialogFragment.EXTRA_CURRENT_ITEM, 0);
        bundle.putParcelable("author_info", profileAuthorInfo);
        ArrayList<? extends Parcelable> arrayList = new ArrayList<>();
        arrayList.add(fullScreenPhoto);
        bundle.putParcelableArrayList(PictureViewPagerDialogFragment.EXTRA_IMAGE_URLS, arrayList);
        guestPortraitDialogFragment.setGetRect(cVar);
        guestPortraitDialogFragment.setArguments(bundle);
        guestPortraitDialogFragment.show(fragmentManager, GuestPortraitDialogFragment.class.getName());
    }

    @Override // us.pinguo.foundation.base.c
    public void addSubscription(Subscription subscription) {
        if (this.mSubscriptions == null) {
            this.mSubscriptions = new CompositeSubscription();
        }
        this.mSubscriptions.add(subscription);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // us.pinguo.inspire.widget.photopager.PictureViewPagerDialogFragment
    public void init(View view) {
        super.init(view);
        setAnimFirstUpdateListener(b.a);
    }

    @Override // us.pinguo.inspire.widget.photopager.a.f
    public void onAnimUpdate(float f2, ImageView imageView) {
        Bitmap a = ((us.pinguo.foundation.t.a.g) imageView.getDrawable()).a();
        if (a != null) {
            imageView.setImageDrawable(new us.pinguo.foundation.t.a.g(a, (int) ((1.0f - f2) * imageView.getWidth() * 0.5d), 0));
        }
    }

    @Override // us.pinguo.inspire.widget.photopager.PictureViewPagerDialogFragment, androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(vStudio.Android.Camera360.R.layout.fragment_dialog_guest_portrait, (ViewGroup) null);
        this.mLayout = inflate;
        return inflate;
    }

    @Override // us.pinguo.inspire.widget.photopager.PictureViewPagerDialogFragment, androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onDestroyView() {
        super.onDestroyView();
        unsubscribeAll();
    }

    @Override // androidx.fragment.app.DialogFragment, android.content.DialogInterface.OnDismissListener
    public void onDismiss(DialogInterface dialogInterface) {
        super.onDismiss(dialogInterface);
        us.pinguo.foundation.statistics.g.e("guest_big_portrait");
    }

    @Override // us.pinguo.inspire.widget.photopager.PictureViewPagerDialogFragment, androidx.fragment.app.Fragment
    public void onViewCreated(View view, @Nullable Bundle bundle) {
        super.onViewCreated(view, bundle);
        setAnimFirstUpdateListener(this);
        AttentionButton attentionButton = (AttentionButton) view.findViewById(vStudio.Android.Camera360.R.id.ab_attention_guest_portrait_dialog);
        this.mAttentionButton = attentionButton;
        attentionButton.setAttentionStyle(new AttentionButton.h() { // from class: us.pinguo.inspire.module.profile.fragment.GuestPortraitDialogFragment.1
            @Override // us.pinguo.inspire.widget.AttentionButton.h
            public void animingStyle(AttentionButton attentionButton2) {
                attentionButton2.setBackgroundResource(vStudio.Android.Camera360.R.drawable.shape_border_white);
                attentionButton2.setTextColor(ViewCompat.MEASURED_SIZE_MASK);
            }

            @Override // us.pinguo.inspire.widget.AttentionButton.h
            public void followedStyle(AttentionButton attentionButton2) {
                attentionButton2.setBackgroundResource(vStudio.Android.Camera360.R.drawable.shape_border_white);
                attentionButton2.setTextColor(-1811939329);
                attentionButton2.setVisibility(8);
            }

            @Override // us.pinguo.inspire.widget.AttentionButton.h
            public void friendStyle(AttentionButton attentionButton2) {
                followedStyle(attentionButton2);
            }

            @Override // us.pinguo.inspire.widget.AttentionButton.h
            public void unFollowedStyle(AttentionButton attentionButton2) {
                attentionButton2.setBackgroundResource(vStudio.Android.Camera360.R.drawable.shape_border_white);
                attentionButton2.setTextColor(-1811939329);
                attentionButton2.setVisibility(0);
            }
        });
        this.mAttentionButton.setClickInteceptor(new AttentionButton.i() { // from class: us.pinguo.inspire.module.profile.fragment.a
            @Override // us.pinguo.inspire.widget.AttentionButton.i
            public final boolean a() {
                return GuestPortraitDialogFragment.this.c0();
            }
        });
        this.mProfileAuthorInfo = (ProfileAuthorInfo) getSafeArguments().getParcelable("author_info");
        this.mHandler.postDelayed(new Runnable() { // from class: us.pinguo.inspire.module.profile.fragment.c
            @Override // java.lang.Runnable
            public final void run() {
                GuestPortraitDialogFragment.this.e0();
            }
        }, 300L);
        us.pinguo.foundation.statistics.g.f("guest_big_portrait");
    }

    public void unsubscribeAll() {
        CompositeSubscription compositeSubscription = this.mSubscriptions;
        if (compositeSubscription != null) {
            compositeSubscription.unsubscribe();
            this.mSubscriptions = null;
        }
    }
}
