package com.codename1.demos.socialboo.gui;

import com.codename1.components.MultiButton;
import com.codename1.components.ToastBar;
import com.codename1.demos.socialboo.SocialBoo;
import com.codename1.ui.Command;
import com.codename1.ui.Container;
import com.codename1.ui.Dialog;
import com.codename1.ui.Display;
import com.codename1.ui.Form;
import com.codename1.ui.animations.CommonTransitions;
import com.codename1.ui.events.ActionEvent;
import com.codename1.ui.events.ActionListener;
import com.codename1.ui.layouts.BorderLayout;
import com.codename1.ui.layouts.BoxLayout;
import com.codename1.ui.util.Resources;

/**
 * GUI builder created Form
 */
public class Person extends com.codename1.ui.Form {
    private boolean dialogShowing;
    private static final String[] C_NAMES = {
        "Jessica White",
        "Beatrice Black",
        "John Bono",
        "Beier Mark"
    };
    private static final String[] C_DATE = {
        "14-Jun-2012",
        "12-May-2012",
        "11-Aug-2011",
        "10-Apr-2010"
    };
    
    private static final String[] C_LINE1 = {
        "Lorem ipsm bla bla",
        "Lorem ipsm bla bla",
        "Lorem ipsm bla bla",
        "Lorem ipsm bla bla"
    };
    
    private static final String[] C_LINE2 = {
        "Some more lorem ipsm",
        "Some more lorem ipsm",
        "Some more lorem ipsm",
        "Some more lorem ipsm"
    };
    
    private static final String[] C_AVATAR = {
        "avatar-1a.jpg",
        "avatar-2a.jpg",
        "avatar-3a.jpg",
        "avatar-4a.jpg"
    };

    private static final String[] C_AVATAR_LARGE = {
        "avatar-1b.jpg",
        "avatar-2b.jpg",
        "avatar-3b.jpg",
        "avatar-4b.jpg"
    };

    
    public Person() {
        this(com.codename1.ui.util.Resources.getGlobalResources());
    }
    
    // adds constant people to the given container
    private void addPeople(final Resources r, Container c) {
        c.removeAll();
        for(int iter = 0 ; iter < C_NAMES.length ; iter++) {
            MultiButton mb = new MultiButton();
            mb.setEmblem(null);
            mb.setHorizontalLayout(true);
            mb.setTextLine1(C_NAMES[iter]);
            mb.setTextLine2(C_DATE[iter]);
            mb.setTextLine3(C_LINE1[iter]);
            mb.setTextLine4(C_LINE2[iter]);
            mb.setMaskName("maskImage");
            mb.setIconUIID("Avatar");
            mb.setIcon(r.getImage(C_AVATAR[iter]));
            final int selectedOffset = iter;
            mb.setCommand(new Command("") {
                public void actionPerformed(ActionEvent ev) {
                    gui_avatar.setIcon(r.getImage(C_AVATAR_LARGE[selectedOffset]));
                    gui_personName.setText(C_NAMES[selectedOffset]);                    
                }
            });
            c.addComponent(mb);
        }
    }
    
