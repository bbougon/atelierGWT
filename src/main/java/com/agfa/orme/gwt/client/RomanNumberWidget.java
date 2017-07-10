package com.agfa.orme.gwt.client;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ChangeEvent;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.resources.client.CssResource;
import com.google.gwt.uibinder.client.*;
import com.google.gwt.user.client.ui.*;


public class RomanNumberWidget extends Composite {

    @UiField
    TextBox arabNumberInput;
    @UiField
    Button arabNumberButton;
    @UiField
    FlowPanel result;
    @UiField
    InlineLabel resultMessage;
    @UiField
    RomanNumberStyle style;
    @UiField
    FlowPanel romanNumberForm;

    private static RomanNumberWidgetUiBinder ourUiBinder = GWT.create(RomanNumberWidgetUiBinder.class);

    interface RomanNumberWidgetUiBinder extends UiBinder<Widget, RomanNumberWidget> {

    }

    interface RomanNumberStyle extends CssResource {

        String alert();

        @ClassName("alert-success")
        String alertSuccess();

        @ClassName("alert-danger")
        String alertDanger();

        String row();

        String padding();

        @ClassName("form-control")
        String formControl();

        @ClassName("btn-default")
        String btnDefault();

        String btn();
    }

    public RomanNumberWidget() {
        initWidget(ourUiBinder.createAndBindUi(this));
    }

    @UiHandler("arabNumberButton")
    public void arabNumberButtonClick(final ClickEvent event) {
    }

    @UiHandler("arabNumberInput")
    public void arabNumberInputChange(final ChangeEvent event) {
    }

}