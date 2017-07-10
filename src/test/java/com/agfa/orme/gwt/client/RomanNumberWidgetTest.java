package com.agfa.orme.gwt.client;

import com.agfa.orme.gwt.rules.WithAsyncServices;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.googlecode.gwt.test.GwtModule;
import com.googlecode.gwt.test.GwtTestWithMockito;
import com.googlecode.gwt.test.utils.events.Browser;
import org.junit.Rule;
import org.junit.Test;
import org.mockito.Mockito;

import static com.googlecode.gwt.test.assertions.GwtAssertions.assertThat;
import static org.mockito.Matchers.any;
import static org.mockito.Matchers.eq;

@GwtModule("com.agfa.orme.gwt.AtelierGwt")
public class RomanNumberWidgetTest extends GwtTestWithMockito {

    @Rule
    public WithAsyncServices withAsyncServices = new WithAsyncServices();

    @Test
    public void widgetIsLoaded() {
        RomanNumberWidget romanNumberWidget = new RomanNumberWidget();

        assertThat(romanNumberWidget.romanNumberForm).hasStyle(romanNumberWidget.style.row());
    }

    @Test
    public void arabNumberFilledIsANumber() {
        RomanNumberWidget romanNumberWidget = new RomanNumberWidget();
        romanNumberWidget.arabNumberInput.setText("ABCD");

        Browser.change(romanNumberWidget.arabNumberInput);

        assertThat(romanNumberWidget.result).isVisible();
        assertThat(romanNumberWidget.resultMessage).textEquals("ABCD n'est pas un nombre, veuillez saisir un nombre.");
        assertThat(romanNumberWidget.result).hasStyle(romanNumberWidget.style.alert(), romanNumberWidget.style.alertDanger());
        assertThat(romanNumberWidget.result).doesNotHaveStyle(romanNumberWidget.style.alertSuccess());
    }

    @Test
    public void onArabNumberButtonClickRomanNumberIsReceived() {
        RomanNumberWidget romanNumberWidget = new RomanNumberWidget();
        romanNumberWidget.arabNumberInput.setText("2");
        doSuccessCallback("II").when(AsyncServices.get().getRomanNumberService()).getRomanNumber(eq(2), any(AsyncCallback.class));

        Browser.click(romanNumberWidget.arabNumberButton);

        assertThat(romanNumberWidget.result).isVisible();
        assertThat(romanNumberWidget.resultMessage).textEquals("Roman number is: II");
        assertThat(romanNumberWidget.result).hasStyle(romanNumberWidget.style.alert(), romanNumberWidget.style.alertSuccess());
        assertThat(romanNumberWidget.result).doesNotHaveStyle(romanNumberWidget.style.alertDanger());
    }

    @Test
    public void onArabNumberButtonClickNumberInputIsCheckedWhenNotANumber() {
        RomanNumberWidget romanNumberWidget = new RomanNumberWidget();
        romanNumberWidget.arabNumberInput.setText("test");

        Browser.click(romanNumberWidget.arabNumberButton);

        Mockito.verifyZeroInteractions(AsyncServices.get().getRomanNumberService());
        assertThat(romanNumberWidget.result).isVisible();
        assertThat(romanNumberWidget.resultMessage).textEquals("test n'est pas un nombre, veuillez saisir un nombre.");
        assertThat(romanNumberWidget.result).hasStyle(romanNumberWidget.style.alert(), romanNumberWidget.style.alertDanger());
        assertThat(romanNumberWidget.result).doesNotHaveStyle(romanNumberWidget.style.alertSuccess());
    }

    @Test
    public void onArabNumberButtonClickFailureIsHandled() {
        RomanNumberWidget romanNumberWidget = new RomanNumberWidget();
        romanNumberWidget.arabNumberInput.setText("5000");
        doFailureCallback(new RuntimeException("Le chiffre arabe '5000' ne peut pas être transcrit en chiffre romain")).when(AsyncServices.get().getRomanNumberService()).getRomanNumber(eq(5000), any(AsyncCallback.class));

        Browser.click(romanNumberWidget.arabNumberButton);

        assertThat(romanNumberWidget.result).isVisible();
        assertThat(romanNumberWidget.resultMessage).textEquals("Le chiffre arabe '5000' ne peut pas être transcrit en chiffre romain");
        assertThat(romanNumberWidget.result).hasStyle(romanNumberWidget.style.alert(), romanNumberWidget.style.alertDanger());
        assertThat(romanNumberWidget.result).doesNotHaveStyle(romanNumberWidget.style.alertSuccess());
    }
}