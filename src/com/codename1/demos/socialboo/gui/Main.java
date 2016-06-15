package com.codename1.demos.socialboo.gui;

import com.codename1.demos.socialboo.SocialBoo;

/**
 * GUI builder created Form
 */
public class Main extends com.codename1.ui.Form {
    public Main() {
        this(com.codename1.ui.util.Resources.getGlobalResources());
    }
    
    public Main(com.codename1.ui.util.Resources resourceObjectInstance) {
        initGuiBuilderComponents(resourceObjectInstance);
        getToolbar().setTitleCentered(true);
        SocialBoo.addToggleCommand(getToolbar());
    }

//-- DON'T EDIT BELOW THIS LINE!!!
    private com.codename1.ui.Tabs gui_Tabs = new com.codename1.ui.Tabs();
    private com.codename1.ui.Container gui_friends = new com.codename1.ui.Container(new com.codename1.ui.layouts.BoxLayout(com.codename1.ui.layouts.BoxLayout.Y_AXIS));
    private com.codename1.components.MultiButton gui_JessicaButton = new com.codename1.components.MultiButton();
    private com.codename1.ui.Container gui_Container = new com.codename1.ui.Container();
    private com.codename1.ui.Label gui_Label1 = new com.codename1.ui.Label();
    private com.codename1.ui.Container gui_Container2 = new com.codename1.ui.Container();
    private com.codename1.ui.Label gui_Label2 = new com.codename1.ui.Label();
    private com.codename1.ui.Container gui_Container3 = new com.codename1.ui.Container(new com.codename1.ui.layouts.BoxLayout(com.codename1.ui.layouts.BoxLayout.Y_AXIS));
    private com.codename1.ui.Label gui_Label = new com.codename1.ui.Label();
    private com.codename1.ui.TextField gui_TextField = new com.codename1.ui.TextField();
    private com.codename1.ui.Button gui_Button = new com.codename1.ui.Button();
    private com.codename1.ui.Button gui_Button1 = new com.codename1.ui.Button();
    private com.codename1.ui.Button gui_Button2 = new com.codename1.ui.Button();
    private com.codename1.ui.Container gui_Container4 = new com.codename1.ui.Container(new com.codename1.ui.layouts.GridLayout(1, 2));
    private com.codename1.ui.Button gui_Button11 = new com.codename1.ui.Button();
    private com.codename1.ui.Button gui_Button21 = new com.codename1.ui.Button();
    private com.codename1.ui.Slider gui_Slider = new com.codename1.ui.Slider();


// <editor-fold defaultstate="collapsed" desc="Generated Code">                          
    private void guiBuilderBindComponentListeners() {
        EventCallbackClass callback = new EventCallbackClass();
        gui_JessicaButton.addActionListener(callback);
    }

    class EventCallbackClass implements com.codename1.ui.events.ActionListener, com.codename1.ui.events.DataChangedListener {
        private com.codename1.ui.Component cmp;
        public EventCallbackClass(com.codename1.ui.Component cmp) {
            this.cmp = cmp;
        }

        public EventCallbackClass() {
        }

        public void actionPerformed(com.codename1.ui.events.ActionEvent ev) {
            com.codename1.ui.Component sourceComponent = ev.getComponent();
            if(sourceComponent.getParent().getLeadParent() != null) {
                sourceComponent = sourceComponent.getParent().getLeadParent();
            }

            if(sourceComponent == gui_JessicaButton) {
                onJessicaButtonActionEvent(ev);
            }
        }

