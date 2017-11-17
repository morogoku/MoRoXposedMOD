package moro.com.moroxposedmod;

import android.graphics.Color;
import android.widget.TextView;

import de.robv.android.xposed.IXposedHookLoadPackage;
import de.robv.android.xposed.XC_MethodHook;
import de.robv.android.xposed.callbacks.XC_LoadPackage;

import static de.robv.android.xposed.XposedHelpers.findAndHookMethod;

/**
 * Created by Morogoku on 17/11/2017.
 */

public class Modulo implements IXposedHookLoadPackage {

    public void handleLoadPackage(final XC_LoadPackage.LoadPackageParam lpparam) throws Throwable {
        if (!lpparam.packageName.equals("com.android.systemui")) return;

        findAndHookMethod("com.android.systemui.statusbar.policy.Clock", lpparam.classLoader, "updateClock", new XC_MethodHook() {
            @Override
            protected void afterHookedMethod(MethodHookParam param) throws Throwable {

                    TextView tv = (TextView) param.thisObject;
                    String text = tv.getText().toString();
                    tv.setText(text + " :)");
                    tv.setTextColor(Color.RED);

            }
        });
    }
}
