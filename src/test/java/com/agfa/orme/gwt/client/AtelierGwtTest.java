package com.agfa.orme.gwt.client;


import com.agfa.orme.gwt.rules.WithRootContainer;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.Widget;
import com.googlecode.gwt.test.GwtModule;
import com.googlecode.gwt.test.GwtTest;
import org.junit.Rule;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

@GwtModule("com.agfa.orme.gwt.AtelierGwt")
public class AtelierGwtTest extends GwtTest {

    @Rule
    public WithRootContainer withRootContainer = new WithRootContainer(AtelierGwt.CONTAINER_NAME);

    @Test
    public void romanNumberWidgetIsLoaded() {
        AtelierGwt atelierGwt = new AtelierGwt();

        atelierGwt.onModuleLoad();

        Widget widget = RootPanel.get(AtelierGwt.CONTAINER_NAME).getWidget(0);
        assertThat(widget).isInstanceOf(RomanNumberWidget.class);
    }
}