        public void dataChanged(int type, int index) {
        }
    }
    private void initGuiBuilderComponents(com.codename1.ui.util.Resources resourceObjectInstance) {
        guiBuilderBindComponentListeners();
        setLayout(new com.codename1.ui.layouts.BorderLayout());
        setScrollableY(false);
        setTitle("Social Boo");
        setName("Main");
        addComponent(com.codename1.ui.layouts.BorderLayout.CENTER, gui_Tabs);
        gui_Tabs.setName("Tabs");
        gui_Tabs.setPropertyValue("titles", new String[]{"Friends", "Chats", "Email", "Settings"});
        gui_Tabs.setPropertyValue("icons", new com.codename1.ui.Image[]{resourceObjectInstance.getImage("friends@2x.png"), resourceObjectInstance.getImage("chats@2x.png"), resourceObjectInstance.getImage("send-email@2x.png"), resourceObjectInstance.getImage("settings@2x.png")});
        gui_Tabs.setPropertyValue("selectedIcons", new com.codename1.ui.Image[]{resourceObjectInstance.getImage("friends@2x_sel.png"), resourceObjectInstance.getImage("chats@2x_sel.png"), resourceObjectInstance.getImage("send-email@2x_sel.png"), resourceObjectInstance.getImage("settings@2x_sel.png")});
        gui_Tabs.addTab("Friends" ,gui_friends);
        gui_friends.setScrollableY(true);
        gui_friends.setName("friends");
        gui_friends.addComponent(gui_JessicaButton);
        gui_JessicaButton.setName("JessicaButton");
        gui_JessicaButton.setPropertyValue("line1", "Jessica");
        gui_JessicaButton.setPropertyValue("line2", "14-July-2012");
        gui_JessicaButton.setPropertyValue("line3", "Lorem ipsum is simply the dummy text");
        gui_JessicaButton.setPropertyValue("line4", "some additional dummy text");
        gui_JessicaButton.setPropertyValue("icon", resourceObjectInstance.getImage("avatar-1a.jpg"));
        gui_JessicaButton.setPropertyValue("iconUiid", "Avatar");
        gui_JessicaButton.setPropertyValue("horizontalLayout", true);
        gui_JessicaButton.setPropertyValue("maskName", "maskImage");
        gui_Tabs.addTab("Chats" ,gui_Container);
        gui_Container.setName("Container");
        gui_Container.addComponent(gui_Label1);
        gui_Label1.setText("This tab is intentionally left blank");
        gui_Label1.setName("Label1");
        gui_Tabs.addTab("Email" ,gui_Container2);
        gui_Container2.setName("Container2");
        gui_Container2.addComponent(gui_Label2);
        gui_Label2.setText("So is this one");
        gui_Label2.setName("Label2");
        gui_Tabs.addTab("Settings" ,gui_Container3);
        gui_Container3.setName("Container3");
        gui_Container3.addComponent(gui_Label);
        gui_Container3.addComponent(gui_TextField);
        gui_Container3.addComponent(gui_Button);
        gui_Container3.addComponent(gui_Button1);
        gui_Container3.addComponent(gui_Button2);
        gui_Container3.addComponent(gui_Container4);
        gui_Container4.setName("Container4");
        gui_Container4.addComponent(gui_Button11);
        gui_Container4.addComponent(gui_Button21);
        gui_Button11.setText("Button1");
        gui_Button11.setUIID("GreenButton");
        gui_Button11.setName("Button11");
        gui_Button21.setText("Button2");
        gui_Button21.setUIID("RedButton");
        gui_Button21.setName("Button21");
        gui_Container3.addComponent(gui_Slider);
        gui_Label.setText("Label");
        gui_Label.setName("Label");
        gui_TextField.setText("TextField");
        gui_TextField.setName("TextField");
        gui_Button.setText("Button");
        gui_Button.setName("Button");
        gui_Button1.setText("Button1");
        gui_Button1.setUIID("GreenButton");
        gui_Button1.setName("Button1");
        gui_Button2.setText("Button2");
        gui_Button2.setUIID("RedButton");
        gui_Button2.setName("Button2");
        gui_Container4.setName("Container4");
        gui_Slider.setEditable(true);
        gui_Slider.setText("");
        gui_Slider.setName("Slider");
        gui_friends.setScrollableY(true);
        gui_friends.setName("friends");
        gui_Container.setName("Container");
        gui_Container2.setName("Container2");
        gui_Container3.setName("Container3");
        gui_Tabs.setName("Tabs");
        gui_Tabs.setPropertyValue("titles", new String[]{"Friends", "Chats", "Email", "Settings"});
        gui_Tabs.setPropertyValue("icons", new com.codename1.ui.Image[]{resourceObjectInstance.getImage("friends@2x.png"), resourceObjectInstance.getImage("chats@2x.png"), resourceObjectInstance.getImage("send-email@2x.png"), resourceObjectInstance.getImage("settings@2x.png")});
        gui_Tabs.setPropertyValue("selectedIcons", new com.codename1.ui.Image[]{resourceObjectInstance.getImage("friends@2x_sel.png"), resourceObjectInstance.getImage("chats@2x_sel.png"), resourceObjectInstance.getImage("send-email@2x_sel.png"), resourceObjectInstance.getImage("settings@2x_sel.png")});
    }// </editor-fold>

//-- DON'T EDIT ABOVE THIS LINE!!!

    public void onJessicaButtonActionEvent(com.codename1.ui.events.ActionEvent ev) {
        new Person().show();
    }

}
