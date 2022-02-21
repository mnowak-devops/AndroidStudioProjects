package com.matdev.tam_projekt

import androidx.core.content.ContextCompat.startActivity
import androidx.test.espresso.Espresso
import androidx.test.espresso.action.ViewActions
import androidx.test.espresso.assertion.ViewAssertions
import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.matdev.tam_projekt.View.LoginActivity
import com.matdev.tam_projekt.View.MainActivity
import com.matdev.tam_projekt.View.SzczegolyActivity
import org.hamcrest.CoreMatchers
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith


@RunWith(AndroidJUnit4::class)
class MainActivityTest {
    @get:Rule
    val activityScenarioRule : ActivityScenarioRule<MainActivity> =
        ActivityScenarioRule(MainActivity::class.java)


    @Test
    fun uruchomienie_ekranu_powinno_pokazac_odpowiednie_widoki() {

        Espresso.onView(ViewMatchers.withId(R.id.saldo_total)).check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
        Espresso.onView(ViewMatchers.withId(R.id.saldo)).check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
        Espresso.onView(ViewMatchers.withId(R.id.tablica)).check(ViewAssertions.matches(ViewMatchers.isDisplayed()))

        Espresso.onView(ViewMatchers.withId(R.id.budżet)).check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
        Espresso.onView(ViewMatchers.withId(R.id.wydatki)).check(ViewAssertions.matches(ViewMatchers.isDisplayed()))


        Espresso.onView(ViewMatchers.withId(R.id.widok_tytuł)).check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
        Espresso.onView(ViewMatchers.withId(R.id.widok)).check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
        Espresso.onView(ViewMatchers.withId(R.id.addTransakcjeButton)).check(ViewAssertions.matches(ViewMatchers.isDisplayed()))

    }
    @Test
    fun kliknięcie_przycisku_zmienia_widok() {
        Espresso.onView(ViewMatchers.withId(R.id.addTransakcjeButton)).perform(ViewActions.click())

        Espresso.onView(ViewMatchers.withId(R.id.etykietaLayout))
            .check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
        Espresso.onView(ViewMatchers.withId(R.id.ilośćLayout))
            .check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
        Espresso.onView(ViewMatchers.withId(R.id.opisLayout))
            .check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
        Espresso.onView(ViewMatchers.withId(R.id.dodanieTransakcjiButton))
            .check(ViewAssertions.matches(ViewMatchers.isDisplayed()))

        }
    @Test
    fun prawidlowe_dodanie_transakcji() {
        Espresso.onView(ViewMatchers.withId(R.id.addTransakcjeButton)).perform(ViewActions.click())

        Espresso.onView(ViewMatchers.withId(R.id.labelInput)).perform(ViewActions.typeText("Zakupy Lidl"));
        Espresso.onView(ViewMatchers.withId(R.id.ilośćInput)).perform(ViewActions.typeText("154.28"));
        //onView(withId(R.id.opisInput)).perform(ViewActions.typeText("Zakupy spożywcze do domu"));


        Espresso.onView(ViewMatchers.withId(R.id.dodanieTransakcjiButton))
            .perform(ViewActions.click())


        Espresso.onView(ViewMatchers.withId(R.id.saldo_total)).check(
            ViewAssertions.matches(
                ViewMatchers.isDisplayed()))
        Espresso.onView(ViewMatchers.withId(R.id.saldo)).check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
        Espresso.onView(ViewMatchers.withId(R.id.tablica)).check(ViewAssertions.matches(ViewMatchers.isDisplayed()))

        Espresso.onView(ViewMatchers.withId(R.id.budżet)).check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
        Espresso.onView(ViewMatchers.withId(R.id.wydatki)).check(ViewAssertions.matches(ViewMatchers.isDisplayed()))


        Espresso.onView(ViewMatchers.withId(R.id.widok_tytuł)).check(
            ViewAssertions.matches(
                ViewMatchers.isDisplayed()))
        Espresso.onView(ViewMatchers.withId(R.id.widok)).check(ViewAssertions.matches(ViewMatchers.isDisplayed()))


    }
    @Test
    fun klikniecie_w_krzyrzyk_wraca_do_głownego_widoku() {

        Espresso.onView(ViewMatchers.withId(R.id.addTransakcjeButton)).perform(ViewActions.click())
        Espresso.onView(ViewMatchers.withId(R.id.closeButton))
            .perform(ViewActions.click())
        Espresso.onView(ViewMatchers.withId(R.id.saldo_total)).check(
            ViewAssertions.matches(
                ViewMatchers.isDisplayed()))
        Espresso.onView(ViewMatchers.withId(R.id.saldo)).check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
        Espresso.onView(ViewMatchers.withId(R.id.tablica)).check(ViewAssertions.matches(ViewMatchers.isDisplayed()))

        Espresso.onView(ViewMatchers.withId(R.id.budżet)).check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
        Espresso.onView(ViewMatchers.withId(R.id.wydatki)).check(ViewAssertions.matches(ViewMatchers.isDisplayed()))


        Espresso.onView(ViewMatchers.withId(R.id.widok_tytuł)).check(
            ViewAssertions.matches(
                ViewMatchers.isDisplayed()))
        Espresso.onView(ViewMatchers.withId(R.id.widok)).check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
    }

}