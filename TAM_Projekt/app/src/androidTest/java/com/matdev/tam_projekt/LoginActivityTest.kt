package com.matdev.tam_projekt

import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.matdev.tam_projekt.View.LoginActivity
import org.hamcrest.CoreMatchers.not
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

/*
Testy funkcjonalne testują faktyczny ekran, na którym można wykonać jakieśkolwiek akcje z poziomu
UI. Czyli zupełnie jakbyśmy sami klikali po ekranie, ale tutaj robi się to automatycznie, za nas.
Każdą testowaną klasę musimy z góry oznakować w sposób @RunWith()
 */
@RunWith(AndroidJUnit4::class)
class LoginActivityTest {

    /*
    Z racji, że testujemy aktywności (Activity), musimy umieścić tę "zasadę" poniżej. W skrócie jest
    to pomocnicza metoda tworząca za nas, dla każdego testu (@Test), aktywność, przez co nic nie
    musimy robić. Schemat jest jak widać, wystarczy w miejsce LoginActivity wstawić odpowiednie
    Activity które chcemy przetestować.
     */
    @get:Rule
    val activityScenarioRule : ActivityScenarioRule<LoginActivity> =
        ActivityScenarioRule(LoginActivity::class.java)

    /*
    Przykładowy @Test. Ogólnie w testach funkcjonalnych możemy sprawdzać aktualny stan widoków,
    lub wykonywać na nich akcje (klik, pisanie, przewijanie, itp). Po czym ponownie możemy sprawdzić
    stan widoków. Itd.
    W tym przypadku sprawdzamy po prostu po uruchomieniu LoginActivity, czy wszystkie widoki, które
    zadeklarowaliśmy w layoucie (activity_login.xml) są zgodne z oczekiwanym stanem po uruchomieniu
    tego ekranu.
     */
    @Test
    fun uruchomienie_ekranu_powinno_pokazac_odpowiednie_widoki() {
        /*
        objaśnienie metod:
        onView() - dla widoku
        withId() - o konkretnym id
        check() - sprawdź
        matches() - czy zgadza się
        isDisplayed() - że widok wyświetla się na ekranie
         */
        onView(withId(R.id.loginLayout)).check(matches(isDisplayed()))
        onView(withId(R.id.hasloLayout)).check(matches(isDisplayed()))
        onView(withId(R.id.loginMe)).check(matches(isDisplayed()))
        /*
        Tutaj jest dodatkowa metoda: not(), a konkretnie not(isDisplayed()) - not po prostu
        zaprzecza to co jest w środku, czyli tutaj: "że widok NIE wyświetla się".
        (no bo domyślnie na tym ekranie progressbar nie powinien się wyświetlić dopóki nie klikniemy
        w przycisk.
         */
        onView(withId(R.id.progressbar)).check(matches(not(isDisplayed())))
    }

    @Test
    fun klikniecie_w_przycisk_bez_danych_powinno_pokazac_progress_oraz_blad() {
        /*
        Objaśnienie metod:
        perform() - wykonaj akcję
        click() - akcja: kliknięcie w dany widok (określony wcześniej, przez onView(withId()))
         */
        onView(withId(R.id.loginMe)).perform(click())
        onView(withId(R.id.progressbar)).check(matches(isDisplayed()))
        /*
        Ta metoda usypia test na 2000 milisekund. Czemu tak? obecnie w kodzie jest logika, że po
        wciśnięciu przycisku czekamy 2 sekundy zanim wykonamy akcję. Test o tym nie wie, więc
        trzeba mu sztucznie wymusić odczekanie tego samego czasu, stąd ta metoda.
         */
        Thread.sleep(2000)
        /*
        Kolejna dodatkowa metoda:
        hasErrorText() - sprawdzamy czy wyświetla się tekst z błędem dla danego inputa.
         */
        onView(withId(R.id.loginInput)).check(matches(hasErrorText("Username can't be empty!")))
    }
}