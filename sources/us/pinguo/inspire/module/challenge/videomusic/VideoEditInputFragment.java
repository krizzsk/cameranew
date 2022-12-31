package us.pinguo.inspire.module.challenge.videomusic;

import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.os.Handler;
import android.text.Editable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.Window;
import android.widget.EditText;
import androidx.fragment.app.DialogFragment;
import com.rockerhieu.emoji.KeyboardFrameLayout;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;
import us.pinguo.inspire.module.attention.InspireAttention;
import vStudio.Android.Camera360.R;
/* compiled from: VideoEditInputFragment.kt */
/* loaded from: classes9.dex */
public final class VideoEditInputFragment extends DialogFragment {
    public Map<Integer, View> _$_findViewCache = new LinkedHashMap();
    private VideoEditChatBottom bottomLayout;
    public CharSequence content;
    private boolean keyboardShow;
    private DialogInterface.OnDismissListener onDismissListener;
    private View root;

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: initViews$lambda-2  reason: not valid java name */
    public static final boolean m117initViews$lambda2(VideoEditInputFragment this$0, int i2, int i3) {
        kotlin.jvm.internal.s.h(this$0, "this$0");
        int[] iArr = new int[2];
        VideoEditChatBottom videoEditChatBottom = this$0.bottomLayout;
        if (videoEditChatBottom != null) {
            videoEditChatBottom.getLocationInWindow(iArr);
        }
        int i4 = iArr[1];
        VideoEditChatBottom videoEditChatBottom2 = this$0.bottomLayout;
        kotlin.jvm.internal.s.e(videoEditChatBottom2);
        int height = i4 + videoEditChatBottom2.getHeight() + i2;
        if (!this$0.keyboardShow) {
            View view = this$0.root;
            if (view == null) {
                kotlin.jvm.internal.s.z("root");
                throw null;
            } else if (view.getHeight() - height > i3) {
                this$0.keyboardShow = true;
                this$0.onKeyboardShow(true);
            }
        } else {
            View view2 = this$0.root;
            if (view2 == null) {
                kotlin.jvm.internal.s.z("root");
                throw null;
            } else if (view2.getHeight() == height) {
                this$0.keyboardShow = false;
                this$0.onKeyboardShow(false);
            }
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: onCreateDialog$lambda-1  reason: not valid java name */
    public static final void m118onCreateDialog$lambda1(final VideoEditInputFragment this$0) {
        kotlin.jvm.internal.s.h(this$0, "this$0");
        new Handler().post(new Runnable() { // from class: us.pinguo.inspire.module.challenge.videomusic.o0
            @Override // java.lang.Runnable
            public final void run() {
                VideoEditInputFragment.m119onCreateDialog$lambda1$lambda0(VideoEditInputFragment.this);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: onCreateDialog$lambda-1$lambda-0  reason: not valid java name */
    public static final void m119onCreateDialog$lambda1$lambda0(VideoEditInputFragment this$0) {
        kotlin.jvm.internal.s.h(this$0, "this$0");
        this$0.onFirstFrameVisible();
    }

    public void _$_clearFindViewByIdCache() {
        this._$_findViewCache.clear();
    }

    public View _$_findCachedViewById(int i2) {
        View findViewById;
        Map<Integer, View> map = this._$_findViewCache;
        View view = map.get(Integer.valueOf(i2));
        if (view == null) {
            View view2 = getView();
            if (view2 == null || (findViewById = view2.findViewById(i2)) == null) {
                return null;
            }
            map.put(Integer.valueOf(i2), findViewById);
            return findViewById;
        }
        return view;
    }

    public final ArrayList<InspireAttention> getAttentions() {
        VideoEditChatBottom videoEditChatBottom = this.bottomLayout;
        ArrayList<InspireAttention> attentions = videoEditChatBottom == null ? null : videoEditChatBottom.getAttentions();
        return attentions == null ? new ArrayList<>() : attentions;
    }

    public final CharSequence getContent() {
        VideoEditChatBottom videoEditChatBottom = this.bottomLayout;
        kotlin.jvm.internal.s.e(videoEditChatBottom);
        EditText editText = videoEditChatBottom.getEditText();
        kotlin.jvm.internal.s.e(editText);
        Editable text = editText.getText();
        kotlin.jvm.internal.s.g(text, "bottomLayout!!.editText!!.text");
        return text;
    }

    public final DialogInterface.OnDismissListener getOnDismissListener() {
        return this.onDismissListener;
    }

    public final View initViews(Dialog dialog) {
        VideoEditChatBottom videoEditChatBottom;
        EditText editText;
        ViewTreeObserver viewTreeObserver;
        kotlin.jvm.internal.s.h(dialog, "dialog");
        View inflate = LayoutInflater.from(getContext()).inflate(R.layout.video_edit_input_fragment, (ViewGroup) null);
        kotlin.jvm.internal.s.g(inflate, "from(context).inflate(R.…dit_input_fragment, null)");
        this.root = inflate;
        if (inflate != null) {
            this.bottomLayout = (VideoEditChatBottom) inflate.findViewById(R.id.video_edit_chat_layout);
            View view = this.root;
            if (view != null) {
                ((KeyboardFrameLayout) view.findViewById(R.id.video_edit_chat_keyboard_layout)).setOnkbdStateListener(this.bottomLayout);
                final int dimensionPixelSize = getResources().getDimensionPixelSize(R.dimen.video_edit_input_margin);
                final int a = us.pinguo.foundation.t.b.a.a(getContext(), 100.0f);
                VideoEditChatBottom videoEditChatBottom2 = this.bottomLayout;
                if (videoEditChatBottom2 != null && (viewTreeObserver = videoEditChatBottom2.getViewTreeObserver()) != null) {
                    viewTreeObserver.addOnPreDrawListener(new ViewTreeObserver.OnPreDrawListener() { // from class: us.pinguo.inspire.module.challenge.videomusic.n0
                        @Override // android.view.ViewTreeObserver.OnPreDrawListener
                        public final boolean onPreDraw() {
                            boolean m117initViews$lambda2;
                            m117initViews$lambda2 = VideoEditInputFragment.m117initViews$lambda2(VideoEditInputFragment.this, dimensionPixelSize, a);
                            return m117initViews$lambda2;
                        }
                    });
                }
                if (this.content != null && (videoEditChatBottom = this.bottomLayout) != null && (editText = videoEditChatBottom.getEditText()) != null) {
                    editText.setText(this.content);
                }
                View view2 = this.root;
                if (view2 != null) {
                    return view2;
                }
                kotlin.jvm.internal.s.z("root");
                throw null;
            }
            kotlin.jvm.internal.s.z("root");
            throw null;
        }
        kotlin.jvm.internal.s.z("root");
        throw null;
    }

    @Override // androidx.fragment.app.DialogFragment
    public Dialog onCreateDialog(Bundle bundle) {
        View decorView;
        Dialog dialog = new Dialog(requireContext(), R.style.video_edit_dialog);
        dialog.requestWindowFeature(1);
        dialog.setContentView(initViews(dialog));
        dialog.setCanceledOnTouchOutside(true);
        Window window = dialog.getWindow();
        if (window != null && (decorView = window.getDecorView()) != null) {
            decorView.post(new Runnable() { // from class: us.pinguo.inspire.module.challenge.videomusic.m0
                @Override // java.lang.Runnable
                public final void run() {
                    VideoEditInputFragment.m118onCreateDialog$lambda1(VideoEditInputFragment.this);
                }
            });
        }
        return dialog;
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public /* synthetic */ void onDestroyView() {
        super.onDestroyView();
        _$_clearFindViewByIdCache();
    }

    @Override // androidx.fragment.app.DialogFragment, android.content.DialogInterface.OnDismissListener
    public void onDismiss(DialogInterface dialog) {
        kotlin.jvm.internal.s.h(dialog, "dialog");
        super.onDismiss(dialog);
        DialogInterface.OnDismissListener onDismissListener = this.onDismissListener;
        if (onDismissListener == null) {
            return;
        }
        onDismissListener.onDismiss(dialog);
    }

    public final void onFirstFrameVisible() {
        EditText editText;
        VideoEditChatBottom videoEditChatBottom = this.bottomLayout;
        if (videoEditChatBottom == null || (editText = videoEditChatBottom.getEditText()) == null) {
            return;
        }
        editText.requestFocus();
    }

    public final void onKeyboardShow(boolean z) {
        us.pinguo.common.log.a.u("hwLog", kotlin.jvm.internal.s.q("onKeyboardShow:", Boolean.valueOf(z)), new Object[0]);
    }

    public final void setContent(CharSequence content) {
        EditText editText;
        kotlin.jvm.internal.s.h(content, "content");
        this.content = content;
        VideoEditChatBottom videoEditChatBottom = this.bottomLayout;
        if (videoEditChatBottom == null || (editText = videoEditChatBottom.getEditText()) == null) {
            return;
        }
        editText.setText(content);
    }

    public final void setOnDismissListener(DialogInterface.OnDismissListener onDismissListener) {
        this.onDismissListener = onDismissListener;
    }
}
