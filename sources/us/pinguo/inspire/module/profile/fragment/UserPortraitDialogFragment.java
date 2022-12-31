package us.pinguo.inspire.module.profile.fragment;

import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.os.Handler;
import android.os.Parcelable;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.annotation.Nullable;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import com.nostra13.universalimageloader.core.ImageLoader;
import java.io.File;
import java.util.ArrayList;
import rx.Subscription;
import rx.functions.Action1;
import rx.subscriptions.CompositeSubscription;
import us.pinguo.androidsdk.pgedit.PGEditResultActivity2;
import us.pinguo.foundation.base.InspireRedirectActivity;
import us.pinguo.foundation.network.Fault;
import us.pinguo.foundation.utils.j0;
import us.pinguo.foundation.utils.w;
import us.pinguo.inspire.module.profile.UserInfoLoader;
import us.pinguo.inspire.module.publish.InspirePublishFragment;
import us.pinguo.inspire.widget.photopager.FullScreenPhoto;
import us.pinguo.inspire.widget.photopager.PictureViewPagerDialogFragment;
import us.pinguo.inspire.widget.photopager.TouchImageView;
import us.pinguo.inspire.widget.photopager.a;
import us.pinguo.user.CropActivity;
import us.pinguo.user.EditInfoActivity;
import us.pinguo.user.R;
import us.pinguo.user.User;
import us.pinguo.user.api.f0;
import us.pinguo.user.model.ProfileAuthorInfo;
import us.pinguo.user.u0;
import us.pinguo.user.util.n;
/* loaded from: classes9.dex */
public class UserPortraitDialogFragment extends PictureViewPagerDialogFragment implements us.pinguo.foundation.base.c, View.OnClickListener, a.f {
    private static final String KEY_PHOTO_PICK_MODE_VALUE = "photo_pick_mode_value";
    private TextView mChangeAvatarTv;
    private Handler mHandler = new Handler();
    private String mPhotoPath;
    private ProgressBar mProgressBar;
    private CompositeSubscription mSubscriptions;

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: c0 */
    public /* synthetic */ void d0(int i2, Intent intent) {
        String stringExtra;
        if (i2 != -1 || intent == null || (stringExtra = intent.getStringExtra(PGEditResultActivity2.PATH)) == null || !new File(stringExtra).exists()) {
            return;
        }
        final String str = InspirePublishFragment.FILE_HEADER + stringExtra;
        final String w0 = EditInfoActivity.w0(stringExtra);
        if (w0 == null) {
            return;
        }
        FragmentActivity activity = getActivity();
        if (activity != null) {
            n.a.d(activity, new Runnable() { // from class: us.pinguo.inspire.module.profile.fragment.d
                @Override // java.lang.Runnable
                public final void run() {
                    UserPortraitDialogFragment.this.b0(str, w0);
                }
            });
        }
        us.pinguo.common.log.a.m("zhouwei", "filePath:" + stringExtra, new Object[0]);
    }

