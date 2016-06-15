package com.codename1.demos.socialboo;


import com.codename1.demos.socialboo.gui.Splash;
import com.codename1.ui.Dialog;
import com.codename1.ui.Display;
import com.codename1.ui.FontImage;
import com.codename1.ui.Form;
import com.codename1.ui.Toolbar;
import com.codename1.ui.plaf.UIManager;
import com.codename1.ui.util.Resources;

/**
 * <p>Social boo shows a simple Social style application UI based on a template of the same name from
 * <a href="http://www.appdesignvault.com/shop/social-boo/">app design vault</a>. This demo
 * uses a somewhat outdated but still reasonable gunmetal look, it also features different UI styles when
 * running on a tablet/phone.</p>
 * <p>
 * This demo was originally developed for the old GUI builder and was adapted to use the new GUI builder in
 * this iteration. We chose to leave the original design in place "as is" since it demonstrates how deeply Codename One
 * can be customized with very few changes.
 * </p>
 */
public class SocialBoo {
    private Form current;
    private Resources theme;
    private static boolean tabletModeOverride;

    public void init(Object context) {
        theme = UIManager.initFirstTheme("/theme");
        tabletModeOverride = Display.getInstance().isTablet();

        // Enable Toolbar on all Forms by default
        Toolbar.setGlobalToolbar(true);

        // Pro only feature, uncomment if you have a pro subscription
        // Log.bindCrashProtection(true);
    }
    
    public void start() {
        if(current != null){
            current.show();
            return;
        }
        new Splash(theme).show();
    }

    public void stop() {
        current = Display.getInstance().getCurrent();
        if(current instanceof Dialog) {
            ((Dialog)current).dispose();
            current = Display.getInstance().getCurrent();
        }
    }
    
    public void destroy() {
    }
    
    /**
     * This flag allows us to toggle the tablet mode in this demo to show off the UI as if we are running on a 
     * phone/tablet respectively
     * @return true if we are in the tablet mode
     */
    public static boolean isTabletMode() {
        return tabletModeOverride;
    }
    
    public static void setTabletMode(boolean b) {
        tabletModeOverride = b;
    }
    
    public static void addToggleCommand(Toolbar t) {
        if(isTabletMode()) {
            t.addMaterialCommandToRightBar("", FontImage.MATERIAL_PHONE_IPHONE, e -> {
                SocialBoo.setTabletMode(false);
                new Splash().show();
            });
        } else {
            t.addMaterialCommandToRightBar("", FontImage.MATERIAL_TABLET_MAC, e -> {
                SocialBoo.setTabletMode(true);
                new Splash().show();
            });
        }
    }
}