    public Person(com.codename1.ui.util.Resources resourceObjectInstance) {
        initGuiBuilderComponents(resourceObjectInstance);
        getToolbar().setTitleCentered(true);
        SocialBoo.addToggleCommand(getToolbar());
        if(SocialBoo.isTabletMode()) {
            setTransitionOutAnimator(CommonTransitions.createEmpty());
            Container listOfFriends = new Container(new BoxLayout(BoxLayout.Y_AXIS));
            listOfFriends.setHideInPortrait(true);
            addPeople(resourceObjectInstance, listOfFriends);
            add(BorderLayout.WEST, listOfFriends);
            listOfFriends.setScrollableY(true);
            final Command peopleCommand = new Command("People") {
                public void actionPerformed(ActionEvent ev) {
                    Dialog dlg = new Dialog("People");
                    dlg.setDialogUIID("Container");
                    dlg.getContentPane().setUIID("Form");
                    dlg.getTitleComponent().setUIID("TitleArea");
                    dlg.setLayout(new BoxLayout(BoxLayout.Y_AXIS));
                    dlg.setTransitionInAnimator(CommonTransitions.createSlide(CommonTransitions.SLIDE_HORIZONTAL, false, 250));
                    dlg.setTransitionOutAnimator(CommonTransitions.createSlide(CommonTransitions.SLIDE_HORIZONTAL, true, 250));
                    addPeople(resourceObjectInstance, dlg);
                    dlg.setDisposeWhenPointerOutOfBounds(true);
                    dialogShowing = true;
                    dlg.showStetched(BorderLayout.WEST, true);
                    dialogShowing = false;
                }
            };
            if(Display.getInstance().isPortrait()) {
                getToolbar().addCommandToLeftBar(peopleCommand);
            }
            addOrientationListener(new ActionListener() {
                public void actionPerformed(ActionEvent evt) {
                    if(dialogShowing) {
                        Form f = Display.getInstance().getCurrent();
                        if(f instanceof Dialog) {
                            ((Dialog)f).dispose();
                        }
                    }
                    if(Display.getInstance().isPortrait()) {
                        getToolbar().addCommandToLeftBar(peopleCommand);
                    } else {
                        removeAllCommands();
                        SocialBoo.addToggleCommand(getToolbar());
                        revalidate();
                    }
                }
            });
        } else {
            Form previous = Display.getInstance().getCurrent();
            getToolbar().setBackCommand("Back", e -> previous.showBack());
        }
    }

//-- DON'T EDIT BELOW THIS LINE!!!
    private com.codename1.ui.Container gui_personRootPanel = new com.codename1.ui.Container(new com.codename1.ui.layouts.BoxLayout(com.codename1.ui.layouts.BoxLayout.Y_AXIS));
    private com.codename1.ui.Container gui_Container = new com.codename1.ui.Container(new com.codename1.ui.layouts.BorderLayout());
    private com.codename1.ui.Container gui_Container9 = new com.codename1.ui.Container();
    private com.codename1.ui.Label gui_avatar = new com.codename1.ui.Label();
    private com.codename1.ui.Container gui_Container1 = new com.codename1.ui.Container(new com.codename1.ui.layouts.BoxLayout(com.codename1.ui.layouts.BoxLayout.Y_AXIS));
    private com.codename1.ui.Label gui_personName = new com.codename1.ui.Label();
    private com.codename1.ui.Label gui_Label1 = new com.codename1.ui.Label();
    private com.codename1.ui.Container gui_Container2 = new com.codename1.ui.Container();
    private com.codename1.ui.Container gui_Container3 = new com.codename1.ui.Container(new com.codename1.ui.layouts.GridLayout(1, 3));
    private com.codename1.ui.Container gui_Container6 = new com.codename1.ui.Container(new com.codename1.ui.layouts.BoxLayout(com.codename1.ui.layouts.BoxLayout.Y_AXIS));
    private com.codename1.ui.Label gui_Label3 = new com.codename1.ui.Label();
    private com.codename1.ui.Label gui_Label2 = new com.codename1.ui.Label();
    private com.codename1.ui.Container gui_Container5 = new com.codename1.ui.Container(new com.codename1.ui.layouts.BoxLayout(com.codename1.ui.layouts.BoxLayout.Y_AXIS));
    private com.codename1.ui.Label gui_Label5 = new com.codename1.ui.Label();
    private com.codename1.ui.Label gui_Label4 = new com.codename1.ui.Label();
    private com.codename1.ui.Container gui_Container4 = new com.codename1.ui.Container(new com.codename1.ui.layouts.BoxLayout(com.codename1.ui.layouts.BoxLayout.Y_AXIS));
    private com.codename1.ui.Label gui_Label7 = new com.codename1.ui.Label();
    private com.codename1.ui.Label gui_Label6 = new com.codename1.ui.Label();
    private com.codename1.ui.Container gui_Container7 = new com.codename1.ui.Container(new com.codename1.ui.table.TableLayout(9, 2));
    private com.codename1.ui.Label gui_Label8 = new com.codename1.ui.Label();
    private com.codename1.ui.Label gui_Label9 = new com.codename1.ui.Label();
    private com.codename1.ui.Label gui_Label11 = new com.codename1.ui.Label();
    private com.codename1.ui.Label gui_Label10 = new com.codename1.ui.Label();
    private com.codename1.ui.TextArea gui_TextArea = new com.codename1.ui.TextArea();
    private com.codename1.ui.Label gui_Label111 = new com.codename1.ui.Label();
    private com.codename1.ui.Label gui_Label12 = new com.codename1.ui.Label();
    private com.codename1.ui.Button gui_Button = new com.codename1.ui.Button();
    private com.codename1.ui.Label gui_Label1111 = new com.codename1.ui.Label();
    private com.codename1.ui.Label gui_Label14 = new com.codename1.ui.Label();
    private com.codename1.ui.Container gui_Container8 = new com.codename1.ui.Container(new com.codename1.ui.layouts.BoxLayout(com.codename1.ui.layouts.BoxLayout.X_AXIS));
    private com.codename1.ui.Label gui_Label15 = new com.codename1.ui.Label();
    private com.codename1.ui.Label gui_Label16 = new com.codename1.ui.Label();
    private com.codename1.ui.Label gui_Label17 = new com.codename1.ui.Label();


// <editor-fold defaultstate="collapsed" desc="Generated Code">                          
    private void guiBuilderBindComponentListeners() {
        EventCallbackClass callback = new EventCallbackClass();
        gui_TextArea.addActionListener(callback);
        gui_Button.addActionListener(callback);
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

            if(sourceComponent == gui_TextArea) {
                onTextAreaActionEvent(ev);
            }
            if(sourceComponent == gui_Button) {
                onButtonActionEvent(ev);
            }
        }

