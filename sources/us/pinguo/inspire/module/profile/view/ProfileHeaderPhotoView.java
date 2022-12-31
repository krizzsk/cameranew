package us.pinguo.inspire.module.profile.view;

import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Pair;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import java.util.ArrayList;
import java.util.List;
import us.pinguo.foundation.t.a.f;
import us.pinguo.foundation.t.a.g;
import us.pinguo.foundation.t.b.a;
import us.pinguo.inspire.model.InspireWork;
import us.pinguo.inspire.module.discovery.entity.InspireFeedPhoto;
import us.pinguo.inspire.module.profile.view.ProfilePhotoImageView;
import us.pinguo.inspire.widget.photopager.FullScreenPhoto;
import us.pinguo.inspire.widget.photopager.PictureViewPagerDialogFragment;
import us.pinguo.inspire_proxy.media.e;
import us.pinguo.ui.uilview.PhotoImageView;
import vStudio.Android.Camera360.R;
/* loaded from: classes9.dex */
public class ProfileHeaderPhotoView extends LinearLayout implements View.OnClickListener {
    private int itemHeight;
    private int itemWidth;
    protected ProfilePhotoImageView mImage1;
    protected ProfilePhotoImageView mImage2;
    protected ProfilePhotoImageView mImage3;
    protected ProfilePhotoImageView mImage4;
    private boolean mIsEnterBigPic;
    private OnItemClickListener mOnItemClickListener;
    private List<InspireWork> mWorks;

    /* loaded from: classes9.dex */
    public interface OnItemClickListener {
        void onItemClick(View view);
    }

    public ProfileHeaderPhotoView(Context context) {
        super(context);
        this.mIsEnterBigPic = true;
        init(context);
    }

    public static Pair<Integer, Integer> getVideoSize(int i2, int i3, int i4, int i5) {
        if (i5 <= 1 || i4 <= 1 || i2 <= 1 || i3 <= 1) {
            i2 = 0;
            i3 = 0;
        } else if (i2 > i3) {
            i3 = (i5 * i2) / i4;
        } else {
            i2 = (i4 * i3) / i5;
        }
        return new Pair<>(Integer.valueOf(i2), Integer.valueOf(i3));
    }

    private void init(Context context) {
        View inflate = LayoutInflater.from(context).inflate(R.layout.profile_photo_view_layout, (ViewGroup) this, true);
        this.mImage1 = (ProfilePhotoImageView) inflate.findViewById(R.id.photo_view_image1);
        this.mImage2 = (ProfilePhotoImageView) inflate.findViewById(R.id.photo_view_image2);
        this.mImage3 = (ProfilePhotoImageView) inflate.findViewById(R.id.photo_view_image3);
        this.mImage4 = (ProfilePhotoImageView) inflate.findViewById(R.id.photo_view_image4);
        this.mImage1.setOnClickListener(this);
        this.mImage2.setOnClickListener(this);
        this.mImage3.setOnClickListener(this);
        this.mImage4.setOnClickListener(this);
        initAndSize(context);
    }

    private void setDefaultRes() {
        this.mImage1.setImageResource(R.drawable.profile_null_photo_shape);
        this.mImage2.setImageResource(R.drawable.profile_null_photo_shape);
        this.mImage3.setImageResource(R.drawable.profile_null_photo_shape);
        ProfilePhotoImageView profilePhotoImageView = this.mImage4;
        if (profilePhotoImageView != null) {
            profilePhotoImageView.setImageBitmap(null);
            this.mImage4.setImageResource(R.drawable.profile_null_photo_shape);
        }
    }

    public ProfilePhotoImageView.TYPE getType(InspireWork inspireWork) {
        int i2 = inspireWork.workType;
        if (i2 == 1) {
            return ProfilePhotoImageView.TYPE.NONE;
        }
        if (i2 == 2) {
            return ProfilePhotoImageView.TYPE.VIDEO;
        }
        return ProfilePhotoImageView.TYPE.MUTIL_PHOTO;
    }

