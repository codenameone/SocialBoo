package com.codename1.demos.socialboo.gui;

import com.codename1.demos.socialboo.SocialBoo;
import com.codename1.ui.Display;
import com.codename1.ui.util.UITimer;

/**
 * Simple splash screen that redirects to the main form after a couple of seconds
 */
public class Splash extends com.codename1.ui.Form {
    public Splash() {
        this(com.codename1.ui.util.Resources.getGlobalResources());
    }
    
    public Splash(com.codename1.ui.util.Resources resourceObjectInstance) {
        initGuiBuilderComponents(resourceObjectInstance);
        if(SocialBoo.isTabletMode()) {
            UITimer.timer(2000, false, this, () -> new Person().show());
        } else {
            UITimer.timer(2000, false, this, () -> new Main().show());
        }
    }

//-- DON'T EDIT BELOW THIS LINE!!!
    private com.codename1.ui.Container gui_Container = new com.codename1.ui.Container(new com.codename1.ui.layouts.FlowLayout());
    private com.codename1.ui.Label gui_Label = new com.codename1.ui.Label();


// <editor-fold defaultstate="collapsed" desc="Generated Code">                          
    private void initGuiBuilderComponents(com.codename1.ui.util.Resources resourceObjectInstance) {
        setLayout(new com.codename1.ui.layouts.BorderLayout());
        setUIID("Splash");
        setTitle("Loading...");
        setName("Splash");
        addComponent(com.codename1.ui.layouts.BorderLayout.CENTER, gui_Container);
        gui_Container.setUIID("SplashLayer");
        gui_Container.setName("Container");
        ((com.codename1.ui.layouts.FlowLayout)gui_Container.getLayout()).setAlign(com.codename1.ui.Component.CENTER);
        ((com.codename1.ui.layouts.FlowLayout)gui_Container.getLayout()).setValign(com.codename1.ui.Component.CENTER);
        gui_Container.addComponent(gui_Label);
        gui_Label.setText("");
        gui_Label.setUIID("LogoLabel");
        gui_Label.setName("Label");
        gui_Label.setIcon(resourceObjectInstance.getImage("SplashLogo.png"));
        gui_Container.setUIID("SplashLayer");
        gui_Container.setName("Container");
        ((com.codename1.ui.layouts.FlowLayout)gui_Container.getLayout()).setAlign(com.codename1.ui.Component.CENTER);
        ((com.codename1.ui.layouts.FlowLayout)gui_Container.getLayout()).setValign(com.codename1.ui.Component.CENTER);
    }// </editor-fold>

//-- DON'T EDIT ABOVE THIS LINE!!!
}
