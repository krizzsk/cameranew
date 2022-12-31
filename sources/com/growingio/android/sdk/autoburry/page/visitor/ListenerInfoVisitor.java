package com.growingio.android.sdk.autoburry.page.visitor;

import android.view.View;
import com.growingio.android.sdk.autoburry.page.proxy.OnFocusChangeListenerProxy;
import com.growingio.android.sdk.collection.AbstractGrowingIO;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
/* loaded from: classes2.dex */
public class ListenerInfoVisitor {
    private static final String TAG = "GIO.ListenerInfo";
    private Class<?> ListenerInfoClass;
    private Field mListenerInfoField;
    private Field mOnClickListenerField;
    private Field mOnFocusChangeListenerField;

    protected boolean checkEnv(View view) {
        try {
            Field declaredField = View.class.getDeclaredField("mListenerInfo");
            this.mListenerInfoField = declaredField;
            declaredField.setAccessible(true);
            Class<?> cls = Class.forName(String.format("%s$ListenerInfo", View.class.getName()));
            this.ListenerInfoClass = cls;
            Field declaredField2 = cls.getDeclaredField("mOnFocusChangeListener");
            this.mOnFocusChangeListenerField = declaredField2;
            declaredField2.setAccessible(true);
            Field declaredField3 = this.ListenerInfoClass.getDeclaredField("mOnClickListener");
            this.mOnClickListenerField = declaredField3;
            declaredField3.setAccessible(true);
            return true;
        } catch (Throwable th) {
            th.printStackTrace();
            return false;
        }
    }

    protected Object getListenerInfo(View view) {
        try {
            return this.mListenerInfoField.get(view);
        } catch (Throwable th) {
            th.printStackTrace();
            return null;
        }
    }

    protected Object getNewListenerInfo(View view) {
        try {
            Constructor<?> declaredConstructor = this.ListenerInfoClass.getDeclaredConstructor(null);
            declaredConstructor.setAccessible(true);
            if (declaredConstructor != null) {
                return declaredConstructor.newInstance(null);
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
        return null;
    }

    protected View.OnClickListener getOnClickListener(Object obj) {
        try {
            return (View.OnClickListener) this.mOnClickListenerField.get(obj);
        } catch (Throwable th) {
            th.printStackTrace();
            return null;
        }
    }

    protected View.OnFocusChangeListener getOnFocusChangeListener(Object obj) {
        try {
            return (View.OnFocusChangeListener) this.mOnFocusChangeListenerField.get(obj);
        } catch (Throwable th) {
            th.printStackTrace();
            return null;
        }
    }

    public boolean handle(View view) {
        if (view.isClickable() && checkEnv(view) && view.getTag(AbstractGrowingIO.GROWING_HOOK_LISTENTER) == null) {
            Object listenerInfo = getListenerInfo(view);
            if (listenerInfo == null) {
                listenerInfo = getNewListenerInfo(view);
                setListenerInfo(view, listenerInfo);
            }
            if (listenerInfo == null) {
                return false;
            }
            setOnFocusChangeListener(listenerInfo, new OnFocusChangeListenerProxy(getOnFocusChangeListener(listenerInfo)));
            view.setTag(AbstractGrowingIO.GROWING_HOOK_LISTENTER, Boolean.TRUE);
        }
        return false;
    }

    protected void setListenerInfo(View view, Object obj) {
        try {
            this.mListenerInfoField.set(view, obj);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    protected void setOnClickListener(Object obj, View.OnClickListener onClickListener) {
        try {
            this.mOnClickListenerField.set(obj, onClickListener);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    protected void setOnFocusChangeListener(Object obj, View.OnFocusChangeListener onFocusChangeListener) {
        try {
            this.mOnFocusChangeListenerField.set(obj, onFocusChangeListener);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }
}
