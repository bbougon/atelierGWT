package com.agfa.orme.gwt.rules;

import com.google.gwt.user.client.ui.LayoutPanel;
import com.google.gwt.user.client.ui.RootPanel;
import org.junit.rules.ExternalResource;

public class WithRootContainer extends ExternalResource {

    public WithRootContainer(final String containerName) {
        LayoutPanel layoutPanel = new LayoutPanel();
        layoutPanel.getElement().setAttribute("id", containerName);
        RootPanel.get().add(layoutPanel);
    }

}