        public void dataChanged(int type, int index) {
        }
    }
    private void initGuiBuilderComponents(com.codename1.ui.util.Resources resourceObjectInstance) {
        guiBuilderBindComponentListeners();
        setLayout(new com.codename1.ui.layouts.BorderLayout());
        setScrollableY(false);
        setTitle("Name");
        setName("Person");
        addComponent(com.codename1.ui.layouts.BorderLayout.CENTER, gui_personRootPanel);
        gui_personRootPanel.setScrollableY(true);
        gui_personRootPanel.setUIID("PersonPanel");
        gui_personRootPanel.setName("personRootPanel");
        gui_personRootPanel.addComponent(gui_Container);
        gui_Container.setUIID("DataSheet");
        gui_Container.setName("Container");
        gui_Container.addComponent(com.codename1.ui.layouts.BorderLayout.WEST, gui_Container9);
        gui_Container9.setName("Container9");
        gui_Container9.addComponent(gui_avatar);
        gui_avatar.setText("");
        gui_avatar.setUIID("Avatar");
        gui_avatar.setName("avatar");
        gui_avatar.setIcon(resourceObjectInstance.getImage("avatar-1b.jpg"));
        gui_avatar.setPropertyValue("maskName", "largeMaskImage");
        gui_Container.addComponent(com.codename1.ui.layouts.BorderLayout.CENTER, gui_Container1);
        gui_Container1.setName("Container1");
        gui_Container1.addComponent(gui_personName);
        gui_Container1.addComponent(gui_Label1);
        gui_Container1.addComponent(gui_Container2);
        gui_Container2.setName("Container2");
        gui_Container2.addComponent(gui_Container3);
        gui_Container3.setName("Container3");
        gui_Container3.addComponent(gui_Container6);
        gui_Container6.setUIID("Followers");
        gui_Container6.setName("Container6");
        gui_Container6.addComponent(gui_Label3);
        gui_Container6.addComponent(gui_Label2);
        gui_Label3.setText("10");
        gui_Label3.setUIID("FollowTitle");
        gui_Label3.setName("Label3");
        gui_Label2.setText("followers");
        gui_Label2.setUIID("FollowText");
        gui_Label2.setName("Label2");
        gui_Container3.addComponent(gui_Container5);
        gui_Container5.setUIID("Following");
        gui_Container5.setName("Container5");
        gui_Container5.addComponent(gui_Label5);
        gui_Container5.addComponent(gui_Label4);
        gui_Label5.setText("35");
        gui_Label5.setUIID("FollowTitle");
        gui_Label5.setName("Label5");
        gui_Label4.setText("following");
        gui_Label4.setUIID("FollowText");
        gui_Label4.setName("Label4");
        gui_Container3.addComponent(gui_Container4);
        gui_Container4.setUIID("Updates");
        gui_Container4.setName("Container4");
        gui_Container4.addComponent(gui_Label7);
        gui_Container4.addComponent(gui_Label6);
        gui_Label7.setText("400");
        gui_Label7.setUIID("FollowTitle");
        gui_Label7.setName("Label7");
        gui_Label6.setText("updates");
        gui_Label6.setUIID("FollowText");
        gui_Label6.setName("Label6");
        gui_Container6.setUIID("Followers");
        gui_Container6.setName("Container6");
        gui_Container5.setUIID("Following");
        gui_Container5.setName("Container5");
        gui_Container4.setUIID("Updates");
        gui_Container4.setName("Container4");
        gui_Container3.setName("Container3");
        gui_personName.setText("Jessica White");
        gui_personName.setName("personName");
        gui_Label1.setText("San Antonio, Texas");
        gui_Label1.setUIID("GrayLabel");
        gui_Label1.setName("Label1");
        gui_Label1.setIcon(resourceObjectInstance.getImage("location@2x.png"));
        gui_Container2.setName("Container2");
        gui_Container9.setName("Container9");
        gui_Container1.setName("Container1");
        gui_personRootPanel.addComponent(gui_Container7);
        gui_Container7.setName("Container7");
        com.codename1.ui.table.TableLayout.Constraint Label8Constraint = ((com.codename1.ui.table.TableLayout)gui_Container7.getLayout()).createConstraint(-1, -1);
        Label8Constraint.setWidthPercentage(38);
        gui_Container7.addComponent(Label8Constraint, gui_Label8);
        com.codename1.ui.table.TableLayout.Constraint Label9Constraint = ((com.codename1.ui.table.TableLayout)gui_Container7.getLayout()).createConstraint(-1, -1);
        Label9Constraint.setWidthPercentage(62);
        gui_Container7.addComponent(Label9Constraint, gui_Label9);
        com.codename1.ui.table.TableLayout.Constraint Label11Constraint = ((com.codename1.ui.table.TableLayout)gui_Container7.getLayout()).createConstraint(-1, -1);
        Label11Constraint.setHorizontalSpan(2);
        gui_Container7.addComponent(Label11Constraint, gui_Label11);
        com.codename1.ui.table.TableLayout.Constraint Label10Constraint = ((com.codename1.ui.table.TableLayout)gui_Container7.getLayout()).createConstraint(-1, -1);
        gui_Container7.addComponent(Label10Constraint, gui_Label10);
        gui_Container7.addComponent(gui_TextArea);
        com.codename1.ui.table.TableLayout.Constraint Label111Constraint = ((com.codename1.ui.table.TableLayout)gui_Container7.getLayout()).createConstraint(-1, -1);
        Label111Constraint.setHorizontalSpan(2);
        gui_Container7.addComponent(Label111Constraint, gui_Label111);
        gui_Container7.addComponent(gui_Label12);
        gui_Container7.addComponent(gui_Button);
        com.codename1.ui.table.TableLayout.Constraint Label1111Constraint = ((com.codename1.ui.table.TableLayout)gui_Container7.getLayout()).createConstraint(-1, -1);
        Label1111Constraint.setHorizontalSpan(2);
        gui_Container7.addComponent(Label1111Constraint, gui_Label1111);
        gui_Container7.addComponent(gui_Label14);
        gui_Container7.addComponent(gui_Container8);
        gui_Container8.setName("Container8");
        gui_Container8.addComponent(gui_Label15);
        gui_Container8.addComponent(gui_Label16);
        gui_Container8.addComponent(gui_Label17);
        gui_Label15.setText("");
        gui_Label15.setUIID("Avatar");
        gui_Label15.setName("Label15");
        gui_Label15.setIcon(resourceObjectInstance.getImage("avatar-2a.jpg"));
        gui_Label15.setPropertyValue("maskName", "maskImage");
        gui_Label16.setText("");
        gui_Label16.setUIID("Avatar");
        gui_Label16.setName("Label16");
        gui_Label16.setIcon(resourceObjectInstance.getImage("avatar-3a.jpg"));
        gui_Label16.setPropertyValue("maskName", "maskImage");
        gui_Label17.setText("");
        gui_Label17.setUIID("Avatar");
        gui_Label17.setName("Label17");
        gui_Label17.setIcon(resourceObjectInstance.getImage("avatar-4a.jpg"));
        gui_Label17.setPropertyValue("maskName", "maskImage");
        gui_Label8.setText("Joined");
        gui_Label8.setUIID("TableTitleLabel");
        gui_Label8.setName("Label8");
        gui_Label9.setText("2 years ago");
        gui_Label9.setUIID("TableValueLabel");
        gui_Label9.setName("Label9");
        gui_Label11.setText(" ");
        gui_Label11.setUIID("Line");
        gui_Label11.setName("Label11");
        gui_Label10.setText("Bio");
        gui_Label10.setUIID("TableTitleLabel");
        gui_Label10.setName("Label10");
        gui_TextArea.setEditable(false);
        gui_TextArea.setText("Released two albums about to release another one");
        gui_TextArea.setUIID("TableValueLabel");
        gui_TextArea.setName("TextArea");
        gui_Label111.setText(" ");
        gui_Label111.setUIID("Line");
        gui_Label111.setName("Label111");
        gui_Label12.setText("Web");
        gui_Label12.setUIID("TableTitleLabel");
        gui_Label12.setName("Label12");
        gui_Button.setText("http://www.codenameone.com/");
        gui_Button.setUIID("Link");
        gui_Button.setName("Button");
        gui_Label1111.setText(" ");
        gui_Label1111.setUIID("Line");
        gui_Label1111.setName("Label1111");
        gui_Label14.setText("Friends");
        gui_Label14.setUIID("TableTitleLabel");
        gui_Label14.setName("Label14");
        gui_Container8.setName("Container8");
        gui_Container.setUIID("DataSheet");
        gui_Container.setName("Container");
        gui_Container7.setName("Container7");
        gui_personRootPanel.setScrollableY(true);
        gui_personRootPanel.setUIID("PersonPanel");
        gui_personRootPanel.setName("personRootPanel");
    }// </editor-fold>

//-- DON'T EDIT ABOVE THIS LINE!!!

    public void onTextAreaActionEvent(com.codename1.ui.events.ActionEvent ev) {
    }


    public void onButtonActionEvent(com.codename1.ui.events.ActionEvent ev) {
    }

}
