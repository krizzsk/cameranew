package us.pinguo.inspire.module.comment.widget;

import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.graphics.ColorFilter;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import com.rockerhieu.emoji.FaceView;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Objects;
import kotlin.jvm.internal.s;
import us.pinguo.inspire.R;
import us.pinguo.inspire.util.v;
import us.pinguo.inspire.widget.SystemErrorEditText;
import us.pinguo.inspire.widget.chat.ChatBottomLayout;
/* compiled from: InfoChatBottom.kt */
/* loaded from: classes9.dex */
public final class InfoChatBottom extends ChatBottomLayout {
    public Map<Integer, View> _$_findViewCache;
    private byte preState;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public InfoChatBottom(Context context) {
        super(context);
        s.h(context, "context");
        this._$_findViewCache = new LinkedHashMap();
    }

    private final void setChatBottomColor(boolean z) {
        if (z) {
            ImageView imageView = (ImageView) _$_findCachedViewById(R.id.chat_bottom_pic);
            if (imageView != null) {
                imageView.setColorFilter(-1);
            }
            FaceView faceView = (FaceView) _$_findCachedViewById(R.id.chat_bottom_face);
            if (faceView != null) {
                faceView.setColorFilter(-1);
            }
            ImageView imageView2 = (ImageView) _$_findCachedViewById(R.id.chat_bottom_at);
            if (imageView2 != null) {
                imageView2.setColorFilter(-1);
            }
            int i2 = R.id.chat_bottom_edit;
            SystemErrorEditText systemErrorEditText = (SystemErrorEditText) _$_findCachedViewById(i2);
            if (systemErrorEditText != null) {
                systemErrorEditText.setHintTextColor(Color.parseColor("#99FFFFFF"));
            }
            SystemErrorEditText systemErrorEditText2 = (SystemErrorEditText) _$_findCachedViewById(i2);
            if (systemErrorEditText2 != null) {
                systemErrorEditText2.setTextColor(getResources().getColor(us.pinguo.ui.R.color.text_white));
            }
            setBackgroundColor(getResources().getColor(vStudio.Android.Camera360.R.color.info_bottom_bg));
            return;
        }
        ImageView imageView3 = (ImageView) _$_findCachedViewById(R.id.chat_bottom_pic);
        if (imageView3 != null) {
            imageView3.setColorFilter((ColorFilter) null);
        }
        FaceView faceView2 = (FaceView) _$_findCachedViewById(R.id.chat_bottom_face);
        if (faceView2 != null) {
            faceView2.setColorFilter((ColorFilter) null);
        }
        ImageView imageView4 = (ImageView) _$_findCachedViewById(R.id.chat_bottom_at);
        if (imageView4 != null) {
            imageView4.setColorFilter((ColorFilter) null);
        }
        int i3 = R.id.chat_bottom_edit;
        SystemErrorEditText systemErrorEditText3 = (SystemErrorEditText) _$_findCachedViewById(i3);
        if (systemErrorEditText3 != null) {
            systemErrorEditText3.setHintTextColor(Color.parseColor("#4D000000"));
        }
        SystemErrorEditText systemErrorEditText4 = (SystemErrorEditText) _$_findCachedViewById(i3);
        if (systemErrorEditText4 != null) {
            systemErrorEditText4.setTextColor(getResources().getColor(us.pinguo.ui.R.color.text_deeper));
        }
        setBackgroundColor(-1);
    }

    public void _$_clearFindViewByIdCache() {
        this._$_findViewCache.clear();
    }

    public View _$_findCachedViewById(int i2) {
        Map<Integer, View> map = this._$_findViewCache;
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

    @Override // us.pinguo.inspire.widget.chat.ChatBottomLayout
    protected v initSoftDetector() {
        Context context = getContext();
        Objects.requireNonNull(context, "null cannot be cast to non-null type android.app.Activity");
        return new v((Activity) context, this, vStudio.Android.Camera360.R.id.info_keyboard_layout);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // us.pinguo.inspire.widget.chat.ChatBottomLayout, android.view.View
    public void onFinishInflate() {
        super.onFinishInflate();
        if (isInEditMode()) {
            return;
        }
        setChatBottomColor(true);
    }

    @Override // us.pinguo.inspire.widget.chat.ChatBottomLayout, com.rockerhieu.emoji.KeyboardLayout.b
    public void onKeyBoardStateChange(int i2) {
        super.onKeyBoardStateChange(i2);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public InfoChatBottom(Context context, AttributeSet attrs) {
        super(context, attrs);
        s.h(context, "context");
        s.h(attrs, "attrs");
        this._$_findViewCache = new LinkedHashMap();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public InfoChatBottom(Context context, AttributeSet attrs, int i2) {
        super(context, attrs, i2);
        s.h(context, "context");
        s.h(attrs, "attrs");
        this._$_findViewCache = new LinkedHashMap();
    }
}
