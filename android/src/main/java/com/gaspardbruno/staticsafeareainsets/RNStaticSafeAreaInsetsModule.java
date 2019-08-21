package com.gaspardbruno.staticsafeareainsets;

import com.facebook.react.bridge.Callback;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;

import java.util.Map;
import java.util.HashMap;

import android.view.WindowInsets;
import android.view.View;
import android.os.Build;
import android.app.Activity;

public class RNStaticSafeAreaInsetsModule extends ReactContextBaseJavaModule {

  private final ReactApplicationContext reactContext;

  public RNStaticSafeAreaInsetsModule(ReactApplicationContext reactContext) {
    super(reactContext);
    this.reactContext = reactContext;
  }

  @Override
  public String getName() {
    return "RNStaticSafeAreaInsets";
  }

  @Override
  public Map<String, Object> getConstants() {
    final Map<String, Object> constants = new HashMap<>();

    constants.put("safeAreaInsetsTop", this._getSafeAreaInsetsTop());
    constants.put("safeAreaInsetsBottom", this._getSafeAreaInsetsBottom());
    constants.put("safeAreaInsetsLeft", this._getSafeAreaInsetsLeft());
    constants.put("safeAreaInsetsRight", this._getSafeAreaInsetsRight());

    return constants;
  }

  private float _getSafeAreaInsetsTop() {
    if (getCurrentActivity() != null && Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
      return insets.getSystemWindowInsetTop();
    } else {
      return 0;
    }
  }

  private float _getSafeAreaInsetsBottom() {
    if (getCurrentActivity() != null && Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
      return insets.getSystemWindowInsetBottom();
    } else {
      return 0;
    }
  }

  private float _getSafeAreaInsetsLeft() {
    if (getCurrentActivity() != null && Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
      return insets.getSystemWindowInsetLeft();
    } else {
      return 0;
    }
  }

  private float _getSafeAreaInsetsRight() {
    if (getCurrentActivity() != null && Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
      return insets.getSystemWindowInsetRight();
    } else {
      return 0;
    }
  }

  @ReactMethod
  public float getSafeAreaInsetsTop(Callback cb) {
    cb.invoke(this._getSafeAreaInsetsTop());
  }

  @ReactMethod
  public float getSafeAreaInsetsBottom(Callback cb) {
    cb.invoke(this._getSafeAreaInsetsBottom());
  }

  @ReactMethod
  public float getSafeAreaInsetsLeft(Callback cb) {
    cb.invoke(this._getSafeAreaInsetsLeft());
  }

  @ReactMethod
  public float getSafeAreaInsetsRight(Callback cb) {
    cb.invoke(this._getSafeAreaInsetsRight());
  }
}
