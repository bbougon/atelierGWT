package com.agfa.orme.gwt.client;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ChangeEvent;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.resources.client.CssResource;
import com.google.gwt.uibinder.client.*;
import com.google.gwt.user.client.rpc.AsyncCallback;
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
        Integer arabNumber = checkIntegerValue(arabNumberInput.getText());
        callRomanNumberService(arabNumber);
    }

    @UiHandler("arabNumberInput")
    public void arabNumberInputChange(final ChangeEvent event) {
        String arabNumberValue = arabNumberInput.getText();
        checkIntegerValue(arabNumberValue);
    }

    private void callRomanNumberService(final Integer arabNumber) {
        if(arabNumber != null) {
            AsyncServices.get().getRomanNumberService().getRomanNumber(arabNumber, new AsyncCallback<String>() {

                public void onFailure(final Throwable caught) {
                    String message = caught.getMessage();
                    applyResult(message, style.alertDanger(), style.alertSuccess());
                }

                public void onSuccess(final String result) {
                    applyResult("Roman number is: " + result, style.alertSuccess(), style.alertDanger());
                }
            });
        }
    }

    private void applyResult(final String message, final String styleToAdd, final String styleToRemove) {
        result.setVisible(true);
        result.removeStyleName(styleToRemove);
        result.addStyleName(styleToAdd);
        resultMessage.setText(message);
    }

    private Integer checkIntegerValue(final String integerValue) {
        try {
            return Integer.valueOf(integerValue);
        } catch (NumberFormatException e) {
            applyResult(integerValue + " n'est pas un nombre, veuillez saisir un nombre.", style.alertDanger(), style.alertSuccess());
        }
        return null;
    }

}