    protected void initAndSize(Context context) {
        int a = a.a(context, 6.0f);
        int j2 = (int) (((a.j(context) - (a.a(context, 16.0f) * 2)) - (a * 3)) / 4.0f);
        setSize(this.mImage1, j2, j2);
        setSize(this.mImage2, j2, j2);
        setSize(this.mImage3, j2, j2);
        setSize(this.mImage4, j2, j2);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(final View view) {
        Bitmap a;
        List<InspireWork> list = this.mWorks;
        if (list == null || list.isEmpty()) {
            return;
        }
        if (!this.mIsEnterBigPic) {
            OnItemClickListener onItemClickListener = this.mOnItemClickListener;
            if (onItemClickListener != null) {
                onItemClickListener.onItemClick(view);
                return;
            }
            return;
        }
        int[] iArr = new int[2];
        view.getLocationInWindow(iArr);
        Rect rect = new Rect(iArr[0], iArr[1], iArr[0] + view.getWidth(), iArr[1] + view.getHeight());
        new PictureViewPagerDialogFragment();
        FragmentManager supportFragmentManager = ((FragmentActivity) view.getContext()).getSupportFragmentManager();
        new Bundle();
        ProfilePhotoImageView profilePhotoImageView = this.mImage1;
        int i2 = this.mImage2 == view ? 1 : 0;
        if (this.mImage3 == view) {
            i2 = 2;
        }
        if (this.mImage4 == view) {
            i2 = 3;
        }
        if (i2 > this.mWorks.size() - 1) {
            return;
        }
        Bitmap[] bitmapArr = null;
        Drawable drawable = ((ImageView) view).getDrawable();
        if ((drawable instanceof g) && (a = ((g) drawable).a()) != null) {
            bitmapArr = new Bitmap[]{a};
        }
        PictureViewPagerDialogFragment.sBitmaps = bitmapArr;
        InspireWork inspireWork = this.mWorks.get(i2);
        if (inspireWork.workType == 2) {
            if (TextUtils.isEmpty(inspireWork.getWorkUrl())) {
                return;
            }
            e.i(view.getContext(), Uri.parse(inspireWork.getWorkUrl()), inspireWork.getWidth(), inspireWork.getHeight(), 0);
            return;
        }
        ArrayList arrayList = new ArrayList();
        if (inspireWork.isMulityPhotos()) {
            for (int i3 = 0; i3 < inspireWork.getMembersCount(); i3++) {
                InspireWork.WorkMember workMember = inspireWork.members.get(i3);
                InspireFeedPhoto inspireFeedPhoto = new InspireFeedPhoto();
                inspireFeedPhoto.url = workMember.memUrl;
                inspireFeedPhoto.width = workMember.width;
                inspireFeedPhoto.height = workMember.height;
                FullScreenPhoto fullScreenPhoto = new FullScreenPhoto();
                fullScreenPhoto.photo = inspireFeedPhoto;
                fullScreenPhoto.rect = rect;
                arrayList.add(fullScreenPhoto);
            }
        } else {
            InspireFeedPhoto inspireFeedPhoto2 = new InspireFeedPhoto();
            inspireFeedPhoto2.url = inspireWork.getWorkUrl();
            inspireFeedPhoto2.width = inspireWork.width;
            inspireFeedPhoto2.height = inspireWork.height;
            FullScreenPhoto fullScreenPhoto2 = new FullScreenPhoto();
            fullScreenPhoto2.photo = inspireFeedPhoto2;
            fullScreenPhoto2.rect = rect;
            arrayList.add(fullScreenPhoto2);
        }
        PictureViewPagerDialogFragment.showFullScreenPics(supportFragmentManager, bitmapArr, arrayList, 0, new PictureViewPagerDialogFragment.c() { // from class: us.pinguo.inspire.module.profile.view.ProfileHeaderPhotoView.1
            @Override // us.pinguo.inspire.widget.photopager.PictureViewPagerDialogFragment.c
            public Rect getPicRect(int i4) {
                int[] iArr2 = new int[2];
                view.getLocationInWindow(iArr2);
                return new Rect(iArr2[0], iArr2[1], iArr2[0] + view.getWidth(), iArr2[1] + view.getHeight());
            }
        });
    }

    public void setEnterBigPic(boolean z) {
        this.mIsEnterBigPic = z;
    }

    protected void setImage(ProfilePhotoImageView profilePhotoImageView, InspireWork inspireWork) {
        profilePhotoImageView.setDisplayer(new f(a.a(profilePhotoImageView.getContext(), 4.0f)));
        profilePhotoImageView.setLoadingColor(getResources().getColor(us.pinguo.user.R.color.portal_page_bg));
        if (inspireWork.isVideo()) {
            profilePhotoImageView.setVideoImageUrl(inspireWork.getWorkUrl(), inspireWork.width, inspireWork.height, this.itemWidth, this.itemHeight);
            profilePhotoImageView.setShowType(getType(inspireWork));
            return;
        }
        List<InspireWork.WorkMember> list = inspireWork.members;
        if (list != null && list.size() > 1) {
            profilePhotoImageView.setShowType(getType(inspireWork), inspireWork.members.size());
        } else {
            profilePhotoImageView.setShowType(getType(inspireWork));
        }
        profilePhotoImageView.setImageUri(inspireWork.getWorkUrl());
    }

    public void setImageUris(List<InspireWork> list) {
        if (list == null) {
            return;
        }
        this.mWorks = list;
        setDefaultRes();
        int size = list.size();
        if (size == 1) {
            setImage(this.mImage1, list.get(0));
        } else if (size == 2) {
            setImage(this.mImage1, list.get(0));
            setImage(this.mImage2, list.get(1));
        } else if (size == 3) {
            setImage(this.mImage1, list.get(0));
            setImage(this.mImage2, list.get(1));
            setImage(this.mImage3, list.get(2));
        } else if (size != 4) {
        } else {
            setImage(this.mImage1, list.get(0));
            setImage(this.mImage2, list.get(1));
            setImage(this.mImage3, list.get(2));
            setImage(this.mImage4, list.get(3));
        }
    }

    public void setOnItemClickListener(OnItemClickListener onItemClickListener) {
        this.mOnItemClickListener = onItemClickListener;
    }

    public void setSize(PhotoImageView photoImageView, int i2, int i3) {
        ViewGroup.LayoutParams layoutParams = photoImageView.getLayoutParams();
        layoutParams.width = i2;
        layoutParams.height = i3;
        this.itemHeight = i3;
        this.itemWidth = i2;
        photoImageView.setLayoutParams(layoutParams);
    }

    public ProfileHeaderPhotoView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mIsEnterBigPic = true;
        init(context);
    }

    public ProfileHeaderPhotoView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.mIsEnterBigPic = true;
        init(context);
    }

    @TargetApi(21)
    public ProfileHeaderPhotoView(Context context, AttributeSet attributeSet, int i2, int i3) {
        super(context, attributeSet, i2, i3);
        this.mIsEnterBigPic = true;
        init(context);
    }
}