    private void clearCache(String str) {
        ImageLoader.getInstance().m().remove(str);
        ImageLoader.getInstance().o().remove(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: e0 */
    public /* synthetic */ void f0(int i2, Intent intent) {
        String stringExtra;
        if (i2 != -1 || intent == null || (stringExtra = intent.getStringExtra("photo_path")) == null) {
            return;
        }
        this.mPhotoPath = stringExtra;
        us.pinguo.common.log.a.m("zhowuei", "photo path:" + this.mPhotoPath, new Object[0]);
        launchCropActivity((InspireRedirectActivity) getActivity(), this.mPhotoPath, 1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: g0 */
    public /* synthetic */ void h0() {
        this.mChangeAvatarTv.setVisibility(0);
    }

    private void hideProgress() {
        this.mProgressBar.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: i0 */
    public /* synthetic */ void j0(String str, String str2) {
        User.Info h2 = User.d().h();
        h2.avatar = str;
        User.v(h2);
        us.pinguo.foundation.r.d.a().b(new us.pinguo.user.event.a());
        clearCache(str2);
        updateAvatarView(str2);
        hideProgress();
        dismiss();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: k0 */
    public /* synthetic */ void l0(DialogInterface dialogInterface, int i2) {
        if (i2 == -1) {
            dialogInterface.dismiss();
            dismiss();
        }
    }

    private void launchGallery() {
        if (getActivity() != null) {
            Intent intent = new Intent();
            intent.setClassName(getActivity(), "com.pinguo.camera360.gallery.photopick.PhotoPickActivity");
            intent.putExtra("photo_pick_mode_value", 6);
            ((InspireRedirectActivity) getActivity()).startActivityForResult(intent, new us.pinguo.foundation.proxy.c() { // from class: us.pinguo.inspire.module.profile.fragment.g
                @Override // us.pinguo.foundation.proxy.c
                public final void onActivityResult(int i2, Intent intent2) {
                    UserPortraitDialogFragment.this.f0(i2, intent2);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: m0 */
    public /* synthetic */ void n0() {
        hideProgress();
        w.k(getActivity(), R.string.upload_risky_image, us.pinguo.ui.R.string.ok, -999, false, new DialogInterface.OnClickListener() { // from class: us.pinguo.inspire.module.profile.fragment.h
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i2) {
                UserPortraitDialogFragment.this.l0(dialogInterface, i2);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: o0 */
    public /* synthetic */ void p0() {
        hideProgress();
        dismiss();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: q0 */
    public /* synthetic */ void r0(final String str, final String str2) {
        ArrayList arrayList = new ArrayList();
        if (!TextUtils.isEmpty(str2)) {
            arrayList.add(str2);
        }
        n.a.o(u0.m, arrayList, new Runnable() { // from class: us.pinguo.inspire.module.profile.fragment.e
            @Override // java.lang.Runnable
            public final void run() {
                UserPortraitDialogFragment.this.j0(str2, str);
            }
        }, new Runnable() { // from class: us.pinguo.inspire.module.profile.fragment.i
            @Override // java.lang.Runnable
            public final void run() {
                UserPortraitDialogFragment.this.n0();
            }
        }, new Runnable() { // from class: us.pinguo.inspire.module.profile.fragment.l
            @Override // java.lang.Runnable
            public final void run() {
                UserPortraitDialogFragment.this.p0();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: s0 */
    public /* synthetic */ void t0(Throwable th) {
        us.pinguo.common.log.a.f(th);
        us.pinguo.foundation.e.e(th);
        showErrorMessage(th);
        hideProgress();
    }

    private void showErrorMessage(Throwable th) {
        if (th instanceof Fault) {
            Fault fault = (Fault) th;
            if (fault == null) {
                j0.c(us.pinguo.c360.i18n.R.string.network_error);
            } else {
                j0.d(f0.a(us.pinguo.foundation.e.b(), fault.getStatus()));
            }
        }
    }

    public static void showFullScreenPics(FragmentManager fragmentManager, Bitmap bitmap, ProfileAuthorInfo profileAuthorInfo, FullScreenPhoto fullScreenPhoto, PictureViewPagerDialogFragment.c cVar) {
        PictureViewPagerDialogFragment.sBitmaps = new Bitmap[]{bitmap};
        UserPortraitDialogFragment userPortraitDialogFragment = new UserPortraitDialogFragment();
        Bundle bundle = new Bundle();
        bundle.putInt(PictureViewPagerDialogFragment.EXTRA_CURRENT_ITEM, 0);
        bundle.putParcelable("author_info", profileAuthorInfo);
        ArrayList<? extends Parcelable> arrayList = new ArrayList<>();
        arrayList.add(fullScreenPhoto);
        bundle.putParcelableArrayList(PictureViewPagerDialogFragment.EXTRA_IMAGE_URLS, arrayList);
        userPortraitDialogFragment.setGetRect(cVar);
        userPortraitDialogFragment.setArguments(bundle);
        userPortraitDialogFragment.show(fragmentManager, UserPortraitDialogFragment.class.getName());
    }

    private void showProgress() {
        this.mProgressBar.setVisibility(0);
    }

    private void updateAvatarView(String str) {
        TouchImageView touchImageView;
        if (this.evp_apvp.getChildCount() <= 0 || (touchImageView = (TouchImageView) this.evp_apvp.getChildAt(0).findViewById(vStudio.Android.Camera360.R.id.tiv_touch_view_adapter)) == null || getActivity() == null) {
            return;
        }
        int j2 = us.pinguo.foundation.t.b.a.j(getActivity());
        touchImageView.setSize(j2, j2);
        touchImageView.setImageUri(str);
    }

    @Override // us.pinguo.foundation.base.c
    public void addSubscription(Subscription subscription) {
        if (this.mSubscriptions == null) {
            this.mSubscriptions = new CompositeSubscription();
        }
        this.mSubscriptions.add(subscription);
    }

    public void launchCropActivity(InspireRedirectActivity inspireRedirectActivity, String str, int i2) {
        Intent intent = new Intent(inspireRedirectActivity, CropActivity.class);
        intent.putExtra(PGEditResultActivity2.PATH, str);
        intent.putExtra("crop_key", i2);
        inspireRedirectActivity.startActivityForResult(intent, new us.pinguo.foundation.proxy.c() { // from class: us.pinguo.inspire.module.profile.fragment.f
            @Override // us.pinguo.foundation.proxy.c
            public final void onActivityResult(int i3, Intent intent2) {
                UserPortraitDialogFragment.this.d0(i3, intent2);
            }
        });
    }

    @Override // us.pinguo.inspire.widget.photopager.a.f
    public void onAnimUpdate(float f2, ImageView imageView) {
        Bitmap a;
        us.pinguo.foundation.t.a.g gVar = (us.pinguo.foundation.t.a.g) imageView.getDrawable();
        if (gVar == null || (a = gVar.a()) == null) {
            return;
        }
        imageView.setImageDrawable(new us.pinguo.foundation.t.a.g(a, (int) ((1.0f - f2) * imageView.getWidth() * 0.5d), 0));
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        launchGallery();
    }

    @Override // us.pinguo.inspire.widget.photopager.PictureViewPagerDialogFragment, androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(vStudio.Android.Camera360.R.layout.fragment_dialog_user_portrait, (ViewGroup) null);
        this.mLayout = inflate;
        return inflate;
    }

    @Override // us.pinguo.inspire.widget.photopager.PictureViewPagerDialogFragment, androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onDestroyView() {
        super.onDestroyView();
        unsubscribeAll();
    }

    @Override // us.pinguo.inspire.widget.photopager.PictureViewPagerDialogFragment, androidx.fragment.app.Fragment
    public void onViewCreated(View view, @Nullable Bundle bundle) {
        super.onViewCreated(view, bundle);
        setAnimFirstUpdateListener(this);
        this.mChangeAvatarTv = (TextView) view.findViewById(vStudio.Android.Camera360.R.id.tv_change_avatar_user_portrait_dialog);
        this.mProgressBar = (ProgressBar) view.findViewById(vStudio.Android.Camera360.R.id.pb_user_portrait_dialog);
        this.mChangeAvatarTv.setOnClickListener(this);
        this.mHandler.postDelayed(new Runnable() { // from class: us.pinguo.inspire.module.profile.fragment.m
            @Override // java.lang.Runnable
            public final void run() {
                UserPortraitDialogFragment.this.h0();
            }
        }, 300L);
    }

    public void unsubscribeAll() {
        CompositeSubscription compositeSubscription = this.mSubscriptions;
        if (compositeSubscription != null) {
            compositeSubscription.unsubscribe();
            this.mSubscriptions = null;
        }
    }

    /* renamed from: updateAvatar */
    public void b0(final String str, String str2) {
        showProgress();
        addSubscription(new UserInfoLoader().updateAvatar(str2).subscribe(new Action1() { // from class: us.pinguo.inspire.module.profile.fragment.j
            @Override // rx.functions.Action1
            public final void call(Object obj) {
                UserPortraitDialogFragment.this.r0(str, (String) obj);
            }
        }, new Action1() { // from class: us.pinguo.inspire.module.profile.fragment.k
            @Override // rx.functions.Action1
            public final void call(Object obj) {
                UserPortraitDialogFragment.this.t0((Throwable) obj);
            }
        }));
    }
}
