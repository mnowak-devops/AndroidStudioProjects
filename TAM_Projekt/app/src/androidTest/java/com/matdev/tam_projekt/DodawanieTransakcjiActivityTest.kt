package com.matdev.tam_projekt

import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.matdev.tam_projekt.View.DodawanieTransakcjiActivity
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith


@RunWith(AndroidJUnit4::class)
class DodawanieTransakcjiActivityTest {


    @get:Rule
    val activityScenarioRule : ActivityScenarioRule<DodawanieTransakcjiActivity> =
        ActivityScenarioRule(DodawanieTransakcjiActivity::class.java)


    @Test
    fun uruchomienie_ekranu_powinno_pokazac_odpowiednie_widoki() {

        onView(withId(R.id.etykietaLayout)).check(matches(isDisplayed()))
        onView(withId(R.id.ilośćLayout)).check(matches(isDisplayed()))
        onView(withId(R.id.opisLayout)).check(matches(isDisplayed()))
        onView(withId(R.id.dodanieTransakcjiButton)).check(matches(isDisplayed()))

    }

    @Test
    fun klikniecie_w_przycisk_bez_danych_powinno_pokazac_blad() {

        onView(withId(R.id.dodanieTransakcjiButton)).perform(click())

        onView(withId(R.id.etykietaLayout)).check(matches(hasErrorText("Proszę podać prawidłową etykiete transakcji!")))
        onView(withId(R.id.loginInput)).check(matches(hasErrorText("Prosze podać poprawną wartość transakcji!")))
    }
}